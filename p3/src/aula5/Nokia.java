package aula5;

import java.io.*;
import java.util.*;



public class Nokia implements Agenda{
	private Stack <String[]> contacts = new Stack<>();
	private LinkedList<Pessoa>P = new LinkedList<>();
	
	public Nokia(String fileName) throws IOException {
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
			for(int i=0; i<p.length;i++) {
				p[i]= sc.nextLine();
			}
			contacts.add(p);
			try {
				sc.nextLine();
			}catch(Exception e) {}
		}
		sc.close();
	}
	
	public void loadPerson() {
		while(!contacts.isEmpty()) {
			String[] load = contacts.pop();
			
			Data d = splitData(load[2]);
			Pessoa p = new Pessoa(load[0],Integer.parseInt(load[1]),d);
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
		PrintWriter w = new PrintWriter("NokiaList_copy.txt");
		w.println("Nokia");
		for(int i =0; i< contacts.size(); i++) {
			w.println(P.get(i).nome());
			w.println(P.get(i).cc());
			w.println(P.get(i).dataNasc());
			w.println();
		}
		w.close();
	}
	
	
	
	
	
	
}
