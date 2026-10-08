CREATE DATABASE IF NOT EXISTS lennonleaf;
USE lennonleaf;

DROP TABLE IF EXISTS OrderItem;
DROP TABLE IF EXISTS `Order`;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Author;


CREATE TABLE Author (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    biography TEXT,
    country_of_origin VARCHAR(100)
);


CREATE TABLE Book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(300) NOT NULL,
    publication_date DATE,
    price DECIMAL(8,2) CHECK (price >= 0),
    author_id INT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES Author(author_id)
        ON DELETE RESTRICT
);


CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);


CREATE TABLE `Order` (
    order_number INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    subtotal DECIMAL(10,2) CHECK (subtotal >= 0),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);


CREATE TABLE OrderItem (
    line_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_number INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    price_each DECIMAL(8,2) NOT NULL,
    FOREIGN KEY (order_number) REFERENCES `Order`(order_number)
        ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES Book(book_id)
);

