import java.util.Scanner; // Importa biblioteca para gravar variáveis;

/***
 * @author André Lobo
 * @data 20/09/2022
 * Crie um algoritmo que possua as variáveis nome, salário, sexo(M ou F), idade, estado civil.
 * Imprima da seguinte forma:
 * O trabalhador(a) <nome> do sexo <sexo>, idade <idade>, estado civil <estado civil> e salário <salário> encontra-se
 * empregado neste estabelecimento.
 */

public class ExercicioDois{
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        String nome, estadoCivil;
        String sexo;
        int idade;
        float salario;

        System.out.printf("Digite seu nome:\n");
        nome = entrada.nextLine();
        System.out.printf("Digite seu sexo:\n");
        sexo = entrada.nextLine();
        System.out.printf("Digite seu estado civil:\n");
        estadoCivil = entrada.nextLine();
        System.out.printf("Digite sua idade:\n");
        idade = entrada.nextInt();
        System.out.printf("Digite seu salario:\n");
        salario = entrada.nextFloat();

        System.out.printf("O trabalhador(a) "+nome+" do sexo "+sexo+ ", idade " +idade+", estado civil " +estadoCivil+ " e salário "+salario+
        " encontra-se empregado neste estabelecimento.\n");
         entrada.close();
    }
}

