package program;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class NewTasak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tid;
	private JTextField szsz;
	private JTextField szeles;
	private JTextField thossz;
	private JTextField m;
	private JTextField reteg;
	private JTextField talpr;
	private JTextField hosszr;
	private JTextField mennyiseg;
	Metódusok dbm = new Metódusok();
	private JTextField date;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTasak frame = new NewTasak();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewTasak() {

		setTitle("Tasak felvétele");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 335, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("tID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 37, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblSzerzdsszm = new JLabel("Szerzõdésszám");
		lblSzerzdsszm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSzerzdsszm.setBounds(39, 77, 101, 13);
		contentPane.add(lblSzerzdsszm);

		JLabel lblSzlessg = new JLabel("Szélesség");
		lblSzlessg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSzlessg.setBounds(39, 116, 101, 17);
		contentPane.add(lblSzlessg);

		JLabel lblTalphossz = new JLabel("Talphossz");
		lblTalphossz.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTalphossz.setBounds(39, 152, 101, 13);
		contentPane.add(lblTalphossz);

		JLabel lblRtegek = new JLabel("Magasság");
		lblRtegek.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRtegek.setBounds(39, 187, 101, 17);
		contentPane.add(lblRtegek);

		JLabel lblRtegek_2 = new JLabel("Rétegek");
		lblRtegek_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRtegek_2.setBounds(39, 221, 101, 17);
		contentPane.add(lblRtegek_2);

		JLabel lblRtegek_2_1 = new JLabel("Talpragasztó");
		lblRtegek_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRtegek_2_1.setBounds(39, 259, 101, 17);
		contentPane.add(lblRtegek_2_1);

		JLabel lblRtegek_2_1_1 = new JLabel("Hosszragasztó");
		lblRtegek_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRtegek_2_1_1.setBounds(39, 297, 101, 17);
		contentPane.add(lblRtegek_2_1_1);

		JLabel lblRtegek_2_1_1_1 = new JLabel("Mennyiség");
		lblRtegek_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRtegek_2_1_1_1.setBounds(39, 332, 101, 17);
		contentPane.add(lblRtegek_2_1_1_1);
		
		JLabel lblRtegek_2_1_1_1_1 = new JLabel("Igénylés dátuma");
		lblRtegek_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRtegek_2_1_1_1_1.setBounds(39, 370, 101, 17);
		contentPane.add(lblRtegek_2_1_1_1_1);

		tid = new JTextField();
		tid.setBounds(94, 35, 96, 19);
		contentPane.add(tid);
		tid.setColumns(10);

		szsz = new JTextField();
		szsz.setColumns(10);
		szsz.setBounds(150, 75, 96, 19);
		contentPane.add(szsz);

		szeles = new JTextField();
		szeles.setColumns(10);
		szeles.setBounds(115, 114, 96, 19);
		contentPane.add(szeles);

		thossz = new JTextField();
		thossz.setColumns(10);
		thossz.setBounds(115, 150, 96, 19);
		contentPane.add(thossz);

		m = new JTextField();
		m.setColumns(10);
		m.setBounds(115, 185, 96, 19);
		contentPane.add(m);

		reteg = new JTextField();
		reteg.setColumns(10);
		reteg.setBounds(115, 221, 96, 19);
		contentPane.add(reteg);

		talpr = new JTextField();
		talpr.setColumns(10);
		talpr.setBounds(125, 257, 96, 19);
		contentPane.add(talpr);

		hosszr = new JTextField();
		hosszr.setColumns(10);
		hosszr.setBounds(135, 295, 96, 19);
		contentPane.add(hosszr);

		mennyiseg = new JTextField();
		mennyiseg.setColumns(10);
		mennyiseg.setBounds(125, 330, 96, 19);
		contentPane.add(mennyiseg);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(150, 368, 96, 19);
		contentPane.add(date);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tid.setText(null);
				szsz.setText(null);
				szeles.setText(null);
				thossz.setText(null);
				m.setText(null);
				reteg.setText(null);
				hosszr.setText(null);
				talpr.setText(null);
				mennyiseg.setText(null);
				date.setText(null);

			}
		});

		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.setBounds(28, 436, 118, 37);
		contentPane.add(btnReset);
		
		JButton btnAdd = new JButton("Felvétel");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!filled(tid))
					error("A tID mezõ üres");
				else if(!ifInt(tid))
					error("A tID mezõ nem megfelelõ");
				else if (!filled(szsz))
					error("A szerzõdésszám mezõ üres");
				else if (!SzSzEll(szsz))
					error("A szerzõdésszám mezõ nem helyes");
				else if (!filled(tid))
					error("A tid mezõ nem helyes");
				else if (!filled(szeles))
					error("A szélesség mezõ üres");
				else if (!ifInt(szeles))
					error("A szélesség mezõ nem helyes");
				else if (!filled(thossz))
					error("A talphossz mezõ üres");
				else if (!ifInt(thossz))
					error("A talphossz mezõ nem helyes");
				else if (!filled(m))
					error("A magasság mezõ üres");
				else if (!ifInt(m))
					error("A magasság mezõ nem helyes");
				else if (!filled(reteg))
					error("A rétegek száma mezõ üres");
				else if (!retegEll(reteg))
					error("A rétegek száma mezõ nem helyes");
				else if (!filled(hosszr))
					error("A hosszragasztó mezõ üres");
				else if (!ifInt(hosszr))
					error("A hosszragasztó mezõ nem helyes");
				else if (!filled(talpr))
					error("A talpragasztó mezõ üres");
				else if (!ifInt(talpr))
					error("A talpragasztó mezõ nem helyes");
				else if (!filled(mennyiseg))
					error("A mennyiség mezõ üres");
				else if (!ifInt(mennyiseg))
					error("A mennyiség mezõ nem helyes");
				else if(!ifDate(date)) {
					error("A dátum mezõ nem helyes");
				}
				else {
					dbm.TasakFelv(getText(tid) ,getText(szsz), getText(szeles), getText(thossz), getText(m), getText(reteg), getText(hosszr), getText(talpr), getText(mennyiseg), getText(date));
					tid.setText(null);
					szsz.setText(null);
					szeles.setText(null);
					thossz.setText(null);
					m.setText(null);
					reteg.setText(null);
					hosszr.setText(null);
					talpr.setText(null);
					mennyiseg.setText(null);
					date.setText(null);
				}

			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setBounds(177, 436, 118, 37);
		contentPane.add(btnAdd);
		
		JLabel rtrn = new JLabel("Vissza");
		rtrn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rtrn.setBounds(135, 498, 53, 22);
		contentPane.add(rtrn);
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
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

}
