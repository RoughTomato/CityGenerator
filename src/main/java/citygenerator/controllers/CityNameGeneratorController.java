package citygenerator.controllers;

import citygenerator.model.DataLayer.BussinesLogic.namegenerator.NameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/citynamegenerator")
public class CityNameGeneratorController {

    @Autowired
    private NameGenerator nameGenerator;

    @GetMapping(name="/generate")
    public @ResponseBody String getGeneratedName() {
        return nameGenerator.getName();
    }

    @GetMapping
    public @ResponseBody List<String> generateMultipleNames(@RequestHeader Integer count) {
        return nameGenerator.getNames(count);
    }

}
