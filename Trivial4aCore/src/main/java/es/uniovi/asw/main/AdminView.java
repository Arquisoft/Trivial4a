package es.uniovi.asw.main;

import es.uniovi.asw.trivial.model.*;
import es.uniovi.asw.trivial.persistence.MongoDB;

@SuppressWarnings("unused")
@Deprecated
public class AdminView {


	private Pregunta[] preguntas;
	private User[] users;
	private Contestacion[] respuestas;
	private MongoDB bd;
	
	public AdminView(Pregunta[] preguntas, MongoDB conexion)
	{
		this.preguntas=preguntas;
		bd=conexion;
		//users = bd.getUsers();
		//respuestas = bd.getRespuestas();
	}
	
	public String filtrar(String select, String from, String where){
		//TODO
		return "resultado";
	}
}
