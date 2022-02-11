package projects;

public class Student {
	private String first;
	private String last;
	private double gpa;
	private int grade;
	private int id;
	private static int num;
	private int student_number;
	
	public Student(String first, String last, double gpa, int grade, int id) {
		this.first = first;
		this.last = last;
		if (gpa >= 0 && gpa <= 4.5) {
			this.gpa = gpa;
		} else {
			gpa = 0;
		}
		if (grade >= 0 && grade <= 12) {
			this.grade = grade;
		} else {
			grade = 0;
		}
		this.id = id;
		
		num += 1;
		student_number = num;
	}
	
	public String school() {
		if (grade >= 0 && grade <= 5) {
			return "Elementary School";
		} else if (grade >= 6 && grade <= 8) {
			return "Middle School";
		} else {
			return "High School";
		}
	}
	
	public String name() {
		return last + ", " + first;
	}
	
	public double gpa() {
		return gpa;
	}
	
	public String grade() {
		if (gpa >= 4.0 && gpa <= 4.5) {
			return "A";
		} else if (gpa >= 3.5 && gpa < 4.0) {
			return "B";
		} else if (gpa >= 3.0 && gpa < 3.5) {
			return "C";
		} else if (gpa >= 2.5 && gpa < 3.0) {
			return "D";
		} else {
			return "F";
		}
	}
	
	public int studentNumber() {
		return student_number;
	}
	
	public void changeGpa(double new_gpa) {
		gpa = new_gpa;
	}
	
	public String toString() {
		String line1 = "Student " + student_number + ": " + last + ", " + first;
		String line2 = "\n\tStudent id: " + id;
		String line3 = "\n\tGrade: " + grade + "th Grade";
		String line4 = "\n\tGPA: " + gpa + "\tLetter Grade: " + this.grade();
		return line1 + line2 + line3 + line4;
	}
}
