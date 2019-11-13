package aula1;

public class Circulo {
	private double raio;
	private Ponto centro;
	
	public Circulo(double x, double y, double r) {
		assert r>=0 : "O raio tem de ser igual ou maior que 0";
		centro = new Ponto(x,y);
		this.raio = r;	
	}
	
	public Circulo(Ponto centro, double r) {
		assert r>=0 : "O raio tem de ser igual ou maior que 0";
		this.centro = centro;
		this.raio = r;
	}
	public double raio() {
		return raio;
	}
	
	public Ponto centro() {
		return centro;
	}
	
	private double area() {
		double area = Math.pow(raio, 2) * 3.14; //Math.PI
		return area;
	}
	
	private double perimeter() {
		double p = 2*raio*3.14; //Math.PI
		return p;
	}
	public String toString() {	
		return "O Circulo de centro "+centro.toString()+" tem de area "+area()+" e tem de perimetro "+perimeter();
	}
	
	public boolean equalCircles(Circulo b) {
		return raio()== b.raio();
	}
	
	public boolean intCircles(Circulo b) {
		Ponto c2 = b.centro();
		double r2 = b.raio();		
		double dist = Math.sqrt(Math.pow(c2.x()-centro.x(),2)+Math.pow(c2.y()-centro.y(), 2));
		double sRaios = raio()+r2;
		
		return sRaios >= dist;
	}
	
}
