package es.uniovi.asw.trivial;

import java.util.Random;

public class Dado {
	
	private static Random r1 = new Random();
	
	public static int lanzarDado()
	{
		int numero = r1.nextInt(7);
		return numero;
		
	}

}
