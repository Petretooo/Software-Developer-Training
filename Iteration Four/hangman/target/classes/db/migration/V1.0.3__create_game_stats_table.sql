CREATE TABLE IF NOT EXISTS game_stats(
game_stats_id varchar(36) primary key not null,
is_word_found BOOLEAN,
remain_tries int,
seconds double,
start_date date,
FOREIGN KEY(game_stats_id) REFERENCES games(game_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);