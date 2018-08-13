package com.bi.service.repositoriesMongoDB;

import com.bi.service.config.DatabaseProperties;
import com.bi.service.model.mongodb.PepPerson;
import com.bi.service.repositoriesMariaDB.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PEPMessageRepositoryImpl implements PEPMessagesRepository {

    private final MongoTemplate mongoTemplate;
    private final MongoOperations mongoOperations;

    private final DatabaseProperties config;

    private PersonRepository personRepository;


    public PEPMessageRepositoryImpl(MongoTemplate mongoTemplate, MongoOperations mongoOperations, DatabaseProperties config, PersonRepository personRepository) {
        this.mongoTemplate = mongoTemplate;
        this.mongoOperations = mongoOperations;
        this.config = config;
        this.personRepository = personRepository;
    }

    public List<PepPerson> findPersons(int limit) {
        Query query = new Query();

        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "_id")));
        query.limit(limit);

        System.out.println(limit);

        System.out.println(getSkipNumber());

        //TODO database count from mariadb repositories
        query.skip(getSkipNumber());

        return mongoTemplate.find(query, PepPerson.class, config.getCollectionName());

    }

    @Override
    public void markPersonAsMigrated(String indetifier) {

    }

    private int getSkipNumber(){

        int skip = (int) personRepository.count();

        return skip;
    }

}