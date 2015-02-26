package es.uniovi.asw.trivial;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import es.uniovi.asw.trivial.pregunta.JSonable;


public class JSonWriter {
	
	private String rutaSalida;
	
	@SuppressWarnings("unused")
	private JSonWriter(){
		//Se debe usar contructor con parametros.
	}
	
	public JSonWriter(String rutaSalida){
		this.rutaSalida = rutaSalida;
	}
	
	public void writeJSonFile(ArrayList<JSonable> preguntas){
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		for(JSonable i : preguntas){
			sb.append(gson.toJson(i));
			sb.append("\n");
		}
		FileWriter fw;
		try {
			fw = new FileWriter(rutaSalida);
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
