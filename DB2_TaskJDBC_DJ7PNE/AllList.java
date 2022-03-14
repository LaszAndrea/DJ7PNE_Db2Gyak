package program;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Kiolvasáshoz3 k;
	Metódusok dbm = new Metódusok();
	private JButton btnMents;
	private JButton btnVissza;

	public AllList(JFrame f, Kiolvasáshoz3 kk) {
		
		k = kk;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1720, 362);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 1684, 251);
		contentPane.add(scrollPane);

		table = new JTable(k);

		scrollPane.setViewportView(table);
		
		btnMents = new JButton("Mentés");
		btnMents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbm.openFile("AllList.txt");
				dbm.mentesAll();
				dbm.closeFile();
				
			}
		});
		btnMents.setBackground(Color.LIGHT_GRAY);
		btnMents.setBounds(742, 278, 89, 34);
		contentPane.add(btnMents);
		
		btnVissza = new JButton("Vissza");
		btnVissza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListSmth n = new ListSmth();
				dispose();
				n.setVisible(true);
				
			}
		});
		btnVissza.setBackground(Color.LIGHT_GRAY);
		btnVissza.setBounds(859, 278, 89, 34);
		contentPane.add(btnVissza);

		TableColumn tc = null;
		for (int i = 0; i < 19; i++) {
			tc = table.getColumnModel().getColumn(i);
			if (i == 1 || i==13) {
				tc.setWidth(10);
			} else if (i == 0)
				tc.setWidth(10);
			else if (i == 4 || i == 2 || i == 3 || i== 5)
				tc.setWidth(180);
			else if (i == 6 || i == 7)
				tc.setWidth(135);

		}
		
	}
	
	public String RTS(int row, int cm) {
		return k.getValueAt(row, cm).toString();
	}
	
	public void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 0);
	}

}
