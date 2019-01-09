package citygenerator.controllers;

import citygenerator.model.DataLayer.BussinesLogic.namegenerator.CityName;
import citygenerator.model.DataLayer.BussinesLogic.namegenerator.NameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping(path="/citynamegenerator")
public class CityNameGeneratorController {

    private AtomicLong seed = new AtomicLong(0);
    private NameGenerator generator = new CityName(seed);

    @GetMapping(path="/getname")
    public @ResponseBody String getGeneratedName() {
        return generator.getName();
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
