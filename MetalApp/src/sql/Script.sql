--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `metal`.`users` DROP PRIMARY KEY;

ALTER TABLE `metal`.`song` DROP PRIMARY KEY;

ALTER TABLE `metal`.`admin` DROP PRIMARY KEY;

ALTER TABLE `metal`.`score_matrix` DROP PRIMARY KEY;

ALTER TABLE `metal`.`gender` DROP PRIMARY KEY;

ALTER TABLE `metal`.`presentation` DROP PRIMARY KEY;

ALTER TABLE `metal`.`jury` DROP PRIMARY KEY;

ALTER TABLE `metal`.`participant` DROP PRIMARY KEY;

ALTER TABLE `metal`.`artist` DROP PRIMARY KEY;

ALTER TABLE `metal`.`song_matrix` DROP PRIMARY KEY;

ALTER TABLE `metal`.`score_matrix` DROP INDEX `metal`.`fk_score_matrix_participant_idx`;

ALTER TABLE `metal`.`admin` DROP INDEX `metal`.`fk_admin_users_idx`;

ALTER TABLE `metal`.`song_matrix` DROP INDEX `metal`.`fk_songmatrix_song`;

ALTER TABLE `metal`.`song` DROP INDEX `metal`.`fk_song_artist`;

ALTER TABLE `metal`.`song` DROP INDEX `metal`.`fk_song_gender`;

ALTER TABLE `metal`.`jury` DROP INDEX `metal`.`fk_jury_users_idx`;

ALTER TABLE `metal`.`participant` DROP INDEX `metal`.`fk_participant_users_idx`;

ALTER TABLE `metal`.`presentation` DROP INDEX `metal`.`fk_presentation_song`;

ALTER TABLE `metal`.`presentation` DROP INDEX `metal`.`fk_presentation_participant_idx`;

DROP TABLE `metal`.`jury`;

DROP TABLE `metal`.`participant`;

DROP TABLE `metal`.`gender`;

DROP TABLE `metal`.`song_matrix`;

DROP TABLE `metal`.`score_matrix`;

DROP TABLE `metal`.`admin`;

DROP TABLE `metal`.`song`;

DROP TABLE `metal`.`users`;

DROP TABLE `metal`.`artist`;

DROP TABLE `metal`.`presentation`;

CREATE TABLE `metal`.`jury` (
	`username` VARCHAR(50) NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`description` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`username`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`participant` (
	`username` VARCHAR(50) NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`country` VARCHAR(50) NOT NULL,
	`age` INT NOT NULL,
	`gender` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`username`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`gender` (
	`id_gender` INT NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`hand_value` INT NOT NULL,
	`head_value` INT NOT NULL,
	PRIMARY KEY (`id_gender`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`song_matrix` (
	`musicality1` INT,
	`musicality2` INT,
	`musicality3` INT,
	`musicality4` INT,
	`musicality5` INT,
	`musicality6` INT,
	`musicality7` INT,
	`musicality8` INT,
	`musicality9` INT,
	`musicality10` INT,
	`composition1` INT,
	`composition2` INT,
	`composition3` INT,
	`composition4` INT,
	`composition5` INT,
	`composition6` INT,
	`composition7` INT,
	`composition8` INT,
	`composition9` INT,
	`composition10` INT,
	`musicality_score` FLOAT,
	`composition_score` FLOAT,
	`total_score` FLOAT,
	`id_song` INT NOT NULL,
	PRIMARY KEY (`id_song`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`score_matrix` (
	`head1` INT,
	`head2` INT,
	`head3` INT,
	`head4` INT,
	`head5` INT,
	`head6` INT,
	`head7` INT,
	`head8` INT,
	`head9` INT,
	`head10` INT,
	`hand1` INT,
	`hand2` INT,
	`hand3` INT,
	`hand4` INT,
	`hand5` INT,
	`hand6` INT,
	`hand7` INT,
	`hand8` INT,
	`hand9` INT,
	`hand10` INT,
	`total_score` FLOAT,
	`username` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`username`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`admin` (
	`username` VARCHAR(50) NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`description` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`username`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`song` (
	`id_song` INT NOT NULL,
	`title` VARCHAR(100) NOT NULL,
	`id_artist` INT NOT NULL,
	`id_gender` INT NOT NULL,
	PRIMARY KEY (`id_song`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`users` (
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`group_name` VARCHAR(50) NOT NULL,
	`user_type` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`username`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`artist` (
	`id_artist` INT NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`description` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id_artist`)
) ENGINE=InnoDB;

CREATE TABLE `metal`.`presentation` (
	`id_presentation` INT NOT NULL,
	`hand_score` FLOAT NOT NULL,
	`head_score` FLOAT NOT NULL,
	`total_score` FLOAT NOT NULL,
	`id_song` INT NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id_presentation`)
) ENGINE=InnoDB;

CREATE INDEX `fk_score_matrix_participant_idx` ON `metal`.`score_matrix` (`username` ASC);

CREATE INDEX `fk_admin_users_idx` ON `metal`.`admin` (`username` ASC);

CREATE INDEX `fk_songmatrix_song` ON `metal`.`song_matrix` (`id_song` ASC);

CREATE INDEX `fk_song_artist` ON `metal`.`song` (`id_artist` ASC);

CREATE INDEX `fk_song_gender` ON `metal`.`song` (`id_gender` ASC);

CREATE INDEX `fk_jury_users_idx` ON `metal`.`jury` (`username` ASC);

CREATE INDEX `fk_participant_users_idx` ON `metal`.`participant` (`username` ASC);

CREATE INDEX `fk_presentation_song` ON `metal`.`presentation` (`id_song` ASC);

CREATE INDEX `fk_presentation_participant_idx` ON `metal`.`presentation` (`username` ASC);

