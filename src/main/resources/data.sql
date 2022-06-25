INSERT INTO users (id,username,password,enabled) values (1,'user','1234',true);
INSERT INTO users (id,username,password,enabled) values (2,'admin','1234',true);

INSERT INTO authorities (id,username,authority) values (1,'user','ROLE_USER');
INSERT INTO authorities (id,username,authority) values (2,'admin','ROLE_ADMIN');