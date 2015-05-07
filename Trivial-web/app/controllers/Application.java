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
        User user=new User(register.data().get("id"),register.data().get("password"));
        user.setPassword2(register.data().get("password2"));
        if(user.validatePass())
        {
            MongoDB mdb=new MongoDB();
            user.setAdmin("n");
            mdb.guardarUsuario(user.get_id(),user.getPassword(),user.getAdmin(),0,0);
            return login();
        }
        return irRegister();
    }
    public static Result salir()
    {
        session().clear();
        return login();
    }

    public static Result responder(String respuesta) throws UnknownHostException {

        System.out.println(respuesta);
        for(String r : ultima.getRespuestasCorrectas())
        {

            if(r.equals(respuesta))
            {
                if(ultima.getCategoria().equals("Entertainment"))
                {
                    quesos.queso1=true;
                }
                if(ultima.getCategoria().equals("Geography"))
                {
                    quesos.queso2=true;
                }
                if(ultima.getCategoria().equals("History"))
                {
                    quesos.queso3=true;
                }
                if(ultima.getCategoria().equals("Math"))
                {
                    quesos.queso4=true;
                }
                if(quesos.queso1 && quesos.queso2 && quesos.queso3 && quesos.queso4)
                {
                    MongoDB mdb=new MongoDB();
                    User user=mdb.getUser(session("user"));
                    mdb.guardarUsuario(user.get_id(),user.getPassword(),user.getAdmin(),user.getPartidasJugadas(),user.getPartidasganadas()+1);
                    return ok(victoria.render());
                }
                System.out.println(ultima.getCategoria());

                return turno("Has acertado","");
            }
        }
        return turno("","Fallaste");
    }


    public static Result jugar() throws UnknownHostException {
        MongoDB mdb=new MongoDB();
        preguntas=mdb.getPreguntas();
        User user=mdb.getUser(session("user"));
        mdb.guardarUsuario(user.get_id(),user.getPassword(),user.getAdmin(),user.getPartidasJugadas()+1,user.getPartidasganadas());

        return turno("","");

    }

    public static Result turno(String acierto, String fallo)
    {
        Random r=new Random();
        ultima=preguntas[r.nextInt(preguntas.length)];
        return ok(juego.render(ultima, Form.form(Respuesta.class),acierto, fallo, quesos));
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
            session("userDatos",user.get_id());
            return ok(datos.render(user));
        }

        return login();
    }


    public static Result modificarDatos() throws UnknownHostException {



            MongoDB mdb=new MongoDB();
            User user=mdb.getUser(session("userDatos"));

            Form<User> userF=userForm.bindFromRequest();
            if(userF.data().get("password")!=null && userF.data().get("password")!=null)
            {
                if(userF.data().get("password").equals(userF.data().get("password2")))
                {
                    System.out.println(userF.data().get("password"));
                    mdb.guardarUsuario(user.get_id(), userF.bindFromRequest().data().get("password"), user.getAdmin(), user.getPartidasJugadas(), user.getPartidasganadas());
                    System.out.println("Contraseña cambiada");
                    if(session("user").equals(session("userDatos")))
                    {
                        System.out.println("yuhu");
                        session("user",session("userDatos"));
                    }
                    return ok(main.render(mdb.getUser(session("user"))));
                }
            }

            return ok(datos.render(user));



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
        System.out.println("User: "+loginForm.data().get("id"));
        System.out.println("Pass: " + loginForm.data().get("password"));
        MongoDB mdb=new MongoDB();
        User user=mdb.getUser(loginForm.data().get("id"));
        System.out.println("Mongo: "+user);
        if(user!=null && user.getPassword().equals(loginForm.data().get("password")))
        {
            session("user", user.get_id());
            return ok(main.render(user));
        }

        return login();
    }


    static Form<User> userForm=Form.form(model.User.class);
    static Pregunta[] preguntas;
    static Pregunta ultima;
    static Queso quesos=new Queso();



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
        public String respuesta2;
        public String respuesta3;
        public String respuesta4;
        public String respuesta5;
        public String respuesta6;
        public String respuesta7;
        public String respuesta8;


    }

    public static class Queso
    {
        public boolean queso1=false;
        public boolean queso2=false;
        public boolean queso3=false;
        public boolean queso4=false;

    }
}


