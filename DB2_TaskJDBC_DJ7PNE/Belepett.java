package program;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Belepett extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Metódusok dbm = new Metódusok();
	Kiolvasáshoz k;
	Kiolvasáshoz2 kk;
	Kiolvasáshoz3 kkk;

	public Belepett(Login log) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menü");
		setBounds(100, 100, 900, 472);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton regBttn = new JButton("Driver Regisztr\u00E1l\u00E1s");
		regBttn.setBackground(Color.LIGHT_GRAY);
		regBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbm.DrReg2();
				
			}
		});
		regBttn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		regBttn.setBounds(72, 50, 189, 68);
		contentPane.add(regBttn);
		
		JButton btnKalkultor = new JButton("Kalkul\u00E1tor");
		btnKalkultor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Kalkulator k = new Kalkulator(Belepett.this);
				k.toString();
				dispose();
				
			}
		});
		btnKalkultor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKalkultor.setBackground(Color.LIGHT_GRAY);
		btnKalkultor.setBounds(326, 50, 189, 68);
		contentPane.add(btnKalkultor);
		
		JButton btnjAdattagFelvtele = new JButton("\u00DAj adattag");
		btnjAdattagFelvtele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbm.TablaLetrehozas();
				NewInsert ni = new NewInsert();
				ni.setVisible(true);
				dispose();
				
			}
		});
		btnjAdattagFelvtele.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnjAdattagFelvtele.setBackground(Color.LIGHT_GRAY);
		btnjAdattagFelvtele.setBounds(585, 50, 189, 68);
		contentPane.add(btnjAdattagFelvtele);
		
		JLabel cls = new JLabel("Kilépés");
		cls.setFont(new Font("Times New Roman", Font.BOLD, 30));
		cls.setBounds(370, 376, 106, 49);
		contentPane.add(cls);
		
		JButton btnTasakokListzsa = new JButton("List\u00E1z\u00E1s");
		btnTasakokListzsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListSmth l = new ListSmth();
				dispose();
				l.setVisible(true);
				
			}
		});
		btnTasakokListzsa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTasakokListzsa.setBackground(Color.LIGHT_GRAY);
		btnTasakokListzsa.setBounds(72, 171, 189, 68);
		contentPane.add(btnTasakokListzsa);
		
		JButton btnSzrs = new JButton("Sz\u0171r\u00E9s");
		btnSzrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SzurokLista l = new SzurokLista();
				dispose();
				l.setVisible(true);
				
			}
		});
		btnSzrs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSzrs.setBackground(Color.LIGHT_GRAY);
		btnSzrs.setBounds(326, 171, 189, 68);
		contentPane.add(btnSzrs);
		
		JButton btnTblk = new JButton("T\u00E1bl\u00E1k");
		btnTblk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbm.getTables();
				
			}
		});
		btnTblk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTblk.setBackground(Color.LIGHT_GRAY);
		btnTblk.setBounds(585, 171, 189, 68);
		contentPane.add(btnTblk);
		cls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cls.setForeground(new Color(0,0,255));
				
			}
			public void mouseExited(MouseEvent e) {
				cls.setForeground(new Color(0,0,0));
			}
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Biztos, hogy ki akar lépni?", "Close", JOptionPane.YES_NO_OPTION)==0) {
					System.exit(0);
				}
			}
		});
		
	}

}
