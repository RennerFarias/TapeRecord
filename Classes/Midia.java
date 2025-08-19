public abstract class Midia {

    private String Titulo;  
    private String Artista;
    private String Duração;

public Midia(String Titulo, String Artista, String Duração) {
    this.Titulo = Titulo;
    this.Artista = Artista;
    this.Duração = Duração;
}

public String getTitulo() {
        return Titulo;
    }

public String getArtista() {
        return Artista;
    }

public String getDuração() {
        return Duração;
    }

    public String toString() {
        return "Midia:" +
                "\n- Titulo='" + Titulo +
                "\n- Artista='" + Artista +
                "\n- Duração='" + Duração;
    }
}