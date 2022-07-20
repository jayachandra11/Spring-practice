CREATE TABLE `user` (
  `id` INT AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL,
  `roles` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));