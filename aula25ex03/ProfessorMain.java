package devDojoClasses.aula25ex03;

import devDojoClasses.Professor;

public class ProfessorMain {
    public static void main(String[] args) {
        Professor prof = new Professor();

        prof.nome = "Romanelli Lodron Zuim";
        prof.matricula = "001";
        prof.rg = "MG-20.424.42";
        prof.cpf = "921.213.634.45";

        System.out.println(">> Dados de Professores da PUC Minas <<");
        System.out.println();
        // Professor(a) 1
        System.out.println("Nome: "+prof.nome);
        System.out.println("Matrícula: "+prof.matricula);
        System.out.println("RG: "+prof.rg);
        System.out.println("CPF: "+prof.cpf);
        System.out.println();

        // Professor(a) 2
        Professor prof2 = new Professor();
        prof2.nome = "Cláudia Tavares";
        prof2.matricula = "002";
        prof2.rg = "MG-22.989.31";
        prof2.cpf = "041.542.127.69";
        System.out.println("Nome: "+prof2.nome);
        System.out.println("Matrícula: "+prof2.matricula);
        System.out.println("RG: "+prof2.rg);
        System.out.println("CPF: "+prof2.cpf);
        System.out.println();
    }
}
