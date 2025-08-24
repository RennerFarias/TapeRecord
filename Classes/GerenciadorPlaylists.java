package Classes.projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorPlaylists {

    // Adicionar uma playlist
    public static void adicionarPlaylist(Scanner scanner, ArrayList<Playlist> playlists) {
        System.out.print("Digite o nome da nova playlist: ");
        String nome = scanner.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("Erro: O nome da playlist não pode ser vazio!");
            return;
        }

        for (Playlist p : playlists) {
            if (p.nome.equalsIgnoreCase(nome)) {
                System.out.println("Erro: Já existe uma playlist com esse nome!");
                return;
            }
        }

        Playlist nova = new Playlist(nome);
        playlists.add(nova);

        System.out.println("Playlist \"" + nome + "\" adicionada com sucesso!");
    }

    // Listar todas as playlists
    public static void listarPlaylists(Scanner scanner, ArrayList<Playlist> playlists) {
        if (playlists.isEmpty()) {
            System.out.println("Não há nenhuma playlist cadastrada.");
        } else {
            System.out.println("Lista de playlists:");
            for (Playlist p : playlists) {
                System.out.println("- " + p.nome + " | Duração total: " + p.calcularDuracaoTotal() + " min");
            }
        }
    }

    // Buscar uma playlist pelo nome
    public static void buscarPlaylist(Scanner scanner, ArrayList<Playlist> playlists) {
        if (playlists.isEmpty()) {
            System.out.println("Não há nenhuma playlist cadastrada.");
            return;
        }

        System.out.print("Digite o nome da playlist que deseja buscar: ");
        String nome = scanner.nextLine();

        for (Playlist p : playlists) {
            if (p.nome.equalsIgnoreCase(nome)) {
                System.out.println("Playlist encontrada!");
                p.exibirPlaylist();
                return;
            }
        }

        System.out.println("Playlist não encontrada.");
    }

    // Remover uma playlist
    public static void removerPlaylist(Scanner scanner, ArrayList<Playlist> playlists) {
        if (playlists.isEmpty()) {
            System.out.println("Não há nenhuma playlist cadastrada.");
            return;
        }

        System.out.print("Digite o nome da playlist que deseja remover: ");
        String nome = scanner.nextLine();

        boolean removida = playlists.removeIf(p -> p.nome.equalsIgnoreCase(nome));

        if (removida) {
            System.out.println("Playlist \"" + nome + "\" removida com sucesso!");
        } else {
            System.out.println("Erro: Playlist não encontrada.");
        }
    }
}
