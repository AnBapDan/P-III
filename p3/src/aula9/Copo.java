package aula9;

public class Copo extends GeladoDecorator{
	
	public Copo(Gelado g) {
		super(g);
	}
	
	public void base(int num) {
		g.base(num);
		System.out.print(" em copo");
	}

}
