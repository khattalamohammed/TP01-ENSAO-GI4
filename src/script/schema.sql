DROP TABLE IF EXISTS livre;

CREATE TABLE livre
(
    id   INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(250) NOT NULL,

    code VARCHAR(250) NOT NULL,

);

DROP TABLE IF EXISTS chaise;

CREATE TABLE chaise
(
    id   INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(250) NOT NULL,

    code VARCHAR(250) NOT NULL,

);


