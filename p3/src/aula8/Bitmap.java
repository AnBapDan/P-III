package aula8;

import java.io.*;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.*;

public class Bitmap implements ImageObserver {
	BitmapFileHeader bmfh;
	BitmapInfoHeader bmih;
	byte[] data,rgbQuad;
	String name;
	
	public Bitmap(File f) throws IOException {
		this(f.getAbsolutePath());
	}
	
	public Bitmap(BitmapFileHeader bmfh,BitmapInfoHeader bmih, byte[] data) {
		this.bmfh = bmfh;
		this.bmih = bmih;
		this.data = data;
	}
	
	public Bitmap(String path) throws IOException {
		String[] y = path.split("/");
		String ext = y[y.length-1];
		if(ext.charAt(ext.length()-3)=='b' && ext.charAt(ext.length()-2)=='m' && ext.charAt(ext.length()-1)=='p') {
			try {
				RandomAccessFile f = new RandomAccessFile(path,"r");
				this.name=ext;
				this.bmfh=new BitmapFileHeader(
						Short.reverseBytes(f.readShort()),
						Integer.reverseBytes(f.readInt()),
						Short.reverseBytes(f.readShort()),
						Short.reverseBytes(f.readShort()),
						Integer.reverseBytes(f.readInt()));
				
				this.bmih=new BitmapInfoHeader(
						Integer.reverseBytes(f.readInt()),
						Integer.reverseBytes(f.readInt()),
						Integer.reverseBytes(f.readInt()),
						Short.reverseBytes(f.readShort()),
						Short.reverseBytes(f.readShort()),
						Integer.reverseBytes(f.readInt()),
						Integer.reverseBytes(f.readInt()),
						Integer.reverseBytes(f.readInt()),
						Integer.reverseBytes(f.readInt()),
						Integer.reverseBytes(f.readInt()),
						Integer.reverseBytes(f.readInt()));
				
				if(this.bmih.getBitCount()!=1 && this.bmih.getBitCount()!=4 && this.bmih.getBitCount()!=8 && this.bmih.getBitCount()!=16 && this.bmih.getBitCount()!=24 && this.bmih.getBitCount()!=32) {
					System.out.print("Bit Count"+this.bmih.getBitCount()+"is not supported!");
					System.exit(2);
				}
				int dataLength = (int) (f.length()-this.bmfh.getOffBits());
				data = new byte[dataLength];
				f.read(data);
				
				f.close();
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("ERROR: Cannot read from file!");
				System.exit(1);
			}
		}
		else {
			System.out.println("File extension not supported!");
		}
	}
	
	@Override
	public String toString() {
		return "Imagem: "+name+"\n\n"+bmfh.toString()+"\n"+bmih.toString();
	}
	
	public void saveAsBmp(File f, String name) throws IOException {
		String path = f.getAbsolutePath();
		String[] x=path.split("/");
		String absPath="";
		for(int i=0;i<x.length-1;i++) {
			absPath += "/"+x[i];
		}
		FileOutputStream fos = new FileOutputStream(absPath+"/"+name+".bmp");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeShort(this.bmfh.getType());
		dos.writeInt(this.bmfh.getSize());
		dos.writeShort(this.bmfh.getReserved1());
		dos.writeShort(this.bmfh.getReserved2());
		dos.writeInt(this.bmfh.getOffBits());
		
		dos.writeInt(this.bmih.getSize());
		dos.writeInt(this.bmih.getWidth());
		dos.writeInt(this.bmih.getHeight());
		dos.writeShort(this.bmih.getPlanes());
		dos.writeShort(this.bmih.getBitCount());
		dos.writeInt(this.bmih.getCompression());
		dos.writeInt(this.bmih.getSizeImage());
		dos.writeInt(this.bmih.getxPelsPerMeter());
		dos.writeInt(this.bmih.getyPelsPerMeter());
		dos.writeInt(this.bmih.getClrUsed());
		dos.writeInt(this.bmih.getClrImportant());
		
		dos.write(data);
		fos.close();
		dos.close();
	}
	
	public void saveAsRaw(File f) throws IOException {
		String path = f.getAbsolutePath();
		String[] x=path.split("/");
		String absPath="";
		for(int i=0;i<x.length-1;i++) {
			absPath += "/"+x[i];
		}
		File im = new File(absPath+"/Figura.raw");
//		BufferedImage image = ImageIO.read(f);
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ImageIO.write(image,"raw",baos);
//		baos.flush();
//		byte[] raw_data = baos.toByteArray();
		
		FileOutputStream fos = new FileOutputStream(im);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.write(data);
		fos.close();
		dos.close();
		
	}
	
	public Bitmap reverseBytes() {
		BitmapFileHeader a=new BitmapFileHeader(
				Short.reverseBytes(this.bmfh.getType()),
				Integer.reverseBytes(this.bmfh.getSize()),
				Short.reverseBytes(this.bmfh.getReserved1()),
				Short.reverseBytes(this.bmfh.getReserved2()),
				Integer.reverseBytes(this.bmfh.getOffBits()));
		
		BitmapInfoHeader b=new BitmapInfoHeader(
				Integer.reverseBytes(this.bmih.getSize()),
				Integer.reverseBytes(this.bmih.getWidth()),
				Integer.reverseBytes(this.bmih.getHeight()),
				Short.reverseBytes(this.bmih.getPlanes()),
				Short.reverseBytes(this.bmih.getBitCount()),
				Integer.reverseBytes(this.bmih.getCompression()),
				Integer.reverseBytes(this.bmih.getSizeImage()),
				Integer.reverseBytes(this.bmih.getxPelsPerMeter()),
				Integer.reverseBytes(this.bmih.getyPelsPerMeter()),
				Integer.reverseBytes(this.bmih.getClrUsed()),
				Integer.reverseBytes(this.bmih.getClrImportant()));
		
		return new Bitmap(a,b,data);
		
	}

	public static Bitmap makeSmaller(Bitmap bmp) {
		int h = Math.abs(bmp.bmih.getHeight());
		int w = Math.abs(bmp.bmih.getWidth())*3;
		byte[] arr = new byte[bmp.data.length/4];
		
		int cont = 0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j+=6) {
				if(i%2==0) {
					arr[cont] = bmp.data[j+(w*i)];
					arr[cont+1] = bmp.data[j+(w*i)+1];
					arr[cont+2] = bmp.data[j+(w*i)+1];
					cont+=3;
				}
			}
		}
		
		BitmapFileHeader a = new BitmapFileHeader(bmp.bmfh.getType(),bmp.bmfh.getSize()-arr.length*3,bmp.bmfh.getReserved1(),bmp.bmfh.getReserved2(),bmp.bmfh.getOffBits());
		BitmapInfoHeader b = new BitmapInfoHeader(bmp.bmih.getSize(),bmp.bmih.getWidth()/2,bmp.bmih.getHeight()/2,bmp.bmih.getPlanes(),bmp.bmih.getBitCount(),bmp.bmih.getCompression(),bmp.bmih.getSizeImage(),bmp.bmih.getxPelsPerMeter()/2,bmp.bmih.getyPelsPerMeter()/2,bmp.bmih.getClrUsed(),bmp.bmih.getClrImportant());
		Bitmap new_bmp = new Bitmap(a,b,arr);
		
		return new_bmp;
	}

	public BufferedImage flipH(File f,Bitmap bmp) throws IOException {
		BufferedImage image = ImageIO.read(f);
		double rads = Math.toRadians(90);
		double sin = Math.abs(Math.sin(rads));
		double cos = Math.abs(Math.cos(rads));
		int w = image.getWidth();
		int h = image.getHeight();
		int newWidth = (int)Math.floor(w*cos+h*sin);
		int newHeight = (int)Math.floor(h*cos+w*sin);
		
		BufferedImage rotated = new BufferedImage(newWidth,newHeight,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rotated.createGraphics();
		AffineTransform at = new AffineTransform();
		at.translate((newWidth-w)/2, (newHeight-h)/2);
		
		int x = w/2;
		int y = h/2;
		
		at.rotate(rads,x,y);
		g2d.setTransform(at);
		g2d.drawImage(image,0,0,this);
		g2d.dispose();
		
		return rotated;
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
}












