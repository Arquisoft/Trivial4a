package es.uniovi.asw.trivial.interfaz;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Quesito extends JLabel{
	String categoria;
	JLabel lbl;
	Color color;
	private boolean coloreado = false;
	
	public Quesito(String ct, Color c){
		this.categoria=ct;
		this.color=c;
		setColor();
	}
	
	public void setColor(){
		if(!coloreado){
			this.setForeground(color);
			this.setVisible(true);
		}
	}
	
	public JLabel getLabel(){
		return lbl;
	}
}
