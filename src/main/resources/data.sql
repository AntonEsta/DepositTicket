INSERT IGNORE INTO currencies(iso_code_number, iso_code_char, name) VALUES (643, "RUB", "rubles");

INSERT IGNORE INTO `users` VALUES
(1,'ramesh@gmail.com','ramesh','$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em','ramesh'),
(2,'admin@gmail.com','admin','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','admin');

INSERT IGNORE INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT IGNORE INTO `users_roles` VALUES (2,1),(1,2);