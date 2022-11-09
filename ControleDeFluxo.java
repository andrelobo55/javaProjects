import java.util.Scanner;

public class ControleDeFluxo {
    /**
     * idade < 15, categoria infantil;
     * idade >= 15 e idade < 18, categoria juvenil;
     * idade >= 18, categoria adulta;
     */
    public static void main(String args[]){
        int idade = 0;
        Scanner entrada;
        entrada = new Scanner(System.in);

        System.out.printf("Informe sua idade:\n");
        idade = entrada.nextInt();
        if(idade < 15){
            System.out.println("Categoria infantil.");
        }
        else if(idade >= 15 && idade < 18){
            System.out.println("Categoria juvenil.");
        }
        else{
            System.out.println("Categoria adulta.");
        }

        entrada.close();
        System.out.printf("\n");
    }
}
