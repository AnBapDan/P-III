package aula2;

public class Data {
	private int dia, mes, ano;	
	
	public Data(int dia, int mes, int ano) {
		assert checkData(dia, mes, ano);
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public String toString() {
		return this.getDia()+"-"+this.getMes()+"-"+this.getAno();
	}
	
	public boolean checkData(int dia, int mes, int ano) {
		if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) {
			if(dia<=31 && dia>=1) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(mes==4 || mes==6 || mes==9 || mes==11) {
			if(dia<=30 && dia>=1) {
				return true;
			}
			else{
				return false;
			}
		}
		else if(mes==2) {
			if(bissexto(ano)) {
				if(dia<=29 && dia>=1) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if(dia<=28 && dia>=1) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
	}
	
	private boolean bissexto(int ano) {
		assert ano >= 0;
		if(ano%4==0 && ano%100!=0 || ano%400==0) {
			return true;
		}
		else {
			return false;
		}
	}
}
