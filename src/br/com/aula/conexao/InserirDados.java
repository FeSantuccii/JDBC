package br.com.aula.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar();
		if (conexao != null) {
			String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)"; //INSERT INTO NO BANCO DE DADOS
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1,  "João da Silva");
				stmt.setInt(2, 20);
				stmt.executeUpdate(); //todos os incluidos no banco de dados
				
				stmt.setString(1, "Maria Souza");
				stmt.setInt(2, 22);
				stmt.executeUpdate();
				
				stmt.setString(1, "Pedro Santos");
				stmt.setInt(2, 25);
				stmt.executeUpdate();
				
				System.out.println("Dados inseridos com sucesso!");
			} catch (SQLException e) {
				System.err.println("Erro ao inserir dados " + e.getMessage());//aviso de erro ao inserir
			} finally {
				try {
					if (conexao != null) conexao.close();
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexao: "  + e.getMessage()); // aviso de erro ao fechar conexão
				}
			}
				
		}
	}
}
