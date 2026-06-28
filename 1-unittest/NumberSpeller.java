package application;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NumberSpeller {
    /**
     * Define our languages using a LinkedHashMap to preserve order
     */
	LinkedHashMap<String, String[]> translations = new LinkedHashMap<String, String[]>() {{
	    put("english", new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"});
	    put("german", new String[] {"null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun"});
	    put("spanish", new String[] {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"});
	    put("fantasy", new String[] {"tioa", "nsom", "homh", "fof", "ttt", "hbts", "jhkm", "motc", "fyfm", "dwys"});
	}};
	
    /**
     * Returns all available languages
     *
     * @return languages as String array
     */
    String[] getLanguages() {
    	
		return (String[]) translations.keySet().toArray(new String[translations.size()]);
	}
    
    /**
     * Spells each digit in given digit-only-string for requested language
     *
     * @return spelled numbers as string
     */
    String getSpelledNumbers(String language, String numbers) throws IllegalArgumentException {
    	// Check if the requested translation is implemented
    	if (!translations.containsKey(language)) {
    		throw new IllegalArgumentException("No translation exists for the given language");
    	}
    	
    	if (numbers.isEmpty()) {
    		throw new IllegalArgumentException("Input must contain at least one digit from 0-9");
    	}
    	
    	// Check if the input only contains digits
    	if (!numbers.matches("[0-9]+")) {
    		throw new IllegalArgumentException("Input can only contain digits from 0-9");
    	}
    	
    	ArrayList<String> spelledDigits = new ArrayList<String>();
    	
    	for (var i = 0; i < numbers.length(); i++) {
    		int digit = Integer.parseInt(numbers.substring(i,i+1)); // convert the character to an integer
    		spelledDigits.add(translations.get(language)[digit]); // Use the digit as an index to access our translation
    	}
    	
		return String.join(" ", spelledDigits); // Combine the spelled digits into a string with one space as a delimiter
    }
}