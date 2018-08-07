package com.bi.service.service;

import com.bi.service.model.Person;
import com.bi.service.repositories.PEPMessagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PEPMessageService {

    PEPMessagesRepository pepMessagesRepository;

    PEPMigrationService pepMigrationService;

    public PEPMessageService(PEPMessagesRepository pepMessagesRepository, PEPMigrationService pepMigrationService) {
        this.pepMessagesRepository = pepMessagesRepository;
        this.pepMigrationService = pepMigrationService;
    }


    public List<Person> migrate(int limit) {

        //download records from mongoDB
        List<Person> persons = pepMessagesRepository.findPersons(limit);

        for (Person person : persons) {


            pepMigrationService.migratePerson(person);
        }


        //store in database

        //add flag


        return persons;


    }


}
