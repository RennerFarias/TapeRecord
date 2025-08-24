package Classes;

import Classes.projeto.Midia;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaUsuario {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioAtual = null;

    public static void cadastrarUsuario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Verifica se o email já existe
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Este email ja esta cadastrado!");
                return;
            }
        }

        usuarios.add(new Usuario(nome, email));
        System.out.println("Usuario cadastrado!");
    }

    public static boolean fazerLogin(Scanner scanner) {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado!");
            return false;
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                usuarioAtual = u;
                System.out.println("Login realizado! Bem-vindo " + u.getNome());
                return true;
            }
        }
        System.out.println("Usuario nao encontrado!");
        return false;
    }

    public static void menuPlaylists(Scanner scanner, ArrayList<Midia> midias) {
        if (usuarioAtual == null) return;

        int opcao = -1;
        while (opcao != 5) {
            System.out.println("\n1-Criar 2-Listar 3-Gerenciar 4-Excluir 5-Voltar");
            opcao = VerificacaoDeEntrada.checarIntervalo(scanner, "Opcao: ", 1, 5);

            switch (opcao) {
                case 1:
                    System.out.print("Nome da playlist: ");
                    usuarioAtual.criarPlaylist(scanner.nextLine());
                    break;
                case 2:
                    usuarioAtual.listarPlaylists();
                    break;
                case 3:
                    gerenciarPlaylist(scanner, midias);
                    break;
                case 4:
                    usuarioAtual.listarPlaylists();
                    if (!usuarioAtual.getPlaylists().isEmpty()) {
                        int i = VerificacaoDeEntrada.checarIntervalo(scanner, "Escolha: ", 1, usuarioAtual.getPlaylists().size()) - 1;
                        usuarioAtual.removerPlaylist(i);
                    }
                    break;
            }
        }
    }

    private static void gerenciarPlaylist(Scanner scanner, ArrayList<Midia> midias) {
        usuarioAtual.listarPlaylists();
        if (usuarioAtual.getPlaylists().isEmpty()) return;

        int i = VerificacaoDeEntrada.checarIntervalo(scanner, "Escolha: ", 1, usuarioAtual.getPlaylists().size()) - 1;
        Playlist p = usuarioAtual.getPlaylist(i);

        int opcao = -1;
        while (opcao != 4) {
            System.out.println("\n1-Ver 2-Adicionar 3-Remover 4-Voltar");
            opcao = VerificacaoDeEntrada.checarIntervalo(scanner, "Opcao: ", 1, 4);

            switch (opcao) {
                case 1: p.exibirPlaylist(); break;
                case 2:
                    if (!midias.isEmpty()) {
                        Classes.projeto.Catalogo.listarMidia(scanner, midias);
                        System.out.print("Titulo: ");
                        String titulo = scanner.nextLine();
                        for (Midia m : midias) {
                            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                                p.adicionarMidia(m);
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.print("Titulo: ");
                    try { p.removerMidia(scanner.nextLine()); }
                    catch (Exception e) { System.out.println(e.getMessage()); }
                    break;
            }
        }
    }

    public static boolean temUsuarioLogado() { return usuarioAtual != null; }
    public static void logout() { usuarioAtual = null; System.out.println("Logout!"); }
}