package com.bi.service.serviceMariaDB;

import com.bi.service.model.mariadb.Country;
import com.bi.service.model.mariadb.Gender;
import com.bi.service.model.mariadb.Person;
import com.bi.service.model.mongodb.PepPerson;
import com.bi.service.repositoriesMariaDB.CountryRepository;
import com.bi.service.repositoriesMariaDB.GenderRepository;
import com.bi.service.repositoriesMariaDB.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    private GenderRepository genderRepository;

    private CountryRepository countryRepository;

    public PersonServiceImpl(PersonRepository personRepository, GenderRepository genderRepository, CountryRepository countryRepository) {
        this.personRepository = personRepository;
        this.genderRepository = genderRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Person addPerson(PepPerson pepPerson) {
        Person person = new Person();

        //System.out.println(pepPerson);

        person.setName(pepPerson.getFirstName());
        person.setLastName(pepPerson.getLastName());
        person.setAdditionalInfo(pepPerson.getFunction());

        person.setCountries(Arrays.asList(storeCountryIfNotExist(pepPerson.getCountry())));

        person.setGender(storeGenderIfNotExist(pepPerson.getGender()));


        personRepository.saveAndFlush(person);

        return person;
    }

    @Override
    public Person deletePerson() {
        return null;
    }

    private Gender storeGenderIfNotExist(String gender) {

        if (genderRepository.findByName(gender) == null) {
            Gender newGender = new Gender();
            newGender.setName(gender);

            return genderRepository.saveAndFlush(newGender);

        } else {
            return genderRepository.findByName(gender);

        }

    }

    private Country storeCountryIfNotExist(String country) {



        if (countryRepository.findByName(country) == null) {
            Country newCountry = new Country();
            newCountry.setName(country);

            return countryRepository.saveAndFlush(newCountry);

        } else {
            return countryRepository.findByName(country);

        }

    }
}