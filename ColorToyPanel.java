//The drawable area for the ColorToy app

import java.awt.*;
import javax.swing.*;

public class ColorToyPanel extends JPanel {

	private double a_r = 0.5;
	private double a_b = 0.5;
	private double a_g = 0.5;

	private double b_r = 0.5;
	private double b_b = 0.5;
	private double b_g = 0.5;

	private double c_r = 1.0;
	private double c_b = 1.0;
	private double c_g = 0.5;

	private double d_r = 0.8;
	private double d_b = 0.9;
	private double d_g = 0.3;

    public void drawFunction(Canvas canvas, Graphics page){
	canvas = new Canvas(this.getSize().getWidth(), this.getSize().getHeight(), 100, 10, 0, 0);
	Point p = new Point(0, 0);
	while(p.getX() < canvas.getWidth())
	    {
		while(p.getY() <  canvas.getHeight())
		    {
			plotpoint(canvas, page, p, (double) (p.getX() / canvas.getWidth()));
			p.setY(p.getY() + 1);
		    }
		p.setY(0.0);
		p.setX(p.getX() + 1);
	    }
    }

    public void plotpoint(Canvas canvas, Graphics page, Point p, double t)
    {
		double r_out = 0.;
		double g_out = 0.;
		double b_out = 0.;
		int r, g, b;
		r_out = a_r + b_r * Math.cos(3.14159 * 2. * (c_r * t + d_r));
		g_out = a_g + b_g * Math.cos(3.14159 * 2. * (c_g * t + d_g));
		b_out = a_b + b_b * Math.cos(3.14159 * 2. * (c_b * t + d_b));
		r_out *= 255.;
		g_out *= 255.;
		b_out *= 255.;
		r = (int) Math.abs(r_out);
		g = (int) Math.abs(g_out);
		b = (int) Math.abs(b_out);
		r %= 255;
		g %= 255;
		b %= 255;
		Color color = new Color(r,g,b);
		canvas.plot(p, page, color);//}
    }

	public void gotUpdate(double ar, double ag, double ab,
						  double br, double bg,	double bb,
						  double cr, double cg, double cb,
						  double dr, double dg, double db) {

	this.a_r = ar;
	this.a_g = ag;
	this.a_b = ab;
	this.b_r = br;
	this.b_g = bg;
	this.b_b = bb;
	this.c_r = cr;
	this.c_g = cg;
	this.c_b = cb;
	this.d_r = dr;
	this.d_g = dg;
	this.d_b = db;

	this.repaint();
	}

	void printValues() {
		System.out.println(a_r + " " + a_g + " " + a_b);
		System.out.println(b_r + " " + b_g + " " + b_b);
		System.out.println(c_r + " " + c_g + " " + c_b);
		System.out.println(d_r + " " + d_g + " " + d_b);
	}

    
    public void paintComponent(Graphics page){
	
	super.paintComponent(page);
	setBackground(Color.black);
	Canvas colortoypage = new Canvas(1000, 100, 100, 10, 0, 0);
	drawFunction(colortoypage, page);
	
    }//end of paintComponent

}//end of ColorToyPanel

//end of file
