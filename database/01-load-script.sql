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

INSERT INTO `artist` (`NAME`, `DESCRIPTION`) 
VALUES ('Adagio', 'French Band'), ('Arch Enemy', 'Swedish Band');

INSERT INTO `gender` (`NAME`, `hand_value`, `head_value`)
VALUES ('Death Metal', 5, 5), ('Thrash Metal', 8, 5), ('Black Metal', 3, 8);

INSERT INTO `song` (`TITLE`, `id_artist`, `id_gender`)
VALUES ('Other title', 'Arch Enemy', 'Death Metal'), ('The Astral PathWay', 'Adagio', 'Death Metal');
