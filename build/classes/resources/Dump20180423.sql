-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: TutorTools
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `Students`
--

DROP TABLE IF EXISTS `Students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Students` (
  `idStudents` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStudents`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Students`
--

LOCK TABLES `Students` WRITE;
/*!40000 ALTER TABLE `Students` DISABLE KEYS */;
INSERT INTO `Students` VALUES (3571113,'Elyvic','Cabais','elyvic.cabais@aol.com','956-889-988'),(9756997,'Osiel','Juarez','osiel.juarez@aol.com','956-453-354');
/*!40000 ALTER TABLE `Students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Supervisor`
--

DROP TABLE IF EXISTS `Supervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Supervisor` (
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
-- Dumping data for table `Supervisor`
--

LOCK TABLES `Supervisor` WRITE;
/*!40000 ALTER TABLE `Supervisor` DISABLE KEYS */;
INSERT INTO `Supervisor` VALUES (2342,NULL,NULL,'456','def',NULL),(107115,'Kenneth','Segarra','kenny','kenneth.segarra@aol.com','956-845-548');
/*!40000 ALTER TABLE `Supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TutoringSessions`
--

DROP TABLE IF EXISTS `TutoringSessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TutoringSessions` (
  `id` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `tutorlname` varchar(45) DEFAULT NULL,
  `startTime` varchar(45) DEFAULT NULL,
  `endTime` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TutoringSessions`
--

LOCK TABLES `TutoringSessions` WRITE;
/*!40000 ALTER TABLE `TutoringSessions` DISABLE KEYS */;
INSERT INTO `TutoringSessions` VALUES (1,9809,'selvera','luis','elyvic','04/22/2018 13:11:30','','english'),(2,23432,'Jacob','Smith','Luis','04/22/2018 17:12:50','12:00','english'),(3,9756997,'Osiel','Juarez','Bethsua','2:00 PM',NULL,'math'),(4,23432,'Jacob','Smith','Luis','04/22/2018 18:37:27','12:00','english'),(5,23432,'Jacob','Smith','Luis','12:00','04/22/2018 18:38:35','english'),(6,23432,'Jacob','Smith','Luis','12:00','04/23/2018 14:13:14','english');
/*!40000 ALTER TABLE `TutoringSessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tutors`
--

DROP TABLE IF EXISTS `Tutors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tutors` (
  `idTutors` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTutors`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tutors`
--

LOCK TABLES `Tutors` WRITE;
/*!40000 ALTER TABLE `Tutors` DISABLE KEYS */;
INSERT INTO `Tutors` VALUES (23,'',NULL,'abc',NULL,'123',NULL),(98120,'Bethsua','Martinez','bethsua.martinez@aol.com','956-659-956','tutor2','Math'),(108115,'Luis','Selvera','luis.selvera@aol.com','512-215-512','tutor1','Computer Science');
/*!40000 ALTER TABLE `Tutors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-23 15:21:53
