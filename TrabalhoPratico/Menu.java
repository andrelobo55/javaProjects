package tp03.classe;

import java.util.Scanner;

public class Menu {

    public int exibirMenu() {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;

        System.out.println("====== Conta Bancaria =====");
        System.out.println("[0] SAIR.");
        System.out.println("[1] CRIAR CONTA.");
        System.out.println("[2] REALIZAR TRANSFERÊNCIA.");
        System.out.println("[3] IMPRIMIR CONTAS.");
        System.out.println("[4] LER REGISTRO");
        System.out.println("[5] ATUALIZAR REGISTRO.");
        System.out.println("[6] DELETAR UM REGISTRO.");
        System.out.println("[7] COMPACTAR");
        System.out.println("[8] DESCOMPACTAR");
        System.out.println("Selecione uma opção: ");
        opcao = entrada.nextInt();

        return opcao;
    }
}
