package aula13;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex13_2 {
	
	static Scanner sc = new Scanner(System.in);
	static LinkedHashMap<String,Integer> numPares;
	static TreeMap<String,Integer> sortedNumPares;
	
	public static void main(String[] args) throws IOException {
//		System.out.print("Introduza o path para o ficheiro a ler: ");
//		String path = sc.next();
		File f = new File("Policarpo.txt");
		
		numPares = new LinkedHashMap<String,Integer>();
		sortedNumPares = new TreeMap<String,Integer>();
		
		List<String> linhas = Files.readAllLines(f.toPath());
		
		String file = makeString(linhas);
		
		addPairs(file);
	
		sortedNumPares.putAll(numPares);
		
		print();
	}
	
	private static void print() throws IOException {
		String s = "",elem,comp="";
		String[] spl,spl1;
		for(String a:sortedNumPares.keySet().toArray(new String[0])) {
			System.out.println(a);
			elem="";
			spl = a.split(" ");
			if(comp.equals(spl[0]))continue;
			comp=spl[0];
			for(String b:sortedNumPares.keySet().toArray(new String[0])) {
				if(b.startsWith(comp)) {
					spl1 = b.split(" "); 
					elem += spl1[1]+"="+numPares.get(a)+" ";
				}
			}
			elem = elem.trim();
			elem = elem.replaceAll(" ", ", ");
			s += comp +"={"+elem+"}\n";
		}
		Files.write(Paths.get("output.txt"),s.getBytes());
	}
	
	
	private static void addPairs(String file) {
		String[] spl = file.split(" ");
		List<String> arr = new ArrayList<String>();
		for(String s:spl) {
			if(s.length()<3){continue;}
			arr.add(s);
		}
		for(int i=1;i<arr.size();i++) {
			String s = arr.get(i-1).toLowerCase()+" "+arr.get(i).toLowerCase();
			if(numPares.containsKey(s)) {
				int cont = numPares.get(s);
				cont++;
				numPares.put(s, cont);
			}
			else {
				numPares.put(s, 1);
			}
		}
	}
	
	private static String makeString(List<String> lista) {
		String s = "";
		for(String s1:lista) {
			s1 = s1.replaceAll("[^a-zA-Z0-9á-źÁ-Źà-ỳÀ-Ỳâ-ẑÂ-Ẑã-ỹÃ-Ỹç]", " ");
			s += s1 + " ";
		}
		return s.trim();
	}

}
