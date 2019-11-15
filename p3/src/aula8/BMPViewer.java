package aula8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BMPViewer implements ActionListener{
	JFrame window;
	public BMPViewer() {
		Window();
	}
	
	public void Window() {
		window = new JFrame("BMPViewer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500,500);
		window.setVisible(true);
		window.setLocationRelativeTo(null);	
		window.setLayout(new BorderLayout());
		this.Menu();
	}
	
	public void Menu() {
		JMenuBar ferramentas = new JMenuBar();
		JMenu files = new JMenu("Ficheiros");
		JMenuItem add = new JMenuItem("Adicionar imagem");
		JMenuItem save = new JMenuItem("Guardar imagem");
		JMenuItem saveas = new JMenuItem("Guardar imagem como...");
		ferramentas.add(files);
		files.add(add);
		files.add(save);
		files.add(saveas);
		window.add(ferramentas, BorderLayout.PAGE_START);
		
	}
	
	public void Display() {
		
	}
	
	public void ImgOptions() {
		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
