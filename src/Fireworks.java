import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Fireworks extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer tmr;
	double dt, gravity;
	ArrayList<Point> points;
	//static int width, height;

	static JFrame mainFrame;

	public Fireworks(){
		points = new ArrayList<Point>();
//		width = 900;
//		height = 700;
		
		for(int i = 0; i<100; i++){
			points.add(new Point  (mainFrame.getWidth()/2-10,  mainFrame.getHeight()/2-10));
		}
		tmr = new Timer(10, this);
		dt = 0.08;
		gravity = 9.8;
		this.setBackground(Color.black);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		repaint();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (Point p : points) {

			p.vy = p.vy - gravity * dt;
			p.x = p.x + p.vx * dt * p.leftOrRight;
			p.y = p.y - p.vy * dt;

			if (p.x >= mainFrame.getWidth() - 25 && p.vx >= 0) {
				p.leftOrRight *= -1;
				p.x = mainFrame.getWidth() - 25;
				p.vx = p.vx;
			}
			if (p.x <= 0 && p.vx >= 0) {
				p.leftOrRight *= -1;
				p.x = 0;
				p.vx = p.vx;
			}
			if (p.y >= mainFrame.getHeight() - 60 && p.vy <= 0) {
				p.y = mainFrame.getHeight() - 60;
				p.vy = -p.vy;
			}
			if (p.y <= 0) {
				p.y = 0;
				p.vy = -p.vy;
			}

			g.setColor(p.col);
			g.fillOval((int) p.x, (int) p.y, 20, 20);
			g.drawLine((int) p.x + 10, (int) p.y + 10, (int) (p.x + 10 + p.vx * p.leftOrRight),
					(int) (p.y + 10 - p.vy));
		}
	}

	public static void main(String[] args) {

		
		mainFrame = new JFrame("Fireworks");
		
		
		Fireworks frw = new Fireworks();

		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(true);
		mainFrame.setSize(400, 400);

		mainFrame.setVisible(true);

		mainFrame.add(frw = new Fireworks());
		frw.tmr.start();
		/*
		 * Thread t = new Thread(){ public void run(){ try { sleep(7000); }
		 * catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } };
		 * 
		 * while(true){
		 * 
		 * frame.remove(frw); frame.add(frw = new Fireworks()); frw.tmr.start();
		 * frame.revalidate(); t.run(); }
		 */

	}

}
