package aula6;

public class Retangulo extends Figura {

	public Retangulo(double x1, double y1, double x2, double y2) {
		super(x1,y1,x2,y2);
		
	}

	public Retangulo(double i, double j) {
		super(0,0,i,j);
	}

	public Retangulo(Retangulo r2) {
		super(r2.getP1(),r2.getl1(),r2.getl2());
	}

	public double area() {
		double area = (getl1()*getl2());
		return Math.abs(area);
	}

	public double perimetro() {
		double p = 2*getl1() + 2*getl2();
		return Math.abs(p);
	}
	
	public String toString() {
		return "Rectangulo de Centro x:"+getP1().x()+", y:"+getP1().y()+", altura "+getl2()+", comprimento "+getl1();
	}
	
}