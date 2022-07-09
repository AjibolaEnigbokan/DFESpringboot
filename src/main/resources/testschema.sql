DROP TABLE IF EXISTS `customer`;

DROP TABLE IF EXISTS `student`;


CREATE TABLE `customer` (
	`id` BIGINT AUTO_INCREMENT,
	`first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) UNIQUE NOT NULL,
	 PRIMARY KEY(`id`)
);


CREATE TABLE `student` (
	`id` BIGINT AUTO_INCREMENT,
	`first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255) NOT NULL,
	`address` VARCHAR(255) NOT NULL,
	 PRIMARY KEY(`id`)
);



