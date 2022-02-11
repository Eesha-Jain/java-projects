package projects;

public class Permute {
	
	public static void permute(String s, String chosen) {
		if (s.length() == 0) {
			System.out.println(chosen);
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
		permute("MARTY", "");
	}

}
