package Classes.projeto;

public abstract class Midia {
	public abstract String getTipo();

	
	public static void main(String[] args) {

	}

	private String Titulo;
	private String Artista;
	private double Duracao;
	private Genero genero;
	
	
	public Midia(String Titulo, String Artista, double Duracao, Genero genero) {
		this.Titulo = Titulo;
		this.Artista = Artista;
		this.Duracao = Duracao;
		this.genero = genero;
	}

	public String getTitulo() {
		return Titulo;
	}

	public String getArtista() {
		return Artista;
	}

	public double getDuracao() {
		return this.Duracao;
	}

	public Genero getGenero() {
		return genero;
	}
	
	
	public String toString() {
		return "Midia:" + "\n- Titulo='" + Titulo + "\n- Artista='" + Artista + "\n- Duracao='" + Duracao + "\n- Genero=" + genero;

	}

}