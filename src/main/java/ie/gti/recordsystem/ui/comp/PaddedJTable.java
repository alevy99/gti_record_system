package ie.gti.recordsystem.ui.comp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class PaddedJTable extends JTable {

    private static final Color EVEN_ROW_COLOR = Color.WHITE;
    private static final Color ODD_ROW_COLOR = new Color(230, 230, 230); // Light gray

    public PaddedJTable() {
        super();
//        java.awt.EventQueue.invokeLater(() -> {
            setRowHeight(25); // Increase row height for better spacing
            setDefaultRenderer(Object.class, new PaddedCellRenderer());
            setDefaultRenderer(Long.class, new PaddedCellRenderer());
//            setDefaultRenderer(Boolean.class, new BooleanCellRenderer());
            setDefaultEditor(Object.class, new PaddedCellEditor());
            // Add sorter to the table
            if (getRowSorter() == null) {
                setRowSorter(new TableRowSorter<TableModel>(this.getModel()));
            }

            JTableHeader header = getTableHeader();
            header.setFont(new Font("Comic", Font.PLAIN, 14)); // Bold, larger font
            header.setBackground(Color.LIGHT_GRAY); // Dark background
            header.setForeground(Color.DARK_GRAY); // White text
            header.setOpaque(true);
            header.setPreferredSize(new Dimension(header.getWidth(), 30));
            ((DefaultTableCellRenderer ) header.getDefaultRenderer()).setHorizontalAlignment(CENTER);
//        });
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

            if (!isSelected) { // Keep selection color when row is selected
                if (row % 2 == 0) {
                    c.setBackground(EVEN_ROW_COLOR);
                } else {
                    c.setBackground(ODD_ROW_COLOR);
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

    // Custom Renderer for Boolean Cells (CheckBoxes)
    private static class BooleanCellRenderer extends JCheckBox implements TableCellRenderer {
        public BooleanCellRenderer() {
            setHorizontalAlignment(CENTER); // Center the checkbox
            setOpaque(true); // Allow background color changes
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) {
                setSelected((Boolean) value);
            }

            // Apply alternating row colors
            if (!isSelected) {
                Color bg = (row % 2 == 0) ? EVEN_ROW_COLOR : ODD_ROW_COLOR; // Match Nimbus striping
                setBackground(bg);
            } else {
                setBackground(table.getSelectionBackground()); // Keep selection color
            }

            return this;
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