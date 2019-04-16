package de.ironcrone.war.utility;

public class XY {

public final int x, y;
	
	public static final XY UP = new XY(0, -1);
	public static final XY UP_RIGHT = new XY(1,-1);
	public static final XY RIGHT = new XY(1,0);
	public static final XY DOWN_RIGHT = new XY(1,1);
	public static final XY DOWN = new XY(0,1);
	public static final XY DOWN_LEFT = new XY(-1,1);
	public static final XY LEFT = new XY(-1, 0);
	public static final XY UP_LEFT = new XY(-1,-1);
	
	public XY(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public XY translateBy(XY translationVector) {
        return new XY(x + translationVector.x, y + translationVector.y);
    }
	
	public String toString()  {
        return "(" + x + "," + y + ")";
    }

	public double distanceOf(XY pos) {
		XY vector = new XY(pos.x-this.x,pos.y-this.y);
		double distance = Math.sqrt(vector.x*vector.x + vector.y*vector.y);
		return distance;
	}
	
	public static final XY randomVector() {
		
		int random = (int) (Math.random() * 7);
		
		switch(random) {
		
		case 0:
			return UP;
			
		case 1:
			return UP_RIGHT;
			
		case 2:
			return RIGHT;
			
		case 3:
			return DOWN_RIGHT;
			
		case 4:
			return DOWN;
			
		case 5:
			return DOWN_LEFT;
			
		case 6:
			return LEFT;
			
		case 7:
			return UP_LEFT;
		
		}
		
		return null;
		
	}

	
}
