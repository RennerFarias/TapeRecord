package Classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VerificacaoDeEntrada {
    public static int checarIntervalo(Scanner scanner, String texto, int minimo, int maximo) {
        boolean controleDeLoop = true;
        int numero = 0;
        do {
            System.out.print(texto);
            try {
                numero = scanner.nextInt();
                if (numero >= minimo && numero <= maximo) {
                    controleDeLoop = false;
                } else {
                    System.out.printf("Opcao Invalida. Digite um numero entre %d e %d %n", minimo, maximo);
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }
        } while (controleDeLoop);

        scanner.nextLine();
        return numero;
    }

}
