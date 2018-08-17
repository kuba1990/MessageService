package com.bi.service.controller;

import com.bi.service.model.rest.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RequestMapping("/person")
@RestController
@Slf4j
@CrossOrigin
public class PersonController {


//1. Dodanie nowej osoby – wykonanie metody http: POST – wysłanie pod adres https://svc-dev-cluster1.blue.bisnode.net/{nazwa aplikacji}/v1/person struktury JSON:
//{
//“name” : “Jan”,
//“last_name” : “Kowalski”,
//“additional_info” : “PEP”,
//“country”: [“Poland”,”Japan”]
//“gender”: “Male”
//}


    /*@RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Customer> create(@RequestBody Customer user) {
        customerService.create(user);
        return customerService.getAll();
    }*/


    @PostMapping
    public Person addPerson(@RequestBody Person person) {


        return person;
    }


    @DeleteMapping
    public void deletePerson(@RequestBody Person person) {


    }

    @PutMapping
    public Person putPerson(@RequestBody Person person) {


        return person;
    }

    @GetMapping(value = "/{id}")
    public Person getPerson(@PathVariable Long id) {


        return new Person();
    }

    @GetMapping(params = "ctry")
    public List<Person> getPersonCountry(@RequestParam(required = true, value = "ctry") String country) {

        return Arrays.asList(new Person());

    }

    @GetMapping(params = "gender")
    public List<Person> getPersonGender(@RequestParam(required = true, value = "gender") String gender) {

        return Arrays.asList(new Person());

    }


}
