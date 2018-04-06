CREATE TABLE IF NOT EXISTS User (
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
    full_name    VARCHAR(50) NOT NULL,
    inn  VARCHAR(50) NOT NULL,
    kpp  VARCHAR(50) NOT NULL,
    address VARCHAR(max) NOT NULL,
    phone  VARCHAR(50) NOT NUll,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(max) NOT NULL,
    phone  VARCHAR(50) NOT NUll,
    is_active BOOLEAN DEFAULT TRUE,
    org_id INTEGER
);

CREATE TABLE IF NOT EXISTS Employee (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    second_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50) NOT NULL,
    position VARCHAR(50) NOT NULL,
    phone  VARCHAR(50) NOT NUll,
    doc_code INTEGER,
    doc_number INTEGER NOT NULL,
    citizenship_code INTEGER,
    is_identified BOOLEAN DEFAULT TRUE,
    office_id INTEGER


);

CREATE TABLE IF NOT EXISTS Doc_type (
    name VARCHAR(50) NOT NULL,
    code INTEGER PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Country (
    name VARCHAR(50) NOT NULL,
    code INTEGER NOT NULL PRIMARY KEY
);


CREATE INDEX office_ix_org_id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Org(id);

CREATE INDEX employee_ix_office_id ON  Employee (office_id);
ALTER TABLE Employee ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX employee_ix_doc_id ON  Employee (doc_code);
ALTER TABLE Employee ADD FOREIGN KEY (doc_code) REFERENCES Doc_type(code);

CREATE INDEX employee_ix_citizenship_id ON  Employee (citizenship_code);
ALTER TABLE Employee ADD FOREIGN KEY (citizenship_code) REFERENCES Country(code);



