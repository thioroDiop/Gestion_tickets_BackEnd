create table classroom
(
    id serial not null
        constraint classroom_pk
            primary key,
    name varchar
);

alter table classroom owner to postgres;

create table learner
(
    id serial not null
        constraint learner_pk
            primary key,
    first_name varchar,
    last_name varchar,
    classroom_idx integer
        constraint classroom_fk
            references classroom
            on delete cascade
);

alter table learner owner to postgres;

create table ticket
(
    id serial not null
        constraint ticket_pk
            primary key,
    date timestamp,
    description varchar,
    learner_idx integer
        constraint learner_fk
            references learner
            on delete cascade,
    is_solved boolean
);

alter table ticket owner to postgres;

