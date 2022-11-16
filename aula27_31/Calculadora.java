package devDojoClasses.aula27_31_classes;

public class Calculadora { // Cria uma classe Calculadora

    public double soma(double num1, double num2){ // Método que realiza soma;  
        return num1 + num2;
    }

    public float subtrai(float num1, float num2){ // Método de subtração;
        return num1 - num2;
    }

    public double multiplicacao(double num1, double num2){ // recebe dois valores/argumentos digitados pelo usuário
        return num1 * num2; // retorna o resultado para a função;
    }

    public void divisao(double num1, double num2){
        if(num1 != 0 && num2 == 0){
            System.out.println("Não é possível divisão por 0.");
        }
        else{
            System.out.println(num1 / num2);
        }
    }

    public void alteraDoisNumeros(int a, int b){
        a = 40;
        b = 20;

        System.out.println("Dentro do altera números:");
        System.out.println("num1 = "+a+" num2 = "+b);
        System.out.println();
    }
}
