
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `first_name` varchar(80) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `person` (`id`, `address`, `first_name`, `gender`, `last_name`) VALUES
	(1, 'Osasco', 'Gabriel', 'male', 'Darlan'),
	(4, 'Osasco', 'Bruna', 'female', 'Butterfly'),
	(5, 'USA', 'Terry', 'male', 'Bogard'),
	(6, 'USA', 'Andy', 'male', 'Bogard'),
	(9, 'Japan', 'Liu', 'male', 'Kang'),
	(10, 'Osasco', 'Gabriel', 'male', 'Darlan'),
	(11, 'Osasco', 'Ryuko', 'male', 'Matoi'),
	(12, 'Osasco', 'Satsuki', 'male', 'Kiryuin');
