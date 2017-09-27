public class Point{

	// x coordinate
	public double x;
	// y coordinate
	public double y;

	/**
	 * Constructor for new Point
	 * @param x x-axis coordinate
	 * @param y y-axis coordinate
	 */
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	/**
	 * Ensures two Points are equal (x and y coordinates are the same - a value or NaN)
	 * @return true if the Points are equal.
	 */
	public boolean equals(Object o) {
		if(o == null) return false;	
		if (!(o instanceof Point)) return false;
		Point that = (Point) o;
		
		// Check x
		if(Double.isNaN(this.x) || Double.isNaN(that.x))
		{
			if ( !(Double.isNaN(this.x) && Double.isNaN(that.x)) )
				return false;
		}
		else
		{
			if ( this.x != that.x)
				return false;		
		}		
		
		// Check y
		if(Double.isNaN(this.y) || Double.isNaN(that.y))
		{
			if ( !(Double.isNaN(this.y) && Double.isNaN(that.y)) )
				return false;
		}
		else
		{
			if ( this.y != that.y)
				return false;		
		}

		// return true if no equality was invalid
		return true;
	}

	@Override
	/**
	 * Creates a unique hashcode for the Point object - identical Point objects should have the same hashcode
	 * @return int hashcode 
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) x;
		result = prime * result + (int) y;
		return result;
	}

	/**
	 * Flips the point about x, y, or y=-x axis
	 * @param axis - "x", "y", "y=-x"
	 */
	public void Mirror(String axis)
	{
		if (axis.equals("x"))
		{
			this.x = -this.x;
		}
		else if (axis.equals("y"))
		{
			this.y = -this.y;
		}
		else if (axis.equals("y=-x"))
		{
			double tempx = y;
			this.x = -this.y;
			this.y = -tempx;
		}

	}
	/**
	 * Flips the point across a line.  If any public member or parameter is null, the point is left unchanged.
	 * @param l the line the point is mirrored across. 
	 */
	public void Mirror(Line l)
	{
		if (l.point1 == null || l.point2 == null)
                {
                        return;
                }
		double rise = l.point1.y - l.point2.y;
		double run = l.point1.x - l.point2.x;
		double slope = rise/run;

		double b = l.point1.y - (slope*l.point1.x);

		double d = (l.point1.x + (l.point1.y - b)*slope) / ( 1 + slope*slope);

		this.x = 2*d - this.x;
		this.y = (2*d*slope - this.y + 2*b);

	}

}
