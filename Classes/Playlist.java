package Classes;

import Classes.projeto.Midia;
import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Midia> midias;

    public Playlist(String nome) {
        this.nome = nome;
        this.midias = new ArrayList<>();
    }

    public String getNome() { return nome; }

    public void adicionarMidia(Midia midia) {
        midias.add(midia);
        System.out.println("Midia adicionada!");
    }

    public void removerMidia(String titulo) throws Exception {
        boolean removido = midias.removeIf(m -> m.getTitulo().equalsIgnoreCase(titulo));
        if (!removido) {
            throw new Exception("Midia nao encontrada!");
        }
    }

    public double calcularDuracaoTotal() {
        double total = 0;
        for (Midia midia : midias) {
            total += midia.getDuracao();
        }
        return total;
    }

    public void exibirPlaylist() {
        System.out.println("Playlist: " + nome);
        if (midias.isEmpty()) {
            System.out.println("Playlist vazia");
            return;
        }
        for (int i = 0; i < midias.size(); i++) {
            System.out.println((i+1) + " - " + midias.get(i).getTitulo());
        }
        System.out.println("Duracao total: " + calcularDuracaoTotal() + " seg");
    }
}