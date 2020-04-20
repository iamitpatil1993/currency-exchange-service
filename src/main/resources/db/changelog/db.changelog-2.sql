--liquibase formatted sql
--changeset amipatil:202004201050
INSERT INTO currency_mapping values(1, 'USD', 'INR', 75, false, now(), now());