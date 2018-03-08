CREATE TABLE EmployeeInfo (
	EmployeeId INT NOT NULL AUTO_INCREMENT,
	Department INT NOT NULL,
	JobId INT,
	InfoId INT UNIQUE,
	Status BOOLEAN NOT NULL,
	PRIMARY KEY (EmployeeId)
);

CREATE TABLE AdressTable (
	AdressId INT NOT NULL AUTO_INCREMENT,
	Adress VARCHAR(1000) NOT NULL,
	City INT NOT NULL,
	District INT NOT NULL,
	PRIMARY KEY (AdressId)
);

CREATE TABLE DeparmentTable (
	DeparmentId INT NOT NULL AUTO_INCREMENT,
	DepartmentName VARCHAR(255) NOT NULL,
	PRIMARY KEY (DeparmentId)
);

CREATE TABLE JobTable (
	JobId INT NOT NULL AUTO_INCREMENT,
	JobName VARCHAR(255) NOT NULL,
	JobCode VARCHAR(255) NOT NULL,
	PRIMARY KEY (JobId)
);

CREATE TABLE CityTable (
	CityId INT NOT NULL AUTO_INCREMENT,
	CİtyName VARCHAR(255) NOT NULL,
	PRIMARY KEY (CityId)
);

CREATE TABLE CommTable (
	CommId INT NOT NULL AUTO_INCREMENT,
	PhoneNumber VARCHAR(11) UNIQUE,
	Email VARCHAR(100) UNIQUE,
	PRIMARY KEY (CommId)
);

CREATE TABLE PersonJobRecord (
	RecordId INT NOT NULL AUTO_INCREMENT,
	PersonId INT NOT NULL,
	StartDate DATE NOT NULL,
	EndDate DATE,
	Date DATE NOT NULL,
	PRIMARY KEY (RecordId)
);

CREATE TABLE PermitTable (
	PermitId INT NOT NULL AUTO_INCREMENT,
	PersonId INT NOT NULL,
	PermitType INT NOT NULL,
	PermitComment VARCHAR(100),
	Date DATE NOT NULL,
	PRIMARY KEY (PermitId)
);

CREATE TABLE PermitTypes (
	PermitTypeId INT NOT NULL AUTO_INCREMENT,
	PermitName VARCHAR(255) NOT NULL,
	PRIMARY KEY (PermitTypeId)
);

CREATE TABLE UserTypes (
	UserTypeId INT NOT NULL AUTO_INCREMENT,
	TypeName VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY (UserTypeId)
);

CREATE TABLE Users (
	UserId INT NOT NULL AUTO_INCREMENT,
	Username VARCHAR(255) NOT NULL UNIQUE,
	Password VARCHAR(255) NOT NULL,
	UserType INT NOT NULL,
	PersonId INT NOT NULL,
	PRIMARY KEY (UserId)
);

CREATE TABLE Perms (
	PermId INT NOT NULL AUTO_INCREMENT,
	PermName VARCHAR(255) NOT NULL UNIQUE,
	PermLink VARCHAR(255) NOT NULL,
	PRIMARY KEY (PermId)
);

CREATE TABLE UserPerms (
	UserPermId INT NOT NULL AUTO_INCREMENT,
	PermissionId INT NOT NULL,
	UserTypeId INT NOT NULL,
	PermVisual BOOLEAN NOT NULL,
	PermSet BOOLEAN NOT NULL,
	PRIMARY KEY (UserPermId)
);

CREATE TABLE EducationInfo (
	EducationId INT NOT NULL AUTO_INCREMENT,
	PersonId INT NOT NULL,
	GraduationDate DATE NOT NULL,
	EducationType INT NOT NULL,
	InstitutionName VARCHAR(255) NOT NULL,
	GraduationType VARCHAR(255) NOT NULL,
	PRIMARY KEY (EducationId)
);

CREATE TABLE EducationTypes (
	EduTypeID INT NOT NULL AUTO_INCREMENT,
	EduTypeName VARCHAR(50) NOT NULL,
	PRIMARY KEY (EduTypeID)
);

CREATE TABLE DistrictTable (
	DistId INT NOT NULL AUTO_INCREMENT,
	City INT NOT NULL,
	DistrictName VARCHAR(255) NOT NULL,
	PRIMARY KEY (DistId)
);

CREATE TABLE PersonalInfo (
	PInfoId INT NOT NULL AUTO_INCREMENT,
	EName VARCHAR(255) NOT NULL,
	ESurname VARCHAR(255) NOT NULL,
	SocialSecurityNumber VARCHAR(255) NOT NULL UNIQUE,
	CitizensShipNumber VARCHAR(255) NOT NULL UNIQUE,
	Adress INT NOT NULL,
	BirthDate DATE NOT NULL,
	Communication INT NOT NULL,
	Gender BINARY NOT NULL,
	MaritalStatus BOOLEAN NOT NULL,
	PRIMARY KEY (PInfoId)
);

CREATE TABLE EmergencyTable (
	RecordId INT NOT NULL AUTO_INCREMENT,
	InfoId INT NOT NULL,
	NameSurname VARCHAR(50) NOT NULL,
	Phone VARCHAR(11) NOT NULL,
	PRIMARY KEY (RecordId)
);

ALTER TABLE EmployeeInfo ADD CONSTRAINT EmployeeInfo_fk0 FOREIGN KEY (InfoId) REFERENCES PersonalInfo(PInfoId);

ALTER TABLE UserPerms ADD CONSTRAINT UserPerms_fk0 FOREIGN KEY (PermissionId) REFERENCES Perms(PermId);

ALTER TABLE UserPerms ADD CONSTRAINT UserPerms_fk1 FOREIGN KEY (UserTypeId) REFERENCES UserTypes(UserTypeId);
