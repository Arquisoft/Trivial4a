package es.uniovi.asw.trivial;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

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
	
	private void loadFile(File file){
		
	}

}
