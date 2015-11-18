INSERT INTO `user` (`username`, `user_type`, `group_name`, `password`)
VALUES ('admin1', 'admin', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  ('jury1', 'jury', 'jury', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  ('participant1', 'participant', 'participant', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');

INSERT INTO `admin` (`username`, `description`, `name`)
VALUES ('admin1', 'A great admin', 'the Admin N1 ');

INSERT INTO `jury` (`username`, `description`, `name`)
VALUES ('jury1', 'the great Jury1', 'Name jury1');

INSERT INTO `participant` (`username`, `age`, `gender`, `image_url`, `name`)
VALUES ('participant1', 53, 'Male', 'hello', 'Pepe The First');
