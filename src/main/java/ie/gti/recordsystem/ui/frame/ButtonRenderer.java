package ie.gti.recordsystem.ui.frame;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

// ButtonRenderer: Custom cell renderer for displaying buttons
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true); // Make sure button has a background
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
