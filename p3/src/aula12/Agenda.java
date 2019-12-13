package aula12;

import java.io.*;


public interface Agenda{
	
	public void readFile(String fileName) throws FileNotFoundException;
	public void loadPerson();
	public void writeFile() throws IOException;
	
	

}