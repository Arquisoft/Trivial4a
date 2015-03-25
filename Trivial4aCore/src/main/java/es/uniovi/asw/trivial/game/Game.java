package es.uniovi.asw.trivial.game;

import es.uniovi.asw.trivial.model.Player;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;

/**
 * Para usar una clase Game debe usarse GameFactory para obtener una referencia.
 *
 * @author Jorge
 */
public interface Game {

    /**
     * Empezar partida.
     * Debe ejecutarse este metodo antes de empezar a jugar.
     *
     * @param usuarios  Cojuntos de <b>usuarios</b> que van a jugar.
     * @param preguntas Conjunto de preguntas que se usarán en el juego
     * @param tam       numero de casillas del tablero
     * @param min       numero maximo del dado
     * @param max       numero minimo del dado
     */
    public void startGame(User[] usuarios, Pregunta[] preguntas, int tam, int min, int max);

    /**
     * Finalizar partida.
     * Debe ejecutarse esta funcion para guardar los resutados en la base de datos.
     */
    public int endGame();

    /**
     * @return La lista de los jugadores.
     */
    public Player[] getPlayers();

    /**
     * @return El jugador actual.
     */
    public Player getCurrentPlayer();

    /**
     * @param posicion
     * @return En nombre de la categoría de la posicion especificada.
     */
    public String getCategoryname(int posicion);

    /**
     * Retorna una pregunta aleatoria de la categoría asignada a la posicion de entrada.
     *
     * @param posicion
     * @return
     */
    public Pregunta getQuestionSet(int posicion);

    /**
     * Retorna una pregunta aleatoria de la categoría asignada a la posicion de entrada.
     *
     * @param posicion
     * @return
     */
    public Pregunta getQuestionSet(String posicion);

    /**
     * Este metodo se usa para asignar al jugador actual una respuesta a determinada pregunta.
     * Automaticamente se actualiza el jugador actual.
     *
     * @return "Playing" El juego sigue. "End" Alguien ha completado el objetivo del juego y debe finalizarse con endGame().
     */
    public String answerQuestionSet(Pregunta pregunta, String respuesta);

    /**
     * @return numero aleatorio entre MIN y MAX.
     */
    public int diceGetNumer();

    /**
     * @param moves debe +-<i>diceGetNumer()</i>
     * @return
     */
    public String movePlayer(int moves);

    /**
     * @return array de categorias
     */
    public String[] getCategorias();
    
    /**
     * @return numero total de casillas
     */
    public int getNumCasillas();


}