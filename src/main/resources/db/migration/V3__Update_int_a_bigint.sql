ALTER TABLE usuario_perfil MODIFY usuario_id BIGINT;
ALTER TABLE usuario_perfil MODIFY perfil_id BIGINT;

ALTER TABLE topico MODIFY autor_id BIGINT;
ALTER TABLE topico MODIFY curso_id BIGINT;

ALTER TABLE respuesta MODIFY autor_id BIGINT;
ALTER TABLE respuesta MODIFY topico_id BIGINT;