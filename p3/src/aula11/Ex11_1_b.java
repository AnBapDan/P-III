package aula11;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex11_1_b {

	static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		System.out.print("Caminho para o ficheiro a ser lido: ");
		String path = sc.next();
		File f = new File(path);
		Set<String> set = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		List<String> lista= Files.readAllLines(f.toPath());
		List<List<String>> words = lista.stream().map(s -> List.of(s.split(" "))).collect(Collectors.toList());
		words.stream().flatMap(s -> s.stream()).forEach(str -> set.add(str));
		words.stream().flatMap(line -> line.stream()).forEach(s -> list.add(s));
		System.out.println("Numero de palavras: "+list.size());
		System.out.println("Numero de palavras diferentes: "+set.size());
	}

}
