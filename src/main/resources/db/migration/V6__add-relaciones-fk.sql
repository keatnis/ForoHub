 alter table respuesta
       add constraint fk_respuesta_topico
       foreign key (topico_id)
       references topico (id);

 alter table respuesta
       add constraint fk_respuesta_usuario
       foreign key (usuario_id)
       references usuario (id);

 alter table topico
       add constraint fk_topico_curso
       foreign key (curso_id)
       references curso (id);

alter table topico
        add constraint fk_topico_usuario
         foreign key (usuario_id)
         references usuario(id);