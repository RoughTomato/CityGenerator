package citygenerator.controllers;

import citygenerator.model.DataLayer.Entities.NameTypes;
import citygenerator.model.DataLayer.Entities.Names;
import citygenerator.model.DataLayer.Repositories.NamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping(path="/names")
public class NamesController {
    @Autowired
    private NamesRepo namesRepository;

    @GetMapping(path="/addnew")
    public @ResponseBody String addNewName(@RequestParam String name,
                                           @RequestParam NameTypes type) {
        Names newName = new Names(name, type);
        namesRepository.save(newName);
        return "Saved.";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Names> getAllNames() {
        return namesRepository.findAll();
    }
}
