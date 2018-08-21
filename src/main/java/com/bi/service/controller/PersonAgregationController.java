/*
package com.bi.service.controller;


import com.bi.service.model.rest.Person;
import com.bi.service.serviceMariaDB.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/aggregateddata/ctry")
@RestController
@Slf4j
@CrossOrigin
public class PersonAgregationController {


    private PersonService personService;

    public PersonAgregationController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public Map<String, List<Person>> getByCountry() {

        Map<String, List<Person>> personByCountry = new HashMap<>();

        personByCountry.put("Poland", Arrays.asList(new Person()));

        return personByCountry;

    }


    @GetMapping
    @RequestMapping("/gender")
    public Map<String, Map<String, List<Person>>> getByCountryByGender() {

        Map<String, List<Person>> personByCountry = new HashMap<>();

        personByCountry.put("Poland", Arrays.asList(new Person()));

        Map<String, Map<String, List<Person>>> personByGenderCountry = new HashMap<>();

        personByGenderCountry.put("Male", personByCountry);

        return personByGenderCountry;
    }

}
*/
