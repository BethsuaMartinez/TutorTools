CREATE DATABASE  IF NOT EXISTS `tutortools` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tutortools`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tutortools
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `idStudent` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (973,'Jose','Gonzales','',''),(3333,'andre','gignac','andre@gmail.com',''),(4546,'Elyvic','Cabais','elyvic.cabais@aol.com',''),(6576,'Hugo','Ayala','hugo@gmail.com',''),(6732,'Anselmo','Vendrechosky','',''),(6767,'Jose','Rodriguez','',''),(7656,'John','Cena','john@gmail.com','(454)342-4356'),(8793,'Lupita','Hernadez','',''),(12345,'luis','selvera','luis.selvera@aol.com','(956)888-8888'),(43567,'pablo','pablo','pablo1@aol.com',''),(87245,'Israel','Jimenez','jimenez@gmail.com',''),(98097,'monica','revuelta','monica.revuelta@utrgv.edu',''),(210048,'monica','revuelta','monica.revuelta@utrgv.edu',''),(987987,'Benito','Juarez','benito@gmail.com',''),(20327396,'Carlos','Quinto','quinto@gmail.com','');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisor`
--

DROP TABLE IF EXISTS `supervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supervisor` (
  `idSupervisor` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSupervisor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisor`
--

LOCK TABLES `supervisor` WRITE;
/*!40000 ALTER TABLE `supervisor` DISABLE KEYS */;
INSERT INTO `supervisor` VALUES (7878,'Vicente','Lopez','root','vicente@gmail.com',''),(44444,'Daniel','Selvera','root','daniel@gmail.com',''),(77777,'Michael','Wilson','root','michael@aol.com',NULL),(78468,'Carlos','Armendariz','root','armendariz@aol.com',''),(87987,NULL,NULL,'q','q',NULL),(98789,'Jorge','Bush','root','jorge@gmail.com',''),(107115,'Kenneth','Segarra','root','kenneth.segarra@aol.com',''),(768778,'Maria','Martinez','root','maria@aol.com','');
/*!40000 ALTER TABLE `supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutoringsessions`
--

DROP TABLE IF EXISTS `tutoringsessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tutoringsessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idStudent` int(11) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `tutor` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `startTime` varchar(45) DEFAULT NULL,
  `endTime` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutoringsessions`
--

LOCK TABLES `tutoringsessions` WRITE;
/*!40000 ALTER TABLE `tutoringsessions` DISABLE KEYS */;
INSERT INTO `tutoringsessions` VALUES (2,23432,'Jacob','Smith','Luis','english','17:12','22:33','2018-02-07','1'),(8,4546,'Elyvic','Cabais','Michael','english','19:12','19:13','2018-04-22','1'),(10,4546,'Elyvic','Cabais','Kahn','English','04:26','01:04','2018-05-12','1'),(15,4546,'Elyvic','Cabais','Bethsua','Science','01:54','01:55','2018-07-07','1'),(16,6576,'Hugo','Ayala','Luis','English','22:31','22:33','2018-08-07','1'),(17,6732,'Anselmo','Vendrechosky','Luis','Computer Science','22:32','22:33','2018-09-07','1'),(18,98732,'Juan','Rodriguez','Elyvic','Computer Science','22:33','22:33','2018-10-07','1'),(19,3333,'andre','gignac','Kristina','biology','23:34','23:35','2018-11-07','1'),(20,6576,'Hugo','Ayala','Rafael','english','23:34','23:35','2018-12-07','1'),(21,6732,'Anselmo','Vendrechosky','Bethsua','Science','23:34','23:35','2018-01-07','1'),(22,7656,'John','Cena','Kevin','english','23:35','23:35','2018-12-07','1'),(23,3333,'andre','gignac','Kevin','Political Science','23:37','23:37','2018-04-07','1'),(24,4546,'Elyvic','Cabais','Javier','Chemistry','23:41','23:41','2018-06-07','1'),(25,4546,'Elyvic','Cabais','Kristina','Math','00:34','00:34','2018-01-08','1'),(27,210048,'monica','revuelta','Rafael','Math','00:46','00:46','2018-06-08','1'),(28,98732,'Luis','Rodriguez','Junior','Chemistry','00:46','00:46','2018-03-08','1'),(29,8793,'Lupita','Hernadez','Bethsua','Chemistry','00:47','00:47','2018-11-08','1'),(30,7656,'John','Cena','Jurgen','biology','00:47','00:47','2018-12-08','1'),(31,43567,'pablo','pablo','Javier','Political Science','00:47','00:47','2018-10-08','1'),(32,3333,'andre','gignac','Rafael','Chemistry','02:33','','2018-05-08','0'),(34,4546,'Elyvic','Cabais','Kevin','java','10:35','10:35','2018-05-08','1'),(35,973,'Jose','Gonzales','Kristina','java','15:08','15:08','2018-05-08','1');
/*!40000 ALTER TABLE `tutoringsessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutors`
--

DROP TABLE IF EXISTS `tutors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tutors` (
  `idTutor` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTutor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutors`
--

LOCK TABLES `tutors` WRITE;
/*!40000 ALTER TABLE `tutors` DISABLE KEYS */;
INSERT INTO `tutors` VALUES (2341,'Kevin','Garcia','kevin@gmail.com','','root','English'),(8888,'jesus','duenas','jesus@gmail.com','','root','biology'),(8987,'Juan','Lopez','lopez@gmail.com','','','java'),(23432,'Kristina','Vatchev','vatchev@gmail.com','','root','biology'),(45623,'Rafael','Sobis','sobis@gmail.com','(453)435-4365','root','Math'),(76787,'Junior','Putin','junior@gmail.com','','root','Math'),(98120,'Bethsua','Martinez','bethsua.martinez01@utrgv.edu','','root','english'),(98798,'Jurgen','Damm','damm@gmail.com','','root','Political Science'),(108115,'Luis','Selvera','luis.selvera@aol.com','(512)215-5124','root','Computer Science'),(898787,'Jesus','Gonzales','jesusgo@gmail.com','','root','Chemistry');
/*!40000 ALTER TABLE `tutors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-08 21:21:07
