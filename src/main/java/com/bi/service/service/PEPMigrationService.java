package com.bi.service.service;

import com.bi.service.model.Person;
import com.bi.service.repositories.PEPMessagesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PEPMigrationService {

    //TODO
    //repo for MARIADB

    PEPMessagesRepository pepMessagesRepository;

    public PEPMigrationService(PEPMessagesRepository pepMessagesRepository) {
        this.pepMessagesRepository = pepMessagesRepository;
    }


    public void migratePerson(Person person) {

        System.out.println(person.getIdentifier());

        //TODO
        //update for 1;

        pepMessagesRepository.markPersonAsMigrated(person.getIdentifier());

    }


}
