package program;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModositasTasak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Metódusok dbm = new Metódusok();
	private JFrame parents = new JFrame();
	Kiolvasáshoz k;

	public ModositasTasak(String tid, String sszsz, String szel, String tsz, String m, String rete, String hr, String tr, String mennyiseg, String date) {

		k = dbm.TasakOlv();

		setTitle("Módosítás tárgya");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mit szeretne megváltoztatni?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(102, 11, 239, 32);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Szerzõdésszám");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új szerzõdésszám");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!SzSzEll(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositTasakSz(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});

			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(43, 66, 131, 32);
		contentPane.add(btnNewButton);

		JButton btnSzlessg = new JButton("Szélesség");
		btnSzlessg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új szélesség");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!ifInt(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositTasakSzel(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});

			}
				
		});
		btnSzlessg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSzlessg.setBackground(Color.LIGHT_GRAY);
		btnSzlessg.setBounds(244, 66, 131, 32);
		contentPane.add(btnSzlessg);

		JButton btnTalphossz = new JButton("Talphossz");
		btnTalphossz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új talphossz");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!ifInt(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositTasakTh(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});
				
			}
		});
		btnTalphossz.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTalphossz.setBackground(Color.LIGHT_GRAY);
		btnTalphossz.setBounds(43, 125, 131, 32);
		contentPane.add(btnTalphossz);

		JButton btnMagassg = new JButton("Magasság");
		btnMagassg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új magasság");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!ifInt(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositTasakM(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});
				
			}
		});
		btnMagassg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnMagassg.setBackground(Color.LIGHT_GRAY);
		btnMagassg.setBounds(244, 125, 131, 32);
		contentPane.add(btnMagassg);

		JButton btnRtegekSzma = new JButton("Rétegek száma");
		btnRtegekSzma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új rétegek száma");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!ifInt(szz)) {
							error("A mezõ hibás");
						} else if(!retegEll(szz)){
							error("A mezõ hibás, a rétegek száma 1 vagy 2 lehet!");
						}
						else {
							dbm.modositTasakR(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});
				
			}
		});
		btnRtegekSzma.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRtegekSzma.setBackground(Color.LIGHT_GRAY);
		btnRtegekSzma.setBounds(43, 186, 131, 32);
		contentPane.add(btnRtegekSzma);

		JButton btnTalpragaszt = new JButton("Talpragasztó");
		btnTalpragaszt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új talpragasztó");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!ifInt(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositTasakTr(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});
				
			}
		});
		btnTalpragaszt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTalpragaszt.setBackground(Color.LIGHT_GRAY);
		btnTalpragaszt.setBounds(244, 186, 131, 32);
		contentPane.add(btnTalpragaszt);

		JButton btnHosszragaszt = new JButton("Hosszragasztó");
		btnHosszragaszt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új hosszragasztó");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!ifInt(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositTasakHr(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});
				
			}
		});
		btnHosszragaszt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnHosszragaszt.setBackground(Color.LIGHT_GRAY);
		btnHosszragaszt.setBounds(43, 244, 131, 32);
		contentPane.add(btnHosszragaszt);

		JButton btnMennyisg = new JButton("Mennyiség");
		btnMennyisg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új mennyiség");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!ifInt(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositTasakMenny(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});
				
			}
		});
		btnMennyisg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnMennyisg.setBackground(Color.LIGHT_GRAY);
		btnMennyisg.setBounds(244, 244, 131, 32);
		contentPane.add(btnMennyisg);

		JLabel rtrn = new JLabel("Vissza");
		rtrn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rtrn.setBounds(183, 370, 55, 14);
		contentPane.add(rtrn);
		
		JButton btnIgnylsLeadsa = new JButton("Ig\u00E9nyl\u00E9s lead\u00E1sa");
		btnIgnylsLeadsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új igénylés dátuma");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				JTextField szz = new JTextField();
				szz.setBounds(132, 10, 107, 25);
				szz.setColumns(10);
				parents.getContentPane().add(szz);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);
				
				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr, mennyiseg, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						}
						else if(!ifDate(szz)) {
							error("A dátum nem megfelelõ formátumú");
						}
						else {
							dbm.modositTasakDate(getText(szz), tid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + tid + " számú tasakban!");
							ModositasTasak f = new ModositasTasak(tid, sszsz, szel, tsz, m, rete, hr, tr,
									mennyiseg, date);
							f.setVisible(true);
						}
					}
				});
				
			}
		});
		btnIgnylsLeadsa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnIgnylsLeadsa.setBackground(Color.LIGHT_GRAY);
		btnIgnylsLeadsa.setBounds(141, 308, 131, 32);
		contentPane.add(btnIgnylsLeadsa);

		rtrn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rtrn.setForeground(new Color(0, 0, 255));

			}

			public void mouseExited(MouseEvent e) {
				rtrn.setForeground(new Color(0, 0, 0));
			}

			public void mouseClicked(MouseEvent arg0) {

				ListSmth s = new ListSmth();
				Kiolvasáshoz k = dbm.TasakOlv();
				TasalList t = new TasalList(s, k);
				dispose();
				t.setVisible(true);

			}
		});

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

	public int getInt(JTextField jtf) {
		int a;
		a = Integer.parseInt(jtf.getText());
		return a;
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
			if(Integer.parseInt(s)>2 || Integer.parseInt(s) < 1) {
				return false;
			}else
				return true;
		}catch(NumberFormatException e) {
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
