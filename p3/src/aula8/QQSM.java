package aula8;

import java.io.*;
import java.util.*;

public class QQSM {
	static File quiz;
	static Scanner sc;
	String[] qst = new String[15];
	String[] ch = new String[60];
	String[] ans = new String[15];
	int[] seq1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14},seq2 = {0,14,1,13,2,12,3,11,4,10,5,9,6,8,7},
		  seq3 = {7,8,6,9,5,10,4,11,3,12,2,13,1,14,0},seq4 = {14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
	
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
		int[] seq = getSeq();
		String[] copy = lines;
		lines = new String[15];
		for(int i=0;i<copy.length;i++) {
			lines[i]=copy[seq[i]];
		}
//		QQSM.randLines(lines);
		for(int i=0;i<lines.length;i++) {
			if(lines[i]==null)break;
			String[] spl = lines[i].split("->");
			this.qst[i]="<html><p>"+spl[0]+"<br><br></p></html>";
			cont=i*4;
			this.ch[cont]="<html>"+spl[1]+"</html>";
			this.ch[cont+1]="<html>"+spl[2]+"</html>";
			this.ch[cont+2]="<html>"+spl[3]+"</html>";
			this.ch[cont+3]="<html>"+spl[4]+"</html>";
			this.ans[i]="<html>"+spl[5]+"</html>";
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
		String[] str=	{"Qual o número correspondente ao pH neutro?->5->10->7->13->7",
						"Qual o primeiro nome do vocalista do grupo Diabo na Cruz?->Jorge->Paulo->João->Bruno->Jorge",
						"Quantos distritos tem Portugal?->6->18->12->24->18",
						"Qual o valor em Celsius de zero absoluto?->-275->0->-130->130->-275",
						"Quantos bits tem um byte?->4->1->16->8->8",
						"Obikwelu praticava que modalidade?->Andebol->Atletismo->Futebol->Golf->Atletismo",
						"Um quadrado com √(2)  metros de comprimento tem quanto de área?->3->1->4->2->2",
						"Uma pessoa corre a 15km/h. Quanto tempo leva a percorrer 10km?->40min->50min->30min->60min->40min",
						"Na série \"The Simpsons\" como se chama o condutor do autocarro da escola?->John->Terry->Otto->Freddy->Otto",
						"Num jogo de hóquei, quantos elementos, de cada equipa, podem estar em campo?->5->7->8->11->5",
						"Qual a data da Batalha de Aljubarrota?->1385->1445->1259->1301->1385",
						"Tyrannosaurus Rex significa?->lagarto tirano rei->Tirano dos Répteis->Rei dos lagartos->Dinossauro tirano rei->Dinossauro tirano rei",
						"Fernando Pessoa desdobrava-se em quantas entidades literárias?->4->3->2->1->3",
						"Quem descobriu o raio-x?->Hermann von Helmholtz->Wilhelm Conrad Röntgen->Fernando Sanford->Nikola Tesla->Hermann von Helmholtz",
						"Qual é o número atómico do laurêncio?->103->40->99->15->99"};

		return str;
	}
	
	private int[] getSeq() {
		double num = Math.random()*3;
		if(num>=2.5) {
			return seq4;
		}
		else if(num<2.5 && num>=1.5) {
			return seq3;
		}
		else if (num<1.5 && num>=0.5) {
			return seq2;
		}
		else if(num<0.5) {
			return seq1;
		}
		return null;

	}
	
//	private static void randLines(String[] lines) {
//		int[]seq=new int[lines.length];
//		String[] s = lines;
//		int a;
//		for(int i=0;i<lines.length;i++) {
//			do {
//				a = (int) (Math.random()*(14));
//				seq[i]=a;
//			}
//			while(lines[a]==null && checkNumExists(seq));
//		}
//		for(int i=0;i<lines.length;i++) {
//			if(lines[i]==null)break;
//			lines[i]=s[seq[i]];
//		}
//	}
//	private static boolean checkNumExists(int[] num) {
//		for(int i=0;i<num.length-1;i++) {
//			for(int j=i;j<num.length;j++) {
//				if(num[i]==num[j])return true;
//			}
//		}
//		return false;
//	}
	
	static {
		try {
			quiz = new File("qqsm_material/qqsm.txt");
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
