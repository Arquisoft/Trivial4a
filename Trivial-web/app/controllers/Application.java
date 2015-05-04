package controllers;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.Pregunta;
import model.User;
import persistence.MongoDB;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.*;
import views.html.*;

import javax.persistence.Id;


public class Application extends Controller {


    public static Result login() {
        return ok(login.render(Form.form(Login.class)));
    }

    public static Result irRegister() {

        return ok(register.render(Form.form(Register.class)));
    }

    public static Result register() throws UnknownHostException {

        Form<Register> register=Form.form(Register.class).bindFromRequest();
        User user=new User(register.get().id,register.get().password);
        System.out.println("Cosas: "+register.get().id+register.get().password+register.get().password2);
        user.setPassword2(register.get().password2);
        if(user.validatePass())
        {
            MongoDB mdb=new MongoDB();
            mdb.guardarUsuario(user.get_id(),user.getPassword(),"no",0,0);
            return login();
        }
        return irRegister();
    }
    public static Result salir()
    {
        session().clear();
        return login();
    }


    public static Result jugar() throws UnknownHostException {
        preguntas=new MongoDB().getPreguntas();
        return turno();

    }

    public static Result turno()
    {
        Random r=new Random();
        Pregunta p=preguntas[r.nextInt(preguntas.length)];
        return ok(juego.render(p, Form.form(Respuesta.class)));
    }

    public static Result principal() throws UnknownHostException {
        MongoDB mdb=new MongoDB();

        return ok(main.render(mdb.getUser(session("user"))));
    }
    public static Result irDatos(String userId) throws UnknownHostException {

        MongoDB mdb=new MongoDB();
        User user=mdb.getUser(userId);
        System.out.println(user.get_id());
        if(user!=null)
        {
            return ok(datos.render(user));
        }

        return login();
    }


    public static Result modificarDatos() {

        if(session().containsKey("user"))
        {
            User user=userForm.bindFromRequest().get();
            if(user.getPassword()!=null && user.getPassword2()!=null)
            {
                if(user.getPassword().equals(user.getPassword2()))
                {
                    user.setPassword(user.getPassword());
                    System.out.println("Contraseña cambiada");
                    return ok(main.render(user));
                }
            }

            return ok(datos.render(user));
        }

            return login();
    }


    public static Result mostrarUsuarios() throws UnknownHostException {
        MongoDB mdb=new MongoDB();
        List<User> usersList=mdb.getUsuarios();
        System.out.println(usersList.size());
        System.out.println(usersList.get(0));
        return ok(users.render(usersList));
    }

    public static Result authenticate() throws UnknownHostException {


        // Login loginForm =Form.form(Login.class).bindFromRequest().get();
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        System.out.println(loginForm);
        System.out.println("User: "+loginForm.get().id);
        System.out.println("Pass: " + loginForm.get().password);
        MongoDB mdb=new MongoDB();
        User user=mdb.getUser(loginForm.get().id);
        if(user!=null && user.getPassword().equals(loginForm.get().password))
        {
            session("user", user.get_id());
            return ok(main.render(user));
        }

        return login();
    }


    static Form<User> userForm=Form.form(model.User.class);
    static Pregunta[] preguntas;




     ///////////////////////////////////
     public static class Login{


         public String id;
         public String password;

     }

    public static class Register{

        public String id;
        public String password;
        public String password2;
    }

    public static class Respuesta
    {
        public String respuesta;
    }
}


