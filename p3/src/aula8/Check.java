package aula8;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
public class Check{
	public Check() {}
	private static int cont=0;
	
	
	public static void checkCont(int cont){		//verifica o numero de jogadas
		if(cont == 9) {
			JOptionPane.showMessageDialog(null,"Empatado!");
			System.exit(0);
		}
	}



	public static void winner(String v,JToggleButton[][] botoes) {
		if(checkUD(botoes)== true || checkLR(botoes)== true || checkD(botoes)==true) {
			JOptionPane.showMessageDialog(null,"O Vencedor é: "+v);
			System.exit(1);
		}
		
	}
	
	
	public static boolean checkUD(JToggleButton[][] botoes) {		//Verifica verticalmente
		
		for(int i =0; i< 3; i++) {
			if(botoes[0][i].getText().equals(botoes[1][i].getText())&& botoes[0][i].getText().equals(botoes[2][i].getText()) && !botoes[0][i].getText().equals("")) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkLR(JToggleButton[][] botoes) {		//Verifica horizontalmente
		
		for(int i =0; i< 3; i++) {
			if(botoes[i][0].getText().equals(botoes[i][1].getText()) && botoes[i][0].getText().equals(botoes[i][2].getText()) && !botoes[i][0].getText().equals("")) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkD(JToggleButton[][] botoes) {		//Verifica diagonais
		
		
			if(botoes[0][0].getText().equals(botoes[1][1].getText()) && botoes[0][0].getText().equals(botoes[2][2].getText()) && !botoes[1][1].getText().equals("")) {
				return true;
			} else if(botoes[0][2].equals(botoes[1][1]) && botoes[0][2].equals(botoes[2][0]) && botoes[1][1].getText().equals("")) {
				return true;
			}
			
			
		return false;
	}
}
