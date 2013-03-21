-- Precaution: First create the database from a SQL Console
-- CREATE DATABASE IF NOT EXISTS metal;
-- USE metal;

CREATE TABLE song_matrix (
	id_song INT NOT NULL AUTO_INCREMENT,
	musicality1 INT,
	musicality2 INT,
	musicality3 INT,
	musicality4 INT,
	musicality5 INT,
	musicality6 INT,
	musicality7 INT,
	musicality8 INT,
	musicality9 INT,
	musicality10 INT,
	composition1 INT,
	composition2 INT,
	composition3 INT,
	composition4 INT,
	composition5 INT,
	composition6 INT,
	composition7 INT,
	composition8 INT,
	composition9 INT,
	composition10 INT,
	musicality_score FLOAT,
	composition_score FLOAT,
	total_score FLOAT,
	id_song1 INT,
	PRIMARY KEY (id_song)
) ENGINE=InnoDB;

CREATE TABLE participant (
	id_participant INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	phone INT NOT NULL,
	age INT NOT NULL,
	gender VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_participant)
) ENGINE=InnoDB;

CREATE TABLE gender (
	id_gender INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	hand_value INT NOT NULL,
	head_value INT NOT NULL,
	PRIMARY KEY (id_gender)
) ENGINE=InnoDB;

CREATE TABLE score_matrix (
	id_participant INT NOT NULL AUTO_INCREMENT,
	head1 INT,
	head2 INT,
	head3 INT,
	head4 INT,
	head5 INT,
	head6 INT,
	head7 INT,
	head8 INT,
	head9 INT,
	head10 INT,
	hand1 INT,
	hand2 INT,
	hand3 INT,
	hand4 INT,
	hand5 INT,
	hand6 INT,
	hand7 INT,
	hand8 INT,
	hand9 INT,
	hand10 INT,
	hand_score FLOAT,
	head_score FLOAT,
	total_score FLOAT,
	id_participant INT,
	PRIMARY KEY (id_participant)
) ENGINE=InnoDB;

CREATE TABLE jury_presentation (
	presentation_id_presentation INT NOT NULL AUTO_INCREMENT,
	jury_id_jury INT NOT NULL,
	PRIMARY KEY (presentation_id_presentation,jury_id_jury)
) ENGINE=InnoDB;

CREATE TABLE artist (
	id_artist INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_artist)
) ENGINE=InnoDB;

CREATE TABLE users (
	username VARCHAR(50) NOT NULL,
	password VARCHAR(100),
	PRIMARY KEY (username)
) ENGINE=InnoDB;

CREATE TABLE presentation (
	id_presentation INT NOT NULL AUTO_INCREMENT,
	id_participant INT NOT NULL,
	id_song INT NOT NULL,
	id_jury INT NOT NULL,
	hand_score FLOAT NOT NULL,
	head_score FLOAT NOT NULL,
	total_score FLOAT NOT NULL,
	id_participant INT,
	id_song1 INT,
	PRIMARY KEY (id_presentation)
) ENGINE=InnoDB;

CREATE TABLE groups (
	id_group VARCHAR(50),
	username VARCHAR(50) NOT NULL,
	PRIMARY KEY (username)
) ENGINE=InnoDB;

CREATE TABLE jury (
	id_jury INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_jury)
) ENGINE=InnoDB;

CREATE TABLE song (
	id_song INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	id_artist INT NOT NULL,
	id_gender INT NOT NULL,
	id_artist1 INT,
	id_gender1 INT,
	PRIMARY KEY (id_song)
) ENGINE=InnoDB;

CREATE INDEX song_presentation ON presentation (id_song1 ASC);

CREATE INDEX song_songmatrix ON song_matrix (id_song1 ASC);

CREATE INDEX participant_presentation ON presentation (id_participant ASC);

CREATE INDEX participant_scorematrix ON score_matrix (id_participant ASC);

CREATE INDEX artist_song ON song (id_artist1 ASC);

CREATE INDEX FK_ASS_27 ON jury_presentation (jury_id_jury ASC);

CREATE INDEX gender_song ON song (id_gender1 ASC);

ALTER TABLE jury_presentation ADD CONSTRAINT FK_ASS_27 FOREIGN KEY (jury_id_jury)
	REFERENCES jury (id_jury)
	ON DELETE CASCADE;

ALTER TABLE presentation ADD CONSTRAINT participant_presentation FOREIGN KEY (id_participant)
	REFERENCES participant (id_participant);

ALTER TABLE song ADD CONSTRAINT artist_song FOREIGN KEY (id_artist1)
	REFERENCES artist (id_artist);

ALTER TABLE presentation ADD CONSTRAINT song_presentation FOREIGN KEY (id_song1)
	REFERENCES song (id_song);

ALTER TABLE song ADD CONSTRAINT gender_song FOREIGN KEY (id_gender1)
	REFERENCES gender (id_gender);

ALTER TABLE score_matrix ADD CONSTRAINT participant_scorematrix FOREIGN KEY (id_participant)
	REFERENCES participant (id_participant);

ALTER TABLE song_matrix ADD CONSTRAINT song_songmatrix FOREIGN KEY (id_song1)
	REFERENCES song (id_song);

ALTER TABLE jury_presentation ADD CONSTRAINT FK_ASS_26 FOREIGN KEY (presentation_id_presentation)
	REFERENCES presentation (id_presentation)
	ON DELETE CASCADE;

