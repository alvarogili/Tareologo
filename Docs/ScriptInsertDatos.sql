CREATE DATABASE  IF NOT EXISTS `tareologo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tareologo`;
-- MySQL dump 10.13  Distrib 5.5.35, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: tareologo
-- ------------------------------------------------------
-- Server version	5.5.35-0ubuntu0.13.10.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Categoria`
--

DROP TABLE IF EXISTS `Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categoria` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categoria`
--

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
INSERT INTO `Categoria` VALUES (1,'Eventos','Eventos generales');
INSERT INTO `Categoria` VALUES (2,'Cumpleaños','');
INSERT INTO `Categoria` VALUES (3,'Reuniones','Reuniones de trabajo');
INSERT INTO `Categoria` VALUES (4,'Fiestas','Juntadas y asados');
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Responsable`
--

DROP TABLE IF EXISTS `Responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Responsable` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Apodo` varchar(45) DEFAULT NULL,
  `Email` varchar(150) NOT NULL,
  `PathFoto` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Responsable`
--

LOCK TABLES `Responsable` WRITE;
/*!40000 ALTER TABLE `Responsable` DISABLE KEYS */;
INSERT INTO `Responsable` VALUES (1,'Alvaro','','alvarogili@gmail.com','File name=, StoreLocation=/home/alvaro/GlassFish/glassfish/domains/domain1/generated/jsp/tareologo-web/upload_ae9ab52_1446950303a__7ffb_00000004.tmp, size=0bytes, isFormField=false, FieldName=addResponsable:foto');
INSERT INTO `Responsable` VALUES (2,'José','pepe','pepe@mail.com','File name=, StoreLocation=/home/alvaro/GlassFish/glassfish/domains/domain1/generated/jsp/tareologo-web/upload_ae9ab52_1446950303a__7ffb_00000011.tmp, size=0bytes, isFormField=false, FieldName=addResponsable:foto');
INSERT INTO `Responsable` VALUES (3,'René','','rene@mail.com','File name=, StoreLocation=/home/alvaro/GlassFish/glassfish/domains/domain1/generated/jsp/tareologo-web/upload_ae9ab52_1446950303a__7ffb_00000018.tmp, size=0bytes, isFormField=false, FieldName=addResponsable:foto');
INSERT INTO `Responsable` VALUES (4,'María','maru','maria@mail.com','File name=, StoreLocation=/home/alvaro/GlassFish/glassfish/domains/domain1/generated/jsp/tareologo-web/upload_ae9ab52_1446950303a__7ffb_00000025.tmp, size=0bytes, isFormField=false, FieldName=addResponsable:foto');
/*!40000 ALTER TABLE `Responsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tarea`
--

DROP TABLE IF EXISTS `Tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tarea` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(256) NOT NULL,
  `Texto` varchar(4000) DEFAULT NULL,
  `Prioridad` varchar(20) NOT NULL,
  `Vencimiento` datetime DEFAULT NULL,
  `Completado` float NOT NULL,
  `Responsable_Id` int(11) NOT NULL,
  `Categoria_Id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Tarea_Responsable_idx` (`Responsable_Id`),
  KEY `fk_Tarea_Categoria1_idx` (`Categoria_Id`),
  CONSTRAINT `fk_Tarea_Categoria1` FOREIGN KEY (`Categoria_Id`) REFERENCES `Categoria` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tarea_Responsable` FOREIGN KEY (`Responsable_Id`) REFERENCES `Responsable` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tarea`
--

LOCK TABLES `Tarea` WRITE;
/*!40000 ALTER TABLE `Tarea` DISABLE KEYS */;
INSERT INTO `Tarea` VALUES (1,'Fiesta de 15 de mi sobrina','Comprar la torta','Urgente','2014-03-08 00:00:00',0,4,4);
INSERT INTO `Tarea` VALUES (2,'Asado de los jueves','','Normal','2014-03-06 00:00:00',0,1,4);
INSERT INTO `Tarea` VALUES (3,'Charla de Java','','Alta','2014-03-13 00:00:00',0,2,3);
INSERT INTO `Tarea` VALUES (4,'Comprar 10 computadoras para curso','Incluir los monitores','Normal','2014-03-29 00:00:00',20,3,1);
INSERT INTO `Tarea` VALUES (5,'Viajar a Bs. As.','Completar formulario','Baja','2014-03-19 00:00:00',50,2,3);
INSERT INTO `Tarea` VALUES (6,'Comprar dizfraz para Milagros','De pricesa','Urgente','2014-02-04 00:00:00',100,3,4);
/*!40000 ALTER TABLE `Tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tareologo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-25 11:12:22
