package projects;

import java.util.Scanner;

public class DuckDuckGoose {
	public static void main (String [] args) {
		Scanner scan = new Scanner (System.in);
		String answer = "goose";
		int count = 0;
		while (!answer.equals("duck")) {
			answer = scan.next();
			if (answer.equals("goose")) {
				count++;
			} else if (!answer.equals("duck")) {
				count = -1;
				break;
			}
		}
		if (count == -1) {
			System.out.println("Error: must enter either duck or goose");
		} else if (count < 2) {
			System.out.println("Error: must enter duck 2 times before entering goose");
		} else {
			System.out.println("Good job! You played correctly");
		}
	}
}
