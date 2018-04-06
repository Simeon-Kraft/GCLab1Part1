import java.util.Scanner;
public class Lab1Part1 {
	
	// This program receives two numbers from the user
	// And compares the relative sums of each number's respective digits

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userStr1;
		String userStr2;
		
		
		// Get input for userStr1
		System.out.println("Please enter a number: ");
		userStr1 = scnr.next();
		
		// Validate first number
		while (!(stringNotEmpty(userStr1) && stringIsNumeric(userStr1))){
			
			System.out.println("Invalid entry.\nPlease enter a number: ");
			userStr1 = scnr.next();
		}
		
		// Get input for userStr2
		System.out.println("Please enter a second number: ");
		userStr2 = scnr.next();
		
		// Validate second number
		while (!(bothStringsValidInputs(userStr1, userStr2))){
			
			System.out.println("Second number was not valid.\nPlease re-enter second number: ");
			userStr2 = scnr.next();
		}
		
		// Produce output true/false
		if (allColumnSumsEqual(userStr1, userStr2)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
	
	public static boolean bothStringsValidInputs(String userStr1, String userStr2) {
		
		// This ensures that the numbers entered are valid in terms of length and characters
		if (stringNotEmpty(userStr1) && stringNotEmpty(userStr2) && stringIsNumeric(userStr1) && stringIsNumeric(userStr2) && stringLengthsEqual(userStr1,userStr2)) {
			return true;
		}
		else {
			return false;
			
		}
	}
	
	public static boolean stringNotEmpty(String str) {
		
		// This ensures that the user's strings are not empty
		if (str != null && str.length() > 0) {
			return true;
		}
		else {
			return false;
			
		}
	}
	
	public static boolean stringIsNumeric(String userStr1) {
		
		// This ensures that the string entered by the user in numeric
		for (int i = 0; i < userStr1.length(); ++i) {
			char currentChar = userStr1.charAt(i);
			boolean currentCharisDigit;
			currentCharisDigit = Character.isDigit(currentChar);
			
			if (currentCharisDigit == false) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean stringLengthsEqual(String userStr1, String userStr2) {
		
		// This determines whether the user's numbers are of equal length
		if (userStr1.length() == userStr2.length()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean allColumnSumsEqual(String userStr1, String userStr2) {
		
		// This determines whether the  respective columns are equal
		if (userStr1.length() < 2 && userStr2.length() < 2) {
			return true;
		}
		
		String col1A = userStr1.charAt(0) + "";
		String col1B = userStr2.charAt(0) + "";
		
		int i;

		for (i = 1; i < userStr1.length(); ++i) {
			
			String currentColA;
			String currentColB;
			currentColA = userStr1.charAt(i) + "";
			currentColB = userStr2.charAt(i) + "";
			
			if (colSumsEqual(currentColA, currentColB, col1A, col1B) == false){
				
				return false;
			}	
		}
	
		return true;
	}

	public static boolean colSumsEqual(String col1A, String col1B, String col2A, String col2B) {
		
		// This evaluates whether the sums of each position in the user number are equal
		int col1Aint = Integer.parseInt(col1A);
		int col1Bint = Integer.parseInt(col1B);
		int col2Aint = Integer.parseInt(col2A);
		int col2Bint = Integer.parseInt(col2B);
		
		if ((col1Aint + col1Bint) == (col2Aint + col2Bint)) {
			return true;
		}
		
		else {
			return false;
		
		}
		
	}
}
