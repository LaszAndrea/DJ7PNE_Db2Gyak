package program;

import java.sql.*;
import java.util.Formatter;

import javax.swing.JOptionPane;

public class Metódusok {

	private Connection conn = null;
	private Statement s = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private Formatter x;
	Kiolvasáshoz4 k;
	Kiolvasáshoz kk;

	public void DrReg2() {
		try {
			Class.forName("org.sqlite.JDBC");
			msg("Sikeres driver regisztrálás!");
		} catch (Exception ex) {
			error("Hiba történt: " + ex.getMessage());
		}
	}

	public void Kapcs() {
		String url = "jdbc:sqlite:/D:/beadando.db";
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException ex) {
			error("Hiba lépett fel a kapcsolat kialakítása közben:\n" + ex.getMessage());
		}
	}

	public void LeKapcs() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				error("Hiba történt: " + ex.getMessage());
			}
		} else {
			error("Nincsen kapcsolat létrehozva.");
		}
	}

	public void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 2);
	}

	public void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 0);
	}

	public String RTST(int row, int cm) {
		return kk.getValueAt(row, cm).toString();
	}

	public int Log(String user, String pswd) {
		Kapcs();
		int pc = -1;
		String sql = "select count(*) pc from Users where user='" + user + "' and pwd='" + pswd + "';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				pc = rs.getInt("pc");
			}
			rs.close();
		} catch (SQLException e) {
			error(e.getMessage());
		}
		LeKapcs();
		return pc;
	}

	public Kiolvasáshoz4 UserOlv() {

		Object[] users = { "user", "pwd" };
		Kiolvasáshoz4 k = new Kiolvasáshoz4(users, 0);
		String user = "", pswd = "";
		String sql = "Select * from Users";
		Kapcs();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				user = rs.getString("user");
				pswd = rs.getString("pwd");
				k.addRow(new Object[] { user, pswd });
			}
			rs.close();
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
		LeKapcs();
		return k;

	}

	public void TablaLetrehozas() {

		Kapcs();
		String sqlp_tasak = "create table if not exists Tasak ( tID int primary key,"
				+ "Szerzodesszam int not null, Szelesseg int check(Szelesseg>0), Talphossz int check(Talphossz>0), Magasság int check(Magasság>0), Retegek int check(Retegek>0), Hosszragaszto int check(Hosszragaszto>0), Talpragaszto int check(Talpragaszto>0), Mennyiseg int check(Mennyiseg>0), Date2 date)";
		String sqlp_nyomdai = "create table if not exists Nyomdai( nyID int primary key,"
				+ "Szerzodesszam int not null,  Vevo char(20) not null, Termek char(40) not null, Minoseg char(35) not null, Gramsuly int check(Gramsuly>0), Szelesseg int check(Szelesseg>0), Vagashossz int check(Vagashossz>0), Festekek int check(Festekek>0), Palyak int check(Palyak>0), Date date not null)";
		String sqlp_users = "create table if not exists Users ( user char(5)," + "pwd char(5) )";
		if (conn != null) {

			try {
				s = conn.createStatement();
				s.executeUpdate(sqlp_tasak);
				s.executeUpdate(sqlp_nyomdai);
				s.executeUpdate(sqlp_users);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}

		}

		k = this.UserOlv();
		int sor = k.getRowCount();
		if (sor == 0) {
			String users = "insert into Users values ('admin', 'admin')";
			Kapcs();

			if (conn != null) {
				try {
					s = conn.createStatement();
					s.executeUpdate(users);
					s.close();
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}

			}
		}

		LeKapcs();

	}

	public void TasakFelv(String tID, String Szerzodesszam, String Szelesseg, String Talphossz, String Magassag,
			String Retegek, String Hosszragaszto, String Talpragaszto, String Mennyiseg, String Date) {
		Kapcs();
		String sql = "insert into Tasak values (" + tID + ", '" + Szerzodesszam + "','" + Szelesseg + "', '" + Talphossz
				+ "', '" + Magassag + "', '" + Retegek + "', '" + Hosszragaszto + "', '" + Talpragaszto + "', '"
				+ Mennyiseg + "', '" + Date + "')";
		try {
			s = conn.createStatement();
			s.executeUpdate(sql);
			msg("Sikeres tasak hozzáadás!");
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
		LeKapcs();
	}

	public void NyomdaiFelv(String nyID, String Szerzodesszam, String Vevo, String Termek, String Minoseg,
			String Gramsuly, String Szelesseg, String Vagashossz, String Festekek, String Palyak, String Date) {
		Kapcs();
		String sql = "insert into Nyomdai values (" + nyID + ", '" + Szerzodesszam + "', '" + Vevo + "', '" + Termek
				+ "', '" + Minoseg + "', '" + Gramsuly + "', '" + Szelesseg + "', '" + Vagashossz + "', '" + Festekek
				+ "', '" + Palyak + "', '" + Date + "')";
		try {
			s = conn.createStatement();
			s.executeUpdate(sql);
			msg("Sikeres nyomdai hozzáadás!");
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
		LeKapcs();
	}

	public Kiolvasáshoz TasakOlv() {
		Object[] tasakok = { "Jel", "tid", "Szerzõdésszám", "Szélesség (mm)", "Talphossz (mm)", "Magasság (mm)",
				"Rétegek száma", "Hosszragasztó (kg)", "Talpragasztó (kg)", "Mennyiség (db)", "Igénylés leadása" };
		Kiolvasáshoz k = new Kiolvasáshoz(tasakok, 0);
		String szsz = "", tid = "", szeles = "", talph = "", m = "", retegek = "", hosszr = "", talpr = "",
				mennyiseg = "", date = "";
		String sql = "Select * from Tasak";
		Kapcs();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				tid = rs.getString("tID");
				szsz = rs.getString("Szerzodesszam");
				szeles = rs.getString("Szelesseg");
				talph = rs.getString("Talphossz");
				m = rs.getString("Magasság");
				retegek = rs.getString("Retegek");
				hosszr = rs.getString("Hosszragaszto");
				talpr = rs.getString("Talpragaszto");
				mennyiseg = rs.getString("Mennyiseg");
				date = rs.getString("Date2");
				k.addRow(new Object[] { false, tid, szsz, szeles, talph, m, retegek, hosszr, talpr, mennyiseg, date });
			}
			rs.close();
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
		LeKapcs();
		return k;
	}

	public void deleteTasak(String tid) {
		Kapcs();
		String sql = "delete from Tasak where tID=" + tid;
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error(e.getMessage());
		}
		LeKapcs();
	}

	public void modositTasakSz(String szsz, String tid) {
		Kapcs();
		String sql = "update Tasak set Szerzodesszam='" + szsz + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositTasakSzel(String szel, String tid) {
		Kapcs();
		String sql = "update Tasak set Szelesseg='" + szel + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositTasakTh(String th, String tid) {
		Kapcs();
		String sql = "update Tasak set Talphossz='" + th + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositTasakM(String m, String tid) {
		Kapcs();
		String sql = "update Tasak set Magasság='" + m + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositTasakR(String rt, String tid) {
		Kapcs();
		String sql = "update Tasak set Retegek='" + rt + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositTasakHr(String hr, String tid) {
		Kapcs();
		String sql = "update Tasak set Hosszragaszto='" + hr + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositTasakTr(String tr, String tid) {
		Kapcs();
		String sql = "update Tasak set Talpragaszto='" + tr + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositTasakMenny(String mnny, String tid) {
		Kapcs();
		String sql = "update Tasak set Mennyiseg='" + mnny + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositTasakDate(String date, String tid) {
		Kapcs();
		String sql = "update Tasak set Date2='" + date + "' where tid='" + tid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void openFile(String txtName) {
		try {
			x = new Formatter(txtName);
		} catch (Exception e) {
			error(e.getMessage());
		}
	}

	public void closeFile() {
		x.close();
	}

	public void mentesTasak() {

		String szsz = "", tid = "", szeles = "", talph = "", m = "", retegek = "", hosszr = "", talpr = "",
				mennyiseg = "", date = "";
		String sql = "Select * from Tasak";
		Kapcs();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				tid = rs.getString("tID");
				szsz = rs.getString("Szerzodesszam");
				szeles = rs.getString("Szelesseg");
				talph = rs.getString("Talphossz");
				m = rs.getString("Magasság");
				retegek = rs.getString("Retegek");
				hosszr = rs.getString("Hosszragaszto");
				talpr = rs.getString("Talpragaszto");
				mennyiseg = rs.getString("Mennyiseg");
				date = rs.getString("Date2");
				x.format(tid + ";" + szsz + ";" + szeles + ";" + talph + ";" + m + ";" + retegek + ";" + hosszr + ";"
						+ talpr + ";" + mennyiseg + ";" + date + "\n");
			}
			rs.close();
			msg("Sikeres mentés txt-be!");
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}

		LeKapcs();

	}

	public Kiolvasáshoz2 NyomdaiOlv() {
		Object[] nyomdaiak = { "Jel", "nyID", "Szerzõdésszám", "Vevõ", "Termék neve", "Minõség", "Gramsúly",
				"Szélesség (mm)", "Vágáshossz (mm)", "Festékek száma", "Pályák száma", "Gyártás kezdete" };
		Kiolvasáshoz2 k = new Kiolvasáshoz2(nyomdaiak, 0);
		String szsz = "", nyid = "", szeles = "", talph = "", m = "", dobozdb = "", raklapdoboz = "", retegek = "",
				hosszr = "", talpr = "", date = "";
		String sql = "Select * from Nyomdai";
		Kapcs();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				nyid = rs.getString("nyID");
				szsz = rs.getString("Szerzodesszam");
				szeles = rs.getString("Vevo");
				talph = rs.getString("Termek");
				m = rs.getString("Minoseg");
				dobozdb = rs.getString("Gramsuly");
				raklapdoboz = rs.getString("Szelesseg");
				retegek = rs.getString("Vagashossz");
				hosszr = rs.getString("Festekek");
				talpr = rs.getString("Palyak");
				date = rs.getString("Date");
				k.addRow(new Object[] { false, nyid, szsz, szeles, talph, m, dobozdb, raklapdoboz, retegek, hosszr,
						talpr, date });
			}
			rs.close();
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
		LeKapcs();
		return k;
	}

	public void modositNyomdai(String nyid, String Szerzodesszam, String Vevo, String Termek, String Minoseg,
			String Gramsuly, String Szelesseg, String Vagashossz, String Festekek, String Palyak, String date) {
		Kapcs();
		String sql = "update Tasak set nyID='" + nyid + "', Szerzodesszam= '" + Szerzodesszam + "', Vevo= '" + Vevo
				+ "', Termek='" + Termek + "', Minoseg='" + Minoseg + "', Gramsuly='" + Gramsuly + "', Szelesseg='"
				+ Szelesseg + "', Vagashossz='" + Vagashossz + "', Festekek='" + Festekek + "', Palyak='" + Palyak + "'"
				+ "', Date='" + date + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
		LeKapcs();
	}

	public void mentesNyomdai() {

		String szsz = "", nyid = "", szeles = "", talph = "", m = "", dobozdb = "", raklapdoboz = "", retegek = "",
				hosszr = "", talpr = "", date = "";
		String sql = "Select * from Nyomdai";
		Kapcs();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				nyid = rs.getString("nyID");
				szsz = rs.getString("Szerzodesszam");
				szeles = rs.getString("Vevo");
				talph = rs.getString("Termek");
				m = rs.getString("Minoseg");
				dobozdb = rs.getString("Gramsuly");
				raklapdoboz = rs.getString("Szelesseg");
				retegek = rs.getString("Vagashossz");
				hosszr = rs.getString("Festekek");
				talpr = rs.getString("Palyak");
				date = rs.getString("Date");
				x.format(nyid + ";" + szsz + ";" + szeles + ";" + talph + ";" + m + ";" + dobozdb + ";" + raklapdoboz
						+ ";" + retegek + ";" + hosszr + ";" + talpr + ";" + date + "\n");
			}
			rs.close();
			msg("Sikeres mentés txt-be!");
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}

		LeKapcs();

	}

	public void modositNyomdaiSz(String szsz, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Szerzodesszam='" + szsz + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}

	}

	public void modositNyomdaiV(String vevo, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Vevo='" + vevo + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositNyomdaiT(String termek, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Termek='" + termek + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositNyomdaiGr(String grs, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Gramsuly='" + grs + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositNyomdaiMin(String min, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Minoseg='" + min + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositNyomdaiSzel(String sz, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Szelesseg='" + sz + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositNyomdaiVh(String vh, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Vagashossz='" + vh + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositNyomdaiF(String f, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Festekek='" + f + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositNyomdaiP(String p, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Palyak='" + p + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void modositNyomdaiDate(String date, String nyid) {
		Kapcs();
		String sql = "update Nyomdai set Date='" + date + "' where nyid='" + nyid + "'";
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public void deleteNyomdai(String nyid) {
		Kapcs();
		String sql = "delete from Nyomdai where nyID=" + nyid;
		try {
			s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
		LeKapcs();
	}

	public Kiolvasáshoz3 AllOlv() {
		Object[] nyomdaiak = { "Jel", "nyid", "Szerzõdésszám", "Vevõ", "Termék neve", "Minõség", "Gramsúly",
				"Szélesség (mm)", "Vágáshossz (mm)", "Festékek száma", "Pályák száma", "Gyártás kezdete",
				"Igénylés leadása", "tid", "Talphossz", "Magasság", "Rétegek száma", "Hosszragasztó", "Talpragasztó",
				"Mennyiség" };
		Kiolvasáshoz3 k = new Kiolvasáshoz3(nyomdaiak, 0);
		String szsz = "", nyid = "", szeles = "", talph = "", m = "", dobozdb = "", raklapdoboz = "", retegek = "",
				hosszr = "", talpr = "", date1 = "", tid = "", date2 = "", th = "", mag = "", reteg = "", menny = "",
				hr = "", tr = "";
		String sql = "Select * from Nyomdai ny left join Tasak t on ny.Szerzodesszam = t.Szerzodesszam and ny.Szelesseg = t.Szelesseg";
		Kapcs();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				nyid = rs.getString("nyID");
				szsz = rs.getString("Szerzodesszam");
				szeles = rs.getString("Vevo");
				talph = rs.getString("Termek");
				m = rs.getString("Minoseg");
				dobozdb = rs.getString("Gramsuly");
				raklapdoboz = rs.getString("Szelesseg");
				retegek = rs.getString("Vagashossz");
				hosszr = rs.getString("Festekek");
				talpr = rs.getString("Palyak");
				date1 = rs.getString("Date");
				tid = rs.getString("tID");
				date2 = rs.getString("Date2");
				th = rs.getString("Talphossz");
				mag = rs.getString("Magasság");
				reteg = rs.getString("Retegek");
				hr = rs.getString("Hosszragaszto");
				tr = rs.getString("Talpragaszto");
				menny = rs.getString("Mennyiseg");
				k.addRow(new Object[] { false, nyid, szsz, szeles, talph, m, dobozdb, raklapdoboz, retegek, hosszr,
						talpr, date1, date2, tid, th, mag, reteg, hr, tr, menny });
			}
			rs.close();
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
		LeKapcs();
		return k;
	}
	
	public void mentesAll() {

		String szsz = "", nyid = "", szeles = "", talph = "", m = "", dobozdb = "", raklapdoboz = "", retegek = "",
				hosszr = "", talpr = "", date1 = "", tid = "", date2 = "", th = "", mag = "", reteg = "", menny = "",
				hr = "", tr = "";
		String sql = "Select * from Nyomdai ny left join Tasak t on ny.Szerzodesszam = t.Szerzodesszam and ny.Szelesseg = t.Szelesseg";
		Kapcs();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				nyid = rs.getString("nyID");
				szsz = rs.getString("Szerzodesszam");
				szeles = rs.getString("Vevo");
				talph = rs.getString("Termek");
				m = rs.getString("Minoseg");
				dobozdb = rs.getString("Gramsuly");
				raklapdoboz = rs.getString("Szelesseg");
				retegek = rs.getString("Vagashossz");
				hosszr = rs.getString("Festekek");
				talpr = rs.getString("Palyak");
				date1 = rs.getString("Date");
				tid = rs.getString("tID");
				date2 = rs.getString("Date2");
				th = rs.getString("Talphossz");
				mag = rs.getString("Magasság");
				reteg = rs.getString("Retegek");
				hr = rs.getString("Hosszragaszto");
				tr = rs.getString("Talpragaszto");
				menny = rs.getString("Mennyiseg");
				x.format(nyid + ";" + szsz + ";" + szeles + ";" + talph + ";" + m + ";" + dobozdb + ";" + raklapdoboz
						+ ";" + retegek + ";" + hosszr + ";" + talpr + ";" + date1 + ";" + tid + ";" + date2 + ";" + th + ";" + mag + ";" + reteg + ";" + hr + ";" + tr + ";" + menny + "\n");
			}
			rs.close();
			msg("Sikeres mentés txt-be!");
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}

		LeKapcs();

	}

	public void getTables() {
		Kapcs();
		try {
			int i = 1;
			DatabaseMetaData mD = conn.getMetaData();
			String[] types = { "TABLE" };
			ResultSet tables = mD.getTables(null, null, "%", types);
			while (tables.next()) {
				msg(i + ". tábla neve: " + tables.getString("TABLE_NAME"));
				i++;
			}
		} catch (Exception e) {
			error(e.getMessage());
		}
		LeKapcs();
	}

	public Szuro1hez Szuro1(String date1, String date2) {

		Object sz[] = { "Jel", "tID", "Szerzõdésszám", "Mennyiség", "Igénylés dátuma" };
		Szuro1hez szr = new Szuro1hez(sz, 0);
		String tid = "", szsz = "", m = "", igd = "";

		String sqlp = "select * from Tasak where date2 between '" + date1 + "' and '" + date2 + "'";

		Kapcs();

		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while (rs.next()) {
				tid = rs.getString("tID");
				szsz = rs.getString("Szerzodesszam");
				m = rs.getString("Mennyiseg");
				igd = rs.getString("Date2");
				szr.addRow(new Object[] { false, tid, szsz, m, igd });
			}
			rs.close();
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}

		return szr;

	}

	public void mentesSzuro1(String date1, String date2) {

		String tid = "", szsz = "", m = "", igd = "";
		String sqlp = "select * from Tasak where date2 between '" + date1 + "' and '" + date2 + "'";
		Kapcs();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while (rs.next()) {
				tid = rs.getString("tID");
				szsz = rs.getString("Szerzodesszam");
				m = rs.getString("Mennyiseg");
				igd = rs.getString("Date2");
				x.format(tid + ";" + szsz + ";" + m + ";" + igd + "\n");
			}
			rs.close();
			msg("Sikeres mentés txt-be!");
		} catch (SQLException e) {
			error("Hiba! " + e.getMessage());
		}
	}

	public Szuro2höz Szuro2(String vevo) {

		Object sz[] = { "Jel", "tID", "Vevõ", "Szerzõdésszám", "Mennyiség", "Igénylés dátuma" };
		Szuro2höz szr = new Szuro2höz(sz, 0);
		String tid = "", szsz = "", m = "", igd = "";

		String sqlp = "select tID, t.Szerzodesszam, Mennyiseg, Date2 from Tasak t inner join Nyomdai ny on t.Szerzodesszam = ny.Szerzodesszam where ny.Vevo = ?";

		Kapcs();

		try {
			ps = conn.prepareStatement(sqlp);
			ps.setString(1, vevo);
			rs = ps.executeQuery();
			while (rs.next()) {
				tid = rs.getString("tID");
				szsz = rs.getString("Szerzodesszam");
				m = rs.getString("Mennyiseg");
				igd = rs.getString("Date2");
				szr.addRow(new Object[] { false, tid, vevo, szsz, m, igd });
			}
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}

		return szr;

	}

	public void mentesSzuro2(String vevo) {

		String tid = "", szsz = "", m = "", igd = "";
		String sqlp = "select tID, t.Szerzodesszam, Mennyiseg, Date2 from Tasak t inner join Nyomdai ny on t.Szerzodesszam = ny.Szerzodesszam where ny.Vevo = ?";
		Kapcs();
		try {
			ps = conn.prepareStatement(sqlp);
			ps.setString(1, vevo);
			rs = ps.executeQuery();
			while (rs.next()) {
				tid = rs.getString("tID");
				szsz = rs.getString("Szerzodesszam");
				m = rs.getString("Mennyiseg");
				igd = rs.getString("Date2");
				x.format(tid + ";" + vevo + ";" + szsz + ";" + m + ";" + igd + "\n");
			}
			rs.close();
			msg("Sikeres mentés txt-be!");
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}
	}

	public Szuro3hoz Szuro3(String min) {

		Object sz[] = { "Jel", "tID", "Termék", "Minõség", "Szerzõdésszám", "Mennyiség", "Igénylés dátuma",
				"Gyártás kezdete" };
		Szuro3hoz szr = new Szuro3hoz(sz, 0);
		String tid = "", szsz = "", m = "", igd = "", t = "", gyk = "";

		String view = "CREATE TEMP VIEW v_all AS select t.tID as tid, t.Szerzodesszam as szerzodesszam1, t.Mennyiseg as menny, t.Date2 as iD, ny.Termek as termek, ny.Date as gyD, ny.Minoseg as min, ny.Szerzodesszam as szerzodesszam2 from Tasak t left join Nyomdai as ny using (szerzodesszam) union select t.tID as tid, t.Szerzodesszam as szerzodesszam, t.Mennyiseg as menny, t.Date2 as iD, ny.Termek as termek, ny.Date as gyD, ny.Minoseg as min, ny.Szerzodesszam as szerzodesszam2 from Nyomdai as ny left join Tasak as t using(szerzodesszam) ";

		String sqlp = "select tid, menny, iD, termek, gyD, min,  CASE WHEN szerzodesszam1 IS NULL THEN szerzodesszam2 WHEN szerzodesszam2 IS NULL THEN szerzodesszam1 WHEN szerzodesszam1=szerzodesszam2 THEN szerzodesszam1 END szerzodesszam from  v_all where min = ?";

		Kapcs();

		try {
			s = conn.createStatement();
			s.executeUpdate(view);
			ps = conn.prepareStatement(sqlp);
			ps.setString(1, min);
			rs = ps.executeQuery();
			while (rs.next()) {
				tid = rs.getString("tID");
				t = rs.getString("Termek");
				szsz = rs.getString("Szerzodesszam");
				m = rs.getString("menny");
				igd = rs.getString("iD");
				gyk = rs.getString("gyD");
				szr.addRow(new Object[] { false, tid, t, min, szsz, m, igd, gyk });
			}
			rs.close();
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}

		return szr;

	}

	public void mentesSzuro3(String min) {

		String tid = "", szsz = "", m = "", igd = "", t = "", gyk = "";

		String view = "CREATE TEMP VIEW v_all AS select t.tID as tid, t.Szerzodesszam as szerzodesszam1, t.Mennyiseg as menny, t.Date2 as iD, ny.Termek as termek, ny.Date as gyD, ny.Minoseg as min, ny.Szerzodesszam as szerzodesszam2 from Tasak t left join Nyomdai as ny using (szerzodesszam) union select t.tID as tid, t.Szerzodesszam as szerzodesszam, t.Mennyiseg as menny, t.Date2 as iD, ny.Termek as termek, ny.Date as gyD, ny.Minoseg as min, ny.Szerzodesszam as szerzodesszam2 from Nyomdai as ny left join Tasak as t using(szerzodesszam) ";
		String sqlp = "select tid, menny, iD, termek, gyD, min,  CASE WHEN szerzodesszam1 IS NULL THEN szerzodesszam2 WHEN szerzodesszam2 IS NULL THEN szerzodesszam1 WHEN szerzodesszam1=szerzodesszam2 THEN szerzodesszam1 END szerzodesszam from  v_all where min = ?";

		Kapcs();

		try {
			s = conn.createStatement();
			s.executeUpdate(view);
			ps = conn.prepareStatement(sqlp);
			ps.setString(1, min);
			rs = ps.executeQuery();
			while (rs.next()) {
				tid = rs.getString("tID");
				t = rs.getString("Termek");
				szsz = rs.getString("Szerzodesszam");
				m = rs.getString("menny");
				igd = rs.getString("iD");
				gyk = rs.getString("gyD");
				x.format(tid + ";" + t + ";" + szsz + ";" + m + ";" + igd + ";" + gyk + "\n");
			}
			rs.close();
			msg("Sikeres mentés txt-be!");
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}

	}
	
	public Szuro4hez Szuro4(String festek) {

		Object sz[] = { "Jel", "nyID", "Vevõ", "Termék", "Festékek", "Szerzõdésszám", "Gyártás kezdete" };
		Szuro4hez szr = new Szuro4hez(sz, 0);
		String tid = "", v="", t="", szsz = "", gyd = "";

		String sqlp = "select nyid, vevo, termek, festekek, szerzodesszam, date from nyomdai where festekek=?";

		Kapcs();

		try {
			ps = conn.prepareStatement(sqlp);
			ps.setString(1, festek);
			rs = ps.executeQuery();
			while (rs.next()) {
				tid = rs.getString("nyID");
				v = rs.getString("Vevo");
				t = rs.getString("Termek");
				szsz = rs.getString("Szerzodesszam");
				gyd = rs.getString("Date");
				szr.addRow(new Object[] { false, tid, v, t, festek, szsz, gyd });
			}
			rs.close();
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}

		return szr;

	}
	
	public void mentesSzuro4(String festek) {

		String tid = "", v="", t="", szsz = "", gyd = "";

		String sqlp = "select nyid, vevo, termek, festekek, szerzodesszam, date from nyomdai where festekek=?";

		Kapcs();

		try {
			ps = conn.prepareStatement(sqlp);
			ps.setString(1, festek);
			rs = ps.executeQuery();
			while (rs.next()) {
				tid = rs.getString("nyID");
				v = rs.getString("Vevo");
				t = rs.getString("Termek");
				szsz = rs.getString("Szerzodesszam");
				gyd = rs.getString("Date");
				x.format(tid + ";" + v + ";" + t + ";" + festek + ";" + szsz + ";" + gyd + "\n");
			}
			rs.close();
			msg("Sikeres mentés txt-be!");
		} catch (SQLException e) {
			error("Hiba!" + e.getMessage());
		}


	}


}
