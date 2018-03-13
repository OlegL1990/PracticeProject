CREATE TABLE IF NOT EXISTS Login (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    login VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    passhash VARCHAR(50) NOT NUll
);

CREATE TABLE IF NOT EXISTS Org (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name    VARCHAR(50) NOT NULL,
    fullname    VARCHAR(50) NOT NULL,
    inn  VARCHAR(50) NOT NULL,
    kpp  VARCHAR(50) NOT NULL,
    address VARCHAR(max) NOT NULL,
    phone  VARCHAR(50) NOT NUll,
    isActive BOOLEAN DEFAULT TRUE,
);

CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(max) NOT NULL,
    phone  VARCHAR(50) NOT NUll,
    isActive BOOLEAN DEFAULT TRUE,
    orgid INTEGER
);

CREATE TABLE IF NOT EXISTS Users (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    secondName VARCHAR(50) NOT NULL,
    middleName VARCHAR(50) NOT NULL,
    position VARCHAR(50) NOT NULL,
    phone  VARCHAR(50) NOT NUll,
    docid INTEGER,
    docNumber INTEGER NOT NULL,
    docDate DATE,
    citizenshipid INTEGER,
    isIdentified BOOLEAN DEFAULT TRUE,
    officeid INTEGER,

);

CREATE TABLE IF NOT EXISTS Docs {
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    code INTEGER NOT NUll
};

CREATE TABLE IF NOT EXISTS Countries {
    id        INTEGER  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    code INTEGER NOT NUll
};


ALTER TABLE Office ADD FOREIGN KEY (orgid) REFERENCES Org(id);
ALTER TABLE Users ADD FOREIGN KEY (officeid) REFERENCES Office(id);
ALTER TABLE Users ADD FOREIGN KEY (docid) REFERENCES Docs(id);
ALTER TABLE Users ADD FOREIGN KEY (citizenshipid) REFERENCES Countries(id);


