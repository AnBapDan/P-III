package aula1;
import java.util.Scanner;


public class Ex1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a string a analisar: ");
		String input = sc.nextLine();
		System.out.println();
		int numbers = amntNum(input);
		if(numbers == 0) {
			System.out.println("a)Sem numeros detectados...");
			System.out.println();
			boolean verify = checkCase(input);
			msg(verify, input,0);
		}
		else {System.out.printf("a)Foram encontrados %d numeros na String fornecida: \n", numbers);
		}
		
		int words = amntWord(input);
		System.out.printf("d) Foram encontradas %s palavras\n", words);
		changeChars(input);
		sc.close();
		System.exit(0);
	}
	
	public static int amntNum(String input) {					//Counts the amount of numbers in the given String
		int count = 0;
		char a = ' ';
		for(int i = 0; i< input.length(); i++) {
			a=input.charAt(i);
			if(Character.isDigit(a)) {
				count++;
			}
		}
		return count;
	}
	
	
	public static int amntWord(String input) {					//Counts the number of Words 
		String[] Words = input.split(" ");
		for(int i=0; i< Words.length; i++) {
			System.out.printf("%s - %s \n", i+1, Words[i]);
		}
		return Words.length;
	}
	
	
	public static void msg (boolean verify, String input, int i) {
		if(verify == true) {
			if(Character.isWhitespace(input.charAt(i))) {
				i++;
				msg(true, input,i);
			}
			else if(Character.isUpperCase(input.charAt(i))) {
				System.out.println("b) Todas as letras são maiusculas");
				System.out.println();
			} 
			else {System.out.println("c) Todas as letras são minusculas");
			System.out.println();}
		}	
		else{System.out.println("b)c) A String inserida apresenta tanto maiusculas como minusculas");}		
	}
	
	
	private static boolean  checkCase(String input) {			//checks if the String as Lower and Upper char
		char letter =' ';
		char letter2= ' ';
		for(int i=0; i<input.length(); i++) {					//Search every char to see if it has some difference between letters
			if(Character.isWhitespace(input.charAt(i)) || Character.isDigit(input.charAt(i))) {		//Skips every WhiteSpace and numbers
				continue;
			}
			else {
				letter = input.charAt(i);
				try {
					letter2 = input.charAt(i+1);				//Tries to give a letter 
				}
				catch(Exception fim){				//Catch the end of the string and "exits"
					break;
				}
				
				if(Character.isWhitespace(letter2) ) {			//If letter2 is a White Space, it goes to the next letter
					continue;
				}	
			}
			if((Character.isUpperCase(letter)&&Character.isLowerCase(letter2)) || 
			   (Character.isUpperCase(letter2)&&Character.isLowerCase(letter)) ) { 	// If there's a difference between any two letters, it returns a "false"
				return false;
			}		
		}
		return true; 											//If the end is reached, return a true statement
	}


	private static void changeChars(String a) {
		String[]b = a.split(" ");
		String[]c = new String[b.length];
		int i=0;
		do {
			String change = "";
			char l1 =' ';
			char l2=' ';
			
			for(int j = 0; j < b[i].length(); j+=2) {		//loop two by two chars
				try {
					l1= b[i].charAt(j+1);
					l2= b[i].charAt(j);
					change= change + Character.toString(l1)+Character.toString(l2);
				}
				catch(Exception e) {						//if the number of chars is not a 2 multiple, it adds the last char of the original words
					change = change + b[i].charAt(b[i].length()-1);
				}
			c[i]= change;
			}
			i++;
		}while(i< b.length);
		
		System.out.println();
		System.out.printf("e)");
		for(int k=0; k< c.length; k++) {
			System.out.printf("%s ",b[k]); 
			System.out.printf("--> %s\n ",c[k]); //print the changed words
		}
		
	}
}
