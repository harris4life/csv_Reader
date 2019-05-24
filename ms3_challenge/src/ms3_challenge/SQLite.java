package ms3_challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite{
	 
	
	
	
	public static void main(String args[]){
		
		
		try{
			//establish connection with database
			Class.forName("org.sqlite.JDBC");
			Connection con=DriverManager.getConnection("jdbc:sqlite:demo.db");
 
			if(con!=null){
				System.out.println("Connection established");
			}
			
			Statement st = con.createStatement();

	
			st.executeUpdate("CREATE TABLE CSV (A text, B text, C text, D text, "
					+ "E text, F text, G text, H text, I text, J text)");
			
			
			st.close();
			con.close();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Some error occured");
		}
		
		
		
		
	}	
	
	
	
	
	/*public void addRow(String[] row) throws SQLException {
		
		st.executeUpdate("INSERT INTO CSV VALUES ("
				+ row[0] + ","
				+ row[1] + ","
				+ row[2] + ","
				+ row[3] + ","
				+ row[4] + ","
				+ row[5] + ","
				+ row[6] + ","
				+ row[7] + ","
				+ row[8] + ","
				+ row[9] + ")");
	}*/
	
	
	
	
	
	
	
	
}