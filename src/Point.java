import java.awt.Color;

public class Point {
	public double x, y, vx, vy;
	public int leftOrRight;
	Color col;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		vx = Math.random() * 55;
		vy = Math.random() * 90;
		leftOrRight = ((int) (Math.random() * 2) == 0) ? -1 : 1;

		col = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		
	}
}
