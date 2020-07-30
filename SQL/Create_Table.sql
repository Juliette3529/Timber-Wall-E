Create table Users
(
	Identifiant BIGINT IDENTITY,
	Last_Name VARCHAR(25),
	First_Name VARCHAR(25),
	Login VARCHAR(255),
	Password VARCHAR(255),
	Role VARCHAR(50),
	PRIMARY KEY(Identifiant)
)

Create Table Maps
(
	Identifiant BIGINT IDENTITY,
	Xmax BIGINT,
	Ymax BIGINT,
	Name VARCHAR(255),
	PRIMARY KEY(Identifiant)
)


Create Table Obstacles
(
	Identifiant BIGINT IDENTITY,
	Xpoint BIGINT,
	Ypoint BIGINT,
	Maps BIGINT,
	Type_Of_Obstacles BIGINT,
	PRIMARY KEY(Identifiant),
	ADD Constraint Fk_Maps Foreign key (Maps) References Maps(Identifiant),
	ADD Constraint Fk_Type_Of_Obstacles Foreign key (Type_Of_Obstacles) References Type_Of_Obstacles(Identifiant)
)

Create Table Type_Of_Obstacles
(
	Identifiant BIGINT IDENTITY,
	Wording VARCHAR(255),
	PRIMARY KEY(Identifiant)
)

Create Table Circuit
(
	Identifiant BIGINT IDENTITY,
	Date_Circuit DateTime,
	Consumption BIGINT,
	Maps BIGINT,
	PRIMARY KEY (Identifiant),
	ADD Constraint Fk_Maps Foreign key (Maps) References Maps(Identifiant)
)

Create Table Breakpoint
(
	Identifiant BIGINT IDENTITY,
	Obstacles BIGINT,
	Circuit BIGINT,
	PRIMARY KEY (Identifiant),
	ADD Constraint FK_Circuit Foreign key (Circuit) References Circuit(Identifiant),
	ADD Constraint FK_Obstacles Foreign key (Obstacles) References Obstacles(Identifiant)
)