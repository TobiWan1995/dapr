--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: leistungsverwaltung; Type: SCHEMA; Schema: -; Owner: root
--

CREATE SCHEMA leistungsverwaltung;


ALTER SCHEMA leistungsverwaltung OWNER TO root;

--
-- Name: projektverwaltung; Type: SCHEMA; Schema: -; Owner: root
--

CREATE SCHEMA projektverwaltung;


ALTER SCHEMA projektverwaltung OWNER TO root;

--
-- Name: stammdaten; Type: SCHEMA; Schema: -; Owner: root
--

CREATE SCHEMA stammdaten;


ALTER SCHEMA stammdaten OWNER TO root;

--
-- Name: vertragsverwaltung; Type: SCHEMA; Schema: -; Owner: root
--

CREATE SCHEMA vertragsverwaltung;


ALTER SCHEMA vertragsverwaltung OWNER TO root;

--
-- Name: zeiterfassung; Type: SCHEMA; Schema: -; Owner: root
--

CREATE SCHEMA zeiterfassung;


ALTER SCHEMA zeiterfassung OWNER TO root;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: dienstleistungsnachweis; Type: TABLE; Schema: leistungsverwaltung; Owner: root
--

CREATE TABLE leistungsverwaltung.dienstleistungsnachweis (
    id bigint NOT NULL,
    personentage numeric,
    korrektur numeric,
    leistungszeitraum date,
    geprueft boolean,
    partnervertrag bigint,
    kundenvertrag bigint
);


ALTER TABLE leistungsverwaltung.dienstleistungsnachweis OWNER TO root;

--
-- Name: kunde; Type: TABLE; Schema: projektverwaltung; Owner: root
--

CREATE TABLE projektverwaltung.kunde (
    id bigint NOT NULL,
    beschreibung character varying,
    firmenname character varying,
    rechtsform character varying
);


ALTER TABLE projektverwaltung.kunde OWNER TO root;

--
-- Name: projekt; Type: TABLE; Schema: projektverwaltung; Owner: root
--

CREATE TABLE projektverwaltung.projekt (
    id bigint NOT NULL,
    projekt_kuerzel character varying(255),
    beschreibung character varying(255),
    startdatum date,
    enddatum date,
    kunden_id bigint
);


ALTER TABLE projektverwaltung.projekt OWNER TO root;

--
-- Name: kunde; Type: TABLE; Schema: stammdaten; Owner: root
--

CREATE TABLE stammdaten.kunde (
    id bigint,
    firmenname character varying(255),
    rechtsform character varying(255)
);


ALTER TABLE stammdaten.kunde OWNER TO root;

--
-- Name: mitarbeiter; Type: TABLE; Schema: stammdaten; Owner: root
--

CREATE TABLE stammdaten.mitarbeiter (
    id bigint,
    vorname character varying(255),
    nachname character varying(255),
    kuerzel character varying(255),
    rolle character varying(255),
    ausgeschieden boolean
);


ALTER TABLE stammdaten.mitarbeiter OWNER TO root;

--
-- Name: person; Type: TABLE; Schema: stammdaten; Owner: root
--

CREATE TABLE stammdaten.person (
    id bigint NOT NULL,
    email character varying(255),
    rechnungsadresse character varying(255),
    beschreibung character varying(255),
    iban character varying(255)
);


ALTER TABLE stammdaten.person OWNER TO root;

--
-- Name: kunde; Type: TABLE; Schema: vertragsverwaltung; Owner: root
--

CREATE TABLE vertragsverwaltung.kunde (
    id bigint NOT NULL,
    beschreibung character varying,
    firmenname character varying,
    rechtsform character varying
);


ALTER TABLE vertragsverwaltung.kunde OWNER TO root;

--
-- Name: kundenvertrag; Type: TABLE; Schema: vertragsverwaltung; Owner: root
--

CREATE TABLE vertragsverwaltung.kundenvertrag (
    id bigint,
    leistungssatz numeric,
    kunde bigint
);


ALTER TABLE vertragsverwaltung.kundenvertrag OWNER TO root;

--
-- Name: mitarbeiter; Type: TABLE; Schema: vertragsverwaltung; Owner: root
--

CREATE TABLE vertragsverwaltung.mitarbeiter (
    id bigint NOT NULL,
    vorname character varying(255),
    nachname character varying(255),
    kuerzel character varying(255),
    rolle character varying(255),
    ausgeschieden boolean
);


ALTER TABLE vertragsverwaltung.mitarbeiter OWNER TO root;

--
-- Name: partnervertrag; Type: TABLE; Schema: vertragsverwaltung; Owner: root
--

CREATE TABLE vertragsverwaltung.partnervertrag (
    id bigint,
    tagessatz numeric,
    mitarbeiter bigint
);


ALTER TABLE vertragsverwaltung.partnervertrag OWNER TO root;

--
-- Name: vertrag; Type: TABLE; Schema: vertragsverwaltung; Owner: root
--

CREATE TABLE vertragsverwaltung.vertrag (
    id bigint NOT NULL,
    startdatum date,
    enddatum date,
    projekt bigint
);


ALTER TABLE vertragsverwaltung.vertrag OWNER TO root;

--
-- Name: mitarbeiter_monat; Type: TABLE; Schema: zeiterfassung; Owner: root
--

CREATE TABLE zeiterfassung.mitarbeiter_monat (
    id bigint NOT NULL,
    monat date,
    mitarbeiter bigint
);


ALTER TABLE zeiterfassung.mitarbeiter_monat OWNER TO root;

--
-- Name: taetigkeit; Type: TABLE; Schema: zeiterfassung; Owner: root
--

CREATE TABLE zeiterfassung.taetigkeit (
    id bigint NOT NULL,
    beginn timestamp without time zone,
    ende timestamp without time zone,
    pause bigint,
    typ character varying,
    projekt bigint,
    mitarbeiter bigint,
    partnervertrag bigint,
    kundenvertrag bigint,
    leistungsnachweis bigint
);


ALTER TABLE zeiterfassung.taetigkeit OWNER TO root;

--
-- Data for Name: dienstleistungsnachweis; Type: TABLE DATA; Schema: leistungsverwaltung; Owner: root
--

COPY leistungsverwaltung.dienstleistungsnachweis (id, personentage, korrektur, leistungszeitraum, geprueft, partnervertrag, kundenvertrag) FROM stdin;
\.


--
-- Data for Name: kunde; Type: TABLE DATA; Schema: projektverwaltung; Owner: root
--

COPY projektverwaltung.kunde (id, beschreibung, firmenname, rechtsform) FROM stdin;
5	Ansprechpartner für Oscorp Industries	Oscorp Industries	AG
7	Ansprechpartner für Stark Industries	Stark Industries	AG
1	Ansprechpartner für ACME Inc.	ACME Inc.	GmbH
4	Ansprechpartner für Cyberdyne Systems	Cyberdyne Systems	GmbH
2	Ansprechpartner für Globex Corporation	Globex Corporation	AG
10	Ansprechpartner für Aperture Science	Aperture Science	GmbH
8	Ansprechpartner für Umbrella Corporation	Umbrella Corporation	GmbH
9	Ansprechpartner für Weyland-Yutani Corporation	Weyland-Yutani Corporation	AG
3	Ansprechpartner für Initech GmbH	Initech GmbH	GmbH
6	Ansprechpartner für Wayne Enterprises	Wayne Enterprises	GmbH
11	Ansprechpartner für Benthos Oil	Benthos Oil	AG
13	Ansprechpartner für Tyrell Corporation	Tyrell Corporation	GmbH
12	Ansprechpartner für Gringotts Wizarding Bank	Gringotts Wizarding Bank	GmbH
14	Ansprechpartner für Virtucon Industries	Virtucon Industries	AG
15	Ansprechpartner für Weygandt Industries	Weygandt Industries	GmbH
16	Ansprechpartner für Abstergo Industries	Abstergo Industries	AG
\.


--
-- Data for Name: projekt; Type: TABLE DATA; Schema: projektverwaltung; Owner: root
--

COPY projektverwaltung.projekt (id, projekt_kuerzel, beschreibung, startdatum, enddatum, kunden_id) FROM stdin;
1	CLMF	Neue Website	2022-01-01	2022-06-30	1
2	KRUK	ERP-System	2022-02-15	2023-02-14	2
3	CLMA	App-Entwicklung	2022-03-01	2022-09-30	3
4	DISA	Marketing-Kampagne	2022-04-01	2022-07-31	4
5	RUFU	E-Commerce-Plattform	2022-05-01	2023-04-30	5
6	ESOM	CRM-System	2022-06-01	2022-12-31	6
7	ARAG	IT-Infrastruktur	2022-07-01	2023-06-30	7
8	SETU	Software-Integration	2022-08-01	2023-03-31	8
9	ZEMC	Data-Warehouse	2022-09-01	2023-08-31	9
10	LASV	E-Learning-Plattform	2022-10-01	2023-09-30	10
11	RASV	IT-Sicherheitsaudit	2022-11-01	2022-12-31	11
12	ROMB	ERP-Optimierung	2022-12-01	2023-11-30	12
13	XEXO	Social-Media-Kampagne	2023-01-01	2023-02-28	13
14	BMIN	Mobile-App-Design	2023-02-01	2023-09-30	14
15	IWAX	Cloud-Migration	2023-03-01	2023-06-30	15
16	YAPI	ERP-Integration	2023-04-01	2023-11-30	16
\.


--
-- Data for Name: kunde; Type: TABLE DATA; Schema: stammdaten; Owner: root
--

COPY stammdaten.kunde (id, firmenname, rechtsform) FROM stdin;
1	ACME Inc.	GmbH
2	Globex Corporation	AG
3	Initech GmbH	GmbH
4	Cyberdyne Systems	GmbH
5	Oscorp Industries	AG
6	Wayne Enterprises	GmbH
7	Stark Industries	AG
8	Umbrella Corporation	GmbH
9	Weyland-Yutani Corporation	AG
10	Aperture Science	GmbH
11	Benthos Oil	AG
12	Gringotts Wizarding Bank	GmbH
13	Tyrell Corporation	GmbH
14	Virtucon Industries	AG
15	Weygandt Industries	GmbH
16	Abstergo Industries	AG
\.


--
-- Data for Name: mitarbeiter; Type: TABLE DATA; Schema: stammdaten; Owner: root
--

COPY stammdaten.mitarbeiter (id, vorname, nachname, kuerzel, rolle, ausgeschieden) FROM stdin;
17	Max	Mustermann	MUMU	Entwickler	f
18	Anna	Schmidt	ASCH	Entwickler	f
19	Lena	Müller	LMUE	Entwickler	f
20	Simon	Klein	SKLE	Führungskraft	f
21	Laura	Schneider	LSCH	Führungskraft	f
22	Johannes	Koch	JKOC	Consultant	f
23	Jan	Schulz	JSCH	Consultant	f
24	Paul	Hofmann	PHOF	IT-Support	f
25	Sabrina	Meyer	SMEY	IT-Support	f
26	Oliver	Fuchs	OFUC	Entwickler	f
27	Hannah	Baum	HBUM	Entwickler	f
28	Moritz	Huber	MHUB	Führungskraft	f
29	Sarah	Gärtner	SGAE	Consultant	f
30	Sebastian	Kramer	SKRA	Consultant	f
31	Lisa	Bauer	LBAU	IT-Support	f
32	Hans	Müller	HMUE	Fachabteilung	f
33	Laura	Schmidt	LSCH	Fachabteilung	f
34	Markus	Bauer	MBAU	Fachabteilung	f
35	Sabine	Koch	SKOC	Human Resources	f
36	Daniel	Klein	DKLE	Human Resources	f
37	Anna	Fischer	AFIS	Human Resources	f
38	Peter	Hoffmann	PHOF	Rechnungswesen	f
39	Tanja	Meyer	TMEY	Rechnungswesen	f
40	David	Wagner	DWAG	Rechnungswesen	f
\.


--
-- Data for Name: person; Type: TABLE DATA; Schema: stammdaten; Owner: root
--

COPY stammdaten.person (id, email, rechnungsadresse, beschreibung, iban) FROM stdin;
1	max.mustermann@example.com	Unter den Linden 12, 10117 Berlin	Ansprechpartner für ACME Inc.	DE12 3456 7890 1234 5678 90
2	anna.mueller@globex.com	Kurfürstendamm 123, 10709 Berlin	Ansprechpartner für Globex Corporation	DE98 7654 3210 9876 5432 10
3	peter.schmidt@initech.de	Am Sandtorkai 64, 20457 Hamburg	Ansprechpartner für Initech GmbH	DE34 5678 9012 3456 7890 12
4	sarah.mueller@cyberdyne.de	Zirkusweg 2, 20359 Hamburg	Ansprechpartner für Cyberdyne Systems	DE56 7890 1234 5678 9012 34
5	johannes.maier@oscorp.com	Königstraße 3, 70173 Stuttgart	Ansprechpartner für Oscorp Industries	DE90 1234 5678 9012 3456 78
6	melanie.klein@wayne.de	Grabenstraße 5, 40213 Düsseldorf	Ansprechpartner für Wayne Enterprises	DE12 3456 7890 1234 5678 90
7	paul.schneider@stark.com	Hanauer Landstraße 291-293, 60314 Frankfurt am Main	Ansprechpartner für Stark Industries	DE98 7654 3210 9876 5432 10
8	hans.mueller@umbrella.de	Am Sandtorkai 38, 20457 Hamburg	Ansprechpartner für Umbrella Corporation	DE34 5678 9012 3456 7890 12
9	eva.wagner@weyland-yutani.com	An der Alster 85, 20099 Hamburg	Ansprechpartner für Weyland-Yutani Corporation	DE56 7890 1234 5678 9012 34
10	frank.stein@aperture.de	Königstraße 26, 70173 Stuttgart	Ansprechpartner für Aperture Science	DE90 1234 5678 9012 3456 78
11	lisa.mueller@benthos-oil.com	Am Zirkus 2, 10117 Berlin	Ansprechpartner für Benthos Oil	DE12 3456 7890 1234 5678 90
12	max.mustermann@gringotts.com	Bahnhofstraße 32, 60329 Frankfurt am Main	Ansprechpartner für Gringotts Wizarding Bank	DE98 7654 3210 9876 5432 10
13	julia.meyer@tyrell.de	Marienplatz 8, 80331 München	Ansprechpartner für Tyrell Corporation	DE34 5678 9012 3456 7890 12
14	max.mustermann@virtucon.com	Königstraße 56, 70173 Stuttgart	Ansprechpartner für Virtucon Industries	DE12 3456 7890 1234 5678 90
15	peter.parker@weygandt.de	Kaiserswerther Straße 135, 40474 Düsseldorf	Ansprechpartner für Weygandt Industries	DE23 4567 8901 2345 6789 01
16	desmond.miles@abstergo.com	Berliner Allee 65, 40212 Düsseldorf	Ansprechpartner für Abstergo Industries	DE34 5678 9012 3456 7890 12
17	max.mustermann@example.com	Unter den Linden 12, 10117 Berlin	Softwareentwickler, spezialisiert auf Web-Technologien	DE89100000001234567890
18	julia.mayer@example.com	Kurfürstendamm 123, 10709 Berlin	Softwarearchitekt mit langjähriger Erfahrung in der Finanzbranche	DE89100000004321098765
19	alexander.mueller@example.com	Am Sandtorkai 64, 20457 Hamburg	IT-Projektmanager mit Expertise in agilen Methoden	DE89100000005432187654
20	sandra.schmidt@example.com	Zirkusweg 2, 20359 Hamburg	Consultant für digitale Transformation in der Automobilbranche	DE89100000006543276543
21	lukas.schulz@example.com	Königstraße 3, 70173 Stuttgart	Softwareentwickler mit Schwerpunkt auf Datenbanktechnologien	DE89100000007654365432
22	marie.klein@example.com	Grabenstraße 5, 40213 Düsseldorf	UX-Designerin mit Erfahrung in der Entwicklung von mobilen Anwendungen	DE89100000008765454321
23	felix.becker@example.com	Hanauer Landstraße 291-293, 60314 Frankfurt am Main	IT-Sicherheitsexperte mit fundiertem Wissen in der Cloud-Technologie	DE89100000009876543210
24	hannah.wagner@example.com	Am Sandtorkai 38, 20457 Hamburg	Junior-Entwicklerin für Web-Anwendungen mit Schwerpunkt auf ReactJS	DE89100000000123456789
25	leon.fischer@example.com	An der Alster 85, 20099 Hamburg	Entwickler für mobile Anwendungen mit Expertise in der Nutzung von NLP	DE89100000000234567890
26	anja.weber@example.com	Königstraße 26, 70173 Stuttgart	Beraterin für digitale Transformation in der Industriebranche	DE89100000000345678901
27	jan.meier@example.com	Am Zirkus 2, 10117 Berlin	Softwareentwickler mit Erfahrung in der Anwendung von Machine Learning	DE89100000000456789012
28	katharina.huber@example.com	Bahnhofstraße 32, 60329 Frankfurt am Main	IT-Consultant für Finanzdienstleister mit Schwerpunkt auf Blockchain	DE89100000000567890123
29	svenja.meyer@example.com	Marienplatz 8, 80331 München	IT-Projektmanagerin für agile Softwareentwicklung mit Scrum Master-Zertifizierung	DE89100000000678901234
30	philipp.grimm@example.com	Königstraße 56, 70173 Stuttgart	Softwarearchitekt mit fundierten Kenntnissen in Java und Python	DE12500105170648489890
31	lisa.hoffmann@acme.com	Unter den Linden 12, 10117 Berlin	Ansprechpartnerin für Kunden aus der Automobilbranche	DE12345678901234567890
32	max.mustermann@globex.com	Kurfürstendamm 123, 10709 Berlin	Ansprechpartner für Kunden aus der Energiebranche	DE09876543210987654321
33	martina.mueller@initech.de	Am Sandtorkai 64, 20457 Hamburg	Projektmanagerin für IT-Infrastrukturprojekte	DE13579086420135790864
34	peter.parker@cyberdyne.de	Zirkusweg 2, 20359 Hamburg	Entwickler für Robotiksoftware	DE45678901234567890123
35	gwen.stacy@oscorp.com	Königstraße 3, 70173 Stuttgart	Leiterin Forschung & Entwicklung für Pharmazeutika	DE98765432109876543210
36	bruce.wayne@wayne.de	Grabenstraße 5, 40213 Düsseldorf	Geschäftsführer für Maschinenbau und Automatisierungstechnik	DE01234567890123456789
37	tony.stark@stark.com	Hanauer Landstraße 291-293, 60314 Frankfurt am Main	CEO für Elektronik und Robotik	DE54321098765432109876
38	claire.redfield@umbrella.de	Am Sandtorkai 38, 20457 Hamburg	Leiterin Qualitätsmanagement für Pharmazeutika	DE32109876543210987654
39	ellen.ripley@weyland-yutani.com	An der Alster 85, 20099 Hamburg	Astronautin und Sicherheitsbeauftragte für Weltraummissionen	DE67890123456789012345
40	chell@aperture.de	Königstraße 26, 70173 Stuttgart	Testsubjekt für Testkammern	DE89012345678901234567
\.


--
-- Data for Name: kunde; Type: TABLE DATA; Schema: vertragsverwaltung; Owner: root
--

COPY vertragsverwaltung.kunde (id, beschreibung, firmenname, rechtsform) FROM stdin;
\.


--
-- Data for Name: kundenvertrag; Type: TABLE DATA; Schema: vertragsverwaltung; Owner: root
--

COPY vertragsverwaltung.kundenvertrag (id, leistungssatz, kunde) FROM stdin;
1	1.25	1
2	2.00	2
3	1.50	3
4	2.75	4
5	1.10	5
6	3.00	6
7	1.80	7
8	2.30	8
9	4.50	9
10	1.75	10
11	2.55	11
12	1.30	12
13	2.10	13
14	3.50	14
15	1.90	15
16	5.00	16
\.


--
-- Data for Name: mitarbeiter; Type: TABLE DATA; Schema: vertragsverwaltung; Owner: root
--

COPY vertragsverwaltung.mitarbeiter (id, vorname, nachname, kuerzel, rolle, ausgeschieden) FROM stdin;
17	Max	Mustermann	MUMU	Entwickler	f
18	Anna	Schmidt	ASCH	Entwickler	f
19	Lena	Müller	LMUE	Entwickler	f
20	Simon	Klein	SKLE	Führungskraft	f
21	Laura	Schneider	LSCH	Führungskraft	f
22	Johannes	Koch	JKOC	Consultant	f
23	Jan	Schulz	JSCH	Consultant	f
24	Paul	Hofmann	PHOF	IT-Support	f
25	Sabrina	Meyer	SMEY	IT-Support	f
26	Oliver	Fuchs	OFUC	Entwickler	f
27	Hannah	Baum	HBUM	Entwickler	f
28	Moritz	Huber	MHUB	Führungskraft	f
29	Sarah	Gärtner	SGAE	Consultant	f
30	Sebastian	Kramer	SKRA	Consultant	f
31	Lisa	Bauer	LBAU	IT-Support	f
32	Hans	Müller	HMUE	Fachabteilung	f
33	Laura	Schmidt	LSCH	Fachabteilung	f
34	Markus	Bauer	MBAU	Fachabteilung	f
35	Sabine	Koch	SKOC	Human Resources	f
36	Daniel	Klein	DKLE	Human Resources	f
37	Anna	Fischer	AFIS	Human Resources	f
38	Peter	Hoffmann	PHOF	Rechnungswesen	f
39	Tanja	Meyer	TMEY	Rechnungswesen	f
40	David	Wagner	DWAG	Rechnungswesen	f
\.


--
-- Data for Name: partnervertrag; Type: TABLE DATA; Schema: vertragsverwaltung; Owner: root
--

COPY vertragsverwaltung.partnervertrag (id, tagessatz, mitarbeiter) FROM stdin;
21	500.00	17
22	1000.00	18
23	750.00	19
24	200.00	20
25	450.00	21
26	650.00	22
27	550.00	23
28	800.00	24
29	300.00	25
30	900.00	26
31	1000.00	17
32	350.00	18
33	550.00	19
34	1200.00	20
35	250.00	21
36	800.00	22
37	950.00	23
38	700.00	24
39	1000.00	25
40	1300.00	26
\.


--
-- Data for Name: vertrag; Type: TABLE DATA; Schema: vertragsverwaltung; Owner: root
--

COPY vertragsverwaltung.vertrag (id, startdatum, enddatum, projekt) FROM stdin;
1	2022-01-01	2022-12-31	1
2	2022-02-01	2022-12-31	2
3	2022-03-01	2022-12-31	3
4	2022-04-01	2022-12-31	4
5	2022-05-01	2022-12-31	5
6	2022-06-01	2022-12-31	6
7	2022-07-01	2022-12-31	7
8	2022-08-01	2022-12-31	8
9	2022-09-01	2022-12-31	9
10	2022-10-01	2022-12-31	10
11	2022-11-01	2022-12-31	11
12	2022-12-01	2022-12-31	12
13	2023-01-01	2023-12-31	13
14	2023-02-01	2023-12-31	14
15	2023-03-01	2023-12-31	15
16	2023-04-01	2023-12-31	16
21	2022-01-01	2022-06-30	11
22	2022-01-01	2022-12-31	7
23	2022-03-01	2022-12-31	14
24	2022-04-01	2022-09-30	2
25	2022-05-01	2022-10-31	4
26	2022-06-01	2022-11-30	9
27	2022-07-01	2022-12-31	6
28	2022-08-01	2022-10-31	16
29	2022-09-01	2022-12-31	3
30	2022-10-01	2022-12-31	12
31	2022-06-01	2023-05-31	11
32	2021-10-01	2022-09-30	13
33	2021-11-01	2022-10-31	6
34	2022-01-01	2022-12-31	15
35	2022-03-01	2023-02-28	5
36	2022-04-01	2023-03-31	10
37	2022-05-01	2023-04-30	12
38	2022-07-01	2023-06-30	8
39	2022-08-01	2023-07-31	7
40	2022-09-01	2023-08-31	16
\.


--
-- Data for Name: mitarbeiter_monat; Type: TABLE DATA; Schema: zeiterfassung; Owner: root
--

COPY zeiterfassung.mitarbeiter_monat (id, monat, mitarbeiter) FROM stdin;
1	2022-01-01	17
2	2022-02-01	18
3	2022-03-01	19
4	2022-04-01	20
5	2022-05-01	21
6	2022-06-01	22
7	2022-07-01	23
8	2022-08-01	24
9	2022-09-01	25
10	2022-10-01	26
11	2022-11-01	27
12	2022-12-01	28
13	2022-01-01	29
14	2022-02-01	30
15	2022-03-01	17
16	2022-04-01	18
17	2022-05-01	19
18	2022-06-01	20
19	2022-07-01	21
20	2022-08-01	22
21	2022-09-01	23
22	2022-10-01	24
23	2022-11-01	25
24	2022-12-01	26
25	2022-01-01	27
26	2022-02-01	28
27	2022-03-01	29
28	2022-04-01	30
29	2022-05-01	17
30	2022-06-01	18
\.


--
-- Data for Name: taetigkeit; Type: TABLE DATA; Schema: zeiterfassung; Owner: root
--

COPY zeiterfassung.taetigkeit (id, beginn, ende, pause, typ, projekt, mitarbeiter, partnervertrag, kundenvertrag, leistungsnachweis) FROM stdin;
1	2022-01-01 09:00:00	2022-01-01 17:00:00	60	Besprechung	1	17	21	1	5
2	2022-01-02 08:00:00	2022-01-02 16:00:00	30	Entwicklung	2	18	22	2	7
3	2022-01-03 10:00:00	2022-01-03 16:00:00	60	Beratung	3	19	23	3	11
4	2022-01-04 08:30:00	2022-01-04 17:00:00	45	Support	4	20	24	4	1
5	2022-01-05 09:00:00	2022-01-05 16:30:00	60	Projektmanagement	5	21	25	5	14
6	2022-01-06 08:00:00	2022-01-06 12:00:00	0	Entwicklung	6	22	26	6	3
7	2022-01-07 10:00:00	2022-01-07 16:00:00	60	Beratung	7	23	27	7	10
8	2022-01-08 09:00:00	2022-01-08 13:00:00	15	Entwicklung	8	24	28	8	17
9	2022-01-09 10:00:00	2022-01-09 18:00:00	45	Support	9	25	29	9	8
10	2022-01-10 08:00:00	2022-01-10 12:30:00	0	Entwicklung	10	26	30	10	2
11	2022-01-11 09:30:00	2022-01-11 17:30:00	60	Projektmanagement	11	27	31	11	13
12	2022-01-12 08:00:00	2022-01-12 16:00:00	30	Entwicklung	12	28	32	12	16
13	2022-01-13 09:00:00	2022-01-13 14:00:00	30	Support	13	29	33	13	9
14	2022-02-15 08:00:00	2022-02-15 17:00:00	60	Meeting	5	17	24	13	3
15	2022-02-16 09:00:00	2022-02-16 12:00:00	15	Recherche	1	18	27	2	7
16	2022-02-17 10:00:00	2022-02-17 14:00:00	30	Testing	6	19	25	14	6
17	2022-02-18 11:00:00	2022-02-18 16:00:00	45	Entwicklung	4	20	26	10	5
18	2022-02-19 13:00:00	2022-02-19 17:00:00	0	Recherche	3	21	29	6	19
19	2022-02-20 10:00:00	2022-02-20 15:00:00	30	Testing	2	22	30	1	14
20	2022-02-21 08:00:00	2022-02-21 16:00:00	60	Entwicklung	7	23	38	8	13
21	2022-02-22 08:00:00	2022-02-22 12:00:00	15	Recherche	10	24	21	5	18
22	2022-02-23 09:00:00	2022-02-23 14:00:00	30	Testing	11	25	28	3	11
23	2022-02-24 10:00:00	2022-02-24 14:00:00	45	Entwicklung	12	26	22	9	1
24	2022-02-25 11:00:00	2022-02-25 16:00:00	0	Recherche	15	27	35	7	15
25	2022-02-26 13:00:00	2022-02-26 17:00:00	30	Testing	16	28	37	2	8
26	2022-02-27 10:00:00	2022-02-27 15:00:00	60	Entwicklung	14	29	39	12	2
\.


--
-- Name: dienstleistungsnachweis dienstleistungsnachweis_pkey; Type: CONSTRAINT; Schema: leistungsverwaltung; Owner: root
--

ALTER TABLE ONLY leistungsverwaltung.dienstleistungsnachweis
    ADD CONSTRAINT dienstleistungsnachweis_pkey PRIMARY KEY (id);


--
-- Name: kunde kunde_primary; Type: CONSTRAINT; Schema: projektverwaltung; Owner: root
--

ALTER TABLE ONLY projektverwaltung.kunde
    ADD CONSTRAINT kunde_primary PRIMARY KEY (id);


--
-- Name: projekt projekt_pkey; Type: CONSTRAINT; Schema: projektverwaltung; Owner: root
--

ALTER TABLE ONLY projektverwaltung.projekt
    ADD CONSTRAINT projekt_pkey PRIMARY KEY (id);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: stammdaten; Owner: root
--

ALTER TABLE ONLY stammdaten.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: kunde kunde_primary; Type: CONSTRAINT; Schema: vertragsverwaltung; Owner: root
--

ALTER TABLE ONLY vertragsverwaltung.kunde
    ADD CONSTRAINT kunde_primary PRIMARY KEY (id);


--
-- Name: mitarbeiter mitarbeiter_primary; Type: CONSTRAINT; Schema: vertragsverwaltung; Owner: root
--

ALTER TABLE ONLY vertragsverwaltung.mitarbeiter
    ADD CONSTRAINT mitarbeiter_primary PRIMARY KEY (id);


--
-- Name: vertrag vertrag_pkey; Type: CONSTRAINT; Schema: vertragsverwaltung; Owner: root
--

ALTER TABLE ONLY vertragsverwaltung.vertrag
    ADD CONSTRAINT vertrag_pkey PRIMARY KEY (id);


--
-- Name: mitarbeiter_monat mitarbeiter_monat_pkey; Type: CONSTRAINT; Schema: zeiterfassung; Owner: root
--

ALTER TABLE ONLY zeiterfassung.mitarbeiter_monat
    ADD CONSTRAINT mitarbeiter_monat_pkey PRIMARY KEY (id);


--
-- Name: taetigkeit taetigkeit_pkey; Type: CONSTRAINT; Schema: zeiterfassung; Owner: root
--

ALTER TABLE ONLY zeiterfassung.taetigkeit
    ADD CONSTRAINT taetigkeit_pkey PRIMARY KEY (id);


--
-- Name: kunde kunde_person_fk; Type: FK CONSTRAINT; Schema: stammdaten; Owner: root
--

ALTER TABLE ONLY stammdaten.kunde
    ADD CONSTRAINT kunde_person_fk FOREIGN KEY (id) REFERENCES stammdaten.person(id);


--
-- Name: mitarbeiter mitarbeiter_person_fk; Type: FK CONSTRAINT; Schema: stammdaten; Owner: root
--

ALTER TABLE ONLY stammdaten.mitarbeiter
    ADD CONSTRAINT mitarbeiter_person_fk FOREIGN KEY (id) REFERENCES stammdaten.person(id);


--
-- Name: kundenvertrag kundenvertrag_vertrag_fk; Type: FK CONSTRAINT; Schema: vertragsverwaltung; Owner: root
--

ALTER TABLE ONLY vertragsverwaltung.kundenvertrag
    ADD CONSTRAINT kundenvertrag_vertrag_fk FOREIGN KEY (id) REFERENCES vertragsverwaltung.vertrag(id);


--
-- Name: partnervertrag partnervertrag_vertrag_fk; Type: FK CONSTRAINT; Schema: vertragsverwaltung; Owner: root
--

ALTER TABLE ONLY vertragsverwaltung.partnervertrag
    ADD CONSTRAINT partnervertrag_vertrag_fk FOREIGN KEY (id) REFERENCES vertragsverwaltung.vertrag(id);


--
-- PostgreSQL database dump complete
--

