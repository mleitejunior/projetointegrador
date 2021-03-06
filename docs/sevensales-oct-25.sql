﻿-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.35-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;



-- Copiando estrutura para tabela sevensales.monthlyfixedexpense
CREATE TABLE IF NOT EXISTS `monthlyfixedexpense` (
  `dateFixedExpense` date NOT NULL,
  `useMaterial` float DEFAULT NULL,
  `equipament` float DEFAULT NULL,
  `mensalTax` float DEFAULT NULL,
  `rent` float DEFAULT NULL,
  `lendding` float DEFAULT NULL,
  `maintenance` float DEFAULT NULL,
  `others` float DEFAULT NULL,
  PRIMARY KEY (`dateFixedExpense`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.monthlyfixedexpense: ~0 rows (aproximadamente)
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
  PRIMARY KEY (`idProduct`,`provider_idprovider`),
  KEY `fk_Product_provider1_idx` (`provider_idprovider`),
  CONSTRAINT `fk_Product_provider1` FOREIGN KEY (`provider_idprovider`) REFERENCES `provider` (`idprovider`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.product: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT IGNORE INTO `product` (`idProduct`, `name`, `cost`, `percentProfit`, `productExpense`, `priceSale`, `quantity`, `provider_idprovider`) VALUES
	(2, 'Calcinha Comestível', 10, 20, 0, NULL, 100, 1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.provider
CREATE TABLE IF NOT EXISTS `provider` (
  `idProvider` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `fu` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact` varchar(45) NOT NULL,
  `cnpj` varchar(45) NOT NULL,
  PRIMARY KEY (`idProvider`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.provider: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
INSERT IGNORE INTO `provider` (`idProvider`, `name`, `adress`, `city`, `fu`, `email`, `contact`, `cnpj`) VALUES
	(1, 'Sex Shop Fogo no Rabo', 'Rua da Libido', 'Alfemeas', 'MG', 'nao tem', '1991923', '1501501');
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.sale
CREATE TABLE IF NOT EXISTS `sale` (
  `idSale` int(11) NOT NULL AUTO_INCREMENT,
  `dateTime` datetime NOT NULL,
  `Type` enum('prazo','vista') NOT NULL,
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

-- Copiando dados para a tabela sevensales.user: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT IGNORE INTO `user` (`idUser`, `username`, `password`, `name`, `adress`, `cpf`, `fu`, `email`, `contact`) VALUES
	(1, 'mleitejunior', '1234', 'Marcelo Leite Junior', 'Nao tem', 151516, 'MG', 'mleitejunior@gmail.com', '35 99991234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
