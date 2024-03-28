create table client
(
    age  integer not null,
    id   uuid    not null
        primary key,
    name varchar(255)
);

alter table client
    owner to postgres;