SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `tareologo_test` DEFAULT CHARACTER SET utf8 ;
USE `tareologo_test` ;

-- -----------------------------------------------------
-- Table `tareologo_test`.`Categoria`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tareologo_test`.`Categoria` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL ,
  `Descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tareologo_test`.`Responsable`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tareologo_test`.`Responsable` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(100) NOT NULL ,
  `Apodo` VARCHAR(45),
  `Email` VARCHAR(150) NOT NULL ,
  `PathFoto` VARCHAR(256) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tareologo_test`.`Tarea`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tareologo_test`.`Tarea` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT ,
  `Titulo` VARCHAR(256) NOT NULL ,
  `Texto` VARCHAR(4000) NULL DEFAULT NULL ,
  `Prioridad` INT(11) NOT NULL ,
  `Vencimiento` DATETIME NULL DEFAULT NULL ,
  `Completado` FLOAT NOT NULL ,
  `Responsable_Id` INT(11) NOT NULL ,
  `Categoria_Id` INT(11) NOT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `fk_Tarea_Responsable_idx` (`Responsable_Id` ASC) ,
  INDEX `fk_Tarea_Categoria1_idx` (`Categoria_Id` ASC) ,
  CONSTRAINT `fk_Tarea_Categoria1`
    FOREIGN KEY (`Categoria_Id` )
    REFERENCES `tareologo_test`.`Categoria` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tarea_Responsable`
    FOREIGN KEY (`Responsable_Id` )
    REFERENCES `tareologo_test`.`Responsable` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `tareologo_test` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
