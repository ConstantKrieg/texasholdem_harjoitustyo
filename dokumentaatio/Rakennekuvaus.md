##Rakennekuvaus##

**Peli**
Peli-olio pitää sisällään kaikki pelin kulkuun tarvittavat muuttujat. Sillä on jakaja, pelaaja, pakka ja pöytä sekä toiminnalisuuden vuoksi sillä on vertailija, kädentarkistaja, voitonmaksaja ja tasapelinkäsittelijä. Logiikkaluokkien oliot Peli luo konstruktorissaan ja muut tarvittaessa.

**Domainluokat:**
Nämä luokat toimivat ainoastaan olioina pelille eikä toiminnallisutta juurikaan ole. Pakka luo itsensä 52 kortista omassa konstruktorissaan. Pelaajan ja jakajan erona on se että pelaajalla on attribuuttina panosten määrä kun taas jakajalla on metodi joka tarkistaa mahtuuko jakajan käsi pöytään. Molemmilla on käsi attribuuttina joka on oma enuminsa.
Pötä säilyttää tietoa viidestä kortista jotka ovat jakajan ja pelaajan yhteisiä kortteja.

**Sovellusluokat:**
Peli suorittaa ensin itse korttien jakamisen pelaajalle, pöytään ja jakajalle, sekä pitää attribuuttina pelaajan asettaman panoksen määrää. Jos pelaaja pelaa pelin loppuun asti, luo peli luokka ensin vertailu-olion joka saa kyseisen pelin parametrikseen konstruktoriin. Sen jälkeen se luo KädenTarkistajan joka saa vertailun parametrikseen. Sen metodi tarkistaKasi saa parametrikseen Osallistujan jolle metodi asettaa käden.
Jos kädet ovat samanarvoisia Peli-luokka luo tasapelinkäsittelijän joka tarkistaa kumpi voittaja on ja antaa tästä tiedon pelille. Tämä tehdään suoraan jos kädet eivät ole samanarvoisia. 
Peli luo tämän jälkeen voitonmaksaja-olion joka saa pelin parametrikseen. Voitonmaksaja näkee pelistä voittajan ja muuttaa siten pelin pelaajan pelimerkkimäärää.
