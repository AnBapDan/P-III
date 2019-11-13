package aula8;

public class BitmapFileHeader {
	private short type,reserved1,reserved2;
	private int size,offBits;
	
	public BitmapFileHeader(short type, int size, short reserved1, short reserved2, int offBits) {
		super();
		this.type = type;
		this.reserved1 = reserved1;
		this.reserved2 = reserved2;
		this.size = size;
		this.offBits = offBits;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public short getReserved1() {
		return reserved1;
	}

	public void setReserved1(short reserved1) {
		this.reserved1 = reserved1;
	}

	public short getReserved2() {
		return reserved2;
	}

	public void setReserved2(short reserved2) {
		this.reserved2 = reserved2;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getOffBits() {
		return offBits;
	}
	
	public void setOffBits(int offBits) {
		this.offBits = offBits;
	}
	
	@Override
	public String toString() {
		return "--BitmapFileHeader--\n"
				+ "Type = " + type 
				+ "\nReserved1 = " + reserved1 
				+ "\nReserved2 = " + reserved2 
				+ "\nSize = "+ size 
				+ "\nOffBits = " + offBits + "\n";
	}
	
	
	
	
}
