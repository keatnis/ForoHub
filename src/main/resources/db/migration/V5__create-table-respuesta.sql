CREATE TABLE respuesta (
id bigint not null auto_increment,
mensaje varchar(250) not null,
topico_id bigint not null,
fecha datetime not null,
autor_id bigint not null,
solucion text,

PRIMARY KEY (id)
);