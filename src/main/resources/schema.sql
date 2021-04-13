CREATE TABLE product (
    id bigint PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    max_users integer NOT NULL
)
;

CREATE TABLE _user (
    id bigint auto_increment PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) CONSTRAINT _user_email_key unique,
    password VARCHAR(255),
    cpf VARCHAR(20) CONSTRAINT _user_cpf_key unique,
    mobile VARCHAR(20) CONSTRAINT _user_mobile_key unique,
    creation_date timestamp,
    validation_date timestamp,
    last_login timestamp,
    product_id bigint CONSTRAINT user_fk_product REFERENCES product(id)
);

insert into product (id,name,max_users) values (382833,'Whatsapp Silver',10);
insert into product (id,name,max_users) values (382834,'Whatsapp Gold',100);
INSERT INTO _user (id,name,email,password,cpf,mobile,creation_date,validation_date,last_login,product_id) VALUES (1, 'Marcelo','mmunizs1975@gmail.com','{bcrypt}$2a$10$09VX30H6xCEpv4RrHDMa.uxcF0pJ0uARaqilwPmJPegwxngUMeNk2','45756392068','19999908070','2020-05-12 08:18:36.174','2020-06-12 08:20:26.493','2020-05-12 10:39:42.815',382833);
INSERT INTO _user (id,name,email,password,cpf,mobile,creation_date,validation_date,last_login,product_id) VALUES (2, 'Without password','mmunizs-forcepass@gmail.com','{bcrypt}$2a$10$09VX30H6xCEpv4RrHDMa.uxcF0pJ0uARaqilwPmJPegwxngUMeNk2','45756392067','18999908070','2020-05-12 08:18:36.174','2020-06-12 08:20:26.493','2020-05-12 10:39:42.815',382833);



