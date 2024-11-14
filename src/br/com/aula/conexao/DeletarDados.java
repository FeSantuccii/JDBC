package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarDados { //DELETAR DO BANCO DE DADOS
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM alunos WHERE id = ?"; //DELETE do bd
            try (Scanner scanner = new Scanner(System.in)) {
				try {
				    System.out.print("Digite o ID do aluno que deseja deletar: ");
				    int id = scanner.nextInt();

				    PreparedStatement stmt = conexao.prepareStatement(sql);
				    stmt.setInt(1, id);

				    int rowsDeleted = stmt.executeUpdate();

				    if (rowsDeleted > 0) {
				        System.out.println("Registro deletado com sucesso!");
				    } else {
				        System.out.println("Nenhum registro encontrado com o ID especificado."); //aviso de erro
				    }
				} catch (SQLException e) {
				    System.err.println("Erro ao deletar dados: " + e.getMessage());
				} finally {
				    try {
				        if (conexao != null) conexao.close();
				    } catch (SQLException e) {
				        System.err.println("Erro ao fechar conexão: " + e.getMessage());
				    }
				}
			}
        }
    }
}