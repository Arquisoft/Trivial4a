package es.uniovi.asw.trivial.extractor;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Cosas {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongo = new MongoClient("localhost");
		DB db= mongo.getDB("mySuperdb");
		System.out.println(db);

	}

}
