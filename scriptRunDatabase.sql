-- ----------------------------------------------------- 
-- delete all tables` before start application
-- -----------------------------------------------------
/*
DROP TABLE IF EXISTS 'bi_person`,`bi_gender`,`bi_country`,`bi_person_country`;
*/
-- ----------------------------------------------------- 
-- Table 'bi`.`person` 
-- ----------------------------------------------------- 
CREATE TABLE IF NOT EXISTS `bi_person` (
        `id_person` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(50) NOT NULL,
        `last_name` VARCHAR(100) NOT NULL,
         `additional_info` VARCHAR(50) NOT NULL,
		`gender` INT NOT NULL REFERENCES bi_gender
    ) COLLATE='utf8_bin';

-- ----------------------------------------------------- 
-- Table 'bi`.`gender` 
-- ----------------------------------------------------- 
CREATE TABLE IF NOT EXISTS `bi_gender` (
        `id_gender` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `gender` VARCHAR(10) NOT NULL
    ) COLLATE='utf8_bin';
    
-- ----------------------------------------------------- 
-- Table 'bi`.`country` 
-- ----------------------------------------------------- 

CREATE TABLE IF NOT EXISTS `bi_country` (
        `id_country` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `country` VARCHAR(10) NOT NULL
    ) COLLATE='utf8_bin';    
    
-- ----------------------------------------------------- 
-- Table 'bi`.`PersonCountry` 
-- -----------------------------------------------------     
CREATE TABLE IF NOT EXISTS `bi_person_country` (
        `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `person` INT NOT NULL REFERENCES bi_person,
        `country` INT NOT NULL REFERENCES bi_country
    ) COLLATE='utf8_bin';        
