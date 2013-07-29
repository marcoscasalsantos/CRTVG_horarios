-- Script de creación de esquema de BD y carga de datos iniciales para arracado de la aplicacion gestionCambio

--Estructura DDL


drop table if exists users_roles;
drop sequence if exists seq_role;
drop table if exists role;
drop sequence if exists seq_user;
drop table if exists user;

drop table if exists horarios_horas;
drop table if exists horarios_dias;
drop table if exists producciones;
DROP TABLE IF EXISTS ubicaciones;
DROP TABLE IF EXISTS SECCIONES;
drop table if exists empleados;
drop table if exists profesiones;

-- creacion de tablas y sequences

-- IMPORTANTE fijar el valor inicial en un número superior a los valores introducidos en las correspondientes tablas
create sequence seq_roles increment 1 start 3;
create sequence seq_users increment 1 start 2;

-- creacion de tablas y sequences
create table users ( 
  user_id number not null primary key,
  username varchar(20) not null,
  password varchar(20) not null,
  name varchar(50),
  surnames varchar(50),
  birth_date date,
  nif varchar(10),
  email varchar(50),
  enabled char(1) not null,
  blocked char(1) not null
); 

--create sequence seq_user increment 1 start 1;

create table roles (
  role_id number not null primary key, 
  role_name varchar(20) not null
);

--create sequence seq_role increment 1 start 1;

create table users_roles (
  user_id number not null,
  role_id number not null,
  constraint pk_roles PRIMARY KEY (user_id, role_id),
  constraint fk_users_roles_user foreign key(user_id) references users(user_id),
  constraint fk_users_roles_role foreign key(role_id) references roles(role_id)
);


-- users
insert into users (user_id, username, password, name, surnames, birth_date, nif, email, enabled, blocked)
values (1, 'admin', 'admin', 'Marcos', 'Casal Santos', '02/11/1978','dd/	/yyyy'), '46899482K', 'marcos.casalsantos@plexus.es', '1', '0');

-- roles
insert into roles (role_id, role_name) values (1, 'ROLE_USER');
insert into roles (role_id, role_name) values (2, 'ROLE_ADMIN');

-- r_user_role
insert into users_roles (user_Id, role_id) values (1,1);
insert into users_roles (user_Id, role_id) values (1,2);

CREATE TABLE PROFESIONES(
ID_PROFESION number NOT NULL,
PROFESION VARCHAR(255) NOT NULL,
ID_USUARIO_ALTA number,
FECHA_ALTA DATE,
ID_USUARIO_MODIFICACION number,
FECHA_MODIFICACION TIMESTAMP NOT NULL,
PRIMARY KEY (ID_PROFESION)
);

INSERT INTO profesiones (id_profesion, profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(1,	'Operador de vídeo', NULL, NULL, NULL, CURRENT_TIMESTAMP);
INSERT INTO profesiones (id_profesion, profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(2,	'Posproductor de vídeo', NULL, NULL, NULL,	CURRENT_TIMESTAMP);
INSERT INTO profesiones (id_profesion, profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(3,	'Deseñador gráfico', NULL, NULL, NULL, CURRENT_TIMESTAMP);

CREATE TABLE EMPLEADOS(
ID_EMPLEADO number NOT NULL,
NOMBRE VARCHAR(255) NOT NULL,
APELLIDOS VARCHAR(255) NOT NULL,
ID_PROFESION number NOT NULL,
ID_USUARIO_ALTA SMALLINT,
FECHA_ALTA DATE,
ID_USUARIO_MODIFICACION SMALLINT,
FECHA_MODIFICACION TIMESTAMP,
PRIMARY KEY (ID_EMPLEADO),
constraint fk_empleados_profesiones foreign key (id_profesion) references profesiones (id_profesion)
);

INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(1,'Agustín',	'Sanmartín',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(2,'Alfredo',	'Sanchez',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(3,'Blanca',	'Moreira',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(4,'Ricardo',	'Dacal',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(5,'Pablo',	'Landazabal',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(6,'Adrian',	'Gonzalez Bermudez',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(7,'Mónica',	'Ferro',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(8,'Begoña',	'Arnosi',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(9,'Rocio',	'Torres',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(10,'Verónica',	'Pita',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(11,'Jose Antonio',	'Estevez',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(12,'Gonzalo',	'Lores',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(13,'Ana',	'Castelo',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(14,'Diego',	'Ocampo',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(15,'Daniel',	'G. Portela',	1,	NULL,'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(16,'Luís',	'Peña',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(17,'Guillermo', 'Fernandez',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(18,'Juan Ramón', 'Tajes',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(19,'Angel', 'G. Balseiro',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);
INSERT INTO empleados (id_empleado, nombre, apellidos, id_profesion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(20,'Xoan', 'Pereira Couso',	1,	NULL,	'27/06/2013','dd/mm/yyyy'),	NULL,	current_timestamp);

CREATE TABLE secciones (
  id_seccion number NOT NULL,
  seccion varchar(255) NOT NULL,
  id_usuario_alta number DEFAULT NULL,
  fecha_alta date DEFAULT NULL,
  id_usuario_modificacion number DEFAULT NULL,
  fecha_modificacion timestamp NOT NULL,
  PRIMARY KEY (id_seccion)
);

INSERT INTO secciones (id_seccion, seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(1,	'Quendas de salas de Posprodución de vídeo',	NULL,	NULL,	NULL,	current_timestamp);
INSERT INTO secciones (id_seccion, seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(2,	'Quendas dos Operadores de vídeo',	NULL,	NULL,	NULL,	current_timestamp);
INSERT INTO secciones (id_seccion, seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(3,	'Quendas de Deseño gráfico',	NULL,	NULL,	NULL,	current_timestamp);


CREATE TABLE ubicaciones (
  id_ubicacion number NOT NULL,
  ubicacion varchar(255) NOT NULL,
  id_seccion number NOT NULL,
  id_usuario_alta number DEFAULT NULL,
  fecha_alta date DEFAULT NULL,
  id_usuario_modificacion number DEFAULT NULL,
  fecha_modificacion timestamp NOT NULL,
  PRIMARY KEY (id_ubicacion),
  CONSTRAINT fk_ubicaciones_secciones FOREIGN KEY (id_seccion) REFERENCES secciones(id_seccion)
);

INSERT INTO ubicaciones (id_ubicacion, ubicacion, id_seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(1,	'CABINA 1',	1,	NULL,	NULL,	NULL,	current_timestamp);
INSERT INTO ubicaciones (id_ubicacion, ubicacion, id_seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(2,	'CABINA 2',	1,	NULL,	NULL,	NULL,	current_timestamp);
INSERT INTO ubicaciones (id_ubicacion, ubicacion, id_seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(3,	'CABINA 4',	1,	NULL,	NULL,	NULL,	current_timestamp);
INSERT INTO ubicaciones (id_ubicacion, ubicacion, id_seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(4,	'CABINA 5',	1,	NULL,	NULL,	NULL,	current_timestamp);
INSERT INTO ubicaciones (id_ubicacion, ubicacion, id_seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(5,	'CABINA 6',	1,	NULL,	NULL,	NULL,	current_timestamp);
INSERT INTO ubicaciones (id_ubicacion, ubicacion, id_seccion, id_usuario_alta, fecha_alta, id_usuario_modificacion, fecha_modificacion) VALUES
(6,	'CABINA 7',	1,	NULL,	NULL,	NULL,	current_timestamp);


create table producciones (
  id_produccion number not null,
  produccion varchar(255) not null,
  
  fecha_alta date DEFAULT NULL,
  id_usuario_modificacion smallint DEFAULT NULL,
  fecha_modificacion timestamp NOT NULL,  
  
  primary key (id_produccion)
);

INSERT INTO producciones (id_produccion, produccion, fecha_modificacion) values 
(1, 'Infor. e Depor.', current_timestamp);
INSERT INTO producciones (id_produccion, produccion, fecha_modificacion) values 
(2, 'Tx Local', current_timestamp);
INSERT INTO producciones (id_produccion, produccion, fecha_modificacion) values 
(3, 'Informativos', current_timestamp);
INSERT INTO producciones (id_produccion, produccion, fecha_modificacion) values 
(4, 'Autopromocións', current_timestamp);
INSERT INTO producciones (id_produccion, produccion, fecha_modificacion) values 
(5, 'Heicho cantar', current_timestamp);
INSERT INTO producciones (id_produccion, produccion, fecha_modificacion) values 
(6, 'Deportes TDT', current_timestamp);
INSERT INTO producciones (id_produccion, produccion, fecha_modificacion) values 
(7, 'Vivir aquí', current_timestamp);


create table horarios_dias (
  id_dia_horario number not null,
  id_ubicacion number not null,
  fecha_dia date not null,
  festivo char(1) not null,
  
  id_usuario_modificacion number DEFAULT NULL,
  fecha_modificacion timestamp NOT NULL,
  
  primary key (id_dia_horario),
  constraint fk_dias_ubicaciones foreign key (id_ubicacion) references ubicaciones (id_ubicacion)
);

COMMENT ON TABLE horarios_dias IS 'Tabla con las relaciones día-ubicación';

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(1, 1, '2013-05-06', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(2, 1, '2013-05-07', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(3, 1, '2013-05-08', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(4, 1, '2013-05-09', '1', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(5, 1, '2013-05-10', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(6, 1, '2013-05-11', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(7, 1, '2013-05-12', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(8, 2, '2013-05-06', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(9, 2, '2013-05-07', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(10, 2, '2013-05-08', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(11, 2, '2013-05-09', '1', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(12, 2, '2013-05-10', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(13, 2, '2013-05-11', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(14, 2, '2013-05-12', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(15, 3, '2013-05-06', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(16, 3, '2013-05-07', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(17, 3, '2013-05-08', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(18, 3, '2013-05-09', '1', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(19, 3, '2013-05-10', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(20, 3, '2013-05-11', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(21, 3, '2013-05-12', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(22, 4, '2013-05-06', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(23, 4, '2013-05-07', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(24, 4, '2013-05-08', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(25, 4, '2013-05-09', '1', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(26, 4, '2013-05-10', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(27, 4, '2013-05-11', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(28, 4, '2013-05-12', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(29, 5, '2013-05-06', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(30, 5, '2013-05-07', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(31, 5, '2013-05-08', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(32, 5, '2013-05-09', '1', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(33, 5, '2013-05-10', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(34, 5, '2013-05-11', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(35, 5, '2013-05-12', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(36, 6, '2013-05-06', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(37, 6, '2013-05-07', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(38, 6, '2013-05-08', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(39, 6, '2013-05-09', '1', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(40, 6, '2013-05-10', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(41, 6, '2013-05-11', '0', current_timestamp);

insert into horarios_dias (id_dia_horario, id_ubicacion, fecha_dia, festivo,fecha_modificacion) values 
(42, 6, '2013-05-12', '0', current_timestamp);


create table horarios_horas (
  id_horas_dia int not null,
  id_dia_horario int not null,
  hora_desde date,
  hora_hasta date,
  id_empleado number,
  id_sustituto number,
  
  id_produccion number,
  
  id_usuario_modificacion number DEFAULT NULL,
  fecha_modificacion timestamp NOT NULL,
  
  primary key (id_horas_dia),
  constraint horas_empleado_unique unique (id_dia_horario, id_empleado, hora_desde, hora_hasta),	
  constraint fk_horas_dias foreign key (id_dia_horario) references horarios_dias (id_dia_horario),
  constraint fk_horas_producciones foreign key (id_produccion) references producciones (id_produccion)
);
  
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(1, 1, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 1, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(2, 1, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 2, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(3, 2, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 1, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(4, 2, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 2, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(5, 3, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 1, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(6, 3, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 2, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(7, 4, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 1, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(8, 4, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 2, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(9, 5, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 1, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(10, 5, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 2, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(11, 6, '09:00', 'hh:MM'), '00:00', 'hh:MM'), 3, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(12, 7, '10:00', 'hh:MM'), '01:00', 'hh:MM'), 3, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(13, 8, '07:30', 'hh:MM'), '14:30', 'hh:MM'), 4, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(14, 8, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 5, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(15, 9, '07:30', 'hh:MM'), '14:30', 'hh:MM'), 4, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(16, 9, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 6, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(17, 10, '07:30', 'hh:MM'), '14:30', 'hh:MM'), 4, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(18, 10, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 6, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(19, 11, '07:30', 'hh:MM'), '14:30', 'hh:MM'), 4, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(20, 11, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 6, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(21, 12, '07:30', 'hh:MM'), '14:30', 'hh:MM'), 4, 5, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(22, 12, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 6, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(23, 13, '09:00', 'hh:MM'), '00:00', 'hh:MM'), 7, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(24, 14, '10:00', 'hh:MM'), '01:00', 'hh:MM'), 7, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(25, 15, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 8, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(26, 15, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 10, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(27, 16, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 8, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(28, 16, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 10, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(29, 17, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 8, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(30, 17, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 10, 11, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(31, 18, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 8, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(32, 18, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 10, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(33, 19, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 8, 9, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(34, 19, '16:30', 'hh:MM'), '00:00', 'hh:MM'), 10, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(35, 20, '09:00', 'hh:MM'), '00:00', 'hh:MM'), 3, 1, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(36, 21, '10:00', 'hh:MM'), '01:00', 'hh:MM'), 3, 1, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(37, 22, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 13, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(38, 22, '16:00', 'hh:MM'), '23:30', 'hh:MM'), 14, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(39, 23, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 13, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(40, 23, '16:00', 'hh:MM'), '23:30', 'hh:MM'), 14, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(41, 24, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 13, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(42, 24, '16:00', 'hh:MM'), '23:30', 'hh:MM'), 14, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(43, 25, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 13, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(44, 25, '16:00', 'hh:MM'), '23:30', 'hh:MM'), 14, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(45, 26, '07:30', 'hh:MM'), '15:00', 'hh:MM'), 13, null, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(46, 26, '16:00', 'hh:MM'), '23:30', 'hh:MM'), 14, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(47, 27, '09:00', 'hh:MM'), '00:00', 'hh:MM'), 15, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(48, 28, '10:00', 'hh:MM'), '01:00', 'hh:MM'), 15, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(49, 29, '07:00', 'hh:MM'), '14:30', 'hh:MM'), 16, 17, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(50, 29, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 18, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(51, 30, '07:00', 'hh:MM'), '14:30', 'hh:MM'), 16, 17, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(52, 30, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 18, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(53, 31, '07:00', 'hh:MM'), '14:30', 'hh:MM'), 16, 17, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(54, 31, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 18, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(55, 32, '07:00', 'hh:MM'), '14:30', 'hh:MM'), 16, 17, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(56, 32, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 18, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(57, 33, '07:00', 'hh:MM'), '14:30', 'hh:MM'), 16, 17, 1, current_timestamp);
insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(58, 33, '14:30', 'hh:MM'), '22:00', 'hh:MM'), 18, null, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(59, 34, '08:00', 'hh:MM'), '23:00', 'hh:MM'), 19, 20, 1, current_timestamp);

insert into horarios_horas (id_horas_dia, id_dia_horario, hora_desde, hora_hasta, id_empleado, id_sustituto, id_produccion, fecha_modificacion) values
(60, 35, '09:00', 'hh:MM'), '00:00', 'hh:MM'), 19, 20, 1, current_timestamp);
