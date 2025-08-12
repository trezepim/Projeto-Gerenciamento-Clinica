package app;

import java.util.Scanner;

public class AppClinica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        menu(sc);

        System.out.println("Encerrando sistema...");

        sc.close();
    }

    public static void menu(Scanner sc) {
        int opcao;

        do {
            System.out.println("\n======== MENU ========");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Consultar paciente");
            System.out.println("3 - Imprimir cadastro");
            System.out.println("4 - Sair");
            System.out.print("> ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (opcao != 4);
    }
}
