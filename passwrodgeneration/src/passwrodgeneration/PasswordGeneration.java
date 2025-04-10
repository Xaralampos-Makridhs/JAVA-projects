package passwrodgeneration;
import java.security.*;


public class PasswordGeneration {
	private static final String alphabet="abcdefghijklmnopqrstuvwxyz";
	private static final String upperletters=alphabet.toUpperCase();
	private static final String numbers="0123456789";
	private static final String characters="!@#$%^&*()-+?<>=";
	private static final String summary=alphabet+upperletters+numbers+characters;
	private static SecureRandom random=new SecureRandom();
	
	public static String generate(int length) {
		StringBuilder result=new StringBuilder(length);
		
		for(int i=0;i<length;i++) {
			int index=random.nextInt(summary.length());
			result.append(summary.charAt(index));
		}
		return result.toString();
	}
}
