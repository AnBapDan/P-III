package aula1;

public class Rectangulo {
	private Ponto p1;
	private Ponto p2;
	
	public Rectangulo(Ponto p1, Ponto p2) {
		this.p1= p1;
		this.p2= p2;
		assert p2 != p1: "Os dois pontos dados são o mesmo";
		assert (p2.x() != p1.x()) ||(p2.y() != p1.y()): "Os dois pontos formam uma linha. Os dois pontos devem ser extremos opostos do rectangulo.";
		
	}
	
	public Rectangulo(double x1, double y1, double x2, double y2) {
		p1 = new Ponto(x1, y1);
		p2 = new Ponto(x2, y2);
		assert p2 != p1: "Os dois pontos dados são o mesmo";
		assert (p2.x() != p1.x()) ||(p2.y() != p1.y()): "Os dois pontos formam uma linha. Os dois pontos devem ser extremos opostos do rectangulo.";
		
	}
	
	private double area() {
		double area = (p2.x()-p1.x())*(p2.y()-p1.y());
		return Math.abs(area);
	}
	
	private double perimeter() {
		double p = 2*(p2.x()-p1.x()) + 2*(p2.y()-p1.y());
		return Math.abs(p);
	}
	
	public String toString() {	
		return "O Rectangulo de extremos "+p1.toString()+" e "+p2.toString()+" tem de area "+area()+" e tem de perimetro "+perimeter();
	}
	

}
