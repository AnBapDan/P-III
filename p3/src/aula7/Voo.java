package aula7;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Voo {
	private Hour hour;
	private String nome;
	private String origem;
	private Hour atraso;
	
	
	Voo(String a){
		String[] b = a.split("\t");
		
		this.hour= new Hour(b[0]);
		this.nome = b[1];
		this.origem = b[2];
		try {
			this.atraso = new Hour(b[3]);	
		}catch(IndexOutOfBoundsException e) {
			this.atraso = null;
		}
		
	}

	public Hour getHour() {
		return hour;
	}

	public String getNome() {
		return nome;
	}

	public String getOrigem() {
		return origem;
	}


	public Hour getAtraso() {
		return atraso;
	}


	public Hour getObs() {
		
		return Hour.obs(hour,atraso);
	}

	@Override
	public String toString() {
		return getHour()+"\t"+getNome() +"\t"+getOrigem()+"\t"+ getAtraso()+"\tPrevisto: "+getObs()+"\n";
	}

	public static LinkedList<Voo> importarF(String path) throws IOException{
		List<String> linhas= Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		linhas.remove(0);
		LinkedList<Voo> v = new LinkedList<>();
		for(String linha: linhas) {
			Voo v1 = new Voo(linha);
			v.add(v1);
		}
		return v;
	}
	

}
