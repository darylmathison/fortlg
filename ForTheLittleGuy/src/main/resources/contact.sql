
create table Contact (
   id integer primary key generated by default as identity,
   version integer not null,
   firstname varchar(15),
   lastname varchar(15),
   middle char(15),
   jobTitle varchar(40)
);

create table AddressType (
    id integer primary key,
    version integer,
    name varchar(20) unique not null
);

insert into AddressType values (1,1,'Work'),(2,1,'Home'),(3,1,'Other');

create table Address (
    id integer primary key generated by default as identity,
    version integer,
    contactId integer ,
    addressTypeId integer ,
    street varchar(80),
    city varchar(20),
    state varchar(20),
    constraint contactAddress_fk foreign key(contactId) references Contact(id),
    constraint addressType_fk foreign key(addressTypeId) references AddressType(id)
); 


create table PhoneType (
    id integer primary key,
    version integer,
    name varchar(20)
);

insert into PhoneType values (1,1,'Home'),(2,1,'Work'),(3,1,'Home Fax'),(4,1,'Work Fax'),(5,1,'Mobile');

create table Phonenumber (
     id integer primary key generated by default as identity,
     version integer,
     contactId integer,
     phoneTypeId integer,
     number varchar(15) not null,
     constraint phoneType_fk foreign key(phoneTypeId) references PhoneType(id),
     constraint contactPhonenumber_fk foreign key(contactId) references Contact(id)
);
