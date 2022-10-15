create database if not exists from_zeroto_expert;
use from_zeroto_expert;
drop table if exists fzte_user;
create table fzte_user(
    id int(10) primary key auto_increment,
    username varchar(255) unique not null,
    password varchar(255) not null,
    email varchar(255)
)