package es.uniovi.asw.trivial.persistence;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    private final static String DB_NAME = "mydb";
    private final static String DB_HOST = "localhost";
    private final static String DB_COLLECTION_PREGUNTAS = "preguntas";
    private final static String CATEGORIA = "categoria";
    private final static String DB_COLLECTION_USUARIOS = "usuarios";

    private DB getDB() throws UnknownHostException {
        return new MongoClient(DB_HOST).getDB(DB_NAME);
    }

    public void dropDatabase() throws UnknownHostException {
        getDB().dropDatabase();
    }

    public void addPreguntas(Pregunta[] ps) throws UnknownHostException {
        Gson gson = new Gson();
        DB db = getDB();
        for (Pregunta p : ps) {
            DBCollection dbCollection = db.getCollection(DB_COLLECTION_PREGUNTAS);
            DBObject dbObject = (DBObject) JSON.parse(gson.toJson(p));
            dbCollection.save(dbObject);
        }
    }

    /**
     * Busca en la base de datos preguntas de determinada categoria. Si no se encuentra ninguna
     * pregunta se devuelve un array vacio.
     *
     * @param categoria
     * @return Array con las preguntas de la consulta.
     * @throws UnknownHostException
     */
    public Pregunta[] getPreguntas_Categoria(String categoria) throws UnknownHostException {
        Pregunta[] aux = {};
        List<Pregunta> preguntas = new ArrayList<Pregunta>();

        DBCollection coleccion = getDB().getCollection(DB_COLLECTION_PREGUNTAS);
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(CATEGORIA, categoria);
        DBCursor cursor = coleccion.find(searchQuery);

        while (cursor.hasNext())
            preguntas.add(JSonObjectBuilder.PreguntaFromJson(cursor.next().toString()));

        return preguntas.toArray(aux);
    }

    /**
     * Busca todas las preguntas de la base de datos.
     *
     * @return Un array de Preguntas. Si no hay preguntas en la base de datos es un array de tamaño 0.
     * @throws UnknownHostException
     */
    public Pregunta[] getPreguntas() throws UnknownHostException {
        Pregunta[] aux = {};
        List<Pregunta> preguntas = new ArrayList<Pregunta>();

        DBCollection coleccion = getDB().getCollection(DB_COLLECTION_PREGUNTAS);
        DBCursor cursor = coleccion.find();

        while (cursor.hasNext())
            preguntas.add(JSonObjectBuilder.PreguntaFromJson(cursor.next().toString()));

        return preguntas.toArray(aux);
    }

    /**
     * Obtiene el usuario con el ID espeficicado.
     *
     * @param _id
     * @return
     */
    public User getUser(String _id) throws UnknownHostException {
        ArrayList<User> usuario = new ArrayList<User>();
        DBCollection collection = getDB().getCollection(DB_COLLECTION_USUARIOS);
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("_id", _id);
        DBCursor cursor = collection.find(searchQuery);
        while (cursor.hasNext())
            usuario.add(JSonObjectBuilder.UserFromJson(cursor.next().toString()));
        return usuario.get(0);
    }

}
