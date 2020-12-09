CREATE TABLE IF NOT EXISTS `cliente` (
  `id` char(36) NOT NULL,
  `codigo` char(36) NOT NULL,
  `tipoIdentificacion` int(11) DEFAULT NULL,
  `identificacion` varchar(20) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `tipoCliente` int(11) DEFAULT '1',
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT 'facturacioncliente@consurr7h.com',
  `codigoISOPais` varchar(45) DEFAULT 'ECU',
  `pais` varchar(200) DEFAULT 'ECUADOR',
  `provincia` varchar(200) DEFAULT 'EL ORO',
  `ciudad` varchar(200) DEFAULT 'SANTA ROSA',
  `direccion` varchar(100) DEFAULT '.',
  `formaPago` int(11) DEFAULT '1',
  `condicionPago` int(11) DEFAULT '1',
  `descripcion` text,
  `estado` int(11) DEFAULT '1',
  `fechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fechaActualizacion` timestamp NULL DEFAULT NULL,
  `sync_field` int(11) DEFAULT '0',
  `codigoPostal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla AS2.cliente: ~15.397 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id`, `codigo`, `tipoIdentificacion`, `identificacion`, `nombre`, `tipoCliente`, `telefono`, `email`, `codigoISOPais`, `pais`, `provincia`, `ciudad`, `direccion`, `formaPago`, `condicionPago`, `descripcion`, `estado`, `fechaCreacion`, `fechaActualizacion`, `sync_field`, `codigoPostal`) VALUES
	('00000000-0000-0000-0000-000000000000', '0', 7, 'CF', 'CONSUMIDOR FINAL', 1, '72985629', 'facturacion@consurr7h.com', 'GTA', 'GT', '.', '.', 'CIUDAD', 1, 99, 'COBRO PEAJE', 1, '2020-04-28 11:31:11', '2019-04-04 10:40:35', 1, '01005');

