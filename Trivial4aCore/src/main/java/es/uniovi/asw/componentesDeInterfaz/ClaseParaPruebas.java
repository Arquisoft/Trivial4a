package es.uniovi.asw.componentesDeInterfaz;

import java.net.UnknownHostException;

import es.uniovi.asw.trivial.game.Game;
import es.uniovi.asw.trivial.game.GameFactory;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;
import es.uniovi.asw.trivial.persistence.MongoDB;

/**
 * Esta clase solo se usara para hacer pruebas
 */
public class ClaseParaPruebas {

	private static Game g = GameFactory.getNewGame();
	
	private static User[] usuarios;
	private static Pregunta[] preguntas;
	private static MongoDB bd;
	
	
	public static Game juegoPruebaSinBBDD(int nCasillas, int nUsuarios, int min, int max){
		generarUsuarios(nUsuarios);
		crearPreguntas(40,2);
		g.startGame(usuarios, preguntas, nCasillas, min, max);
		return g;
	}
	
	
	public static Game juegoPruebaConBBDD(int nCasillas, int nUsuarios, int min, int max){
		generarUsuarios(nUsuarios);
		g.startGame(usuarios, cargarPreguntas(), nCasillas, min, max);
		return g;
	}
	
	private static Pregunta[] cargarPreguntas(){
		try {
			return bd.getPreguntas();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Genera usuarios que tienen como nombre
	 * los caracteres de numero 0 hasta n-1
	 * @param n
	 */
	private static void generarUsuarios(int n){
		usuarios = new User[n];
		for(int i=80; i<(n+80); i++){
			char[] caracter = new char[]{(char)i};
			String letra = new String(caracter);
			usuarios[(i-80)] = new User(letra);
		}
	}
	
	private static void crearPreguntas(int n, int resp){
		preguntas = new Pregunta[n];
		for(int i=0; i<n; i++){
			String id = "id_" + i;
			String pregunta = "Pregunta " + i + "?";
			String[] respCorrectas = new String[resp];
			String[] respIncorrectas = new String[resp];
			String categoria = "Categoria ";
			
			if(i<n/5)
				categoria += "A";
			else if(i<(n/5*2))
				categoria += "B";
			else if(i<(n/5*3))
				categoria += "C";
			else if(i<(n/5*4))
				categoria += "D";
			else
				categoria += "E";
			
			for(int k=0; k<resp; k++){
				respCorrectas[k] = "Respuesta Correcta " + k;
				respIncorrectas[k] = "Respuesta Incorrecta " + k;
			}
			preguntas[i] = new Pregunta(id,pregunta,categoria,respCorrectas,respIncorrectas);
		}
	}
}
