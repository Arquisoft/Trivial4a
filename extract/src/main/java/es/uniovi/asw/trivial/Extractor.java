package es.uniovi.asw.trivial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import es.uniovi.asw.trivial.parser.*;

import es.uniovi.asw.trivial.parser.Parser;
import es.uniovi.asw.trivial.pregunta.JSonable;

public class Extractor {

	public static void main(String[] args) {
		new Extractor().run(args);
	}

	protected ArrayList<JSonable> preguntas;

	public int run(String[] args) {

		FileReader fr = null;
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
		} catch (Exception e) {

			System.err.print(e.getMessage());
		}
		if (fr != null) {
			lexico = new Yylex(fr);
			Parser parser = new Parser(lexico);
			parser.run();
			preguntas = parser.getPreguntas();
			JSonWriter jsw = new JSonWriter(args[0] + ".out.json");
			jsw.writeJSonFile(preguntas);
			System.out.println(preguntas);
		}
		return 0;
	}

}
