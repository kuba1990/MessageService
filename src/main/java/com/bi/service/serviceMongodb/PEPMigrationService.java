package com.bi.service.serviceMongodb;


import com.bi.service.model.mongodb.Person;
import com.bi.service.repositoriesMongoDB.PEPMessagesRepository;
import org.springframework.stereotype.Service;

@Service
public class PEPMigrationService {


    PEPMessagesRepository pepMessagesRepository;

    public PEPMigrationService(PEPMessagesRepository pepMessagesRepository) {
        this.pepMessagesRepository = pepMessagesRepository;
    }


    public void migratedPerson(Person person) {

        System.out.println(person.getIdentifier());

        //TODO
        //update for 1;

        pepMessagesRepository.markPersonAsMigrated(person.getIdentifier());

    }


}
