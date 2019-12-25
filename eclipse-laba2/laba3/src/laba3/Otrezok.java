package laba3;

public class Otrezok {
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((x1 == null) ? 0 : x1.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		result = prime * result + ((y1 == null) ? 0 : y1.hashCode());
		return result;
	}

		public Integer x;
		public Integer y;
		public Integer x1;
		public Integer y1;
		
		@Override
		public boolean equals(Object b)
		{
			
			if (b == null || b.getClass() != this.getClass())
				return false;
			Otrezok a = (Otrezok) b;
			if (a.x == this.x && a.y == this.y && a.x1 == this.x1 && a.y1 == this.y1)
				return true;
			else
				return false;		
		}

}
