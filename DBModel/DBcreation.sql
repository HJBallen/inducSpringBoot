CREATE TABLE producto (
    id serial NOT NULL,
    nombre varchar(100) NOT NULL,
    imagen varchar(255) NOT NULL,
    descripcion varchar(255) NOT NULL,
    id_categoria varchar(50) NOT NULL,
    estado varchar(2) NOT NULL DEFAULT 'AC',
    PRIMARY KEY (id)
);

CREATE TABLE categoria (
    id varchar(50) NOT NULL,
    descripcion varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE usuario (
    id bigint NOT NULL,
    nombre varchar(50) NOT NULL,
    apellido varchar(50) NOT NULL,
    password varchar(255) NOT NULL,
    fecha_registro date NOT NULL,
    username varchar(50) NOT NULL UNIQUE,
    estado varchar(2) NOT NULL DEFAULT 'AC',
    PRIMARY KEY (id)
);

-- Foreign key constraints
-- Schema: public
ALTER TABLE producto ADD CONSTRAINT fk_producto_idCategoria_categoria_id FOREIGN KEY(id_categoria) REFERENCES categoria(id);