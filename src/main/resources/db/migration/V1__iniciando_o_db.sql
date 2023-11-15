USE myflight;

CREATE TABLE clients (
	id BIGINT PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    cpf BIGINT NOT NULL UNIQUE,
    birth_date DATE NOT NULL,
    role TINYINT NOT NULL
);

CREATE TABLE flights (
	id BIGINT PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    destiny VARCHAR(100) NOT NULL,
    description VARCHAR(250) NOT NULL
);

CREATE TABLE flights_passengers (
    flight_id BIGINT UNIQUE NOT NULL,
    passengers_id BIGINT UNIQUE NOT NULL,
    PRIMARY KEY(flight_id, passengers_id)
);