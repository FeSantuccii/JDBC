package br.com.aula.conexao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do { //pequena interface
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Deletar Aluno");
            System.out.println("4. Ler registros de Alunos");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) { //todas as situações
                case 1:
                    InserirDados.main(null);
                    break;
                case 2:
                    AtualizarDados.main(null);
                    break;
                case 3:
                    DeletarDados.main(null);
                    break;
                case 4:
                    LerDados.main(null);
                    break;
                case 0:
                    System.out.println("Saindo..."); //mensagem de saída
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}