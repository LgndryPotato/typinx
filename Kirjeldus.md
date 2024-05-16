# Typinx – mäng, kus peab kiirkirjutama sõnu, et pinksis vastane võita

# Kirjeldus
Autorid: Markus Viks, Tristan Laur

Projekti eesmärk on luua mäng, kus kasutaja peab kirjutama õigesti suvaliselt valitud sõna. Projekti esimeses järgus valmis programm, mis valib etteantud veebilehel olevast
failist suvalise sõna ja viskab mängijale ette võimalikult kiireks kirjutamiseks. Pärast sõna kirjutamist annab programm mängijale tagasisidet kirjutamiskiiruse kohta ja annab ette uue
sõna, kuni mängija kirjutab 'stop' (ei saa panna 'stopp', sest see sõna on failis olemas), mis lõpetab programmi töö. Teises järgus on plaan tekitada mängule graafiline liides, kus saab võistelda lautennise matši stiilis ja mängu võita kiiresti kirjutades.

# Programmi töö üldine selgitus

Programm laeb suvalise sõna etteantud veebilehel leiduvast failist.
Kasutajale kuvatakse valitud sõna.
Kasutaja peab võimalikult kiiresti sisestama oodatava sõna.
Kui kasutaja sisestab õigesti, kuvatakse kulunud aeg. Kui mitte, läheb mäng praegu edasi. Järgmises etapis kaotab mängija valesti kirjutatud sõna eest punkti.



# Programmi käivitamine IntelliJ's
- Alla tuleb laadida ja projekti paigutada kõik .java failid peale Main.java (see on esimene versioon).
- Jsoup library lisamine
  1. Projekt peab olema JavaFX tüüpi
  2. Laadige repos olev .jar fail IntelliJ projekti juurkausta.
  3. Paremklõpsake .jar failil vasakpoolse failibrauseri aknas IntelliJ's
  4. Valige "Add as library"
  5. build.gradle faili tuleb Dependencies alla lisada implementation 'org.jsoup:jsoup:1.17.2'
  6. Java 22 viskab igasuguseid erroreid, seega palume kasutada java 21.

  

# Klassid ja meetodid
1. main(String[] args): Käivitab JavaFX rakenduse.
2. muudaBackgroundi(String path): Muudab taustapildi vastavalt antud failiteele.
3. start(Stage primaryStage): Algatab rakenduse stseeni ja kasutajaliidese loomise.
4. statsLabel(): Tagastab statistika silti, mis näitab mängu statistikat.
5. uuendaStatse(): Värskendab mängu statistikat ja kuvab selle kasutajaliideses.
6. startGame(): Algatab mängu, salvestades algusaja.
7. kontrolli(): Kontrollib kasutaja sisestatud sõna õigsust ja mängu olekut.
8. sonaEkraanile(String sona): Kuvab antud sõna kasutajaliideses.
9. stop(): Salvestab mängu tulemused tekstifaili enne rakenduse sulgemist.


# Protsess

Etapp 1.1 otsustati typer stiilis mängu kasuks ja leiti, et graafiline pool võiks olla lauatenniseteemaline.<br />
<br />
Etapp 1.2 kirjutati valmis algne programm, mis oli suuteline valima suvalise sõna ja käskima selle mängijal kirjutada, kiirust samal ajal mõõtes.<br />
<br />
Etapp 1.3 testiti programmi ja lisati mõningad funktsionaalsused (nt while loop ja mängu lõpetamine), et see rühmatöö nr 2 käigus valmivasse programmi võimalikult hästi implementeeruks.<br />
<br />

Etapp 2.1 loodi 2D graafiline liides, et mäng konsoolist välja viia ja mängija jaoks huvitavamaks teha.<br />
Etapp 2.2 joonistati vajalikud pildid.<br />
Etapp 2.3 prorammeeriti lõplik mäng<br />


# Rühmaliikmete panus
Idee väljatöötamine ja algse tegevuskava plaanimine ~1.5 tundi.

- Markus Viks:<br />
Projekti kirjelduse kirjutamine ja viimistlemine ~1.5 tundi.<br />
Lisafunktsionaalsuste programmeerimine ja katsetamine ~30 min.<br />
Testimine ~45 minutit.<br />
Teise etapi programmeerimine ~7 tundi.

- Tristan Laur:<br />
Algse programmi kirjutamine ~3 tundi.<br />
Githubi repo loomine.<br />
Joonised ~2.5 tundi.<br />
Teise etapi programmeerimine ~6 tundi.

# Probleemid
Kohati ei toiminud jsoup'i integratsioon.
Keeruliseks osutub tõenäoliselt graafilise poole valmistamine. Esimese etapi jaoks vajalikud oskused on praeguseks juba kursusel läbitud.
Väga keeruline oli projekti faile õigesse kausta paigutada ja omavahel jagada.


# Hinnang tulemusele
Programm toimib ja on valmis "saama päris mänguks". Funksionaalsused toimivad ja pole "mul töötab, aga sul mitte" probleemi.

Mäng on valmis ja toimib.

# Testimine
Programmi testiti läbi mängides pärast valmimist ja muudatusi.

