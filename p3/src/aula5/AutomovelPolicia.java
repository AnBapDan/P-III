package aula5;

import aula5.Const.Color;
import aula5.Const.Emergency;

public class AutomovelPolicia extends Automovel implements Policia{
	private Const.Emergency tipo;
	
	public AutomovelPolicia(int ano, int nRodas, int velMax, Color color, String matricula, int cilindrada,
			int potencia, int consumo, int combustivel, Emergency tipo) {
		super(ano, nRodas, velMax, color, matricula, cilindrada, potencia, consumo, combustivel);
		this.tipo=tipo;
	}

	public Const.Emergency getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Tipo: "+this.getTipo();
	}
}
