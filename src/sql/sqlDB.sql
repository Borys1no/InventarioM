/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  borys
 * Created: 6 mar 2023
 */

CREATE DATABASE IF NOT EXISTS inventory;
USE inventory;

-- -----------------------------------------------------
-- Table `inventory`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE,
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) VISIBLE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `inventory`.`productos` (
  `id_productos` INT NOT NULL AUTO_INCREMENT,
  `nombre_producto` VARCHAR(45) NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` DECIMAL NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `fecha_caducidad` DATE NOT NULL,
  `proveedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_productos`))
ENGINE = InnoDB;

ALTER TABLE productos modify fecha_caducidad DATE;
ALTER TABLE productos modify precio DECIMAL(8, 2);



CREATE TABLE IF NOT EXISTS `inventory`.`salida` (
  `id_salida` INT NOT NULL AUTO_INCREMENT,
  `producto_salida` VARCHAR(45) NOT NULL,
  `cantidad_salida` DECIMAL NOT NULL,
  `fecha_salida` DATE NOT NULL,
  `total_venta` DECIMAL NOT NULL,
  `producto_id` INT NULL,
  PRIMARY KEY (`id_salida`),
  INDEX `producto_id_idx` (`producto_id` ASC) VISIBLE,
  CONSTRAINT `producto_id`
    FOREIGN KEY (`producto_id`)
    REFERENCES `inventory`.`productos` (`id_productos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


ALTER TABLE salida modify total_venta DECIMAL(8, 2);

ALTER TABLE salida;

ADD CONSTRAINT producto_id
FOREIGN KEY (producto_id)
REFERENCES productos(id_productos)
ON DELETE CASCADE
ON UPDATE NO ACTION;

insert into usuario (nombres, apellidos, usuario, correo, password)
values 
	('Borys Alvaro', 'Cereceda Guzman', 'borysuno', 'boryscereceda@hotmail.com', 'facil2023');




insert into productos (nombre_producto, cantidad, precio, fecha_ingreso, tipo, fecha_caducidad, proveedor)
values
	('atun', 12, 1.50, '2023-10-10', 'no perecible', '2025-10-10', 'isabel' );



SELECT producto_id, nombre_producto, precio, fecha_ingreso, tipo, fecha_caducidad, cantidad, proveedor, cantidad_salida, fecha_salida, total_venta FROM salida
INNER JOIN productos
ON salida.producto_id = productos.id_productos;
DELETE FROM productos WHERE id_productos='1';
ALTER TABLE salida
DROP FOREIGN KEY producto_id;