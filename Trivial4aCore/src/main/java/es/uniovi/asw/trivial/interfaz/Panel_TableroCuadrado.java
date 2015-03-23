package es.uniovi.asw.trivial.interfaz;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import es.uniovi.asw.trivial.game.Game;

@SuppressWarnings("serial")
public class Panel_TableroCuadrado extends JPanel{
	
	Map<Integer,JButton> casillas;
	
	public Panel_TableroCuadrado(int tam, Game juego, Map<Integer,JButton> casillas){
		this.casillas = casillas;
		setOrganizacion(tam);
		rellenarTablero(tam);
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
		
		ArrayList<JButton> arriba = new ArrayList<JButton>();
		ArrayList<JButton> abajo = new ArrayList<JButton>();
		ArrayList<JButton> izq = new ArrayList<JButton>();
		ArrayList<JButton> der = new ArrayList<JButton>();
 
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				//Si la posicion forma parte del interior
				if (i != 0 && i != filas - 1 && j != 0 && j != columnas - 1)
					agregarBoton(false);
				else {
					if (contadorCasillas < tam){						
						if(i==0)
							arriba.add(agregarBoton(true));
						else if(i>0 && i<filas-1 && j==0)
							izq.add(agregarBoton(true));
						else if(i>0 && i<filas-1 && j==columnas-1)
							der.add(agregarBoton(true));
						else if(i==filas-1)
							abajo.add(agregarBoton(true));
					}
					else  //Si no quedan mas posiciones
						agregarBoton(false);
					contadorCasillas++;
				}
			}
		}
		enumerarCasillas(der,arriba,izq,abajo);
	}
	
	private JButton agregarBoton(boolean visible){
		JButton btn = new JButton();
		btn.setVisible(visible);
		this.add(btn);
		return btn;
	}

	/**
	 * Enumera correctamente las casillas
	 * @param der
	 * @param arriba
	 * @param izq
	 * @param abajo
	 */
	protected void enumerarCasillas (ArrayList<JButton> der, 
			ArrayList<JButton> arriba, ArrayList<JButton> izq, 
			ArrayList<JButton> abajo){
		
		int enumeracion = 0;
		for(int i=der.size()-1; i>=0; i--){
			remplazar(der,i,enumeracion);
			casillas.put(enumeracion, der.get(i));
			enumeracion++;
		}
		for(int i=arriba.size()-1; i>=0; i--){
			remplazar(arriba,i,enumeracion);
			casillas.put(enumeracion, arriba.get(i));
			enumeracion++;
		}
		for(int i=0; i<izq.size(); i++){
			remplazar(izq,i,enumeracion);
			casillas.put(enumeracion,izq.get(i));
			enumeracion++;
		}
		for(int i=0; i<abajo.size(); i++){
			remplazar(abajo,i,enumeracion);
			casillas.put(enumeracion,abajo.get(i));
			enumeracion++;
		}
	}
	
	private void remplazar(ArrayList<JButton> list, int i, int enu){
		JButton btn = list.get(i);
		btn.setText(""+enu);
		list.set(i, btn);
	}
}
