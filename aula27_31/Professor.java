package devDojoClasses.aula27_31_classes;

public class Professor {
    public String nome;
    public String matricula;
    public String rg;
    public String cpf;

    public void imprime(Professor refProf){ // espera um objeto de Professor
        System.out.println("Nome: "+refProf.nome+" | Matrícula: "+refProf.matricula+" | RG: "+refProf.rg+" | CPF: "+refProf.cpf);
    }
}
