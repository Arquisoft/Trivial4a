package es.uniovi.asw.trivial.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.uniovi.asw.trivial.model.Player;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.Respuesta;
import es.uniovi.asw.trivial.model.User;


public class GameObject implements Game{

	GameObject() {}
	
	
	//TODO private {usuario,pregunta,isCorrect}[] tuplas
	private Player[] players;
	private Pregunta[] preguntas;
	private int jugadorActual;
	private List<Respuesta> respuestas;
	
	//Informacion de control
	private int tam;
	private int min;
	private int max;
	private String[] categorias;
	private int nCategorias;
	

	public void startGame(User[] usuarios, Pregunta[] preguntas, int tam,
			int min, int max) {		
		this.players = createPlayers(usuarios);
		this.preguntas = preguntas;
		this.tam = tam;
		this.min = min;
		this.max = max;
		this.categorias = categoryCount(preguntas);
		this.jugadorActual = 0;
		respuestas = new ArrayList<Respuesta>();
	}

	
	private String[] categoryCount(Pregunta[] preguntas) {
		List<String> aux = new ArrayList<String>();
		for(Pregunta p : preguntas)
			if(!aux.contains(p.getCategoria()))
				aux.add(p.getCategoria());
		
		String[] categorias ={};
		categorias =  aux.toArray(categorias);
				
		
		this.nCategorias=categorias.length;
		return categorias;
	}


	private Player[] createPlayers(User[] usuarios) {
		
		Player[] players = new Player[usuarios.length];
		for(int i=0;i<players.length;i++)
			players[i]= new Player(usuarios[i],0);
		
		return players;
	}

	public int endGame() {
		String[] auxRespuestas = {};
		auxRespuestas = respuestas.toArray(auxRespuestas);
		//TODO pasarlo al mongo
		return 0;
	}

	public Player[] getPlayers() {
		return players;
	}

	public Player getCurrentPlayer() {
		return players[jugadorActual];
	}

	public String getCategoryname(int posicion) {
		return categorias[posicion%nCategorias];
	}

	public Pregunta getQuestionSet(int posicion) {
		/* TODO Crear en MongoDB un metodo con un funcionamiento pareciso al siguiente:
		ResultSet sr = db.preguntas.find(categoria, getCategoryname(posicion);
		
		TODO Obtener una pregunta aleatoria del SerultSet anterior
		// */
		return null;
	}

	public Pregunta getQuestionSet(String posicion) {
		return getQuestionSet(Integer.parseInt(posicion));
	}

	public String answerQuestionSet(Pregunta pregunta, String respuesta) {
		 //	TODO Almacenar la respuesta de tuplas
		 
		 //	TODO Añadirle al jugador un quesito de la categoría acertada
		 //		TODO añadirle los quesitos ganados a la clase jugador
		
		 //TODO Poner logica de negocio
		 if( players[jugadorActual].getPosicion()==tam-1 && todosLosQuesos(players[jugadorActual]))
			 return "End";
		 
		 //if( not PreguntaCorrecta)
		 	nextPlayer();
		return "Playing";
	}

	private boolean todosLosQuesos(Player player) {
		// TODO true si el jugador tiene tantos quesos como categirias hay en el juego
		return false;
	}


	private void nextPlayer(){
		jugadorActual = jugadorActual==players.length-1 ? 0 : jugadorActual+1 ;
	}
	
	public int diceGetNumer() {
		Random r = new Random();
		int valorDado = r.nextInt(max)+min;
		return valorDado;
	}

	public String movePlayer(int moves) {
		players[jugadorActual].setPosicion(players[jugadorActual].getPosicion()+moves);
		return "Player on "+players;
	}

}
