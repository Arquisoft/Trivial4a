package es.uniovi.asw.trivial.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private User user;
	private int posicion;
	private List<String> quesitos;
	
	
	
	public Player(User user, int posicion) {
	
		this.user = user;
		this.posicion = posicion;
		quesitos = new ArrayList<String>();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public boolean putQuesito(String nombre)
	{
		if(quesitos.contains(nombre))
			return false;
		quesitos.add(nombre);
		
		return true;
	}
	
	public void clearQuesitos()
	{
		quesitos = new ArrayList<String>();
	}

	public List<String> getQuesitos() {
		return quesitos;
	}

	@Override
	public String toString() {
		return "Player [user=" + user.get_id() + ", posicion=" + posicion
				+ ", quesitos=" + imprimirQuesitos() + "]";
	}
	
	private String imprimirQuesitos(){
		String cadena = "";
		for(int i=0;i<quesitos.size();i++)
			if(i<quesitos.size()-1)
				cadena+=quesitos.get(i)+", ";
			else
				cadena+=quesitos.get(i);
		return cadena;
	}

	
	
}
