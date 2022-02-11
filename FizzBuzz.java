package projects;

import java.util.Scanner;

public class FizzBuzz {
	
	public static String check(int num) {
		String answer = "";
		if (num % 3 == 0) {
			answer += "Fizz";
		}
		if (num % 5 == 0) {
			answer += "Buzz";
		}
		if (answer.isEmpty()) {
			answer += "None";
		}
		
		return answer;
	}
	
	public static void main (String args[]) {
		/* ACTUAL THINGY
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter a number: ");
		int num = scan.nextInt();
		
		String answer = check(num);
		
		System.out.println(answer);*/
		
		//CHALLENGE
		for (int i = 1; i <= 100; i++) {
			String answer = check(i);
			System.out.println(i + ": " + answer);
		}
		
	}
}
