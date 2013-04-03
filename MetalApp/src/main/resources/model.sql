SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `metal` ;
CREATE SCHEMA IF NOT EXISTS `metal` ;
USE `metal` ;

-- -----------------------------------------------------
-- Table `metal`.`artist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`artist` ;

CREATE  TABLE IF NOT EXISTS `metal`.`artist` (
  `id_artist` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `description` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id_artist`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`gender` ;

CREATE  TABLE IF NOT EXISTS `metal`.`gender` (
  `id_gender` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `hand_value` INT NOT NULL ,
  `head_value` INT NOT NULL ,
  PRIMARY KEY (`id_gender`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`song`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`song` ;

CREATE  TABLE IF NOT EXISTS `metal`.`song` (
  `id_song` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(100) NOT NULL ,
  `id_artist` INT NOT NULL ,
  `id_gender` INT NOT NULL ,
  PRIMARY KEY (`id_song`) ,
  INDEX `fk_song_artist` (`id_artist` ASC) ,
  INDEX `fk_song_gender` (`id_gender` ASC) ,
  CONSTRAINT `fk_song_artist`
    FOREIGN KEY (`id_artist` )
    REFERENCES `metal`.`artist` (`id_artist` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_song_gender`
    FOREIGN KEY (`id_gender` )
    REFERENCES `metal`.`gender` (`id_gender` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`song_matrix`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`song_matrix` ;

CREATE  TABLE IF NOT EXISTS `metal`.`song_matrix` (
  `musicality1` INT NULL DEFAULT NULL ,
  `musicality2` INT NULL DEFAULT NULL ,
  `musicality3` INT NULL DEFAULT NULL ,
  `musicality4` INT NULL DEFAULT NULL ,
  `musicality5` INT NULL DEFAULT NULL ,
  `musicality6` INT NULL DEFAULT NULL ,
  `musicality7` INT NULL DEFAULT NULL ,
  `musicality8` INT NULL DEFAULT NULL ,
  `musicality9` INT NULL DEFAULT NULL ,
  `musicality10` INT NULL DEFAULT NULL ,
  `composition1` INT NULL DEFAULT NULL ,
  `composition2` INT NULL DEFAULT NULL ,
  `composition3` INT NULL DEFAULT NULL ,
  `composition4` INT NULL DEFAULT NULL ,
  `composition5` INT NULL DEFAULT NULL ,
  `composition6` INT NULL DEFAULT NULL ,
  `composition7` INT NULL DEFAULT NULL ,
  `composition8` INT NULL DEFAULT NULL ,
  `composition9` INT NULL DEFAULT NULL ,
  `composition10` INT NULL DEFAULT NULL ,
  `musicality_score` FLOAT NULL DEFAULT NULL ,
  `composition_score` FLOAT NULL DEFAULT NULL ,
  `total_score` FLOAT NULL DEFAULT NULL ,
  `id_song` INT NOT NULL ,
  INDEX `fk_songmatrix_song` (`id_song` ASC) ,
  PRIMARY KEY (`id_song`) ,
  CONSTRAINT `fk_songmatrix_song`
    FOREIGN KEY (`id_song` )
    REFERENCES `metal`.`song` (`id_song` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`users` ;

CREATE  TABLE IF NOT EXISTS `metal`.`users` (
  `username` VARCHAR(50) NOT NULL ,
  `password` VARCHAR(50) NOT NULL ,
  `group` VARCHAR(50) NOT NULL ,
  `user_type` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`username`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`participant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`participant` ;

CREATE  TABLE IF NOT EXISTS `metal`.`participant` (
  `username` VARCHAR(50) NOT NULL ,
  `name` VARCHAR(100) NOT NULL ,
  `country` VARCHAR(50) NOT NULL ,
  `age` INT NOT NULL ,
  `gender` VARCHAR(50) NOT NULL ,
  INDEX `fk_participant_users_idx` (`username` ASC) ,
  PRIMARY KEY (`username`) ,
  CONSTRAINT `fk_participant_users`
    FOREIGN KEY (`username` )
    REFERENCES `metal`.`users` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`score_matrix`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`score_matrix` ;

CREATE  TABLE IF NOT EXISTS `metal`.`score_matrix` (
  `head1` INT NULL DEFAULT NULL ,
  `head2` INT NULL DEFAULT NULL ,
  `head3` INT NULL DEFAULT NULL ,
  `head4` INT NULL DEFAULT NULL ,
  `head5` INT NULL DEFAULT NULL ,
  `head6` INT NULL DEFAULT NULL ,
  `head7` INT NULL DEFAULT NULL ,
  `head8` INT NULL DEFAULT NULL ,
  `head9` INT NULL DEFAULT NULL ,
  `head10` INT NULL DEFAULT NULL ,
  `hand1` INT NULL DEFAULT NULL ,
  `hand2` INT NULL DEFAULT NULL ,
  `hand3` INT NULL DEFAULT NULL ,
  `hand4` INT NULL DEFAULT NULL ,
  `hand5` INT NULL DEFAULT NULL ,
  `hand6` INT NULL DEFAULT NULL ,
  `hand7` INT NULL DEFAULT NULL ,
  `hand8` INT NULL DEFAULT NULL ,
  `hand9` INT NULL ,
  `hand10` INT NULL DEFAULT NULL ,
  `total_score` FLOAT NULL DEFAULT NULL ,
  `username` VARCHAR(50) NOT NULL ,
  INDEX `fk_score_matrix_participant_idx` (`username` ASC) ,
  PRIMARY KEY (`username`) ,
  CONSTRAINT `fk_score_matrix_participant`
    FOREIGN KEY (`username` )
    REFERENCES `metal`.`participant` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`presentation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`presentation` ;

CREATE  TABLE IF NOT EXISTS `metal`.`presentation` (
  `id_presentation` INT NOT NULL AUTO_INCREMENT ,
  `hand_score` FLOAT NOT NULL ,
  `head_score` FLOAT NOT NULL ,
  `total_score` FLOAT NOT NULL ,
  `id_song` INT NOT NULL ,
  `username` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id_presentation`) ,
  INDEX `fk_presentation_song` (`id_song` ASC) ,
  INDEX `fk_presentation_participant_idx` (`username` ASC) ,
  CONSTRAINT `fk_presentation_song`
    FOREIGN KEY (`id_song` )
    REFERENCES `metal`.`song` (`id_song` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_presentation_participant`
    FOREIGN KEY (`username` )
    REFERENCES `metal`.`participant` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`jury`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`jury` ;

CREATE  TABLE IF NOT EXISTS `metal`.`jury` (
  `username` VARCHAR(50) NOT NULL ,
  `name` VARCHAR(100) NOT NULL ,
  `description` VARCHAR(100) NOT NULL ,
  INDEX `fk_jury_users_idx` (`username` ASC) ,
  PRIMARY KEY (`username`) ,
  CONSTRAINT `fk_jury_users`
    FOREIGN KEY (`username` )
    REFERENCES `metal`.`users` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `metal`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `metal`.`admin` ;

CREATE  TABLE IF NOT EXISTS `metal`.`admin` (
  `username` VARCHAR(50) NOT NULL ,
  `name` VARCHAR(100) NOT NULL ,
  `description` VARCHAR(100) NOT NULL ,
  INDEX `fk_admin_users_idx` (`username` ASC) ,
  PRIMARY KEY (`username`) ,
  CONSTRAINT `fk_admin_users`
    FOREIGN KEY (`username` )
    REFERENCES `metal`.`users` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
