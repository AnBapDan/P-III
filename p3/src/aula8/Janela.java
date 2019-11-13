package aula8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Janela implements ActionListener{
	private static JToggleButton[][] botoes = new JToggleButton[3][3];
	private int cont = 0;
	final String x = "X";
	final String o = "O";
	String pos;
	String pos2;
	public Janela(String player) {
		if(player== x) {
			pos = x;
			pos2=o;
		}else {
			pos=o;
			pos2=x;
		}
		
		janela();
	}
	
	
	public static JToggleButton[][] getBotoes() {
		return botoes;
	}
	
	public void janela() {
		JFrame frame = new JFrame("Jogo do Galo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);	//Obter coordenadas centrais do pc
		
		JPanel contentor =  (JPanel) frame.getContentPane();
		contentor.setBackground(Color.GRAY);
		contentor.setOpaque(true);
		contentor.setLayout(new GridLayout(3,3));
		
		
		for(int i = 0 ; i<3 ; i++) {
			for(int j= 0; j<3; j++) {
				botoes[i][j]= new JToggleButton("");
				botoes[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
				botoes[i][j].addActionListener(this);
				contentor.add(botoes[i][j]);
			}
		}	
	}
	


	
	@Override
	public void actionPerformed(ActionEvent x) {

		JToggleButton b = (JToggleButton) x.getSource();
		if(cont %2 == 0) {
			b.setText(pos);
			b.setEnabled(false);
			Check.winner(pos,getBotoes());
		}
		else {
			b.setText(pos2);
			b.setEnabled(false);
			Check.winner(pos2,getBotoes());
		}
		cont++;	

		Check.checkCont(cont);
	}


	
	

}
