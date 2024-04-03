# Typinx – mäng, kus peab kiirkirjutama sõnu, et pinksis vastane võita

# Kirjeldus
Autorid: Markus Viks, Tristan Laur

Projekti eesmärk on luua mäng, kus kasutaja peab kirjutama õigesti suvaliselt valitud sõna. Projekti esimeses järgus valmis programm, mis valib etteantud veebilehel olevast
failist suvalise sõna ja viskab mängijale, ette võimalikult kiireks kirjutamiseks. Pärast sõna kirjutamist annab programm mängijale tagasisidet kirjutamiskiiruse kohta ja annab ette uue
sõna, kuni mängija kirjutab 'stop' (ei saa panna 'stopp', sest see sõna on failis olemas), mis lõpetab programmi töö. Teises järgus on plaan tekitada mängule graafiline liides, kus saab võistelda lautennise matši stiilis ja mängu võita kiiresti kirjutades.

# Programmi töö üldine selgitus:

Programm laeb suvalise sõna etteantud veebilehel leiduvast failist.
Kasutajale kuvatakse valitud sõna.
Kasutaja peab võimalikult kiiresti sisestama oodatava sõna.
Kui kasutaja sisestab õigesti, kuvatakse kulunud aeg. Kui mitte, läheb mäng praegu edasi. Järgmises etapis kaotab mängija valesti kirjutatud sõna eest punkti.


# Klassid ja olulisemad meetodid:
- Main:

Eesmärk: Programmi käivitamine ja kasutajaliides.

Olulisemad meetodid: main(), valisuvasona()

- sonanetist:
    Veebilehelt suvalise sõna laadimine.
  
- valisuvasona()
    Loeb failist sissse kõik sõnad ja genereerib juhuarvu, et listist suvaline sõna tagastada.


# Protsess:

Etapp 1.1 otsustati typer stiilis mängu kasuks ja leiti, et graafiline pool võiks olla lauatenniseteemaline.
Etapp 1.2 kirjutati valmis algne programm, mis oli suuteline valima suvalise sõna ja käskima selle mängijal kirjutada, kiirust samal ajal mõõtes.
Etapp 1.3 testiti programmi ja lisati mõningad funktsionaalsused (nt while loop ja mängu lõpetamine), et see rühmatöö nr 2 käigus valmivasse programmi võimalikult hästi implementeeruks.

Etapp 2.1 luuakse 2D graafiline liides, et mäng konsoolist välja viia ja mängija jaoks huvitavamaks teha.


# Rühmaliikmete panus:
Idee väljatöötamine ja algse tegevuskava plaanimine ~1.5 tundi.

Markus Viks:
Projekti kirjelduse kirjutamine ja viimistlemine ~1 tund.
Lisafunktsionaalsuste programmeerimine ja katsetamine ~30 min.
Testimine ~45 minutit.

Tristan Laur:
Algse programmi kirjutamine ~3 tundi.
Githubi repo loomine.

# Probleemid
Kohati ei toiminud jsoup'i integratsioon.
Keeruliseks osutub tõenäoliselt graafilise poole valmistamine. Esimese etapi jaoks vajalikud oskused on praeguseks juba kursusel läbitud.


# Hinnang tulemusele:
Programm toimib ja on valmis "saama päris mänguks". Funksionaalsused toimivad ja pole "mul töötab, aga sul mitte" probleemi.

# Testimine:
Programmi testiti pärast algprogrammi valmimist ning ka pärast, kui oli tehtud muudatusi.

