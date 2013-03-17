--Precaution: First create the database from a SQL Console
--CREATE DATABASE IF NOT EXISTS metal;
--USE metal;

DROP TABLE IF EXISTS `metal`.`jury`;
DROP TABLE IF EXISTS `metal`.`presentation`;
DROP TABLE IF EXISTS `metal`.`jury_presentation`;
DROP TABLE IF EXISTS `metal`.`groups`;
DROP TABLE IF EXISTS `metal`.`song`;
DROP TABLE IF EXISTS `metal`.`participant`;
DROP TABLE IF EXISTS `metal`.`gender`;
DROP TABLE IF EXISTS `metal`.`artist`;
DROP TABLE IF EXISTS `metal`.`score_matrix`;
DROP TABLE IF EXISTS `metal`.`users`;
DROP TABLE IF EXISTS `metal`.`song_matrix`;

-- security Realm Tables
CREATE TABLE `metal`.`groups` (
	`id_group` VARCHAR(50),
	`username` VARCHAR(50)
) ENGINE=InnoDB;

ALTER TABLE groups ADD CONSTRAINT GroupsRealm_PK PRIMARY KEY
(
  username
);

CREATE TABLE `metal`.`users` (
	`username` VARCHAR(50),
	`password` VARCHAR(100)
) ENGINE=InnoDB;

ALTER TABLE users ADD CONSTRAINT UsersRealm_PK PRIMARY KEY
(
  username
);

-- Domain Tables
CREATE TABLE artist
(
	id_artist INTEGER NOT NULL ,
    name      VARCHAR (50) NOT NULL
) ;
ALTER TABLE artist ADD CONSTRAINT Artist_PK PRIMARY KEY
(
  id_artist
)
;
CREATE TABLE gender
  (
    id_gender  INTEGER NOT NULL ,
    name       VARCHAR (50) NOT NULL ,
    hang_value INTEGER NOT NULL ,
    head_value INTEGER NOT NULL
  ) ;
ALTER TABLE gender ADD CONSTRAINT Gender_PK PRIMARY KEY
(
  id_gender
)
;
CREATE TABLE jury
  (
    id_jury  INTEGER NOT NULL ,
    name     VARCHAR (100) NOT NULL ,
    username VARCHAR (50) NOT NULL ,
    password VARCHAR (50) NOT NULL
  ) ;
ALTER TABLE jury ADD CONSTRAINT Jury_PK PRIMARY KEY
(
  id_jury
)
;
CREATE TABLE jury_presentation
  (
    presentation_id_presentation INTEGER NOT NULL ,
    jury_id_jury                 INTEGER NOT NULL
  ) ;
ALTER TABLE jury_presentation ADD CONSTRAINT jury_presentation__IDX PRIMARY KEY
(
  presentation_id_presentation, jury_id_jury
)
;
CREATE TABLE participant
  (
    id_participat INTEGER NOT NULL ,
    name          VARCHAR (100) NOT NULL ,
    phone         INTEGER NOT NULL ,
    age           INTEGER NOT NULL ,
    gender        VARCHAR (50) NOT NULL ,
    username      VARCHAR (50) NOT NULL ,
    password      VARCHAR (50) NOT NULL
  ) ;
ALTER TABLE participant ADD CONSTRAINT Participant_PK PRIMARY KEY
(
  id_participat
)
;
CREATE TABLE presentation
  (
    id_presentation INTEGER NOT NULL ,
    id_participant  INTEGER NOT NULL ,
    id_song         INTEGER NOT NULL ,
    id_jury         INTEGER NOT NULL ,
    hand_score FLOAT NOT NULL ,
    head_score FLOAT NOT NULL ,
    total_score FLOAT NOT NULL ,
    id_participat INTEGER ,
    id_song1      INTEGER
  ) ;
ALTER TABLE presentation ADD CONSTRAINT Prsentation_PK PRIMARY KEY
(
  id_presentation
)
;
CREATE TABLE score_matrix
  (
    id_participant INTEGER NOT NULL ,
    head1          INTEGER ,
    head2          INTEGER ,
    head3          INTEGER ,
    head4          INTEGER ,
    head5          INTEGER ,
    head6          INTEGER ,
    head7          INTEGER ,
    head8          INTEGER ,
    head9          INTEGER ,
    head10         INTEGER ,
    hand1          INTEGER ,
    hand2          INTEGER ,
    hand3          INTEGER ,
    hand4          INTEGER ,
    hand5          INTEGER ,
    hand6          INTEGER ,
    hand7          INTEGER ,
    hand8          INTEGER ,
    hand9          INTEGER ,
    hand10         INTEGER ,
    hand_score FLOAT ,
    head_score FLOAT ,
    total_score FLOAT ,
    id_participat INTEGER
  ) ;
ALTER TABLE score_matrix ADD CONSTRAINT Score_Matriz_PK PRIMARY KEY
(
  id_participant
)
;
CREATE TABLE song
  (
    id_song    INTEGER NOT NULL ,
    title      VARCHAR (100) NOT NULL ,
    id_artist  INTEGER NOT NULL ,
    id_gender  INTEGER NOT NULL ,
    id_artist1 INTEGER ,
    id_gender1 INTEGER
  ) ;
ALTER TABLE song ADD CONSTRAINT Song_PK PRIMARY KEY
(
  id_song
)
;
CREATE TABLE song_matrix
  (
    id_song       INTEGER NOT NULL ,
    musicality1   INTEGER ,
    musicality2   INTEGER ,
    musicality3   INTEGER ,
    musicality4   INTEGER ,
    musicality5   INTEGER ,
    musicality6   INTEGER ,
    musicality7   INTEGER ,
    musicality8   INTEGER ,
    musicality9   INTEGER ,
    musicality10  INTEGER ,
    composition1  INTEGER ,
    composition2  INTEGER ,
    composition3  INTEGER ,
    composition4  INTEGER ,
    composition5  INTEGER ,
    composition6  INTEGER ,
    composition7  INTEGER ,
    composition8  INTEGER ,
    composition9  INTEGER ,
    composition10 INTEGER ,
    musicality_score FLOAT ,
    composition_score FLOAT ,
    total_score FLOAT ,
    id_song1 INTEGER
  ) ;
ALTER TABLE song_matrix ADD CONSTRAINT Song_Matriz_PK PRIMARY KEY
(
  id_song
)
;
ALTER TABLE jury_presentation ADD CONSTRAINT FK_ASS_26 FOREIGN KEY
(
  presentation_id_presentation
)
REFERENCES presentation
(
  id_presentation
)
ON
DELETE CASCADE ;
ALTER TABLE jury_presentation ADD CONSTRAINT FK_ASS_27 FOREIGN KEY ( jury_id_jury ) REFERENCES jury ( id_jury ) ON
DELETE CASCADE ;
ALTER TABLE song ADD CONSTRAINT artist_song FOREIGN KEY ( id_artist1 ) REFERENCES artist ( id_artist ) ;
ALTER TABLE song ADD CONSTRAINT gender_song FOREIGN KEY ( id_gender1 ) REFERENCES gender ( id_gender ) ;
ALTER TABLE presentation ADD CONSTRAINT participant_presentation FOREIGN KEY ( id_participat ) REFERENCES participant ( id_participat ) ;
ALTER TABLE score_matrix ADD CONSTRAINT participant_scorematrix FOREIGN KEY ( id_participat ) REFERENCES participant ( id_participat ) ;
ALTER TABLE presentation ADD CONSTRAINT song_presentation FOREIGN KEY ( id_song1 ) REFERENCES song ( id_song ) ;
ALTER TABLE song_matrix ADD CONSTRAINT song_songmatrix FOREIGN KEY ( id_song1 ) REFERENCES song ( id_song ) ;
