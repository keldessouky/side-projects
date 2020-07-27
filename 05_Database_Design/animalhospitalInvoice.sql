DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS invoice;





CREATE TABLE address
(address_id serial,
street varchar(64) not null,
city varchar(64) not null,
district varchar(64) not null,
zipcode int not null,
owner_id int not null,
CONSTRAINT pk_address primary key (address_id),
CONSTRAINT fk_address_owner foreign key (owner_id) REFERENCES owner(owner_id)
 );


CREATE TABLE invoice
(invoice_id serial,
total_cost money not null,
CONSTRAINT pk_invoice primary key (invoice_id)
 );

ALTER TABLE visitation ADD invoice_id int not null;
ALTER TABLE visitation ADD foreign key (invoice_id) REFERENCES invoice(invoice_id);
ALTER TABLE visitation ADD cost money not null;