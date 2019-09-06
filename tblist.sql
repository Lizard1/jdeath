account-- MySQL Script generated by MySQL Workbench
-- Wed Aug 28 17:35:41 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema thebanklist
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema thebanklist
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `thebanklist` DEFAULT CHARACTER SET utf8 ;
USE `thebanklist` ;

-- -----------------------------------------------------
-- Table `thebanklist`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thebanklist`.`user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `thebanklist`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thebanklist`.`account` (
  `accountid` INT NOT NULL,
  `account` INT NULL,
  `userid` INT NULL,
  PRIMARY KEY (`accountid`),
  INDEX `userid_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `userid`
    FOREIGN KEY (`userid`)
    REFERENCES `thebanklist`.`user` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
