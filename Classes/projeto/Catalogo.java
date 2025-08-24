package Classes.projeto;

import java.util.Scanner;
import java.util.ArrayList;

public class Catalogo {

    public static void adicionarMidia(Scanner scanner, ArrayList<Midia> midias) {
        System.out.println("Selecione o tipo de mídia:");
        System.out.println("1. Música");
        System.out.println("2. Podcast");
        System.out.println("3. Audiobook");

        int tipo = 0;
        while (true) {
            System.out.print("Digite uma opção: ");
            String entrada = scanner.nextLine();
            try {
                tipo = Integer.parseInt(entrada);
                if (tipo >= 1 && tipo <= 3)
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números.");
            }
        }

        switch (tipo) {
            case 1:
                System.out.println("Você está adicionando uma nova música.");
                break;
            case 2:
                System.out.println("Você está adicionando um novo podcast.");
                break;
            case 3:
                System.out.println("Você está adicionando um novo audiobook.");
                break;
        }

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autoria: ");
        String artista = scanner.nextLine();

        double duracao = 0;
        while (true) {
            System.out.print("Duração (em segundos): ");
            try {
                String entradaDuracao = scanner.nextLine();
                duracao = Double.parseDouble(entradaDuracao);
                break; // AGORA o break está no lugar certo!
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido para a duração.");
            }
        }

        Genero genero = null;

        if (tipo == 1) {
            System.out.println("Escolha o gênero da música:");
            for (Genero g : Genero.values()) {
                System.out.println("- " + g.name());
            }

            while (true) {
                System.out.print("Gênero: ");
                String generoInput = scanner.nextLine().toUpperCase();
                try {
                    genero = Genero.valueOf(generoInput);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Gênero inválido. Tente novamente.");
                }
            }
        }

        for (Midia m : midias) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Título já adicionado anteriormente.");
                return;
            }
        }

        Midia novaMidia;
        switch (tipo) {
            case 1:
                novaMidia = new Musica(titulo, artista, duracao, genero);
                break;
            case 2:
                novaMidia = new Podcast(titulo, artista, duracao, null);
                break;
            case 3:
                novaMidia = new Audiobook(titulo, artista, duracao, null);
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }

        midias.add(novaMidia);
        System.out.println("Mídia adicionada com sucesso!");
    }

    public static void listarMidia(Scanner scanner, ArrayList<Midia> midias) {
        if (midias.isEmpty()) {
            System.out.println("Não há nenhuma mídia cadastrada.");
        } else {
            System.out.println("Lista de mídias:");
            for (Midia m : midias) {
                System.out.println("- [" + m.getTipo() + "] " + m.getTitulo() + " (" + m.getDuracao() + " seg)");
            }
        }
    }

    public static void removerMidia(Scanner scanner, ArrayList<Midia> midias) {
        System.out.print("Digite o título da mídia que deseja remover: ");
        String titulo = scanner.nextLine();

        boolean removida = midias.removeIf(m -> m.getTitulo().equalsIgnoreCase(titulo));
        if (removida) {
            System.out.println("Mídia removida com sucesso!");
        } else {
            System.out.println("Mídia Não Encontrada.");
        }
    }

    public static void buscarMidia(Scanner scanner, ArrayList<Midia> midias) {
        if (midias.isEmpty()) {
            System.out.println("Catalogo de midias esta vazio");
            return;
        }
        System.out.print("Digite O Nome Da Mídia Que Deseja Buscar: ");
        String titulo = scanner.nextLine();

        for (Midia m : midias) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Mídia Encontrada: " + m.getTitulo() + " (" + m.getDuracao() + " seg)");
                return;
            }
        }
        System.out.println("Mídia Não Encontrada.");
    }
}