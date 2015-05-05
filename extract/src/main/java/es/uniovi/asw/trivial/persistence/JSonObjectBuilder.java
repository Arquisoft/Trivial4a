package es.uniovi.asw.trivial.persistence;

import com.google.gson.Gson;

import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;

/**
 * Created by Jorge on 24/03/2015.
 */
public class JSonObjectBuilder {

    /**
     * Tranformar de json a Pregunta.
     *
     * @param json Cadena en formato json.
     * @return Objeto Pregunta con los datos de entrada.
     */
    public static Pregunta PreguntaFromJson(String json) {
        return new Gson().fromJson(json, Pregunta.class);
    }

    /**
     * Tranformar de json a User.
     *
     * @param json Cadena en formato json.
     * @return Objeto User con los datos de entrada.
     */
    public static User UserFromJson(String json) {
        return new Gson().fromJson(json, User.class);
    }

}
