package morsecodetranslator;

public class MorseTranslator {
	
	public static String toMorse(String text) {
		StringBuilder morse=new StringBuilder();
		text=text.toUpperCase();
		
		for(char c:text.toCharArray()) {
			if(c==' ') { //one space
				morse.append("   ");//three spaces for word gap
			}else {
				String code=MorseCode.toMorse.get(c);
				if(code!=null) {
					morse.append(code).append(" ");
				}
			}
		}
		return morse.toString().trim();
	}
	
	public static String toEnglish(String morse) {
		StringBuilder english=new StringBuilder();
		String[] words= morse.trim().split(" ");
		
		for(String word: words) {
			for(String letter:word.split(" ")) {
				Character c=MorseCode.toEnglish.get(letter);
				if(c!=null) {
					english.append(c);
				}
			}
			english.append(" ");
		}
		
		return english.toString().trim();
	}
}
