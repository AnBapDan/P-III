package aula12;

import aula5.Const.Color;

public class Automovel extends Motorizado{
	
	public Automovel(int ano, int nRodas, int velMax, Const.Color color, String matricula, int cilindrada, int potencia,
			int consumo, int combustivel) {
		super(ano, nRodas, velMax, color, matricula, cilindrada, potencia, consumo, combustivel);
	}

	@Override
	public String toString() {
		return "Automovel"+super.toString();
	}

}
