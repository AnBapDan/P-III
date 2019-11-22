package aula9;

import java.util.*;

public class Data {
private int dia, mes, ano;
	
	public Data(int dia, int mes, int ano) {
		assert checkData(dia, mes, ano);
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
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
	
	public String toString() {
		return this.dia()+"-"+this.mes()+"-"+this.ano();
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
	
	public static Data today() {
		Calendar cal = Calendar.getInstance();
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);
		return new Data(dia, mes, ano);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (ano != other.ano)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}
}
