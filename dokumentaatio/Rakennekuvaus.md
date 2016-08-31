##Rakennekuvaus##

**Peli**
Peli-olio pit�� sis�ll��n kaikki pelin kulkuun tarvittavat muuttujat. Sill� on jakaja, pelaaja, pakka ja p�yt� sek� toiminnalisuuden vuoksi sill� on vertailija, k�dentarkistaja, voitonmaksaja ja tasapelink�sittelij�. Logiikkaluokkien oliot Peli luo konstruktorissaan ja muut tarvittaessa.

*Domainluokat*
N�m� luokat toimivat ainoastaan olioina pelille eik� toiminnallisutta juurikaan ole. Pakka luo itsens� 52 kortista omassa konstruktorissaan. Pelaajan ja jakajan erona on se ett� pelaajalla on attribuuttina panosten m��r� kun taas jakajalla on metodi joka tarkistaa mahtuuko jakajan k�si p�yt��n. Molemmilla on k�si attribuuttina joka on oma enuminsa.
P�t� s�ilytt�� tietoa viidest� kortista jotka ovat jakajan ja pelaajan yhteisi� kortteja.

*Sovellusluokat*
Peli suorittaa ensin itse korttien jakamisen pelaajalle, p�yt��n ja jakajalle, sek� pit�� attribuuttina pelaajan asettaman panoksen m��r��. Jos pelaaja pelaa pelin loppuun asti, luo peli luokka ensin vertailu-olion joka saa kyseisen pelin parametrikseen konstruktoriin. Sen j�lkeen se luo K�denTarkistajan joka saa vertailun parametrikseen. Sen metodi tarkistaKasi saa parametrikseen Osallistujan jolle metodi asettaa k�den.
Jos k�det ovat samanarvoisia Peli-luokka luo tasapelink�sittelij�n joka tarkistaa kumpi voittaja on ja antaa t�st� tiedon pelille. T�m� tehd��n suoraan jos k�det eiv�t ole samanarvoisia. 
Peli luo t�m�n j�lkeen voitonmaksaja-olion joka saa pelin parametrikseen. Voitonmaksaja n�kee pelist� voittajan ja muuttaa siten pelin pelaajan pelimerkkim��r��.
