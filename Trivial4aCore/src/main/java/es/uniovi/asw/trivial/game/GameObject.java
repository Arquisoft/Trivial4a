package es.uniovi.asw.trivial.game;

import es.uniovi.asw.trivial.model.Contestacion;
import es.uniovi.asw.trivial.model.Player;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameObject implements Game {

    private Player[] players;
    private Pregunta[] preguntas;
    private int jugadorActual;
    private List<Contestacion> respuestas;
    //Informacion de control
    private int tam;
    private int min;
    private int max;
    private String[] categorias;
    private int nCategorias;
    GameObject() {
    }

    public void startGame(User[] usuarios, Pregunta[] preguntas, int tam,
                          int min, int max) {

        this.players = createPlayers(usuarios);
        this.preguntas = preguntas;
        this.tam = tam;
        this.min = min;
        this.max = max;
        this.categorias = categoryCount(preguntas);
        this.jugadorActual = 0;
        respuestas = new ArrayList<Contestacion>();
    }


    private String[] categoryCount(Pregunta[] preguntas) {
        List<String> aux = new ArrayList<String>();
        for (Pregunta p : preguntas)
            if (!aux.contains(p.getCategoria()))
                aux.add(p.getCategoria());

        String[] categorias = {};
        categorias = aux.toArray(categorias);


        this.nCategorias = categorias.length;
        return categorias;
    }


    private Player[] createPlayers(User[] usuarios) {

        Player[] players = new Player[usuarios.length];
        for (int i = 0; i < players.length; i++)
            players[i] = new Player(usuarios[i], 0);

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
        return categorias[posicion % nCategorias];
    }

    public Pregunta getQuestionSet(int posicion) {

        String categoria = getCategoryname(posicion);

        List<Pregunta> preguntasAux = new ArrayList<Pregunta>();

        for (Pregunta p : preguntas)
            if (p.getCategoria().equals(categoria))
                preguntasAux.add(p);

        Random r = new Random();


        return preguntasAux.get(r.nextInt(preguntasAux.size()));
    }

    public Pregunta getQuestionSet(String posicion) {
        return getQuestionSet(Integer.parseInt(posicion));
    }

    public String answerQuestionSet(Pregunta pregunta, String respuesta) {

        User user = getCurrentPlayer().getUser();
        respuestas.add(new Contestacion(user, pregunta, isCorrecta(pregunta, respuesta)));
        //el añadir el quesito devuelve un booleano con si lo añadio en función de si lo tenía ya o no, por si lo queremos decir
        if (respuestas.get(respuestas.size() - 1).isCorrecta()) {
            getCurrentPlayer().putQuesito(pregunta.getCategoria());

            if (players[jugadorActual].getPosicion() == tam - 1 && todosLosQuesos(players[jugadorActual]))
                return "End";
        } else
            nextPlayer();
        return "Playing";
    }

    private boolean isCorrecta(Pregunta pregunta, String respuesta) {
        // TODO Auto-generated method stub
        String[] auxRespuestas = pregunta.getRespuestasCorrectas();
        for (int i = 0; i < auxRespuestas.length; i++)
            if (auxRespuestas[i].equals(respuesta))
                return true;

        return false;
    }


    private boolean todosLosQuesos(Player player) {

        return player.getQuesitos().size() == nCategorias;
    }


    private void nextPlayer() {
        jugadorActual = jugadorActual == players.length - 1 ? 0 : jugadorActual + 1;
    }

    public int diceGetNumer() {
        Random r = new Random();
        int valorDado = r.nextInt(max) + min;
        return valorDado;
    }

    public String movePlayer(int moves) {

        int posicionFinal = players[jugadorActual].getPosicion() + moves;

        if (posicionFinal < tam && posicionFinal>=0)
            players[jugadorActual].setPosicion(posicionFinal);
        else if(posicionFinal<0){
        	players[jugadorActual].setPosicion(tam-1+posicionFinal);
        }
        else {
            posicionFinal = posicionFinal - (tam - 1);
            players[jugadorActual].setPosicion(posicionFinal);
        }
        return players[jugadorActual].toString();
    }

    public String[] getCategorias() {
        return this.categorias;
    }
    
    public int getNumCasillas(){
    	return tam;
    }
    
    public Player siguienteJugador(){
    	if(jugadorActual<(players.length-1))
    		jugadorActual++;
    	else
    		jugadorActual = 0;
    	return players[jugadorActual];
    }

}
