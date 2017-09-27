public class Parabola {
	
		//Point that is the focus of the Parabola
		public Point focus;
		//Point that is the vertex
		public Point vertex;
		//Line that is the directrix
		public Line directrix;
	
		/**
		 * Constructor for the Parabola
		 * @param f focus
		 * @param v vertex
		 * @param d directrix
		 */
		public Parabola(Point f, Point v, Line d)
		{
			this.focus = f;
			this.vertex = v;
			this.directrix = d;
		}
	
		/**
		 * Mirror the Parabola across the directrix line.  If any members are null, the parabola is left unchanged.
		 **/
		public void Mirror()
		{
			if(this.focus != null){
				this.focus.Mirror(this.directrix);
			}
			if(this.vertex != null){
				this.vertex.Mirror(this.directrix);
			}
			
		}
	
		/**
		 * Creates a vertical line through the center of the Parabola
		 * @return Line object through the vertex and the focus
		 */
		public Line FindCenter()
		{
			if (this.vertex != null && this.focus != null)
			{
				Line l = new Line(this.vertex,this.focus);
				return l;
			}
			Line l = null;
			return l;
		}
	
		@Override
		/**
		 * Checks if two Parabolas are equal - focus and vertex are equivalent Points and the directrix is an equivalent line
		 * @return true if everything is equivalent; a null Point/Line is considered equivalent to another null   
		 */
	
		public boolean equals(Object o) {
			if(this == null && o == null) return true;	
			if (o == null || this == null) return false;
			if (!(o instanceof Parabola)) return false;
			Parabola that = (Parabola) o;
						
			// Check the focus
			if(this.focus == null || that.focus == null)
			{
				if( !(this.focus == null && that.focus == null) )
					return false;					
			}
			else if( (this.focus instanceof Point) && (that.focus instanceof Point) )
			{
				if (!this.focus.equals(that.focus))
					return false;	
			}
			else
			{
				return false;
			}
	
			// Check the vertex
			if(this.vertex == null || that.vertex == null)
			{
				if( !(this.vertex == null && that.vertex == null) )
					return false;
			}
			else if ((this.vertex instanceof Point) && (that.vertex instanceof Point)) {
				if (!this.vertex.equals(that.vertex))
					return false;
			}
			else
			{
				return false;
			}
	
			// Check the directrix  
			if(this.directrix == null || that.directrix == null)
			{
				if( !(this.directrix == null && that.directrix == null) )
					return false;
			}
			else if ((this.directrix instanceof Line) && (that.directrix instanceof Line))
			{	
				if (!this.directrix.equals(that.directrix))
					return false;
			}
			else
			{
				return false;
			}

			// return true if no equality was invalid			
			return true;
	
		}
		@Override
		/**
		 * Creates a unique hashcode for the Parabola object - identical Parabolas should have the same hashcode
		 * @return int hashcode 
		 */
		public int hashCode() {
			final int prime = 17;
			int result = 1;
			result = prime * result + ((focus == null) ? 0 : focus.hashCode());
			result = prime * result + ((vertex == null) ? 0 : vertex.hashCode());
			result = prime * result + ((directrix == null) ? 0 : directrix.hashCode());
			return result;
		}
}
