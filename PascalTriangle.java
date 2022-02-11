package projects;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {
	
	public static int choosing(int n, int k) {
		int numerator = 1;
		int count = 0;
		while (count < k) {
			numerator *= n;
			n--;
			count++;
		}
		int deno = 1;
		for (int i = k; i > 0; i--) {
			deno *= i;
		}
		
		return (numerator) / (deno);
	}
	
	public static void combinationsMethod() {
		Scanner scan = new Scanner (System.in);
		System.out.println("How many row numbers do you want to see?");
		int rows = scan.nextInt();
		
		for (int i = 0; i < rows; i++) {
			if (i % 2 == 0) {
				System.out.print(ConsoleColors.CYAN_BOLD + "\n");
			} else {
				System.out.print(ConsoleColors.PURPLE_BOLD + "\n");
			}
			for (int j = rows - i; j >= 0; j--) {
				System.out.print("\t");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(choosing(i, j) + "\t\t");
			}
			
		}
	}
	
	public static void previousNumberMethod() {
		Scanner scan = new Scanner (System.in);
		ArrayList<Integer> previousrowNumbers = new ArrayList<Integer>();
		ArrayList<Integer> rowNumbers = new ArrayList<Integer>();
		rowNumbers.add(1);
		System.out.println("How many row numbers do you want to see?");
		int rows = scan.nextInt();
		while (rows >= 0) {
			//This does the spacing in front of the numbers to make it in a triangle
			int counter = 2*rows;
			while (counter !=  0) {
				System.out.print(" ");
				counter -= 1;
			}
			
			//Print out the initial value of of rowNumbers
			for (Integer val: rowNumbers) {
				System.out.print(val + "  ");
				previousrowNumbers.add(val);
			}
			
			//Clears rowNumbers and makes its value [1]
			rowNumbers.clear();	
			rowNumbers.add(1);
			
			//Add the sum of the previous two numbers above it
			for (int i = 0; i < previousrowNumbers.size() - 1; i++) {
				int num = previousrowNumbers.get(i) + previousrowNumbers.get(i + 1);
				rowNumbers.add(num);
			}
			
			//Add one to be the last number
			rowNumbers.add(1);
			//Change loop variable
			rows -= 1;
			//Go to the next line in the Pascal triangle
			System.out.println();
			//clear previousRowNumbers
			previousrowNumbers.clear();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combinationsMethod();
		System.out.println(ConsoleColors.RESET);
		previousNumberMethod();
	}
}
