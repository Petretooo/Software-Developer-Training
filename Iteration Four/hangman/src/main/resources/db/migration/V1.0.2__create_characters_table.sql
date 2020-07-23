CREATE TABLE IF NOT EXISTS characters(
character_id varchar(36) primary key not null,
letter varchar(1),
id_game_character VARCHAR(36),
FOREIGN KEY(id_game_character) REFERENCES games(game_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);