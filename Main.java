import Classes.VerificacaoDeEntrada;
import Classes.SistemaUsuario;
import Classes.projeto.Midia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String MENSAGEMOPCAO = "Digite sua opcao: ";
    private static ArrayList<Midia> midias = new ArrayList<>();

    private static void tresPontos() throws InterruptedException {
        Thread.sleep(200);
        System.out.print(".");
        Thread.sleep(300);
        System.out.print(".");
        Thread.sleep(300);
        System.out.print(".");
        Thread.sleep(300);
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Header do sistema
        System.out.println("=========================");
        System.out.println("♫🗭♫  Tape Record  ♫🗭♫");
        System.out.println("=========================");

        // Login
        while (!SistemaUsuario.temUsuarioLogado()) {
            System.out.println("\n=== LOGIN/CADASTRO ===");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Sair");
            System.out.println("======================");

            int opcao = VerificacaoDeEntrada.checarIntervalo(scanner, MENSAGEMOPCAO, 1, 3);

            switch (opcao) {
                case 1:
                    SistemaUsuario.fazerLogin(scanner);
                    break;
                case 2:
                    SistemaUsuario.cadastrarUsuario(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }

        // Menu principal
        int opcaoPrincipal = -1;
        while (opcaoPrincipal != 5) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Playlists");
            System.out.println("2 - Midias");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Logout");
            System.out.println("5 - Sair");
            System.out.println("======================");

            opcaoPrincipal = VerificacaoDeEntrada.checarIntervalo(scanner, MENSAGEMOPCAO, 1, 5);
            int opcao = -1;

            switch (opcaoPrincipal) {
                case 1:
                    SistemaUsuario.menuPlaylists(scanner, midias);
                    break;

                case 2:
                    while (opcao != 5) {
                        System.out.println("\n=== MIDIAS ===");
                        System.out.println("1 - Listar midias do catalogo");
                        System.out.println("2 - Adicionar midia ao catalogo");
                        System.out.println("3 - Buscar Midia");
                        System.out.println("4 - Remover midia do catalogo");
                        System.out.println("5 - Voltar");
                        System.out.println("==============");

                        opcao = VerificacaoDeEntrada.checarIntervalo(scanner, MENSAGEMOPCAO, 1, 5);

                        switch (opcao) {
                            case 1:
                                Classes.projeto.Catalogo.listarMidia(scanner, midias);
                                break;
                            case 2:
                                Classes.projeto.Catalogo.adicionarMidia(scanner, midias);
                                break;
                            case 3:
                                Classes.projeto.Catalogo.buscarMidia(scanner, midias);
                                break;
                            case 4:
                                Classes.projeto.Catalogo.removerMidia(scanner, midias);
                                break;
                            case 5:
                                System.out.print("Voltando ao menu anterior");
                                tresPontos();
                                break;
                        }
                    }
                    opcao = -1;
                    break;

                case 3:
                    Classes.projeto.Catalogo.buscarMidia(scanner, midias);
                    break;

                case 4:
                    SistemaUsuario.logout();
                    main(args); // Reinicia o programa
                    return;

                case 5:
                    tresPontos();
                    scanner.close();
                    break;
            }
        }
    }
}