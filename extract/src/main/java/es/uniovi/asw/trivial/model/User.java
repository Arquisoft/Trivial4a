package es.uniovi.asw.trivial.model;

public class User {

    private String _id;
    private String contrasena;


    public User(String _id) {

        this._id = _id;
    }

    public User(String _id, String contrasena) {
        this._id = _id;
        this.contrasena = contrasena;
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
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


}
