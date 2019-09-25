package weekfour;

import java.util.HashMap;

public class AnagramSolver2 {
	
	public static void main(String [] args) {
		String [] s = {"Tar", "Rat","Study", "Dusty", "Elbow", "Below", "Dormitory", "Dirty room"};
		
		System.out.println(s[1] + " " + s[0] + " " + isAnagram(s[1],s[0]));
		System.out.println(s[2] + " " + s[3] + " " + isAnagram(s[2],s[3]));
		System.out.println(s[5] + " " + s[4] + " " + isAnagram(s[4],s[5]));

		System.out.println("Empty String" + s[0] + " " + isAnagram("", s[0]));
		System.out.println("Hello String and null " + isAnagram("Hello", null)); 
		System.out.println(s[6] + " " + s[7] + " " + isAnagram(s[6], s[7]));
	}

	public static boolean isAnagram(String s1, String s2) {

		// base case, null strings, different lengths or empty strings.
		if((s1 == null || s2 == null) || (s1.length() == 0 || s2.length() == 0) )
			return false;
		
		// convert s1 and s2 to lower case
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		HashMap<Character, Integer> anagram1 = new HashMap<>();
		HashMap<Character, Integer> anagram2 = new HashMap<>();
		
		int value = 0;
		Character key;
		
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == ' ')
				continue;
			// for hashmap 1
			if(anagram1.containsKey(s1.charAt(i))) {
				value = anagram1.get(s1.charAt(i)) + 1;
				key = s1.charAt(i);
				anagram1.put(key, value);
			} else {
				key = s1.charAt(i);
				anagram1.put(key, 1);
			}	
		}
		
		for(int i = 0; i < s2.length(); i++) {
			if(s2.charAt(i) == ' ')
				continue;
		
			// for hashmap 2
			if(anagram2.containsKey(s2.charAt(i))) {
				key = s2.charAt(i);
				value = anagram2.get(s2.charAt(i)) + 1;
				anagram2.put(key,value );
			} else {
				key = s2.charAt(i);
				anagram2.put(key, 1);
			}	
		}		
		return anagram1.equals(anagram2);
	}
}
