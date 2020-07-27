DROP TABLE IF EXISTS visitation_procedure;
DROP TABLE IF EXISTS pet_procedure;
DROP TABLE IF EXISTS visitation;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS owner;


CREATE TABLE owner
(owner_id serial,
first_name varchar(64) not null,
last_name varchar(64) not null,

CONSTRAINT pk_owner primary key (owner_id)
);

CREATE TABLE pet
(pet_id serial,
pet_name varchar(64) not null,
pet_type varchar(64) not null,
pet_age int not null,
owner_id int not null,

CONSTRAINT pk_pet primary key (pet_id),
CONSTRAINT fk_pet_owner foreign key (owner_id) references owner(owner_id)

);



CREATE TABLE visitation
(visitation_id serial,
pet_id int not null,
owner_id int not null,
visit_date timestamp not null,

CONSTRAINT pk_visitation primary key (visitation_id),
CONSTRAINT fk_visitation_owner foreign key (owner_id) references owner(owner_id),
CONSTRAINT fk_visitation_pet foreign key (pet_id) references pet(pet_id)
);



CREATE TABLE pet_procedure
(pet_procedure_id serial,
name varchar(64) not null,

CONSTRAINT pk_pet_procedure primary key (pet_procedure_id)
);

CREATE TABLE visitation_procedure
(pet_procedure_id int not null,
visitation_id int not null,

CONSTRAINT pk_visitation_procedure primary key (pet_procedure_id, visitation_id),
CONSTRAINT fk_visitation_procedure_pet_procedure foreign key (pet_procedure_id) references pet_procedure(pet_procedure_id),
CONSTRAINT fk_visitation_procedure_visitation foreign key (visitation_id) references visitation(visitation_id)

);

INSERT INTO owner (first_name, last_name) VALUES ('Sam', 'Cook');
INSERT INTO pet (pet_name, pet_type, pet_age, owner_id) VALUES ('Rover', 'Dog', 12, 1);


SELECT * FROM owner;
