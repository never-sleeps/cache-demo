create table users
(
    id       bigserial primary key,
    name     varchar(255),
    birthday timestamp,
    email    varchar(255)
);