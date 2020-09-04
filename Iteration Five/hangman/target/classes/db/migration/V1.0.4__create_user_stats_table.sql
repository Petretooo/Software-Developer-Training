CREATE TABLE IF NOT EXISTS user_stats(
user_stats_id varchar(36) not null,
score int,
word varchar(30),
user_id varchar(36),
FOREIGN KEY(user_id) REFERENCES `user`(user_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

