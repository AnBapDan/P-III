package aula5;

import aula5.Const.Color;

public class Bicicleta extends Veiculo{

	public Bicicleta(int ano, int nRodas, int velMax, Color color) {
		super(ano, nRodas, velMax, color);
	}
	
	@Override
	public String toString() {
		return "Bicicleta"+super.toString();
	}
}
