package model;

public class Contestacion {

    private User user;
    private Pregunta pregunta;
    private boolean isCorrecta;

    public Contestacion(User user, Pregunta pregunta, boolean isCorrecta) {

        this.user = user;
        this.pregunta = pregunta;
        this.isCorrecta = isCorrecta;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOnlyUser() {
        return user.get_id();
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getOnlyPregunta() {
        return pregunta.getPregunta();
    }

    public boolean isCorrecta() {
        return isCorrecta;
    }

    public void setCorrecta(boolean isCorrecta) {
        this.isCorrecta = isCorrecta;
    }

    @Override
    public String toString() {
        return "Contestacion [user=" + user.get_id() + ", pregunta=" + pregunta.getPregunta()
                + ", isCorrecta=" + isCorrecta + "]";
    }


}
