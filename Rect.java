package projects;

public class Rect {
	private int x;
	private int y;
	
	public Rect(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int area() {
		return (x * y);
	}
	
	public int perimeter() {
		return 2 * (x + y);
	}
	
	public void changeX(int x) {
		this.x = x;
	}
	
	public void changeY (int y) {
		this.y = y;
	}
}
