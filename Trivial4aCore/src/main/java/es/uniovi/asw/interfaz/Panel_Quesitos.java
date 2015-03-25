package es.uniovi.asw.interfaz;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import es.uniovi.asw.trivial.model.Player;

@SuppressWarnings("serial")
public class Panel_Quesitos extends JPanel{

	Map<String,Quesito> quesitos = new HashMap<String,Quesito>();
	Player jugadorActual;
	
	public Panel_Quesitos(Player p, String[] categorias){
		this.jugadorActual = p;
		setOrganizacion(categorias.length);
		
		//Esto son pruebas
		addQuesitos(categorias);
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
			this.add(quesito.get());			
		}
	}
	
	public void agregarQuesito(boolean acierto, String categoria){
		if(acierto){
			jugadorActual.putQuesito(categoria);
			quesitos.get(categoria).setColor();
			this.revalidate();
			this.repaint();
		}
	}
}
