package aula9;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable{
	private String a;
	private Scanner sc;
	private String[] b;
	private int i =0;
	
	public ScannerAbeirense(InputStream in) {
		BufferedInputStream x = new BufferedInputStream(in);
		this.a = x.read(); 
		sc= new Scanner(in);
		Change();
	}
	
	public ScannerAbeirense(File f) throws FileNotFoundException {
		sc = new Scanner(f);
		Change();
	}
	
	public String Change() {
		String s = a.replaceAll("v","b");
		s = s.replaceAll("V","B" );
		b = s.split(" ");
		return s;
	}
	
	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}

	@Override
	public String next() {
		sc.next();
		return b[i++]+" ";
	}

	@Override
	public void close() throws IOException {
		sc.close();
		
	}

}
