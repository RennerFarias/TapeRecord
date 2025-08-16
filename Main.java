import Classes.VerificacaoDeEntrada;
import Classes.Menus;

import java.util.Scanner;

public class Main {
    private static final String MENSAGEMOPCAO = "Digite sua opcao: ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Menus.NAME);
        // Usario e email
        // Verificacao de usuario

        int opcaoPrincipal = -1;
        while(opcaoPrincipal != 4)  {
            System.out.println(Menus.PRINCIPAL);
            opcaoPrincipal = VerificacaoDeEntrada.checarIntervalo(scanner, MENSAGEMOPCAO, 1, 4);
            int opcao = -1;

            switch (opcaoPrincipal) {
                case 1:
                    while (opcao != 5) {
                        System.out.println(Menus.PLAYLISTS);
                        opcao = VerificacaoDeEntrada.checarIntervalo(scanner, MENSAGEMOPCAO, 1, 5);

                        switch (opcao) {
                            case 1:
                                // Funcao de criar
                                break;
                            case 2:
                                // Funcao de Listar playlist
                                break;
                            case 3:
                                // Selecionar playlist
                                // Menu e funcoes de modificar a playlist
                                break;
                            case 4:
                                // Excluir playlist
                                break;
                            case 5:
                                System.out.println("Voltando ao menu anterior...");
                                System.out.println(Menus.NAME);
                                break;
                            default:
                                System.out.println("\033[5;49;91mOpcao invalida\033[m");

                        }


                    }

                case 2:
                    while (opcao != 5) {
                        System.out.println(Menus.PLAYLISTS);
                        opcao = VerificacaoDeEntrada.checarIntervalo(scanner, MENSAGEMOPCAO, 1, 5);

                        switch (opcao) {
                            case 1:
                                // Listar midias
                                break;
                            case 2:
                                // Listar musicas
                                break;
                            case 3:
                                // Listar podCasts
                                break;
                            case 4:
                                // Listar AudioBooks
                                break;
                            case 5:
                                System.out.println("Voltando ao menu anterior...");
                                System.out.println(Menus.NAME);
                                break;

                            default:
                                System.out.println("\033[5;49;91mOpcao invalida\033[m");
                        }


                    }

                case 3:
                    // Pesquisar midia
                    break;

                case 4:
                    System.out.println("...");
                    scanner.close();
                    break;

                default:
                    System.out.println("\033[5;49;91mOpcao invalida\033[m");

            }

        }
    }
}
