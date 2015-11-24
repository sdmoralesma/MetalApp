-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema headbanging-db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `headbanging-db` ;

-- -----------------------------------------------------
-- Schema headbanging-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `headbanging-db` DEFAULT CHARACTER SET latin1 ;
USE `headbanging-db` ;

-- -----------------------------------------------------
-- Table `headbanging-db`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`admin` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`admin` (
  `admin_id` INT(11) NOT NULL COMMENT '',
  `admin_info` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`admin_id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`jury`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`jury` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`jury` (
  `jury_id` INT(11) NOT NULL COMMENT '',
  `jury_info` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`jury_id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`participant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`participant` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`participant` (
  `participant_id` INT(11) NOT NULL COMMENT '',
  `age` INT(11) NOT NULL COMMENT '',
  `gender` VARCHAR(10) NOT NULL COMMENT '',
  `image_url` VARCHAR(300) NULL DEFAULT NULL COMMENT '',
  `song` VARCHAR(100) NULL COMMENT '',
  `total_score` DOUBLE NULL COMMENT '',
  PRIMARY KEY (`participant_id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`qualifications`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`qualifications` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`qualifications` (
  `id_qualification` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `score` INT(11) NOT NULL COMMENT '',
  `participant_id` INT(11) NOT NULL COMMENT '',
  `jury_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_qualification`)  COMMENT '',
  INDEX `fk_qualifications_participant1_idx` (`participant_id` ASC)  COMMENT '',
  INDEX `fk_qualifications_jury1_idx` (`jury_id` ASC)  COMMENT '',
  CONSTRAINT `fk_qualifications_participant1`
    FOREIGN KEY (`participant_id`)
    REFERENCES `headbanging-db`.`participant` (`participant_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qualifications_jury1`
    FOREIGN KEY (`jury_id`)
    REFERENCES `headbanging-db`.`jury` (`jury_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`user` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `user_type` VARCHAR(20) NOT NULL COMMENT '',
  `group_name` VARCHAR(20) NOT NULL COMMENT '',
  `username` VARCHAR(20) NOT NULL COMMENT '',
  `password` VARCHAR(50) NOT NULL COMMENT '',
  `description` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`user_id`)  COMMENT '',
  UNIQUE INDEX `USERNAME` (`username` ASC)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

