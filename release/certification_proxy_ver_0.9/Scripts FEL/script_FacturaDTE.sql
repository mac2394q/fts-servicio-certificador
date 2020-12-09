-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla easyroad.facturadte
CREATE TABLE IF NOT EXISTS `FacturaDTE` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_hora_emision` varchar(50) DEFAULT NULL,
  `moneda` varchar(50) DEFAULT NULL,
  `nit_emisor` varchar(50) DEFAULT NULL,
  `nombre_emisor` varchar(50) DEFAULT NULL,
  `codigo_establecimiento` varchar(50) DEFAULT NULL,
  `nombre_comercial` varchar(50) DEFAULT NULL,
  `afiliacion_iva` varchar(50) DEFAULT NULL,
  `direccion_emisor` varchar(50) DEFAULT NULL,
  `codPostal_emisor` varchar(50) DEFAULT NULL,
  `municipio_emisor` varchar(50) DEFAULT NULL,
  `departamento_emisor` varchar(50) DEFAULT NULL,
  `pais_emisor` varchar(50) DEFAULT NULL,
  `id_receptor` varchar(50) DEFAULT NULL,
  `nombre_receptor` varchar(50) DEFAULT NULL,
  `direccion_receptor` varchar(50) DEFAULT NULL,
  `codPostal_receptor` varchar(50) DEFAULT NULL,
  `municipio_receptor` varchar(50) DEFAULT NULL,
  `departamento_receptor` varchar(50) DEFAULT NULL,
  `pais_receptor` varchar(50) DEFAULT NULL,
  `tipo_frase1` varchar(50) DEFAULT NULL,
  `tipo_frase2` varchar(50) DEFAULT NULL,
  `cod_escenario1` varchar(50) DEFAULT NULL,
  `cod_escenario2` varchar(50) DEFAULT NULL,
  `numLinea_item` varchar(50) DEFAULT NULL,
  `bienoservicio_item` varchar(50) DEFAULT NULL,
  `cantidad_item` varchar(50) DEFAULT NULL,
  `uniMedida_item` varchar(50) DEFAULT NULL,
  `descripcion_item` varchar(50) DEFAULT NULL,
  `precioUnitario_item` varchar(50) DEFAULT NULL,
  `precio_item` varchar(50) DEFAULT NULL,
  `descuento_item` varchar(50) DEFAULT NULL,
  `nombre_impuesto` varchar(50) DEFAULT NULL,
  `codGravable_impuesto` varchar(50) DEFAULT NULL,
  `montoGravable_impuesto` varchar(50) DEFAULT NULL,
  `monto_impuesto` varchar(50) DEFAULT NULL,
  `total_monto_impuesto` varchar(50) DEFAULT NULL,
  `total` varchar(50) DEFAULT NULL,
  `numAutorizacion` varchar(50) DEFAULT NULL,
  `result` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `entity` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `data3` varchar(50) DEFAULT NULL,
  `transaction` varchar(50) DEFAULT NULL,
  `requestor` varchar(50) DEFAULT NULL,
  `data1` varchar(50) DEFAULT NULL,
  `data2` varchar(20000) DEFAULT NULL,
  `responseData1` varchar(30000) DEFAULT NULL,
  `numeroAcceso` varchar(50) DEFAULT NULL,
  `estado_certificacion` varchar(50) DEFAULT NULL,
  `idDte` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
