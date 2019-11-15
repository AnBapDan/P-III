package aula8;

import java.io.*;
import java.util.*;

public class QQSM {
	static File quiz;
	static Scanner sc;
	String[] qst = new String[15];;
	String[] ch = new String[60];
	String[] ans = new String[15];
	
	public QQSM() {
		int cont=0;
		String[] lines = new String[15];
		if(!quiz.exists()) lines = load();
		else {
			if(sc.hasNextLine()) {
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					lines[cont] = line;
					cont++;
				}
			}
		}
		for(int i=0;i<lines.length;i++) {
			if(lines[i]==null)break;
			String[] spl = lines[i].split("->");
			this.qst[i]=spl[0];
			cont=i*4;
			this.ch[cont]=spl[1];
			this.ch[cont+1]=spl[2];
			this.ch[cont+2]=spl[3];
			this.ch[cont+3]=spl[4];
			this.ans[i]=spl[5];
		}
		
	}
	
	public String[] getQst() {
		return qst;
	}

	public String[] getCh() {
		return ch;
	}

	public String[] getAns() {
		return ans;
	}

	private String[] load() {
		return null;
	}
	
	static {
		try {
			quiz = new File("qqsm.txt");
			if(quiz.exists()) {
				try {
					sc = new Scanner(quiz);
				} catch (FileNotFoundException e) {
					try {
						quiz.createNewFile();
					}
					catch(IOException e1) {
						System.out.print("ERROR: "+e1.getMessage()+"!\n");
						System.out.print(1);
					}
				}
			}
		}
		catch(NullPointerException f) {
			try {
				quiz.createNewFile();
			} catch (IOException e) {
				System.out.print("ERROR: "+e.getMessage());
				System.exit(1);
			}
		}
	}
}
