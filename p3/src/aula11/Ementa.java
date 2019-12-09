package aula11;

import java.util.*;

public class Ementa {
	private Hashtable<Const.DiaSemana, LinkedList<Prato>> pratos=new Hashtable<Const.DiaSemana, LinkedList<Prato>>();
	private String nome, local;
	
	public Ementa(String nome,String local) {
		this.nome=nome;
		this.local=local;
	}
	
	public Hashtable<Const.DiaSemana, LinkedList<Prato>> getPratos(){
		return pratos;
	}

	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}
	
	public void addPrato(Prato p, Const.DiaSemana d) {
		if(pratos.containsKey(d)) {
			pratos.get(d).add(p);;
		}
		else {
			LinkedList<Prato> tmp = new LinkedList<Prato>();
			tmp.add(p);
			pratos.put(d, tmp);
		}
	}
	
	@Override
	public String toString() {
		Const.DiaSemana[] keys = pratos.keySet().toArray(new Const.DiaSemana[0]);
		String s="";
		Arrays.sort(keys);
		for(Const.DiaSemana d : keys) {
			LinkedList<Prato> tmp = pratos.get(d);
			for(Prato p : tmp.toArray(new Prato[0])) {
				s+=p.toString()+", dia "+d.name()+"\n";
			}
		}
		return s;
	}
}











