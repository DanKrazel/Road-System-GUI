/**
 * 
 */
package utilities;

/**
 * @author Sophie Krimberg
 *
 */
public abstract class Point implements Utilities {
	private double x;
	private double y;
	private final double minVal = 0;
	private final double maxX=800;
	private final double maxY=600;
	
	/**Constructor
	 * @param xVal
	 * @param yVal
	 */
	public Point(double xVal, double yVal) {
		
		if (checkValue(xVal, minVal, maxX)) {
			x=xVal;
		}
		
		else {
			x=getRandomDouble(minVal, maxX);
			correctingMessage(xVal,x,"X");
		}
		
		if (checkValue(yVal, minVal, maxY)) {
			y=yVal;
		}
		else {
			y=getRandomDouble(minVal, maxY);
			correctingMessage(yVal,y,"Y");
		}
		
		
	
			
	}
	
	/**Default constructor
	 * 
	 */
	public Point() {
		x=getRandomDouble(minVal, maxX);
		y=getRandomDouble(minVal, maxY);
		
	}
	  	
	/**
	 * @param xVal
	 * @return
	 */
	public boolean setX(int xVal) {
		
		if (checkValue(xVal,minVal, maxX)) {
			x=xVal;
			return true;
		}
		
		else {
			errorMessage(xVal, "X");
			System.out.println();
			return false;
			
		}
	}
	
	/**
	 * @param yVal
	 * @return
	 */
	public boolean setY(int yVal) {
		
		if (checkValue(yVal,minVal,maxY)) {
			y=yVal;
			return true;
		}
		
		else {
			errorMessage(yVal, "Y");
			System.out.println();
			return false;
		}
	}

	@Override
	public String toString() {
		
		 return new String("Point (" + x + " , " + y + ")");
		
	}
	
//	
//	public boolean equals(Point other) {
//		if (this.x==other.x && this.y==other.y) {
//			return true;
//		}
//		else return false;
//	}

	

	
	/**compares coordinates only 
	 * @param other
	 * @return
	 */
	public boolean equals(Point other) {
		if (this.x!=other.x || this.y!=other.y) 
			return false;
		return true;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	public double calcDistance(Point other){
		return Math.sqrt(Math.pow(other.getX()-this.getX(),2)+Math.pow(other.getY()-this.getY(),2));
	}

	/**
	 * @return the minVal 
	 */
	public double getMinVal() {
		return minVal;
	}

	/**
	 * @return the maxX
	 */
	public double getMaxX() {
		return maxX;
	}

	/**
	 * @return the maxY
	 */
	public double getMaxY() {
		return maxY;
	}
	
}
