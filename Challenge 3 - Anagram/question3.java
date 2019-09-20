package qlik;

public class question3 {
	
	public static void main(String args[]) {
		String a = "Debit Card";
		String b = "Bad Credit";
		boolean check = isAnagram(a, b);
		System.out.println(check);
	}
	
	public static boolean isAnagram(String str1, String str2) {
		//deal with the empty space and change the letters to lowercase
		String string1 = str1.replaceAll("\\s+","").toLowerCase();
		String string2 = str2.replaceAll("\\s+","").toLowerCase(); 
		//initial check if length is not same. if not same, return false
	    if (string1.length() != string2.length()) {
	        return false;
	    }
	    //create table of 26 alphabets
	    int[] table = new int[26];
	    //add the number of letters in corresponding position for string 1
	    for (int i = 0; i < string1.length(); i++) {
	        table[string1.charAt(i) - 'a']++;
	    }
	    //delete the number of letters in corresponding position for string 2
	    for (int i = 0; i < string1.length(); i++) {
	        table[string2.charAt(i) - 'a']--;
	        //if there are more letter at some position, return false
	        if (table[string2.charAt(i) - 'a'] < 0) {
	            return false;
	        }
	    }
	    //return true after matching all alphabets
	    return true;
	}
	
}
