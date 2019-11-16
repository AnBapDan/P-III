package aula8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class GameWindow implements ActionListener {
	@SuppressWarnings("unused")
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
	private JLabel moneyMark;
	private JPanel imageBox;
	private JPanel questionBox;
	private JPanel answers;
	private JPanel btns;
	private boolean nextQuestion=false;
	private int numQst=0;
	private boolean answered=false;
	
	
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
		gameBox.setSize(1000,750);
		gameBox.setLayout(new GridLayout(2,2));
		gameBox.setLocationRelativeTo(null);		
		gameBox.setVisible(true);
		JPanel[][] panelHolder = new JPanel[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				panelHolder[i][j]=new JPanel();
				gameBox.add(panelHolder[i][j]);
			}
		}
		
			
		imageBox = panelHolder[0][0];
		BufferedImage buff1 = null, buff2 = null;
		try {
			buff1 = ImageIO.read(new File("qqsm_material/img0.png"));
			buff2 = ImageIO.read(new File("qqsm_material/img1.png"));
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Image img1 = buff1.getScaledInstance(imageBox.getWidth(), imageBox.getHeight(), Image.SCALE_SMOOTH);
		Image img2 = buff2.getScaledInstance(imageBox.getWidth(), imageBox.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon();
		JLabel img = new JLabel(); 
		imageBox.add(img);
		gameBox.add(imageBox);
		
		questionBox = panelHolder[0][1];
		SpringLayout sl = new SpringLayout();
		questionBox.setLayout(sl);
		Border blackline = BorderFactory.createLineBorder(Color.black);
//		JPanel qbox2 = new JPanel();
//		qbox2.setBorder(blackline);
//		qbox2.setPreferredSize(new Dimension(300,150));
//		sl.putConstraint(SpringLayout.EAST, qbox2, -50, SpringLayout.EAST, questionBox);
//		sl.putConstraint(SpringLayout.NORTH, qbox2, 50, SpringLayout.NORTH, questionBox);
		question = new JLabel();
		question.setFont(new Font("Arial", Font.PLAIN, 20));
		question.setBorder(blackline);
		sl.putConstraint(SpringLayout.NORTH, question, 200, SpringLayout.NORTH, questionBox);
		
		moneyMark = new JLabel();
		moneyMark.setVerticalAlignment(SwingConstants.TOP);
		moneyMark.setHorizontalAlignment(SwingConstants.RIGHT);
		questionBox.add(moneyMark);
//		questionBox.add(qbox2);
//		qbox2.add(question)
		questionBox.add(question);
		gameBox.add(questionBox);
		
		answers = panelHolder[1][0];
		answers.setLayout(new GridLayout(3,3));
		JPanel[][]ansHolder=new JPanel[3][3]; 
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				ansHolder[i][j]=new JPanel();
				answers.add(ansHolder[i][j]);
			}
		}
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
		audienceHelp.addActionListener(this);
		phoneHelp.addActionListener(this);
		halfHelp.addActionListener(this);
		ansHolder[0][0].add(audienceHelp);
		ansHolder[0][1].add(phoneHelp);
		ansHolder[0][2].add(halfHelp);
		ansHolder[1][0].add(ans1);
		ansHolder[1][2].add(ans2);
		ansHolder[2][0].add(ans3);
		ansHolder[2][2].add(ans4);
		gameBox.add(answers);
		
		btns = panelHolder[1][1];
		btns.setLayout(new GridLayout(3,1));
		JPanel[][] btnHolder = new JPanel[3][1];
		for(int i=0;i<3;i++) {
			for(int j=0;j<1;j++) {
				btnHolder[i][j] = new JPanel();
				btns.add(btnHolder[i][j]);
			}
		}
		quit.addActionListener(this);
		confirm.addActionListener(this);
		btnHolder[2][0].setLayout(new FlowLayout());
		btnHolder[2][0].add(quit);
		btnHolder[2][0].add(confirm);
		gameBox.add(btns);
		while(!nextQuestion) {
			nextQuestion=false;
			question.setText("<html><p>"+this.getGame().getQst()[numQst]+"</p></html>");
			ans1.setText(this.getGame().getCh()[numQst*4]);
			ans2.setText(this.getGame().getCh()[(numQst*4)+1]);
			ans3.setText(this.getGame().getCh()[(numQst*4)+2]);
			ans4.setText(this.getGame().getCh()[(numQst*4)+3]);
			moneyMark.setText(money[numQst]+"€");
			if(numQst%2==0) {
				image = new ImageIcon(img1);
				img.setIcon(image);
			}
			else {
				image = new ImageIcon(img2);
				img.setIcon(image);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent x) {
		Object btn = x.getSource();
		if(btn.equals(ans1)) {
			ans1.setSelected(true);
			ans2.setSelected(false);
			ans3.setSelected(false);
			ans4.setSelected(false);
			answered=true;
		}
		else if(btn.equals(ans2)) {
			ans1.setSelected(false);
			ans2.setSelected(true);
			ans3.setSelected(false);
			ans4.setSelected(false);
			answered=true;
		}
		else if(btn.equals(ans3)) {
			ans1.setSelected(false);
			ans2.setSelected(false);
			ans3.setSelected(true);
			ans4.setSelected(false);
			answered=true;
		}
		else if(btn.equals(ans4)) {
			ans1.setSelected(false);
			ans2.setSelected(false);
			ans3.setSelected(false);
			ans4.setSelected(true);
			answered=true;
		}
		else if(btn.equals(confirm) && answered) {
			answered = false;
			if(ans1.isSelected() && checkAnswer(ans1.getText())) {
				numQst++;
				nextQuestion=true;
				if(this.getGame().getQst()[numQst]==null) {
					JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst-1]+"€!");
					System.exit(0);
				}
			}
			else if(ans2.isSelected() && checkAnswer(ans2.getText())) {
				numQst++;
				nextQuestion=true;
				if(this.getGame().getQst()[numQst]==null) {
					JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst-1]+"€!");
					System.exit(0);
				}
			}
			else if(ans3.isSelected() && checkAnswer(ans3.getText())) {
				numQst++;
				nextQuestion=true;
				if(this.getGame().getQst()[numQst]==null) {
					JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst-1]+"€!");
					System.exit(0);
				}
			}
			else if(ans4.isSelected() && checkAnswer(ans4.getText())) {
				numQst++;
				nextQuestion=true;
				if(this.getGame().getQst()[numQst]==null) {
					JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst-1]+"€!");
					System.exit(0);
				}
			}
			else {
				if(numQst==0)JOptionPane.showMessageDialog(null,"Ganhou "+money[numQst]+"€!");
				else JOptionPane.showMessageDialog(null,"Ganhou "+money[numQst-1]+"€!");
				System.exit(0);
			}
			deselect();
		}
		else if(btn.equals(quit)) {
			if(numQst==0)JOptionPane.showMessageDialog(null,"Ganhou "+money[numQst]+"€!");
			else JOptionPane.showMessageDialog(null,"Ganhou "+money[numQst-1]+"€!");
			System.exit(0);
		}
		else if(btn.equals(halfHelp)) {
			halfHelpButton();
		}
		else if(btn.equals(phoneHelp)) {
			phoneHelpButton();
		}
		else if(btn.equals(audienceHelp)) {
			audienceHelpButton();
		}
	}
	private void deselect() {
		ans1.setSelected(false);
		ans2.setSelected(false);
		ans3.setSelected(false);
		ans4.setSelected(false);
	}
	
	private void audienceHelpButton() {
		LinkedList<JRadioButton> group = new LinkedList<JRadioButton>();
		group.add(ans1);
		group.add(ans2);
		group.add(ans3);
		group.add(ans4);
		int cont=0;
		int[] percentage = new int[4]; 
		double a =Math.random();
		percentage[3] = (int) (100-(numQst+1)*6*a);
		percentage[1] = makeRound(Math.random()*2);
		percentage[2] = makeRound(Math.random()*2);
		percentage[0] = makeRound(Math.random()*2);
		while(percentage[1]+percentage[2]+percentage[0]>100-percentage[3]) {
			percentage[1]=(int)((100-percentage[3])/3);
			percentage[2]=percentage[1]+makeRound(Math.random()*2);
			percentage[0]=percentage[1]-makeRound(Math.random()*2);
		}
		String message = "";
		
		for(int i=0;i<group.size();i++) {
			if(checkAnswer(group.get(i).getText())){
				message += group.get(i).getText()+":"+percentage[3]+"%\n";
			}
			else {
				message += group.get(i).getText()+":"+percentage[cont]+"%\n";
				cont++;
			}
			
		}
		JOptionPane.showMessageDialog(null,message);
		audienceHelp.setEnabled(false);
	}
	
	private void phoneHelpButton() {
		LinkedList<JRadioButton> group = new LinkedList<JRadioButton>();
		group.add(ans1);
		group.add(ans2);
		group.add(ans3);
		group.add(ans4);
		int rand1 = makeRound(Math.random()*2);
		JRadioButton rjb = null;
		for(int i=0;i<group.size();i++) {
			if(checkAnswer(group.get(i).getText())) {
				rjb = group.get(i);
				group.remove(i);
			}
		}
		double a =Math.random();
		int percentage1 = (int) (100-(numQst+1)*6*a);
		int percentage2 = (int) (Math.random()*(numQst+3));
		if(percentage2>100-percentage1)percentage2=100-percentage1;
		JOptionPane.showMessageDialog(null,"Dúvida entre:\n"+
											rjb.getText()+":"+percentage1+"%\n"+
											group.get(rand1).getText()+":"+percentage2+"%");
		phoneHelp.setEnabled(false);
	}
	
	private void halfHelpButton() {
		LinkedList<JRadioButton> group = new LinkedList<JRadioButton>();
		group.add(ans1);
		group.add(ans2);
		group.add(ans3);
		group.add(ans4);
		int rand1,rand2;
		do {
			rand1 = makeRound(Math.random()*2);
			rand2 = makeRound(Math.random()*2);
		}
		while(rand1==rand2);
		for(int i=0;i<group.size();i++) {
			if(checkAnswer(group.get(i).getText())) {
				group.remove(i);
				group.get(rand1).setEnabled(false);
				group.get(rand2).setEnabled(false);
			}
		}
		halfHelp.setEnabled(false);
	}
	
	private int makeRound(double num) {
		if(num>=1.5) {
			return 2;
		}
		else if (num<1.5 && num>=0.5) {
			return 1;
		}
		else if(num<0.5) {
			return 0;
		}
		return -1;
	}
	
	private boolean checkAnswer(String text) {
		return text.equalsIgnoreCase(this.getGame().getAns()[numQst]);
	}
}
