package com.bi.service.serviceMongodb;

import com.bi.service.model.mariadb.Country;
import com.bi.service.model.mariadb.Gender;
/*import com.bi.service.model.mariadb.PersonCountry;*/
import com.bi.service.model.mongodb.PepPerson;
import com.bi.service.repositoriesMariaDB.CountryRepository;
import com.bi.service.repositoriesMariaDB.GenderRepository;
/*import com.bi.service.repositoriesMariaDB.PersonCountryRepository;*/
import com.bi.service.repositoriesMariaDB.PersonRepository;
import com.bi.service.repositoriesMongoDB.PEPMessagesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class PEPMessageService {

    PEPMessagesRepository pepMessagesRepository;

    PersonRepository personRepository;

    GenderRepository genderRepository;

    CountryRepository countryRepository;

/*    PersonCountryRepository personCountryRepository;*/


    public PEPMessageService(PEPMessagesRepository pepMessagesRepository, PersonRepository personRepository, GenderRepository genderRepository, CountryRepository countryRepository/*, PersonCountryRepository personCountryRepository*/) {
        this.pepMessagesRepository = pepMessagesRepository;
        this.personRepository = personRepository;
        this.genderRepository = genderRepository;
        this.countryRepository = countryRepository;
       /* this.personCountryRepository = personCountryRepository;*/
    }

    public List<PepPerson> migrate(int limit) {

        //download records from mongoDB
        List<PepPerson> pepPersons = pepMessagesRepository.findPersons(limit);

        pepPersons.forEach(pepPerson -> System.out.println(pepPerson));



        com.bi.service.model.mariadb.Person person = new com.bi.service.model.mariadb.Person();

        Gender gender = new Gender();

        gender.setName("male");

        gender = genderRepository.save(gender);


        //country
        Country country = new Country();
        country.setName("Poland");
        country = countryRepository.save(country);


        //person country

       /*    PersonCountry personCountry = new PersonCountry();*/

        /* personCountry.setCountries(Arrays.asList(country));*/


        person.setName("Kuba");
        person.setLastName("WW");
        person.setAdditionalInfo("Java master");
        person.setGender(gender);

        Set<Country> countries = new HashSet();
        countries.add(country);
        person.setCountries(countries);


        System.out.println(person.getName());

        System.out.println(person.getGender());
        System.out.println(person.getCountries());
        System.out.println(person.getLastName());
        System.out.println(person.getAdditionalInfo());


        personRepository.save(person);


        return pepPersons;


    }


}
