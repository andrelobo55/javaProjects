package devDojoClasses.teste;

import devDojoClasses.aula27_31_classes.Calculadora;

public class CalculadoraTeste {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora(); // cria objeto de tipo Calculadora
        //double resultado = 0;

        //resultado = calc.soma(5, 3); // utiliza o método de soma da Calculadora;
        //resultado = calc.subtrai(10, 5); // subtrai 10 - 5;
        //resultado = calc.multiplicacao(2, 3); // passa 2 argumentos para o método de multiplicação;
        //System.out.println(resultado);
        calc.divisao(10, 0);
    }
}
