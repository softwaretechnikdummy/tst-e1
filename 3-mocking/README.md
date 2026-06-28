# Begründung
Ich habe mich dazu entschieden im bestehenden Projekt (siehe `2-tdd`) die Klasse `Product` zu mocken. Ehrlich gesagt ist der Grund dafür eher an den Ohren herbeigezogen.

Aber man könnte sich ja vorstellen, dass die Klasse komplexer und in der Entwicklung sehr dynamisch wäre und man nur die Methoden `GetName` und `GetPrice` nutzen möchte. Dann könnte man argumentieren, dass man hier mittels Mocking die Basis der Klasse emuliert und so immer aktuell bleibt, ohne ständig anzupassen.

## Anpassung der Code-Base
Natürlich musste ich dann erstmal in der Datei `Product.java` die Methoden `GetName` und `GetPrice` hinzufügen und im restlichen Code den Zugriff auf die Attribute der Klasse in Aufrufe der beiden neuen Methoden umwandeln.
Nach diesem Refactoring konnte ich dann endlich den Test umschreiben und so zwei Mock-Objekte der Klasse `Product` bereitstellen, die dann gewünschten Namen und Preis zurückgeben und für die Tests tauglich sind