CREATE TABLE `configuracion` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`Parametro` VARCHAR(100) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`descripcion` VARCHAR(200) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`ValorNumerico` INT(11) NULL DEFAULT '0',
	`ValorAlpha` VARCHAR(150) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`ValorMoneda` DECIMAL(10,2) NULL DEFAULT '0.00',
	`Habilitador` INT(11) NULL DEFAULT '0',
	`codigo` VARCHAR(45) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DYNAMIC
;
