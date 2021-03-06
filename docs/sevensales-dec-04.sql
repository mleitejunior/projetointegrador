﻿-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.14 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando a estrutura do banco de dados para sevensales
CREATE DATABASE IF NOT EXISTS `sevensales` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sevensales`;

-- Copiando estrutura para tabela sevensales.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `idBrand` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idBrand`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.brand: ~0 rows (aproximadamente)
DELETE FROM `brand`;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.category
CREATE TABLE IF NOT EXISTS `category` (
  `idCategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idCategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.category: ~0 rows (aproximadamente)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.client
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `fu` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.client: ~0 rows (aproximadamente)
DELETE FROM `client`;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.itemssale
CREATE TABLE IF NOT EXISTS `itemssale` (
  `Product_idProduct` int(11) NOT NULL,
  `Sale_idSale` int(11) NOT NULL,
  `Sale_Employee_idEmployee` int(11) NOT NULL,
  `Sale_Client_idClient` int(11) NOT NULL,
  PRIMARY KEY (`Product_idProduct`,`Sale_idSale`,`Sale_Employee_idEmployee`,`Sale_Client_idClient`),
  KEY `fk_Product_has_Sale_Sale1_idx` (`Sale_idSale`,`Sale_Employee_idEmployee`,`Sale_Client_idClient`),
  KEY `fk_Product_has_Sale_Product1_idx` (`Product_idProduct`),
  CONSTRAINT `fk_Product_has_Sale_Product1` FOREIGN KEY (`Product_idProduct`) REFERENCES `product` (`idProduct`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_Sale_Sale1` FOREIGN KEY (`Sale_idSale`, `Sale_Employee_idEmployee`, `Sale_Client_idClient`) REFERENCES `sale` (`idSale`, `Employee_idEmployee`, `Client_idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.itemssale: ~0 rows (aproximadamente)
DELETE FROM `itemssale`;
/*!40000 ALTER TABLE `itemssale` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemssale` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.monthlyfixedexpense
CREATE TABLE IF NOT EXISTS `monthlyfixedexpense` (
  `dateFixedExpense` date NOT NULL,
  `useMaterial` float DEFAULT NULL,
  `equipament` float DEFAULT NULL,
  `mensalTax` float DEFAULT NULL,
  `rent` float DEFAULT NULL,
  `lendding` float DEFAULT NULL,
  `maintenance` float DEFAULT NULL,
  `employee` float DEFAULT NULL,
  `others` float DEFAULT NULL,
  PRIMARY KEY (`dateFixedExpense`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.monthlyfixedexpense: ~0 rows (aproximadamente)
DELETE FROM `monthlyfixedexpense`;
/*!40000 ALTER TABLE `monthlyfixedexpense` DISABLE KEYS */;
/*!40000 ALTER TABLE `monthlyfixedexpense` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.product
CREATE TABLE IF NOT EXISTS `product` (
  `idProduct` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `cost` float NOT NULL,
  `percentProfit` float NOT NULL,
  `productExpense` float NOT NULL,
  `priceSale` float DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `provider_idprovider` int(11) NOT NULL,
  `category_idcategory` int(11) NOT NULL,
  PRIMARY KEY (`idProduct`,`provider_idprovider`,`category_idcategory`),
  KEY `fk_Product_provider1_idx` (`provider_idprovider`),
  KEY `fk_Product_category1` (`category_idcategory`),
  CONSTRAINT `fk_Product_category1` FOREIGN KEY (`category_idcategory`) REFERENCES `category` (`idCategory`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_provider1` FOREIGN KEY (`provider_idprovider`) REFERENCES `provider` (`idprovider`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.product: ~0 rows (aproximadamente)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.provider
CREATE TABLE IF NOT EXISTS `provider` (
  `idProvider` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(100) NOT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `fu` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) NOT NULL,
  `ownerName` varchar(100) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact` varchar(45) NOT NULL,
  PRIMARY KEY (`idProvider`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.provider: ~1 rows (aproximadamente)
DELETE FROM `provider`;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
INSERT INTO `provider` (`idProvider`, `companyName`, `adress`, `city`, `fu`, `cnpj`, `ownerName`, `email`, `contact`) VALUES
	(1, 'Sex Shop Fogo no Rabo', 'Rua da Libido', 'Alfemeas', 'MG', '1501501', '', 'nao tem', '1991923');
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.sale
CREATE TABLE IF NOT EXISTS `sale` (
  `idSale` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `type` enum('prazo','vista') NOT NULL,
  `discount` float NOT NULL,
  `tax` float NOT NULL,
  `Employee_idEmployee` int(11) NOT NULL,
  `Client_idClient` int(11) NOT NULL,
  PRIMARY KEY (`idSale`,`Employee_idEmployee`,`Client_idClient`),
  KEY `fk_Sale_Employee_idx` (`Employee_idEmployee`),
  KEY `fk_Sale_Client1_idx` (`Client_idClient`),
  CONSTRAINT `fk_Sale_Client1` FOREIGN KEY (`Client_idClient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sale_Employee` FOREIGN KEY (`Employee_idEmployee`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.sale: ~0 rows (aproximadamente)
DELETE FROM `sale`;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.user
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `adress` varchar(45) DEFAULT NULL,
  `cpf` int(11) NOT NULL,
  `fu` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.user: ~0 rows (aproximadamente)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`idUser`, `username`, `password`, `name`, `adress`, `cpf`, `fu`, `email`, `contact`) VALUES
	(1, 'mleitejunior', '1234', 'Marcelo Leite Junior', 'Nao tem', 151516, 'MG', 'mleitejunior@gmail.com', '35 99991234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
