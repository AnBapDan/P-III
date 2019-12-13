package aula12.plgs12_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import aula12.Agenda;
import aula12.Data;
import aula12.Pessoa;

public class vCard implements Agenda{
	
	private Stack <String[]> contacts = new Stack<>();
	private LinkedList<Pessoa>P = new LinkedList<>();
	public vCard(String fileName) throws IOException {
		readFile(fileName);
		loadPerson();
		writeFile();
	}
	
	
	public void readFile(String fileName) throws FileNotFoundException {
		String[] p = new String[3];
		File f = new File(fileName);
		Scanner sc = new Scanner(f);
		
		sc.nextLine();
		
		while(sc.hasNextLine()) {
			String tmp= sc.nextLine();
			p= tmp.split("\t");
		contacts.add(p);
	}
	sc.close();	
		
	}
	public void loadPerson() {
		while(!contacts.isEmpty()) {
			String[] load = contacts.pop();
			
			Data d = splitData(load[3]);
			Pessoa p = new Pessoa(load[1],Integer.parseInt(load[2]),d);
			P.add(p);
		}	
	}
	
	private Data splitData(String string) {
		String[]d = string.split("/");
		if(d.length != 3) {
			System.out.print("Invalid data. Exiting...");
			System.exit(1);
		}
		
		int[] data= new int[d.length];
		for(int i = 0; i<d.length;i++) {
			data[i]= Integer.parseInt(d[i]);
		}

		
		return new Data(data[0],data[1],data[2]);
	}
	
	public void writeFile() throws IOException {
		PrintWriter w = new PrintWriter("CSVList_copy.txt");
		w.println("CSV");
		for(int i =0; i< contacts.size(); i++) {
			w.print("#");
			w.print(P.get(i).nome());
			w.print("#");
			w.print(P.get(i).cc());
			w.print("#");
			w.println(P.get(i).dataNasc());
		}
		w.close();
	}
}
