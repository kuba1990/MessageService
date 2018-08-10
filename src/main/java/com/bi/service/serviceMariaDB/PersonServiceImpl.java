/*
package com.bi.service.serviceMariaDB;

import Person;
import com.bi.service.repositoriesMariaDB.PersonRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepositories personRepositories;

    public PersonServiceImpl(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    @Override
    public int numberMigratedPeople() {
        List<Person> products = new ArrayList<>();
        personRepositories.findAll().forEach(products::add);
        return products.size();


    }
}
*/
