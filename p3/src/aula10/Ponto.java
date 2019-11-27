package aula10;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double x() {
		return x;
	}
	
	public double y() {
		return y;
	}
	
	public String toString() {
		return "x:"+this.x+", y:"+this.y;
	}
	
	public double distTo(Ponto p) {
		double dist = Math.sqrt(Math.pow(p.x-this.x, 2) + Math.pow(p.y-this.y, 2));
		return dist;
	}
	
	public Ponto medio(Ponto p) {
		double x, y;
		x = (p.x-this.x)/2;
		y = (p.y-this.y)/2;
		Ponto d = new Ponto(x, y);
		return d;
	}
}
