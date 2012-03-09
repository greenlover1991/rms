INSERT IGNORE INTO `rms`.`cash_payments`
(`id`,
`order_slip_id`,
`amount`,
`employee_id`,
`or_number`,
`status`)
VALUES
(
1,
1,
100,
1,
0001,
''
);

INSERT IGNORE INTO `rms`.`credit_card_payments`
(`id`,
`order_slip_id`,
`amount`,
`employee_id`,
`or_number`,
`credit_card_holder`,
`credit_card_bank_name`,
`status`)
VALUES
(
1,
2,
50,
1,
0002,
'Luffy',
'River Bank',
''
);

INSERT IGNORE INTO `rms`.`ingredients`
(`id`,
`name`,
`description`,
`unit_of_measure`,
`minimum_quantity`,
`quantity`,
`status`)
VALUES
(
1,
'Sugar',
'Sweet',
'Kilograms',
'5',
'10',
''
);

INSERT IGNORE INTO `rms`.`inventory_logs`
(`id`,
`ingredient_id`,
`date_of_inventory`,
`beginning_inventory`,
`in_inventory`,
`out_inventory`,
`end_inventory`,
`status`)
VALUES
(
1,
1,
'2012-03-01',
15,
5,
10,
10,
''
);

DELETE FROM `rms`.`menu_items`
WHERE id > 0;

INSERT IGNORE INTO `rms`.`menu_items`
(`id`,
`name`,
`description`,
`recipe_procedure`,
`seconds_to_cook`,
`menu_category_id`,
`image_url`,
`price`,
`status`)
VALUES
(
1,
'Milk Shake',
'Shaken milk',
'Stir',
10,
1,
'',
35,
''
);

INSERT IGNORE INTO `rms`.`menu_items`
(`id`,
`name`,
`description`,
`recipe_procedure`,
`seconds_to_cook`,
`menu_category_id`,
`image_url`,
`price`,
`status`)
VALUES
(
2,
'Burger',
'Made in bikini bottom.',
'Fry',
100,
1,
'',
100,
''
);

DELETE FROM `rms`.`order_slip_items`
WHERE id > 0;


INSERT IGNORE INTO `rms`.`order_slip_items`
(`id`,
`order_slip_id`,
`quantity`,
`menu_item_id`,
`unit_cost`,
`amount`,
`description`,
`order_status`,
`discount_fixed_amount`,
`discount_rate`,
`discount_description`,
`net_amount`,
`datetime_of_order`,
`datetime_of_cook`,
`datetime_of_serve`,
`status`)
VALUES
(1,1,1,1,35,35,'No milk please.','Queued',35,0,'',35,'2012-03-09 10:24:00','2012-03-09 10:27:00','2012-03-09 10:30:00',''),
(3,2,2,1,35,35,'Do not shake please.','Queued',35,0,'',35,'2012-03-09 10:24:00','2012-03-09 10:27:00','2012-03-09 10:30:00','');

INSERT IGNORE INTO `rms`.`order_slip_items`
(`id`,
`order_slip_id`,
`quantity`,
`menu_item_id`,
`unit_cost`,
`amount`,
`description`,
`order_status`,
`discount_fixed_amount`,
`discount_rate`,
`discount_description`,
`net_amount`,
`datetime_of_order`,
`datetime_of_cook`,
`datetime_of_serve`,
`status`)
VALUES
(
2,
2,
1,
2,
100,
100,
'Extra sesame seeds please.',
'Processing',
100,
0,
'',
100,
'2012-03-01 10:25:00',
'2012-03-01 10:27:00',
'2012-03-01 10:30:00',
''
);

INSERT IGNORE INTO `rms`.`requisition_slips`
(`id`,
`datetime_of_requisition`,
`supplier_id`,
`purchase_order_id`,
`requisitioned_by`,
`approved_by`,
`description`,
`total_amount`,
`status`)
VALUES
(
1,
'2012-03-01 10:30:00',
1,
1,
1,
1,
'',
100,
''
);


INSERT IGNORE INTO `rms`.`spoilage_reports`
(`id`,
`date_of_spoilage`,
`status`)
VALUES
(
1,
'2012-03-01',
''
);

INSERT IGNORE INTO `rms`.`spoilage_report_items`
(`id`,
`spoilage_report_id`,
`quantity`,
`ingredient_id`,
`description`,
`employee_id`,
`status`)
VALUES
(
1,
1,
9,
1,
'',
1,
''
);

DELETE FROM `rms`.`restaurant_tables`
WHERE id > 0;


INSERT IGNORE INTO `rms`.`restaurant_tables`
(`id`,
`table_number`,
`description`,
`capacity`,
`table_status`,
`status`)
VALUES
(1,1,'',5,'Vacant','Active'),
(2,3,'',5,'Occupied','Active'),
(3,4,'',5,'Dirty','Active'),
(4,5,'',5,'Reserved','Active'),
(5,7,'',5,'Dirty','Active'),
(6,10,'',5,'Vacant','Active');

DELETE FROM `rms`.`employees`
WHERE id > 0;

INSERT IGNORE INTO `rms`.`employees`
(`id`,
`first_name`,
`last_name`,
`middle_name`,
`nickname`,
`birthdate`,
`landline_number`,
`mobile_number`,
`address`,
`login`,
`password`,
`role_id`,
`image_url`,
`status`)
VALUES
(
99,
'Luf',
'Fy',
'D',
'Pirate King',
'1991-01-01',
'',
'',
'East Blue',
'',
'',
1,
'',
''
);

DELETE FROM `rms`.`roles`
WHERE id > 0;

INSERT IGNORE INTO `rms`.`roles`
(`id`,
`name`,
`description`,
`status`)
VALUES
(
1,
'Developer',
'',
''
);






