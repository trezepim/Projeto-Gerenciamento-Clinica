package app;

import classes.Paciente;
import classes.VetPaciente;

import java.util.Scanner;

public class AppClinica {
    public static void main(String[] args) {

        menu();

        System.out.println("Encerrando sistema...");
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        VetPaciente vp = new VetPaciente();

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
                    System.out.println(cadastrar(sc, vp));
                    break;
                case 2:
                    System.out.println(consultar(sc, vp));
                    break;
                case 3:
                    imprimir(vp);
                    break;
                case 4:
                    sc.close();
                    break;
                default:
                    System.out.println("- ERRO: Informe uma opção válida.");
                    break;
            }
        } while (opcao != 4);
    }

    public static String cadastrar(Scanner sc, VetPaciente vp) {
        System.out.println("\n   Cadastrar paciente");

        System.out.println("Informe o nome do paciente: ");
        sc.nextLine();
        String nome = sc.nextLine();

        System.out.println("Informe o CPF do paciente (ex: 12345678901): ");
        String cpf = sc.nextLine();

        System.out.println("Informe a data de nascimento do paciente (ex: 22/11/2005)");
        String dtNasc = sc.nextLine();

        int result = VetPaciente.insere(new Paciente(nome, cpf, dtNasc), vp);

        if (result == 0) {
            return "- SUCESSO: Paciente cadastrado.";
        }

        if (result == -2) {
            return "- ERRO: Paciente já cadastrado.";
        }

        return "- ERRO: O vetor está cheio.";
    }

    public static String consultar(Scanner sc, VetPaciente vp) {
        System.out.println("\n   Consultar paciente");

        System.out.println("Informe o cpf do paciente: ");
        sc.nextLine();
        String cpf = sc.nextLine();

        int result = VetPaciente.pesquisa(cpf, vp);

        if (result == -1) {
            return "- ERRO: Paciente não cadastrado.";
        }

        return "Nome: " + vp.getPaciente(result).getNome() + " | CPF: " + vp.getPaciente(result).getCpf();
    }

    public static void imprimir(VetPaciente vp) {
        if (vp.getQuant() == 0) {
            System.out.println("- ERRO: Nenhum paciente cadastrado.");
        }

        for (int i = 0; i < vp.getQuant(); i++) {
            System.out.println("Nome: " + vp.getPaciente(i).getNome() + " | CPF: " + vp.getPaciente(i).getCpf());
        }
    }
}