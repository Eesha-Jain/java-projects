package projects;

import java.util.ArrayList;

public class Permutation {
	
	private static ArrayList <String> prev;
	
	public static void permute(String s, String chosen) {
		if (s.length() == 0) {
			boolean not = true;
			for (String x: prev) {
				if (x.equals(chosen)) {
					not = false;
				}
			}
			if (not) {
				prev.add(chosen);
			}
		}
		else {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				permute(s.substring(0, i) + s.substring(i + 1), chosen + c);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prev = new ArrayList <String> ();
		permute("SIS", "");
		for (String x: prev) {
			System.out.println(x);
		}
	}

}
