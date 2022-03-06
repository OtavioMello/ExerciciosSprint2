create database db_exercicio02;
use db_exercicio02;

create table movie(
movie_id int auto_increment primary key,
movie_name varchar(50) not null,
movie_description varchar(200) not null,
movie_year year(4) not null
);
