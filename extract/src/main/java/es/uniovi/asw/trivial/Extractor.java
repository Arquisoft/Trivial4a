package es.uniovi.asw.trivial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import es.uniovi.asw.trivial.parser.*;

import javax.imageio.stream.FileImageInputStream;

import es.uniovi.asw.trivial.parser.Parser;
import es.uniovi.asw.trivial.pregunta.JSonable;

public class Extractor {
	
	public static void main(String[] args) {
        new Extractor().run(args);
    }	
	protected ArrayList<JSonable> preguntas;
	public int run(String[] args) {
		
		FileReader fr=null;
		Yylex lexico;
		try {
			if (args.length == 0) 
				throw new Exception("No se han espeficicado argumentos.");
				
			fr = new FileReader(new File(args[0]));	
			
			
			
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
		 */ catch (Exception e) {
			
			System.err.print(e.getMessage());
		}
		if(fr!=null){
		lexico  = new Yylex(fr);
		Parser parser = new Parser(lexico);
		parser.run();
		
		
		preguntas = parser.getPreguntas();
		
		//preguntas = null;
		
		//TODO ver si se puede hacer que el segundo argumento sea la ruta de salia de forma sencilla. la ruta actual de salida es añadir .out.json al fichero de entrada
		
		JSonWriter jsw = new JSonWriter(args[0]+".out.json");
		jsw.writeJSonFile(preguntas);
		System.out.println(preguntas);
		}
		return 0 ;
	}
	
	private void mostrarErrorNoFargumentos() {
		System.err.println("No se han espeficicado argumentos.");
		
	}


}
