package devDojoClasses.aula38Sobrecarga.classe;

public class Funcionario {
    public String nome;
    public String cpf;
    public double salario;
    public String rg;

    // Método que cria ou inicializa o objeto funcionário.
    public void iniciar(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    /*
     * SOBRECARGA de método é um método com mesmo nome de outro, normalmente um
     * inicializador, que possui mesmo
     * nome, porém a quantidade de paramêtros ou os tipos destes são diferentes.
     * Neste exemplo, suponhamos que o chefe peça para acrescentar o atributo String rg. Para que não quebremos
     * o código dos outros funcionários que estão utilizando-o ao mesmo tempo criamos uma sobrecarga de método.
     * Nela podemos chamar o método antigo que inicializou os parâmetros do funcionário dentro da sobrecarga e
     * o que acrescentarmos de novo, no caso a String rg, será pelo this.rg = rg.
     */
    public void iniciar(String nome, String cpf, double salario, String rg) {
        iniciar(nome, cpf, salario);
        this.rg = rg;
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