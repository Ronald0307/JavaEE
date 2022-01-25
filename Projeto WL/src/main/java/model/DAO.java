package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  Módulo de conexao *. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://192.168.15.2:3306/dbprojeto?useTimezone=true$serverTimezone=UTC";
	
	/** The user. */
	private String user = "dba";
	
	/** The password. */
	private String password = "Dba@123456";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD CREATE *.
	 *
	 * @param projeto the projeto
	 */
	public void inserirProjeto(JavaBeans projeto) {
		String create = "insert into projeto ( nome, cpf, item) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, projeto.getNome());
			pst.setString(2, projeto.getCpf());
			pst.setString(3, projeto.getItem());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 *  CRUD READ *.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarProjeto() {
		ArrayList<JavaBeans> projeto = new ArrayList<>();
		String read = "select * from projeto order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String item = rs.getString(4);
				projeto.add(new JavaBeans(idcon, nome, cpf, item));
				{
				}
			}
			con.close();
			return projeto;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD UPDATE *.
	 *
	 * @param projeto the projeto
	 */
	public void selecionarProjeto(JavaBeans projeto) {
		String read2 = "select * from projeto where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, projeto.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				projeto.setIdcon(rs.getString(1));
				projeto.setNome(rs.getString(2));
				projeto.setCpf(rs.getString(3));
				projeto.setItem(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar dados.
	 *
	 * @param projeto the projeto
	 */
	public void alterarDados(JavaBeans projeto) {
		String create = "update projeto set nome =?, cpf=?, item=? where idcon =?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, projeto.getNome());
			pst.setString(2, projeto.getCpf());
			pst.setString(3, projeto.getItem());
			pst.setString(4, projeto.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 *  CRUD DELETE *.
	 *
	 * @param projeto the projeto
	 */
	public void deletarProjeto(JavaBeans projeto) {
		String delete = "delete from projeto where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, projeto.getIdcon());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}