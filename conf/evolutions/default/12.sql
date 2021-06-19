# --- !Ups
INSERT INTO category ('name', description)
VALUES  ('Elektronika', 'Elektronika użytkowa'),
        ('Gaming', 'Gry, karty graficzne itp'),
        ('Ubrania', 'ubrania damskie i męskie'),
        ('Alkohol', 'whiskys, wódka, wino, piwo'),
        ('Inne', 'inne'),
        ('Dom', 'dodatki do domu');

INSERT INTO product ('name', description, categoryId, price, weight, height, width)
VALUES  ('Samsung S20', 'base model', 1, 2800, 120.0, 0.0, 0.0),
        ('Samsung S20+', 'bigger than s20', 1, 3700, 130.0, 0.0, 0.0),
        ('Samsung S20 ultra', 'base model', 1, 5000, 150.0, 0.0, 0.0),
        ('iPhon 12', '128GB', 1, 7000, 180.0, 0.0, 0.0),
        ('Macbook Pro', '14inch', 1, 7200, 1200.0, 0.0, 0.0),
        ('XBOX', '2B', 1, 3500, 10000.0, 0.0, 0.0);

INSERT INTO product ('name', description, categoryId, price, weight, height, width)
VALUES ('SIMS 4', 'PC', 2, 50, 0.0, 0.0, 0.0),
       ('Cyberpunk 2077', 'PC', 2, 2190, 0.0, 0.0, 0.0),
       ('Naruto to Boruto: Shinobi Striker', 'PS5', 2, 350, 0.0, 0.0, 0.0),
       ('BIOMUTANT', 'PC', 2, 190, 0.0, 0.0, 0.0),
       ('LEGO Baman 3', 'PC', 2, 12, 0.0, 0.0, 0.0),
       ('Battlefield 1', 'PC i XBOX X', 2, 180, 0.0, 0.0, 0.0);

INSERT INTO product ('name', description, categoryId, price, weight, height, width)
VALUES ('Johnnie Walker Black Label', '0.7', 4, 150, 0.0, 0.0, 0.0),
       ('GLENFIDDICH', '1L', 4, 288, 0.0, 0.0, 0.0),
       ('LAGAVULIN', '0.7', 4, 293, 0.0, 0.0, 0.0),
       ('GLENMORANGIE', '1L', 4, 667, 0.0, 0.0, 0.0);

INSERT INTO user2 (providerId, providerKey, email, 'role', firstName, lastName)
VALUES  ('credentials', 'admin@admin.com', 'admin@admin.com', 'ADMIN', 'Admin', 'Admin'),
        ('credentials', 'a@a.com', 'a@a.com', 'ADMIN', 'Admin2', 'Admin2'),
        ('credentials', 'adam@adam.com', 'adam@adam.com', 'USER', 'Adam', 'Czymsz');

INSERT INTO passwordInfo (providerId, providerKey, hasher, password, salt)
VALUES ('credentials', 'admin@admin.com', 'bcrypt-sha256', '$2a$10$CCM/jSUIAR4.I0hy/V51ZerhzZhgRQoUwAxLGuQCHGagryKTl76bq', null),
       ('credentials', 'a@a.com', 'bcrypt-sha256', '$2a$10$ZumxW1dcdarwfqpFihGe7OrZPGxRqTDjPAHxnME1Uz9GUOkkbtpvm', null),
       ('credentials', 'adam@adam.com', 'bcrypt-sha256', '$2a$10$tXKUwHCpYRqVfKqysEQeYe6wEbrkUDKNICxsVIVunyGbruJ0zhtbO', null);

INSERT INTO authToken (userId)
VALUES (1), (2), (3);
# --- !Downs