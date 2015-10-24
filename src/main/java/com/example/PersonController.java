package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableAutoConfiguration
public class PersonController {
    @Autowired
    PersonRepository repository;
    
    @RequestMapping("/person")
    public String personView(Model model) {
      Iterable<Person> list = repository.findAll();
      model.addAttribute("results", list);
      return "person-view";
    }
    
    @RequestMapping(value="/post", method=RequestMethod.POST)
    public String personSearch(Model model,
        @RequestParam("name") String name,
        @RequestParam("tel") String tel,
        @RequestParam("mail") String mail,
        @RequestParam("description") String description) {
 
        Person person = new Person(name, tel, mail, description);
        repository.saveAndFlush(person);
        Iterable<Person> list = repository.findAll();
        model.addAttribute("results", list);
        return "person-view";
    }
}
