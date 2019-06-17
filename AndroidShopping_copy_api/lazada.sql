CREATE DATABASE  IF NOT EXISTS `LAZADA` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `LAZADA`;
-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: LAZADA
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BINHLUAN`
--

DROP TABLE IF EXISTS `BINHLUAN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `BINHLUAN` (
  `MABL` int(11) NOT NULL AUTO_INCREMENT,
  `TIEUDE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MABL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BINHLUAN`
--

LOCK TABLES `BINHLUAN` WRITE;
/*!40000 ALTER TABLE `BINHLUAN` DISABLE KEYS */;
/*!40000 ALTER TABLE `BINHLUAN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETBINHLUAN`
--

DROP TABLE IF EXISTS `CHITIETBINHLUAN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CHITIETBINHLUAN` (
  `MABL` int(11) NOT NULL,
  `MANV` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `NOIDUNG` text COLLATE utf8mb4_general_ci,
  `NGAYBL` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`MABL`,`MANV`,`MASP`),
  KEY `KHOANGOAI_CHITIETBINHLUAN_MANV` (`MANV`),
  KEY `KHOANGOAI_CHITIETBINHLUAN_MASP` (`MASP`),
  CONSTRAINT `KHOANGOAI_CHITIETBINHLUAN_MABL` FOREIGN KEY (`MABL`) REFERENCES `binhluan` (`MABL`),
  CONSTRAINT `KHOANGOAI_CHITIETBINHLUAN_MANV` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  CONSTRAINT `KHOANGOAI_CHITIETBINHLUAN_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETBINHLUAN`
--

LOCK TABLES `CHITIETBINHLUAN` WRITE;
/*!40000 ALTER TABLE `CHITIETBINHLUAN` DISABLE KEYS */;
/*!40000 ALTER TABLE `CHITIETBINHLUAN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETHOADON`
--

DROP TABLE IF EXISTS `CHITIETHOADON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CHITIETHOADON` (
  `MAHD` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  PRIMARY KEY (`MAHD`,`MASP`),
  KEY `KHOANGOAI_CHITIETHOADON_MASP` (`MASP`),
  CONSTRAINT `KHOANGOAI_CHITIETHOADON_MAHD` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`),
  CONSTRAINT `KHOANGOAI_CHITIETHOADON_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETHOADON`
--

LOCK TABLES `CHITIETHOADON` WRITE;
/*!40000 ALTER TABLE `CHITIETHOADON` DISABLE KEYS */;
/*!40000 ALTER TABLE `CHITIETHOADON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETKHUYENMAI`
--

DROP TABLE IF EXISTS `CHITIETKHUYENMAI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CHITIETKHUYENMAI` (
  `MASP` int(11) NOT NULL,
  `MAKM` int(11) NOT NULL,
  `PHANTRAMKM` int(2) DEFAULT NULL,
  PRIMARY KEY (`MASP`,`MAKM`),
  KEY `KHOANGOAI_CHITIETKHUYENMAI_MAKM` (`MAKM`),
  CONSTRAINT `KHOANGOAI_CHIETIETKUYENMAI_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`),
  CONSTRAINT `KHOANGOAI_CHITIETKHUYENMAI_MAKM` FOREIGN KEY (`MAKM`) REFERENCES `khuyenmai` (`MAKM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETKHUYENMAI`
--

LOCK TABLES `CHITIETKHUYENMAI` WRITE;
/*!40000 ALTER TABLE `CHITIETKHUYENMAI` DISABLE KEYS */;
INSERT INTO `CHITIETKHUYENMAI` VALUES (1,1,49),(2,1,49),(3,1,49),(4,1,49),(5,1,49),(6,1,49),(7,1,49),(8,1,49),(9,1,49),(10,1,49),(11,2,50),(12,2,50),(13,2,50),(14,2,50),(15,2,50),(16,2,50),(17,2,50),(18,2,50),(19,2,50),(20,2,50),(21,3,40),(21,4,30),(22,3,40),(22,4,30),(23,3,40),(23,4,30),(24,3,40),(24,4,30),(25,3,40),(25,4,30),(26,3,40),(26,4,30),(27,3,40),(27,4,30),(28,3,40),(28,4,30),(29,3,40),(29,4,30),(30,3,40),(30,4,30);
/*!40000 ALTER TABLE `CHITIETKHUYENMAI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETSANPHAM`
--

DROP TABLE IF EXISTS `CHITIETSANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CHITIETSANPHAM` (
  `MASP` int(11) NOT NULL,
  `TENCHITIET` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `GIATRI` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`MASP`,`TENCHITIET`),
  CONSTRAINT `KHOANGOAI_CHITIETSANPHAM_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETSANPHAM`
--

LOCK TABLES `CHITIETSANPHAM` WRITE;
/*!40000 ALTER TABLE `CHITIETSANPHAM` DISABLE KEYS */;
INSERT INTO `CHITIETSANPHAM` VALUES (1,'3D TV','No'),(1,'Bảo hành','12 tháng'),(1,'Bộ nhớ trong','64GB'),(1,'Camera Back','11 - 15 MP'),(1,'Camera Front','5 - 6 MP'),(1,'Curved TV','No'),(1,'Hệ điều hành','IOS'),(1,'Kích thước màn hình','4.7'),(1,'Mẫu mã','6s'),(1,'Network Connections','3G-HSPA|4G-LTE'),(1,'Operation System Version','IOS9'),(1,'RAM memory','2GB'),(1,'Sản xuất tại','Trung quốc'),(1,'Sim Slots','1'),(1,'Sim type','SIM nano'),(1,'Trọng lượng (KG)','0.2'),(1,'Điều kiện','Mới'),(2,'3D TV','No'),(2,'Bảo hành','12 tháng'),(2,'Bộ nhớ trong','64GB'),(2,'Camera Back','11 - 15 MP'),(2,'Camera Front','5 - 6 MP'),(2,'Curved TV','No'),(2,'Hệ điều hành','IOS'),(2,'Kích thước màn hình','4.7'),(2,'Mẫu mã','6s'),(2,'Network Connections','3G-HSPA|4G-LTE'),(2,'Operation System Version','IOS9'),(2,'RAM memory','2GB'),(2,'Sản xuất tại','Trung quốc'),(2,'Sim Slots','1'),(2,'Sim type','SIM nano'),(2,'Trọng lượng (KG)','0.2'),(2,'Điều kiện','Mới'),(3,'3D TV','No'),(3,'Bảo hành','12 tháng'),(3,'Bộ nhớ trong','64GB'),(3,'Camera Back','11 - 15 MP'),(3,'Camera Front','5 - 6 MP'),(3,'Curved TV','No'),(3,'Hệ điều hành','IOS'),(3,'Kích thước màn hình','4.7'),(3,'Mẫu mã','6s'),(3,'Network Connections','3G-HSPA|4G-LTE'),(3,'Operation System Version','IOS9'),(3,'RAM memory','2GB'),(3,'Sản xuất tại','Trung quốc'),(3,'Sim Slots','1'),(3,'Sim type','SIM nano'),(3,'Trọng lượng (KG)','0.2'),(3,'Điều kiện','Mới'),(4,'3D TV','No'),(4,'Bảo hành','12 tháng'),(4,'Bộ nhớ trong','64GB'),(4,'Camera Back','11 - 15 MP'),(4,'Camera Front','5 - 6 MP'),(4,'Curved TV','No'),(4,'Hệ điều hành','IOS'),(4,'Kích thước màn hình','4.7'),(4,'Mẫu mã','6s'),(4,'Network Connections','3G-HSPA|4G-LTE'),(4,'Operation System Version','IOS9'),(4,'RAM memory','2GB'),(4,'Sản xuất tại','Trung quốc'),(4,'Sim Slots','1'),(4,'Sim type','SIM nano'),(4,'Trọng lượng (KG)','0.2'),(4,'Điều kiện','Mới'),(5,'3D TV','No'),(5,'Bảo hành','12 tháng'),(5,'Bộ nhớ trong','64GB'),(5,'Camera Back','11 - 15 MP'),(5,'Camera Front','5 - 6 MP'),(5,'Curved TV','No'),(5,'Hệ điều hành','IOS'),(5,'Kích thước màn hình','4.7'),(5,'Mẫu mã','6s'),(5,'Network Connections','3G-HSPA|4G-LTE'),(5,'Operation System Version','IOS9'),(5,'RAM memory','2GB'),(5,'Sản xuất tại','Trung quốc'),(5,'Sim Slots','1'),(5,'Sim type','SIM nano'),(5,'Trọng lượng (KG)','0.2'),(5,'Điều kiện','Mới'),(6,'3D TV','No'),(6,'Bảo hành','12 tháng'),(6,'Bộ nhớ trong','64GB'),(6,'Camera Back','11 - 15 MP'),(6,'Camera Front','5 - 6 MP'),(6,'Curved TV','No'),(6,'Hệ điều hành','IOS'),(6,'Kích thước màn hình','4.7'),(6,'Mẫu mã','6s'),(6,'Network Connections','3G-HSPA|4G-LTE'),(6,'Operation System Version','IOS9'),(6,'RAM memory','2GB'),(6,'Sản xuất tại','Trung quốc'),(6,'Sim Slots','1'),(6,'Sim type','SIM nano'),(6,'Trọng lượng (KG)','0.2'),(6,'Điều kiện','Mới'),(7,'3D TV','No'),(7,'Bảo hành','12 tháng'),(7,'Bộ nhớ trong','64GB'),(7,'Camera Back','11 - 15 MP'),(7,'Camera Front','5 - 6 MP'),(7,'Curved TV','No'),(7,'Hệ điều hành','IOS'),(7,'Kích thước màn hình','4.7'),(7,'Mẫu mã','6s'),(7,'Network Connections','3G-HSPA|4G-LTE'),(7,'Operation System Version','IOS9'),(7,'RAM memory','2GB'),(7,'Sản xuất tại','Trung quốc'),(7,'Sim Slots','1'),(7,'Sim type','SIM nano'),(7,'Trọng lượng (KG)','0.2'),(7,'Điều kiện','Mới'),(8,'3D TV','No'),(8,'Bảo hành','12 tháng'),(8,'Bộ nhớ trong','64GB'),(8,'Camera Back','11 - 15 MP'),(8,'Camera Front','5 - 6 MP'),(8,'Curved TV','No'),(8,'Hệ điều hành','IOS'),(8,'Kích thước màn hình','4.7'),(8,'Mẫu mã','6s'),(8,'Network Connections','3G-HSPA|4G-LTE'),(8,'Operation System Version','IOS9'),(8,'RAM memory','2GB'),(8,'Sản xuất tại','Trung quốc'),(8,'Sim Slots','1'),(8,'Sim type','SIM nano'),(8,'Trọng lượng (KG)','0.2'),(8,'Điều kiện','Mới'),(9,'3D TV','No'),(9,'Bảo hành','12 tháng'),(9,'Bộ nhớ trong','64GB'),(9,'Camera Back','11 - 15 MP'),(9,'Camera Front','5 - 6 MP'),(9,'Curved TV','No'),(9,'Hệ điều hành','IOS'),(9,'Kích thước màn hình','4.7'),(9,'Mẫu mã','6s'),(9,'Network Connections','3G-HSPA|4G-LTE'),(9,'Operation System Version','IOS9'),(9,'RAM memory','2GB'),(9,'Sản xuất tại','Trung quốc'),(9,'Sim Slots','1'),(9,'Sim type','SIM nano'),(9,'Trọng lượng (KG)','0.2'),(9,'Điều kiện','Mới'),(10,'3D TV','No'),(10,'Bảo hành','12 tháng'),(10,'Bộ nhớ trong','64GB'),(10,'Camera Back','11 - 15 MP'),(10,'Camera Front','5 - 6 MP'),(10,'Curved TV','No'),(10,'Hệ điều hành','IOS'),(10,'Kích thước màn hình','4.7'),(10,'Mẫu mã','6s'),(10,'Network Connections','3G-HSPA|4G-LTE'),(10,'Operation System Version','IOS9'),(10,'RAM memory','2GB'),(10,'Sản xuất tại','Trung quốc'),(10,'Sim Slots','1'),(10,'Sim type','SIM nano'),(10,'Trọng lượng (KG)','0.2'),(10,'Điều kiện','Mới'),(11,'3D TV','No'),(11,'Bảo hành','12 tháng'),(11,'Bộ nhớ trong','64GB'),(11,'Camera Back','11 - 15 MP'),(11,'Camera Front','5 - 6 MP'),(11,'Curved TV','No'),(11,'Hệ điều hành','IOS'),(11,'Kích thước màn hình','4.7'),(11,'Mẫu mã','6s'),(11,'Network Connections','3G-HSPA|4G-LTE'),(11,'Operation System Version','IOS9'),(11,'RAM memory','2GB'),(11,'Sản xuất tại','Trung quốc'),(11,'Sim Slots','1'),(11,'Sim type','SIM nano'),(11,'Trọng lượng (KG)','0.2'),(11,'Điều kiện','Mới'),(12,'3D TV','No'),(12,'Bảo hành','12 tháng'),(12,'Bộ nhớ trong','64GB'),(12,'Camera Back','11 - 15 MP'),(12,'Camera Front','5 - 6 MP'),(12,'Curved TV','No'),(12,'Hệ điều hành','IOS'),(12,'Kích thước màn hình','4.7'),(12,'Mẫu mã','6s'),(12,'Network Connections','3G-HSPA|4G-LTE'),(12,'Operation System Version','IOS9'),(12,'RAM memory','2GB'),(12,'Sản xuất tại','Trung quốc'),(12,'Sim Slots','1'),(12,'Sim type','SIM nano'),(12,'Trọng lượng (KG)','0.2'),(12,'Điều kiện','Mới'),(13,'3D TV','No'),(13,'Bảo hành','12 tháng'),(13,'Bộ nhớ trong','64GB'),(13,'Camera Back','11 - 15 MP'),(13,'Camera Front','5 - 6 MP'),(13,'Curved TV','No'),(13,'Hệ điều hành','IOS'),(13,'Kích thước màn hình','4.7'),(13,'Mẫu mã','6s'),(13,'Network Connections','3G-HSPA|4G-LTE'),(13,'Operation System Version','IOS9'),(13,'RAM memory','2GB'),(13,'Sản xuất tại','Trung quốc'),(13,'Sim Slots','1'),(13,'Sim type','SIM nano'),(13,'Trọng lượng (KG)','0.2'),(13,'Điều kiện','Mới'),(14,'3D TV','No'),(14,'Bảo hành','12 tháng'),(14,'Bộ nhớ trong','64GB'),(14,'Camera Back','11 - 15 MP'),(14,'Camera Front','5 - 6 MP'),(14,'Curved TV','No'),(14,'Hệ điều hành','IOS'),(14,'Kích thước màn hình','4.7'),(14,'Mẫu mã','6s'),(14,'Network Connections','3G-HSPA|4G-LTE'),(14,'Operation System Version','IOS9'),(14,'RAM memory','2GB'),(14,'Sản xuất tại','Trung quốc'),(14,'Sim Slots','1'),(14,'Sim type','SIM nano'),(14,'Trọng lượng (KG)','0.2'),(14,'Điều kiện','Mới'),(15,'3D TV','No'),(15,'Bảo hành','12 tháng'),(15,'Bộ nhớ trong','64GB'),(15,'Camera Back','11 - 15 MP'),(15,'Camera Front','5 - 6 MP'),(15,'Curved TV','No'),(15,'Hệ điều hành','IOS'),(15,'Kích thước màn hình','4.7'),(15,'Mẫu mã','6s'),(15,'Network Connections','3G-HSPA|4G-LTE'),(15,'Operation System Version','IOS9'),(15,'RAM memory','2GB'),(15,'Sản xuất tại','Trung quốc'),(15,'Sim Slots','1'),(15,'Sim type','SIM nano'),(15,'Trọng lượng (KG)','0.2'),(15,'Điều kiện','Mới'),(16,'3D TV','No'),(16,'Bảo hành','12 tháng'),(16,'Bộ nhớ trong','64GB'),(16,'Camera Back','11 - 15 MP'),(16,'Camera Front','5 - 6 MP'),(16,'Curved TV','No'),(16,'Hệ điều hành','IOS'),(16,'Kích thước màn hình','4.7'),(16,'Mẫu mã','6s'),(16,'Network Connections','3G-HSPA|4G-LTE'),(16,'Operation System Version','IOS9'),(16,'RAM memory','2GB'),(16,'Sản xuất tại','Trung quốc'),(16,'Sim Slots','1'),(16,'Sim type','SIM nano'),(16,'Trọng lượng (KG)','0.2'),(16,'Điều kiện','Mới'),(17,'3D TV','No'),(17,'Bảo hành','12 tháng'),(17,'Bộ nhớ trong','64GB'),(17,'Camera Back','11 - 15 MP'),(17,'Camera Front','5 - 6 MP'),(17,'Curved TV','No'),(17,'Hệ điều hành','IOS'),(17,'Kích thước màn hình','4.7'),(17,'Mẫu mã','6s'),(17,'Network Connections','3G-HSPA|4G-LTE'),(17,'Operation System Version','IOS9'),(17,'RAM memory','2GB'),(17,'Sản xuất tại','Trung quốc'),(17,'Sim Slots','1'),(17,'Sim type','SIM nano'),(17,'Trọng lượng (KG)','0.2'),(17,'Điều kiện','Mới'),(18,'3D TV','No'),(18,'Bảo hành','12 tháng'),(18,'Bộ nhớ trong','64GB'),(18,'Camera Back','11 - 15 MP'),(18,'Camera Front','5 - 6 MP'),(18,'Curved TV','No'),(18,'Hệ điều hành','IOS'),(18,'Kích thước màn hình','4.7'),(18,'Mẫu mã','6s'),(18,'Network Connections','3G-HSPA|4G-LTE'),(18,'Operation System Version','IOS9'),(18,'RAM memory','2GB'),(18,'Sản xuất tại','Trung quốc'),(18,'Sim Slots','1'),(18,'Sim type','SIM nano'),(18,'Trọng lượng (KG)','0.2'),(18,'Điều kiện','Mới'),(19,'3D TV','No'),(19,'Bảo hành','12 tháng'),(19,'Bộ nhớ trong','64GB'),(19,'Camera Back','11 - 15 MP'),(19,'Camera Front','5 - 6 MP'),(19,'Curved TV','No'),(19,'Hệ điều hành','IOS'),(19,'Kích thước màn hình','4.7'),(19,'Mẫu mã','6s'),(19,'Network Connections','3G-HSPA|4G-LTE'),(19,'Operation System Version','IOS9'),(19,'RAM memory','2GB'),(19,'Sản xuất tại','Trung quốc'),(19,'Sim Slots','1'),(19,'Sim type','SIM nano'),(19,'Trọng lượng (KG)','0.2'),(19,'Điều kiện','Mới'),(20,'3D TV','No'),(20,'Bảo hành','12 tháng'),(20,'Bộ nhớ trong','64GB'),(20,'Camera Back','11 - 15 MP'),(20,'Camera Front','5 - 6 MP'),(20,'Curved TV','No'),(20,'Hệ điều hành','IOS'),(20,'Kích thước màn hình','4.7'),(20,'Mẫu mã','6s'),(20,'Network Connections','3G-HSPA|4G-LTE'),(20,'Operation System Version','IOS9'),(20,'RAM memory','2GB'),(20,'Sản xuất tại','Trung quốc'),(20,'Sim Slots','1'),(20,'Sim type','SIM nano'),(20,'Trọng lượng (KG)','0.2'),(20,'Điều kiện','Mới'),(21,'3D TV','No'),(21,'Bảo hành','12 tháng'),(21,'Bộ nhớ trong','64GB'),(21,'Camera Back','11 - 15 MP'),(21,'Camera Front','5 - 6 MP'),(21,'Curved TV','No'),(21,'Hệ điều hành','IOS'),(21,'Kích thước màn hình','4.7'),(21,'Mẫu mã','6s'),(21,'Network Connections','3G-HSPA|4G-LTE'),(21,'Operation System Version','IOS9'),(21,'RAM memory','2GB'),(21,'Sản xuất tại','Trung quốc'),(21,'Sim Slots','1'),(21,'Sim type','SIM nano'),(21,'Trọng lượng (KG)','0.2'),(21,'Điều kiện','Mới'),(22,'3D TV','No'),(22,'Bảo hành','12 tháng'),(22,'Bộ nhớ trong','64GB'),(22,'Camera Back','11 - 15 MP'),(22,'Camera Front','5 - 6 MP'),(22,'Curved TV','No'),(22,'Hệ điều hành','IOS'),(22,'Kích thước màn hình','4.7'),(22,'Mẫu mã','6s'),(22,'Network Connections','3G-HSPA|4G-LTE'),(22,'Operation System Version','IOS9'),(22,'RAM memory','2GB'),(22,'Sản xuất tại','Trung quốc'),(22,'Sim Slots','1'),(22,'Sim type','SIM nano'),(22,'Trọng lượng (KG)','0.2'),(22,'Điều kiện','Mới'),(23,'3D TV','No'),(23,'Bảo hành','12 tháng'),(23,'Bộ nhớ trong','64GB'),(23,'Camera Back','11 - 15 MP'),(23,'Camera Front','5 - 6 MP'),(23,'Curved TV','No'),(23,'Hệ điều hành','IOS'),(23,'Kích thước màn hình','4.7'),(23,'Mẫu mã','6s'),(23,'Network Connections','3G-HSPA|4G-LTE'),(23,'Operation System Version','IOS9'),(23,'RAM memory','2GB'),(23,'Sản xuất tại','Trung quốc'),(23,'Sim Slots','1'),(23,'Sim type','SIM nano'),(23,'Trọng lượng (KG)','0.2'),(23,'Điều kiện','Mới'),(24,'3D TV','No'),(24,'Bảo hành','12 tháng'),(24,'Bộ nhớ trong','64GB'),(24,'Camera Back','11 - 15 MP'),(24,'Camera Front','5 - 6 MP'),(24,'Curved TV','No'),(24,'Hệ điều hành','IOS'),(24,'Kích thước màn hình','4.7'),(24,'Mẫu mã','6s'),(24,'Network Connections','3G-HSPA|4G-LTE'),(24,'Operation System Version','IOS9'),(24,'RAM memory','2GB'),(24,'Sản xuất tại','Trung quốc'),(24,'Sim Slots','1'),(24,'Sim type','SIM nano'),(24,'Trọng lượng (KG)','0.2'),(24,'Điều kiện','Mới'),(25,'3D TV','No'),(25,'Bảo hành','12 tháng'),(25,'Bộ nhớ trong','64GB'),(25,'Camera Back','11 - 15 MP'),(25,'Camera Front','5 - 6 MP'),(25,'Curved TV','No'),(25,'Hệ điều hành','IOS'),(25,'Kích thước màn hình','4.7'),(25,'Mẫu mã','6s'),(25,'Network Connections','3G-HSPA|4G-LTE'),(25,'Operation System Version','IOS9'),(25,'RAM memory','2GB'),(25,'Sản xuất tại','Trung quốc'),(25,'Sim Slots','1'),(25,'Sim type','SIM nano'),(25,'Trọng lượng (KG)','0.2'),(25,'Điều kiện','Mới'),(26,'3D TV','No'),(26,'Bảo hành','12 tháng'),(26,'Bộ nhớ trong','64GB'),(26,'Camera Back','11 - 15 MP'),(26,'Camera Front','5 - 6 MP'),(26,'Curved TV','No'),(26,'Hệ điều hành','IOS'),(26,'Kích thước màn hình','4.7'),(26,'Mẫu mã','6s'),(26,'Network Connections','3G-HSPA|4G-LTE'),(26,'Operation System Version','IOS9'),(26,'RAM memory','2GB'),(26,'Sản xuất tại','Trung quốc'),(26,'Sim Slots','1'),(26,'Sim type','SIM nano'),(26,'Trọng lượng (KG)','0.2'),(26,'Điều kiện','Mới'),(27,'3D TV','No'),(27,'Bảo hành','12 tháng'),(27,'Bộ nhớ trong','64GB'),(27,'Camera Back','11 - 15 MP'),(27,'Camera Front','5 - 6 MP'),(27,'Curved TV','No'),(27,'Hệ điều hành','IOS'),(27,'Kích thước màn hình','4.7'),(27,'Mẫu mã','6s'),(27,'Network Connections','3G-HSPA|4G-LTE'),(27,'Operation System Version','IOS9'),(27,'RAM memory','2GB'),(27,'Sản xuất tại','Trung quốc'),(27,'Sim Slots','1'),(27,'Sim type','SIM nano'),(27,'Trọng lượng (KG)','0.2'),(27,'Điều kiện','Mới'),(28,'3D TV','No'),(28,'Bảo hành','12 tháng'),(28,'Bộ nhớ trong','64GB'),(28,'Camera Back','11 - 15 MP'),(28,'Camera Front','5 - 6 MP'),(28,'Curved TV','No'),(28,'Hệ điều hành','IOS'),(28,'Kích thước màn hình','4.7'),(28,'Mẫu mã','6s'),(28,'Network Connections','3G-HSPA|4G-LTE'),(28,'Operation System Version','IOS9'),(28,'RAM memory','2GB'),(28,'Sản xuất tại','Trung quốc'),(28,'Sim Slots','1'),(28,'Sim type','SIM nano'),(28,'Trọng lượng (KG)','0.2'),(28,'Điều kiện','Mới'),(29,'3D TV','No'),(29,'Bảo hành','12 tháng'),(29,'Bộ nhớ trong','64GB'),(29,'Camera Back','11 - 15 MP'),(29,'Camera Front','5 - 6 MP'),(29,'Curved TV','No'),(29,'Hệ điều hành','IOS'),(29,'Kích thước màn hình','4.7'),(29,'Mẫu mã','6s'),(29,'Network Connections','3G-HSPA|4G-LTE'),(29,'Operation System Version','IOS9'),(29,'RAM memory','2GB'),(29,'Sản xuất tại','Trung quốc'),(29,'Sim Slots','1'),(29,'Sim type','SIM nano'),(29,'Trọng lượng (KG)','0.2'),(29,'Điều kiện','Mới'),(30,'3D TV','No'),(30,'Bảo hành','12 tháng'),(30,'Bộ nhớ trong','64GB'),(30,'Camera Back','11 - 15 MP'),(30,'Camera Front','5 - 6 MP'),(30,'Curved TV','No'),(30,'Hệ điều hành','IOS'),(30,'Kích thước màn hình','4.7'),(30,'Mẫu mã','6s'),(30,'Network Connections','3G-HSPA|4G-LTE'),(30,'Operation System Version','IOS9'),(30,'RAM memory','2GB'),(30,'Sản xuất tại','Trung quốc'),(30,'Sim Slots','1'),(30,'Sim type','SIM nano'),(30,'Trọng lượng (KG)','0.2'),(30,'Điều kiện','Mới'),(31,'3D TV','No'),(31,'Bảo hành','12 tháng'),(31,'Bộ nhớ trong','64GB'),(31,'Camera Back','11 - 15 MP'),(31,'Camera Front','5 - 6 MP'),(31,'Curved TV','No'),(31,'Hệ điều hành','IOS'),(31,'Kích thước màn hình','4.7'),(31,'Mẫu mã','6s'),(31,'Network Connections','3G-HSPA|4G-LTE'),(31,'Operation System Version','IOS9'),(31,'RAM memory','2GB'),(31,'Sản xuất tại','Trung quốc'),(31,'Sim Slots','1'),(31,'Sim type','SIM nano'),(31,'Trọng lượng (KG)','0.2'),(31,'Điều kiện','Mới'),(32,'3D TV','No'),(32,'Bảo hành','12 tháng'),(32,'Bộ nhớ trong','64GB'),(32,'Camera Back','11 - 15 MP'),(32,'Camera Front','5 - 6 MP'),(32,'Curved TV','No'),(32,'Hệ điều hành','IOS'),(32,'Kích thước màn hình','4.7'),(32,'Mẫu mã','6s'),(32,'Network Connections','3G-HSPA|4G-LTE'),(32,'Operation System Version','IOS9'),(32,'RAM memory','2GB'),(32,'Sản xuất tại','Trung quốc'),(32,'Sim Slots','1'),(32,'Sim type','SIM nano'),(32,'Trọng lượng (KG)','0.2'),(32,'Điều kiện','Mới');
/*!40000 ALTER TABLE `CHITIETSANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETTHUONGHIEU`
--

DROP TABLE IF EXISTS `CHITIETTHUONGHIEU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CHITIETTHUONGHIEU` (
  `MATHUONGHIEU` int(11) NOT NULL,
  `MALOAISP` int(11) NOT NULL,
  `HINHTHUONGHIEU` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`MATHUONGHIEU`,`MALOAISP`),
  KEY `KHOANGOAI_CHITIETTHUONGHIEU_MALOAISP` (`MALOAISP`),
  CONSTRAINT `KHOANGOAI_CHITIETTHUONGHIEU_MALOAISP` FOREIGN KEY (`MALOAISP`) REFERENCES `loaisanpham` (`MALOAISP`),
  CONSTRAINT `KHOANGOAI_CHITIETTHUONGHIEU_MATHUONGHIEU` FOREIGN KEY (`MATHUONGHIEU`) REFERENCES `thuonghieu` (`MATHUONGHIEU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETTHUONGHIEU`
--

LOCK TABLES `CHITIETTHUONGHIEU` WRITE;
/*!40000 ALTER TABLE `CHITIETTHUONGHIEU` DISABLE KEYS */;
INSERT INTO `CHITIETTHUONGHIEU` VALUES (1,1,'/hinhthuonghieu/apple.png'),(1,49,'/hinhthuonghieu/macbook.png'),(2,1,'/hinhthuonghieu/nokia.png'),(3,1,'/hinhthuonghieu/samsung.png'),(4,1,'/hinhthuonghieu/xiaomi.png'),(5,1,'/hinhthuonghieu/asus.png'),(6,1,'/hinhthuonghieu/lenovo.png'),(6,49,'/hinhthuonghieu/laptoplenovo.png'),(7,1,'/hinhthuonghieu/oppo.png'),(8,1,'/hinhthuonghieu/sony.png'),(9,1,'/hinhthuonghieu/htc.png'),(10,49,'/hinhthuonghieu/dell.png'),(11,1,'/hinhthuonghieu/hp.png'),(12,1,'/hinhthuonghieu/scandisk.png'),(13,1,'/hinhthuonghieu/silicon.jpg'),(14,1,'/hinhthuonghieu/canon.jpg'),(15,49,'/hinhthuonghieu/microsoft.png');
/*!40000 ALTER TABLE `CHITIETTHUONGHIEU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DANHGIA`
--

DROP TABLE IF EXISTS `DANHGIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `DANHGIA` (
  `MADG` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `MASP` int(11) DEFAULT NULL,
  `TENTHIETBI` text COLLATE utf8mb4_general_ci,
  `TIEUDE` text COLLATE utf8mb4_general_ci,
  `NOIDUNG` text COLLATE utf8mb4_general_ci,
  `SOSAO` int(1) DEFAULT NULL,
  `NGAYDANHGIA` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`MADG`),
  KEY `KHOANGOAI_DANHGIA_MASP` (`MASP`),
  CONSTRAINT `KHOANGOAI_DANHGIA_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DANHGIA`
--

LOCK TABLES `DANHGIA` WRITE;
/*!40000 ALTER TABLE `DANHGIA` DISABLE KEYS */;
/*!40000 ALTER TABLE `DANHGIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOADON`
--

DROP TABLE IF EXISTS `HOADON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `HOADON` (
  `MAHD` int(11) NOT NULL AUTO_INCREMENT,
  `NGAYMUA` text COLLATE utf8mb4_general_ci,
  `NGAYGIAO` text COLLATE utf8mb4_general_ci,
  `TRANGTHAI` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `TENNGUOINHAN` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `SODT` text COLLATE utf8mb4_general_ci,
  `DIACHI` text COLLATE utf8mb4_general_ci,
  `CHUYENKHOAN` tinyint(1) DEFAULT NULL,
  `MACHUYENKHOAN` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`MAHD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOADON`
--

LOCK TABLES `HOADON` WRITE;
/*!40000 ALTER TABLE `HOADON` DISABLE KEYS */;
/*!40000 ALTER TABLE `HOADON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KHUYENMAI`
--

DROP TABLE IF EXISTS `KHUYENMAI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `KHUYENMAI` (
  `MAKM` int(11) NOT NULL AUTO_INCREMENT,
  `MALOAISP` int(11) DEFAULT NULL,
  `TENKM` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NGAYBATDAU` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `NGAYKETTHUC` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `HINHKHUYENMAI` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`MAKM`),
  KEY `KHOANGOAI_KHUYENMAI_MALOAISP` (`MALOAISP`),
  CONSTRAINT `KHOANGOAI_KHUYENMAI_MALOAISP` FOREIGN KEY (`MALOAISP`) REFERENCES `loaisanpham` (`MALOAISP`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KHUYENMAI`
--

LOCK TABLES `KHUYENMAI` WRITE;
/*!40000 ALTER TABLE `KHUYENMAI` DISABLE KEYS */;
INSERT INTO `KHUYENMAI` VALUES (1,2,'Xã hàng hot đến 49%','2016/9/12','2016/10/12','/hinhkhuyenmai/con loc giam gia mua he.png'),(2,2,'Giải nhiệt mùa hè giảm ngay 50%','2016/9/12','2016/10/12','/hinhkhuyenmai/khuyen mai ta quan ta dan.jpg'),(3,2,'Hè này mua gì ?','2016/9/12','2016/10/12','/hinhkhuyenmai/du lich.jpg'),(4,3,'Festival salve !','2016/9/12','2016/10/12','/hinhkhuyenmai/festival sale 90.jpg');
/*!40000 ALTER TABLE `KHUYENMAI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOAINHANVIEN`
--

DROP TABLE IF EXISTS `LOAINHANVIEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `LOAINHANVIEN` (
  `MALOAINV` int(11) NOT NULL AUTO_INCREMENT,
  `TENLOAINV` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MALOAINV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOAINHANVIEN`
--

LOCK TABLES `LOAINHANVIEN` WRITE;
/*!40000 ALTER TABLE `LOAINHANVIEN` DISABLE KEYS */;
/*!40000 ALTER TABLE `LOAINHANVIEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOAISANPHAM`
--

DROP TABLE IF EXISTS `LOAISANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `LOAISANPHAM` (
  `MALOAISP` int(11) NOT NULL AUTO_INCREMENT,
  `TENLOAISP` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MALOAI_CHA` int(11) DEFAULT NULL,
  PRIMARY KEY (`MALOAISP`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOAISANPHAM`
--

LOCK TABLES `LOAISANPHAM` WRITE;
/*!40000 ALTER TABLE `LOAISANPHAM` DISABLE KEYS */;
INSERT INTO `LOAISANPHAM` VALUES (1,'Điện thoại & Máy tính bảng',0),(2,'Điện thoại di động',1),(3,'Máy tính bảng',1),(4,'Điện thoại bàn',1),(5,'Phụ kiện điện thoại & máy tính bảng',1),(6,'Ốp lưng và bao da điện thoại',5),(7,'Miếng dán màn hình điện thoại',5),(8,'Phụ kiện di động trên xe hơi',5),(9,'Phụ kiện khác',5),(10,'Cáp & Dock sạc',5),(11,'Linh kiện & Dụng cụ',5),(12,'SIM & Thẻ cào',5),(13,'Pin và bộ sạc',5),(14,'Phụ kiện máy tính bảng',5),(15,'Pin sạc dự phòng',5),(16,'Phụ kiện camera điện thoại',5),(17,'Nhà cửa & Đời sống',0),(18,'Bếp phòng ăn',17),(19,'Dụng cụ làm bánh',18),(20,'Dụng cụ nấu ăn',18),(21,'Đồ dùng bàn ăn',18),(22,'Đồ dùng uống trà và cà phê',18),(23,'Dao nấu bếp',18),(24,'Khăn trải bàn & Phụ kiện bằng vải',18),(25,'Phụ kiện & Dụng cụ nhà bếp',18),(26,'Đồ dùng phòng ngủ',17),(27,'Bộ chăn và ga giường gối',26),(28,'Gối',26),(29,'Phụ kiện giường ngủ',26),(30,'Bộ chăn ra gối nệm',26),(31,'Ga giường',26),(32,'Nệm và Vỏ nệm',26),(33,'Đồ nội thất',17),(34,'Nội thất phòng ngủ',33),(35,'Nội thất phòng khách',33),(36,'Nội thất bếp & Phòng ăn',33),(37,'Nội thất phòng trẻ em',33),(38,'Nội thất phòng làm việc tại gia',33),(39,'Nội thất cho hành lang & lối vào',33),(40,'Nội thất phòng trang trí',33),(41,'Nội thất kiểu cổ',33),(42,'Tân trang nhà cửa',17),(43,'Kho chứa dụng cụ và Garage',42),(44,'Điện',42),(45,'Cổng và Hàng rào',42),(46,'Bảo vệ và An toàn',42),(47,'Ống nước',42),(48,'Máy vi tính & Laptop',17),(49,'Laptop',48),(50,'Dòng giải trí',49),(51,'Macbooks',49),(52,'Ultrabooks',49),(53,'Thiết bị lưu trữ',17),(54,'Ổ cứng SSD',53),(55,'Ổ cứng gắn ngoài',53),(56,'Ổ cứng gắn trong',53),(57,'USB lưu trữ',53),(58,'Máy in & Phụ kiện',17),(59,'Máy in',58),(60,'Kệ máy in',58),(61,'Máy Fax',58),(62,'Mực in',58),(63,'Chăm sóc sức khỏe & làm đẹp',17),(64,'Trang điểm',63),(65,'Mặt',64),(66,'Môi',64),(67,'Mắt',64),(68,'Tẩy trang',64),(69,'Chăm sóc mặt',63),(70,'Mặt nạ đắp',69),(71,'Sữa rữa mặt',69),(72,'Thể thao',17),(73,'Yaga & Thể hình',72),(74,'Yoga',73),(75,'Máy tập thể hình',73),(76,'Máy tập thể lực',73),(77,'Giày & Trang phục',72),(78,'Dành cho nữ',77),(79,'Dành cho nam',77),(80,'Dành cho bé',77),(81,'Thời trang',0),(82,'TV, Video, Âm Thanh ,Game & Thiết Bị Số',0),(83,'Tivi',82),(84,'Dưới 24 inches',83),(85,'25-32 inches',83),(86,'33-42 inches',83),(87,'43-54 inches',83),(88,'Trên 55 inches',83),(89,'Tivi giá đặc biệt cho các tỉnh, thành lớn',83),(90,'Thiết bị âm thanh',82),(91,'Các loại tai nghe',90),(92,'Loa di động',90),(93,'Dàn âm thanh giải trí',90),(94,'Máy nghe nhạc',90),(95,'Video',82),(96,'Thiết bị trình chiếu',95),(97,'Thiết bị streaming',95),(98,'Thiết bị chơi game',82),(99,'Xbox',98),(100,'Nitendo',98),(101,'Thiết bị đeo công nghệ',82),(102,'Đồng hồ thông minh',101),(103,'Thiết bị theo dõi sức khỏe & vận động',101),(104,'Mắt kính thông minh',101),(105,'Thiết bị giám sát thông minh',102),(106,'Thể thao & du lịch',0),(107,'Các loại bài tập & thể hình',106),(108,'Máy tập thể hình',107),(109,'Máy tập thể lực',107),(110,'Phụ kiện',107),(111,'Tạ',107),(112,'Yoga',107),(113,'Pilates',107),(114,'Đấm bốc, Võ thuật & Đánh MMA',107),(115,'Thể tao đồng đội',106),(116,'Máy tập thể hình',115),(117,'Máy tập thể hình',115),(118,'Bóng đá',115),(119,'Bóng rổ',115),(120,'Bóng chuyền',115),(121,'Hoạt động dã ngoại',106),(122,'Xe đạp',121),(123,'Dã ngoại & leo núi',121),(124,'Câu cá',121),(125,'Xe Scooters',121),(126,'Trượt băng trong nhà',121),(127,'Trượt ván',121),(128,'Bơi lội',121),(129,'Xe máy và bách hóa',0),(130,'Ô tô & xe máy',129),(131,'Chăm sóc ô tô & xe máy',130),(132,'Phụ kiện bên ngoài',130),(133,'Phụ kiện bên trong',130),(134,'Link kiện thay thế',130),(135,'Thiết bị giám định ô tô',130),(136,'Xe mô tô & xe địa hình',130),(137,'Dầu nhớt',130),(138,'Sơn sửa',130),(139,'Phụ kiện xe tải',130),(140,'Dụng cụ và thiết bị',130),(141,'Bánh & vỏ xe',130),(142,'Thiết bị định vị',130);
/*!40000 ALTER TABLE `LOAISANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NHANVIEN`
--

DROP TABLE IF EXISTS `NHANVIEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `NHANVIEN` (
  `MANV` int(11) NOT NULL AUTO_INCREMENT,
  `TENNV` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TENDANGNHAP` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MATKHAU` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DIACHI` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NGAYSINH` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `SODT` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `GIOITINH` tinyint(1) DEFAULT NULL,
  `MALOAINV` int(11) DEFAULT NULL,
  PRIMARY KEY (`MANV`),
  KEY `KHOANGOAI_NHANVIEN_MALOAINV` (`MALOAINV`),
  CONSTRAINT `KHOANGOAI_NHANVIEN_MALOAINV` FOREIGN KEY (`MALOAINV`) REFERENCES `loainhanvien` (`MALOAINV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NHANVIEN`
--

LOCK TABLES `NHANVIEN` WRITE;
/*!40000 ALTER TABLE `NHANVIEN` DISABLE KEYS */;
/*!40000 ALTER TABLE `NHANVIEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SANPHAM`
--

DROP TABLE IF EXISTS `SANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `SANPHAM` (
  `MASP` int(11) NOT NULL AUTO_INCREMENT,
  `TENSP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `GIA` decimal(10,0) DEFAULT NULL,
  `ANHLON` text COLLATE utf8mb4_general_ci,
  `ANHNHO` text COLLATE utf8mb4_general_ci,
  `THONGTIN` text COLLATE utf8mb4_general_ci,
  `SOLUONG` int(11) DEFAULT NULL,
  `MALOAISP` int(11) DEFAULT NULL,
  `MATHUONGHIEU` int(11) DEFAULT NULL,
  `LUOTMUA` int(11) DEFAULT NULL,
  PRIMARY KEY (`MASP`),
  KEY `KHOANGOAI_SANPHAM_MALOAISP` (`MALOAISP`),
  KEY `KHOANGOAI_SANPHAM_MATHUONGHIEU` (`MATHUONGHIEU`),
  CONSTRAINT `KHOANGOAI_SANPHAM_MALOAISP` FOREIGN KEY (`MALOAISP`) REFERENCES `loaisanpham` (`MALOAISP`),
  CONSTRAINT `KHOANGOAI_SANPHAM_MATHUONGHIEU` FOREIGN KEY (`MATHUONGHIEU`) REFERENCES `thuonghieu` (`MATHUONGHIEU`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SANPHAM`
--

LOCK TABLES `SANPHAM` WRITE;
/*!40000 ALTER TABLE `SANPHAM` DISABLE KEYS */;
INSERT INTO `SANPHAM` VALUES (1,'Apple Iphone 6s Plus 16GB',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(2,'Apple Iphone 6s Plus 16GB (Vàng hồng)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(3,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(4,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(5,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(6,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(7,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(8,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(9,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(10,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0),(11,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,49,1,0),(12,'Pin sạc dự phòng Asus Zenpower 10.050mAh (Vàng) ',339000,'/hinhsanpham/pinsacduphongasus.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,13,5,0),(13,'Bao da kiêm bàn phím cho máy tính bảng 7 inch ( Đen)  ',98000,'/hinhsanpham/baodabanphimmaytinhbang7ich.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,14,5,0),(14,'Gậy chụp hình Selfie Stick (Đen phối vàng) ',36000,'/hinhsanpham/gaychuphinhtusuong.png','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,16,5,0),(15,'Bộ Miếng dán cường lực và ốp lưng cho iPhone 6 - NVPro 30306 (Trong suốt)  ',86000,'/hinhsanpham/mieng-gian-cuong-luc-iphone-6-6s.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,7,5,0),(16,'Đế kẹp smartphone cho điện thoại',36000,'/hinhsanpham/dekepsmartphonechodienthoai.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,8,5,0),(17,'Sim 3G tài khoản 600 MB',106000,'/hinhsanpham/sim3gtaikhoan600.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,12,5,0),(18,'Ổ cắm thông minh Xiaomi Mi Power Strips (Trắng) ',166000,'/hinhsanpham/o-cam-thong-minh-xiaomi.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,11,5,0),(19,'Giá đỡ điện thoại cho tay cầm chơi Game Terios T-3 ( Đen)  ',99000,'/hinhsanpham/taycamchoigame.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,11,5,0),(20,'Tivi LED Arirang 24inch HD - Model AR-2488F (Đen)',2439000,'/hinhsanpham/tiviled24inchesariang.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,84,5,0),(21,'Tivi LED LG 42inch 42LF550T Full HD (Đen)  ',6939000,'/hinhsanpham/tiviled42inches.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,85,5,0),(22,'Smart Tivi LED LG 55inch Full HD - Model 55LH575T (Đen)',17000000,'/hinhsanpham/tiviled55inches.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,87,5,0),(23,'Load Bluetooth SUNTEK S204 (Đen) ',269000,'/hinhsanpham/sony-electronics-hd-radio.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,92,5,0),(24,'Tai nghe chụp tai Ovann X1 Gaming (Đen phối Xanh) ',60000,'/hinhsanpham/tai-nghe-chup-tai-ovann-x1-gaming-den-phoi-xanh_5235588062018469161_300.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,91,5,0),(25,'Dàn âm thanh Samsung HT-E350K 5.1 330W (Đen) ',1760000,'/hinhsanpham/vish-dvd-ht-e350k-2.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,93,5,0),(26,'Máy nghe nhạc MP3 NVPro Minion (Xanh dương) ',40000,'/hinhsanpham/may-nghe-nhac-mp3-nvpro-minion-xanh-duong-8610-6315961-e77b808c5237d08a940e6fe597050469-catalog_233.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,94,5,0),(27,'Máy chiếu mini cho điện thoại (Nâu)  ',169999,'/hinhsanpham/may-chieu-mini-cho-dien-thoai-nau-9973-9001242-168928dd2df3fa0fae4f2c453b3e8620-catalog_233.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,96,5,0),(28,'Thiết bị Android TV box MXQ S805 (Đen) ',429300,'/hinhsanpham/20160530150209551.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,97,5,0),(29,'Tay cầm chơi game Xbox One Controller và Wireless Adapter for PC (Đen)',1549000,'/hinhsanpham/36743763_palaciodehierro_wirelesscontrollerc35mmone_xbox_vista_1.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,99,5,0),(30,'Máy chơi games Nintendo Wii +HDD 500 GB (Full Games) (Đen) ',5999000,'/hinhsanpham/23. WII CONSOLE BLACK W WII REMOTE PLUS _ NUNCHUCK (UPC 045496880675).jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,100,5,0),(31,'Đồng hồ thông minh Smart Watch Uwatch DZ09 (Bạc) ',302676000,'/hinhsanpham/res_50df6f16088731d12e6c6698c47231e4_1200x1200c_mttq.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,102,5,0),(32,'Vòng đeo tay Xiaomi Miband 2 (Đen)  ',819000,'/hinhsanpham/sh-02-a.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,103,5,0),(33,'Bút ghi âm chuyên nghiệp 8 GB (Đen) ',612000,'/hinhsanpham/130814225508442671.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,104,5,0);
/*!40000 ALTER TABLE `SANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `THUONGHIEU`
--

DROP TABLE IF EXISTS `THUONGHIEU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `THUONGHIEU` (
  `MATHUONGHIEU` int(11) NOT NULL AUTO_INCREMENT,
  `TENTHUONGHIEU` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `HINHTHUONGHIEU` text COLLATE utf8mb4_general_ci,
  `LUOTMUA` int(11) DEFAULT NULL,
  PRIMARY KEY (`MATHUONGHIEU`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `THUONGHIEU`
--

LOCK TABLES `THUONGHIEU` WRITE;
/*!40000 ALTER TABLE `THUONGHIEU` DISABLE KEYS */;
INSERT INTO `THUONGHIEU` VALUES (1,'Apple','hinhthuonghieu/tenapple.jpg',0),(2,'Nokia','hinhthuonghieu/tennokia.png',0),(3,'Samsung','hinhthuonghieu/tensamsung.png',0),(4,'Xiaomi','hinhthuonghieu/tenxiaomi.png',0),(5,'Asus','hinhthuonghieu/tenasus.png',0),(6,'Lenovo','hinhthuonghieu/tenlenovo.png',0),(7,'Oppo','hinhthuonghieu/tenoppo.png',0),(8,'Sony','hinhthuonghieu/tensony.png',0),(9,'HTC','hinhthuonghieu/tenhtc.png',0),(10,'Dell','hinhthuonghieu/tendell.png',0),(11,'HP','hinhthuonghieu/tenhp.png',0),(12,'Scandisk','hinhthuonghieu/tensandisk.png',0),(13,'Silicon','hinhthuonghieu/tensilicon.png',0),(14,'Canon','hinhthuonghieu/tencannon.png',0),(15,'Microsoft','hinhthuonghieu/tenmicrosoft.png',0);
/*!40000 ALTER TABLE `THUONGHIEU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'LAZADA'
--

--
-- Dumping routines for database 'LAZADA'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-08 21:46:54
