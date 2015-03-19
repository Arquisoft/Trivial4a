package es.uniovi.asw.trivial.persistence;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by Jorge on 13/03/2015.
 */
public class MongoDBPlaygorund {

    public static void main(String [] args) throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost");
        System.out.println("Conectado");
        DB db= mongo.getDB("mydb");
        DBCollection dbCollection =db.getCollection("preguntas");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));
        dbCollection.save(doc);
        System.out.println("Conectado");

    }
}
