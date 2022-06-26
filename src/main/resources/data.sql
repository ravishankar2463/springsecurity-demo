INSERT INTO PERMISSIONS (permission) values ('student:read');
INSERT INTO PERMISSIONS (permission) values ('student:write');
INSERT INTO PERMISSIONS (permission) values ('course:read');
INSERT INTO PERMISSIONS (permission) values ('course:write');

INSERT INTO ROLES (role) values ('STUDENT');
INSERT INTO ROLES (role) values ('ADMIN');

INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ADMIN','student:read');
INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ADMIN','student:write');
INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ADMIN','course:read');
INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ADMIN','course:write');

INSERT INTO USERS (username,enabled,password,role) values ('user',true,'1234','STUDENT');
INSERT INTO USERS (username,enabled,password,role) values ('admin',true,'1234','ADMIN');