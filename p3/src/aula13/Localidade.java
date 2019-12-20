package aula13;

public class Localidade extends Regiao{
	private TipoLocalidade type;
	
	public Localidade(String name, int popSize, TipoLocalidade type) {
		super(name,popSize);
		this.type=type;
	}

	public TipoLocalidade getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type+" "+super.toString();
	}
}
