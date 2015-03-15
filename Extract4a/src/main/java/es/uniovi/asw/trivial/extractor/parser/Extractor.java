package es.uniovi.asw.trivial.extractor.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.net.UnknownHostException;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.persistence.JSonWriter;
import es.uniovi.asw.trivial.persistence.MongoDB;

public class Extractor {
	
	
	private boolean writeFiles;
	
	public void run(String... args) throws UnknownHostException, FileNotFoundException{
		
		if(args.length!=0){
			if(args[0].equalsIgnoreCase("clean")){
				dropDatabase();
				return;
			}
			if(args[0].equalsIgnoreCase("output")){
				writeFiles = true;
			}
		}
		loadFiles();
	}

	private void loadFiles() throws FileNotFoundException, UnknownHostException {
		File folder = new File("input");
		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				return lowercaseName.endsWith(".gift");
			}
		};
		File[] giftFiles = folder.listFiles(textFilter);
		
		for(File f : giftFiles){
			parseFile(f);
		}
		
	}

	private void parseFile(File f) throws FileNotFoundException, UnknownHostException {
		
		Yylex lexico = new Yylex(new FileReader(f));
		Parser p = new Parser(lexico);
		p.setCategoria(nombre(f));
		p.run();
		
		Pregunta[] arrayp = new Pregunta[0];
		arrayp = p.getPreguntas().toArray(arrayp);
		if(writeFiles)
			new JSonWriter().writeJSONfile(p.getPreguntas());
		new MongoDB().addPreguntas(arrayp);
		
		for(Pregunta pp : arrayp)
			System.out.println(pp);
	}

	private String nombre(File f) {
		String name = f.getName();
		if (name.indexOf(".") > 0)
		    name = name.substring(0, name.lastIndexOf("."));
		return name;
	}
	
	private void dropDatabase() throws UnknownHostException {
		new MongoDB().dropDatabase();
	}

}
