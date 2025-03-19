package ie.gti.recordsystem.ui.comp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JGtiTable extends JTable {

    public JGtiTable() {
        super();
        initJTable();
    }

    private void initJTable() {
        final int CELL_PAD = 5;
        // Add padding to cells
//        PaddedCellRenderer paddedCellRenderer = new PaddedCellRenderer(CELL_PAD);

        // Apply to all text columns
        for (int i = 0; i < getColumnCount() - 1; i++) {
//            Class<?> columnClass = getModel().getColumnClass(i);
//            if ((columnClass == String.class)
//                    || (columnClass == Integer.class)
//                    || (columnClass == Double.class)
//                    || (columnClass == Float.class)) {
                this.getColumnModel().getColumn(i).setCellRenderer(new PaddedCellRenderer(CELL_PAD));
//            }
        }

        // Set cell editor with paddings
        JTextField textField = new JTextField();
        textField.setBorder(new EmptyBorder(0, CELL_PAD, 0, CELL_PAD)); // Apply padding inside the editor

        DefaultCellEditor cellEditor = new DefaultCellEditor(textField);
        this.setDefaultEditor(Object.class, cellEditor); // Apply to all cells

        // Add sorter to the table
        if (getRowSorter() == null) {
            setRowSorter(new TableRowSorter<TableModel>(this.getModel()));
        }
    }

}
