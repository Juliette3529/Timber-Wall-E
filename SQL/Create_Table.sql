Create table Users
(
	Identifiant BIGINT IDENTITY,
	Nom VARCHAR(25),
	Prenom VARCHAR(25),
	Login VARCHAR(255),
	Password VARCHAR(255),
	Role VARCHAR(50),
	PRIMARY KEY(Identifiant)
)

Create Table Cartographie
(
	Identifiant BIGINT IDENTITY,
	Xmax BIGINT,
	Ymax BIGINT,
	PRIMARY KEY(Identifiant)
)

/*
Create Table Obstacle
(
	Identifiant BIGINT IDENTITY,
	Xpoint BIGINT,
	Ypoint BIGINT,
	Cartographie BIGINT,
	Type_Obstacle BIGINT,
	PRIMARY KEY(Identifiant),
	ADD Constraint Fk_Cartographie Foreign key (Cartographie) References Cartographie(Identifiant),
	ADD Constraint Fk_Type_Obstacle Foreign key (Type_Obstacle) References Type_Obstacle(Identifiant)
)*/

Create Table Type_Obstacle
(
	Identifiant BIGINT IDENTITY,
	Libelle VARCHAR(255),
	PRIMARY KEY(Identifiant)
)

Create Table Parcours
(
	Identifiant BIGINT IDENTITY,
	Date_parcours DateTime,
	Consommation BIGINT,
	Cartographie BIGINT,
	PRIMARY KEY (Identifiant),
	ADD Constraint Fk_Cartographie Foreign key (Cartographie) References Cartographie(Identifiant)
)

Create Table Points_Arrets
(
	Identifiant BIGINT IDENTITY,
	Xpoint BIGINT,
	Ypoint BIGINT,
	Parcours BIGINT,
	Type_Obstacle BIGINT,
	PRIMARY KEY (Identifiant),
	ADD Constraint FK_Parcours Foreign key (Parcours) References Parcours(Identifiant),
	ADD Constraint Fk_Type_Obstacle Foreign key (Type_Obstacle) References Type_Obstacle(Identifiant)
)