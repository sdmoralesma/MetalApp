INSERT INTO `user` (`user_id`, `username`, `user_type`, `group_name`, `password`)
VALUES (NULL, 'admin1', 'admin', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  (NULL, 'jury1', 'jury', 'jury', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  (NULL, 'participant1', 'participant', 'participant', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');

INSERT INTO `presentation` (id_presentation, score, song) VALUES (NULL, 1.0, 'bicycle race');

INSERT INTO `score_matrix` (id_score_matrix, total_score) VALUES (NULL, 10);

INSERT INTO `admin` (user_id, admin_info) VALUES (1, 'A great admin');

INSERT INTO `jury` (user_id, jury_info, presentation_id) VALUES (2, 'the great Jury1', 1);

INSERT INTO `participant` (user_id, age, gender, image_url, presentation_id, score_matrix_id)
VALUES (3, 18, 'Male', 'http://www.oracle.com/ocom/groups/public/@ocom/documents/digitalasset/427163.jpg', 1, 1);
