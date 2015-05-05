package es.uniovi.asw.trivial.persistence;

import com.google.gson.Gson;
import es.uniovi.asw.trivial.model.Pregunta;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class JSonFileWriter {

    public static String ruta;

    public void writeJSONfile(ArrayList<Pregunta> preguntas) throws UnknownHostException {
        Gson gson = new Gson();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();

        String name = "output/" + (dateFormat.format(date) + ".json"); //2014/08/06 15:59:48
        ruta = name;
        StringBuilder sb = new StringBuilder();
        sb.append(gson.toJson(preguntas));

        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name, true)));
            bw.write(sb.toString());
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Conectado");
    }

}
