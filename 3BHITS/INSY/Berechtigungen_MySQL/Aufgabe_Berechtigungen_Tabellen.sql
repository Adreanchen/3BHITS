-- ======================================================
-- Datenbank-Setup: Personen & Log-Tabelle
-- ======================================================

-- Datenbank erstellen
DROP DATABASE IF EXISTS schulverwaltung;
CREATE DATABASE schulverwaltung;
USE schulverwaltung;

-- 1. Tabelle: personen
CREATE TABLE IF NOT EXISTS personen (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vorname VARCHAR(50) NOT NULL,
    nachname VARCHAR(50) NOT NULL,
    svnr CHAR(10) UNIQUE NOT NULL,
    geb_datum DATE NOT NULL
);

-- 2. Tabelle: personen_log
CREATE TABLE IF NOT EXISTS personen_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    aktion VARCHAR(20) NOT NULL,
    person_id INT,
    details TEXT,
    benutzer VARCHAR(50),
    zeitstempel TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ======================================================
-- Beispieldaten
-- ======================================================

INSERT INTO personen (vorname, nachname, svnr, geb_datum) VALUES
('Anna', 'Müller', '1234010105', '2005-01-01'),
('Lukas', 'Wagner', '5678150306', '2006-03-15'),
('Sarah', 'Huber', '9012200705', '2005-07-20'),
('Max', 'Mustermann', '1111101010', '2010-10-10');
