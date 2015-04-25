package es.uniovi.asw.trivial.extractor.parser;

import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.persistence.JSonFileWriter;
import es.uniovi.asw.trivial.persistence.MongoDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Extractor {


    private boolean writeFiles;
    private boolean useDB = true;

    public void run(String... args) throws UnknownHostException, FileNotFoundException {

        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("clean")) {
                dropDatabase();
                return;
            }
            if (args[0].equalsIgnoreCase("output")) {
                writeFiles = true;
            }
            if (args[0].equalsIgnoreCase("test")) {
                writeFiles = true;
                useDB = false;
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

        for (File f : giftFiles) {
        	System.out.println("Loading "+nombre(f));
            parseFile(f);
        }

    }

    private void parseFile(File f) throws FileNotFoundException, UnknownHostException {

        Yylex lexico = new Yylex(new FileReader(f));
        Parser p = new Parser(lexico);
        p.run();

        Marcador[] arrayp = new Marcador[0];
        arrayp = p.getMarcadores().toArray(arrayp);

        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
        
        String categoria = "";
        for (Marcador pp : arrayp){
        	if(pp instanceof Categoria)
        		categoria = ((Categoria)pp).valor.split(":")[1];
        	else{
        		if(!(categoria.equals(""))){
        			PreguntaM m = (PreguntaM)pp;
        			m.setCategoria(categoria);
        			preguntas.add(PreguntaM.transformarPregunta(m));
        		}
        	}
        }
        
//        for (Pregunta pregunta : preguntas) {
//			System.out.println(pregunta);
//		}
//        
        if (writeFiles)
        	new JSonFileWriter().writeJSONfile(preguntas);
        if (useDB)
        	new MongoDB().addPreguntas(preguntas.toArray(new Pregunta[0]));

        
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
