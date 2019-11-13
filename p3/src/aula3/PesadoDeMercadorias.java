package aula3;

public class PesadoDeMercadorias extends Viatura{
	
	public PesadoDeMercadorias(int cilindrada, int potencia, int lotacao, int pesoBruto, Condutor c) {
		super(pesoBruto, pesoBruto, pesoBruto, pesoBruto, c);
	}
	
	@Override
	public String toString() {
		return "Pesado de Mercadoria"+super.toString();
	}
	
}
