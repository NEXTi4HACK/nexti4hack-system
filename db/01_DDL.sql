DROP TABLE IF EXISTS users;

-- users
create table users
(
  user_id varchar(255) BINARY primary key,
  login_id varbinary(255),
  password varchar(255) BINARY,
  create_date datetime,
  update_date datetime,
  create_user varchar(100) BINARY,
  update_user varchar(100) BINARY
);