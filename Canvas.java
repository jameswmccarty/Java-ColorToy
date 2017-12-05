/**
 *A Canvas Object that we can impose an X-Y coordinate plane onto, useful for drawing graphs on.
 */

import java.awt.*;

public class Canvas{
   
    private double width, height, xupper, yupper, xlower, ylower;
    private double Xdot, Ydot, ranx, rany;

    public Canvas(double width, double height, double xupper, double yupper, double xlower, double ylower){
	this.width = width;
	this.height = height;
	this.xupper = xupper;
	this.yupper = yupper;
	this.xlower = xlower;
	this.ylower = ylower;
	this.ranx = xupper - xlower;
	this.rany = yupper - ylower;
    }
    
    public double getXupper(){
	return xupper;
    }
    
    public double getYupper(){
	return yupper;
    }

    public double getXstep(){
	return xupper / width;
    }

    public double getYstep(){
	return yupper / height;
    }

    public double getWidth(){
	return width;
    }

    public double getHeight(){
	return height;
    }

    public double getXdot(Point pt){
	return ((pt.getX() / this.width) * this.ranx) - (0.5 * this.ranx);
    }

    public double getYdot(Point pt){
	return ((pt.getY() / this.height) * this.rany) - (0.5 * this.rany);
    }



    public void plot(Point pt, Graphics page, Color color){
	
	if(0.0 <= pt.getX()){
	    if(pt.getX() <= width){
		if(0.0 <= pt.getY()){
		    if(pt.getY()<= height){	
			page.setColor(color);
			page.fillRect((int)pt.getX(), (int)pt.getY(), 1, 1);
		    }}}}
	    
    }

  
}//end of Canvas class

//end of File
