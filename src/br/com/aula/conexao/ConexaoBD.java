package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexaoBD {

	private static final String URL = "jdbc:mysql://localhost:3306/aula_java_db"; //CONEXÃO COM O BANCO DE DADOS
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public static Connection conectar() { //conexão do usuario, com as informações acima
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conexão realizada com sucesso!");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver não encontrado: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Erro ao conectar " + e.getMessage());
		}
		return conexao;
	}
	public static void main(String[] args) { //apenas o conectar
		conectar();
	}
}