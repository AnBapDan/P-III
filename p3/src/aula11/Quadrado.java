package aula11;

public class Quadrado extends Retangulo{
	public Quadrado(double i) {
		super(0,0,i,i);
	}
	public Quadrado(double i, double j, double k) {
		super(i,j,k,k);
	}
	
	public Quadrado(Ponto p1, double i) {
		super(p1,i,i);
	}

	public Quadrado(Quadrado q2) {
		this(q2.getP1().x(),q2.getP1().y(),q2.getl1());
	}


	public String toString() {
		return "Quadrado de Centro x:"+getP1().x()+", y:"+getP1().y()+" e de lado "+getl1();
	}

	public double area() {
		double area = (getl1()*getl2());
		return Math.abs(area);
	}

	public double perimetro() {
		double p = 2*getl1() + 2*getl2();
		return Math.abs(p);
	}
}
