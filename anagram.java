import java.util.*;
class Solution {
 
	// Function to check whether anagram strings 
	public static boolean CheckAnagram(String str1, String str2) {

		//Comparing the lengths
		if (str1.length() != str2.length()) {
			return false ;
		}
 
 		//Creating and initialising arrays
		int count1[] = new int[256];
		Arrays.fill(count1, 0);
		
		int count2[] = new int[256];
		Arrays.fill(count2, 0);
		int i;
		
		for (i = 0; i < str1.length() && i < str2.length(); i++) {
			count1[str1.charAt(i)]++;
			count2[str2.charAt(i)]++;
		}

		// Compare count arrays
		for (i = 0; i < 256; i++) {
			if (count1[i] != count2[i]) {
				return false;
			}
		}
		return true;
	}

	//Main starts here
	public static void main(String args[]) {
		String str1 = "coding";
		String str2 = "ingodc";

		// Function call
		if (CheckAnagram(str1, str2)) {
			System.out.println("Strings are anagrams");
		}
		else{
			System.out.println("Strings are not anagrams");
		}
	}
}
