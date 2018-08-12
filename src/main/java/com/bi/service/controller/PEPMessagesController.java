package com.bi.service.controller;

import com.bi.service.exception.ResourceBadRequestException;
import com.bi.service.model.mongodb.PepPerson;
import com.bi.service.repositoriesMongoDB.PEPMessagesRepository;
import com.bi.service.serviceMongodb.PEPMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/messages")
@CrossOrigin
public class PEPMessagesController {

    private PEPMessagesRepository pEPMessagesRepository;

    private PEPMessageService pepMessageService;

    public PEPMessagesController(PEPMessagesRepository pEPMessagesRepository, PEPMessageService pepMessageService) {
        this.pEPMessagesRepository = pEPMessagesRepository;
        this.pepMessageService = pepMessageService;
    }


    @GetMapping(params = "limit")
    public List<PepPerson> getSortedOntolgizedMessage(@RequestParam(required = false, value = "limit", defaultValue = "10000") int limit) {

        if (limit > 10000) {
            throw new ResourceBadRequestException();
        }

        List<PepPerson> messages = pepMessageService.migrate(limit);

        log.info("Fetch for latest {} ontologized messages, returned {} messages. ", limit, messages.size());
        return messages;

    }

}