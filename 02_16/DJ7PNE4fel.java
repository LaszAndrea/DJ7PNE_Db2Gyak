package dj7pne_db2;

import java.sql.Connection;

public class DJ7PNE4fel {

	Connection conn = null;
	
	public void LeKapcs() {

		if (conn != null) {

			try {

				conn.close();
				System.out.println("Sikeres lekapcsolódás!");

			} catch (Exception ex) {

				System.err.println(ex.getMessage());

			}

		}

	}

}
