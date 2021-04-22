package connectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DizionarioDAO {
	
	
	public boolean esiste(String parola) {
	
	boolean trovato = false;
	String sql = "SELECT nome FROM parola WHERE nome = ?";
	
	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, parola);
		ResultSet rs = st.executeQuery();
		if(rs.next())
			trovato = true;
		conn.close();
		return trovato;

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
