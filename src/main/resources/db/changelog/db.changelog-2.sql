--liquibase formatted sql
--changeset amipatil:202004201050
INSERT INTO currency_mapping values(1, 'USD', 'INR', 75, false, now(), now());
INSERT INTO currency_mapping values(2, 'EUR', 'INR', 65, false, now(), now());
INSERT INTO currency_mapping values(3, 'AUS', 'INR', 50, false, now(), now());