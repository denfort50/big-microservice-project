create schema if not exists catalogue;

create table if not exists catalogue.products
(
    id serial primary key,
    title varchar(50) not null,
    details varchar(1000)
)