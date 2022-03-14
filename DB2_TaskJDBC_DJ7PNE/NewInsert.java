package program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NewInsert extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public NewInsert() {

		setTitle("Új adat");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(211, 211, 211));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton close = new JButton("Bezárás");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				Belepett b = new Belepett(log);
				b.setVisible(true);
				dispose();
			}
		});
		close.setBackground(new Color(169, 169, 169));
		close.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		close.setBounds(165, 202, 99, 36);
		contentPanel.add(close);

		JButton nyomdai = new JButton("Nyomdai");
		nyomdai.setBackground(new Color(169, 169, 169));
		nyomdai.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nyomdai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NewNyomdai ny = new NewNyomdai();
				ny.setVisible(true);
				dispose();
				
			}
		});
		nyomdai.setBounds(45, 127, 115, 47);
		contentPanel.add(nyomdai);

		JButton tasak = new JButton("Tasak");
		tasak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NewTasak nt = new NewTasak();
				nt.setVisible(true);
				dispose();
				
			}
		});
		tasak.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tasak.setBackground(new Color(169, 169, 169));
		tasak.setBounds(271, 127, 115, 47);
		contentPanel.add(tasak);

		JLabel lbl = new JLabel("Kérem válasszon!");
		lbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBackground(new Color(192, 192, 192));
		lbl.setBounds(151, 10, 137, 47);
		contentPanel.add(lbl);

		JLabel lbl2 = new JLabel("Milyen típusú adatot vinne fel?");
		lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbl2.setBackground(new Color(192, 192, 192));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(82, 45, 288, 50);
		contentPanel.add(lbl2);

	}

}
