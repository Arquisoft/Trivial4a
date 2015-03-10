public class Casilla {
	private int id;
	private int categoria;
	private boolean ultima;
	private boolean quesito;

	
	public Casilla(int categoria) {
			this.categoria=categoria;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public boolean isUltima() {
		return ultima;
	}

	public void setUltima(boolean ultima) {
		this.ultima = ultima;
	}

	public boolean isQuesito() {
		return quesito;
	}

	public void setQuesito(boolean quesito) {
		this.quesito = quesito;
	}

	

}
