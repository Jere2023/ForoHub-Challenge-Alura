-- Tabla de Perfiles
CREATE TABLE perfil (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Tabla de Usuarios
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

-- Tabla intermedia para relación muchos a muchos entre Usuarios y Perfiles
CREATE TABLE usuario_perfil (
    usuario_id INT REFERENCES usuario(id),
    perfil_id INT REFERENCES perfil(id),
    PRIMARY KEY (usuario_id, perfil_id)
);

-- Tabla de Cursos
CREATE TABLE curso (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

-- Tabla de Tópicos
CREATE TABLE topico (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor_id INT REFERENCES usuario(id),
    curso_id INT REFERENCES curso(id)
);

-- Tabla de Respuestas
CREATE TABLE respuesta (
    id SERIAL PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    autor_id INT REFERENCES usuario(id),
    topico_id INT REFERENCES topico(id),
    solucion BOOLEAN DEFAULT FALSE
);
