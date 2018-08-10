package com.bi.service.repositoriesMongoDB;

import com.bi.service.model.mongodb.Person;

import java.util.List;

public interface PEPMessagesRepository {

    public List<Person> findPersons(int numbersOfMessages);

    public void markPersonAsMigrated(String indetifier);

}