package program;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pwd;
	Metódusok m = new Metódusok();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 415);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		m.TablaLetrehozas();
		
		JButton btnNewButton = new JButton("Belépés");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int pc = m.Log(getText(username), getText(pwd));
				if(pc == 1) {
					Belepett abkezel = new Belepett(Login.this);
					abkezel.setVisible(true);
					dispose();
				}
				else {
					error("Sikertelen bejelentkezés!");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(225, 317, 169, 51);
		contentPane.add(btnNewButton);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(170, 86, 284, 36);
		contentPane.add(username);
		username.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setHorizontalAlignment(SwingConstants.CENTER);
		pwd.setEchoChar('*');
		pwd.setColumns(10);
		pwd.setBounds(170, 182, 284, 36);
		contentPane.add(pwd);
		
		JLabel lblNewLabel = new JLabel("Felhasználónév");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(256, 52, 114, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblJelsz = new JLabel("Jelszó");
		lblJelsz.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblJelsz.setBounds(287, 148, 44, 24);
		contentPane.add(lblJelsz);
		
		JCheckBox isSeen = new JCheckBox("Jelszó láthatósága");
		isSeen.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		isSeen.setBounds(244, 251, 131, 21);
		isSeen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSeen.isSelected()==true) {
					pwd.setEchoChar((char)0);
				}
				else {
					pwd.setEchoChar('*');
				}
			}
		});
		contentPane.add(isSeen);
		
		pwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				int key = arg0.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					
					int pc = m.Log(getText(username), getText(pwd));
					if(pc == 1) {
						Belepett abkezel = new Belepett(Login.this);
						abkezel.setVisible(true);
						dispose();
					}
					else {
						error("Sikertelen bejelentkezés!");
					}
					
				}
				
			}
		});
		
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
}
