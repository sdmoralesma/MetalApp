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
-- Table `headbanging-db`.`presentation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`presentation` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`presentation` (
  `id_presentation` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `score` FLOAT NOT NULL COMMENT '',
  `song` VARCHAR(300) NOT NULL COMMENT '',
  PRIMARY KEY (`id_presentation`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`jury`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`jury` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`jury` (
  `jury_id` INT(11) NOT NULL COMMENT '',
  `jury_info` VARCHAR(100) NOT NULL COMMENT '',
  `presentation_id` INT(11) NULL COMMENT '',
  PRIMARY KEY (`jury_id`)  COMMENT '',
  INDEX `fk_jury_presentation1_idx` (`presentation_id` ASC)  COMMENT '',
  CONSTRAINT `fk_jury_presentation1`
    FOREIGN KEY (`presentation_id`)
    REFERENCES `headbanging-db`.`presentation` (`id_presentation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`score_matrix`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`score_matrix` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`score_matrix` (
  `id_score_matrix` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `total_score` FLOAT NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_score_matrix`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
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
  `score_matrix_id` INT(11) NULL COMMENT '',
  `presentation_id` INT(11) NULL COMMENT '',
  PRIMARY KEY (`participant_id`)  COMMENT '',
  INDEX `fk_participant_score_matrix1_idx` (`score_matrix_id` ASC)  COMMENT '',
  INDEX `fk_participant_presentation1_idx` (`presentation_id` ASC)  COMMENT '',
  CONSTRAINT `fk_participant_presentation1`
    FOREIGN KEY (`presentation_id`)
    REFERENCES `headbanging-db`.`presentation` (`id_presentation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participant_score_matrix1`
    FOREIGN KEY (`score_matrix_id`)
    REFERENCES `headbanging-db`.`score_matrix` (`id_score_matrix`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
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
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

