package aula9;

public class Cone extends GeladoDecorator{

	public Cone(Gelado g) {
		super(g);
	}
	
	public void base(int num) {
		g.base(num);
		System.out.print(" em cone");
	}
}
