package aula5;

public class Circulo extends Figura {
	
	
	public Circulo(double x, double y, double r) {
		super(x,y,x,(y+r));
	}
	
	public Circulo(int i) {
		super(0,0,0,i);
	}

	
	public Circulo(Circulo c1) {
		super(c1.getP1(),c1.getl1(),c1.getl2());
	}

	
	public double area() {
		double area = Math.PI * Math.pow(getRaio(), 2);
		return (Math.round(area * 100) / 100.0);	
	}
	
	
	public double perimetro() {
		double perimetro = 2 * Math.PI * getRaio();
		return (Math.round(perimetro * 100) / 100.0);
	}
	
	public double getRaio() {
		return getl2()-getP1().y();	//raio = y2-y1;
	}
			 
	
	@Override
	public String toString() {
		
		return "Circulo de Centro x:"+getP1().x()+", y:"+getP1().y()+" e de raio "+getRaio();
	}
	

}
