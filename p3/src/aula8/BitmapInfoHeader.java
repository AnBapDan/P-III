package aula8;

public class BitmapInfoHeader {
	private int size, width, height, compression,sizeImage, xPelsPerMeter, yPelsPerMeter, clrUsed, clrImportant;
	private short planes,bitCount;
	
	public BitmapInfoHeader(int size, int width, int height, short planes, short bitCount, int compression, int sizeImage, 
			int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant) {
		super();
		this.size = size;
		this.width = width;
		this.height = height;
		this.compression = compression;
		this.sizeImage = sizeImage;
		this.xPelsPerMeter = xPelsPerMeter;
		this.yPelsPerMeter = yPelsPerMeter;
		this.clrUsed = clrUsed;
		this.clrImportant = clrImportant;
		this.planes = planes;
		this.bitCount = bitCount;
	}
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCompression() {
		return compression;
	}

	public void setCompression(int compression) {
		this.compression = compression;
	}

	public int getSizeImage() {
		return sizeImage;
	}

	public void setSizeImage(int sizeImage) {
		this.sizeImage = sizeImage;
	}

	public int getxPelsPerMeter() {
		return xPelsPerMeter;
	}

	public void setxPelsPerMeter(int xPelsPerMeter) {
		this.xPelsPerMeter = xPelsPerMeter;
	}

	public int getyPelsPerMeter() {
		return yPelsPerMeter;
	}

	public void setyPelsPerMeter(int yPelsPerMeter) {
		this.yPelsPerMeter = yPelsPerMeter;
	}

	public int getClrUsed() {
		return clrUsed;
	}
	
	public void setClrUsed(int clrUsed) {
		this.clrUsed = clrUsed;
	}
	
	public int getClrImportant() {
		return clrImportant;
	}

	public void setClrImportant(int clrImportant) {
		this.clrImportant = clrImportant;
	}

	public short getPlanes() {
		return planes;
	}

	public void setPlanes(short planes) {
		this.planes = planes;
	}

	public short getBitCount() {
		return bitCount;
	}

	public void setBitCount(short bitCount) {
		this.bitCount = bitCount;
	}

	@Override
	public String toString() {
		return "--BitmapInfoHeader--\n"
				+ "Header Size = " + size 
				+ "\nWidth = " + width 
				+ "\nHeight = "+ height 
				+ "\nCompression = "+ compression 
				+ "\nImage Size = " + sizeImage 
				+ "\nHorizontal Resoltuion = " + xPelsPerMeter 
				+ "\nVertical Resolution = "+ yPelsPerMeter 
				+ "\nNumber of Colors = " + clrUsed 
				+ "\nNumber of Colors Used = " + clrImportant 
				+ "\nPlanes = " + planes 
				+ "\nBitCount=" + bitCount+"\n";
	}
	
	
}
