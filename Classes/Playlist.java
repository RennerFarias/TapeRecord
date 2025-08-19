import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final String nome;
    private final List<Midia> midias;

    public Playlist(String nome) {
        this.nome = nome;
        this.midias = new ArrayList<>();
    }

    public void adicionarMidia(Midia midia) {
        midias.add(midia);
    }

    public void removerMidia(String titulo) throws Exception {
        boolean removido = midias.removeIf(m -> m.getTitulo().equalsIgnoreCase(titulo));
        if (!removido) {
            throw new Exception("Mídia não encontrada! ");
        }
    }

    public double calcularDuracaoTotal() {
        return midias.stream().mapToDouble(Midia::getDuracao).sum();
    }

    public void exibirPlaylist() {
        System.out.println("Playlist: " + nome);
        midias.forEach(System.out::println);
        System.out.println("Duracao total: " + calcularDuracaoTotal() + " min\n");
    }
}