package es.uniovi.asw.trivial.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import es.uniovi.asw.trivial.interfaz.Colores.ColorCategoria;
import es.uniovi.asw.trivial.model.Player;

@SuppressWarnings("serial")
public class Panel_Quesitos extends JPanel{

	Map<Integer,Quesito> quesitos;
	Player jugadorActual;
	ColorCategoria[] colores;
	
	public Panel_Quesitos(int tam, Colores c, Player p){
		this.colores = c.coloresElegidos;
		this.jugadorActual = p;
		this.setLayout(new GridLayout());
	}
	
	private void agregarQuesito(){
		
	}

	
	public class Quesito{
		String categoria;
		JLabel lbl;
		Color color;
		private boolean coloreado = false;
		
		public Quesito(JLabel l, String ct, Color c){
			this.lbl=l;
			this.categoria=ct;
			this.color=c;
			setColor();
		}
		
		public void setColor(){
			if(!coloreado)
				lbl.setBackground(color);
		}
	}
}
