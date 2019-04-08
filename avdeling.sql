
DROP SCHEMA IF EXISTS avdeling CASCADE;
CREATE SCHEMA avdeling;
SET search_path TO avdeling;
    
CREATE TABLE Avdeling
(
    avdeling-id SERIAL UNIQUE,
    navn VARCHAR(255),


En ansatt må jobbe i en avdeling
2. En avdeling må ha én sjef (som jobber i avdelingen)
Forslag til fremgangsmåte:
 Utvid databasedefinisjonen til nå å inneholde både Ansatt og Avdeling, og sett opp koblingene 
mellom disse. Legg inn eksempeldata for f.eks. 10 ansatte og 3 avdelinger.
Høna-og-egget-tips: Siden en ansatt må jobbe i en avdeling, og en avdeling må ha en sjef,
 er det vanskelig å legge inn data for den ene før den andre. Trikset her er å f.eks. vente 
 med Avdeling sin sjef, og legge dette inn via en UPDATE etter at den ansatte er opprettet. 
 Problemstillingen gjelder også tabelldefinisjonene. Her må man gjøre ALTER TABLE ... ADD CONSTRAINT
 på en av fremmednøklene etter at begge tabeller er opprettet.

  Avdeling
 Unik avdeling-id (automatisk generert løpenummer)
 Navn
 Hvilken ansatt som er sjef
