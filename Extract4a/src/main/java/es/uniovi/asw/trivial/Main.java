package es.uniovi.asw.trivial;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

import es.uniovi.asw.trivial.extractor.Extractor;

public class Main {
	
	public static void main(String[] args){
		try {
			new Extractor().run(args);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
