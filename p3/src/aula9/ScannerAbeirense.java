package aula9;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ScannerAbeirense implements Iterator<String>, Closeable{

	private BufferedInputStream x;

	public ScannerAbeirense(InputStream x) throws IOException {
		this.x = new BufferedInputStream(x);
	}
	
	public ScannerAbeirense(File f) throws IOException {
		this.x = new BufferedInputStream(new FileInputStream (f));
	}
	
	public String nextLine() {
		String r="";
		String next = next();
		while (!(next.equals("\n"))) {
			r += next;
			next = next();
		}
		return r;
	}



	@Override
	public boolean hasNext() {	
		try {
			return x.available() >0;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String next() {
		try {
			int b = x.read();
			if(b== -1) {
				return"";
			}
			if(b == 'v' || b == 'V') {
				b= b-20;
			}
			return ""+(char) b;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void close() throws IOException {
		x.close();

	}

}
