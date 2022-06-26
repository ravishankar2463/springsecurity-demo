INSERT INTO PERMISSIONS (permission) values ('student:read');
INSERT INTO PERMISSIONS (permission) values ('student:write');
INSERT INTO PERMISSIONS (permission) values ('course:read');
INSERT INTO PERMISSIONS (permission) values ('course:write');

INSERT INTO ROLES (role) values ('ROLE_STUDENT');
INSERT INTO ROLES (role) values ('ROLE_ADMIN');

INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ROLE_ADMIN','student:read');
INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ROLE_ADMIN','student:write');
INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ROLE_ADMIN','course:read');
INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ROLE_ADMIN','course:write');
INSERT INTO ROLES_PERMISSIONS (role,permission) values ('ROLE_STUDENT','student:read');

INSERT INTO USERS (username,enabled,password,role) values ('user',true,'1234','ROLE_STUDENT');
INSERT INTO USERS (username,enabled,password,role) values ('admin',true,'1234','ROLE_ADMIN');