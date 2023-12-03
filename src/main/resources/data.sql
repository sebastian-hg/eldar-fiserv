INSERT INTO credit_card_brand
(id, name,date_modified,tax)
VALUES
(1,'visa', '2023-11-02', 0),
(2,'naranja','2023-11-02', 0.5),
(3,'amex', '2023-11-02', 0.1);

INSERT INTO credit_card
(id, credit_card_brand_id, card_holder, card_number, date_expiration)
VALUES
(1, 1, 'Sebastian Hernandez', '4540730045321266', '2032-12-12'),
(2, 2, 'Pedro Fuentes', '5895620045321266', '2024-12-12'),
(3, 3, 'Sebastian Hernandez', '376631730045321266', '2032-12-12');



