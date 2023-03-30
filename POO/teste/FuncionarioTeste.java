package devDojoClasses.aula38Sobrecarga.teste;

import devDojoClasses.aula38Sobrecarga.classe.Funcionario;

public class FuncionarioTeste {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();

        //funcionario1.iniciar("Joseph Joestar", "032.657.190.43", 1400.5);
        funcionario1.iniciar("Joseph Joestar", "032.657.190.43", 1400.5, "43.234.234");
        funcionario1.imprimir();
        System.out.println();
    }
}
 