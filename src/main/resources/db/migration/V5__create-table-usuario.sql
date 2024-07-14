CREATE TABLE usuario (
id bigint NOT NULL auto_increment,
nombre varchar(60) not null unique,
email varchar(100) not null unique,
password varchar(200) not null,

PRIMARY KEY(id)
);