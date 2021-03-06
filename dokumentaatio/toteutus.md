# Toteutusdokumentti

## Yleisrakenne


#### Luokkayhteenveto
* Legosovellus: Main-luokka sovelluksen käynnistämiseen.
* logiikka.Ohjain: Wräpperi DifferentialPilotille joka ohjaa robottia liikuttavia pyöriä
* logiikka.Tekoaly: Pääluokka joka vastaa robotin toiminnasta ja logiikasta.
* logiikka.Tutka: Abstraktio robotin ultraäänisensorille ja sitä pyörittävälle moottorille.
* ui.TekstiUI: Tekstipohjainen valikko nxt-tiilelle jolla voi muuttaa asetuksia ja laittaa robotin liikkeelle.
* util.Taulukot: Kirjasto taulukkojen käsittelyyn.
* util.LogWriter: Tiilen muistille kirjoittava luokka. Tällä hetkellä testausta varten. 


## Ohjelmointiympäristö
Ohjelma on tehty [rojbos](http://robotuprising.fi/rojbos/) Linuxjakelulla. Se sisältää Eclipse IDEn lejos-pluginilla joka automatisoi projektin kääntämistä. [Lejos](www.lejos.org) on jälkiasennettava firmware Lego Mindstorms roboteille. Huomaa että lejos-version jolla projekti käännetään __täytyy__ olla sama kuin robotin firmware. 

## Puutteet ja parannukset
#### Puutteet
* Ohjaus ei ole täysin tarkka.
* Parempi dokumentaatio.
#### Parannukset
* Ohjaus voisi toimia siten että sensori kuvaa viivan robotin edestä ja laskee kääntymisasteen lähestymiskulman mukaan. Tämä korjaisi kanssa ohjausvirheitä.
* Jonkinlainen tieto robotin omasta sijainnista ja ympäristön kartoitus.
* Rakenteellinen muutos jossa robotti on kompaktimpi ja sensori/moottori-yhdistelmä ei sojota niin paljon ulos muusta robotista.

## Media
Soon:tm:
