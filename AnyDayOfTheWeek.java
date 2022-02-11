package projects;

import java.util.Scanner;
import java.lang.Math;

public class AnyDayOfTheWeek {
	
	public static int repeatedCodeInSubtract(int d, int closestDay, int doomsday) {
		if (d - closestDay >= 0) {
			int distance = (d - closestDay) % 7;
			return (doomsday + distance) % 7;
		} else {
			while (closestDay > d) {
				closestDay -= 7;
			}
			if (closestDay <= 0) {
				closestDay += 7;
				while (closestDay != d) {
					closestDay -= 1;
					doomsday -= 1;
				}
				return doomsday;
			}
			int distance = (d - closestDay) % 7;
			return (doomsday + distance) % 7;
		}
	}
		
	public static int monthToNum(String m) {
		m = m.toLowerCase();
		if (m.equals("january") || m.equals("jan") || m.equals("1")) {
			return 1;
		} else if (m.equals("february") || m.equals("feb") || m.equals("2")) {
			return 2;
		} else if (m.equals("march") || m.equals("mar") || m.equals("3")) {
			return 3;
		} else if (m.equals("april") || m.equals("apr") || m.equals("4")) {
			return 4;
		} else if (m.equals("may") || m.equals("may") || m.equals("5")) {
			return 5;
		} else if (m.equals("june") || m.equals("jun") || m.equals("6")) {
			return 6;
		} else if (m.equals("july") || m.equals("jul") || m.equals("7")) {
			return 7;
		} else if (m.equals("august") || m.equals("aug") || m.equals("8")) {
			return 8;
		} else if (m.equals("september") || m.equals("sept") || m.equals("9")) {
			return 9;
		} else if (m.equals("october") || m.equals("oct") || m.equals("10")) {
			return 10;
		} else if (m.equals("november") || m.equals("nov") || m.equals("11")) {
			return 11;
		} else if (m.equals("december") || m.equals("dec") || m.equals("1"))  {
			return 12;
		} else {
			return 0;
		}
	}
	
	public static int doomsDay(int y) {
		int d = 2 + y + (int)Math.floor(y / 4) - (int)Math.floor(y/100) + (int)Math.floor(y/400);
		d = d % 7;
		return d;
	}
	
	public static String dayOfTheWeek(int d) {
		if (d == 0) {
			return "Sunday";
		} else if (d == 1) {
			return "Monday";
		} else if (d == 2) {
			return "Tuesday";
		} else if (d == 3) {
			return "Wednesday";
		} else if (d == 4) {
			return "Thursday";
		} else if (d == 5) {
			return "Friday";
		} else {
			return "Saturday";
		}
	}

	public static int closestMonth(int m) {
		if (m == 2 || m == 4 || m == 6 || m == 8 || m == 10 || m == 12 || m == 5|| m == 7 || m == 9 ||m == 11) {
			return m;
		} else if (m == 3) {
			return 4;
		} else {
			return 2;
		}
	}
	
	public static int closestDay(int m, boolean y) {
		int closest = closestMonth(m);
		if (closest == 2) {
			if (y) {
				return 29;
			}
			return 28;
		} else if (closest == 5) {
			return 9;
		} else if (closest == 7) {
			return 11;
		} else if (closest == 9) {
			return 5;
		} else if (closest == 11) {
			return 7;
		}
		return closest;
	}
	
	public static int subtract(int m, int d, int y, boolean ly) {
		int closestDay = closestDay(m, ly);
		int closestMonth = closestMonth(m);
		int doomsday = doomsDay(y);
		
		if (closestMonth == m) {
			return repeatedCodeInSubtract(d, closestDay, doomsday);
		} else {
			while (d < 31) {
				d += 7;
			}
			d += 7;
			d -= 31;
			return repeatedCodeInSubtract(d, closestDay, doomsday);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		boolean leapYear = true;
		System.out.println("Enter the month");
		String mon = scan.nextLine();
		int month = monthToNum(mon);
		if (month == 0) {
			System.out.println("Sorry, that is not a valid month");
			System.exit(0);
		}
		System.out.println("Enter the number of the day");
		int day = 0;
		try {
			day = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Sorry, not a valid day");
			System.exit(0);
		}
		System.out.println("Enter the number of the year");
		int year = 0;
		try {
			year = scan.nextInt();
		} catch (Exception e){
			System.out.println("Sorry, not a valid year");
			System.exit(0);
		}
		if (year % 4 == 0) {
			leapYear = true;
		} else {
			leapYear = false;
		}
		
		int date = subtract(month, day, year, leapYear);
		
		System.out.println("The date that you selected is on a " + dayOfTheWeek(date) + ".");
	}
}
