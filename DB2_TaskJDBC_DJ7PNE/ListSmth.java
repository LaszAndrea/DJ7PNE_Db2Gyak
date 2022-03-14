package program;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ListSmth extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Kiolvasáshoz k;
	Kiolvasáshoz2 kk;
	Kiolvasáshoz3 kkk;
	Metódusok dbm = new Metódusok();

	public ListSmth() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Melyiket szeretné listázni?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(116, 10, 217, 32);
		contentPane.add(lblNewLabel);
		
		JButton nyomdaiBttn = new JButton("Nyomdaiak");
		nyomdaiBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				kk = dbm.NyomdaiOlv();
				NyomdaiList t = new NyomdaiList(ListSmth.this, kk);
				t.setVisible(true);
				
			}
		});
		nyomdaiBttn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nyomdaiBttn.setBounds(77, 81, 119, 43);
		nyomdaiBttn.setBackground(Color.LIGHT_GRAY);
		contentPane.add(nyomdaiBttn);
		
		JButton tasakBttn = new JButton("Tasakok");
		tasakBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				k = dbm.TasakOlv();
				TasalList t = new TasalList(ListSmth.this, k);
				t.setVisible(true);
				
			}
		});
		tasakBttn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tasakBttn.setBounds(239, 81, 119, 43);
		tasakBttn.setBackground(Color.LIGHT_GRAY);
		contentPane.add(tasakBttn);
		
		JButton allBttn = new JButton("Együtt");
		allBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kkk = dbm.AllOlv();
				AllList l = new AllList(ListSmth.this, kkk);
				dispose();
				l.setVisible(true);
				
			}
		});
		allBttn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		allBttn.setBounds(153, 151, 119, 43);
		allBttn.setBackground(Color.LIGHT_GRAY);
		contentPane.add(allBttn);
		
		JLabel rtrn = new JLabel("Vissza");
		rtrn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rtrn.setBounds(193, 227, 54, 26);
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
				Login log = new Login();
				Belepett b = new Belepett(log);
				dispose();
				b.setVisible(true);
			}
		});
		
	}

}
