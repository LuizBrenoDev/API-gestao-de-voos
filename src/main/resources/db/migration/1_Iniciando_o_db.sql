create database myflight;

CREATE TABLE clients (
	id LONG PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    cpf BIGINT NOT NULL UNIQUE,
    birthDate DATE NOT NULL
);

CREATE TABLE flight (
	id LONG PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    destiny VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL
);

ALTER TABLE clients MODIFY cpf bigint;