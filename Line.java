import java.util.Random;

public class Line {

    //One point in the line
    public Point point1;
    //Second point in the line
    public Point point2;

    /**
     * Creates a new Line object
     * @param p1 - first Point
     * @param p2 - second Point
     */
    public Line(Point p1, Point p2)
    {
        if(p1 == null){
            this.point1 = null;
        }else{
            this.point1 = new Point(p1.x,p1.y);
        }
        if (p2 == null){
            this.point2 = null;
        }else{
            this.point2 = new Point(p2.x,p2.y);
        }

    }

    /**
     * Checks whether 2 lines are parallel
     * @param l - the line to check against
     * @return true if the lines are parallel
     */
    public boolean parallel(Line l)
    {
        if (l == null) return false;
        if (l.point1 == null || l.point2 == null || this.point1 == null || this.point2 == null)
        {
            return false;
        }
        double other_slope = slope(l.point1,l.point2);

                double this_slope = this.slope(this.point1,this.point2);

        if (other_slope == this_slope)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * Checks whether 2 lines are perpendicular
     * @param l - the line to check against
     * @return true if the lines are perpendicular
     */
    public boolean perpendicular(Line l)
    {
        if (l == null) return false;
        if (l.point1 == null || l.point2 == null || this.point1 == null || this.point2 == null)
                {
                        return false;
                }
        double other_slope = this.slope(l.point1,l.point2);

        double this_slope = this.slope(this.point1,this.point2); 

        if (other_slope*this_slope == -1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * Rotate the line 90 degrees around the specified point
     * @param p point to rotate around (will stay the same)
     * @return Line that has been rotated
     */ 
     public Line rotate(Point p)
     {
         if (p == null || this.point1 == null || this.point2 == null)
         {  
            return this;
         }
         double slope = this.slope(this.point1,this.point2); 

         double b = this.point1.y - (slope*this.point1.x);

         double new_slope = -1/slope;

         Random rand = new Random();
         double x_2 = rand.nextInt(10);

         double y = new_slope*x_2+b;

         Point p2 = new Point(x_2,y);
         Line l2 = new Line(p,p2);

         return l2;
     }

     /**
     *  Helper method for determining slope of a line between two points
     *  @return double value for slope of line 
     *  
     **/
     private double slope(Point point1, Point point2)
     {
        double rise = point1.y - point2.y;
                double run = point1.x - point1.y;
                double slope = rise/run;
        return slope;
     }


     @Override
     /**
      * Checks if two Line objects are the same  - they both have equivalent points (null == null)
      * @return true if the Lines are equal 
      */
     public boolean equals(Object o) {
        if(this == null && o == null) return true;  
        if (o == null || this == null) return false;
        if (!(o instanceof Line)) return false;
        Line that = (Line) o;

        Line test = this;
        // Check point 1

        if ( (this.point1 instanceof Point) && (that.point1 instanceof Point) )
        {
            if(!this.point1.equals(that.point1))
                return false;
        }
        else if(this.point1 == null &&  that.point1 == null){
            //they are valid
        }
        else if(this.point2 == null || that.point2 == null)
        {
            return false;
        }
        
        // Check point 2
        if ( (this.point2 instanceof Point) && (that.point2 instanceof Point) )
        {
            if(!this.point2.equals(that.point2))
                return false;
        }
        else if(this.point2 == null &&  that.point2 == null){
            //they are valid
        }
        else if(this.point2 == null || that.point2 == null)
        {
            return false;
        }

        // return true if no equality invalid
        return true;
     } 


     @Override
     /**
      * Creates a unique hashCode for the Line - two hashcodes will match if two Lines are equal
      * @return the hashcode 
      */
     public int hashCode() {
         final int prime = 13;
         int result = 1;
         result = prime * result + ((point1 == null) ? (-1) : point1.hashCode());
         result = prime * result + ((point2 == null) ? (-1) : point2.hashCode());
         return result; 
     }
}
