package aula12.plugins;

import aula12.IPlugin;

public class Teste implements IPlugin{

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("TESTE");
		int x=0;
		while(x<100) {
			System.out.println(x);
			x++;
		}
		
	}

}
