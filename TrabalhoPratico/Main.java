package tp03.teste;

import java.util.*;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import tp03.classe.AES;
import tp03.classe.ContaBancaria;
import tp03.classe.LZW;
import tp03.classe.Menu;

public class Main {
    public static void main(String[] args) {
        ContaBancaria contas[] = new ContaBancaria[1]; // criar um vetor de objetos tamanho 3;
        Scanner entrada = new Scanner(System.in);
        Menu menu = new Menu();

        int opcaoMain = 0;
        String nomeP, cidade, email, nomeU, senha;
        String cpf;
        int i, transferenciaR = 0;
        double saldoConta = 0;

        final String senhaChave = "ssshhhhhhhhhhh!!!!"; // chave para criptografar
        String senhaUsuario; // variável que receberá a senha do usuário
         String senhaCripto;
         String senhaDescripto;

        do {
            opcaoMain = menu.exibirMenu();

            switch (opcaoMain) {
                case 0:
                    System.out.println("Saindo...");
                    entrada.close();
                    System.out.println();
                    break;

                case 1: {
                    for (i = 0; i < contas.length; i++) {
                        // Usuário preenche os dados;
                        System.out.println("Digite seu nome:");
                        nomeP = entrada.nextLine();

                        System.out.println("Digite seu cpf:");
                        cpf = entrada.nextLine();

                        System.out.println("Digite seu e-mail:");
                        email = entrada.nextLine();

                        System.out.println("Digite sua cidade:");
                        cidade = entrada.nextLine();

                        System.out.println("Digite seu usuário:");
                        nomeU = entrada.nextLine();

                        System.out.println("Digite sua senha:");
                        senha = entrada.nextLine();

                        System.out.println("Informe seu saldo:");
                        saldoConta = entrada.nextDouble();

                        // Constrói os objetos com os dados inseridos;
                        contas[i] = new ContaBancaria(i + 1, nomeP, cpf, email, cidade, nomeU, senha, 0, saldoConta);
                        
                       // contas[i].setSenhaCripto(senha);
                        senhaUsuario = contas[i].getSenha();
                        senhaCripto = AES.encrypt(senhaUsuario, senhaChave);
                        contas[i].setSenha(senhaCripto);
                        contas[i].escreverArquivo(i + 1, nomeP, cpf, cidade, email, nomeU, senhaCripto, transferenciaR, saldoConta);
                        
                        clearBuffer(entrada); // LIMPA O BUFFER
                        System.out.println();
                    }
                }
                    break;

                case 2: {
                    double valorTransf = 0, valorDestino = 0;
                    /*
                     * Exemplo: usuário tsuna/de nome Andre(saldo: 1000) quero transferir para usuário ronin de nome Rafael(saldo: 800) 100 reais.
                     * 
                     */
                    System.out.println("Deseja transferir para quem?");
                    nomeU = entrada.nextLine(); // transferir para ronin.
                    System.out.println("Valor a ser transferido:");
                    valorTransf = entrada.nextDouble();
                    transferenciaR++;

                    if (nomeU.equals(contas[0].getNomeUsuario())) { // Transferir de Rafael para Andre
                        saldoConta = contas[1].getSaldoConta(); // pegando saldo atual de Rafael
                        saldoConta = saldoConta - valorTransf; // debitando na conta de Rafael
                        contas[1].setSaldoConta(saldoConta); // saldo debitado de Rafael
                        valorDestino = contas[0].getSaldoConta() + valorTransf; // armazenando o saldo atual de Andre e
                                                                                // somando o saldo acrescentado
                        contas[0].setSaldoConta(valorDestino); // armazenando o saldo acrescentado na conta Andre

                        contas[0].setTransferenciaRealizada(transferenciaR); // acrescenta transferencia para Andre
                        contas[1].setTransferenciaRealizada(transferenciaR); // acrescenta transferencia para Rafael
                        System.out.println();
                    } else if (nomeU.equals(contas[1].getNomeUsuario())) { // Transferir de Andre para Rafael
                        saldoConta = contas[0].getSaldoConta(); // pegando saldo atual de Andre
                        saldoConta = saldoConta - valorTransf; // debitando na conta de Andre
                        contas[0].setSaldoConta(saldoConta); // saldo debitado de Andre
                        valorDestino = contas[1].getSaldoConta() + valorTransf; // armazenando o saldo atual de Rafael e
                                                                                // somando o saldo acrescentado
                        contas[1].setSaldoConta(valorDestino); // armazenando o saldo acrescentado na conta Rafael

                        contas[0].setTransferenciaRealizada(transferenciaR); // acrescenta transferencia para Andre
                        contas[1].setTransferenciaRealizada(transferenciaR); // acrescenta transferencia para Rafael
                        System.out.println();
                    } else {
                        System.out.println("Usuário não existe.");
                    }
                    clearBuffer(entrada);
                }
                    break;

                case 3:
                    // IMPRIME CONTAS CRIADAS;
                    for (i = 0; i < contas.length; i++) {
                        contas[i].imprimir();
                    }
                    break;

                case 4: {
                    // FAZ A LEITURA DE UM REGISTRO E IMPRIME A CONTA LIDA;
                    System.out.println("Digite o nome do usuario:");
                    nomeU = entrada.nextLine();
                    if (nomeU.equals(contas[0].getNomeUsuario())) {
                        senhaCripto = contas[0].getSenha();
                        senhaDescripto = AES.decrypt(senhaCripto, senhaChave);
                        contas[0].setSenha(senhaDescripto);
                        contas[0].setSenha(senhaDescripto);
                        contas[0].imprimir();
                        contas[0].lerArquivo();
                    } else if (nomeU.equals(contas[1].getNomeUsuario())) {
                        senhaCripto = contas[1].getSenha();
                        senhaDescripto = AES.decrypt(senhaCripto, senhaChave);
                        contas[1].setSenha(senhaDescripto);
                        contas[1].setSenha(senhaDescripto);
                        contas[1].imprimir();
                        contas[1].lerArquivo();
                    } else {
                        System.out.println("Usuário não existe.");
                    }
                    clearBuffer(entrada);
                }
                    break;

                case 5: {
                    // ATUALIZA DADOS DE UM REGISTRO
                    int id0 = 0, id1 = 0;
                    id0 = contas[0].getIdConta();
                    id1 = contas[1].getIdConta();

                    System.out.println("Digite o nome do usuário:");
                    nomeU = entrada.nextLine();
                    // se for igual ao nome de usuário da conta 0;
                    if (nomeU.equals(contas[0].getNomeUsuario())) {
                        id0 = contas[1].getIdConta() + 1;
                        contas[0].setIdConta(id0);

                        System.out.println("Digite seu novo nome:");
                        nomeP = entrada.nextLine();

                        System.out.println("Digite seu novo cpf:");
                        cpf = entrada.nextLine();

                        System.out.println("Digite seu novo e-mail:");
                        email = entrada.nextLine();

                        System.out.println("Digite sua novo cidade:");
                        cidade = entrada.nextLine();

                        System.out.println("Digite seu novo usuário:");
                        nomeU = entrada.nextLine();

                        System.out.println("Digite sua novo senha:");
                        senha = entrada.nextLine();

                        System.out.println("Informe seu novo saldo:");
                        saldoConta = entrada.nextDouble();

                        contas[0] = new ContaBancaria(id0, nomeP, cpf, email, cidade, nomeU, senha, saldoConta);
                    } else if (nomeU.equals(contas[1].getNomeUsuario())) { // se for igual ao nome de usuário da conta 1;
                        id1 = contas[1].getIdConta() + 1;
                        contas[1].setIdConta(id1); // Muda o valor do id

                        System.out.println("Digite seu novo nome:");
                        nomeP = entrada.nextLine();

                        System.out.println("Digite seu novo cpf:");
                        cpf = entrada.nextLine();

                        System.out.println("Digite seu novo e-mail:");
                        email = entrada.nextLine();

                        System.out.println("Digite sua novo cidade:");
                        cidade = entrada.nextLine();

                        System.out.println("Digite seu novo usuário:");
                        nomeU = entrada.nextLine();

                        System.out.println("Digite sua novo senha:");
                        senha = entrada.nextLine();

                        System.out.println("Informe seu novo saldo:");
                        saldoConta = entrada.nextDouble();

                        contas[1] = new ContaBancaria(id1, nomeP, cpf, email, cidade, nomeU, senha, saldoConta); // Muda os valores acima
                    } else { // se não for igual a nenhuma conta;
                        System.out.println("Usuário não existe.");
                    }
                    clearBuffer(entrada);
                }
                    break;

                case 6: { // DELETA UM REGISTRO
                    System.out.println("Qual Usuario desejas deletar?");
                    nomeU = entrada.nextLine();

                    if (nomeU.equals(contas[0].getNomeUsuario())) { // se for igual ao nome de usuário da conta 0;
                        contas[0] = new ContaBancaria(); // conta 0 recebe Construtor vazio (valores = null);
                    } else if (nomeU.equals(contas[1].getNomeUsuario())) { // se for igual ao nome de usuário da conta 1;
                        contas[1] = new ContaBancaria();
                    } else { // se não for igual a nenhuma conta;
                        System.out.println("Usuário não existe.");
                    }
                    clearBuffer(entrada);
                }
                break;
                
                case 7: // Compactação
                    {
                        // variável concatenar recebe a concatenação dos atributos das conta de um usuário;
                        String concatenar;
                        concatenar ="ID da Conta: "  + contas[0].getIdConta() + " Nome: " + contas[0].getNomePessoa() + " CPF: " + contas[0].getCpf() + " Email: " +
                        contas[0].getEmail() + " Cidade: " + contas[0].getCidade() + " Usuario: " + contas[0].getNomeUsuario() + " Senha: " +
                        contas[0].getSenha() + " Transferências realizadas: " + contas[0].getTransferenciaRealizada() + " Saldo da Conta: " +
                        contas[0].getSaldoConta();

                        contas[0].setConcatenar(concatenar); // muda o valor do atributo concatenara para o que foi escrito acima;

                        List<Integer> comprimir = LZW.compress(contas[0].getConcatenar()); // comprimir recebe o arquivo concatenado comprimido;
                        contas[0].setComprimido(comprimir); // conta 0 tem o seu valor de arquivo comprimido alterado para o valor de concatenado;
                        System.out.println("ARQUIVO COMPRIMIDO:");
                        System.out.println(contas[0].getComprimido()); // da conta 0, pega o arquivo comprimido;
                        System.out.println();
                        System.out.println("ESCREVENDO NO ARQUIVO...");
                        contas[0].escreverArquivoCompactado(comprimir); // da conta 0, escreve o arquivo comprimido
                        System.out.println("Perda: 0%");
                        System.out.println();
                    }
                break;

                case 8: // Descompactação
                    {
                        String descomprimido;
                        descomprimido = LZW.decompress(contas[0].getComprimido()); // descomprimido recebe descompressão LZW de  um arquivo comprimido;
                        System.out.println("LENDO O ARQUIVO...");
                        System.out.println();
                        contas[0].lerArquivoCompactado(contas[0].getComprimido()); // o arquivo descomprimido é lido;
                        System.out.println();
                        System.out.println("ARQUIVO DESCOMPACTADO:");
                        System.out.println(descomprimido); // mostra o arquivo lido;
                        System.out.println();
                    }
                break;

                default:
                    System.out.println("[ERRO] - Opção inválida!");
                    System.out.println();
            }

        } while (opcaoMain != 0);
    }

    // Método de limpeza de buffer
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

}
