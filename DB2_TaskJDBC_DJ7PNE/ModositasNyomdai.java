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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModositasNyomdai extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Metódusok dbm = new Metódusok();
	private JFrame parents = new JFrame();
	Kiolvasáshoz2 k;

	public ModositasNyomdai(String nyid, String szerzodesszam, String v, String t, String min, String gr, String sz,
			String vh, String festekek, String palyak, String date) {

		k = dbm.NyomdaiOlv();

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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
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
							dbm.modositNyomdaiSz(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú nyomdaiban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
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

		JButton vev = new JButton("Vevõ");
		vev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új vevõ");
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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else {
							dbm.modositNyomdaiV(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
							f.setVisible(true);
						}
					}
				});

			}
		});
		vev.setBackground(Color.LIGHT_GRAY);
		vev.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vev.setBounds(244, 305, 131, 32);
		contentPane.add(vev);

		JButton btnSzlessg = new JButton("Terméknév");
		btnSzlessg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új terméknév");
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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else {
							dbm.modositNyomdaiT(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
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

		JButton btnTalphossz = new JButton("Minõség");
		btnTalphossz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új minõség");
				szer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				szer.setBounds(10, 10, 122, 26);
				parents.getContentPane().add(szer);

				String[] legordulo = { "stark fehér papír", "fehér nátron mondi", "barna papír" };
				JComboBox<String> minosegek = new JComboBox<>(legordulo);
				minosegek.setBounds(132, 10, 135, 25);
				parents.getContentPane().add(minosegek);

				JButton ok = new JButton("Módosítás");
				ok.setBackground(Color.LIGHT_GRAY);

				JButton cancel = new JButton("Vissza");
				cancel.setBackground(Color.LIGHT_GRAY);

				cancel.setBounds(155, 70, 100, 35);
				parents.getContentPane().add(cancel);

				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parents.setVisible(false);
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							dbm.modositNyomdaiMin((String)minosegek.getSelectedItem(), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
							f.setVisible(true);
					}
				});

			}
		});
		btnTalphossz.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTalphossz.setBackground(Color.LIGHT_GRAY);
		btnTalphossz.setBounds(43, 125, 131, 32);
		contentPane.add(btnTalphossz);

		JButton btnMagassg = new JButton("Gramsúly");
		btnMagassg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új gramsúly");
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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
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
							dbm.modositNyomdaiGr(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
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

		JButton btnRtegekSzma = new JButton("Szélesség");
		btnRtegekSzma.addActionListener(new ActionListener() {
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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
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
							dbm.modositNyomdaiSzel(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
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

		JButton btnTalpragaszt = new JButton("Vágáshossz");
		btnTalpragaszt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új vágáshossz");
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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
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
							dbm.modositNyomdaiVh(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
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

		JButton btnHosszragaszt = new JButton("Festékek");
		btnHosszragaszt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új festékek száma");
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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
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
						}else if(!festekEll(szz))
							error("A mezõ hibás");
						else {
							dbm.modositNyomdaiF(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
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

		JButton btnMennyisg = new JButton("Pályák");
		btnMennyisg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új pályák száma");
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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!palyakSz(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositNyomdaiP(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
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

		JButton btnIgnylsLeadsa = new JButton("Gyártás kezdete");
		btnIgnylsLeadsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				parents.setBounds(200, 80, 300, 160);
				parents.getContentPane().setLayout(null);
				parents.setLocation(540, 180);
				parents.setVisible(true);

				JLabel szer = new JLabel("Új gyártáskezdet");
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
						ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh, festekek,
								palyak, date);
						f.setVisible(true);
					}
				});

				ok.setBounds(30, 70, 100, 35);
				parents.getContentPane().add(ok);

				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!filled(szz)) {
							error("A mezõ üres");
						} else if (!ifDate(szz)) {
							error("A mezõ hibás");
						} else {
							dbm.modositNyomdaiDate(getText(szz), nyid);
							parents.setVisible(false);
							msg("Sikeres módosítás a " + nyid + " számú tasakban!");
							ModositasNyomdai f = new ModositasNyomdai(nyid, szerzodesszam, v, t, min, gr, sz, vh,
									festekek, palyak, date);
							f.setVisible(true);
						}
					}
				});

			}
		});
		btnIgnylsLeadsa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnIgnylsLeadsa.setBackground(Color.LIGHT_GRAY);
		btnIgnylsLeadsa.setBounds(43, 305, 131, 32);
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
				Kiolvasáshoz2 k = dbm.NyomdaiOlv();
				NyomdaiList t = new NyomdaiList(s, k);
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

	public boolean festekEll(JTextField f) {
		String s = getText(f);
		try {
			Integer.parseInt(s);
			if (Integer.parseInt(s) > 3 || Integer.parseInt(s) < 1) {
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
		} catch (ParseException e) {
			error(e.getMessage());
			return false;
		}
		if (sdf.format(testDate).equals(s))
			return true;
		else
			return false;
	}
	
	public boolean palyakSz(JTextField f) {
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

}
