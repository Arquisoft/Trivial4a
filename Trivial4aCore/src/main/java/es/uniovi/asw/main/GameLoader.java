package es.uniovi.asw.main;

import es.uniovi.asw.trivial.game.Game;
import es.uniovi.asw.trivial.game.GameFactory;
import es.uniovi.asw.trivial.model.Dado;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;
import es.uniovi.asw.trivial.persistence.MongoDB;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class GameLoader {

	private static final String ADMINISTRADOR = "admin";
	private User admin;
	private MongoDB bd;
	private Pregunta[] preguntas;
	private List<User> users;
	private int nCategorias;
	private Dado dado;

	public GameLoader() throws UnknownHostException {
		bd = new MongoDB();
		nCategorias = 0;
		users = new ArrayList<User>();
		admin = bd.getUser(ADMINISTRADOR);
		cargarDatos();
	}

	// public static void main(String[] args) throws UnknownHostException {
	// new Loader().run(args[0]);
	// MongoClient m = new MongoClient("localhost");
	// DBCursor cursor = m.getDB("mydb").getCollection("preguntas").find();
	//
	// while (cursor.hasNext()) {
	// System.out.println(cursor.next().get("respuestas"));
	// }
	// }

	public Dado getDado() {
		return dado;
	}

	public MongoDB getConexion() {
		return bd;
	}

	public List<User> getUsuarios() {
		return users;
	}

	public Pregunta[] getPreguntas() {
		return preguntas;
	}

	/**
	 * Coge todas las preguntas de la base de datos y los guarda en los
	 * atributos
	 * 
	 * @throws UnknownHostException
	 */
	private void cargarDatos() throws UnknownHostException {

		preguntas = bd.getPreguntas();

		List<String> categorias = new ArrayList<String>();

		for (int i = 0; i < preguntas.length; i++)
			if (!categorias.contains(preguntas[i].getCategoria())) {
				categorias.add(preguntas[i].getCategoria());
				nCategorias++;
			}

	}

	/**
	 * PRIMERO: comprueba que haya menos usuarios que categorias logueados no
	 * permite más usuarios logueados que categoris Comprueba que el usuario y
	 * contrasenha introducidos son correctos
	 *
	 * @param usuario
	 *            , pass
	 * @return true si login correcto
	 * @throws UnknownHostException
	 */
	public boolean comprobarLogin(String usuario, String pass)
			throws UnknownHostException {
		if (users.size() == nCategorias) {
			return false;
		}
		User user = bd.getUser(usuario);

		if (user == null) {
			System.err.println("No existe usuario");
			return false;
		}
		System.out.println(user);

		if (!user.getContrasena().equals(pass)) {
			System.err.println("Pass incorrecta");
			return false;
		}

		users.add(user);
		return true;
	}

	/**
	 * Comprueba si el usuario administrador ha sido logueado correctamente
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean loginAdmin(String user, String pass) {
		if (admin.get_id().equals(user) && admin.getContrasena().equals(pass))
			return true;

		System.err.println("Usuario o pass incorrectas");
		return false;
	}

	/**
	 * PRIMERO: comprueba que haya menos usuarios que categorias logueados si se
	 * ha llegado al maximo de jugadores, guardará este en la base de datos pero
	 * no lo creará en el juego
	 * <p/>
	 * <p/>
	 * Registra un usuario nuevo, comprueba que el nombre no exista, si es todo
	 * correcto crea new User()
	 *
	 * @param usuario
	 *            , pass
	 * @return true si lo registra correctamente
	 * @throws UnknownHostException
	 */
	public boolean registroNuevoUser(String usuario, String pass)
			throws UnknownHostException {

		User user = bd.getUser(usuario);

		if (user == null) {

			bd.guardarUsuario(usuario, pass);

			if (users.size() < nCategorias) {
				users.add(new User(usuario, pass));
				return true;
			} else
				System.err
						.println("Superado limite de usuarios, se anhade a bd pero no podra jugar");
		} else
			System.err.println("El usuario ya existe");

		return false;

	}

	/**
	 * Quita de la lista de jugadores un usuario que ya se haya loggeado
	 *
	 * @param p
	 */
	public boolean deletePlayer(String nombre) {

		for (User usuario : users) {
			if (usuario.get_id().equals(nombre)) {
				users.remove(usuario);
				return true;
			}
		}
		System.err.println("El usuario no esta jugando");
		return false;
	}

	public void DadoSize(int min, int max) {
		dado = new Dado(min, max);
	}

	public void cambiarDado(int min, int max) {
		dado.setDado(min, max);
	}

	/**
	 * Empezar partida. Debe ejecutarse este metodo antes de empezar a jugar.
	 *
	 * @param usuarios
	 *            Cojuntos de <b>usuarios</b> que van a jugar.
	 * @param preguntas
	 *            Conjunto de preguntas que se usarán en el juego
	 * @param tam
	 *            numero de casillas del tablero
	 * @param min
	 *            numero maximo del dado
	 * @param max
	 *            numero minimo del dado
	 * @throws UnknownHostException
	 */
	public void startGame(User[] usuarios, Pregunta[] preguntas, int tam,
			Dado dado, MongoDB conexion) throws UnknownHostException {
		@SuppressWarnings("unused")
		Game g = GameFactory.getNewGame();
	}

}
