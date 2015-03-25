package es.uniovi.asw.interfaz;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Quesito extends JButton{
	String categoria;
	Color color;
	private boolean coloreado = false;
	
	public Quesito(String ct, Color c){
		this.categoria=ct;
		this.color=c;
		this.setOpaque(true);
		setColor();
	}
	
	public void setColor(){
		if(!coloreado){
			this.setBackground(color);
			this.setVisible(true);
			coloreado = true;
		}
	}
	
	public JButton get(){
		return this;
	}
}
