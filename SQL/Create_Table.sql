Create table Users
(
	Id BIGINT IDENTITY,
	Last_Name VARCHAR(25),
	First_Name VARCHAR(25),
	Login VARCHAR(255),
	Password VARCHAR(255),
	PRIMARY KEY(Id)
)

Create Table Maps
(
	Id BIGINT IDENTITY,
	Xmax Float(8),
	Ymax Float(8),
	Name VARCHAR(255),
	PRIMARY KEY(Id)
)


Create Table Obstacles
(
	Id BIGINT IDENTITY,
	Xpoint Float(8),
	Ypoint Float(8),
	Maps BIGINT,
	Type_Of_Obstacles BIGINT,
	PRIMARY KEY(Id),
	ADD Constraint Fk_Maps Foreign key (Maps) References Maps(Id),
	ADD Constraint Fk_Type_Of_Obstacles Foreign key (Type_Of_Obstacles) References Type_Of_Obstacles(Id)
)

Create Table Type_Of_Obstacles
(
	Id BIGINT IDENTITY,
	Label VARCHAR(255),
	PRIMARY KEY(Id)
)

Create Table Circuit
(
	Id BIGINT IDENTITY,
	Date_Circuit DateTime,
	Consumption BIGINT,
	Maps BIGINT,
	PRIMARY KEY (Id),
	ADD Constraint Fk_Maps Foreign key (Maps) References Maps(Id)
)

Create Table Breakpoint
(
	Id BIGINT IDENTITY,
	Obstacles BIGINT,
	Circuit BIGINT,
	PRIMARY KEY (Id),
	ADD Constraint FK_Circuit Foreign key (Circuit) References Circuit(Id),
	ADD Constraint FK_Obstacles Foreign key (Obstacles) References Obstacles(Id)
)