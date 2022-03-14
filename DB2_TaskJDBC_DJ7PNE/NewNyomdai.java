package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class NewNyomdai extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nyid;
	private JTextField szsz;
	private JTextField vevo;
	private JTextField termek;
	private JTextField gramsuly;
	private JTextField szeles;
	private JTextField vhossz;
	private JTextField festekek;
	private JTextField palyak;
	private Metódusok dbm = new Metódusok();
	private JTextField date;
	private String[] legordulo = { "stark fehér papír", "fehér nátron mondi", "barna papír" };
	private JComboBox<String> minosegek = new JComboBox<>(legordulo);

	public NewNyomdai() {
		
		setTitle("Nyomdai felvétele");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 335, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nyID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 37, 45, 17);
		contentPane.add(lblNewLabel);
		
		JLabel rtrn = new JLabel("Vissza");
		rtrn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rtrn.setBounds(135, 498, 53, 22);
		contentPane.add(rtrn);
		
		JLabel lblSzerzdsszm = new JLabel("Szerzõdésszám");
		lblSzerzdsszm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSzerzdsszm.setBounds(39, 69, 88, 17);
		contentPane.add(lblSzerzdsszm);
		
		JLabel lblVev = new JLabel("Vevõ");
		lblVev.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVev.setBounds(39, 104, 45, 17);
		contentPane.add(lblVev);
		
		JLabel lblTermk = new JLabel("Termék");
		lblTermk.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTermk.setBounds(39, 136, 69, 17);
		contentPane.add(lblTermk);
		
		JLabel lblMinsg = new JLabel("Minõség");
		lblMinsg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMinsg.setBounds(39, 169, 69, 17);
		contentPane.add(lblMinsg);
		
		JLabel lblGramsly = new JLabel("Gramsúly");
		lblGramsly.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGramsly.setBounds(39, 200, 69, 17);
		contentPane.add(lblGramsly);
		
		JLabel lblMinsg_1_1 = new JLabel("Szélesség");
		lblMinsg_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMinsg_1_1.setBounds(39, 234, 69, 17);
		contentPane.add(lblMinsg_1_1);
		
		JLabel lblMinsg_1_2 = new JLabel("Vágáshossz");
		lblMinsg_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMinsg_1_2.setBounds(39, 269, 69, 17);
		contentPane.add(lblMinsg_1_2);
		
		JLabel lblMinsg_1 = new JLabel("Festékek");
		lblMinsg_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMinsg_1.setBounds(39, 309, 69, 17);
		contentPane.add(lblMinsg_1);
		
		JLabel lblMinsg_1_3 = new JLabel("Pályák");
		lblMinsg_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMinsg_1_3.setBounds(39, 343, 69, 17);
		contentPane.add(lblMinsg_1_3);

		minosegek.setBounds(98, 169, 140, 21);
		contentPane.add(minosegek);
		
		nyid = new JTextField();
		nyid.setBounds(92, 37, 96, 19);
		contentPane.add(nyid);
		nyid.setColumns(10);
		
		szsz = new JTextField();
		szsz.setColumns(10);
		szsz.setBounds(135, 69, 96, 19);
		contentPane.add(szsz);
		
		vevo = new JTextField();
		vevo.setColumns(10);
		vevo.setBounds(92, 104, 96, 19);
		contentPane.add(vevo);
		
		termek = new JTextField();
		termek.setColumns(10);
		termek.setBounds(98, 136, 96, 19);
		contentPane.add(termek);
		
		gramsuly = new JTextField();
		gramsuly.setColumns(10);
		gramsuly.setBounds(108, 200, 96, 19);
		contentPane.add(gramsuly);
		
		szeles = new JTextField();
		szeles.setColumns(10);
		szeles.setBounds(98, 234, 96, 19);
		contentPane.add(szeles);
		
		vhossz = new JTextField();
		vhossz.setColumns(10);
		vhossz.setBounds(118, 269, 96, 19);
		contentPane.add(vhossz);
		
		festekek = new JTextField();
		festekek.setColumns(10);
		festekek.setBounds(98, 309, 96, 19);
		contentPane.add(festekek);
		
		palyak = new JTextField();
		palyak.setColumns(10);
		palyak.setBounds(92, 343, 96, 19);
		contentPane.add(palyak);
		
		JLabel lblMinsg_1_3_1 = new JLabel("Gyártás kezdete");
		lblMinsg_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMinsg_1_3_1.setBounds(39, 379, 96, 17);
		contentPane.add(lblMinsg_1_3_1);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(145, 379, 96, 19);
		contentPane.add(date);
		
		rtrn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rtrn.setForeground(new Color(0,0,255));
				
			}
			public void mouseExited(MouseEvent e) {
				rtrn.setForeground(new Color(0,0,0));
			}
			public void mouseClicked(MouseEvent arg0) {
				NewInsert i = new NewInsert();
				dispose();
				i.setVisible(true);
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nyid.setText(null);
				szsz.setText(null);
				vevo.setText(null);
				termek.setText(null);
				szeles.setText(null);
				gramsuly.setText(null);
				vhossz.setText(null);
				festekek.setText(null);
				palyak.setText(null);
				date.setText(null);

			}
		});

		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.setBounds(28, 432, 118, 37);
		contentPane.add(btnReset);
		
		JButton btnAdd = new JButton("Felvétel");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!filled(nyid))
					error("A nyID mezõ üres");
				else if(!ifInt(nyid))
					error("A nyID mezõ nem megfelelõ");
				else if (!filled(szsz))
					error("A szerzõdésszám mezõ üres");
				else if (!SzSzEll(szsz))
					error("A szerzõdésszám mezõ nem helyes");
				else if (!filled(vevo))
					error("A vevõ mezõ üres");
				else if (!filled(termek))
					error("A termék mezõ üres");
				else if (!filled(gramsuly))
					error("A gramsúly mezõ üres");
				else if (!ifInt(gramsuly))
					error("A doboz/db mezõ nem helyes");
				else if (!filled(szeles))
					error("A szélesség mezõ üres");
				else if (!ifInt(szeles))
					error("A szélesség mezõ nem helyes");
				else if (!filled(vhossz))
					error("A vágáshossz mezõ üres");
				else if (!ifInt(vhossz))
					error("A vágáshossz mezõ nem helyes");
				else if (!filled(festekek))
					error("A festékek száma mezõ üres");
				else if (!festekEll(festekek))
					error("A festékek száma mezõ nem helyes");
				else if (!filled(palyak))
					error("A pályák száma mezõ üres");
				else if (!ifInt(palyak))
					error("A pályák száma mezõ nem helyes");
				else if(!ifDate(date)) 
					error("A gyártás kezdete mezõ nem helyes");
				else {
					
					dbm.NyomdaiFelv(getText(nyid), getText(szsz), getText(vevo), getText(termek), (String)minosegek.getSelectedItem(),
							getText(gramsuly), getText(szeles), getText(vhossz), getText(festekek),
							getText(palyak), getText(date));
					nyid.setText(null);
					szsz.setText(null);
					vevo.setText(null);
					termek.setText(null);
					szeles.setText(null);
					gramsuly.setText(null);
					vhossz.setText(null);
					festekek.setText(null);
					palyak.setText(null);
					date.setText(null);
					
				}

			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setBounds(177, 432, 118, 37);
		contentPane.add(btnAdd);
	}
	
	public String getText(JTextField jtf) {
		return jtf.getText();
	}

	public void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 2);
	}

	public void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Figyelem!", 0);
	}

	public boolean filled(JTextField f) {
		String s = getText(f);
		if (s.length() <= 0) {
			return false;
		} else
			return true;
	}

	public boolean ifInt(JTextField f) {
		String s = getText(f);
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean SzSzEll(JTextField f) {
		String s = getText(f);
		try {
			Integer.parseInt(s);
			if (s.length() < 8) {
				return false;
			} else
				return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean retegEll(JTextField f) {
		String s = getText(f);
		try {
			Integer.parseInt(s);
			if (Integer.parseInt(s) > 2 || Integer.parseInt(s) < 1) {
				return false;
			} else
				return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public boolean ifDate(JTextField f) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
		String s = getText(f);
		Date testDate = null;
		try {
			testDate = sdf.parse(s);
		} catch (ParseException e){
			error(e.getMessage());
			return false;
		}
		if(sdf.format(testDate).equals(s)) 
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
