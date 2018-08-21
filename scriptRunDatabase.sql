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
        `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(50) NOT NULL,
        `last_name` VARCHAR(100) NOT NULL,
         `additional_info` VARCHAR(50) NOT NULL,
        `gender_id` INT, 
        FOREIGN KEY(gender_id) REFERENCES bi_gender(id))
     COLLATE='utf8_bin';

-- ----------------------------------------------------- 
-- Table 'bi`.`gender` 
-- ----------------------------------------------------- 
CREATE TABLE IF NOT EXISTS `bi_gender` (
        `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `name`  VARCHAR(10) NOT NULL  
    ) COLLATE='utf8_bin';
    
-- ----------------------------------------------------- 
-- Table 'bi`.`country` 
-- ----------------------------------------------------- 

CREATE TABLE IF NOT EXISTS `bi_country` (
        `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `name`  VARCHAR(10) NOT NULL 
    ) COLLATE='utf8_bin'; 
    
-- ----------------------------------------------------- 
-- Table 'bi`.`PersonCountry` 
-- -----------------------------------------------------     
CREATE TABLE IF NOT EXISTS `bi_person_country` (
        `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `person_id` INT NOT NULL,
        `country_id` INT NOT NULL,
        FOREIGN KEY(person_id) REFERENCES bi_person(id),
        FOREIGN KEY(country_id) REFERENCES bi_country(id))
     COLLATE='utf8_bin';        
