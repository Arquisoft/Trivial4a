package es.uniovi.asw.trivial.persistence;

import com.google.gson.Gson;
import com.mongodb.*;

import es.uniovi.asw.trivial.model.Pregunta;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 13/03/2015.
 */
public class MongoDBPlaygorund {
	
	private final static String DB_NAME = "mydb";
	private final static String DB_HOST = "localhost";
	private final static String DB_COLLECTION_PREGUNTAS = "preguntas";
	private final static String CATEGORIA = "categoria";
	
	private DB getDB() throws UnknownHostException{
		return new MongoClient(DB_HOST).getDB(DB_NAME);
	}	

	//#Section añadir a
	//TODO Añadir a Pregunta.java 
	/**
	 * Tranformar de json a Pregunta.
	 * @param json Cadena en formato json.
	 * @return Objeto Pregunta con los datos de entrada.
	 */
	public static Pregunta fromJson(String json){
		 return new Gson().fromJson(json, Pregunta.class);
	}
	
	//TODO Añadir a MongoDB.java
	/**
	 * Busca en la base de datos preguntas de determinada categoria. Si no se encuentra ninguna
	 * pregunta se devuelve un array vacio.
	 * @param categoria
	 * @return Array con las preguntas de la consulta.
	 * @throws UnknownHostException
	 */
	public Pregunta[] getPreguntas_Categoria(String categoria) throws UnknownHostException{
		Pregunta[] aux = {};
		List<Pregunta> preguntas = new ArrayList<Pregunta>();

		DBCollection coleccion = getDB().getCollection(DB_COLLECTION_PREGUNTAS);
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put(CATEGORIA, categoria);
    	
    	DBCursor cursor = coleccion.find(searchQuery);
    	
    	while (cursor.hasNext()) {
    		//Cambiar preguntaFromJson a Pregunta.fromJson
    		preguntas.add(preguntaFromJson(cursor.next().toString()));
    	}
    	
		return preguntas.toArray(aux);
	}
	
	/**
	 * Conseguir todas las preguntas 
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public Pregunta[] getAllPreguntas() throws UnknownHostException{
		
		Pregunta[] aux = {};
		List<Pregunta> preguntas = new ArrayList<Pregunta>();

		
		DBCollection coleccion = getDB().getCollection(DB_COLLECTION_PREGUNTAS);
		
		DBCursor cur = coleccion.find();
		
		while (cur.hasNext())
			preguntas.add(preguntaFromJson(cur.next().toString()));
		
		return preguntas.toArray(aux);
	}
	//#endsection
	
    public static void main(String [] args) throws UnknownHostException {
    	Pregunta[] p = new MongoDBPlaygorund().getPreguntas_Categoria("Paco");
    	System.out.println(p.length);
    	for(Pregunta pp:p)
    		System.out.println(pp);
    }
    
    private static Pregunta preguntaFromJson(String string) {
		return fromJson(string);
	}
    
    //#Section basura
    	/*

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
