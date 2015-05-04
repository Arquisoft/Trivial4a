package model;

import persistence.MongoDB;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.Required;

import javax.persistence.*;
import java.net.UnknownHostException;

@Entity
public class User extends Model{

        @Id
        private String _id;

        @Required
        private String password;

        private String password2;
        private String admin;
        private int partidasJugadas;
        private int partidasGanadas;


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword2() {
        return password2;
    }

        public void setPassword2(String password) {
            this.password2 = password;
         }

        public boolean validatePass()
        {
            return password.equals(password2);
        }
        public String getAdmin() {
            return admin;
        }

        public void setAdmin(String admin) {
            if(admin.equalsIgnoreCase("n"))
                this.admin = "N";
            if(admin.equalsIgnoreCase("y"))
                this.admin = "Y";
        }

        public int getPartidasJugadas() {
            return partidasJugadas;
        }

        public void setPartidasJugadas(int partidasJugadas) {
            this.partidasJugadas = partidasJugadas;
        }

        public int getPartidasganadas() {
            return partidasGanadas;
        }

        public void setPartidasganadas(int partidasganadas) {
            this.partidasGanadas = partidasganadas;
        }



        public User(String _id) {

            this._id = _id;
        }

        public User(String _id, String password) {
            this._id = _id;
            this.password = password;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        @Override
        public String toString() {
            return "User [_id=" + _id + "]";
        }

        public String getContrasena() {
            return password;
        }

        public void setContrasena(String contrasena) {
            this.password = contrasena;
        }



}