package aula13;

public class Regiao {
	private String name;
	private int popSize;
	
	public Regiao(String name,int popSize) {
		this.name=name;
		this.popSize=popSize;
	}

	public String getName() {
		return name;
	}

	public int getPopSize() {
		return popSize;
	}
	
	@Override
	public String toString() {
		return name+", Populacao: "+popSize;
	}
}
