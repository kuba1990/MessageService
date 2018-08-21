package com.bi.service.serviceMongodb;

import com.bi.service.model.mariadb.Country;
import com.bi.service.model.mariadb.Gender;
import com.bi.service.model.mongodb.PepPerson;
import com.bi.service.repositoriesMariaDB.CountryRepository;
import com.bi.service.repositoriesMariaDB.GenderRepository;
import com.bi.service.repositoriesMariaDB.PersonRepository;
import com.bi.service.repositoriesMongoDB.PEPMessagesRepository;
import com.bi.service.serviceMariaDB.PersonService;
import com.bi.service.serviceMariaDB.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*import com.bi.service.model.mariadb.PersonCountry;*/
/*import com.bi.service.repositoriesMariaDB.PersonCountryRepository;*/

@Slf4j
@Service
public class PEPMessageService {

    PEPMessagesRepository pepMessagesRepository;

    PersonRepository personRepository;

    GenderRepository genderRepository;

    CountryRepository countryRepository;

    PersonService personService;


    public PEPMessageService(PEPMessagesRepository pepMessagesRepository, PersonRepository personRepository, GenderRepository genderRepository, CountryRepository countryRepository, PersonService personService) {
        this.pepMessagesRepository = pepMessagesRepository;
        this.personRepository = personRepository;
        this.genderRepository = genderRepository;
        this.countryRepository = countryRepository;
        this.personService = personService;
    }

    public List<PepPerson> migrate(int limit) {

        List<PepPerson> pepPersons = pepMessagesRepository.findPersons(limit);
        for (int a = 0; a < pepPersons.size(); a++) {
            personService.addPerson(pepPersons.get(a));


        }

            return pepPersons;
    }


       /* Country country = new Country();
        country.setName("Poland");
        countryRepository.saveAndFlush(country);


        Gender gender = new Gender();
        gender.setName("MALE");
        genderRepository.saveAndFlush(gender);

        com.bi.service.model.mariadb.Person person = new com.bi.service.model.mariadb.Person();

        person.setName("Kuba");
        person.setLastName("WW");
        person.setAdditionalInfo("123");
        person.setGender(gender);


        List<Country> countryPoland = new ArrayList<>();

        countryPoland.add(country);

        person.setCountries(countryPoland);

        personRepository.saveAndFlush(person);


        return new ArrayList<>();*/

        //download records from mongoDB

        //pepPersons.forEach(pepPerson -> System.out.println(pepPerson));






           /* person.setName(pepPersons.get(a).getFirstName());
            person.setLastName(pepPersons.get(a).getLastName());
            person.setAdditionalInfo(pepPersons.get(a).getIdentifier());
            person.setGender(gender);

            Set<Country> countries = new HashSet();
            countries.add(country);
            person.setCountries(countries);*/


           /* personRepository.save(person);*/



        }




