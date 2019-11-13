package aula3;

public class Bolseiro extends Student{
	private int bolsa;

	public Bolseiro(String nome, int cc, Data bday) {
		super(nome, cc, bday);
		// TODO Auto-generated constructor stub
		this.bolsa=0;
	}

	public int getBolsa() {
		return bolsa;
	}

	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}
	
	@Override
	public String toString() {
		return super.toString() +", Bolsa: "+ this.getBolsa();
	}

}
