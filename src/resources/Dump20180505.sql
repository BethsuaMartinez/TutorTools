-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: TutorTools
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
  `idStudent` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Students`
--

LOCK TABLES `Students` WRITE;
/*!40000 ALTER TABLE `Students` DISABLE KEYS */;
INSERT INTO `Students` VALUES (3333,'andre','gignac','andre@gmail.com','512'),(4546,'Elyvic','Cabais','elyvic.cabais@aol.com','956-889-988'),(7656,'John','Wilson','john@gmail.com','(454) 342-4356'),(12345,'luis','selvera','luis.selvera@aol.com','512-345-6789'),(43567,'pablo','pablo','pablo1@aol.com','9568885566'),(88888,'luis','selvera','gmail','512'),(98097,'monica','revuelta','monica.revuelta@utrgv.edu','956-882-0000'),(98098,'kjklj','lkj','lkj','lkj'),(99999,'luis','selvera','luiselvera@aol.com','809809'),(210048,'monica','revuelta','monica.revuelta@utrgv.edu',''),(909809,'luis','selvera','yahoo','9897'),(9756997,'Osiel','Juarez','osiel.juarez@aol.com','956-453-354'),(9809890,'luis','selvera','gmail.com','9809'),(20327396,'Carlos','Quinto','quinto@gmail.com','');
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
INSERT INTO `Supervisor` VALUES (107115,'Kenneth','Segarra','kenny','kenneth.segarra@aol.com','956-845-548');
/*!40000 ALTER TABLE `Supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TutoringSessions`
--

DROP TABLE IF EXISTS `TutoringSessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TutoringSessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idStudent` int(11) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `tutor` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `startTime` varchar(45) DEFAULT NULL,
  `endTime` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TutoringSessions`
--

LOCK TABLES `TutoringSessions` WRITE;
/*!40000 ALTER TABLE `TutoringSessions` DISABLE KEYS */;
INSERT INTO `TutoringSessions` VALUES (1,9809,'selvera','luis','elyvic','english','13:11','14:15','04/25/2018','0'),(2,23432,'Jacob','Smith','Luis','english','17:12','12:00','04/25/2018','0'),(3,9756997,'Osiel','Juarez','Bethsua','math','14:00','16:00','04/25/2018','1'),(8,4546,'Elyvic','Cabais','carla','english','19:12','19:13','04/25/2018','1'),(9,4546,'Elyvic','Cabais','luis','math','04:14','04:14','04/26/2018','1'),(10,4546,'Elyvic','Cabais','luis','math','04:26','04:26','04/26/2018','0'),(11,4546,'Elyvic','Cabais','luis','math','16:33','16:33','04/28/2018','0'),(12,4546,'Elyvic','Cabais','luis','math','19:58','19:58','04/28/2018','0'),(13,99999,'luis','selvera','luis','math','19:58','19:58','04/28/2018','1');
/*!40000 ALTER TABLE `TutoringSessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tutors`
--

DROP TABLE IF EXISTS `Tutors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tutors` (
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
-- Dumping data for table `Tutors`
--

LOCK TABLES `Tutors` WRITE;
/*!40000 ALTER TABLE `Tutors` DISABLE KEYS */;
INSERT INTO `Tutors` VALUES (8888,'jesus','duenas','jesus@gmail.com','956','','biology'),(9809,'kljlk','jlk','jlkj','kl','','jlk'),(98120,'Bethsua','Martinez','bethsua.martinez@aol.com','956-659-956','tutor2','Math'),(108115,'Luis','Selvera','luis.selvera@aol.com','512-215-512','tutor1','Computer Science'),(9809809,'jlkjlk','jlk','jlk','jlkj','','lkj'),(90809809,'klj','lkjlk','jkl','jlkjklj','','lkj');
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

-- Dump completed on 2018-05-05 16:01:59
