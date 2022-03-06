create database db_exercicio01;
use db_exercicio01;

create table product 
(product_id int auto_increment primary key, 
product_name varchar(50) not null, 
product_description varchar(150) not null, 
product_amount int not null,
product_price decimal(9, 2) unsigned not null);


