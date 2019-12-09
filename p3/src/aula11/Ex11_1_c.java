package aula11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex11_1_c {
	
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.print("Caminho para o ficheiro a ser lido: ");
		String path = sc.next();
		File f = new File(path);
		List<String> lista= Files.readAllLines(f.toPath());
		Hashtable<String,Integer> tab = new Hashtable<String,Integer>();
		Set<String> set = new HashSet<String>();
		List<List<String>> words =  lista.stream().map(s -> List.of(s.split(" "))).collect(Collectors.toList());
		words.stream().flatMap(list -> list.stream()).forEach(word -> { set.add(word);
																		if(!tab.containsKey(word)) {tab.put(word,1);}
																		else {
																			int i = tab.get(word);
																			i++;
																			tab.put(word, i);
																		}
																	});
		set.stream().forEach(s -> System.out.println(s + " - " + tab.get(s)));
	}

}
