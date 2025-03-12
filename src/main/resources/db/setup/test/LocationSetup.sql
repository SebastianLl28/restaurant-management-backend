INSERT IGNORE INTO district (name)
VALUES ('San Juan de Lurigancho'),
       ('San Martin de Porres'),
       ('Los Olivos'),
       ('Comas'),
       ('Independencia');


INSERT IGNORE INTO location (name, longitude, latitude, district_id, address, status, phone, image_url)
VALUES ('Location 1', '', '', 1, 'Av Los Jardines 235', 1, '+51 984 321 654', 'https://www.machupicchuperutours.com/wp-content/uploads/Mayta-Restaurante-1.jpg'),
       ('Location 2', '', '', 2, 'Address 2', 1, '+51 984 321 654', 'https://www.machupicchuperutours.com/wp-content/uploads/Mayta-Restaurante-1.jpg'),
       ('Location 3', '', '', 3, 'Address 3', 1, '+51 984 321 654', 'https://www.machupicchuperutours.com/wp-content/uploads/Mayta-Restaurante-1.jpg'),
       ('Location 4', '', '', 4, 'Address 4', 1, '+51 984 321 654', 'https://www.machupicchuperutours.com/wp-content/uploads/Mayta-Restaurante-1.jpg'),
       ('Location 5', '', '', 5, 'Address 5', 1, '+51 984 321 654', 'https://www.machupicchuperutours.com/wp-content/uploads/Mayta-Restaurante-1.jpg');

INSERT IGNORE INTO product_location_stock (product_id, location_id, quantity) VALUES (1, 1, 10),
                                                                    (1, 2, 20),
                                                                    (2, 1,20),
                                                                    (2, 2,30),
                                                                    (3, 1, 30),
                                                                    (4, 1, 40),
                                                                    (5, 1, 50),
                                                                    (6, 2, 10),
                                                                    (7, 2, 20),
                                                                    (8, 2, 30);
