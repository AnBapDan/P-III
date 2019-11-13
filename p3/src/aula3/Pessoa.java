package aula3;

import java.util.*;

public class Pessoa {
	private String nome;
	private int cc;
	private Data bday;
	
	public Pessoa(String nome, int cc, Data bday) {
		this.nome = nome;
		this.cc = cc;
		this.bday = bday;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCc() {
		return cc;
	}
	
	public Data getDNasc() {
		return bday;
	}
	
	@Override
	public String toString() {
		return this.getNome()+", BI: "+ this.getCc()+", Nasc. Data: " +this.getDNasc().dia()+"/"
				+this.getDNasc().mes()+"/"+this.getDNasc().ano();
	}
	
	public int getIdade() {
		Calendar cal = Calendar.getInstance();
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);
		int idade = 0;
		if(this.getDNasc().dia()<=dia) {
			if(this.getDNasc().mes()<=mes){
				idade=ano-this.getDNasc().ano();
			}
			else {
				idade=ano-this.getDNasc().ano()-1;
			}
		}
		else {
			if(this.getDNasc().mes()>=mes) {
				idade=ano-this.getDNasc().ano()-1;
			}
			else {
				idade=ano-this.getDNasc().ano();
			}
		}
		return idade;
	}
}
