package aula5;

import aula5.Const.Color;
import aula5.Const.Emergency;

public class MotoPolicia extends Moto implements Policia{
	private Const.Emergency tipo;
	
	public MotoPolicia(int ano, int nRodas, int velMax, Color color, String matricula, int cilindrada, int potencia,
			int consumo, int combustivel, Emergency tipo) {
		super(ano, nRodas, velMax, color, matricula, cilindrada, potencia, consumo, combustivel);
		this.tipo=tipo;
	}

	public Emergency getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Tipo: "+this.getTipo();
	}
}
