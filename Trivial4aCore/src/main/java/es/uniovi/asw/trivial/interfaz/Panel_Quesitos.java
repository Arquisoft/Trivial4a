package es.uniovi.asw.trivial.interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import es.uniovi.asw.trivial.interfaz.Colores.ColorCategoria;
import es.uniovi.asw.trivial.model.Player;
import es.uniovi.asw.trivial.model.User;

@SuppressWarnings("serial")
public class Panel_Quesitos extends JPanel{

	Map<String,Quesito> quesitos = new HashMap<String,Quesito>();
	Player jugadorActual;
	
	public Panel_Quesitos(Player p, String[] categorias){
		this.jugadorActual = p;
		setOrganizacion(categorias.length);
		
		//Esto son pruebas
		addQuesitos(categorias);
		agregarQuesito(true,"Categoria A");
		this.setVisible(true);
	}
	
	private void setOrganizacion(int tam){
		if(tam==1)
			this.setLayout(new GridLayout(1,1));
		else if(tam==2)
			this.setLayout(new GridLayout(2,1));
		else if(tam==3 || tam==4)
			this.setLayout(new GridLayout(2,2));
		else if(tam==5 || tam==6)
			this.setLayout(new GridLayout(3,2));
	}
	
	public void addQuesitos(String[] categorias){
		for(int i=0; i<categorias.length; i++){
			Quesito quesito = new Quesito(categorias[i],
					VentanaJuego.colores.getColor(categorias[i]));
			quesitos.put(categorias[i], quesito);
			this.add(quesito);			
		}
	}
	
	public void agregarQuesito(boolean acierto, String categoria){
		if(acierto){
			jugadorActual.putQuesito(categoria);
			quesitos.get(categoria).setColor();
		}
	}
	
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
				this.setBackground(color);
				this.setVisible(true);
			}
		}
		
		public JLabel getLabel(){
			return lbl;
		}
	}
}
