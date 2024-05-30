package debari.roberto.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import debari.roberto.database.pojo.Nome;

public class DaoAccessNumero {
	final String DB_URL = "jdbc:mysql://localhost:3307/db_rubrica";
	final String DB_USER = "root";
	final String DB_PASS = "robb";
	Connection conn=null;
	final String INSERT = "INSERT INTO nominativi(nome,cognome,email,numerotel) VALUES(?,?,?,?)";
	final String SELECT="SELECT * FROM nominativi";
	final String DELETE="DELETE FROM nominativi where idnominativi = ? ";
	final String UPDATE ="UPDATE SET nome = ?,cognome = ?, email = ?, numerotel = ?  where idnominativi = ?   ";
	public Connection conn() {
		try {
	        conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void insertnumero(Nome nome) throws SQLException {
		conn=conn();
		PreparedStatement ps=conn.prepareStatement(INSERT);
		ps.setString(1, nome.getNome());
		ps.setString(2, nome.getCognome());
		ps.setString(3, nome.getEmail());
		ps.setInt(4, nome.getNtel());
		ps.executeUpdate();
	}
	public List<Nome> selectallnumber(){
		List <Nome> nomi = new ArrayList <>() ;
		conn=conn();
		try {
			PreparedStatement ps=conn.prepareStatement(SELECT);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("idnominativi");
				String nome= rs.getString("nome");
				String cognome= rs.getString("cognome");
				String email= rs.getString("email");
				int ntel= rs.getInt("numerotel");
				nomi.add(new Nome(nome,cognome,cognome,ntel,id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return nomi;
	}
public void deletenumber(int id){
	conn=conn();
	try {
		PreparedStatement ps=conn.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
public void updatenumber(String nome, String cognome, String email,int ntel,int id) throws SQLException{
	conn=conn();
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE);
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, cognome);
        preparedStatement.setString(3, email);
        preparedStatement.setInt(4, ntel);
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
}	
}
