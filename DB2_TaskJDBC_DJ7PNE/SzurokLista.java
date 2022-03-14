package program;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SzurokLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String[] legordulo = { "stark fehér papír", "fehér nátron mondi", "barna papír" };
	private JComboBox<String> minosegek = new JComboBox<>(legordulo);
	private JTextField textField_4;
	Szuro1hez k;
	Szuro2höz kk;
	Szuro3hoz kkk;
	Szuro4hez kkkk;
	Metódusok dbm = new Metódusok();

	public SzurokLista() {

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u00E9s");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(182, 32, 13, 24);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(43, 35, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 35, 129, 20);
		contentPane.add(textField_1);

		JLabel lblKzttLeadottTasakrendelsek = new JLabel("között leadott tasakrendelések.");
		lblKzttLeadottTasakrendelsek.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKzttLeadottTasakrendelsek.setBounds(344, 32, 209, 24);
		contentPane.add(lblKzttLeadottTasakrendelsek);

		JButton btnNewButton = new JButton("Szûrés");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!ifDate(textField) || !ifDate(textField_1)) {
					error("nem jó formátumú valamelyik dátum!");
				} else {
					k = dbm.Szuro1(getText(textField), getText(textField_1));
					Szuro1 sz = new Szuro1(SzurokLista.this, k, getText(textField), getText(textField_1));
					dispose();
					sz.setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(568, 32, 89, 23);
		contentPane.add(btnNewButton);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(43, 95, 129, 20);
		contentPane.add(textField_2);

		JLabel lblVevltalLeadott = new JLabel("vevõ által leadott rendelések.");
		lblVevltalLeadott.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVevltalLeadott.setBounds(182, 91, 209, 24);
		contentPane.add(lblVevltalLeadott);

		minosegek.setBounds(43, 150, 129, 20);
		contentPane.add(minosegek);

		JLabel lblMinsgTasakok = new JLabel("minõségû tasakok.");
		lblMinsgTasakok.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinsgTasakok.setBounds(182, 146, 209, 24);
		contentPane.add(lblMinsgTasakok);

		JButton btnNewButton_1 = new JButton("Szûrés");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				kk = dbm.Szuro2(getText(textField_2));
				Szuro2 sz = new Szuro2(SzurokLista.this, kk, getText(textField_2));
				dispose();
				sz.setVisible(true);

			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(384, 91, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Szûrés");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				kkk = dbm.Szuro3((String) minosegek.getSelectedItem());
				Szuro3 sz = new Szuro3(SzurokLista.this, kkk, (String) minosegek.getSelectedItem());
				dispose();
				sz.setVisible(true);

			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(320, 147, 89, 23);
		contentPane.add(btnNewButton_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(43, 201, 129, 20);
		contentPane.add(textField_4);

		JLabel lblFestkszmNyomdaiak = new JLabel("festékszámú nyomdaiak.");
		lblFestkszmNyomdaiak.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFestkszmNyomdaiak.setBounds(182, 197, 209, 24);
		contentPane.add(lblFestkszmNyomdaiak);

		JButton btnNewButton_2_1 = new JButton("Szûrés");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!festekEll(textField_4)) {
					error("Nem megfelelõ adat");
				} else {
					kkkk = dbm.Szuro4(getText(textField_4));
					Szuro4 sz = new Szuro4(SzurokLista.this, kkkk, getText(textField_4));
					dispose();
					sz.setVisible(true);
				}

			}
		});
		btnNewButton_2_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2_1.setBounds(357, 200, 89, 23);
		contentPane.add(btnNewButton_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Bezárás");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login log = new Login();
				Belepett b = new Belepett(log);
				dispose();
				b.setVisible(true);

			}
		});
		btnNewButton_2_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2_1_1.setBounds(326, 266, 99, 34);
		contentPane.add(btnNewButton_2_1_1);

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

	public String getText(JTextField jtf) {
		return jtf.getText();
	}

	public boolean ifDate(JTextField f) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
		String s = getText(f);
		Date testDate = null;
		try {
			testDate = sdf.parse(s);
		} catch (ParseException e) {
			error(e.getMessage());
			return false;
		}
		if (sdf.format(testDate).equals(s))
			return true;
		else
			return false;
	}

	public boolean festekEll(JTextField f) {
		String s = getText(f);
		try {
			Integer.parseInt(s);
			int a = Integer.parseInt(s);
			if (a > 3 || a < 1) {
				return false;
			} else
				return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
