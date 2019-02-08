create database if not exists adlister_db;
use adlister_db;

create table if not exists users
(
  id       int unsigned not null auto_increment,
  username varchar(25),
  password varchar(25),
  email    varchar(25),
  primary key (id)
);


create table ads
(
  id          int unsigned not null auto_increment,
  user_id     int unsigned not null,
  title       varchar(50),
  description varchar(300),
  primary key (id),
  foreign key (user_id) references users (id)
);

