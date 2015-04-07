package es.uniovi.asw.main;

import java.net.UnknownHostException;
import java.util.ArrayList;

import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;
import es.uniovi.asw.trivial.persistence.MongoDB;

public class ConfiguracionPartida {
	private Pregunta[] preguntas;
	private ArrayList<User> usuarios;
	private int min;
	private int max;
	private int tam;
	
	public ConfiguracionPartida() throws UnknownHostException{
		preguntas = new MongoDB().getPreguntas();
	}
	
	public Pregunta[] getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(Pregunta[] preguntas) {
		this.preguntas = preguntas;
	}
	public ArrayList<User> getUsuarios() {
		return usuarios;
	}	
	public void setUsuarios(ArrayList<User> usuarios) {
		this.usuarios = usuarios;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getTam() {
		return tam;
	}
	public void setTam(int tam) {
		this.tam = tam;
	}
	
	public void eliminarJugador(String nombre){
		if(usuarios.isEmpty())
			return;
		for(User usuario : usuarios){
			if(usuario.get_id().equals(nombre)){
				usuarios.remove(usuario);
				return;
			}
		}
	}
	
	public boolean isCorrecto(){
		if(this.max==0 || this.min==0 ||
				this.usuarios.isEmpty() ||
				(preguntas==null || preguntas.length==0))
			return false;
		return true;		
	}

	
}
