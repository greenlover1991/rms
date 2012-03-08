-- phpMyAdmin SQL Dump
-- version 3.3.2deb1ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 23, 2012 at 10:53 AM
-- Server version: 5.1.41
-- PHP Version: 5.3.2-1ubuntu4.14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT=0;
START TRANSACTION;

CREATE SCHEMA IF NOT EXISTS `rms` DEFAULT CHARACTER SET utf8;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rms`
--

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE IF NOT EXISTS `branches` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `branches`
--


-- --------------------------------------------------------

--
-- Table structure for table `cash_payments`
--

CREATE TABLE IF NOT EXISTS `cash_payments` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_slip_id` int(10) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `employee_id` int(10) NOT NULL,
  `or_number` varchar(80) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `cash_payments`
--


-- --------------------------------------------------------

--
-- Table structure for table `credit_card_payments`
--

CREATE TABLE IF NOT EXISTS `credit_card_payments` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_slip_id` int(10) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `employee_id` int(10) NOT NULL,
  `or_number` varchar(80) DEFAULT NULL,
  `credit_card_holder` varchar(80) DEFAULT NULL,
  `credit_card_bank_name` varchar(80) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `credit_card_payments`
--


-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `middle_name` varchar(40) NOT NULL,
  `nickname` varchar(40) DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `landline_number` varchar(40) DEFAULT NULL,
  `mobile_number` varchar(40) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `login` varchar(80) NOT NULL,
  `password` varchar(80) NOT NULL,
  `role_id` int(10) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `employees`
--


-- --------------------------------------------------------

--
-- Table structure for table `ingredients`
--

CREATE TABLE IF NOT EXISTS `ingredients` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `description` varchar(80) DEFAULT NULL,
  `unit_of_measure` varchar(40) NOT NULL,
  `minimum_quantity` decimal(10,2) NOT NULL,
  `quantity` decimal(10,2) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `ingredients`
--


-- --------------------------------------------------------

--
-- Table structure for table `inventory_logs`
--

CREATE TABLE IF NOT EXISTS `inventory_logs` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ingredient_id` varchar(80) NOT NULL,
  `date_of_inventory` datetime NOT NULL,
  `beginning_inventory` decimal(10,2) DEFAULT NULL,
  `in_inventory` decimal(10,2) DEFAULT NULL,
  `out_inventory` decimal(10,2) DEFAULT NULL,
  `end_inventory` decimal(10,2) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `inventory_logs`
--


-- --------------------------------------------------------

--
-- Table structure for table `menu_categories`
--

CREATE TABLE IF NOT EXISTS `menu_categories` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `description` varchar(80) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `menu_categories`
--


-- --------------------------------------------------------

--
-- Table structure for table `menu_items`
--

CREATE TABLE IF NOT EXISTS `menu_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `description` varchar(80) DEFAULT NULL,
  `recipe_procedure` text,
  `seconds_to_cook` int(10) DEFAULT NULL,
  `menu_category_id` int(10) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `menu_items`
--


-- --------------------------------------------------------

--
-- Table structure for table `menu_price_list_logs`
--

CREATE TABLE IF NOT EXISTS `menu_price_list_logs` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_item_id` int(10) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `date_start` datetime NOT NULL,
  `date_end` datetime DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `menu_price_list_logs`
--


-- --------------------------------------------------------

--
-- Table structure for table `order_slips`
--

CREATE TABLE IF NOT EXISTS `order_slips` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `datetime_of_order` datetime NOT NULL,
  `datetime_of_tender` datetime NOT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `total_discount_amount` decimal(10,2) DEFAULT NULL,
  `grand_total` decimal(10,2) NOT NULL,
  `waited_by` int(10) DEFAULT NULL,
  `tendered_by` int(10) DEFAULT NULL,
  `number_of_customers` int(10) DEFAULT NULL,
  `order_status` varchar(40) NOT NULL,
  `is_takeout` bit(1) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `order_slips`
--


-- --------------------------------------------------------

--
-- Table structure for table `order_slip_items`
--

CREATE TABLE IF NOT EXISTS `order_slip_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_slip_id` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  `menu_item_id` int(10) NOT NULL,
  `unit_cost` decimal(10,2) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `order_status` varchar(40) NOT NULL,
  `discounted_items` int(10) DEFAULT NULL,
  `discount_fixed_amount` decimal(10,2) DEFAULT NULL,
  `discount_rate` decimal(10,2) DEFAULT NULL,
  `discount_description` varchar(40) DEFAULT NULL,
  `net_amount` decimal(10,2) NOT NULL,
  `datetime_of_order` datetime NOT NULL,
  `datetime_of_cook` datetime DEFAULT NULL,
  `datetime_of_serve` datetime DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `order_slip_items`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchase_orders`
--

CREATE TABLE IF NOT EXISTS `purchase_orders` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `datetime_of_purchase` datetime NOT NULL,
  `supplier_id` int(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `purchase_orders`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchase_order_items`
--

CREATE TABLE IF NOT EXISTS `purchase_order_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `purchase_order_id` int(10) NOT NULL,
  `quantity` decimal(10,2) NOT NULL,
  `ingredient_id` int(10) NOT NULL,
  `unit_cost` decimal(10,2) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `purchase_order_items`
--


-- --------------------------------------------------------

--
-- Table structure for table `recipes`
--

CREATE TABLE IF NOT EXISTS `recipes` (
  `ingredient_id` int(10) NOT NULL,
  `menu_item_id` int(10) NOT NULL,
  `quantity` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ingredient_id`,`menu_item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recipes`
--


-- --------------------------------------------------------

--
-- Table structure for table `requisition_slips`
--

CREATE TABLE IF NOT EXISTS `requisition_slips` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `datetime_of_requisition` datetime NOT NULL,
  `supplier_id` int(10) NOT NULL,
  `purchase_order_id` int(10) NOT NULL,
  `requisitioned_by` int(10) DEFAULT NULL,
  `approved_by` int(10) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `requisition_slips`
--


-- --------------------------------------------------------

--
-- Table structure for table `requisition_slip_items`
--

CREATE TABLE IF NOT EXISTS `requisition_slip_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `requisition_slip_id` int(10) NOT NULL,
  `quantity` decimal(10,2) NOT NULL,
  `ingredient_id` int(10) NOT NULL,
  `unit_cost` decimal(10,2) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `requisition_slip_items`
--


-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE IF NOT EXISTS `reservations` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `datetime_of_reservation` datetime NOT NULL,
  `order_slip_id` int(10) DEFAULT NULL,
  `employee_id` int(10) NOT NULL,
  `customer_name` varchar(80) NOT NULL,
  `customer_contact_number` varchar(40) DEFAULT NULL,
  `is_waiting` bit(1) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `reservations`
--


-- --------------------------------------------------------

--
-- Table structure for table `restaurant_tables`
--

CREATE TABLE IF NOT EXISTS `restaurant_tables` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `table_number` int(10) NOT NULL,
  `description` varchar(80) DEFAULT NULL,
  `capacity` int(10) NOT NULL,
  `table_status` varchar(80) NOT NULL,
  `status` varchar(40) NOT NULL,
  `order_slip_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `restaurant_tables`
--


-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `description` varchar(80) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `roles`
--


-- --------------------------------------------------------

--
-- Table structure for table `spoilage_reports`
--

CREATE TABLE IF NOT EXISTS `spoilage_reports` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `date_of_spoilage` datetime NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `spoilage_reports`
--


-- --------------------------------------------------------

--
-- Table structure for table `spoilage_report_items`
--

CREATE TABLE IF NOT EXISTS `spoilage_report_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `spoilage_report_id` int(10) NOT NULL,
  `quantity` decimal(10,2) NOT NULL,
  `ingredient_id` int(10) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `employee_id` int(10) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `spoilage_report_items`
--


-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE IF NOT EXISTS `suppliers` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `landline_number` varchar(40) DEFAULT NULL,
  `mobile_number` varchar(40) DEFAULT NULL,
  `contact_person` varchar(80) DEFAULT NULL,
  `email_address` varchar(40) DEFAULT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `suppliers`
--


-- --------------------------------------------------------

--
-- Table structure for table `supplier_price_lists`
--

CREATE TABLE IF NOT EXISTS `supplier_price_lists` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ingredient_id` int(10) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `supplier_id` int(10) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `supplier_price_lists`
--


-- --------------------------------------------------------

--
-- Table structure for table `supplier_price_list_logs`
--

CREATE TABLE IF NOT EXISTS `supplier_price_list_logs` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ingredient_id` int(10) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `date_start` datetime NOT NULL,
  `date_end` datetime DEFAULT NULL,
  `supplier_id` int(10) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `supplier_price_list_logs`
--

COMMIT;
