DROP SCHEMA IF EXISTS Oblig3 CASCADE;
CREATE SCHEMA Oblig3;
SET search_path TO Oblig3;
	
	CREATE TABLE Ansatt
	(
		ansattId integer Primary key,
		brukernavn Varchar,
		fornavn Varchar,
		etternavn Varchar,
		stilling varchar,
		annsettelsesdato Date,
		maanedslonn decimal,
		avdeling varchar,
		prosjekter varchar,
		
		
	)