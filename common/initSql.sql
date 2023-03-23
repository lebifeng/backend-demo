create database user;

create table user.user_base_info
(
    id      int auto_increment
        primary key,
    phone   varchar(11)  null,
    name    varchar(20)  not null,
    age     int          null,
    address varchar(200) null
);

