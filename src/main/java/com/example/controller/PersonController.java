package com.example.controller;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String showAllPerson(Model model) {
        model.addAttribute("personList", personService.listPerson());
        return "person/list-person";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showPersonAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "person/add-person";
    }


//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addPerson(HttpServletRequest request) {
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String age = request.getParameter("age");
//
//        System.out.println(firstName);
//        System.out.println(lastName);
//        System.out.println(age);
//        return "person/list-person";
//    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addPerson(
//            @RequestParam
//            String firstName,
//            @RequestParam
//            String lastName,
//            @RequestParam
//            int age
//    ) {
//        personService.addPerson(new Person(firstName, lastName, age));
//
//        return "person/added";
//    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(
            @ModelAttribute("person")
            Person person
    ) {
        personService.addPerson(person);
        return "person/added";
    }
}
