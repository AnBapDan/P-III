package aula3;

import aula3.Carta.Tipo;

public class Condutor extends Pessoa{
	private Carta.Tipo tipo;

	public Condutor(String nome, int cc, Data bday, Tipo tipo) {
		super(nome, cc, bday);
		this.tipo = tipo;
	}

	public Carta.Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Carta.Tipo tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return super.toString() + "\nCarta: "+this.getTipo();
	}

}
