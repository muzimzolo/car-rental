CREATE TABLE clients
(client_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(30), last_name VARCHAR(30),
email_address VARCHAR(30), mobile_number VARCHAR(30));


CREATE TABLE cars
(car_id INT AUTO_INCREMENT PRIMARY KEY,  model VARCHAR(30),  make VARCHAR(30),
rental_price INT,  year INT);
	
CREATE TABLE reservations
(reservation_id INT AUTO_INCREMENT PRIMARY KEY, client_id INT,  
car_id INT , res_date DATE);