package es.uniovi.asw.trivial.persistence;

import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import es.uniovi.asw.trivial.pregunta.Pregunta;

public class MongoDB {
	
	private final static String DB_NAME = "mydb";
	private final static String DB_HOST = "localhost";
	private final static String DB_COLLECTION = "preguntas";
	
	private DB getDB() throws UnknownHostException{
		return new MongoClient(DB_HOST).getDB(DB_NAME);
	}	
	
	public void dropDatabase() throws UnknownHostException{
		getDB().dropDatabase();
	}
	
	public void addPreguntas(Pregunta[] ps) throws UnknownHostException{
		Gson gson = new Gson();
		DB db = getDB();
		for (Pregunta p : ps) {
			DBCollection dbCollection =db.getCollection(DB_COLLECTION);
	        DBObject dbObject = (DBObject) JSON.parse(gson.toJson(p));
	        dbCollection.save(dbObject);
		}
	}

}
