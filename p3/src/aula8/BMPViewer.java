package aula8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BMPViewer implements ActionListener{
	private JFrame window;
	/* Menu Superior */
	private JMenuBar ferramentas = new JMenuBar();
	private JMenu files = new JMenu("Ficheiros\n ");
	private JMenuItem add = new JMenuItem("Adicionar imagem");
	private JMenuItem save = new JMenuItem("Guardar imagem");
	private JMenuItem saveas = new JMenuItem("Guardar imagem como...");
	/*Image Display*/
	JPanel panel= new JPanel();
	Bitmap bmp = new Bitmap();
	/*Menu Inferior*/
	private JMenuBar funct = new JMenuBar();
	private JMenuItem fh = new JMenuItem("Rodar Horizontalmente");
	private JMenuItem fv = new JMenuItem("Rodar Verticalmente");
	private JMenuItem sm = new JMenuItem("Diminuir");
	private boolean showImage = false;
	
	
	
	
	public BMPViewer() {
		Window();
	}
	
	public void Window() {
		window = new JFrame("BMPViewer");
		window.getContentPane().setBackground(Color.GRAY);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1000,1000);
		window.setLocationRelativeTo(null);	
		window.setLayout(new BorderLayout());
		this.Menu();
		this.Display(bmp);
		this.ImgOptions();
		window.setVisible(true);
	}
	
	public void Menu() {
		ferramentas.add(files);
		files.add(add);
		files.add(save);
		files.add(saveas);
		window.add(ferramentas, BorderLayout.PAGE_START);
		add.addActionListener(this);
		

		
	}
	
	public void Display(Bitmap bmp) {
		try {
			window.remove(panel);
			panel = new PanelImage(bmp.getData(),Math.abs(bmp.getWidth()),bmp.getHeight());
			window.add(panel, BorderLayout.CENTER);
			window.revalidate();
			window.repaint();
		}catch(NullPointerException e) {}
		
	}
	
	public void ImgOptions() {
		funct.add(fh);
		funct.add(fv);
		funct.add(sm);
		window.add(funct,BorderLayout.PAGE_END);
		fh.addActionListener(this);
		fv.addActionListener(this);
		sm.addActionListener(this);
	}
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent arg0){
		Object action = arg0.getSource();
		if(action.equals(add)) {
			showImage=true;
				try {
					Search();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		else if(action.equals(fh) && showImage) {
			Pixel[][] pixel= bmp.flipHorizontal();
			Bitmap bmp1=bmp;
			bmp1.setData(Bitmap.pixelToByteArray(pixel));
			Display(bmp1);
		} else if(action.equals(fv) && showImage) {
			Pixel[][] pixel= bmp.flipVertical();
			Bitmap bmp1=bmp;
			bmp1.setData(Bitmap.pixelToByteArray(pixel));
			Display(bmp1);
		} else if(action.equals(sm) && showImage) {
			if(bmp.getWidth() <= 80 || bmp.getHeight() <= 80) {
				JOptionPane.showMessageDialog(null,"Image is too small to shrink");
			} else {
				Bitmap bmp1=bmp;
				bmp1.shrink();
				Display(bmp1);
			}
		
		} else if(action.equals(save)&& showImage) {
			String path= JOptionPane.showInputDialog(null, "");
			try {
				bmp.saveToBmp(path, bmp.byteToPixelArray(bmp.getWidth(), bmp.getHeight()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if(action.equals(saveas)) {
			String path = JOptionPane.showInputDialog("The path were you want to save the image");
		}
	}
	
	public void Search() throws IOException{
		JFileChooser chooser = new JFileChooser();	
		int c=chooser.showOpenDialog(window);
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("BMP Images", "bmp");
		chooser.setFileFilter(filter);
		if(c == JFileChooser.APPROVE_OPTION) {
		       JTextField dir = new JTextField();
		       dir.setText(chooser.getCurrentDirectory().toString());
		       String path= dir.getText()+"/"+chooser.getSelectedFile().getName();
		    	   bmp = new Bitmap(path);
		    	   Display(bmp);
		}
		else if(c == JFileChooser.CANCEL_OPTION) {	
		}
	}
}
