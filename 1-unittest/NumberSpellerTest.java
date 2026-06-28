package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberSpellerTest {
	NumberSpeller speller;
	@BeforeEach
	void setUp() throws Exception {
		speller = new NumberSpeller();
	}

	@Test
	void testGetLanguages() {
		String[] languages = speller.getLanguages();
		assertNotNull(languages);

		for (String language : languages) {
            assertNotNull(language);
            String[] entries = speller.translations.get(language);

            assertNotNull(entries);
            assertEquals(10, entries.length);

            for (int i = 0; i < entries.length; i++) {
                assertNotNull(entries[i]);
            }
        }
	}

	@Test
	void testGetSpelledNumbers() {
		// check for null as a parameter
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> { speller.getSpelledNumbers(null, "0123456789"); });
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> { speller.getSpelledNumbers("english", null); });
		
		// check for non numbers
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> { speller.getSpelledNumbers("english", "notanumber"); });
		
		// check for non existing language
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> { speller.getSpelledNumbers("nonexistinglanguage", "0123456789"); });

		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> { speller.getSpelledNumbers("nonexistinglanguage", "0123456789"); });
		
		// check example case
		// Hier wollte ich am liebsten auch genau testen, ob in allen Fällen die Methode das richtige Ergebnis liefert
		// Aber das hätte bedeutet, dass ich die Methode quasi ein zweites Mal vollständig implementieren hätte müssen
		// Also mache ich hier stattdessen in vordefinierten Sprachen vordefinierte statische Tests
		Assertions.assertEquals("zero one two three four five six seven eight nine", speller.getSpelledNumbers("english", "0123456789"));
	}

}
