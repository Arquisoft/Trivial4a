package es.uniovi.asw.trivial.extractor.parser;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

public class MainDeleteMe {

	public static void main(String[] args) {

		try {
			new Extractor().run(args);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
