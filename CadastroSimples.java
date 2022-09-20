import java.util.Scanner; // Importando biblioteca para gravar variáveis;

/***
 * @author André Lobo
 * @data 20/09/2022
 * Crie um algoritmo que possua variáveis para salvar os seguintes dados: Nome, Endereço e Telefone de uma pessoa.
 * Imprima essas variáveis da seguinte forma: O <nome> domiciliado no endereço <endereço> e telefone <telefone> 
 * não possui nenhum tipo de pendência.
 */
public class CadastroSimples{
    public static void main(String args[]){ // Programa main. O JVM(Java Virtual Machine começará a ler o código daqui)
        /* Entrada */
        Scanner entrada = new Scanner(System.in); // Cria um objeto 'entrada' de tipo Scanner;
        String nome = null;
        String endereco = null;
        String telefone = null;

        /* Processamento */
        System.out.printf("Digite seu nome:\n"); // Usuário preenche o nome;
        nome = entrada.nextLine(); // nome recebe uma função do objeto entrada de tipo scanner;
        System.out.printf("Digite seu endereco:\n");
        endereco = entrada.nextLine();
        System.out.printf("Digite seu numero de telefone:\n");
        telefone = entrada.nextLine();

        /* Saída */
        System.out.printf("O "+nome +" domiciliado no endereco "+endereco+" e telefone "+telefone+" nao possui nenhum tipo de pendencia.\n");
        entrada.close();
    }
}
