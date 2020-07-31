CREATE TABLE IF NOT EXISTS user_stats(
user_stats_id varchar(36) not null,
score int,
word varchar(30),
id_user_stats varchar(36),
FOREIGN KEY(id_user_stats) REFERENCES users(user_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

