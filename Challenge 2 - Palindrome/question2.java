package qlik;

public class question2 {
	
	public static void main(String[] args) {
	    int max = -1; //current max palindrome, initial as -1
	    int firstNumber = -1; //first 3-digit number, initial as -1
	    int secondNumber = -1; //second 3-digit number, initial as -1
	  //loop two numbers start from 999 to 100
	    for ( int i = 999 ; i >= 100 ; i--) { 
	        for (int j = 999 ; j >= 100 ; j-- ) {
	            int product = i * j;
	            if ( max < product && isPalindrome(product) ) {
	                max = product; //replace max
	                firstNumber = i; //replace first number
	                secondNumber = j; //replace second number
	            }
	        }
	    }
	    System.out.println("First number is " + firstNumber + " and Second number is " + secondNumber);
	    System.out.println(max);
	}
	
	public static boolean isPalindrome(int num) {
	    int rev = 0; //reversed number, initial as 0
	    int copy = num; //store value in copy
	    while (copy > 0) {
	        rev = 10 * rev + copy % 10; //reverse number
	        copy /= 10;
	    }
	    return (num == rev); // return true if the number is palindrome
	}

	
}
