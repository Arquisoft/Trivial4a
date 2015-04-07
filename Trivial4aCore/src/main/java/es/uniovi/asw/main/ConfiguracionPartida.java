package es.uniovi.asw.main;

import java.util.ArrayList;

import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;

public class ConfiguracionPartida {
	private Pregunta[] preguntas;
	private ArrayList<User> usuarios;
	private int min;
	private int max;
	
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
	

}
