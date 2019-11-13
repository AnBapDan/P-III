package aula5;

import aula5.Const.Color;

public class Moto extends Motorizado{

	public Moto(int ano, int nRodas, int velMax, Color color, String matricula, int cilindrada, int potencia,
			int consumo, int combustivel) {
		super(ano, nRodas, velMax, color, matricula, cilindrada, potencia, consumo, combustivel);
	}

	@Override
	public String toString() {
		return "Moto"+super.toString();
	}

}
