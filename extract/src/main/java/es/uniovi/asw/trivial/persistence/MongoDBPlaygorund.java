package es.uniovi.asw.trivial.persistence;

import com.mongodb.*;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;

/**
 * Created by Jorge on 13/03/2015.
 */
@SuppressWarnings("all")
public class MongoDBPlaygorund {

    private final static String DB_NAME = "mydb";
    private final static String DB_HOST = "localhost";

	private final static String DB_COLLECTION_PREGUNTAS = "preguntas";
    private final static String CATEGORIA = "categoria";
    private final static String DB_COLLECTION_USUARIOS = "usuarios";

    public static void main(String[] args) throws UnknownHostException {

    }

    //#Section añadir a

    //Añadir a MongoDB.java

    /**
     * Guarda un usuario en la base de datos. No debe existir ningun otro usuario en la base de datos con ese identificador.
     *
     * @param _id      Identificador del usuario.
     * @param password Constraseña del usuario.
     * @return <i>0</i> Al guardar. <i>-1</i> si no se ha guardado el usuario.
     * @throws UnknownHostException
     */
    private int guardarUsuario(String _id, String password) throws UnknownHostException {

        DBCollection dbCollection = getDB().getCollection(DB_COLLECTION_USUARIOS);
        DBObject dbObject = (DBObject) JSON.parse("{'_id':'" + _id + "', 'password':" + password + "}");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("_id", _id);
        DBCursor cursor = dbCollection.find(searchQuery);
        if (cursor.size() == 0) {
            dbCollection.save(dbObject);
            return 0;
        }
        return -1;

    }

    //#endsection

    private DB getDB() throws UnknownHostException {
        return new MongoClient(DB_HOST).getDB(DB_NAME);
    }


    //#Section basura
        /*

    	Pregunta[] p = new MongoDBPlaygorund().getPreguntas_Categoria("Paco");
    	System.out.println(p.length);
    	for(Pregunta pp:p)
    		System.out.println(pp);


        MongoClient mongo = new MongoClient("localhost");
        System.out.println("Conectado");
        DB db= mongo.getDB("mydb");
        
        DBCollection coleccion = db.getCollection("preguntas");
        
        BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("categoria", "Math");
    	
    	DBCursor cursor = coleccion.find(searchQuery);
    	while (cursor.hasNext()) {
    		Pregunta p = preguntaFromJson(cursor.next().toString());
    		System.out.println(p);
    	}
    	
    	  	while (cursor.hasNext()) {
    		DBObject dbObject =	cursor.next();
        	System.out.println(dbObject);
    		String _id = (String) dbObject.get("_id");
    		String pregunta = (String) dbObject.get("pregunta");
    		String categoria = (String) dbObject.get("categoria");
    		BasicDBList respuestasCorrectasAux = (BasicDBList) dbObject.get("respuestasCorrectas");
    		String[] respuestasCorrectas = {};
    		respuestasCorrectas = respuestasCorrectasAux.toArray(respuestasCorrectas);
    		
       		BasicDBList respuestasIncorrectasAux = (BasicDBList) dbObject.get("respuestasIncorrectas");
    		String[] respuestasincorrectas = {};
    		respuestasincorrectas = respuestasIncorrectasAux.toArray(respuestasincorrectas);
    		
    		System.out.println(_id+" "+pregunta+" "+categoria);
    		System.out.println("Respuestas:");
    		for (String string : respuestasincorrectas) 
				System.out.println(string);
    		for (String string : respuestasCorrectas) 
				System.out.println(string);
			
				
        
        DBCollection dbCollection =db.getCollection("preguntas");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));
        dbCollection.save(doc);	
        System.out.println("Conectado");

    	
    	*/
    //#endsection


}
