package citygenerator.controllers;

import citygenerator.model.DataLayer.Entities.CityNames;
import citygenerator.model.DataLayer.Repositories.CityNamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/citynames")
public class CityNamesController {
    @Autowired
    private CityNamesRepo namesRepository;

    @GetMapping
    public @ResponseBody String addNewName(@RequestParam String name) {
        CityNames cityname = new CityNames(name);
        namesRepository.save(cityname);
        return "Saved.";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CityNames> getAllNames() {
        return namesRepository.findAll();
    }
}
