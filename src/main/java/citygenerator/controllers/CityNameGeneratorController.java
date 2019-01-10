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
    private AtomicInteger order = new AtomicInteger(8);
    private NameGenerator generator;
    Stack<String> data = new Stack<>();

    @GetMapping(path="/getname")
    public @ResponseBody String getGeneratedName() {
        if(data.size() == 0) {
            ArrayList<CityNames> result = Lists.newArrayList(namesRepository.findAll());
            for(CityNames city : result) {
                data.add(city.getName());
            }
        }
        if(data.size() > 0) {
            generator = new CityName(data, this.order.get(), this.prior.get(), this.seed);
            return generator.getName();
        } else {
            return "ERROR. Couldn't fetch recrods.";
        }
    }

    @GetMapping(path="/setseed")
    public @ResponseBody String setSeed(@RequestParam Long seed) {
        this.seed = new AtomicLong(seed);
        return "Random seed was changed to: " + this.seed.toString();
    }

    @GetMapping(path="/getnames")
    public @ResponseBody List<String> generateMultipleNames(@RequestParam Integer count) {
        return generator.getNames(count);
    }

}
