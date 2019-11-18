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
	private JFrame gameBox;
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
	private boolean answered=false,ctrl=false,lastQuestion=true;;
	private String[] qst,ch,ans;
	
	
	public GameWindow(QQSM game) {
		this.game=game;
		this.qst = this.getGame().getQst();
		this.ch = this.getGame().getCh();
		this.ans = this.getGame().getAns();
		start();
	}
	
	public QQSM getGame() {
		return game;
	}
	
	public void start() {
		gameBox = new JFrame("Quem Quer Ser Milionário?");
		gameBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameBox.setSize(1000,750);
		gameBox.setLayout(new GridLayout(2,2));
		gameBox.setLocationRelativeTo(null);		
		gameBox.setVisible(true);
		gameBox.setBackground(Color.white);
		JPanel[][] panelHolder = new JPanel[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				panelHolder[i][j]=new JPanel();
				gameBox.add(panelHolder[i][j]);
			}
		}
		
			
		imageBox = panelHolder[0][0];
		SpringLayout sp = new SpringLayout();
		imageBox.setLayout(sp);
		imageBox.setPreferredSize(new Dimension(450,300));
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
		sp.putConstraint(SpringLayout.WEST, img, 30, SpringLayout.WEST, imageBox);
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
		question.setPreferredSize(new Dimension(300,200));
		sl.putConstraint(SpringLayout.NORTH, question, 150, SpringLayout.NORTH, questionBox);
		sl.putConstraint(SpringLayout.WEST, question, 20, SpringLayout.WEST, questionBox);
		
		moneyMark = new JLabel();
		moneyMark.setPreferredSize(new Dimension(100,50));
		sl.putConstraint(SpringLayout.WEST, moneyMark, 450, SpringLayout.WEST, questionBox);
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
//		for(String s:qst)System.out.println(s);
//		for(String s:ch)System.out.println(s);
//		for(String s:ans)System.out.println(s);
		int rnd1=0,rnd2=0,rnd3=0,rnd4=0;
		while(numQst!=14) {
//			System.out.println(numQst);
//			System.out.println(nextQuestion);
////			if(numQst==14 && nextQuestion) {
//				JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst-1]+"€!");
//				System.exit(0);
//		}
			nextQuestion=false;
			question.setText(qst[numQst]);
			do {
				rnd1 = getRnd();
				rnd2 = getRnd();
				rnd3 = getRnd();
				rnd4 = getRnd();
			}while(rnd1==rnd2 || rnd1==rnd3 || rnd1==rnd4 || rnd2==rnd3 || rnd2==rnd4 || rnd3==rnd4);
			if(!ctrl) {
				ans1.setText(ch[(numQst*4)+rnd1]);
				ans2.setText(ch[(numQst*4)+rnd2]);
				ans3.setText(ch[(numQst*4)+rnd3]);
				ans4.setText(ch[(numQst*4)+rnd4]);
				ctrl = true;
			}
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
		do {
//			System.out.println(numQst);
//			System.out.println(nextQuestion);
			do {
				rnd1 = getRnd();
				rnd2 = getRnd();
				rnd3 = getRnd();
				rnd4 = getRnd();
			}while(rnd1==rnd2 || rnd1==rnd3 || rnd1==rnd4 || rnd2==rnd3 || rnd2==rnd4 || rnd3==rnd4);
			question.setText("<html><p>"+qst[14]+"<br><br></p></html>");
			if(!ctrl) {
				ans1.setText(ch[(numQst*4)+rnd1]);
				ans2.setText(ch[(numQst*4)+rnd2]);
				ans3.setText(ch[(numQst*4)+rnd3]);
				ans4.setText(ch[(numQst*4)+rnd4]);
				ctrl = true;
			}
			
		}
		while(lastQuestion);
		JOptionPane.showMessageDialog(null,"Jogo Terminado!\nGanhou "+money[numQst-1]+"€!");
		System.exit(0);
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
				nextQuestion=true;
			}
			else if(ans2.isSelected() && checkAnswer(ans2.getText())) {
				nextQuestion=true;
			}
			else if(ans3.isSelected() && checkAnswer(ans3.getText())) {
				nextQuestion=true;
			}
			else if(ans4.isSelected() && checkAnswer(ans4.getText())) {
				nextQuestion=true;
			}
			else {
				if(numQst==0)JOptionPane.showMessageDialog(null,"Ganhou "+money[numQst]+"€!");
				else JOptionPane.showMessageDialog(null,"Ganhou "+money[numQst-1]+"€!");
				System.exit(0);
			}
			if(numQst==14 && nextQuestion)lastQuestion=false;
			if(nextQuestion && numQst!=14)numQst++;
			deselect();
			enable();
			ctrl=false;
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
	
	private void enable() {
		ans1.setEnabled(true);
		ans2.setEnabled(true);
		ans3.setEnabled(true);
		ans4.setEnabled(true);
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
		while(percentage[1]+percentage[2]+percentage[0]>100-percentage[3] || percentage[0]<0 || percentage[1]<0 || percentage[2]<0 || percentage[3]<0) {
			percentage[1]=(int)((100-percentage[3])/3);
			percentage[2]=percentage[1]+makeRound(Math.random()*2);
			percentage[0]=percentage[1]-makeRound(Math.random()*2);
		}
		String message = "";
		
		String c;
		for(int i=0;i<group.size();i++) {
			if(checkAnswer(group.get(i).getText())){
				c = cleanString(group.get(i).getText())+":"+percentage[3]+"%\n";
			}
			else {
				c = cleanString(group.get(i).getText())+":"+percentage[cont]+"%\n";
				cont++;
			}
			message+=c;
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
											cleanString(rjb.getText())+":"+percentage1+"%\n"+
											cleanString(group.get(rand1).getText())+":"+percentage2+"%");
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
	
	private int getRnd() {
		double num = Math.random()*3;
		if(num>=2.5) {
			return 3;
		}
		else if(num<2.5 && num>=1.5) {
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
		return text.equalsIgnoreCase(ans[numQst]);
	}
	
	private String cleanString(String s) {
		s = s.replaceAll("html", "");
		s = s.replaceAll(">", "");
		s = s.replaceAll("<", "");
		s = s.replaceAll("/", "");
		return s;
	}
}
