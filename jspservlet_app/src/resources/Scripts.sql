create database ecomm;


CREATE TABLE `ecomm`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `age` INT NULL,
  `gender` VARCHAR(45) NULL,
  `isMarried` VARCHAR(45) NULL,
  PRIMARY KEY (`userId`));
