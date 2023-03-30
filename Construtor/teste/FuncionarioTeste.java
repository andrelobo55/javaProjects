package devDojoClasses.aula39Construtores.teste;

import devDojoClasses.aula39Construtores.classe.Funcionario;

public class FuncionarioTeste {
    public static void main(String[] args) {
        // Usando o construtor em que é obrigatório passar argumentos.
        Funcionario funcionario1 = new Funcionario("Joseph Joestar", "032.657.190.43", 1400.5, "43.234.234" );
        funcionario1.imprimir();
        System.out.println();
        // Usando construtor vazio, em que não é obrigatório passar argumentos.
        Funcionario funcionario2 = new Funcionario();
        funcionario2.imprimir();
        System.out.println();
    }
}
