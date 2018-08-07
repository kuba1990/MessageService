package com.bi.service.repositories;

import com.bi.service.config.DatabaseProperties;
import com.bi.service.model.Person;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


@Repository
public class PEPMessageRepositoryImpl implements PEPMessagesRepository {

    private final MongoTemplate mongoTemplate;
    private final DatabaseProperties config;

    @Autowired
    public PEPMessageRepositoryImpl(MongoTemplate mongoTemplate, DatabaseProperties config) {
        this.mongoTemplate = mongoTemplate;
        this.config = config;
    }

    @Override
    public List<Document> getOntologizedMessages(String value) {
        return mongoTemplate.find(query(where("header.uniqueIdentifier.keys.value").is(value)), Document.class, config.getCollectionName());
    }

    @Override
    public List<Document> getLatestOntologizedMessages(int numbersOfMessages) {
        Query query = new Query();

        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "_id")));
        query.limit(numbersOfMessages);

        return mongoTemplate.find(query, Document.class, config.getCollectionName());
    }


    public List<Person> findPersons(int limit) {
        Query query = new Query();

        query.addCriteria(Criteria.where("migrated").is(null));


        query.limit(limit);

        return mongoTemplate.find(query, Person.class, config.getCollectionName());

    }

    @Override
    public void markPersonAsMigrated(String indetifier) {

        Query query = new Query();
        query.addCriteria(Criteria.where("identifier").is(indetifier));


        Update update = new Update();
        update.set("migrated", "1");
        mongoTemplate.updateMulti(query, update, Person.class);


    }
}