package program;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Szuro4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Szuro4hez k;
	private JButton btnNewButton;
	private JButton btnMents;
	Metódusok dbm = new Metódusok();

	public Szuro4(SzurokLista sz, Szuro4hez kk, String festek) {

		k = kk;

		setTitle("Szûrés listája");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 684, 300);
		contentPane.add(scrollPane);

		table = new JTable(k);

		scrollPane.setViewportView(table);

		btnNewButton = new JButton("Bezárás");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SzurokLista l = new SzurokLista();
				dispose();
				l.setVisible(true);

			}
		});
		btnNewButton.setBounds(374, 344, 101, 30);
		contentPane.add(btnNewButton);

		btnMents = new JButton("Mentés");
		btnMents.setBackground(Color.LIGHT_GRAY);
		btnMents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dbm.openFile("Szuro4.txt");
				dbm.mentesSzuro4(festek);
				dbm.closeFile();

			}
		});
		btnMents.setBounds(240, 344, 101, 30);
		contentPane.add(btnMents);

	}

}
