package es.uniovi.asw.trivial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class Loader {

	void run(String path) {
		List<Categoria> categorias = new ArrayList<Categoria>();
		File file = new File(path);
		if(!file.exists())
			throw new RuntimeException("No existe la ruta especificada");
		else if(file.isDirectory()){
			
		}else if(file.isFile()){
			
		}

	}
	
	private void loadFile(File file) throws Throwable{
		Gson gson = new Gson();
		 JsonReader jsonReader = new JsonReader(new FileReader(file));
		 
		 jsonReader.beginObject();
		 while (jsonReader.hasNext()) {
		   String name = jsonReader.nextName();
	        if (name.equals("descriptor")) {
	            ;//TODO 

	        }
	    }

	   jsonReader.endObject();
	   jsonReader.close();

	}
}


