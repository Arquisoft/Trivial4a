package es.uniovi.asw.componentesDeInterfaz;

import java.awt.Color;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Quesito extends JButton{
	String categoria;
	Color color;
	private boolean coloreado = false;
	
	public Quesito(String ct, Color c){
		this.categoria=ct;
		this.color=c;
		this.setOpaque(true);
		this.setVisible(false);
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	
	public void setColor(boolean colorear){
		if(colorear && !coloreado){
			this.setBackground(color);
			this.setVisible(true);
			coloreado = true;
		}
		else{
			this.setBackground(new JButton().getBackground());
			this.setVisible(false);
			coloreado = false;
		}
	}
}
