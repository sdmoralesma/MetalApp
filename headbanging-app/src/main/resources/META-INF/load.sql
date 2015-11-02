-- Data for table `users`
INSERT INTO `users` (`USERNAME`, `user_type`, `GROUP_NAME`, `PASSWORD`) VALUES ('admin1','admin','admin','admin'),('admin2','admin','admin','admin'),('jury1','jury','jury','jury'),('jury2','jury','jury','jury'),('pepe1','participant','participant','participant'),('pepe2','participant','participant','participant');

-- Data for table `admin`
INSERT INTO `admin` (`USERNAME`, `DESCRIPTION`, `NAME`) VALUES ('admin1','A great admin','the Admin N1 '),('admin2','Other admin','the Admin N2');

-- Data for table `jury`
INSERT INTO `jury` (`USERNAME`, `DESCRIPTION`, `NAME`) VALUES ('jury1','the great Jury1','Name jury1'),('jury2','other jury','Name jury2');

-- Data for table `participant`
INSERT INTO `participant` (`USERNAME`, `AGE`, `COUNTRY`, `GENDER`, `IMAGE_URL`, `NAME`) VALUES ('pepe1',53,'Colombia','Male','hello','Pepe The First'),('pepe2',35,'Peru','Female',NULL,'Pepe The Second');

-- Data for table `artist`
INSERT INTO `artist` (`NAME`, `DESCRIPTION`) VALUES ('Adagio','French Band'),('Arch Enemy','Swedish Band');

-- Data for table `gender`
INSERT INTO `gender` (`NAME`, `hand_value`, `head_value`) VALUES ('Death Metal',5,5),('Thrash Metal',8,5),('Black Metal',3,8);

-- Data for table `song`
INSERT INTO `song` (`TITLE`, `id_artist`, `id_gender`) VALUES ('Other title','Arch Enemy','Death Metal'),('The Astral PathWay','Adagio','Death Metal');