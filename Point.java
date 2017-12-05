

public class Point{			     
    
    private double x, y;

    public Point(double x, double y){
	this.x = x;
	this.y = y;
    }

    public double getX(){
	return x;
    }

    public double getY(){
	return y;
    }

    public void setX(double x){
	this.x = x;
    }

    public void setY(double y){
	this.y = y;
    }
    
    public double distance(Point pt){
	double d;
	d = Math.sqrt(Math.pow(this.y - pt.getY(), 2) + Math.pow(this.x - pt.getX(), 2));
	return d;
    }


}//end of point class
