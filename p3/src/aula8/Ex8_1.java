package aula8;

public class Ex8_1 {
	public static void main(String[] args) {
		try {
			args[0] = args[0].toUpperCase();
		}catch(ArrayIndexOutOfBoundsException e) {
			args= new String[1];
			args[0]= "X";
		}
		assert args[0]=="X" || args[0]== "O" || args[0]==null;
		Janela j = new Janela(args[0]);	
	}
}
