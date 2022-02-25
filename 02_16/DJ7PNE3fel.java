package dj7pne_db2;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DJ7PNE3fel {

	Connection conn = null;
	
	public void Connect() {
		
		String url = "jdbc:oracle:thin:@193.6.5.58:1521:XE";
		String user = "H22_DJ7PNE";
		String pwd = "DJ7PNE";
		try {
			
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Sikeres kapcsolódás\n");
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public void LeKapcs() {
		
		if(conn!=null) {
			
			try {
				
				conn.close();
				System.out.println("Sikeres lekapcsolódás!");
				
			} catch(Exception ex) {
				
				System.err.println(ex.getMessage());
				
			}
			
		}
		
	}
	
	public void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 0);
	}
	
}
