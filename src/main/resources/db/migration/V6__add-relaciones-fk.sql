ALTER TABLE usuario ADD CONSTRAINT fk_usuario_perfil FOREIGN KEY (perfil_id) REFERENCES perfil (id);
ALTER TABLE topico ADD CONSTRAINT fk_topico_curso FOREIGN KEY (curso_id) REFERENCES curso(id);
ALTER TABLE topico ADD CONSTRAINT fk_topico_usuario FOREIGN KEY (autor_id) REFERENCES usuario(id);
ALTER TABLE respuesta ADD CONSTRAINT fk_respuesta_usuario FOREIGN KEY (autor_id) REFERENCES usuario(id);
ALTER TABLE respuesta ADD CONSTRAINT fk_respuesta_topico FOREIGN KEY  (topico_id) REFERENCES topico(id);

