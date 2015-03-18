package es.uniovi.asw.main;

import java.net.UnknownHostException;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


public class GameMain {

	public static void main(String[] args) throws UnknownHostException {
//		new Loader().run(args[0]);
		MongoClient m = new MongoClient("localhost");
		DBCursor cursor = m.getDB("mydb").getCollection("preguntas").find();
		
		while(cursor.hasNext()){
			System.out.println(cursor.next().get("respuestas"));
		}
	}

}
