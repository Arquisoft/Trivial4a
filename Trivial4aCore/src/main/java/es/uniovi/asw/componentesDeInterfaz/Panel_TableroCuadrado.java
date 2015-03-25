package es.uniovi.asw.componentesDeInterfaz;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import es.uniovi.asw.interfaz.VentanaJuego;
import es.uniovi.asw.trivial.game.Game;

/**
 * Esta clase es el panel donde se moveran los jugadores
 * @author Santiago
 *
 */
@SuppressWarnings("serial")
public class Panel_TableroCuadrado extends JPanel{
	
	Map<Integer,Casilla> casillas;
	
	public Panel_TableroCuadrado(){
		casillas = new HashMap<Integer,Casilla>();
		setOrganizacion(VentanaJuego.juego.getNumCasillas());
		rellenarTablero(VentanaJuego.juego.getNumCasillas());
	}
	
	/**
	 * Establece el layout para el panel tablero y el panel de los quesitos de
	 * forma dinamica
	 * 
	 * @param nElementos
	 * @param panel
	 *            quesitos o panel Tablero
	 */
	private void setOrganizacion(int nElementos) {
		if (nElementos == 0) {
			System.err.println("Numero de elementos = 0");
			return;
		}

		double proporcion = nElementos / 4.0;

		// IMPORTANTE: una proporcion de 0,25 daria como resultado
		// un tablero o quesito con un hueco vacio
		if (proporcion - (int) proporcion == 0.25) {
			if (nElementos >= 5)
				set_0_5_25(++nElementos);
			else
				// Si es igual a 1 (Siempre es 1 si entra por aqui)
				this.setLayout(new GridLayout(1, 0, 0, 0));
		}

		else if (proporcion - (int) proporcion == 0.5) {
			if (nElementos >= 10)
				set_0_5_25(nElementos);
			else if (nElementos == 6) // Si es igual a 6
				this.setLayout(new GridLayout(2, 3, 0, 0));
			else
				// Si es igual a 2 (Siempre es 2 si entra por aqui)
				this.setLayout(new GridLayout(0, 2, 0, 0));
		}

		// IMPORTANTE: una proporcion de 0,25 daria como resultado
		// un tablero o quesito con un hueco vacio
		else if (proporcion - (int) proporcion == 0.75) {
			if (nElementos >= 7)
				// Al hacer nElementos++ se crea una tabla parecida a
				// si tuvieramos 0 pero con un hueco vacio
				set_75(++nElementos);
			else
				// Si es igual a 3 (Siempre es 3 si entra por aqui)
				this.setLayout(new GridLayout(3, 0, 0, 0));
		}

		else if (proporcion - (int) proporcion == 0 && nElementos >= 4) {
			// Establecer proporciones iniciales
			int ancho = (int) proporcion + 1;
			int largo = (int) proporcion + 1;
			this.setLayout(new GridLayout(ancho, largo, 5, 0));
		}
	}
	
	/**
	 * Establece el layout si el resultado de dividir
	 * nElementos/4 es igual a X'0, X'5 o X'25
	 * @param nElementos
	 */
	private void set_0_5_25(int nElementos) {
		int mitad = nElementos / 2;
		int ancho = (int) (mitad / 2) + 1;
		int largo = (int) (mitad / 2) + 2;
		this.setLayout(new GridLayout(ancho, largo, 0, 0));
	}

	/**
	 * Establece el layout si el resultado de dividir
	 * nElementos/4 es igual a X'0, X'5 o X'25
	 * @param nElementos
	 */
	private void set_75(int nElementos) {
		int mitad = nElementos / 2;
		int ancho = (int) (mitad / 2) + 1;
		int largo = (int) (mitad / 2) + 1;
		this.setLayout(new GridLayout(ancho, largo, 0, 0));
	}
	
	
	/**
	 * Rellena el tablero segun un tamaño
	 * Ordenando las casillas al final
	 * @param tam
	 */
	protected void rellenarTablero(int tam) {
		GridLayout gl = (GridLayout) this.getLayout();
		int columnas = gl.getColumns();
		int filas = gl.getRows();
		int contadorCasillas = 0;
		
		ArrayList<Casilla> arriba = new ArrayList<Casilla>();
		ArrayList<Casilla> abajo = new ArrayList<Casilla>();
		ArrayList<Casilla> izq = new ArrayList<Casilla>();
		ArrayList<Casilla> der = new ArrayList<Casilla>();
 
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				//Si la posicion forma parte del interior
				if (i != 0 && i != filas - 1 && j != 0 && j != columnas - 1)
					agregarBotonVacio();
				else {
					if (contadorCasillas < tam){						
						if(i==0)
							arriba.add(agregarCasilla());
						else if(i>0 && i<filas-1 && j==0)
							izq.add(agregarCasilla());
						else if(i>0 && i<filas-1 && j==columnas-1)
							der.add(agregarCasilla());
						else if(i==filas-1)
							abajo.add(agregarCasilla());
					}
					else  //Si no quedan mas posiciones
						agregarBotonVacio();
					contadorCasillas++;
				}
			}
		}
		enumerarCasillas(der,arriba,izq,abajo);
	}
	
	/**
	 * Añade al panel un boton invisble
	 */
	private void agregarBotonVacio(){
			JButton btn = new JButton();
			btn.setVisible(false);
			this.add(btn);
	}
	
	/**
	 * Añade al panel una casilla visible
	 * @return
	 */
	private Casilla agregarCasilla(){
		Casilla casilla = new Casilla();
		casilla.setVisible(true);
		this.add(casilla);
		return casilla;
	}

	/**
	 * Enumera correctamente las casillas
	 * @param der
	 * @param arriba
	 * @param izq
	 * @param abajo
	 */
	protected void enumerarCasillas (ArrayList<Casilla> der, 
			ArrayList<Casilla> arriba, ArrayList<Casilla> izq, 
			ArrayList<Casilla> abajo){
		
		int enumeracion = 0;
		for(int i=der.size()-1; i>=0; i--){
			casillas.put(enumeracion, actualizarCasilla(der,i,enumeracion));
			enumeracion++;
		}
		for(int i=arriba.size()-1; i>=0; i--){
			casillas.put(enumeracion, actualizarCasilla(arriba,i,enumeracion));
			enumeracion++;
		}
		for(int i=0; i<izq.size(); i++){
			casillas.put(enumeracion,actualizarCasilla(izq,i,enumeracion));
			enumeracion++;
		}
		for(int i=0; i<abajo.size(); i++){
			casillas.put(enumeracion,actualizarCasilla(abajo,i,enumeracion));
			enumeracion++;
		}
	}
	
	/**
	 * Actualiza las casillas dandoles
	 * un indice y un color
	 * @param list (lista de los 4 lados)
	 * @param i (posicion dentro de la lista)
	 * @param enu (indice de la propia casilla)
	 * @return casilla modificada
	 */
	private Casilla actualizarCasilla(ArrayList<Casilla> list, int i, int enu){
		Casilla casilla = list.get(i);
		casilla.setPosicion(enu);
		return casilla;
	}
}
