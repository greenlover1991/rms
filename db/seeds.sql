INSERT INTO roles VALUES(null,'Administrator','administrator','Active');
INSERT INTO roles VALUES(null,'Chef','chef','Active');
INSERT INTO roles VALUES(null,'Cashier','cashier','Active');
INSERT INTO roles VALUES(null,'Waiter','waiter','Active');

INSERT INTO branches VALUES(null,'Guadalupe','M. Velez St., Brgy. Guadalupe, Cebu City','Active');
INSERT INTO branches VALUES(null,'IT Park','AsiaTown IT Park, Brgy. Lahug, Cebu City','Active');
INSERT INTO branches VALUES(null,'Crossroads','Crossroads, Brgy. Banilad, Cebu City','Active');
INSERT INTO branches VALUES(null,'One Mango','One Mango Plaza, Mango Avenue, Brgy. Ambot, Cebu City','Active');

INSERT INTO employees (id,first_name,last_name,middle_name,login,password,role_id,status) VALUES(null,'default','default','default','admin','default',1,'Active');
INSERT INTO employees (id,first_name,last_name,middle_name,login,password,role_id,status) VALUES(null,'default','default','default','chef','chef',2,'Active');
INSERT INTO employees (id,first_name,last_name,middle_name,login,password,role_id,status) VALUES(null,'default','default','default','cashier','cashier',3,'Active');
INSERT INTO employees (id,first_name,last_name,middle_name,login,password,role_id,status) VALUES(null,'default','default','default','waiter','waiter',4,'Active');

INSERT INTO restaurant_tables VALUES (null, 1, 'Table 1', 2, 'Available', 'Active', null);
INSERT INTO restaurant_tables VALUES (null, 2, 'Table 2', 2, 'Available', 'Active', null);
INSERT INTO restaurant_tables VALUES (null, 3, 'Table 3', 4, 'Available', 'Active', null);
INSERT INTO restaurant_tables VALUES (null, 4, 'Table 4', 6, 'Available', 'Active', null);
INSERT INTO restaurant_tables VALUES (null, 5, 'Table 5', 8, 'Available', 'Active', null);
INSERT INTO restaurant_tables VALUES (null, 6, 'Table 6', 2, 'Available', 'Active', null);
INSERT INTO restaurant_tables VALUES (null, 7, 'Table 7', 4, 'Available', 'Active', null);
INSERT INTO restaurant_tables VALUES (null, 8, 'Table 8', 6, 'Available', 'Active', null);
INSERT INTO restaurant_tables VALUES (null, 9, 'Table 9', 4, 'Available', 'Active', null);

INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Dough', NULL, 'pcs', '15', '100', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Patty', NULL, 'pcs', '15', '100', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Burger Bun', NULL, 'pcs', '15', '100', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Lemon Iced Tea', NULL, 'bottles', '10', '20', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Canned Juice', NULL, 'cans', '10', '20', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Bottled Water', NULL, 'bottles', '10', '20', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'San Mig Light', NULL, 'cans', '10', '20', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Pale Pilsen', NULL, 'bottles', '10', '20', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Coke Regular', NULL, 'cans', '10', '20', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Sprite', NULL, 'cans', '10', '20', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Royal', NULL, 'cans', '10', '20', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Barbecue Sauce', NULL, 'liters', '20', '45.5', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Sweet Chilli Sauce', NULL, 'liters', '20', '45.5', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Sinamak', NULL, 'liters', '20', '45.5', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Tartar Sauce', NULL, 'liters', '20', '45.5', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Marinara Sauce', NULL, 'liters', '10', '24.7', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Gravy', NULL, 'liters', '25', '39.7', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Pizza Sauce', NULL, 'liters', '25', '39.7', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Mustard', NULL, 'liters', '1', '2.7', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'White Sugar', NULL, 'kgs', '10', '25.46', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Brown Sugar', NULL, 'kgs', '9', '24.73', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Breadcrumbs', NULL, 'kgs', '15', '26.73', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Cornstarch', NULL, 'kgs', '18', '22.83', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Soy Sauce', NULL, 'liters', '19', '25.73', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Black Pepper', NULL, 'kgs', '21', '22.98', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'White Pepper', NULL, 'kgs', '31', '35.72', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Rock Salt', NULL, 'kgs', '22', '26.83', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Iodized Salt', NULL, 'kgs', '17', '27.70', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Vegetable Oil', NULL, 'liters', '19', '21.73', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Dried Mushroom', NULL, 'kgs', '25', '42.72', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Lettuce', NULL, 'kgs', '15', '27.83', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Cucumber', NULL, 'kgs', '15', '31.22', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Tomato', NULL, 'kgs', '10', '22.73', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Red Onions', NULL, 'kgs', '12', '24.63', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Cabbage', NULL, 'kgs', '15', '22.73', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Garlic', NULL, 'kgs', '20', '30.00', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Potato', 'baba baba banana, potato na', 'kgs', '15', '42.73', 'Active');
INSERT INTO `rms`.`ingredients` (`id`, `name`, `description`, `unit_of_measure`, `minimum_quantity`, `quantity`, `status`) VALUES (NULL, 'Hungarian Sausage', NULL, 'kgs', '15', '22.73', 'Active');

INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Pizzas', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Burgers', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Drinks', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Desserts', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Pasta', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Fish', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Chicken', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Pork', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Vegetarian', NULL, 'Active');
INSERT INTO `rms`.`menu_categories` (`id`, `name`, `description`, `status`) VALUES (NULL, 'Others', NULL, 'Active');

INSERT INTO `rms`.`suppliers` (`id`, `name`, `address`, `landline_number`, `mobile_number`, `contact_person`, `email_address`, `status`) VALUES (NULL, 'Carbon', NULL, NULL, NULL, NULL, NULL, 'Active');
INSERT INTO `rms`.`suppliers` (`id`, `name`, `address`, `landline_number`, `mobile_number`, `contact_person`, `email_address`, `status`) VALUES (NULL, 'Sunpride', NULL, NULL, NULL, NULL, NULL, 'Active');
INSERT INTO `rms`.`suppliers` (`id`, `name`, `address`, `landline_number`, `mobile_number`, `contact_person`, `email_address`, `status`) VALUES (NULL, 'Singapore', NULL, NULL, NULL, NULL, NULL, 'Active');



