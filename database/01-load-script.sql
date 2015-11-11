INSERT INTO `users` (`USERNAME`, `user_type`, `GROUP_NAME`, `PASSWORD`)
VALUES ('admin1', 'admin', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  ('jury1', 'jury', 'jury', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  ('participant1', 'participant', 'participant', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');

INSERT INTO `admin` (`USERNAME`, `DESCRIPTION`, `NAME`)
VALUES ('admin1', 'A great admin', 'the Admin N1 ');

INSERT INTO `jury` (`USERNAME`, `DESCRIPTION`, `NAME`)
VALUES ('jury1', 'the great Jury1', 'Name jury1');

INSERT INTO `participant` (`USERNAME`, `AGE`, `COUNTRY`, `GENDER`, `IMAGE_URL`, `NAME`)
VALUES ('participant1', 53, 'Colombia', 'Male', 'hello', 'Pepe The First');
