# database
�������� � ���������� ���� ������:
  create table pizza  (
        pizza_id INT NOT NULL AUTO_INCREMENT  primary key,
        name VARCHAR(30),
        weight VARCHAR(30),
	price VARCHAR(30),
	URL VARCHAR(70),
	consist VARCHAR(150),
	categories VARCHAR(30)
   );
  create table paste (
        paste_id INT NOT NULL AUTO_INCREMENT  primary key,
        name VARCHAR(30),
        weight VARCHAR(30),
	price VARCHAR(30),
	URL VARCHAR(70),
	consist VARCHAR(150),
	categories VARCHAR(30)
   );
  create table risotto (
        risotto_id INT NOT NULL AUTO_INCREMENT  primary key,
        name VARCHAR(30),
        weight VARCHAR(30),
	price VARCHAR(30),
	URL VARCHAR(70),
	consist VARCHAR(150),
	categories VARCHAR(30)
   );

  create table dessert (
        dessert_id INT NOT NULL AUTO_INCREMENT  primary key,
        name VARCHAR(30),
        weight VARCHAR(30),
	price VARCHAR(30),
	URL VARCHAR(70),
	consist VARCHAR(150),
	categories VARCHAR(30)
   );

create table client  (
        client_id INT NOT NULL AUTO_INCREMENT  primary key,
        name VARCHAR(30),
        login VARCHAR(30),
	password VARCHAR(30),
	phone VARCHAR(30),
	rights VARCHAR(10),
	email VARCHAR(30),
	verification VARCHAR(30)
   );


create table reviews (
        reviews_id INT NOT NULL AUTO_INCREMENT  primary key,
        date datetime,
        review VARCHAR(500),
	client_id INT NOT NULL,
	FOREIGN KEY (client_id) REFERENCES `client`(client_id)
   );


INSERT INTO pizza VALUES(NULL,'4 Cheese', '900', '115', './img/pizza/4 Cheese.png', '���� "��������", ��� "�����", ��� "�����������", ��� "���������", ����������� ��� "����", ��� "��������", ��������','all');

INSERT INTO pizza VALUES(NULL,'Casablanca', '900', '145', './img/pizza/Casablanca.png', '���� "��������", ��������, ����������, �������� ���������� �� ��������, �����, �������, ���� ������� ��������, ��� "���������", ������','all');


INSERT INTO paste VALUES(NULL,'Spaghetti Carbonara', '350', '75', './img/paste/Spaghetti Carbonara.jpg', '�������� �����, ��������, ��������, ������ ������, ���� �Carbonara�.','all');

INSERT INTO paste VALUES(NULL,'Spaghetti Bolognese', '35', '85', './img/paste/Spaghetti Bolognese.jpg', '������� � ������� �� ��������� ������','all');


INSERT INTO risotto VALUES(NULL,'Risotto with seafood', '250', '95', './img/risotto/Risotto with seafood.jpg', '�������� �����, ��������, ��������, ������ ������, ���� �Carbonara�.','all');

INSERT INTO risotto VALUES(NULL,'Risotto with chicken', '250', '85', './img/risotto/Risotto with chicken.jpg', '������� � ������� �� ��������� ������','all');


INSERT INTO dessert VALUES(NULL,'Cake �Napoleon�', '155', '55', './img/dessert/Napoleon cake.jpg', '����� �������)','all');

INSERT INTO dessert VALUES(NULL,'Cake �Cheesecake�', '110', '65', './img/dessert/Cake Cheesecake.jpg', '����� �������)','all');


INSERT INTO client VALUES(NULL, 'valleria', 'user', '123', '380637737347', NULL, 'valleria@gmail.com', 'verification');

INSERT INTO client VALUES(NULL, 'admin', 'admin', 'root', '380637737347', 'admin', '18rammzes@gmail.com', 'verification');


INSERT INTO reviews VALUES(NULL, now(), '��� ������ ������� �� ������ �������������� �� �������� ���, ������������� ��������', 1);

