package com.bi.service.repositoriesMariaDB;

import com.bi.service.model.mariadb.PersonCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonCountryRepository extends JpaRepository<PersonCountry, Long> {
}
