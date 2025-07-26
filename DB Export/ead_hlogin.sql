-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ead
-- ------------------------------------------------------
-- Server version	5.5.50

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hlogin`
--

DROP TABLE IF EXISTS `hlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hlogin` (
  `Username` varchar(45) NOT NULL,
  `Telno` int(11) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Password` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hlogin`
--

LOCK TABLES `hlogin` WRITE;
/*!40000 ALTER TABLE `hlogin` DISABLE KEYS */;
INSERT INTO `hlogin` VALUES ('ABCD',789004543,NULL,NULL),('Abcdef',97654213,NULL,NULL),('abcdfgt',745678921,NULL,NULL),('Acarsha ken',764562718,'Kendra@gmail.com','ken1234'),('Andrew Garfield',761234568,NULL,NULL),('Ann Gamage',552223344,NULL,NULL),('Binithi Edirimuni',768009000,NULL,NULL),('David Williamson',552234567,NULL,NULL),('Dhiyana ',71234567,NULL,NULL),('Dhiyana Hafeel',765373689,NULL,NULL),('Ferasha',761234567,NULL,NULL),('janvdtaj',763452115,NULL,NULL),('Jessica Fernando',779004044,NULL,NULL),('Kendra',723456781,'Kendra@gmail.com','ken1234'),('Kendra Acasha',723567009,NULL,NULL),('Neranjala Madhurangani',776460092,NULL,NULL),('Nesaara Rahal',745098764,NULL,NULL),('Nihali Otara',721345678,NULL,NULL),('Nirmal ',77778975,NULL,NULL),('Olu',55522243,NULL,NULL),('Prasanna Ranjith',769004044,NULL,NULL),('Ranujitha',77800900,NULL,NULL),('Ranujitha Biman',740447892,NULL,NULL),('Ranujitha Bimath',740447077,NULL,NULL),('Rehana Ekanayake',745689004,NULL,NULL),('Ruhasha Wikramanayaka',789004044,NULL,NULL),('Ruvini',71234567,NULL,NULL),('Ruwangi',789024351,'Ruwangi@gmail.com','ruwa1234'),('Saduni Imasha',754009876,NULL,NULL),('Tenuri Vimansa',768901234,NULL,NULL),('Tharundi Hashinka',767764609,NULL,NULL),('Thisuli Lesara',789004044,NULL,NULL),('Thushara Fernando',745689003,NULL,NULL),('Umasha Umayangani',70090044,NULL,NULL),('Umesha Siriwardhana',723456789,NULL,NULL),('Vimansa Tenuri',765373689,NULL,NULL),('Kendra',745267482,'Kendra@gmail.com','ken1234'),('Kevin Fernando',734526173,'kevin@gmail.com','kevinkevin'),('Kevindra Acasha',563715155,'Kendra@gmail.com','ken1234'),('Kendra Acasha',723456723,'Kendra@gmail.com','ken1234'),('Kendra Acasha',769002345,'Kendra@gmail.com','ken1234'),('Kendra Achasa',745627183,'Kendra@gmail.com','ken1234'),('Ruwangi Karunanayaka',721234566,'Ruwangiii@gmail.com','09876'),('Kendra Acasha',761234568,'Kendra@gmail.com','ken1234');
/*!40000 ALTER TABLE `hlogin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-26 19:50:51
