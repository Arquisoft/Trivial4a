package es.uniovi.asw.trivial.model;

public class Player {
	
	private User user;
	private int posicion;
	
	
	
	public Player(User user, int posicion) {
	
		this.user = user;
		this.posicion = posicion;
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

}
