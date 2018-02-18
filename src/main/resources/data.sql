INSERT INTO contact(contact_id, name)
    VALUES (1, 'Иванов Иван Иванович');


INSERT INTO application(
            application_id, contact_id, dt_created, product_name)
    VALUES (1, 1, now(), 'Продукт 1');
INSERT INTO application(
            application_id, contact_id, dt_created, product_name)
    VALUES (2, 1, now(), 'Продукт 2');
