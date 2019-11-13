package aula7;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Companhias {
	private String iniciais;
	private String companhia;
	
	Companhias(String f){
		String[] x =f.split("\t");
		this.iniciais=x[0];
		this.companhia = x[1];
	}

	public String getIniciais() {
		return iniciais;
	}

	public String getCompanhia() {
		return companhia;
	}
	
	public static LinkedList<Companhias> importarF(String path) throws IOException{
		List<String> linhas= Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		linhas.remove(0);
		LinkedList<Companhias> comp = new LinkedList<>();
		for(String linha: linhas) {
			Companhias Ncompanhia = new Companhias(linha);
			comp.add(Ncompanhia);
		}
		return comp;
	}
}
