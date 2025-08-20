public abstract class Midia {

	public static void main(String[] args) {

	}

	private String Titulo;
	private String Artista;
	private int Duracao;
	private Genero genero;
	
	
	public Midia(String Titulo, String Artista, int Duracao, Genero genero) {
		this.Titulo = Titulo;
		this.Artista = Artista;
		this.Duração = Duracao;
		this.genero = genero;
	}

	public String getTitulo() {
		return Titulo;
	}

	public String getArtista() {
		return Artista;
	}

	public int getDuração() {
		return Duracao;
	}

	public Genero getGenero() {
		return genero;
	}
	
	
	public String toString() {
		return "Midia:" + "\n- Titulo='" + Titulo + "\n- Artista='" + Artista + "\n- Duração='" + Duracao + "\n- Genero=" + genero;

	}
}
