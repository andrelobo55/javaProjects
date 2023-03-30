package devDojoClasses.aula39Construtores.classe;

public class Funcionario {
    public String nome;
    public String cpf;
    public double salario;
    public String rg;

    /*
     * Contrutor é um método que é executado quando se cria um objeto. Pode ser obrigatoriamente inicializado,
     * ou não. Neste caso, o usuário é obrigado a passar argumentos.
     */
    public Funcionario (String nome, String cpf, double salario, String rg){
        System.out.println("Dentro do construtor inicializador.");
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.rg = rg;
    }

    /*
     * Abaixo temos uma sobrecarga de Construtor, porém este é vazio. Ou seja não é necessário passar parâmetros.
     */
    public Funcionario () {
        System.out.println("Dentro do construtor vazio.");
    }

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Salário: " + this.salario);
        System.out.println("RG: " + this.rg);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void salario(double salario) {
        this.salario = salario;
    }

    public void rg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getSalario() {
        return this.salario;
    }

    public String getRG() {
        return this.rg;
    }
}