CREATE SCHEMA projektverwaltung;
CREATE SCHEMA stammdaten;
CREATE SCHEMA vertragsverwaltung;
CREATE SCHEMA zeiterfassung;
CREATE SCHEMA leistungsverwaltung;
CREATE SCHEMA abrechnung;


---------------------- schema.stammdaten ----------------------


CREATE TABLE IF NOT EXISTS stammdaten.person
(
    id                  BIGINT PRIMARY KEY,
    email               VARCHAR(255),
    rechnungsadresse    VARCHAR(255),
    beschreibung        VARCHAR(255),
    iban                VARCHAR(255)
);


-- Personentabelle Data
INSERT INTO stammdaten.person (id, email, rechnungsadresse, beschreibung, iban)
VALUES
(1, 'max.mustermann@example.com', 'Unter den Linden 12, 10117 Berlin', 'Ansprechpartner für ACME Inc.', 'DE12 3456 7890 1234 5678 90'),
(2, 'anna.mueller@globex.com', 'Kurfürstendamm 123, 10709 Berlin', 'Ansprechpartner für Globex Corporation', 'DE98 7654 3210 9876 5432 10'),
(3, 'peter.schmidt@initech.de', 'Am Sandtorkai 64, 20457 Hamburg', 'Ansprechpartner für Initech GmbH', 'DE34 5678 9012 3456 7890 12'),
(4, 'sarah.mueller@cyberdyne.de', 'Zirkusweg 2, 20359 Hamburg', 'Ansprechpartner für Cyberdyne Systems', 'DE56 7890 1234 5678 9012 34'),
(5, 'johannes.maier@oscorp.com', 'Königstraße 3, 70173 Stuttgart', 'Ansprechpartner für Oscorp Industries', 'DE90 1234 5678 9012 3456 78'),
(6, 'melanie.klein@wayne.de', 'Grabenstraße 5, 40213 Düsseldorf', 'Ansprechpartner für Wayne Enterprises', 'DE12 3456 7890 1234 5678 90'),
(7, 'paul.schneider@stark.com', 'Hanauer Landstraße 291-293, 60314 Frankfurt am Main', 'Ansprechpartner für Stark Industries', 'DE98 7654 3210 9876 5432 10'),
(8, 'hans.mueller@umbrella.de', 'Am Sandtorkai 38, 20457 Hamburg', 'Ansprechpartner für Umbrella Corporation', 'DE34 5678 9012 3456 7890 12'),
(9, 'eva.wagner@weyland-yutani.com', 'An der Alster 85, 20099 Hamburg', 'Ansprechpartner für Weyland-Yutani Corporation', 'DE56 7890 1234 5678 9012 34'),
(10, 'frank.stein@aperture.de', 'Königstraße 26, 70173 Stuttgart', 'Ansprechpartner für Aperture Science', 'DE90 1234 5678 9012 3456 78'),
(11, 'lisa.mueller@benthos-oil.com', 'Am Zirkus 2, 10117 Berlin', 'Ansprechpartner für Benthos Oil', 'DE12 3456 7890 1234 5678 90'),
(12, 'max.mustermann@gringotts.com', 'Bahnhofstraße 32, 60329 Frankfurt am Main', 'Ansprechpartner für Gringotts Wizarding Bank', 'DE98 7654 3210 9876 5432 10'),
(13, 'julia.meyer@tyrell.de', 'Marienplatz 8, 80331 München', 'Ansprechpartner für Tyrell Corporation', 'DE34 5678 9012 3456 7890 12'),
(14, 'max.mustermann@virtucon.com', 'Königstraße 56, 70173 Stuttgart', 'Ansprechpartner für Virtucon Industries', 'DE12 3456 7890 1234 5678 90'),
(15, 'peter.parker@weygandt.de', 'Kaiserswerther Straße 135, 40474 Düsseldorf', 'Ansprechpartner für Weygandt Industries', 'DE23 4567 8901 2345 6789 01'),
(16, 'desmond.miles@abstergo.com', 'Berliner Allee 65, 40212 Düsseldorf', 'Ansprechpartner für Abstergo Industries', 'DE34 5678 9012 3456 7890 12'),
(17, 'max.mustermann@example.com', 'Unter den Linden 12, 10117 Berlin', 'Softwareentwickler, spezialisiert auf Web-Technologien', 'DE89100000001234567890'),
(18, 'julia.mayer@example.com', 'Kurfürstendamm 123, 10709 Berlin', 'Softwarearchitekt mit langjähriger Erfahrung in der Finanzbranche', 'DE89100000004321098765'),
(19, 'alexander.mueller@example.com', 'Am Sandtorkai 64, 20457 Hamburg', 'IT-Projektmanager mit Expertise in agilen Methoden', 'DE89100000005432187654'),
(20, 'sandra.schmidt@example.com', 'Zirkusweg 2, 20359 Hamburg', 'Consultant für digitale Transformation in der Automobilbranche', 'DE89100000006543276543'),
(21, 'lukas.schulz@example.com', 'Königstraße 3, 70173 Stuttgart', 'Softwareentwickler mit Schwerpunkt auf Datenbanktechnologien', 'DE89100000007654365432'),
(22, 'marie.klein@example.com', 'Grabenstraße 5, 40213 Düsseldorf', 'UX-Designerin mit Erfahrung in der Entwicklung von mobilen Anwendungen', 'DE89100000008765454321'),
(23, 'felix.becker@example.com', 'Hanauer Landstraße 291-293, 60314 Frankfurt am Main', 'IT-Sicherheitsexperte mit fundiertem Wissen in der Cloud-Technologie', 'DE89100000009876543210'),
(24, 'hannah.wagner@example.com', 'Am Sandtorkai 38, 20457 Hamburg', 'Junior-Entwicklerin für Web-Anwendungen mit Schwerpunkt auf ReactJS', 'DE89100000000123456789'),
(25, 'leon.fischer@example.com', 'An der Alster 85, 20099 Hamburg', 'Entwickler für mobile Anwendungen mit Expertise in der Nutzung von NLP', 'DE89100000000234567890'),
(26, 'anja.weber@example.com', 'Königstraße 26, 70173 Stuttgart', 'Beraterin für digitale Transformation in der Industriebranche', 'DE89100000000345678901'),
(27, 'jan.meier@example.com', 'Am Zirkus 2, 10117 Berlin', 'Softwareentwickler mit Erfahrung in der Anwendung von Machine Learning', 'DE89100000000456789012'),
(28, 'katharina.huber@example.com', 'Bahnhofstraße 32, 60329 Frankfurt am Main', 'IT-Consultant für Finanzdienstleister mit Schwerpunkt auf Blockchain', 'DE89100000000567890123'),
(29, 'svenja.meyer@example.com', 'Marienplatz 8, 80331 München', 'IT-Projektmanagerin für agile Softwareentwicklung mit Scrum Master-Zertifizierung', 'DE89100000000678901234'),
(30, 'philipp.grimm@example.com', 'Königstraße 56, 70173 Stuttgart', 'Softwarearchitekt mit fundierten Kenntnissen in Java und Python', 'DE12500105170648489890'),
(31, 'lisa.hoffmann@acme.com', 'Unter den Linden 12, 10117 Berlin', 'Ansprechpartnerin für Kunden aus der Automobilbranche', 'DE12345678901234567890'),
(32, 'max.mustermann@globex.com', 'Kurfürstendamm 123, 10709 Berlin', 'Ansprechpartner für Kunden aus der Energiebranche', 'DE09876543210987654321'),
(33, 'martina.mueller@initech.de', 'Am Sandtorkai 64, 20457 Hamburg', 'Projektmanagerin für IT-Infrastrukturprojekte', 'DE13579086420135790864'),
(34, 'peter.parker@cyberdyne.de', 'Zirkusweg 2, 20359 Hamburg', 'Entwickler für Robotiksoftware', 'DE45678901234567890123'),
(35, 'gwen.stacy@oscorp.com', 'Königstraße 3, 70173 Stuttgart', 'Leiterin Forschung & Entwicklung für Pharmazeutika', 'DE98765432109876543210'),
(36, 'bruce.wayne@wayne.de', 'Grabenstraße 5, 40213 Düsseldorf', 'Geschäftsführer für Maschinenbau und Automatisierungstechnik', 'DE01234567890123456789'),
(37, 'tony.stark@stark.com', 'Hanauer Landstraße 291-293, 60314 Frankfurt am Main', 'CEO für Elektronik und Robotik', 'DE54321098765432109876'),
(38, 'claire.redfield@umbrella.de', 'Am Sandtorkai 38, 20457 Hamburg', 'Leiterin Qualitätsmanagement für Pharmazeutika', 'DE32109876543210987654'),
(39, 'ellen.ripley@weyland-yutani.com', 'An der Alster 85, 20099 Hamburg', 'Astronautin und Sicherheitsbeauftragte für Weltraummissionen', 'DE67890123456789012345'),
(40, 'chell@aperture.de', 'Königstraße 26, 70173 Stuttgart', 'Testsubjekt für Testkammern', 'DE89012345678901234567');


CREATE TABLE IF NOT EXISTS stammdaten.kunde
(
    id                  BIGINT,
    firmenname          VARCHAR(255),
    rechtsform          VARCHAR(255)
);

-- Inheritance Strategy Joined
ALTER TABLE ONLY stammdaten.kunde ADD CONSTRAINT kunde_person_fk FOREIGN KEY (id) REFERENCES stammdaten.person(id);

-- Kundentabelle Data
INSERT INTO stammdaten.kunde (id, firmenname, rechtsform)
VALUES
    (1, 'ACME Inc.', 'GmbH'),
    (2, 'Globex Corporation', 'AG'),
    (3, 'Initech GmbH', 'GmbH'),
    (4, 'Cyberdyne Systems', 'GmbH'),
    (5, 'Oscorp Industries', 'AG'),
    (6, 'Wayne Enterprises', 'GmbH'),
    (7, 'Stark Industries', 'AG'),
    (8, 'Umbrella Corporation', 'GmbH'),
    (9, 'Weyland-Yutani Corporation', 'AG'),
    (10, 'Aperture Science', 'GmbH'),
    (11, 'Benthos Oil', 'AG'),
    (12, 'Gringotts Wizarding Bank', 'GmbH'),
    (13, 'Tyrell Corporation', 'GmbH'),
    (14, 'Virtucon Industries', 'AG'),
    (15, 'Weygandt Industries', 'GmbH'),
    (16, 'Abstergo Industries', 'AG');


CREATE TABLE IF NOT EXISTS stammdaten.mitarbeiter (
    id                  BIGINT,
    vorname             VARCHAR(255),
    nachname            VARCHAR(255),
    kuerzel             VARCHAR(255),
    rolle               VARCHAR(255),
    ausgeschieden       BOOLEAN
);

-- Inheritance Strategy Joined
ALTER TABLE ONLY stammdaten.mitarbeiter ADD CONSTRAINT mitarbeiter_person_fk FOREIGN KEY (id) REFERENCES stammdaten.person(id);

-- Mitarbeitertabelle Data
INSERT INTO stammdaten.mitarbeiter (id, vorname, nachname, kuerzel, rolle, ausgeschieden)
VALUES
    (17, 'Max', 'Mustermann', 'MUMU', 'Entwickler', false),
    (18, 'Anna', 'Schmidt', 'ASCH', 'Entwickler', false),
    (19, 'Lena', 'Müller', 'LMUE', 'Entwickler', false),
    (20, 'Simon', 'Klein', 'SKLE', 'Führungskraft', false),
    (21, 'Laura', 'Schneider', 'LSCH', 'Führungskraft', false),
    (22, 'Johannes', 'Koch', 'JKOC', 'Consultant', false),
    (23, 'Jan', 'Schulz', 'JSCH', 'Consultant', false),
    (24, 'Paul', 'Hofmann', 'PHOF', 'IT-Support', false),
    (25, 'Sabrina', 'Meyer', 'SMEY', 'IT-Support', false),
    (26, 'Oliver', 'Fuchs', 'OFUC', 'Entwickler', false),
    (27, 'Hannah', 'Baum', 'HBUM', 'Entwickler', false),
    (28, 'Moritz', 'Huber', 'MHUB', 'Führungskraft', false),
    (29, 'Sarah', 'Gärtner', 'SGAE', 'Consultant', false),
    (30, 'Sebastian', 'Kramer', 'SKRA', 'Consultant', false),
    (31, 'Lisa', 'Bauer', 'LBAU', 'IT-Support', false),
    (32, 'Hans', 'Müller', 'HMUE', 'Fachabteilung', false),
    (33, 'Laura', 'Schmidt', 'LSCH', 'Fachabteilung', false),
    (34, 'Markus', 'Bauer', 'MBAU', 'Fachabteilung', false),
    (35, 'Sabine', 'Koch', 'SKOC', 'Human Resources', false),
    (36, 'Daniel', 'Klein', 'DKLE', 'Human Resources', false),
    (37, 'Anna', 'Fischer', 'AFIS', 'Human Resources', false),
    (38, 'Peter', 'Hoffmann', 'PHOF', 'Rechnungswesen', false),
    (39, 'Tanja', 'Meyer', 'TMEY', 'Rechnungswesen', false),
    (40, 'David', 'Wagner', 'DWAG', 'Rechnungswesen', false);


---------------------- schema.projektverwaltung ----------------------


CREATE TABLE IF NOT EXISTS projektverwaltung.projekt
(
    id                  BIGINT PRIMARY KEY,
    projekt_kuerzel      VARCHAR(255),
    beschreibung        VARCHAR(255),
    startdatum          DATE,
    enddatum            DATE,
    kunden_id            BIGINT
);

-- Projekttabelle Data
INSERT INTO projektverwaltung.projekt (id, projekt_kuerzel, beschreibung, startdatum, enddatum, kunden_id) VALUES
    (1, 'CLMF', 'Neue Website', '2022-01-01', '2022-06-30', 1),
    (2, 'KRUK', 'ERP-System', '2022-02-15', '2023-02-14', 2),
    (3, 'CLMA', 'App-Entwicklung', '2022-03-01', '2022-09-30', 3),
    (4, 'DISA', 'Marketing-Kampagne', '2022-04-01', '2022-07-31', 4),
    (5, 'RUFU', 'E-Commerce-Plattform', '2022-05-01', '2023-04-30', 5),
    (6, 'ESOM', 'CRM-System', '2022-06-01', '2022-12-31', 6),
    (7, 'ARAG', 'IT-Infrastruktur', '2022-07-01', '2023-06-30', 7),
    (8, 'SETU', 'Software-Integration', '2022-08-01', '2023-03-31', 8),
    (9, 'ZEMC', 'Data-Warehouse', '2022-09-01', '2023-08-31', 9),
    (10, 'LASV', 'E-Learning-Plattform', '2022-10-01', '2023-09-30', 10),
    (11, 'RASV', 'IT-Sicherheitsaudit', '2022-11-01', '2022-12-31', 11),
    (12, 'ROMB', 'ERP-Optimierung', '2022-12-01', '2023-11-30', 12),
    (13, 'XEXO', 'Social-Media-Kampagne', '2023-01-01', '2023-02-28', 13),
    (14, 'BMIN', 'Mobile-App-Design', '2023-02-01', '2023-09-30', 14),
    (15, 'IWAX', 'Cloud-Migration', '2023-03-01', '2023-06-30', 15),
    (16, 'YAPI', 'ERP-Integration', '2023-04-01', '2023-11-30', 16);


---------------------- schema.vertragsverwaltung ----------------------


CREATE TABLE IF NOT EXISTS vertragsverwaltung.vertrag
(
    id                  BIGINT PRIMARY KEY,
    startdatum          DATE,
    enddatum            DATE,
    projekt             BIGINT
);

-- Vertragtabelle Data
INSERT INTO vertragsverwaltung.vertrag (id, startdatum, enddatum, projekt)
VALUES (1, '2022-01-01', '2022-12-31', 1),
       (2, '2022-02-01', '2022-12-31', 2),
       (3, '2022-03-01', '2022-12-31', 3),
       (4, '2022-04-01', '2022-12-31', 4),
       (5, '2022-05-01', '2022-12-31', 5),
       (6, '2022-06-01', '2022-12-31', 6),
       (7, '2022-07-01', '2022-12-31', 7),
       (8, '2022-08-01', '2022-12-31', 8),
       (9, '2022-09-01', '2022-12-31', 9),
       (10, '2022-10-01', '2022-12-31', 10),
       (11, '2022-11-01', '2022-12-31', 11),
       (12, '2022-12-01', '2022-12-31', 12),
       (13, '2023-01-01', '2023-12-31', 13),
       (14, '2023-02-01', '2023-12-31', 14),
       (15, '2023-03-01', '2023-12-31', 15),
       (16, '2023-04-01', '2023-12-31', 16),
       (21, '2022-01-01', '2022-06-30', 11),
       (22, '2022-01-01', '2022-12-31', 7),
       (23, '2022-03-01', '2022-12-31', 14),
       (24, '2022-04-01', '2022-09-30', 2),
       (25, '2022-05-01', '2022-10-31', 4),
       (26, '2022-06-01', '2022-11-30', 9),
       (27, '2022-07-01', '2022-12-31', 6),
       (28, '2022-08-01', '2022-10-31', 16),
       (29, '2022-09-01', '2022-12-31', 3),
       (30, '2022-10-01', '2022-12-31', 12),
       (31, '2022-06-01', '2023-05-31', 11),
       (32, '2021-10-01', '2022-09-30', 13),
       (33, '2021-11-01', '2022-10-31', 6),
       (34, '2022-01-01', '2022-12-31', 15),
       (35, '2022-03-01', '2023-02-28', 5),
       (36, '2022-04-01', '2023-03-31', 10),
       (37, '2022-05-01', '2023-04-30', 12),
       (38, '2022-07-01', '2023-06-30', 8),
       (39, '2022-08-01', '2023-07-31', 7),
       (40, '2022-09-01', '2023-08-31', 16);


CREATE TABLE IF NOT EXISTS vertragsverwaltung.kundenvertrag
(
    id                  BIGINT,
    leistungssatz       NUMERIC,
    kunde               BIGINT
);

-- Inheritance Strategy Joined
ALTER TABLE ONLY vertragsverwaltung.kundenvertrag ADD CONSTRAINT kundenvertrag_vertrag_fk FOREIGN KEY (id) REFERENCES vertragsverwaltung.vertrag(id);

-- Kundenertragtabelle Data
INSERT INTO vertragsverwaltung.kundenvertrag (id, leistungssatz, kunde)
VALUES (1, 1.25, 1),
       (2, 2.00, 2),
       (3, 1.50, 3),
       (4, 2.75, 4),
       (5, 1.10, 5),
       (6, 3.00, 6),
       (7, 1.80, 7),
       (8, 2.30, 8),
       (9, 4.50, 9),
       (10, 1.75, 10),
       (11, 2.55, 11),
       (12, 1.30, 12),
       (13, 2.10, 13),
       (14, 3.50, 14),
       (15, 1.90, 15),
       (16, 5.00, 16);


CREATE TABLE IF NOT EXISTS vertragsverwaltung.partnervertrag
(
    id                  BIGINT,
    tagessatz           NUMERIC,
    mitarbeiter         BIGINT
);

-- Inheritance Strategy Joined
ALTER TABLE ONLY vertragsverwaltung.partnervertrag ADD CONSTRAINT partnervertrag_vertrag_fk FOREIGN KEY (id) REFERENCES vertragsverwaltung.vertrag(id);

-- Partnervertragtabelle Data
INSERT INTO vertragsverwaltung.partnervertrag (id, tagessatz, mitarbeiter)
VALUES
    (21, 500.00, 17),
    (22, 1000.00, 18),
    (23, 750.00, 19),
    (24, 200.00, 20),
    (25, 450.00, 21),
    (26, 650.00, 22),
    (27, 550.00, 23),
    (28, 800.00, 24),
    (29, 300.00, 25),
    (30, 900.00, 26),
    (31, 1000.00, 17),
    (32, 350.00, 18),
    (33, 550.00, 19),
    (34, 1200.00, 20),
    (35, 250.00, 21),
    (36, 800.00, 22),
    (37, 950.00, 23),
    (38, 700.00, 24),
    (39, 1000.00, 25),
    (40, 1300.00, 26);



---------------------- schema.zeiterfassung ----------------------


CREATE TABLE IF NOT EXISTS zeiterfassung.taetigkeit
(
    id                  BIGINT PRIMARY KEY,
    beginn              TIMESTAMP,
    ende                TIMESTAMP,
    pause               BIGINT,
    typ                 varchar,
    projekt             BIGINT,
    mitarbeiter         BIGINT,
    partnervertrag      BIGINT,
    kundenvertrag       BIGINT,
    leistungsnachweis   BIGINT
);


-- Taetigkeittabelle Data
INSERT INTO zeiterfassung.taetigkeit (id, beginn, ende, pause, typ, projekt, mitarbeiter, partnervertrag, kundenvertrag, leistungsnachweis)
VALUES
    (1, '2022-01-01 09:00:00', '2022-01-01 17:00:00', 60, 'Besprechung', 1, 17, 21, 1, 5),
    (2, '2022-01-02 08:00:00', '2022-01-02 16:00:00', 30, 'Entwicklung', 2, 18, 22, 2, 7),
    (3, '2022-01-03 10:00:00', '2022-01-03 16:00:00', 60, 'Beratung', 3, 19, 23, 3, 11),
    (4, '2022-01-04 08:30:00', '2022-01-04 17:00:00', 45, 'Support', 4, 20, 24, 4, 1),
    (5, '2022-01-05 09:00:00', '2022-01-05 16:30:00', 60, 'Projektmanagement', 5, 21, 25, 5, 14),
    (6, '2022-01-06 08:00:00', '2022-01-06 12:00:00', 0, 'Entwicklung', 6, 22, 26, 6, 3),
    (7, '2022-01-07 10:00:00', '2022-01-07 16:00:00', 60, 'Beratung', 7, 23, 27, 7, 10),
    (8, '2022-01-08 09:00:00', '2022-01-08 13:00:00', 15, 'Entwicklung', 8, 24, 28, 8, 17),
    (9, '2022-01-09 10:00:00', '2022-01-09 18:00:00', 45, 'Support', 9, 25, 29, 9, 8),
    (10, '2022-01-10 08:00:00', '2022-01-10 12:30:00', 0, 'Entwicklung', 10, 26, 30, 10, 2),
    (11, '2022-01-11 09:30:00', '2022-01-11 17:30:00', 60, 'Projektmanagement', 11, 27, 31, 11, 13),
    (12, '2022-01-12 08:00:00', '2022-01-12 16:00:00', 30, 'Entwicklung', 12, 28, 32, 12, 16),
    (13, '2022-01-13 09:00:00', '2022-01-13 14:00:00', 30, 'Support', 13, 29, 33, 13, 9),
    (14, '2022-02-15 08:00:00', '2022-02-15 17:00:00', 60, 'Meeting', 5, 17, 24, 13, 3),
    (15, '2022-02-16 09:00:00', '2022-02-16 12:00:00', 15, 'Recherche', 1, 18, 27, 2, 7),
    (16, '2022-02-17 10:00:00', '2022-02-17 14:00:00', 30, 'Testing', 6, 19, 25, 14, 6),
    (17, '2022-02-18 11:00:00', '2022-02-18 16:00:00', 45, 'Entwicklung', 4, 20, 26, 10, 5),
    (18, '2022-02-19 13:00:00', '2022-02-19 17:00:00', 0, 'Recherche', 3, 21, 29, 6, 19),
    (19, '2022-02-20 10:00:00', '2022-02-20 15:00:00', 30, 'Testing', 2, 22, 30, 1, 14),
    (20, '2022-02-21 08:00:00', '2022-02-21 16:00:00', 60, 'Entwicklung', 7, 23, 38, 8, 13),
    (21, '2022-02-22 08:00:00', '2022-02-22 12:00:00', 15, 'Recherche', 10, 24, 21, 5, 18),
    (22, '2022-02-23 09:00:00', '2022-02-23 14:00:00', 30, 'Testing', 11, 25, 28, 3, 11),
    (23, '2022-02-24 10:00:00', '2022-02-24 14:00:00', 45, 'Entwicklung', 12, 26, 22, 9, 1),
    (24, '2022-02-25 11:00:00', '2022-02-25 16:00:00', 0, 'Recherche', 15, 27, 35, 7, 15),
    (25, '2022-02-26 13:00:00', '2022-02-26 17:00:00', 30, 'Testing', 16, 28, 37, 2, 8),
    (26, '2022-02-27 10:00:00', '2022-02-27 15:00:00', 60, 'Entwicklung', 14, 29, 39, 12, 2);


CREATE TABLE IF NOT EXISTS zeiterfassung.mitarbeiter_monat
(
    id                  BIGINT PRIMARY KEY,
    monat               DATE,
    mitarbeiter         BIGINT
);


-- Mitarbeitermonattabelle data
INSERT INTO zeiterfassung.mitarbeiter_monat (id, monat, mitarbeiter)
VALUES
    (1, '2022-01-01', 17),
    (2, '2022-02-01', 18),
    (3, '2022-03-01', 19),
    (4, '2022-04-01', 20),
    (5, '2022-05-01', 21),
    (6, '2022-06-01', 22),
    (7, '2022-07-01', 23),
    (8, '2022-08-01', 24),
    (9, '2022-09-01', 25),
    (10, '2022-10-01', 26),
    (11, '2022-11-01', 27),
    (12, '2022-12-01', 28),
    (13, '2022-01-01', 29),
    (14, '2022-02-01', 30),
    (15, '2022-03-01', 17),
    (16, '2022-04-01', 18),
    (17, '2022-05-01', 19),
    (18, '2022-06-01', 20),
    (19, '2022-07-01', 21),
    (20, '2022-08-01', 22),
    (21, '2022-09-01', 23),
    (22, '2022-10-01', 24),
    (23, '2022-11-01', 25),
    (24, '2022-12-01', 26),
    (25, '2022-01-01', 27),
    (26, '2022-02-01', 28),
    (27, '2022-03-01', 29),
    (28, '2022-04-01', 30),
    (29, '2022-05-01', 17),
    (30, '2022-06-01', 18);


---------------------- schema.leistungsverwaltung ----------------------


CREATE TABLE IF NOT EXISTS leistungsverwaltung.dienstleistungsnachweis
(
    id                  BIGINT PRIMARY KEY,
    personentage        NUMERIC,
    korrektur           NUMERIC,
    leistungszeitraum   DATE,
    geprueft            BOOLEAN,
    partnervertrag      BIGINT,
    kundenvertrag       BIGINT
);

-- Dienstleistungsnachweistabelle Data
INSERT INTO leistungsverwaltung.dienstleistungsnachweis
(id, personentage, korrektur, leistungszeitraum, geprueft, partnervertrag, kundenvertrag)
SELECT
                ROW_NUMBER() OVER (ORDER BY t.id) + 1 AS id,
                (EXTRACT(epoch FROM (t.ende - t.beginn)) / 3600) / 8 AS personentage,
                0.00 AS korrektur,
                mm.monat AS leistungszeitraum,
                CASE WHEN ROW_NUMBER() OVER (ORDER BY t.id) <= 10 THEN true ELSE false END AS geprueft,
                t.partnervertrag AS partnervertrag,
                t.kundenvertrag AS kundenvertrag
FROM
    zeiterfassung.taetigkeit t
        INNER JOIN zeiterfassung.mitarbeiter_monat mm ON t.mitarbeiter = mm.mitarbeiter AND mm.monat >= t.beginn AND mm.monat <= t.ende
ORDER BY
    t.id;

---------------------- schema.abrechnung ----------------------


CREATE TABLE IF NOT EXISTS abrechnung.abrechenbare_leistung
(
    id                  BIGINT PRIMARY KEY,
    einzelpreis         NUMERIC,
    anzahl              NUMERIC,
    leistungszeitraum   DATE,
    leistungsnachweis   BIGINT,
    rechnung            BIGINT
);

-- Abrechenbareleistungtabelle Data
INSERT INTO abrechnung.abrechenbare_leistung (id, einzelpreis, anzahl, leistungszeitraum, leistungsnachweis, rechnung)
VALUES
    (1, 2250.00, 10.50, '2022-01-01', 1, 1),
    (2, 3125.50, 14.00, '2022-01-01', 2, 2),
    (3, 2750.00, 11.50, '2022-02-01', 3, 3),
    (4, 5000.00, 20.00, '2022-03-01', 4, 4),
    (5, 1950.00, 9.00, '2022-04-01', 5, 5),
    (6, 2700.00, 12.00, '2022-05-01', 6, NULL),
    (7, 3225.00, 15.00, '2022-06-01', 7, NULL),
    (8, 3675.00, 15.00, '2022-07-01', 8, NULL),
    (9, 2400.00, 10.00, '2022-08-01', 9, NULL),
    (10, 2900.00, 11.50, '2022-09-01', 10, NULL);


CREATE TABLE IF NOT EXISTS abrechnung.rechnung
(
    id                  BIGINT PRIMARY KEY,
    erstellung          DATE,
    bezahlt             DATE,
    gestellt            BOOLEAN,
    kunde               BIGINT
);

-- Rechnungtabelle Data
INSERT INTO abrechnung.rechnung (id, erstellung, bezahlt, gestellt, kunde)
VALUES
    (1, '2022-02-15', NULL, true, 1),
    (2, '2022-03-10', NULL, false, 2),
    (3, '2022-04-05', '2022-04-25', true, 3),
    (4, '2022-05-01', NULL, false, 4),
    (5, '2022-06-02', NULL, false, 5);
