-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.26 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para sevensales
CREATE DATABASE IF NOT EXISTS `sevensales` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sevensales`;

-- Copiando estrutura para tabela sevensales.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `idBrand` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idBrand`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.brand: ~13 rows (aproximadamente)
DELETE FROM `brand`;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`idBrand`, `name`) VALUES
	(1, 'Nike'),
	(2, 'Adidas'),
	(3, 'Lacoste'),
	(4, 'Dudalina'),
	(5, 'Calvin Klein'),
	(6, 'Victoria Secrets '),
	(7, 'Louis Vuitton'),
	(8, 'FidoDido '),
	(9, 'Sawaary Jeans '),
	(10, 'Gioconda '),
	(11, 'Intensify.me'),
	(12, 'Tita.co'),
	(13, 'Lace & Others ');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.category
CREATE TABLE IF NOT EXISTS `category` (
  `idCategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idCategory`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.category: ~10 rows (aproximadamente)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`idCategory`, `name`) VALUES
	(1, 'Masculino'),
	(2, 'Feminino'),
	(3, 'Moda Verão '),
	(4, 'Moda Inverno'),
	(5, 'Roupa Íntima Masculina '),
	(6, 'Roupa Íntima Feminina '),
	(7, 'Calçado Masculino'),
	(8, 'Calçado Feminino'),
	(9, 'Calça Jeans Masculina'),
	(10, 'Calça Jeans Feminina');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.client: ~4 rows (aproximadamente)
DELETE FROM `client`;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`idClient`, `name`, `adress`, `city`, `fu`, `email`, `contact`, `cpf`) VALUES
	(1, 'Marcelo Leite Junior', 'Rua do Kra Legal no 69', 'Machado', 'MG', 'mleitejunior@gmail.com', '0151894984', '56156156'),
	(2, 'Cristian Luiz Inácio Condenado', 'Rua do Me Soltam Quando Quiser', 'Curitiba', 'PA', 'jesus@cristian.com', '5165184', '151615156'),
	(3, 'ILara Í', 'Rua Ilaracá', 'Caxancú', 'MG', 'ilara@ai.com.br', '56156156156', '1561561561'),
	(4, 'Dafne Brigadão com Tu', 'Rua do Ódio no 333', 'Capetópolis', 'AC', 'hotmail@gmail.com', '6156156156', '56165156156');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.itemssale
CREATE TABLE IF NOT EXISTS `itemssale` (
  `Product_idProduct` int(11) NOT NULL,
  `Sale_idSale` int(11) NOT NULL,
  `Sale_User_idUser` int(11) NOT NULL,
  `Sale_Client_idClient` int(11) NOT NULL,
  PRIMARY KEY (`Product_idProduct`,`Sale_idSale`,`Sale_User_idUser`,`Sale_Client_idClient`),
  KEY `fk_Product_has_Sale_Sale1_idx` (`Sale_idSale`,`Sale_User_idUser`,`Sale_Client_idClient`),
  KEY `fk_Product_has_Sale_Product1_idx` (`Product_idProduct`),
  CONSTRAINT `fk_Product_has_Sale_Product1` FOREIGN KEY (`Product_idProduct`) REFERENCES `product` (`idProduct`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_Sale_Sale1` FOREIGN KEY (`Sale_idSale`, `Sale_User_idUser`, `Sale_Client_idClient`) REFERENCES `sale` (`idSale`, `User_idUser`, `Client_idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.itemssale: ~3 rows (aproximadamente)
DELETE FROM `itemssale`;
/*!40000 ALTER TABLE `itemssale` DISABLE KEYS */;
INSERT INTO `itemssale` (`Product_idProduct`, `Sale_idSale`, `Sale_User_idUser`, `Sale_Client_idClient`) VALUES
	(6, 1, 1, 3),
	(8, 2, 2, 2),
	(8, 3, 1, 1);
/*!40000 ALTER TABLE `itemssale` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.monthlyfixedexpense
CREATE TABLE IF NOT EXISTS `monthlyfixedexpense` (
  `dateFixedExpense` date NOT NULL,
  `useMaterial` float DEFAULT NULL,
  `equipment` float DEFAULT NULL,
  `monthlyTax` float DEFAULT NULL,
  `rent` float DEFAULT NULL,
  `loan` float DEFAULT NULL,
  `maintenance` float DEFAULT NULL,
  `employee` float DEFAULT NULL,
  `others` float DEFAULT NULL,
  PRIMARY KEY (`dateFixedExpense`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.monthlyfixedexpense: ~1 rows (aproximadamente)
DELETE FROM `monthlyfixedexpense`;
/*!40000 ALTER TABLE `monthlyfixedexpense` DISABLE KEYS */;
INSERT INTO `monthlyfixedexpense` (`dateFixedExpense`, `useMaterial`, `equipment`, `monthlyTax`, `rent`, `loan`, `maintenance`, `employee`, `others`) VALUES
	('2019-12-04', 100, 20, 80, 70, 0, 0, 0, 10);
/*!40000 ALTER TABLE `monthlyfixedexpense` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.product
CREATE TABLE IF NOT EXISTS `product` (
  `idProduct` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `cost` float NOT NULL,
  `percentProfit` float NOT NULL,
  `priceSale` float DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `provider_idprovider` int(11) NOT NULL,
  `category_idcategory` int(11) NOT NULL,
  `brand_idbrand` int(11) NOT NULL,
  PRIMARY KEY (`idProduct`,`provider_idprovider`,`category_idcategory`,`brand_idbrand`),
  KEY `fk_Product_provider1_idx` (`provider_idprovider`),
  KEY `fk_Product_category1` (`category_idcategory`),
  KEY `fk_Product_brand1` (`brand_idbrand`),
  CONSTRAINT `fk_Product_brand1` FOREIGN KEY (`brand_idbrand`) REFERENCES `brand` (`idBrand`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_category1` FOREIGN KEY (`category_idcategory`) REFERENCES `category` (`idCategory`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_provider1` FOREIGN KEY (`provider_idprovider`) REFERENCES `provider` (`idprovider`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.product: ~3 rows (aproximadamente)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`idProduct`, `name`, `cost`, `percentProfit`, `priceSale`, `quantity`, `provider_idprovider`, `category_idcategory`, `brand_idbrand`) VALUES
	(6, 'Brusinha', 5, 125, 11.25, 100, 2, 2, 1),
	(7, 'Tênis', 20, 200, 60, 25, 2, 7, 1),
	(8, 'Cachecol Rosa', 3, 800, 27, 10, 1, 4, 5);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.provider: ~2 rows (aproximadamente)
DELETE FROM `provider`;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
INSERT INTO `provider` (`idProvider`, `companyName`, `adress`, `city`, `fu`, `cnpj`, `ownerName`, `email`, `contact`) VALUES
	(1, 'Sex Shop Fogo no Rabo', 'Rua da Libido', 'Alfemeas', 'MG', '1501501', '', 'nao tem', '1991923'),
	(2, 'Nike company do camelô ', 'bras', 'São Paulo', 'SP', '123456789', 'camelô ', 'casadocaralho@pqp.com.br', '190');
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.sale
CREATE TABLE IF NOT EXISTS `sale` (
  `idSale` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `type` enum('prazo','vista','crédito','débito') NOT NULL,
  `discount` float DEFAULT NULL,
  `tax` float DEFAULT NULL,
  `User_idUser` int(11) NOT NULL,
  `Client_idClient` int(11) NOT NULL,
  PRIMARY KEY (`idSale`,`User_idUser`,`Client_idClient`),
  KEY `fk_Sale_Employee_idx` (`User_idUser`),
  KEY `fk_Sale_Client1_idx` (`Client_idClient`),
  CONSTRAINT `fk_Sale_Client1` FOREIGN KEY (`Client_idClient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sale_Employee` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.sale: ~3 rows (aproximadamente)
DELETE FROM `sale`;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` (`idSale`, `date`, `type`, `discount`, `tax`, `User_idUser`, `Client_idClient`) VALUES
	(1, '2019-12-04 21:37:02', 'prazo', 0, 10, 1, 3),
	(2, '2019-12-04 21:39:07', 'prazo', NULL, 18, 2, 2),
	(3, '2019-12-04 21:39:26', 'vista', 99, 0, 1, 1);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;

-- Copiando estrutura para tabela sevensales.user
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `cpf` int(11) NOT NULL,
  `fu` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contact` varchar(45) NOT NULL,
  `idAccess` int(11) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sevensales.user: ~2 rows (aproximadamente)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`idUser`, `username`, `password`, `name`, `city`, `adress`, `cpf`, `fu`, `email`, `contact`, `idAccess`) VALUES
	(1, 'mleitejunior', '1234', 'Marcelo Leite Junior', 'Machado', 'Nao tem', 151516, 'MG', 'mleitejunior@gmail.com', '35 99991234', 1),
	(2, 'shingeriu', 'japaloko', 'Alexingeriu de Sushimoiama', 'Hiroshima', 'Longe', 15651561, 'KO', 'omaea@shingeriu.nani', '12315161', 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Copiando estrutura para trigger sevensales.calculatePrice
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER';
DELIMITER //
CREATE TRIGGER `calculatePrice` BEFORE INSERT ON `product` FOR EACH ROW BEGIN
set new.priceSale = new.cost + new.cost * new.percentProfit/100;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
