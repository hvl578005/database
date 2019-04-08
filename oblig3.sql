
DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    
CREATE TABLE Ansatt
(
	id SERIAL UNIQUE,
    brukernavn VARCHAR(4) UNIQUE,
    fornavn VARCHAR(255),
    etternavn VARCHAR(255),
    ansettelsesdato DATE,
    stilling VARCHAR(255),
    maanedslonn VARCHAR(255),
    avdelingid INTEGER NOT NULL,
    CONSTRAINT UC_Ansatt UNIQUE (id, brukernavn),
    CONSTRAINT PK_Ansatt PRIMARY KEY (id)
);

CREATE TABLE avdeling
(
    avdelingid SERIAL UNIQUE,
    navn VARCHAR(255),
    sjefid INTEGER,
    CONSTRAINT PK_avdeling PRIMARY KEY (avdelingid),
    CONSTRAINT FK_avdeling FOREIGN KEY (sjefid) REFERENCES Ansatt(id)
);

INSERT INTO Ansatt
VALUES
    (123456, 'kbh', 'Kathrine', 'Hermansen', '2019-03-27', 'Sjef', '100 000', 1),
    (333444, 'aaa', 'Malin', 'Jensen', '2019-02-27', 'Redaktør', '40 000', 2),
    (111111, 'ths', 'Anna', 'Ulvestad', '2018-01-01', 'Resepsjonist', '25 000', 1),
    (121212, 'bbb', 'Berit', 'Nordmann', '2019-04-03', 'Sosiale medier ansvarlig', '10 000', 1),
    (10, 'ksa', 'Karianne', 'Smith', '2019-04-03', 'Konsulent', '50 000', 3),
    (11, 'hdf', 'Hertuginnen', 'Naomi', '2019-04-03', 'Hertuginne', '500 000', 2),
    (12, 'wtf', 'Trine', 'Hermansen', '2019-04-03', 'Konsulent', '50 000', 1),
    (13, 'mmm', 'Kari', 'Smith', '2019-04-03', 'Konsulent', '50 000', 2),
    (14, 'nja', 'Anne', 'Smith', '2019-04-03', 'Konsulent', '50 000', 3),
    (15, 'soa', 'Silja', 'Smith', '2019-04-03', 'Konsulent', '50 000', 1);

ALTER TABLE Ansatt ADD CONSTRAINT FK_avdeling
FOREIGN KEY (avdelingid) REFERENCES avdeling(avdelingid);

INSERT INTO avdeling
VALUES
    (1, 'Markedsføring', 123456),
    (2, 'IT', 10),
    (3, 'Salg', 15);



  

/*TA MED:
Avdeling (ANSATT MÅ JOBBE I AVDELING,)
    Prosjekter (ansatt har deltatt i eller deltar i, med rolle og antall arbeidstimer)
    - deltar i:
        - rolle 
        - antall arbeidstimer
    - har deltatt i:
        - rolle
        - antall arbeidstimer


Ansatt
 Unik ansatt-id (automatisk generert løpenummer)
 Unikt brukernavn (initialer, 3-4 bokstaver, f.eks. «lph»)
 Fornavn
 Etternavn
 Dato for ansettelse
 Stilling
 Månedslønn
 Hvilken avdeling den ansatte jobber i
 Hvilke prosjekter den ansatte deltar/har deltatt i m/ rolle og antall arbeidstimer*/