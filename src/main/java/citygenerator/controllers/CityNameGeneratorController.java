package citygenerator.controllers;

import citygenerator.model.DataLayer.BussinesLogic.namegenerator.CityName;
import citygenerator.model.DataLayer.BussinesLogic.namegenerator.NameGenerator;
import citygenerator.model.DataLayer.Entities.CityNames;
import citygenerator.model.DataLayer.Repositories.CityNamesRepo;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping(path="/citynamegenerator")
public class CityNameGeneratorController {

    @Autowired
    private CityNamesRepo namesRepository;
    
    private AtomicLong seed = new AtomicLong(0);
    private AtomicDouble prior = new AtomicDouble(0);
    private AtomicInteger order = new AtomicInteger(10);
    private NameGenerator generator;
    Stack<String> data = new Stack<>();

    private void fillDataStack() {
        ArrayList<CityNames> result = Lists.newArrayList(namesRepository.findAll());
        for(CityNames city : result) {
            data.add(city.getName());
        }
    }

    private void getGeneratorInstance(){
        if(this.generator == null) {
            fillDataStack();
            generator = new CityName(this.data, this.order.get(), this.prior.get(), this.seed);
        }
    }

    @GetMapping(path="/getname")
    public @ResponseBody String getGeneratedName
            (@RequestParam(required=false, defaultValue="20") Integer order,
             @RequestParam(required=false, defaultValue="0.0") Double prior,
             @RequestParam(required=false, defaultValue="6692049294298592859")
                     Long seed) {
        String name;
        this.seed.set(seed);
        this.order.set(order);
        this.prior.set(prior);

        if(this.data.size() == 0) {
            this.getGeneratorInstance();
            name = this.generator.getName();
        }
        else if(data.size() != 0) {
            name = this.generator.getName();
        }
        else {
            name = "Error. Couldn't fetch name.";
        }
        return name;
    }

    @GetMapping(path="/cleardata")
    public @ResponseBody String clearData() {
        this.data.clear();
        return "Done.";
    }

    @GetMapping(path="/getnames")
    public @ResponseBody List<String> generateMultipleNames(@RequestParam Integer count) {
        return generator.getNames(count);
    }

}
