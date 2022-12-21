package tp03.classe;

import java.util.*;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ContaBancaria {
    private int idConta;
    private String nomePessoa;
    private String email;
    private String nomeUsuario;
    private String senha;
    private String cpf;
    private String cidade;
    private int transferenciaRealizada;
    private double saldoConta;
    byte[] ba; // cria um vetor de objeto byte array;
    private String concatenar;
    List<Integer> comprimido;
    String descomprimido;
    String senhaCripto;
    String senhaDescripto; 


    // Construtor inicializador
    public ContaBancaria(int idConta, String nomePessoa, String cpf, String cidade, String email, String nomeUsuario,
            String senha, int transferenciaR, double saldoConta) { // Construindo uma conta
        this.idConta = idConta; // o idConta da classe recebe o idConta do objeto
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.cidade = cidade;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.transferenciaRealizada = transferenciaR;
        this.saldoConta = saldoConta;
    }

    // Sobrecarga de método para alterar alguns atributos;
    public ContaBancaria(int idConta, String nomePessoa, String cpf, String cidade, String email, String nomeUsuario,
            String senha, double saldoConta) {
        this.idConta = idConta;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.cidade = cidade;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.saldoConta = saldoConta;
    }

    // Construtor vazio para excluir uma conta;
    public ContaBancaria() {

    }

    // TRANSFORMA A CLASSE CONTA E SEUS DADOS EM UM VETOR DE BYTES (REGISTRO);
    public byte[] toByteArray(int idConta, String nomePessoa, String cpf, String cidade, String email,
            String nomeUsuario,
            String senha, int transferenciaR, double saldoConta) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(this.idConta);
        dos.writeUTF(this.nomePessoa);
        dos.writeUTF(this.cpf);
        dos.writeUTF(this.cidade);
        dos.writeUTF(this.email);
        dos.writeUTF(this.nomeUsuario);
        dos.writeUTF(this.senha);
        dos.writeInt(this.transferenciaRealizada);
        dos.writeDouble(this.saldoConta);

        return baos.toByteArray();
    }

    // Vetor de Bytes para a Compactação
    public byte[] toByteArray(List<Integer>arqComp) throws IOException { // recebe o arquivo compactado
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); // cria um tipo byte array
        DataOutputStream dos = new DataOutputStream(baos); // cria dados do tipo byte array
        int tamanho = arqComp.size(); // pega o tamanho do arquivo compactado

        dos.writeUTF(arqComp.toString()); //transoforma o arquivo compactado em String para escrever no arquivo
        System.out.println("ARQUIVO ESCRITO COM SUCESSO!");

        return baos.toByteArray(); // retorna o vetor de bytes da escrita do arquivo
    }

    // FAZ A LEITURA DE UM REGISTRO(VETOR DE BYTES);
    public void fromByteArray(byte[] ba) throws IOException { // recebe um vetor de bytes
        ByteArrayInputStream bais = new ByteArrayInputStream(ba); // cria um byte array de leitura
        DataInputStream dis = new DataInputStream(bais); // transforma os dados em byte array de leitura

        this.idConta = dis.readInt(); // lê o id da conta do objeto
        this.nomePessoa = dis.readUTF();
        this.email = dis.readUTF();
        this.nomeUsuario = dis.readUTF();
        this.senha = dis.readUTF();
        this.cpf = dis.readUTF();
        this.cidade = dis.readUTF();
        this.transferenciaRealizada = dis.readInt();
        this.saldoConta = dis.readDouble();
    }

    // FAZ A LEITURA DE UM REGISTRO(VETOR DE BYTES);
    public void fromByteArray(byte[] ba, List<Integer> comprimir) throws IOException { // recebe um vetor de bytes eu arquivo comprimido
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
        String auxComprimir; // variável auxiliar

        auxComprimir = comprimir.toString(); // auxiliar recebe o arquivo comprimido convertido para string
        auxComprimir = dis.readUTF(); // lê o arquivo comprimido
        System.out.println("ARQUIVO LIDO COM SUCESSO!");
        
    }

    // MÉTODO PARA LEITURA DE ARQUIVO COMPACTADO;
    public void lerArquivoCompactado(List<Integer> comprimir) { // recebe um arquivo comprimido
        FileInputStream arquivo2;
        DataInputStream dis;
        int tam;

        try {
            arquivo2 = new FileInputStream("tp02/teste/dados/ContaBancariaCompressao1.db"); // "arquivo" recebe um objeto de tipo arquivo;
            // DataOutputStream é um intermediário em que transforma o objeto "arquivo" em
            // sequência de bytes;
            dis = new DataInputStream(arquivo2); // "dos" recebe um objeto de tipo dado de saída e o parâmetro arquivo;

            tam = dis.readInt();
            ba = new byte[tam];
            dis.read(ba);
            fromByteArray(ba, comprimir);
            arquivo2.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MÉTODO PARA ESCREVER A CONTA BANCÁRIA DE UM OBJETO EM UM ARQUIVO;
    public void escreverArquivo(int idConta, String nomePessoa, String cpf, String cidade, String email,
            String nomeUsuario,
            String senha, int transferenciaR, double saldoConta) { // recebe os argumentos de dados da  conta
        this.idConta = idConta; // o id conta do objeto recebe o id conta do argumento;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.cidade = cidade;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.transferenciaRealizada = transferenciaR;
        this.saldoConta = saldoConta;
        try {
            FileOutputStream arquivo;
            DataOutputStream dos;

            arquivo = new FileOutputStream("tp02/teste/dados/contas.db", true); // "arquivo" recebe um objeto de tipo arquivo;
            // DataOutputStream é um intermediário em que transforma o objeto "arquivo" em
            // sequência de bytes;
            dos = new DataOutputStream(arquivo); // "dos" recebe um objeto de tipo dado de saída e o parâmetro arquivo;

            ba = toByteArray(idConta, nomePessoa, cpf, cidade, email, nomeUsuario, senha, transferenciaR, saldoConta); // objeto vetor de bytes recebe o método que transforma a classe Conta em um
                                // vetor e bytes;
            dos.writeInt(ba.length); // Escreve no arquivo o tamanho do registro Conta em vetor de bytes;
            dos.write(ba); // Escreve o registro Conta;
            arquivo.close(); // Fecha o arquivo;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MÉTODO PARAE ESCREVER UMA CONTA BANCÁRIA EM UM ARQUIVO COMPACTADO;
    public void escreverArquivoCompactado(List<Integer> arqCompactado) {
        List<Integer> arqComp = arqCompactado;

        try {
            FileOutputStream arquivo;
            DataOutputStream dos;

            arquivo = new FileOutputStream("tp02/teste/dados/ContaBancariaCompressao1.db", true); // "arquivo" recebe um objeto de tipo arquivo;
            // DataOutputStream é um intermediário em que transforma o objeto "arquivo" em
            // sequência de bytes;
            dos = new DataOutputStream(arquivo); // "dos" recebe um objeto de tipo dado de saída e o parâmetro arquivo;

            ba = toByteArray(arqComp); // objeto vetor de bytes recebe o método que transforma a classe Conta em um
                                // vetor e bytes;
            dos.writeInt(ba.length); // Escreve no arquivo o tamanho do registro Conta em vetor de bytes;
            dos.write(ba); // Escreve o registro Conta;
            arquivo.close(); // Fecha o arquivo;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MÉTODO PARA LER UM ARQUIVO DE CONTA BANCÁRIA;
    public void lerArquivo() {
        FileInputStream arquivo2;
        DataInputStream dis;

        try {
            arquivo2 = new FileInputStream("tp02/teste/dados/contas.db"); // "arquivo" recebe um objeto de tipo arquivo;
            // DataOutputStream é um intermediário em que transforma o objeto "arquivo" em
            // sequência de bytes;
            dis = new DataInputStream(arquivo2); // "dis" recebe um objeto de tipo dado de saída e o parâmetro arquivo;

            idConta = dis.readInt();
            nomePessoa = dis.readUTF();
            cpf = dis.readUTF();
            cidade = dis.readUTF();
            email = dis.readUTF();
            nomeUsuario = dis.readUTF();
            senha = dis.readUTF();
            transferenciaRealizada = dis.readInt();
            saldoConta = dis.readDouble();
            System.out.println("Arquivo lido.");
            arquivo2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MÉTODO PARA IMPRIMIR CONTAS;
    public void imprimir() {
        System.out.println("ID da Conta: " + this.idConta);
        System.out.println("Nome: " + this.nomePessoa);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Email: " + this.email);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Nome de usuario: " + this.nomeUsuario);
        System.out.println("Senha: " + this.senha);
        System.out.println("Transferências Realizadas: " + this.transferenciaRealizada);
        System.out.println("Saldo da Conta: " + this.saldoConta);
        System.out.println();
    }

    /* sets */
    public void setIdConta(int idConta) { // Muda o idConta para o que receber com argumento;
        this.idConta = idConta;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setTransferenciaRealizada(int transferenciaRealizada) {
        this.transferenciaRealizada = transferenciaRealizada;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public void setConcatenar(String concatenar) {
        this.concatenar = concatenar;
    }
    
    public void setComprimido(List<Integer> comprimido) {
        this.comprimido = comprimido;
    }

    public void setDescomprimido(String descomprimido) {
        this.descomprimido = descomprimido;
    }
    
    public void setSenhaCripto(String senhaCripto) {
        this.senhaCripto = senhaCripto;
    }

    public void setSenhaDescripto(String senhaDescripto) {
        this.senhaDescripto = senhaDescripto;
    }

    /* gets */
    public int getIdConta() { // Pega o id da conta e retorna seu valor;
        return idConta;
    }

    public String getNomePessoa() {
        return this.nomePessoa;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public int getTransferenciaRealizada() {
        return transferenciaRealizada;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public String getConcatenar() {
        return concatenar;
    }
    
    public List<Integer> getComprimido() {
        return comprimido;
    }

    public String getDescomprimido() {
        return descomprimido;
    }

    public String getSenhaCripto() {
        return senhaCripto;
    }

    public String getSenhaDescripto() {
        return senhaDescripto;
    }
}
