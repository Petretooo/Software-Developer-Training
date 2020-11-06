CREATE table if not exists game(
game_id varchar(36) PRIMARY KEY not null,
number_tries int not null,
current_word varchar(30) not null,
hidden_word varchar(30) not null,
user_id VARCHAR(36),
CONSTRAINT `fK_game_user` FOREIGN KEY (user_id) REFERENCES `user`(user_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);