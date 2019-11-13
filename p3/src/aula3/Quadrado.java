package aula3;

public class Quadrado extends Figura {


	public Quadrado(double i) {
		super(0,0,i,i);
	}
	public Quadrado(double i, double j, double k) {
		super(i,j,k,k);
	}

	public Quadrado(Quadrado q2) {
		super(q2.getP1(),q2.getP2());
	}


	public String toString() {
		return "O Quadrado ";
	}

	public double area() {
		return super.area();
	}


}