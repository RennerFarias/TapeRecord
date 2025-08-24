package Classes.projeto;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	public final String nome;
	public final List<Midia> midias;

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
			throw new Exception("Mídia não encontrada!");
		}
	}

	public double calcularDuracaoTotal() {
		return midias.stream().mapToDouble(Midia::getDuracao).sum();
	}

	public void exibirPlaylist() {
		System.out.println("Playlist: " + nome);
		if (midias.isEmpty()) {
			System.out.println("(Nenhuma mídia adicionada ainda)");
		} else {
			midias.forEach(System.out::println);
		}
		System.out.println("Duração total: " + calcularDuracaoTotal() + " min\n");
	}
}
