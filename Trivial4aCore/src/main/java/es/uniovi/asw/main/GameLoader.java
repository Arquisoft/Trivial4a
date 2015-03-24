package es.uniovi.asw.main;

import java.net.UnknownHostException;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;


public class GameLoader {

	/*
	 * 3 métodos de acceso a base de datos
	 * getPreguntas, que saque todas las preguntas de la base de datos
	 * getUser, que se le pase un nombre y devuelva el usuario o null si no existe
	 * addUser para guardar un nuevo usuario en bbdd
	 * 
	 * @param args
	 * @throws UnknownHostException
	 */
	
	/*
	 * private Pregunta[] preguntas;
	 * private User[] users; ??
	 * 
	 */
	public static void main(String[] args) throws UnknownHostException {
//		new Loader().run(args[0]);
		MongoClient m = new MongoClient("localhost");
		DBCursor cursor = m.getDB("mydb").getCollection("preguntas").find();
		
		while(cursor.hasNext()){
			System.out.println(cursor.next().get("respuestas"));
		}
	}
	/**
	 * Coge todas las preguntas y usuarios de la base de datos y los guarda en los atributos
	 * 
	 */
	private void cargarDatos()
	{
		//TODO
	}
	
	/**
	 * PRIMERO: comprueba que haya menos usuarios que categorias logueados
	 * no permite más usuarios logueados que categoris
	 * Comprueba que el usuario y contrasenha introducidos son correctos
	 * 
	 * @param usuario, pass
	 * @return true si login correcto
	 */
	public boolean comprobarLogin(String usuario, String pass)
	{
		//TODO
		
		return false;
	}
	
	/**
	 * PRIMERO: comprueba que haya menos usuarios que categorias logueados
	 * si se ha llegado al maximo de jugadores, guardará este en la base de datos pero no lo creará en el juego
	 * 
	 * 
	 * Registra un usuario nuevo, comprueba que el nombre no exista, si es todo correcto crea new User()
	 *
	 * @param usuario, pass
	 * @return true si lo registra correctamente
	 */
	public boolean registroNuevoUser(String usuario, String pass)
	{
		//TODO 1)Comprueba que el usuario no exista 2)Crea nuevo usuario 3)Guarda el usuario en bbdd
		
		return false;
		
	}
	
	
	
	/**
	 * Quita de la lista de jugadores un usuario que ya se haya loggeado
	 * 
	 * @param p
	 */
	public void deletePlayer(User p)
	{
		
		//TODO
		
	}
	
	
	/**
	 * Empezar partida.
	 * Debe ejecutarse este metodo antes de empezar a jugar.
	 * @param usuarios Cojuntos de <b>usuarios</b> que van a jugar.
	 * @param preguntas Conjunto de preguntas que se usarán en el juego
	 * @param tam numero de casillas del tablero
	 * @param min numero maximo del dado
	 * @param max numero minimo del dado
	 */
	public void startGame(User[] usuarios, Pregunta[] preguntas, int tam, int min, int max)
	{
		
	}
	
}
