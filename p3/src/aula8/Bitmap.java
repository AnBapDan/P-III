package aula8;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Bitmap
{
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	byte[] rgbQuad;  
	byte[] data;
	private Pixel[][] pixelArray;
	private int width=100, height=100;
	
	public Bitmap(String path) throws IOException
	{
		RandomAccessFile file = new RandomAccessFile(path, "r");
		
		//Process bitmap file header
		short type = Short.reverseBytes(file.readShort());
		int size = Integer.reverseBytes(file.readInt());
		file.readShort(); //Skip unused 
		file.readShort(); //Skip unused	
		int offBits = Integer.reverseBytes(file.readInt());

		this.bitmapFileHeader = new BitmapFileHeader(type, size, offBits);
		
		//Process bitmap info header
		size = Integer.reverseBytes(file.readInt());
		width = Integer.reverseBytes(file.readInt());
		height = Math.abs(Integer.reverseBytes(file.readInt()));
		short planes = Short.reverseBytes(file.readShort());
		short bitCount = Short.reverseBytes(file.readShort());
		int compression = Integer.reverseBytes(file.readInt());
		int sizeImage = Integer.reverseBytes(file.readInt());
		int xPelsPerMeter = Integer.reverseBytes(file.readInt());
		int yPelsPerMeter = Integer.reverseBytes(file.readInt());
		int clrUsed = Integer.reverseBytes(file.readInt());
		int clrImportant = Integer.reverseBytes(file.readInt());
		this.bitmapInfoHeader = new BitmapInfoHeader(size, width, height, planes, bitCount, compression, sizeImage, 
				xPelsPerMeter, yPelsPerMeter, clrUsed, clrImportant);
		
		if(this.getBitmapInfoHeader().getBitCount() < 16) {
			System.out.println("This program does not support a bit count of less than 16-bit");
			System.exit(0);
		}
		
		//Process bitmap data
		//For some reason this.getBitmapInfoHeader.getSizeImage is returning 0, so I made a way to get it my own way
		this.data = new byte[ (int)file.length() - this.getBitmapFileHeader().getOffBits()];
		
		file.read(this.data); 
		file.close();
		
		this.pixelArray = this.byteToPixelArray(this.getBitmapInfoHeader().getWidth(), this.getBitmapInfoHeader().getHeight());
		
	}
	
	public Bitmap() {
		// TODO Auto-generated constructor stub
	}
	
	public Bitmap(BitmapFileHeader a, BitmapInfoHeader b, byte[] data) {
		this.bitmapFileHeader=a;
		this.bitmapInfoHeader=b;
		this.data=data;
	}

	public static byte[] pixelToByteArray(Pixel[][] pixelArray) 
	{
		byte[] byteArray = new byte[pixelArray.length * pixelArray[0].length * 3];
		
		int i = 0;
		for(int y = 0; y < pixelArray.length; y++) 
		{
			for(int x = 0; x < pixelArray[0].length; x++) 
			{
				byteArray[i++] = pixelArray[y][x].B;
				byteArray[i++] = pixelArray[y][x].G;
				byteArray[i++] = pixelArray[y][x].R;
			}
		}
		return byteArray;
	}
	
	public Pixel[][] byteToPixelArray(int width, int height)
	{		
		Pixel[][] pixels = new Pixel[height][width];
		
		int k = 0;
		
		for(int y = 0; y < pixels.length; y++) 
		{
			for(int x = 0; x < pixels[0].length; x++) 
			{
				pixels[y][x] = new Pixel(this.data[k++],this.data[k++],this.data[k++]);
			}
		}
		
		return pixels;
	}
	
//	public void resize()
//	{
//		this.getBitmapInfoHeader().setWidth((int) Math.round(this.getBitmapInfoHeader().getWidth() * 0.5));
//		this.getBitmapInfoHeader().setHeight((int) Math.round(this.getBitmapInfoHeader().getHeight() * 0.5));
//		
//		
//		Pixel[][] newPixelArray = new Pixel[this.bitmapInfoHeader.getxPelsPerMeter()/2][this.bitmapInfoHeader.getyPelsPerMeter()/2];
//		
//		int pixelsX = 0;
//        int pixelsY = 0;
//        
//		for(int y = 0; y < this.bitmapInfoHeader.getyPelsPerMeter()/2; y++) 
//		{
//			for(int x = 0; x < this.bitmapInfoHeader.getxPelsPerMeter()/2; x++) 
//			{
//				newPixelArray[y][x] = pixelArray[pixelsY][pixelsX];
//				pixelsX += 2;
//			}
//			pixelsX = 0;
//			pixelsY += 2;
//		}
//		
//		this.pixelArray = newPixelArray;
//	}
	
	public Bitmap shrink() {
		int w = this.width*3;
		int h = this.height;
		byte[] d = new byte[data.length / 4];
		int t = 0;
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j+=6) {
				if(i % 2 == 0) {
					d[t] = data[j + (w*i)]; 
					d[t+1] = data[j + (w*i)+1];
					d[t+2] = data[j + (w*i)+2];
					t = t + 3;
				}
			}
		}
		
		BitmapFileHeader bf = new BitmapFileHeader(this.bitmapFileHeader.getType(),this.bitmapFileHeader.getSize() - d.length*3,this.bitmapFileHeader.getOffBits());
		BitmapInfoHeader bi = new BitmapInfoHeader(this.bitmapInfoHeader.getSize(),this.bitmapInfoHeader.getWidth()/2,this.bitmapInfoHeader.getHeight()/2,
												   this.bitmapInfoHeader.getPlanes(),this.bitmapInfoHeader.getBitCount(),this.bitmapInfoHeader.getCompression(),d.length,
												   this.bitmapInfoHeader.getxPelsPerMeter()/2,this.bitmapInfoHeader.getyPelsPerMeter()/2,this.bitmapInfoHeader.getClrUsed(),
												   this.bitmapInfoHeader.getClrImportant());

		return new Bitmap(bf,bi,d);
	}
	
	public Pixel[][] flipVertical()
	{
		Pixel[][] verticalFlippedPixelArray = this.getPixelArray();
		int oldY = 0;
		for(int newY = this.pixelArray.length-1; newY >= 0; newY--)
		{
			for(int x = 0; x < this.pixelArray[oldY].length; x++)
			{				
				verticalFlippedPixelArray[oldY][x] = this.pixelArray[newY][x];
			}
		}
		
		return verticalFlippedPixelArray;
	}
	
	public Pixel[][] flipHorizontal()
	{
		Pixel[][] horizontalFlippedPixelArray = this.getPixelArray();
		
		for(int j = 0; j < horizontalFlippedPixelArray.length; j++)
		{
		    for(int i = 0; i < horizontalFlippedPixelArray[j].length / 2; i++) 
		    {
		        Pixel temp = horizontalFlippedPixelArray[j][i];
		        horizontalFlippedPixelArray[j][i] = horizontalFlippedPixelArray[j][horizontalFlippedPixelArray[j].length - i - 1];
		        horizontalFlippedPixelArray[j][horizontalFlippedPixelArray[j].length - i - 1] = temp;
		    }
		}
		return horizontalFlippedPixelArray;
	}
	
	public BitmapFileHeader getBitmapFileHeader() 
	{
		return bitmapFileHeader;
	}
	
	public BitmapInfoHeader getBitmapInfoHeader() 
	{
		return bitmapInfoHeader;
	}
	
	public byte[] getRgbQuad() 
	{
		return rgbQuad;
	}
	
	public byte[] getData() 
	{
		return data;
	}
	
	public void setData(byte[] data) {
		this.data=data;
	}
	
	public Pixel[][] getPixelArray()
	{
		return pixelArray;
	}

	
	public void saveToRaw(String path) throws IOException
	{			
		if(!new File(path).exists()) new File(path).createNewFile();
		RandomAccessFile rawFile = new RandomAccessFile(path, "rw");
		rawFile.write(pixelToByteArray(this.pixelArray));
		rawFile.close();
	}
	
	public void saveToBmp(String path, Pixel[][] pixelArray) throws IOException
	{
		if(!new File(path).exists()) new File(path).createNewFile();
		RandomAccessFile bmpFile = new RandomAccessFile(path, "rw");
		
		//File Header
		bmpFile.writeShort(Short.reverseBytes(this.getBitmapFileHeader().getType()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapFileHeader().getSize()));
		bmpFile.writeShort(0);
		bmpFile.writeShort(0);
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapFileHeader().getOffBits()));
	
		//Info header
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getSize()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getWidth()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getHeight()));
		bmpFile.writeShort(Short.reverseBytes(this.getBitmapInfoHeader().getPlanes()));
		bmpFile.writeShort(Short.reverseBytes(this.getBitmapInfoHeader().getBitCount()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getCompression()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getSizeImage()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getxPelsPerMeter()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getyPelsPerMeter()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getClrUsed()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getClrImportant()));

		bmpFile.write(pixelToByteArray(pixelArray));
		bmpFile.close();
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}