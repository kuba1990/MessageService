package com.bi.service.repositoriesMariaDB;

import com.bi.service.model.mariadb.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
