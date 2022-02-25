package dj7pne_db2;

import javax.swing.JOptionPane;

public class DJ7PNE2fel {

	
	public void DrReg() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sikeres driver regisztrálás!");
		} catch (Exception ex) {
			error("Hiba történt: " + ex.getMessage());
		}
	}
	
	public void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 0);
	}
	
}
