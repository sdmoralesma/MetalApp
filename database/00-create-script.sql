-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema headbanging-db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `headbanging-db` ;

-- -----------------------------------------------------
-- Schema headbanging-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `headbanging-db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `headbanging-db` ;

-- -----------------------------------------------------
-- Table `headbanging-db`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`User` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`User` (
  `id` INT NOT NULL COMMENT '',
  `username` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

