package es.uniovi.asw.trivial;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import es.uniovi.asw.trivial.pregunta.JSonable;

import com.google.gson.Gson;


public class JSonWriter {
	
	private String rutaSalida;
	
	@SuppressWarnings("unused")
	private JSonWriter(){
		//Se debe usar contructor con parametros.
	}
	
	public JSonWriter(String rutaSalida){
		this.rutaSalida = rutaSalida;
	}
	
	public void writeJSonFile(List<JSonable> jSonables){
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		for(JSonable i : jSonables){
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
