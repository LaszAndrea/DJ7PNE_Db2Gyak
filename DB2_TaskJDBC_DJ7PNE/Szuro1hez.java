package program;

import javax.swing.table.DefaultTableModel;

public class Szuro1hez extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public Szuro1hez(Object fildNames[], int rows) {
		super(fildNames, rows);
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 0) {
			return true;
		}
		return false;
	}

	public Class<?> getColumnClass(int index) {
		if (index == 0)
			return (Boolean.class);
		else if (index == 1 || index == 3)
			return (Integer.class);
		else
			return (String.class);
	}

}
