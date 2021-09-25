CREATE TABLE clients
(client_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(30), last_name VARCHAR(30),
email_address VARCHAR(30), mobile_number VARCHAR(10));


CREATE TABLE cars
(car_id INT AUTO_INCREMENT PRIMARY KEY,  model VARCHAR(30),  make VARCHAR(30),
rental_price INT,  year INT);
	
CREATE TABLE reservations
(reservation_id INT AUTO_INCREMENT PRIMARY KEY, client_id INT,  
car_id INT , res_date DATE);


CREATE TABLE user (
  user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(128) NOT NULL UNIQUE,
  password VARCHAR(256) NOT NULL
);

CREATE TABLE auth_user_group (
  auth_user_group_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(128) NOT NULL,
  auth_group VARCHAR(128) NOT NULL,
  CONSTRAINT user_auth_user_group_fk FOREIGN KEY(username) REFERENCES USER(username),
  UNIQUE (username, auth_group)
);

