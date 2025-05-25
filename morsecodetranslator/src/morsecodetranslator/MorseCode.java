package morsecodetranslator;
import java.util.*;

public class MorseCode {
	
	public static final HashMap<Character, String> toMorse=new HashMap<>();
	public static final HashMap<String, Character> toEnglish=new HashMap<>();
	
	
	static {
		String[] letters= {
				 "A", "B", "C", "D", "E", "F", "G", "H",
	             "I", "J", "K", "L", "M", "N", "O", "P",
	             "Q", "R", "S", "T", "U", "V", "W", "X",
	             "Y", "Z", "1", "2", "3", "4", "5", "6",
	             "7", "8", "9", "0"
				
		};
		
		String[] morsecode= {
				".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
	            "....", "..", ".---", "-.-", ".-..", "--", "-.",
	            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
	            "...-", ".--", "-..-", "-.--", "--..", ".----",
	            "..---", "...--", "....-", ".....", "-....",
	            "--...", "---..", "----.", "-----"	
		};
		
		for(int i=0;i<letters.length;i++) {
			toMorse.put(letters[i].charAt(0),morsecode[i]);
			toEnglish.put(morsecode[i],letters[i].charAt(0));
		}
	}
}
