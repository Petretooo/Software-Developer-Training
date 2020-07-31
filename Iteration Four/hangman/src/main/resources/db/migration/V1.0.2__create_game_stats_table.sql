CREATE TABLE IF NOT EXISTS game_stats(
game_stats_id varchar(36) primary key not null,
is_word_found BOOLEAN,
wrong_tries int,
game_start date,
game_end date,
game_id varchar(36) UNIQUE,
CONSTRAINT `fk_game__stats_game` FOREIGN KEY(game_id) REFERENCES games(game_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);