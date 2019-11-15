package aula8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;

public class GameWindow implements ActionListener {
	private static final long serialVersionUID = 1L;
	private QQSM game;
	private JRadioButton ans1;
	private JRadioButton ans2;
	private JRadioButton ans3;
	private JRadioButton ans4;
	private JButton quit = new JButton("Desistir");
	private JButton confirm = new JButton("Confirmar");
	private JButton audienceHelp = new JButton("Ajuda Publico");
	private JButton phoneHelp = new JButton("Telefone");
	private JButton halfHelp = new JButton("50-50");
	private JLabel question; 
	private static final int[] money = { 25, 50, 125, 250, 500, 750, 1500, 2500, 5000, 10000, 16000, 32000, 64000, 125000, 250000};
	private JPanel imageBox;
	private JPanel questionBox;
	private JPanel answers;
	private JPanel btns;
	private int level=1;
	private boolean nextQuestion=false, answered=false,ctrl=false;;
	private int numQst=0;
	
	
	public GameWindow(QQSM game) {
		this.game=game;
		start();
	}
	
	public QQSM getGame() {
		return game;
	}
	
	public void start() {
		JFrame gameBox = new JFrame("Quem Quer Ser Milionário?");
		gameBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameBox.setSize(700,450);
		gameBox.setLayout(new GridLayout(2,2));
		gameBox.setLocationRelativeTo(null);		
		gameBox.setVisible(true);
		
			
		imageBox = new JPanel();
		gameBox.add(imageBox);
		
		questionBox = new JPanel();
		SpringLayout sl = new SpringLayout();
		questionBox.setLayout(new BorderLayout());
		Border blackline = BorderFactory.createLineBorder(Color.black);
		JPanel questionBox2 = new JPanel();
		questionBox2.setBorder(blackline);
		sl.putConstraint(SpringLayout.WEST, questionBox2, 50, SpringLayout.WEST, questionBox);
		question = new JLabel();
		question.setFont(new Font("Arial", Font.PLAIN, 20));
//		questionBox.add(questionBox2);
		questionBox.add(question,BorderLayout.CENTER);
		gameBox.add(questionBox);
		
		answers = new JPanel();
		answers.setLayout(new GridLayout(2,2));
		ans1 = new JRadioButton();
		ans2 = new JRadioButton();
		ans3 = new JRadioButton();
		ans4 = new JRadioButton();
		ans1.setFont(new Font("Arial", Font.PLAIN, 15));
		ans2.setFont(new Font("Arial", Font.PLAIN, 15));
		ans3.setFont(new Font("Arial", Font.PLAIN, 15));
		ans4.setFont(new Font("Arial", Font.PLAIN, 15));
		ans1.addActionListener(this);
		ans2.addActionListener(this);
		ans3.addActionListener(this);
		ans4.addActionListener(this);
		answers.add(ans1);
		answers.add(ans2);
		answers.add(ans3);
		answers.add(ans4);
		gameBox.add(answers);
		
		btns = new JPanel();
		quit.addActionListener(this);
		confirm.addActionListener(this);
		btns.add(quit);
		btns.add(confirm);
		gameBox.add(btns);
		int i=0;
		while(!nextQuestion) {
			nextQuestion=false;
			question.setText("<html><p>"+this.getGame().getQst()[numQst]+"</p></html>");
			ans1.setText(this.getGame().getCh()[numQst*4]);
			ans2.setText(this.getGame().getCh()[(numQst*4)+1]);
			ans3.setText(this.getGame().getCh()[(numQst*4)+2]);
			ans4.setText(this.getGame().getCh()[(numQst*4)+3]);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent x) {
		Object btn = x.getSource();
		if(btn == ans1) {
			ans1.setSelected(true);
			ans2.setSelected(false);
			ans3.setSelected(false);
			ans4.setSelected(false);
			answered=true;
		}
		else if(btn == ans2) {
			ans1.setSelected(false);
			ans2.setSelected(true);
			ans3.setSelected(false);
			ans4.setSelected(false);
			answered=true;
		}
		else if(btn == ans3) {
			ans1.setSelected(false);
			ans2.setSelected(false);
			ans3.setSelected(true);
			ans4.setSelected(false);
			answered=true;
		}
		else if(btn == ans4) {
			ans1.setSelected(false);
			ans2.setSelected(false);
			ans3.setSelected(false);
			ans4.setSelected(true);
			answered=true;
		}
		else if(btn == confirm) {
			if(ans1.isSelected() && ans1.getText().equals(this.getGame().getAns()[numQst])) {
				numQst++;
				nextQuestion=true;
				if(this.getGame().getQst()[numQst]==null) {
					JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst]+" Euros!");
					System.exit(0);
				}
			}
			else if(ans2.isSelected() && ans2.getText().equals(this.getGame().getAns()[numQst])) {
				numQst++;
				nextQuestion=true;
				if(this.getGame().getQst()[numQst]==null) {
					JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst]+" Euros!");
					System.exit(0);
				}
			}
			else if(ans3.isSelected() && ans3.getText().equals(this.getGame().getAns()[numQst])) {
				numQst++;
				nextQuestion=true;
				if(this.getGame().getQst()[numQst]==null) {
					JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst]+" Euros!");
					System.exit(0);
				}
			}
			else if(ans4.isSelected() && ans4.getText().equals(this.getGame().getAns()[numQst])) {
				numQst++;
				nextQuestion=true;
				if(this.getGame().getQst()[numQst]==null) {
					JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst]+" Euros!");
					System.exit(0);
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Ganhou "+money[numQst]+" Euros!");
				System.exit(0);
			}
		}
		else if(btn == quit) {
			JOptionPane.showMessageDialog(null,"Ganhou "+money[numQst]+" Euros!");
			System.exit(0);
		}
	}
}
