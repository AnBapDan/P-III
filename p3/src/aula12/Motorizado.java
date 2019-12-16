package aula12;

public class Motorizado extends Veiculo{
	private String matricula;
	private int cilindrada, potencia, consumo, combustivel;
	
	public Motorizado(int ano, int nRodas, int velMax, Const.Color color, String matricula, int cilindrada, int potencia, int consumo, int combustivel) {
		super(ano, nRodas, velMax, color);
		this.matricula = matricula;
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.consumo = consumo;
		this.combustivel = combustivel;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getCilindrada() {
		return cilindrada;
	}
	
	public int getPotencia() {
		return potencia;
	}

	public int getConsumo() {
		return consumo;
	}

	public int getCombustivel() {
		return combustivel;
	}

	@Override
	public String toString() {
		return super.toString()+", Matricula: "+this.getMatricula()+", Cilindrada: "+this.getCilindrada()+", Potência: "+this.getPotencia()
		+", Consumo: "+this.getConsumo()+"/100km, Combustivel: "+this.getCombustivel();
	}
	
}
