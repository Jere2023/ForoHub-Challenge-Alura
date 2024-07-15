-- V2__Update_autor_id_column.sql
ALTER TABLE topico MODIFY autor_id BIGINT;
ALTER TABLE topico MODIFY curso_id BIGINT;
ALTER TABLE respuesta MODIFY autor_id BIGINT;
