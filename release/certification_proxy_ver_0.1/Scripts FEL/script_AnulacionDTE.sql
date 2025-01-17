CREATE TABLE IF NOT EXISTS `AnulacionDTE` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `num_doc_anular` varchar(50) DEFAULT NULL,
  `nit_emisor` varchar(50) DEFAULT NULL,
  `id_receptor` varchar(50) DEFAULT NULL,
  `fechaEmisionDoc_anular` varchar(50) DEFAULT NULL,
  `fecha_hora_anulacion` varchar(50) DEFAULT NULL,
  `motivo_anulacion` varchar(50) DEFAULT NULL,
  `tipo_doc_dte` varchar(50) DEFAULT NULL,
  `Requestor` varchar(50) DEFAULT NULL,
  `Transaction` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `Entity` varchar(50) DEFAULT NULL,
  `User` varchar(50) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  `Data1` varchar(50) DEFAULT NULL,
  `Data3` varchar(50) DEFAULT NULL,
  `urlWS` varchar(250) DEFAULT NULL,
  `Result` varchar(50) DEFAULT NULL,
  `Code` varchar(50) DEFAULT NULL,
  `Description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;