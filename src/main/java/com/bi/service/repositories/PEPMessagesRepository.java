package com.bi.service.repositories;

import com.bi.service.model.Person;
import org.bson.Document;

import java.util.List;

public interface PEPMessagesRepository {

    public List<Document> getOntologizedMessages(String value);

    public List<Document> getLatestOntologizedMessages(int numbersOfMessages);

    public List<Person> findPersons(int numbersOfMessages);

    public void markPersonAsMigrated(String indetifier);

}