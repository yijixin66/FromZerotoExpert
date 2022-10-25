create database if not exists from_zeroto_expert;
use from_zeroto_expert;
drop table if exists fzte_user;
create table fzte_user(
    id int(10) primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255)
);
drop table if exists fzte_disallow_word;
create table fzte_disallow_word(
    id int(10) primary key auto_increment,
    value VARCHAR(255) not null,
    type int(10) default 0
);
insert into fzte_disallow_word(value)values
('尼玛'),('站长'),('国家领导人'),('操');
