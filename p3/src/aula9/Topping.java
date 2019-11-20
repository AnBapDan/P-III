package aula9;

public class Topping extends GeladoDecorator implements Gelado{
	
	private String top;
	
	public Topping(Gelado g,String top) {
		super(g);
		this.top=top;
	}
	
	public void base(int num) {
		g.base(num);
		System.out.print((top.equals(null)?"":" com "+top));
	}
	
}
