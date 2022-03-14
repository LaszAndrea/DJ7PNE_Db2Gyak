package program;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TasalList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Metódusok dbm = new Metódusok();
	Kiolvasáshoz k;
	private JButton modifyBttn;
	private JButton btnTrls;
	private JButton btnVissza;

	public TasalList(JFrame f, Kiolvasáshoz kk) {

		k = kk;

		setTitle("Tasakok listája");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 10, 1200, 300);
		contentPane.add(scrollPane);

		table = new JTable(k);
		table.setBounds(40, 400, 1200, 381);

		scrollPane.setViewportView(table);

		modifyBttn = new JButton("Módosítás");
		modifyBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int db = 0;
				int sor = 0;
				for (int i = 0; i < k.getRowCount(); i++) {
					if ((Boolean) k.getValueAt(i, 0) == true) {
						db++;
						sor = i;
					}
				}
				if (db == 0)
					error("Nem lett kjelölve semmi");
				else if (db > 1)
					error("Egynél több rekordot nem lehet kijelölni");
				else if (db == 1) {
					dispose();
					ModositasTasak t = new ModositasTasak(RTS(sor, 1), RTS(sor, 2), RTS(sor, 3), RTS(sor, 4), RTS(sor, 5),
							RTS(sor, 6), RTS(sor, 7), RTS(sor, 8), RTS(sor, 9),  RTS(sor, 10));
					t.setVisible(true);
				}
			}
		});
		modifyBttn.setBackground(Color.LIGHT_GRAY);
		modifyBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		modifyBttn.setBounds(38, 382, 107, 33);
		contentPane.add(modifyBttn);

		btnTrls = new JButton("Törlés");
		btnTrls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int db = 0;
				for (int i = 0; i < k.getRowCount(); i++) {
					if ((Boolean) k.getValueAt(i, 0) == true) {
						db++;
						dbm.deleteTasak(RTS(i, 1));
						k.removeRow(i);
						i--;
						msg("A tasak törölve lett!");
					}
				}
				if (db == 0)
					error("Nem lett kjelölve semmi");

			}
		});
		btnTrls.setBackground(Color.LIGHT_GRAY);
		btnTrls.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTrls.setBounds(182, 382, 107, 33);
		contentPane.add(btnTrls);

		btnVissza = new JButton("Vissza");
		btnVissza.setBackground(Color.LIGHT_GRAY);
		btnVissza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListSmth n = new ListSmth();
				dispose();
				n.setVisible(true);

			}
		});
		btnVissza.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnVissza.setBounds(1111, 382, 107, 33);
		contentPane.add(btnVissza);
		
		JButton btnMents = new JButton("Mentés");
		btnMents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbm.openFile("Tasak.txt");
				dbm.mentesTasak();
				dbm.closeFile();
			}
		});
		btnMents.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnMents.setBackground(Color.LIGHT_GRAY);
		btnMents.setBounds(329, 382, 107, 33);
		contentPane.add(btnMents);

		TableColumn tc = null;
		for (int i = 0; i < 10; i++) {
			tc = table.getColumnModel().getColumn(i);
			if (i == 2) {
				tc.setWidth(40);
			} else if (i == 0)
				tc.setWidth(170);
			else if (i == 5 || i == 3 || i == 4)
				tc.setWidth(180);
			else if (i == 6 || i == 7 || i == 8)
				tc.setWidth(155);
			else {
				tc.setWidth(185);
			}
		}

	}

	public String RTS(int row, int cm) {
		return k.getValueAt(row, cm).toString();
	}
	
	public void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 2);
	}

	public void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 0);
	}
}
