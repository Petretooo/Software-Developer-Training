CREATE table if not exists games(
game_id varchar(36) PRIMARY KEY not null,
number_tries int not null,
current_word varchar(30) not null,
hidden_word varchar(30) not null,
id_user_game VARCHAR(36),
FOREIGN KEY (id_user_game) REFERENCES users(user_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);