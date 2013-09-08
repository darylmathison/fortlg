insert into Contact (version, firstname, lastname, middle,jobtitle) 
values (1,'Harry','Mouse','','Clown'), (1,'Mary','June','July','administrator'),
(1,'Mandy','Armstrong','','between jobs');

insert into Address (version, street, city, state, contactid, addresstypeid)
values (1, '113 Willow way', 'Cibolo', 'Texas', 1, 2),
(1, '9090 NW 410', 'San Antonio', 'Texas', 1, 1),
(1, '2020 NW Military Dr', 'San Antonio', 'Texas', 2, 2),
(1, '8888 Willow Pointe', 'Schertz', 'Texas', 2, 1),
(1, '1111 Pointe Loop','New Braunsfels','Texas', 3, 2),
(1, '7878 NW IH 10', 'San Antonio', 'Texas', 3, 1);

insert into Phonenumber(version, contactId, phoneTypeId, number)
values (1, 1, 2, '451-123-1111'), (1,2,1,'210-333-3333'),(1,3,1,'456-909-4545');


