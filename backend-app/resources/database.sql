/* inside connection with root user
DROP USER 'ironhacker'@'localhost';
CREATE USER 'ironhacker'@'localhost' IDENTIFIED BY 'Ir0nh4ck3r!';
GRANT ALL PRIVILEGES ON pokemon.* TO 'ironhacker'@'localhost';
GRANT ALL PRIVILEGES ON pokemon_test.* TO 'ironhacker'@'localhost';
*/
DROP SCHEMA IF EXISTS pokemon;
CREATE SCHEMA pokemon;
USE pokemon;

DROP TABLE IF EXISTS trainer;

CREATE TABLE trainer(
	name VARCHAR(255) NOT NULL,
	age TINYINT UNSIGNED,
	hobby VARCHAR(255),
    photo VARCHAR(255),
    creation_date DATE,
    modification_date DATE,
    user_creation VARCHAR(255),
    user_modification VARCHAR(255),
	PRIMARY KEY(name)
);

INSERT INTO trainer(name, age, hobby, photo, creation_date , modification_date , user_creation, user_modification)
VALUES ("JhonDoe", 22, "Pokemon Hunter" , "https://pokemon.fandom.com/es/wiki/Haunter?file=Haunter.png" , '2021-11-16', '0001-01-01', "Initial query" , "");

DROP TABLE IF EXISTS pokemon;

CREATE TABLE pokemon(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	trainer_name VARCHAR(255),
	name VARCHAR(255),
    image_url VARCHAR(255),
    creation_date DATE,
    modification_date DATE,
    user_creation VARCHAR(255),
    user_modification VARCHAR(255),
	PRIMARY KEY(id),
    FOREIGN KEY(trainer_name) REFERENCES trainer(name)
);

DROP TABLE IF EXISTS pokemon_type;

CREATE TABLE pokemon_type(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	pokemon_id INT UNSIGNED,
	name VARCHAR(255),
    creation_date DATE,
    modification_date DATE,
    user_creation VARCHAR(255),
    user_modification VARCHAR(255),
	PRIMARY KEY(id),
    FOREIGN KEY(pokemon_id) REFERENCES pokemon(id)
);

DROP TABLE IF EXISTS pokemon_stats;

CREATE TABLE pokemon_stats(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	pokemon_id INT UNSIGNED,
	name VARCHAR(255),
    value SMALLINT,
    creation_date DATE,
    modification_date DATE,
    user_creation VARCHAR(255),
    user_modification VARCHAR(255),
	PRIMARY KEY(id),
    FOREIGN KEY(pokemon_id) REFERENCES pokemon(id)
);

