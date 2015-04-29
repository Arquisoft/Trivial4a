package model;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.Required;

import javax.persistence.*;

@Entity
public class User extends Model{

    @Id
    private String id;

    @Required
    private String password;
    private String password2;

    private int numPartidas;
    private int numPartidasGanadas;

    private String log;



    public User()
    {

    }
    public User(String id, String password)
    {
        this.id=id;
        this.password=password;
    }

    public  boolean validate(String user, String pass)
    {
        return true;
    }

    public String get_id() {
        return id;
    }

    public void save()
    {

    }

    public void searchByID(String id)
    {

    }

    public void update()
    {

    }
    public void setLog(String log)
    {
        this.log=log;
    }

    public String getLog()
    {
        return log;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getNumPartidas() {
        return numPartidas;
    }

    public void setNumPartidas(int numPartidas) {
        this.numPartidas = numPartidas;
    }

    public int getNumPartidasGanadas() {
        return numPartidasGanadas;
    }

    public void setNumPartidasGanadas(int numPartidasGanadas) {
        this.numPartidasGanadas = numPartidasGanadas;
    }
}