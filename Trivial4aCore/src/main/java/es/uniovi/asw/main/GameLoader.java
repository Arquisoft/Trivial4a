package es.uniovi.asw.main;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

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
    	 nCategorias=0;
    	 users = new ArrayList<User>();
    	 admin = bd.getUser(ADMINISTRADOR);
		}

	public static void main(String[] args) throws UnknownHostException {
//		new Loader().run(args[0]);
        MongoClient m = new MongoClient("localhost");
        DBCursor cursor = m.getDB("mydb").getCollection("preguntas").find();

        while (cursor.hasNext()) {
            System.out.println(cursor.next().get("respuestas"));
        }
    }

    /**
     * Coge todas las preguntas de la base de datos y los guarda en los atributos
     * @throws UnknownHostException 
     */
    private void cargarDatos() throws UnknownHostException {
       
        preguntas = bd.getPreguntas();
        
      
        List<String> categorias = new ArrayList<String>();
        
        for(int i=0;i<preguntas.length;i++)
        	if(!categorias.contains(preguntas[i].getCategoria())){
        		categorias.add(preguntas[i].getCategoria());
        		nCategorias++;
        	}
        	
    	
    }

    /**
     * PRIMERO: comprueba que haya menos usuarios que categorias logueados
     * no permite más usuarios logueados que categoris
     * Comprueba que el usuario y contrasenha introducidos son correctos
     *
     * @param usuario, pass
     * @return true si login correcto
     * @throws UnknownHostException 
     */
    public boolean comprobarLogin(String usuario, String pass) throws UnknownHostException {
        
    	
    	if(users.size()<nCategorias)
    	{
    		User user = bd.getUser(usuario);
    		
    		if(user==null)
    		{
    			System.err.println("No existe usuario");
    			return false;
    		}
    		
    		if(!user.getContrasena().equals(pass))
    		{
    			System.err.println("Pass incorrecta");
    			return false;
    		}
    		else{
    			users.add(user);
    			return true;
    		}
    			
    	}

        return false;
    }
    
    
    /**
     * Comprueba si el usuario administrador ha sido logueado correctamente
     * 
     * @param user
     * @param pass
     * @return
     */
    private boolean loginAdmin(String user, String pass)
    {
    	if(admin.get_id().equals(user) && admin.getContrasena().equals(pass))
    	return true;
    	
    	System.err.println("Usuario o pass incorrectas");
    	return false;
    }

    /**
     * PRIMERO: comprueba que haya menos usuarios que categorias logueados
     * si se ha llegado al maximo de jugadores, guardará este en la base de datos pero no lo creará en el juego
     * <p/>
     * <p/>
     * Registra un usuario nuevo, comprueba que el nombre no exista, si es todo correcto crea new User()
     *
     * @param usuario, pass
     * @return true si lo registra correctamente
     * @throws UnknownHostException 
     */
    public boolean registroNuevoUser(String usuario, String pass) throws UnknownHostException {
      
    	User user = bd.getUser(usuario);
    	
        if(user==null)
        {
        	bd.guardarUsuario(user.get_id(),user.getContrasena());
        	
        	if(users.size()<nCategorias)
        	{
        		users.add(user);
        		return true;
        	}
        	else
        		System.err.println("Superado limite de usuarios, se anhade a bd pero no podra jugar");       	
        }else
           	System.err.println("El usuario ya existe");
        
    	return false;
        
    }


    /**
     * Quita de la lista de jugadores un usuario que ya se haya loggeado
     *
     * @param p
     */
    public void deletePlayer(User p) {

       if(!users.remove(p))
    	   System.err.println("El usuario no esta jugando");

    }

    public void DadoSize(int min, int max)
    {
    	dado.getInstance(min, max);
    }

    public void cambiarDado(int min,int max)
    {
    	dado.setDado(min, max);
    }
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
    public void startGame(User[] usuarios, Pregunta[] preguntas, int tam, Dado dado) {

    }

}
