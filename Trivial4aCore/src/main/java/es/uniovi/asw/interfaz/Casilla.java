package es.uniovi.asw.interfaz;

import java.awt.Color;

import javax.swing.JButton;

import es.uniovi.asw.trivial.model.*;

@SuppressWarnings("serial")
public class Casilla extends JButton{

	private int posicion;
	private String categoria;
	private boolean ocupada;
	
	public Casilla(){
		this.ocupada = false;
		this.setEnabled(false);
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	public int getPosicion(){
		return this.posicion;
	}
	
	public void setFondo(Colores colores){
		if(VentanaJuego.juego.getCurrentPlayer().getPosicion() == this.posicion)
			this.setBackground(Color.WHITE);
		else
			this.setBackground(colores.getColor(categoria));
	}
	
	public boolean isOcupada(){
		return ocupada;
	}
	public void setOcupada(Player jugadorActual){
		if(jugadorActual.getPosicion() == this.posicion)
			ocupada = true;
	}
	public int getIndice(){
		return this.posicion;
	}
	
	public Pregunta getPregunta(){
		return VentanaJuego.juego.getQuestionSet(posicion);
	}
	
	public void setPosicion(int index){
		this.posicion = index;
		this.categoria = VentanaJuego.juego.getCategoryname(posicion);
		setFondo(VentanaJuego.colores);
	}
}
	
	
