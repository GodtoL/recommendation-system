INSERT INTO users (name, email, registrationDate, age, address, phoneNumber) VALUES
('John Doe', 'johndoe@example.com', '2024-09-21 10:30:00', 28, '123 Main St, New York, NY', '555-1234'),
('Jane Smith', 'janesmith@example.com', '2024-09-20 09:45:00', 34, '456 Elm St, Los Angeles, CA', '555-5678'),
('Mike Johnson', 'mikejohnson@example.com', '2024-09-19 08:20:00', 40, '789 Pine St, Chicago, IL', '555-9101'),
('Emily Davis', 'emilydavis@example.com', '2024-09-18 07:15:00', 25, '321 Oak St, Miami, FL', '555-1112'),
('Chris Brown', 'chrisbrown@example.com', '2024-09-17 11:50:00', 22, '654 Maple St, Dallas, TX', '555-3141'),
('Sarah Wilson', 'sarahwilson@example.com', '2024-09-16 12:40:00', 30, '987 Cedar St, Seattle, WA', '555-5152'),
('David Clark', 'davidclark@example.com', '2024-09-15 01:10:00', 45, '432 Birch St, Denver, CO', '555-7173'),
('Laura Lewis', 'lauralewis@example.com', '2024-09-14 02:25:00', 27, '876 Redwood St, Austin, TX', '555-8184'),
('James Young', 'jamesyoung@example.com', '2024-09-13 03:30:00', 35, '543 Palm St, Boston, MA', '555-9195'),
('Sophia Hall', 'sophiahall@example.com', '2024-09-12 04:50:00', 29, '210 Spruce St, San Francisco, CA', '555-0202');

INSERT INTO purchases (userId, productId, quantity, totalPrice) VALUES
(1, 1, 2, 50),
(1, 2, 1, 25),
(2, 2, 3, 75),
(2, 3, 5, 125),
(3, 5, 2, 60),
(3, 7, 4, 120),
(1, 8, 1, 35),
(2, 9, 2, 70),
(3, 10, 3, 90),
(1, 1, 1, 40);
