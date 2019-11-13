package aula3;

public class Retangulo extends Figura {

	public Retangulo(double x1, double y1, double x2, double y2) {
		super(x1,y1,x2,y2);
		
	}

	public Retangulo(double i, double j) {
		super(0,0,i,j);
	}

	public Retangulo(Retangulo r2) {
		super(r2.getP1(),r2.getP2());
	}

	public double area() {
		return super.area();
	}
	
	public String toString() {
		return "O Retangulo ";
	}
	
}