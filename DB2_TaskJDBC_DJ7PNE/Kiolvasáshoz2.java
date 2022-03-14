package program;

import javax.swing.table.DefaultTableModel;

public class Kiolvasáshoz2 extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public Kiolvasáshoz2(Object fildNames[], int rows) {
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
			return Boolean.class;
		else if (index == 2)
			return (Long.class);
		else if(index == 3 || index ==4 || index == 5 || index == 11)
			return (String.class);
		else
			return (Integer.class);
	}
}
