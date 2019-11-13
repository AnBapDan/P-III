package aula8;

import java.io.*;

public class Ex8_2 {

	public static void main(String[] args) throws IOException {
		try 
		{
			File f = new File("Figura.bmp");
			Bitmap bmp = new Bitmap(f);
			// alinea a)
			System.out.print(bmp.toString());
			bmp.reverseBytes().saveAsRaw(f);
//			Bitmap.makeSmaller(bmp).reverseBytes().saveAsBmp(f,"FiguraPequena");
//			Bitmap.flipH(bmp).reverseBytes().saveAsBmp(f,"FiguraHorizontal1");
//			Bitmap.flipV(bmp).reverseBytes().saveAsBmp(f,"FiguraVertical");
//			Bitmap.flipV(Bitmap.flipH(bmp)).reverseBytes().saveAsBmp(f,"FiguraHorizontal2");
		}
		catch(Exception e) {
			System.out.print("Task could not be done -> "+e.getMessage()+"!");
		}
			
	}
}
