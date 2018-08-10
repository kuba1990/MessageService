package com.bi.service.repositoriesMongoDB;

import com.bi.service.config.DatabaseProperties;
import com.bi.service.model.mongodb.Person;
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


    @Autowired
    public PEPMessageRepositoryImpl(MongoTemplate mongoTemplate, MongoOperations mongoOperations, DatabaseProperties config) {
        this.mongoTemplate = mongoTemplate;
        this.mongoOperations = mongoOperations;
        this.config = config;
    }


    public List<Person> findPersons(int limit) {
        Query query = new Query();

        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "_id")));
        query.limit(limit);

        //TODO database count from mariadb repositories
        query.skip(10);

        return mongoTemplate.find(query, Person.class, config.getCollectionName());

    }

    @Override
    public void markPersonAsMigrated(String indetifier) {

    }
}