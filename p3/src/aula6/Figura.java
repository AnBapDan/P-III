package aula6;

public abstract class Figura implements Comparable<Figura>{
	private Ponto p1;
	private double l1,l2;
	
	public Figura() {
		
	}
	
	public Figura(Ponto p1, double l1, double l2) {
		this.p1=p1;
		this.l1 =l1;
		this.l2=l2;
	}

	public Figura(double a, double b, double l1, double l2) {
		this.p1 = new Ponto (a,b);
		this.l1= l1;
		this.l2 = l2;
	}

	/*Areas e perimetros*/
	public abstract double area();

	public abstract double perimetro();


	/*Outros*/
	public Ponto getP1() {
		return p1;
	}


	public double getl1() {
		return l1;
	}
	
	public double getl2() {
		return l2;
	}

	/*Igualdades*/	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		if (Double.doubleToLongBits(getl1()) != Double.doubleToLongBits(other.getl1()))
			return false;
		if (Double.doubleToLongBits(getl2()) != Double.doubleToLongBits(other.getl2()))
			return false;
		if (getP1() == null) {
			if (other.p1 != null)
				return false;
		} else if (!getP1().equals(other.getP1()))
			return false;
		return true;
	}
	
	
	public int compareTo( Figura a) {
		if(a == null || this == null) {
			throw new NullPointerException("Figura null");
		}
		if(this.area() > a.area()) {
			return 1;
		}
		else if(this.area()<a.area()) {
			return -1;
		}
		return 0;
	}


}
