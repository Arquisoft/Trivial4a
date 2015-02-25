package es.uniovi.asw.trivial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

public class Extractor {
	
	public static void main(String[] args) {
        new Extractor().run(args);
    }	
	
	public int run(String[] args) {
		if (args.length == 0) {
			mostrarErrorNoFargumentos();
			return -1;
		}
		try {
			
			FileImageInputStream inputStream = new FileImageInputStream(new File(args[0]));
			
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo.");
		} catch (IOException e) {
			System.err.println("No se ha podido cargar el archivo.");
			return -1;
		}
		/*
		 * TODO 
		 * El parser creado con yacc y jflex debe invocarse desde aqui.
		 * Deberá verificar el fichero y procesarlo para que devuelva una estructura de datos que contenta las preguntas.
		 * Esta estructura de datos se recorrera despues para generar el json.
		 * Para pasar la lista de objetos a Json intentaremos usar gson.
		 * http://search.maven.org/#artifactdetails%7Ccom.google.code.gson%7Cgson%7C2.3.1%7Cjar
		 */

		System.out.println("To'bien.");
		return 0 ;
	}
	
	private void mostrarErrorNoFargumentos() {
		System.err.println("No se han espeficicado argumentos.");
		
	}


}
