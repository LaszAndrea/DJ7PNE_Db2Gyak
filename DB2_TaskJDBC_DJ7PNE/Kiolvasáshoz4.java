package program;

import javax.swing.table.DefaultTableModel;

public class Kiolvasáshoz4 extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public Kiolvasáshoz4(Object fildNames[], int rows) {
		super(fildNames, rows);
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public Class<?> getColumnClass(int index) {
		
			return (String.class);
			
	}
	
}
