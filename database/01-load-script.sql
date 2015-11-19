INSERT INTO `user` (`user_id`, `username`, `user_type`, `group_name`, `password`)
VALUES (NULL, 'admin1', 'admin', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  (NULL, 'jury1', 'jury', 'jury', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  (NULL, 'participant1', 'participant', 'participant', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');

INSERT INTO `admin` (user_id, admin_info) VALUES (1, 'A great admin');

INSERT INTO `jury` (user_id, jury_info) VALUES (2, 'the great Jury1');

INSERT INTO `participant` (user_id, age, gender, image_url)  VALUES (3, 18, 'Male', 'http://www.oracle.com/ocom/groups/public/@ocom/documents/digitalasset/427163.jpg');
