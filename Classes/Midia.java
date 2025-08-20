public abstract class Midia {

	public static void main(String[] args) {

	}

	private String Titulo;
	private String Artista;
	private int Duração;
	private Genero genero;
	
	
	public Midia(String Titulo, String Artista, int Duração, Genero genero) {
		this.Titulo = Titulo;
		this.Artista = Artista;
		this.Duração = Duração;
		this.genero = genero;
	}

	public String getTitulo() {
		return Titulo;
	}

	public String getArtista() {
		return Artista;
	}

	public int getDuração() {
		return Duração;
	}

	public Genero getGenero() {
		return genero;
	}
	
	
	public String toString() {
		return "Midia:" + "\n- Titulo='" + Titulo + "\n- Artista='" + Artista + "\n- Duração='" + Duração + "\n- Genero=" + genero;

	}
}
