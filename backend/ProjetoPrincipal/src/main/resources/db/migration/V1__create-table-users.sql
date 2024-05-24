create table users (
id VARCHAR(36) primary key,
name varchar(255) not null,
email varchar(255) unique not null,
password varchar(255) not null
);
