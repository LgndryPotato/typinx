# Typinx – mäng, kus peab kiirkirjutama sõnu, et pinksis vastane võita

# Kirjeldus
Autorid: Markus Viks, Tristan Laur

Projekti eesmärk on luua mäng, kus kasutaja peab kirjutama õigesti suvaliselt valitud sõna. Projekti esimeses järgus valmis programm, mis valib etteantud veebilehel olevast
failist suvalise sõna ja viskab mängijale, ette võimalikult kiireks kirjutamiseks. Pärast sõna kirjutamist annab programm mängijale tagasisidet kirjutamiskiiruse kohta ja annab ette uue
sõna, kuni mängija kirjutab 'stop' (ei saa panna 'stopp', sest see sõna on failis olemas), mis lõpetab programmi töö. Teises järgus on plaan tekitada mängule graafiline liides, kus saab võistelda lautennise matši stiilis ja mängu võita kiiresti kirjutades.

# Programmi töö üldine selgitus

Programm laeb suvalise sõna etteantud veebilehel leiduvast failist.
Kasutajale kuvatakse valitud sõna.
Kasutaja peab võimalikult kiiresti sisestama oodatava sõna.
Kui kasutaja sisestab õigesti, kuvatakse kulunud aeg. Kui mitte, läheb mäng praegu edasi. Järgmises etapis kaotab mängija valesti kirjutatud sõna eest punkti.

# Programmi käivitamine IntelliJ's
- Jsoup library lisamine
  1. Laadige repos olev .jar fail IntelliJ projekti root kausta.
  2. Paremklõpsake .jar failil vasakpoolse failibrauseri aknas IntelliJ's
  3. Valige "Add as library"
  4. Kui ikka ei toimi: 📧 markus.viks@ut.ee
  

# Klassid ja meetodid
- Klass Main:
  Programmi käivitamine ja kasutajaliides.
- Klass sonanetist:
  Veebilehelt suvalise sõna laadimine.

- Meetod main():
    Käivitab programmi ja on liides mängija ja programmi vahel.
- Meetod valisuvasona():
    Loeb failist sissse kõik sõnad ja genereerib juhuarvu, et listist suvaline sõna tagastada.


# Protsess

Etapp 1.1 otsustati typer stiilis mängu kasuks ja leiti, et graafiline pool võiks olla lauatenniseteemaline.<br />
<br />
Etapp 1.2 kirjutati valmis algne programm, mis oli suuteline valima suvalise sõna ja käskima selle mängijal kirjutada, kiirust samal ajal mõõtes.<br />
<br />
Etapp 1.3 testiti programmi ja lisati mõningad funktsionaalsused (nt while loop ja mängu lõpetamine), et see rühmatöö nr 2 käigus valmivasse programmi võimalikult hästi implementeeruks.<br />
<br />

Etapp 2.1 luuakse 2D graafiline liides, et mäng konsoolist välja viia ja mängija jaoks huvitavamaks teha.<br />


# Rühmaliikmete panus
Idee väljatöötamine ja algse tegevuskava plaanimine ~1.5 tundi.

- Markus Viks:<br />
Projekti kirjelduse kirjutamine ja viimistlemine ~1 tund.<br />
Lisafunktsionaalsuste programmeerimine ja katsetamine ~30 min.<br />
Testimine ~45 minutit.

- Tristan Laur:<br />
Algse programmi kirjutamine ~3 tundi.<br />
Githubi repo loomine.

# Probleemid
Kohati ei toiminud jsoup'i integratsioon.
Keeruliseks osutub tõenäoliselt graafilise poole valmistamine. Esimese etapi jaoks vajalikud oskused on praeguseks juba kursusel läbitud.


# Hinnang tulemusele
Programm toimib ja on valmis "saama päris mänguks". Funksionaalsused toimivad ja pole "mul töötab, aga sul mitte" probleemi.

# Testimine
Programmi testiti läbi mängides pärast algprogrammi valmimist ja pärast muudatusi.

