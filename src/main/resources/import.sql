INSERT INTO tb_account(name, cpf) VALUES ('Alessia Casado', '222.333.444-55');
INSERT INTO tb_account(name, cpf) VALUES ('Maria Joaquina', '111.333.777-55');
INSERT INTO tb_account(name, cpf) VALUES ('Joao Silva', '222.111.000-88');
INSERT INTO tb_account(name, cpf) VALUES ('Lucas Santos', '790.555.777-99');

INSERT INTO tb_transfer(account_id_from, account_id_to, amount, transfer_date) VALUES (2, 4, 300.00, TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z');