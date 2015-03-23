package es.uniovi.asw.trivial.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import es.uniovi.asw.trivial.interfaz.Colores.ColorCategoria;
import es.uniovi.asw.trivial.model.Player;
import es.uniovi.asw.trivial.model.User;

@SuppressWarnings("serial")
public class Panel_Quesitos extends JPanel{

	Map<String,Quesito> quesitos = new HashMap<String,Quesito>();
	Player jugadorActual;
	
	public Panel_Quesitos(int tam, Player p){
		this.jugadorActual = p;
		this.setLayout(new GridLayout());
		
		//Esto son pruebas
		agregarQuesito(true);
	}
	
	public void agregarQuesito(boolean acierto){
		if(acierto){
			jugadorActual.putQuesito("Categoria A");
			for(int i=0; i<jugadorActual.getQuesitos().size(); i++){
				String categoria = jugadorActual.getQuesitos().get(i);
				Quesito quesito = new Quesito( categoria,
						VentanaJuego.colores.getColor(categoria));
				quesitos.put(categoria, quesito);
			}
		}
	}
	
	public class Quesito{
		String categoria;
		JLabel lbl;
		Color color;
		private boolean coloreado = false;
		
		public Quesito(String ct, Color c){
			this.lbl=new JLabel();
			this.categoria=ct;
			this.color=c;
			setColor();
		}
		
		public void setColor(){
			if(!coloreado){
				lbl.setBackground(color);
				lbl.setVisible(true);
			}
		}
	}
}
