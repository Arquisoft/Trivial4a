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
	
	public int avanzar()
	{
		int avance = Dado.lanzarDado();
		
		posicion+=avance;
		
		return avance;
	}
	public void avanzar(int valor)
	{
		posicion=valor;
	}
	
	public boolean aPorQuesito(Categoria categoria)
	{
		for(Categoria c: quesitos)
			if(c.equals(categoria))
				return false;
		quesitos.add(categoria);
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosicion() {
		return posicion;
	}
	public String toString()
	{
		String cadena="";
		cadena+="Jugador: "+nombre+"\nPosicion en el tablero: "+posicion+"\nQuesitos: ";
		if(quesitos.size()==0)
			cadena+="no tiene quesitos";
		else{
			for(Categoria c : quesitos)
				cadena+=c.getCategoria()+" ";
		}

		return cadena;
	}
	
	
}
