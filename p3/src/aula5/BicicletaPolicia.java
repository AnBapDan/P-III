package aula5;

import aula5.Const.Color;
import aula5.Const.Emergency;

public class BicicletaPolicia extends Bicicleta implements Policia{
	public static int num=1;
	private Const.Emergency tipo;

	public BicicletaPolicia(int ano, int nRodas, int velMax, Color color, Emergency tipo) {
		super(ano, nRodas, velMax, color);
		this.tipo = tipo;
	}

	public Const.Emergency getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Tipo: "+this.getTipo();
	}

}
