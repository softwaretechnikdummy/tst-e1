# Erste Idee
Als erstes habe ich mir aufgemalt, wie ich mir das Programm vorstelle:
<img width="1700" height="1280" alt="grafik" src="https://github.com/user-attachments/assets/d7cbc0f1-75e9-4ba9-93e0-1c1a313aee38" />

## Grundstruktur
In meinem ersten Commit nach der Erstellung der README.md sehen Sie meine erste Struktur, die bereits eine vollständige UI implementiert.
Die Klassen `Product`, `ShoppingCart` und `ShoppingCartEntry` bilden die logische Struktur.
Es fehlt jetzt lediglich die Implementation der Klasse `ShoppingCartEntry`. Ihre Methoden habe ich mir aber bereits überlegt und diese auch schon in der UI implementiert.
Als nächstes werde ich mir die Tests für die Klasse überlegen und dann wie gewünscht die Features Schritt für Schritt implementieren.

## Tests
Die Tests habe ich mir überlegt, sie sind womöglich nicht vollständig. Während des Schreibens sind mir immer wieder neue Dinge eingefallen.
Aber die Grundanforderungen werden definitiv klar und ich werde jetzt im nächsten Schritt alle Funktionieren so implementieren, dass alle Tests bestanden werden.
Danach werde ich das Programm mittels der UI testen und sehen, wie vollständig meine Tests denn dann wirklich waren!

![alt text](grafik.png)

### AddProduct
Hier war die Implementierung eigentlich straight-forward. Aber dann fiel mir auf, dass ein normales Array für `entries` nicht tauglich war, da ich ja dynamisch Elemente hinzufügen wollte. Also habe ich umgerüstet auf eine `ArrayList` und somit musste ich auch die Tests anpassen, die direkt auf die Variable zugreifen.

Der Test `testAddProduct` glückt nun bereits. Ein Refactoring ist meiner Meinung nach überflüssig.

![alt text](grafik-1.png)