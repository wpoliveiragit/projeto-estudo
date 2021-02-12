package arrumar.conexaoSQL;

/*
 * ConexaoPGSQL.java
 * 
 * Classe usada para realizar a conexão com o banco de dados PostregreSQL
 * 
 * Autor: Claudio A. Colares  05 de Maio de 2010 07:24
 * 
 ********************************************************************************************/

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Essa classe tem a finalidade de realizar uma conexao com uma base de dados
 * PostegreSQL. Nela existe dois metodos, o primeiro Conectar(), realiza a
 * conexao com o banco de dados e o segundo, Desconectar(), realiza a desconexao
 * (Desconecta) o banco de dados.
 */

public class ConexaoPGSQL {

	public static void main(String[] args) {
		ConexaoPGSQL banco = new ConexaoPGSQL();

		banco.Conectar("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

		try {
			ResultSet r = banco.stmt.executeQuery("create database testee;");
			System.out.println(r.getRow());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** Usada para a conexao com o banco de dados */
	private Connection con = null;

	/** Usada para realizar as instrucoes SQL */
	public Statement stmt;

	/** Retorna os dados das tabelas do banco */
	public ResultSet rs;

	/** Usada para receber o endereco da base de dados */
	private String endereco;

	/** Usada para receber o nome do usuario do banco */
	private String usuario;

	/** Usada para receber a senha do usuario do banco */
	private String senha;

	/**
	 * Esse metodo realiza a conexao com o banco, ele precisa de tres argumentos, o
	 * primeiro, recebe o endereço do banco, o segundo recebe o nome do usuario e o
	 * terceiro recebe a senha do banco de dados.
	 * 
	 * EXP: "jdbc:postgresql://localhost:5432/projeto_01", "sa", "sa"
	 * 
	 **************************************************************************************************/

	public void Conectar(String strEnd, String strUsuario, String strSenha) {

		/**
		 * Recebendo o endereco,usuario e senha do usuario e repassando para a variavel
		 * global
		 */
		endereco = strEnd;
		usuario = strUsuario;
		senha = strSenha;

		try {
			/** Pasando o nome do Driver do PostgreSQL */
			Class.forName("org.postgresql.Driver");

			/** Obtendo a conexao com o banco de dados */
			con = DriverManager.getConnection(endereco, usuario, strSenha);

			/** Criando o Statement */
			stmt = con.createStatement();

			/**
			 * Retorna um erro caso nao encontre o driver, ou alguma informacao sobre o
			 * mesmo esteja errada
			 */
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
			cnfe.printStackTrace();

			/** Retorna um erro caso exista erro de query SQL */
		} catch (SQLException sqlex) {
			JOptionPane.showMessageDialog(null, "erro na query");
			sqlex.printStackTrace();

		}
	}

	/** Esse metodo quando invocado, realiza a desconexao com o banco */
	public void Desconectar() {

		try {
			con.close();

			/** Retorna um erro caso nao consiga desconectar */
		} catch (SQLException onConClose) {
			JOptionPane.showMessageDialog(null, "Erro ao desconectar o banco");
			onConClose.printStackTrace();
		}
	}
}
