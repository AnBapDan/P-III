package aula13;

public class Estado extends Regiao{
	private Localidade stateCapital;

	public Estado(String name, int popSize, Localidade capital) {
		super(name, popSize);
		if(capital.getType()==TipoLocalidade.Cidade) {
			this.stateCapital = capital;
		}
		else {
			this.stateCapital=null;
			//throw new IllegalArgumentException("Capital Inválida");
		}
	}

	public Localidade getStateCapital() {
		return stateCapital;
	}
	
	
	
}
