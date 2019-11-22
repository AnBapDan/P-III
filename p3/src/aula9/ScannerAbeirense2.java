package aula9;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense2 implements Iterator<String>, Closeable{

	private Scanner scan;
	
	public ScannerAbeirense2(File f) throws FileNotFoundException {
		try {
			scan = new Scanner(f);
		} catch(FileNotFoundException e) {
			throw new FileNotFoundException("Ficheiro n�o encontrado");
		}
	}
	
	public ScannerAbeirense2(String s) {
		scan = new Scanner(s);
	}

	@Override
	public void close() throws IOException {
		scan.close();
	}

	@Override
	public boolean hasNext() {
		return scan.hasNext();
	}

	@Override
	public String next() {
		String tmp = scan.next();
		tmp = tmp.replaceAll("v","b");
		tmp = tmp.replaceAll("V","B");
		return tmp;
	}
	
	public String nextLine() {
		String tmp = scan.nextLine();
		tmp = tmp.replaceAll("v","b");
		tmp = tmp.replaceAll("V", "B");
		return tmp;
	}
}
