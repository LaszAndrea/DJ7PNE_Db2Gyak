package program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Kalkulator {

	public Kalkulator(Belepett b) {
		final JFrame parent = new JFrame();
		parent.setBounds(480, 80, 575, 395);
		parent.setLayout(null);

		parent.setPreferredSize(new Dimension(450, 430));
		parent.setLocation(540, 180);
		parent.setTitle("Kalkulátor");

		JButton button = new JButton("Darabszámot szeretnék számolni kilóból");
		JButton button2 = new JButton("Kilót szeretnék számolni darabszámból");
		JButton button3 = new JButton("Darabszámot szeretnék számolni folyóméterbõl");
		JButton button4 = new JButton("Folyómétert szeretnék számolni darabszámból");
		
		button.setBounds(50, 50, 350, 40);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		parent.add(button, BorderLayout.CENTER);
		
		button2.setBounds(50, 100, 350, 40);
		button2.setFont(new Font("Tahoma", Font.BOLD, 12));
		parent.add(button2, BorderLayout.CENTER);
		
		button3.setBounds(50, 150, 350, 40);
		button3.setFont(new Font("Tahoma", Font.BOLD, 12));
		parent.add(button3, BorderLayout.CENTER);
		
		button4.setBounds(50, 200, 350, 40);
		button4.setFont(new Font("Tahoma", Font.BOLD, 12));
		parent.add(button4, BorderLayout.CENTER);
		
		JButton cancel = new JButton("Mégsem");
		cancel.setBounds(50, 300, 350, 40);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		parent.add(cancel, BorderLayout.CENTER);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(false);
				Login f = new Login();
				Belepett b = new Belepett(f);
				b.setVisible(true);
			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(false);
				boolean flag = false;
				int mennyiség = 0;
				while (!flag) {
					String name2 = JOptionPane.showInputDialog(null, "Adja meg a mennyiséget (kg)");
					if (name2 != null || (name2 != null && ("".equals(name2)))) {
						try {
							mennyiség = Integer.parseInt(name2);
							flag = false;
							int szélesség = 0;
							while (!flag) {
								String name3 = JOptionPane.showInputDialog(parent, "Adja meg a szélességet (mm)", null);
								if (name3 != null || (name3 != null && ("".equals(name3)))) {
									try {
										szélesség = Integer.parseInt(name3);
										flag = false;
										int vagas = 0;
										String name = JOptionPane.showInputDialog(parent, "Adja meg a vágáshosszt (mm)",
												null);
										if (name != null || (name != null && ("".equals(name)))) {
											try {
												vagas = Integer.parseInt(name);
												flag = false;
												int gramsúly = 0;
												String name4 = JOptionPane.showInputDialog(parent,
														"Adja meg a gramsúlyt (gr/m2)", null);
												if (name4 != null || (name4 != null && ("".equals(name4)))) {
													try {
														gramsúly = Integer.parseInt(name4);
														flag = true;
														Kalkulator tasak = new Kalkulator(mennyiség, vagas, szélesség,
																gramsúly);
														JOptionPane.showMessageDialog(parent,
																"A gyártott darabszám: " + tasak.szamitas());

													} catch (NumberFormatException ex) {
														JOptionPane.showMessageDialog(parent,
																"User did not enter an integer.");
													}
												} else {
													flag = true;
												}

											} catch (NumberFormatException ex) {
												JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
											}
										} else {
											flag = true;
										}

									} catch (NumberFormatException ex) {
										JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
									}
								} else {
									flag = true;
								}

							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
						}
					} else {
						flag = true;
					}

				}

				parent.setVisible(true);

			}
		});


		parent.pack();
		parent.setVisible(true);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(false);
				boolean flag = false;
				int mennyiség = 0;
				while (!flag) {
					String name2 = JOptionPane.showInputDialog(null, "Adja meg a mennyiséget (db)");
					if (name2 != null || (name2 != null && ("".equals(name2)))) {
						try {
							mennyiség = Integer.parseInt(name2);
							flag = false;
							int szélesség = 0;
							while (!flag) {
								String name3 = JOptionPane.showInputDialog(parent, "Adja meg a szélességet (mm)", null);
								if (name3 != null || (name3 != null && ("".equals(name3)))) {
									try {
										szélesség = Integer.parseInt(name3);
										flag = false;
										int vagas = 0;
										String name = JOptionPane.showInputDialog(parent, "Adja meg a vágáshosszt (mm)",
												null);
										if (name != null || (name != null && ("".equals(name)))) {
											try {
												vagas = Integer.parseInt(name);
												flag = false;
												int gramsúly = 0;
												String name4 = JOptionPane.showInputDialog(parent,
														"Adja meg a gramsúlyt (gr/m2)", null);
												if (name4 != null || (name4 != null && ("".equals(name4)))) {
													try {
														gramsúly = Integer.parseInt(name4);
														flag = true;
														Kalkulator tasak = new Kalkulator(mennyiség, vagas, szélesség,
																gramsúly);
														JOptionPane.showMessageDialog(parent,
																"A gyártott kiló: " + tasak.szamitas2());

													} catch (NumberFormatException ex) {
														JOptionPane.showMessageDialog(parent,
																"User did not enter an integer.");
													}
												} else {
													flag = true;
												}

											} catch (NumberFormatException ex) {
												JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
											}
										} else {
											flag = true;
										}

									} catch (NumberFormatException ex) {
										JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
									}
								} else {
									flag = true;
								}

							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
						}
					} else {
						flag = true;
					}

				}

				parent.setVisible(true);

			}
		});

		parent.pack();
		parent.setVisible(true);
		button3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				parent.setVisible(false);
				boolean flag = false;
				int mennyiség = 0;
				while (!flag) {
					String name2 = JOptionPane.showInputDialog(null, "Adja meg a mennyiséget (fm)");
					if (name2 != null || (name2 != null && ("".equals(name2)))) {
						try {
							mennyiség = Integer.parseInt(name2);
							flag = false;
							int vagas = 0;
							String name = JOptionPane.showInputDialog(parent, "Adja meg a vágáshosszt (mm)", null);
							if (name != null || (name != null && ("".equals(name)))) {
								try {
									vagas = Integer.parseInt(name);
									flag = false;
									int palyak = 1;
									String name4 = JOptionPane.showInputDialog(parent, "Adja meg a pályák számát",
											null);
									if (name4 != null || (name4 != null && ("".equals(name4)))) {
										try {
											palyak = Integer.parseInt(name4);
											Kalkulator tasak = new Kalkulator(mennyiség, vagas, palyak);
											JOptionPane.showMessageDialog(parent,
													"A gyártott mennyiség (db): " + tasak.szamitas3());
										} catch (NumberFormatException e) {
											JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
										}
									} else {
										flag = true;
									}

								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
								}
							} else {
								flag = true;
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
						}
					} else {
						flag = true;
					}
				}
				parent.setVisible(true);
			}
		});

		parent.pack();
		parent.setVisible(true);
		button4.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				parent.setVisible(false);
				boolean flag = false;
				int mennyiség = 0;
				while (!flag) {
					String name2 = JOptionPane.showInputDialog(null, "Adja meg a mennyiséget (db)");
					if (name2 != null || (name2 != null && ("".equals(name2)))) {
						try {
							mennyiség = Integer.parseInt(name2);
							flag = false;
							int vagas = 0;
							String name = JOptionPane.showInputDialog(parent, "Adja meg a vágáshosszt (mm)", null);
							if (name != null || (name != null && ("".equals(name)))) {
								try {
									vagas = Integer.parseInt(name);
									flag = false;
									int palyak = 1;
									String name4 = JOptionPane.showInputDialog(parent, "Adja meg a pályák számát",
											null);
									if (name4 != null || (name4 != null && ("".equals(name4)))) {
										try {
											palyak = Integer.parseInt(name4);
											Kalkulator tasak = new Kalkulator(mennyiség, vagas, palyak);
											JOptionPane.showMessageDialog(parent,
													"A gyártott mennyiség (fm): " + tasak.szamitas4());
										} catch (NumberFormatException e) {
											JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
										}
									} else {
										flag = true;
									}

								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
								}
							} else {
								flag = true;
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(parent, "User did not enter an integer.");
						}
					} else {
						flag = true;
					}
				}
				parent.setVisible(true);

			}
		});
		
		//JButton p5 = new JButton();
		

	}

	private double mennyiseg;
	private double vagashossz;
	private double szelesseg;
	private double gramsuly;
	private int palyak;

	public Kalkulator(double mennyiseg, double vagashossz, double szelesseg, double gramsuly) {
		super();
		this.mennyiseg = mennyiseg;
		this.vagashossz = vagashossz;
		this.szelesseg = szelesseg;
		this.gramsuly = gramsuly;
	}

	public Kalkulator(double mennyiseg, double vagashossz, int palyak) {
		super();
		this.mennyiseg = mennyiseg;
		this.vagashossz = vagashossz;
		this.palyak = palyak;
	}

	@Override
	public String toString() {
		return "Szamito [mennyiseg=" + mennyiseg + ", vagashossz=" + vagashossz + ", szelesseg=" + szelesseg
				+ ", gramsuly=" + gramsuly + "]";
	}

	public int szamitas() {
		double vegeredmeny;

		vegeredmeny = ((this.mennyiseg)
				/ ((this.vagashossz / 1000) * (this.szelesseg / 1000) * (this.gramsuly / 1000)));
		return (int) vegeredmeny;
	}

	public double szamitas2() {
		double vegeredmeny;

		vegeredmeny = ((this.mennyiseg)
				* ((this.vagashossz / 1000) * (this.szelesseg / 1000) * (this.gramsuly / 1000)));
		return vegeredmeny;
	}

	public double szamitas3() {
		double vegeredmeny;

		vegeredmeny = ((this.mennyiseg) * this.palyak) / (this.vagashossz / 1000);

		return vegeredmeny;
	}

	public double szamitas4() {
		double vegeredmeny;

		vegeredmeny = (this.mennyiseg * (this.vagashossz / 1000)) / this.palyak;

		return vegeredmeny;
	}

}
