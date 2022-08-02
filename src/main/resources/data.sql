
/*****   EMPLOYEE DATA   ********************************************************/
INSERT INTO EMPLOYEE(First_Name,Last_Name,Phone, Email) VALUES 
	('Mary', 'Jacobs',  '360-285-8110', 'Mary.Jacobs@WPC.com'),
	('Rosalie', 'Jackson', '360-285-8120', 'Rosalie.Jackson@WPC.com'),
	('Richard', 'Bandalone',  '360-285-8210', 'Richard.Bandalone@WPC.com'),
	('Tom', 'Caruthers',  '360-285-8310', 'Tom.Caruthers@WPC.com'),
	('Heather', 'Jones',  '360-285-8320', 'Heather.Jones@WPC.com'),
	('Mary', 'Abernathy', '360-285-8410', 'Mary.Abernathy@WPC.com'),
	('George', 'Smith',  '360-285-8510', 'George.Smith@WPC.com'),
	('Tom', 'Jackson',  '360-287-8610', 'Tom.Jackson@WPC.com'),
	('George', 'Jones', '360-287-8620', 'George.Jones@WPC.com'),
	('Ken', 'Numoto', '360-287-8710', 'Ken.Mumoto@WPC.com'),
	('James', 'Nestor', null, 'James.Nestor@WPC.com'),
	('Rick', 'Brown','360-287-8820', 'Rick.Brown@WPC.com');
	

/*****   PROJECT DATA   ***************************************************/
INSERT INTO PROJECT (Name,Max_Hours,Start_Date,End_Date) VALUES 
	('2013 Q3 Product Plan',  135.00, '2022-05-10', '2022-06-15'),
	('2013 Q3 Portfolio Analysis',  120.00, '2022-07-05', '2022-07-25'),
	('2013 Q3 Tax Preparation', 145.00, '2022-08-10', '2022-10-15'),
	('2013 Q4 Product Plan',  150.00, '2022-08-10', '2022-09-15'),
	('2013 Q4 Portfolio Analysis',  140.00, '2022-10-05',NULL);
/*****   ASSIGNMENT(project_id, employee_id, hours_worked)  DATA   ************************************************/

INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(1, 1, 30.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(1, 8, 75.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(1, 10, 55.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(2, 4, 40.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(2, 6, 45.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(3, 1, 25.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(3, 2, 20.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(3, 4, 45.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(3, 5, 40.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(4, 1, 35.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(4, 8, 80.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(4, 10, 50.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(5, 4, 15.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(5, 5, 10.0);
INSERT INTO ASSIGNMENT(project_id, employee_id, hours_worked) VALUES(5, 6, 27.5);

/****************************************************************************************/

INSERT INTO USER(username, password) VALUES ('admin', '1');

