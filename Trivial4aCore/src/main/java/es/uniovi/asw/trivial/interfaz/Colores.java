package es.uniovi.asw.trivial.interfaz;

import java.awt.Color;
import java.util.Random;

public class Colores {

	// Lista de posibles colores
	Color[] colores = new Color[]{Color.BLACK, Color.BLUE,Color.RED,
			Color.YELLOW, Color.ORANGE, Color.PINK, Color.GRAY, 
			Color.GREEN}; //El blanco no se incluye porque se usa
						  //para saber donde esta el jugador actual
	
	//Se usa para comprobar que no se repitan colores
	boolean[] elegidos = new boolean[colores.length];
	
	//Colores asociados con sus respectivas categorias
	ColorCategoria[] coloresElegidos;
	
	public Colores(String[] categorias){
		coloresElegidos = new ColorCategoria[categorias.length];
		setColores(categorias);
	}
	
	//Asocia cada color con una categoria de forma aleatoria
	private void setColores(String[] categorias){
		Random r = new Random();
		for(int i=0; i<coloresElegidos.length; i++){
			boolean asociado = false;
			while(!asociado){
				int siguiente = r.nextInt(colores.length);
				if(!elegidos[siguiente]){
					coloresElegidos[i] = new ColorCategoria(colores[siguiente],categorias[i]);
					elegidos[siguiente] = true;
					asociado = true;
				}
			}
		}
	}
	
	/**
	 * Devuelve un color segun una categoria
	 * @param categoria
	 * @return color
	 */
	public Color getColor(String categoria){
		for(ColorCategoria cc : coloresElegidos)
			if(cc.categoria.equals(categoria))
				return cc.color;
		return null;
	}
	
	
	///////////////////////////////////////
	// Esta clase asocia un color con una categoria
	//////////////////////////////////////
	public class ColorCategoria{
		private Color color;
		private String categoria;
		
		public ColorCategoria(Color color, String categoria){
			this.color = color;
			this.categoria = categoria;
		}
		
		public Color getColor(){
			return color;
		}
		public String getCategoria(){
			return categoria;
		}
	}
}
