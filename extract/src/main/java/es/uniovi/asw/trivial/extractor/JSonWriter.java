package es.uniovi.asw.trivial.extractor;

import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import es.uniovi.asw.trivial.pregunta.Pregunta;


public class JSonWriter {
	
	
	public void writeDataToDB(ArrayList<Pregunta> preguntas) throws UnknownHostException {
		Gson gson = new Gson();		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		String name = "output/json/"+(dateFormat.format(date)); //2014/08/06 15:59:48
		StringBuilder sb = new StringBuilder();
		sb.append(gson.toJson(preguntas));
		FileWriter fw;
		try {
			
			fw = new FileWriter(name);
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


        
        System.out.println("Conectado");
	}

}
