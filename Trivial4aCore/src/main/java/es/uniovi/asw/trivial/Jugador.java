package es.uniovi.asw.trivial;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private String nombre;
	List<Categoria> quesitos;
	private int posicion;
	
	public Jugador(String nombre)
	{
		this.nombre=nombre;
		quesitos = new ArrayList<Categoria>();
		posicion=0;
		
	}
	
	
	
}
