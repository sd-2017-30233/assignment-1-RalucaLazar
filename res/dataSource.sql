create database if not exists bank;
use bank;

create table client(
id int unique auto_increment primary key,
name char(20),
idCardNumber varchar(6),
PNC char(13),
address char(30));

create table account(
id int unique auto_increment primary key,
type char(20),
amount float,
date date,
client_id int,
foreign key(client_id) references client(id));

create table employee(
id int unique auto_increment primary key,
name char(20),
username char(20),
password char (20));


create table admin(
id int unique auto_increment primary key,
username char(20),
password char (20));


create table report(
id int unique auto_increment primary key,
date date,
description char(100),
employee_id int,
foreign key(employee_id) references employee(id));


insert into client(name,idCardNumber,PNC,address) values
('Popescu Ion','245985','1810326371028','Str. 1 Decembrie, nr. 20'),
('Pop Maria','355988','2910326371458','Str. Fantanele, nr. 57'),
('Ionescu Zamfira','135985','2770613371067','Str. Plopilor, nr. 60');

insert into account(type,amount,date,client_id) values
('curent',4200,'2013-02-28',1),
('economii',12000,'2010-03-24',2),
('curent',5000,'2016-10-11',2),
('depozit',400,'2017-02-15',3);

insert into employee(name,username,password) values
('Popescu Anamaria','Anamaria','anamaria'),
('Antonescu Matei','Matei','mateia'),
('Popovici Andreea','Andreea','popovicia');

insert into admin(username,password) values
('alexandruadmin','admin'),
('mariaadmin','admin');

insert into report(date, description, employee_id) values
  ('2016-12-20','Created new account',2),
  ('2017-01-19','Added new client',1),
  ('2017-01-28','Created new account',3),
  ('2017-03-22','Added new client',1);