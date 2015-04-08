package es.uniovi.asw.componentesDeInterfaz;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import es.uniovi.asw.interfaz.VentanaJuego;
import es.uniovi.asw.trivial.model.Player;

@SuppressWarnings("serial")
public class Panel_Quesitos extends JPanel{

	Map<String,Quesito> quesitos = new HashMap<String,Quesito>();
	
	public Panel_Quesitos(){
		setOrganizacion();
		generarQuesitos();
	}
	
	/**
	 * Actualiza el panel de los quesitos
	 * mostrando aquellos que el jugador
	 * actual tenga
	 */
	public void actualizarQuesitos(Player jugadorActual){
		for(Quesito quesito : quesitos.values()){
			if(jugadorActual.findQuesitos(quesito.getCategoria()))
					quesito.setColor(true);
			else
				quesito.setColor(false);
		}
	}
	
	/**
	 * Indica que layout tendra
	 * en funcion de su tamanyo
	 */
	private void setOrganizacion(){
		int tam = VentanaJuego.juego.getCategorias().length;
		if(tam==1)
			this.setLayout(new GridLayout(1,1));
		else if(tam==2)
			this.setLayout(new GridLayout(2,1));
		else if(tam==3 || tam==4)
			this.setLayout(new GridLayout(2,2));
		else if(tam==5 || tam==6)
			this.setLayout(new GridLayout(3,2));
	}
	
	/**
	 * Genera botones quesito sin color
	 * (ya que aun no estan asignados
	 * a ningun jugador)
	 */
	private void generarQuesitos(){
		String[] categorias = VentanaJuego.juego.getCategorias();
		for(int i=0; i<categorias.length; i++){
			Quesito quesito = new Quesito(categorias[i],
					VentanaJuego.colores.getColor(categorias[i]));
			quesitos.put(categorias[i], quesito);
			this.add(quesito);			
		}
	}
}
