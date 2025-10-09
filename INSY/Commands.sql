CREATE DATABASE Fahrschule_DB;
use Fahrschule_DB;

CREATE TABLE Fahrlehrer (
  fahrlehrer_id int AUTO_INCREMENT,
  vorname varchar(255),
  nachname varchar(255),
  PRIMARY KEY (fahrlehrer_id)
);

CREATE TABLE Fahrschueler (
  schueler_id int AUTO_INCREMENT,
  vorname varchar(255),
  nachname varchar(255),
  adresse varchar(255),
  PRIMARY KEY (schueler_id)
);

CREATE TABLE Theoriekurs (
  kurs_id int AUTO_INCREMENT,
  kurs_name varchar(255),
  fahrlehrer_id int,
  PRIMARY KEY (kurs_id),
  CONSTRAINT Theoriekurs FOREIGN KEY (fahrlehrer_id) REFERENCES Fahrlehrer (fahrlehrer_id)
);

CREATE TABLE Fahrschulauto (
  auto_id int AUTO_INCREMENT,
  kennzeichen varchar(255),
  modell varchar(255),
  fahrlehrer_id int,
  PRIMARY KEY (auto_id),
  CONSTRAINT Fahrschulauto FOREIGN KEY (fahrlehrer_id) REFERENCES Fahrlehrer (fahrlehrer_id)
);

CREATE TABLE Fahrschueler_hat_Theoriekurs (
  schueler_id int,
  kurs_id int,
  PRIMARY KEY (schueler_id, kurs_id),
  KEY kurs_id (kurs_id),
  CONSTRAINT Fahrschueler_hat_Theoriekurs FOREIGN KEY (schueler_id) REFERENCES Fahrschueler (schueler_id),
  CONSTRAINT Theoriekurs_hat_Fahrschueler FOREIGN KEY (kurs_id) REFERENCES Theoriekurs (kurs_id)
);
