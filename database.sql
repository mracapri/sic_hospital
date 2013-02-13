DROP DATABASE sic_hospital;
CREATE DATABASE IF NOT EXISTS sic_hospital;
USE sic_hospital;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET NAMES 'UTF8';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE TABLE IF NOT EXISTS estado (
  id_estado integer(3) NOT NULL,  
  estado varchar(30) NOT NULL,       
  PRIMARY KEY (id_estado)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS municipio (
  id_municipio integer(3) NOT NULL,
  id_estado integer(3) NOT NULL,  
  municipio varchar(30) NOT NULL,       
  PRIMARY KEY (id_municipio),
  FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS institucion (
  id_institucion integer(3) NOT NULL,
  id_municipio integer(3) NOT NULL,
  id_estado integer(3) NOT NULL,  
  institucion varchar(50) NOT NULL,       
  PRIMARY KEY (id_institucion),
  FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
  FOREIGN KEY (id_municipio) REFERENCES municipio(id_municipio)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Catalogos*/
CREATE TABLE IF NOT EXISTS unidad_medica (
  id_unidad_medica integer(3) NOT NULL,
  unidad_medica varchar(30) NOT NULL,          
  PRIMARY KEY (id_unidad_medica)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS turno (
  id_turno integer(3) NOT NULL,
  turno varchar(30) NOT NULL,          
  PRIMARY KEY (id_turno)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS periodo_revision (
  id_periodo integer(3) NOT NULL,
  periodo varchar(30) NOT NULL,          
  PRIMARY KEY (id_periodo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS num_visitas (
  id_visita integer(3) NOT NULL,
  visita varchar(30) NOT NULL,          
  PRIMARY KEY (id_visita)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS aval (
  id_aval integer(3) NOT NULL,
  aval varchar(30) NOT NULL,          
  PRIMARY KEY (id_aval)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS area (
  id_area integer(3) NOT NULL,
  area varchar(30) NOT NULL,          
  PRIMARY KEY (id_area)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS nivel_atencion (
  id_nivel integer(3) NOT NULL,
  nivel varchar(30) NOT NULL,          
  PRIMARY KEY (id_nivel)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS servicio (
  id_servicio integer(3) NOT NULL,
  servicio varchar(30) NOT NULL,          
  PRIMARY KEY (id_servicio)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;