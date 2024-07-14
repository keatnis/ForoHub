CREATE TABLE respuesta (
id bigint not null auto_increment,
mensaje varchar(250) not null,
topico_id bigint not null,
fecha_creacion datetime not null,
usuario_id bigint not null,
solucion text,

PRIMARY KEY (id)
);