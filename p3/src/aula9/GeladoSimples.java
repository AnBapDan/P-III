package aula9;

public class GeladoSimples implements Gelado{
	private String sabor;
	 
	public GeladoSimples(String sabor) {
		super();
		this.sabor=sabor;
	}
	
	public void base(int num) {
		String s = "\n"+num + " bolas de gelado de "+sabor;
		System.out.print(s);
	}
}
