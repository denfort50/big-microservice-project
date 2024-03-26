create schema if not exists user_management;

create table if not exists user_management.users
(
    id serial primary key,
    username varchar not null unique,
    password varchar
);

create table if not exists user_management.authorities
(
    id serial primary key,
    authority varchar not null unique
);

create table user_management.user_authority
(
    id serial primary key,
    user_id int not null references user_management.users(id),
    authority_id int not null references user_management.user_authority(id),
    constraint uk_user_authority unique (user_id, authority_id)
);