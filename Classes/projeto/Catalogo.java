package projeto;

import java.util.Scanner;
import java.util.ArrayList;

public class Catalogo {
    public static void main(String[] args) {

        ArrayList<String> midia = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 5) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar Mídia");
            System.out.println("2. Listar Mídias");
            System.out.println("3. Remover Mídia");
            System.out.println("4. Buscar Mídia");
            System.out.println("5. Sair");
            System.out.print("-Digite uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
            case 1:
                // adicionar
                System.out.println("-Selecione Qual Será O Seu Tipo De Mídia");
                System.out.println("1. Música");
                System.out.println("2. Podcast");
                System.out.println("3. Audiobook");

                System.out.print("-Digite Uma Opção: ");
                int tipo = scanner.nextInt();
                scanner.nextLine();

                System.out.print("-Título: ");
                String titulo = scanner.nextLine();

                System.out.print("-Artista: ");
                String artista = scanner.nextLine();

                System.out.print("-Duração (em segundos): ");
                double duracao = scanner.nextDouble();
                scanner.nextLine();

                
                Genero genero = null;
                while (genero == null) {
                    System.out.print("-Gênero: ");
                    String generoInput = scanner.nextLine().toUpperCase();

                    try {
                        genero = Genero.valueOf(generoInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("-Erro: O gênero '" + generoInput + "' não existe no programa!");
                        System.out.println("Gêneros disponíveis: ");
                        for (Genero g : Genero.values()) {
                            System.out.println("- " + g);
                        }
                        System.out.println("Tente novamente.\n");
                    }
                }

                if (midia.contains(titulo)) {
                    System.out.println("-Título já tinha sido adicionado anteriormente.");
                } else {
                    midia.add(titulo);
                    System.out.println("-Mídia adicionada com sucesso!");
                }
                break;

            case 2:
                // listar
                if (midia.isEmpty()) {
                    System.out.println("-Não há nenhuma mídia cadastrada.");
                } else {
                    System.out.println("-Lista de mídias:");
                    for (String elemento : midia) {
                        System.out.println("- " + elemento);
                    }
                }
                break;

            case 3:
                // remover
                if (midia.isEmpty()) {
                    System.out.println("-Não há nenhuma mídia cadastrada.");
                    break;
                }

                System.out.print("-Digite a mídia que você deseja remover: ");
                String titulo1 = scanner.nextLine();

                if (midia.remove(titulo1)) {
                    System.out.println("-Mídia removida com sucesso!");
                } else {
                    System.out.println("-A mídia '" + titulo1 + "' não foi encontrada.");
                }
                break;

            case 4:
                // buscar
                if (midia.isEmpty()) {
                    System.out.println("-Não há nenhuma mídia cadastrada.");
                    break;
                }

                System.out.print("-Digite o nome da mídia que você deseja pesquisar: ");
                String titulomidia = scanner.nextLine();

                boolean encontrada = false;
                for (String elemento : midia) {
                    if (elemento.equalsIgnoreCase(titulomidia)) {
                        System.out.println("-Mídia encontrada: " + elemento);
                        encontrada = true;
                        break;
                    }
                }

                if (!encontrada) {
                    System.out.println("-Mídia não encontrada.");
                }
                break;

            case 5:
                System.out.println("-Saindo...");
                scanner.close();
                break;

            default:
                System.out.println("-Opção inválida!");
                break;
            }
        }
    }
}
