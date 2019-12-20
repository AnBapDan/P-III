package aula13;

public class Provincia extends Regiao{
	private String governor;
	
	public Provincia(String name, int popSize, String governor) {
		super(name, popSize);
		this.governor = governor;
	}
	
	public String getGovernor() {
		return governor;
	}
}
