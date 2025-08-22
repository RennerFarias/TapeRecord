package Classes.projeto;

import java.util.Scanner;
import java.util.ArrayList;

public class Catalogo {
	private static ArrayList<Midia> midias = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0;

		do {
			System.out.println("Catálogo de Mídias");
			System.out.println("1. Adicionar Mídia");
			System.out.println("2. Listar Mídia");
			System.out.println("3. Remover Mídia");
			System.out.println("4. Buscar Mídia");
			System.out.println("5. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				adicionarMidia();
				break;
			case 2:
				listarMidia();
				break;
			case 3:
				removerMidia();
				break;
			case 4:
				buscarMidia();
				break;
			case 5:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 5);

		scanner.close();
	}

	public static void adicionarMidia() {
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

		System.out.print("Artista: ");
		String artista = scanner.nextLine();

		double duracao = 0;
		while (true) {
			System.out.print("Duração (em segundos): ");
			String entradaDuracao = scanner.nextLine();
			try {
				duracao = Double.parseDouble(entradaDuracao);
				break;
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

	public static void listarMidia() {
		if (midias.isEmpty()) {
			System.out.println("Não há nenhuma mídia cadastrada.");
		} else {
			System.out.println("Lista de mídias:");
			for (Midia m : midias) {
				System.out.println("- [" + m.getTipo() + "] " + m.getTitulo());
			}
		}
	}

	public static void removerMidia() {
		System.out.print("Digite o título da mídia que deseja remover: ");
		String titulo = scanner.nextLine();

		boolean removida = midias.removeIf(m -> m.getTitulo().equalsIgnoreCase(titulo));
		if (removida) {
			System.out.println("Mídia removida com sucesso!");
		} else {
			System.out.println("Mídia Não Encontrada.");
		}
	}

	public static void buscarMidia() {
		System.out.print("Digite O Nome Da Mídia Que Deseja Buscar: ");
		String titulo = scanner.nextLine();

		for (Midia m : midias) {
			if (m.getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println("Mídia Encontrada: " + m.getTitulo());
				return;
			}
		}
		System.out.println("Mídia Não Encontrada.");
	}
}