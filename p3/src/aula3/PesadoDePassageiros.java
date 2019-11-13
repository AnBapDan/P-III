package aula3;

public class PesadoDePassageiros extends Viatura{
	
	public PesadoDePassageiros(int cilindrada, int potencia, int lotacao, int pesoBruto, Condutor c) {
		super(pesoBruto, pesoBruto, pesoBruto, pesoBruto, c);
	}

	
	@Override
	public String toString() {
		return "Pesado de Mercadorias"+super.toString();
	}
	
}
