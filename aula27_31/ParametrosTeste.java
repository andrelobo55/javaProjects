package devDojoClasses.teste;

import devDojoClasses.aula27_31_classes.Calculadora;

public class ParametrosTeste {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int num1 = 5, num2 = 10;

        calc.alteraDoisNumeros(num1, num2); // passando a cópia de num1 e num1 para o método;
        System.out.println("Dentro do teste:");
        System.out.println("num1 = "+num1+" num2 = "+num2);
        System.out.println();
    }
}
