package aula1;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		assert mes>=1 && mes <=12 : "mes invalido" ;
		this.mes = mes;
		this.dia = dia;
		this.ano = ano;
		checkDia();
	}
	
	private void checkDia() {
		int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		assert this.dia >=1 : "dia invalido";
		if(this.mes== 2 && bissexto(this.ano) == false) {
			assert this.dia <=28 :  "dia invalido";
		}
		else if(this.mes== 2 && bissexto(this.ano) == true) {
			assert this.dia <=29 : "dia invalido";
		}
		else {
			assert this.dia <= diasMes[this.mes-1] :  "dia invalido";
		}
		
	}
	
	
	public int dia() {
		return dia;
	}
	
	public int mes() {
		return mes;
	}
	
	public int ano() {
		return ano;
	}
	
	public String toString()
	{
		return this.dia+"-"+this.mes+"-"+this.ano;
	}
	private static boolean bissexto(int ano) {
		return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
	}

}
