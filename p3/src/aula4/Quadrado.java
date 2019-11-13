package aula4;

public class Quadrado extends Figura {


	public Quadrado(double i) {
		super(0,0,i,i);
	}
	public Quadrado(double i, double j, double k) {
		super(i,j,k,k);
	}

	public Quadrado(Quadrado q2) {
		super(q2.getP1(),q2.getl1(),q2.getl2());
	}


	public String toString() {
		return "Quadrado de Centro "+getP1().x()+", "+getP1().y()+" e de lado "+getl1();
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