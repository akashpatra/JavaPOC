package poc;

import java.util.HashMap;

public class StringChecks {

	// Check Spaces
	private static String REG = ".*\\s{2,}.*";
	private static String temp = "akash patra";
	
	// Check Email
	private static String EMAIL_REG = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	private static String EMAIL_REG_1 = "[\\w]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})";
	private static String emailTemp = "akash_patrA@gmail.com.co.fdsfds";
	
	// Check 12Digit
	private static String AADHAAR_REG = "[0-9]{12}";
	private static String aadhaarTemp = "a23456789012"; //"333840956532";
	
	public static void main(String[] args) {
		// Check Spaces
//		checkSpaces();
		
		// Check Email
//		checkEmail();
		
		// Check Aadhaar
		checkAadhaar();
	}

	private static void checkSpaces() {
		System.out.println("Spaces Check: " + temp.matches(REG));
	}
	
	private static void checkEmail() {
		System.out.println("Email Check: " + emailTemp.matches(EMAIL_REG_1));
	}
	
	private static void checkAadhaar() {
		System.out.println("Aadhaar Check: " + aadhaarTemp.matches(AADHAAR_REG));
	}
}
