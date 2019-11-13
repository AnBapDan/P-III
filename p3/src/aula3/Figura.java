package aula3;

public class Figura{
	private Ponto p1, p2;
	
	public Figura() {
		
	}
	
	public Figura(Ponto p1, Ponto p2) {
		this.p1=p1;
		this.p2=p2;	
	}

	public Figura(double a, double b, double i, double i2) {
		this.p1 = new Ponto (a,b);
		this.p2 = new Ponto (i,i2);
	}

	/*Areas e perimetros*/
	public double area() {
		double area = (getP2().x()-getP1().x())*(getP2().y()-getP1().y());	//(x2-x1)*(y2-y1)
		return Math.abs(area);
	}

	public double perimetro() {
		double p = 2*(getP2().x()-getP1().x()) + 2*(getP2().y()-getP1().y());//2(x2-x1) + 2(y2-y1)
		return Math.abs(p);
	}


	/*Outros*/
	public Ponto getP1() {
		return p1;
	}


	public Ponto getP2() {
		return p2;
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
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		return true;
	}
}
