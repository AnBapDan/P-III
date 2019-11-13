package aula3;

public class Viatura {
	private int cilindrada, potencia, lotacao, pesoBruto;
	private Condutor c;
	
	public Viatura(int cilindrada, int potencia, int lotacao, int pesoBruto, Condutor c) {
		super();
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.lotacao = lotacao;
		this.pesoBruto = pesoBruto;
		this.c = c;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getLotacao() {
		return lotacao;
	}

	public int getPesoBruto() {
		return pesoBruto;
	}

	public Condutor getCondutor() {
		return c;
	}

	@Override
	public String toString() {
		return " -> Condutor: "+this.getCondutor().toString()+"\nCilindrada: "+this.getCilindrada()
		+"\nPotência: "+this.getPotencia()+"\nLotação: "+this.getLotacao()+"\nPeso Bruto: "
		+this.getPesoBruto();
	}
}
