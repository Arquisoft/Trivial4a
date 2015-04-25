package controllers;

import java.util.Map;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.User;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.*;
import views.html.*;


public class Application extends Controller {


    public static Result login() {
        return ok(login.render(Form.form(Login.class)));
    }

    public static Result salir()
    {
        session().clear();
        return login();
    }
    public static Result irDatos() {
        User us=new User("caca","caca");
        us.setNumPartidas(100);
        us.setNumPartidasGanadas(0);
        return ok(datos.render(us));
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
                    user.setLog("Contraseña cambiada");
                    return ok(main.render(user));
                }
            }

            return ok(datos.render(user));
        }

            return login();
    }



    public static Result authenticate() {

        Login loginForm =Form.form(Login.class).bindFromRequest().get();
        User usuario=new User(loginForm.id,loginForm.password);
        System.out.println("User: "+loginForm.id);
        System.out.println("Pass: "+loginForm.password);

        if(usuario.validate(usuario.getId(),usuario.getPassword()))
        {
            session("user", usuario.getId());
            return ok(main.render(usuario));

        }

        return ok();
    }


    static Form<User> userForm=Form.form(model.User.class);




     ///////////////////////////////////
     public static class Login {

         public String id;
          public String password;

     }
}


