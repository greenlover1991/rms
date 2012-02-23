INSERT INTO roles VALUES(null,'Administrator','administrator','Active');
INSERT INTO roles VALUES(null,'Chef','chef','Active');
INSERT INTO roles VALUES(null,'Cashier','cashier','Active');
INSERT INTO roles VALUES(null,'Waiter','waiter','Active');


INSERT INTO branches VALUES(null,'Guadalupe','M. Velez St., Brgy. Guadalupe, Cebu City','Active');
INSERT INTO branches VALUES(null,'IT Park','AsiaTown IT Park, Brgy. Lahug, Cebu City','Active');
INSERT INTO branches VALUES(null,'Crossroads','Crossroads, Brgy. Banilad, Cebu City','Active');
INSERT INTO branches VALUES(null,'One Mango','One Mango Plaza, Mango Avenue, Brgy. Ambot, Cebu City','Active');


INSERT INTO employees (id,first_name,last_name,middle_name,login,password,role_id,status) VALUES(null,'default','default','default','admin','default',1,'Active');
