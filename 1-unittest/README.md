# NumberSpeller
Dieses Projekt habe ich vor ein paar Semestern für ein anderes Modul entwickelt. Jetzt habe ich JUnit-Tests hinzugefügt.

## Die Tests
In der Funktion `testGetLanguages` prüfe ich, ob alle in der Klasse definierten languages auch wirklich einen validen Key haben.
Außerdem teste ich, ob sie genau 10 Elemente enthalten und somit funktionieren um die Ziffern 0-9 zu repräsentieren.

Die Funktion `testGetSpelledNumbers` prüft, ob bestimmte falsche Inputs korrekt Exceptions werfen.
Dann wird noch eine spezifische Eingabe in der Funktion mit der erwarteten Rückgabe verglichen.

## Anfängliche Probleme
Zuerst schlug der Test fehl, da die Funktion `GetSpelledNumbers` nicht korrekt prüfte, ob das übergebene Parameter `numbers` auch nicht etwa `null` sei.

<img width="451" height="516" alt="grafik" src="https://github.com/user-attachments/assets/b60b8e82-ced2-48a6-9471-eb68ea99f975" />

Mit einem weiteren Commit habe ich das behoben.

## Erfolg
Nach der Anpassung wurden beide Tests bestanden

<img width="450" height="379" alt="grafik" src="https://github.com/user-attachments/assets/ac1d17c4-ca3e-4c29-b132-d54122630155" />
