package es.uniovi.asw.trivial;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;

public class Loader {
	
	public void run(String path){
		try {
			load(path);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

	private void load(String path) throws IOException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		File file = new File(path);
		if(!file.exists())
			throw new RuntimeException("No existe la ruta especificada");
		else if(file.isDirectory()){
			
		}else if(file.isFile()){
			loadFile(file);
		}

	}
	
	private void loadFile(File file) throws IOException{
	}
	
	
	
	
	 public List<Pregunta> readJsonStream(InputStream in) throws IOException {
	     JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
	     try {
	       return readPreguntaArray(reader);
	     } finally {
	       reader.close();
	     }
	   }

	 private List<Pregunta> readPreguntaArray(JsonReader reader) throws IOException {
		 List<Pregunta> preguntas = new ArrayList<Pregunta>();

	     reader.beginArray();
	     while (reader.hasNext()) {
	       preguntas.add(readPregunta(reader));
	     }
	     reader.endArray();
	     return preguntas;
	   }
	 
	private class Wrapper{ String identificador; String pregunta; String[] respuestasCorrectas; String[] respuestasIncorrectas; }
	private Pregunta readPregunta(JsonReader reader) throws IOException {
		Wrapper aux = new Wrapper();
		reader.beginObject();

		//TODO leer el objeto y guardarlo en el Wrapper
		
		 reader.endObject();
		 
		return new Pregunta();//TODO actualizar con constructor
	}


}


