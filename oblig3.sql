
DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    
CREATE TABLE Ansatt
(
	Id SERIAL UNIQUE,
    Brukernavn VARCHAR(4) UNIQUE,
    Fornavn VARCHAR(255),
    Etternavn VARCHAR(255),
    Ansettelsesdato DATE,
    Stilling VARCHAR(255),
    Maanedslonn VARCHAR(255),
    Avdelingid INTEGER NOT NULL,
    CONSTRAINT UC_Ansatt UNIQUE (Id, Brukernavn),
    CONSTRAINT PK_Ansatt PRIMARY KEY (Id)
);

CREATE TABLE Avdeling
(
    Avdelingid SERIAL UNIQUE,
    Navn VARCHAR(255),
    Sjefid INTEGER,
    CONSTRAINT PK_avdeling PRIMARY KEY (Avdelingid),
    CONSTRAINT FK_avdeling FOREIGN KEY (Sjefid) REFERENCES Ansatt(Id)
);

INSERT INTO Ansatt(Brukernavn, Fornavn, Etternavn, Ansettelsesdato, Stilling, Maanedslonn, Avdelingid)
VALUES
    ('kbh', 'Kathrine', 'Hermansen', '2019-03-27', 'Sjef', '100 000', 1),
    ('aaa', 'Malin', 'Jensen', '2019-02-27', 'Redaktør', '40 000', 2),
    ('ths', 'Anna', 'Ulvestad', '2018-01-01', 'Resepsjonist', '25 000', 1),
    ('bbb', 'Berit', 'Nordmann', '2019-04-03', 'Sosiale medier ansvarlig', '10 000', 1),
    ('ksa', 'Karianne', 'Smith', '2019-04-03', 'Konsulent', '50 000', 3),
    ('hdf', 'Hertuginnen', 'Naomi', '2019-04-03', 'Hertuginne', '500 000', 2),
    ('wtf', 'Trine', 'Hermansen', '2019-04-03', 'Konsulent', '50 000', 1),
    ('mmm', 'Kari', 'Smith', '2019-04-03', 'Konsulent', '50 000', 2),
    ('nja', 'Anne', 'Smith', '2019-04-03', 'Konsulent', '50 000', 3),
    ('soa', 'Silja', 'Smith', '2019-04-03', 'Konsulent', '50 000', 1),
    ('jbj', 'Julie', 'Heldal', '2019-04-09', 'Sjef', '90 000', 4),
    ('fss', 'Francis', 'Soliman', '2019-04-09', 'Spion', '9 000', 4),
    ('lss', 'Lasse', 'Hansen', '2019-04-09', 'Pizza ekspert', '47 000', 4);

INSERT INTO Avdeling(Navn, Sjefid)
VALUES
    ('Markedsføring', 1),
    ('IT', 2),
    ('Salg', 3),
    ('Kjøkken', 11);
    
ALTER TABLE Ansatt ADD CONSTRAINT FK_avdeling
FOREIGN KEY (Avdelingid) REFERENCES Avdeling(Avdelingid);


