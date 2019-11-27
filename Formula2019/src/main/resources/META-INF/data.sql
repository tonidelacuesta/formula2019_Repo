
insert into roles (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN'); 
insert into roles (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (2, 'dbuser1', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (1, 'dbadmin1', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (3, 'Antonio', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (4, 'Jorge', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (5, 'Diego', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (6, 'Madroño', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (7, 'Chus', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (8, 'Hermes', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (9, 'Igor', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (10, 'Fran', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (11, 'Chea', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (12, 'Jose Ramón', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (13, 'Valdes', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuarios (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED,PUNTOS) values (14, 'Santi', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi', 1,0);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (1, 1, 1); 
insert into usuariorol (ID, USER_ID, ROLE_ID) values (2, 1, 2); 
insert into usuariorol (ID, USER_ID, ROLE_ID) values (3, 2, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (4, 3, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (5, 4, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (6, 5, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (7, 6, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (8, 7, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (9, 8, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (10, 9, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (11, 10, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (12, 11, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (13, 12, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (14, 13, 2);
insert into usuariorol (ID, USER_ID, ROLE_ID) values (15, 14, 2);

insert into grandespremios(CIUDAD,FECHA_CARRERA)values('Lugones','2019-12-31');

insert into pilotos(NOMBRE, PUNTOS) values ('Hamilton', 0);
insert into pilotos(NOMBRE, PUNTOS) values ('Bottas', 0);
insert into pilotos(NOMBRE, PUNTOS) values ('Vettel', 0);
insert into pilotos(NOMBRE, PUNTOS) values ('Verstappen', 0);
insert into pilotos(NOMBRE, PUNTOS) values ('Raikkonen', 0);
insert into pilotos(NOMBRE, PUNTOS) values ('Sainz', 0);






