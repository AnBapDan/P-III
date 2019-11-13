package aula3;

public class Circulo extends Figura {
	
	
	public Circulo(double x, double y, double r) {
		super(x,y,x,(y+r));
	}
	
	public Circulo(int i) {
		super(0,0,0,i);
	}

	
	public Circulo(Circulo c1) {
		super(c1.getP1(),c1.getP2());
	}

	
	@Override
	public double area() {
		double raio = ((this.getP2().y())-(this.getP1().y()));	//raio = y2-y1
		double area = Math.PI * Math.pow(raio, 2);
		return (Math.round(area * 100) / 100.0);
		
	}
	
	@Override
	public double perimetro() {
		double raio = ((this.getP2().y())-(this.getP1().y()));	//raio = y2-y1
		double perimetro = 2 * Math.PI * raio;
		return (Math.round(perimetro * 100) / 100.0);
	}
			 
	
	@Override
	public String toString() {
		return "O Circulo ";
	}
	

}
