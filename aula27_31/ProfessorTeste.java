package devDojoClasses.teste;

import devDojoClasses.aula27_31_classes.Professor;

public class ProfessorTeste {
    public static void main(String[] args) {
        Professor prof = new Professor();
        Professor prof2 = new Professor();

        prof.nome = "Sandro Jerônimo";
        prof.matricula = "005";
        prof.rg = "MG-23.324.234";
        prof.cpf = "123.324.576.97";

        prof2.nome = "Deborah Paixão";
        prof2.matricula = "006";
        prof2.rg = "MG-22.980.765";
        prof2.cpf = "031.785.332.12";

        /* OBS.: Exceto os tipos primitivos(byte, int, float, double, boolean, string), 
         * a passagem abaixo é uma passagem por referência.
         * Ou seja, o endereço do objeto está sendo passado para uma variável referência refProf
         * da classe Professor e método impime.
         */
        prof.imprime(prof); // passando objeto prof para imprime
        prof.imprime(prof2); // passando objeto prof2 para imprime
        System.out.println();
    }
}
