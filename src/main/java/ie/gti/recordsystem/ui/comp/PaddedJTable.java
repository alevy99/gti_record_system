package ie.gti.recordsystem.ui.comp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PaddedJTable extends JTable {

    public PaddedJTable() {
        super();
        setRowHeight(20); // Increase row height for better spacing
        setDefaultRenderer(Object.class, new PaddedCellRenderer());
        setDefaultRenderer(Long.class, new PaddedCellRenderer());
        setDefaultEditor(Object.class, new PaddedCellEditor());
        // Add sorter to the table
        if (getRowSorter() == null) {
            setRowSorter(new TableRowSorter<TableModel>(this.getModel()));
        }
    }

    // Custom Cell Renderer with Padding
    private static class PaddedCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (c instanceof JLabel) {
                ((JLabel) c).setBorder(new EmptyBorder(5, 5, 5, 5)); // Top, Left, Bottom, Right
                // Check if the value is of type Long
                if (value instanceof Number) {
                    setHorizontalAlignment(SwingConstants.RIGHT); // Align Long values to the right
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT); // Default alignment for other types
                }
            }

            return c;
        }
    }

    // Custom Cell Editor with Padding
    private static class PaddedCellEditor extends DefaultCellEditor {
        public PaddedCellEditor() {
            super(new JTextField());
            ((JTextField) getComponent()).setBorder(new EmptyBorder(0, 5, 0, 5)); // Add padding to the editor
        }
    }

    // Method to check if a cell contains a String
//    public boolean isCellStringType(int row, int column) {
//        Object value = getValueAt(row, column);
//        return value instanceof String;
//    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Custom JTable with Padding");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            // Sample data
//            Object[][] data = {
//                    {"Row 1, Col 1", 123},
//                    {"Row 2, Col 1", "Row 2, Col 2"}
//            };
//            Object[] columns = {"Column 1", "Column 2"};
//
//            PaddedJTable table = new PaddedJTable(data, columns);
//            JScrollPane scrollPane = new JScrollPane(table);
//            frame.add(scrollPane);
//
//            frame.setSize(400, 200);
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
}