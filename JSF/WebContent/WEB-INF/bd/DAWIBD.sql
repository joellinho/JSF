create database DawiiDB;

use DawiiDB;

CREATE TABLE IF NOT EXISTS `tb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `nivel` int(11) NOT NULL,
  `orden` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `url` varchar(120) DEFAULT NULL,
  `icono` varchar(30) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Menu_Menu1` (`menu_id`)
) ;

CREATE TABLE IF NOT EXISTS `tb_rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `tb_rolmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rol_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_RolMenu_Rol` (`rol_id`),
  KEY `fk_RolMenu_Menu1` (`menu_id`)
) ;

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rol_id` int(11) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `clave` varchar(32) NOT NULL,
  `email` varchar(60) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `usuariocreacion` varchar(25) NOT NULL,
  `fechacreacion` datetime NOT NULL,
  `usuariomodificacion` varchar(25) DEFAULT NULL,
  `fechamodificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Usuario_Rol1` (`rol_id`)
) ;

INSERT INTO `tb_rol` (`id`, `nombre`, `descripcion`, `estado`) VALUES(1, 'Admin', 'administrador del sistema', 1);

INSERT INTO `tb_usuario` (`id`, `rol_id`, `usuario`, `clave`, `email`, `estado`, `usuariocreacion`, `fechacreacion`, `usuariomodificacion`, `fechamodificacion`) VALUES
(1, 1, 'admin', 'admin', 'montesinos2005ii@gmail.com', 1, 'usu', '2013-01-01 000000', 'usu', '2013-01-01 000000'),
(2, 1, 'admin22', 'admin2', 'admin22@gmail.com', NULL, 'admin', '2013-04-21 000000', NULL, NULL),
(6, 1, 'admin3', 'admin3', 'prueba@gmail.com', NULL, 'admin', '2013-04-21 000000', NULL, NULL),
(7, 1, 'admin2', 'admin2', 'prueba@gmail.com', NULL, 'admin', '2013-04-21 000000', NULL, NULL);

ALTER TABLE `tb_menu`ADD CONSTRAINT `fk_Menu_Menu1` FOREIGN KEY (`menu_id`) REFERENCES `tb_menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `tb_rolmenu`
  ADD CONSTRAINT `fk_RolMenu_Menu1` FOREIGN KEY (`menu_id`) REFERENCES `tb_menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_RolMenu_Rol` FOREIGN KEY (`rol_id`) REFERENCES `tb_rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `tb_usuario`
  ADD CONSTRAINT `fk_Usuario_Rol1` FOREIGN KEY (`rol_id`) REFERENCES `tb_rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
