package ie.gti.recordsystem.ui.comp;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PaddedCellRenderer extends DefaultTableCellRenderer {

    private final int leftPad;
    private final int rightPad;
    private final int topPad;
    private final int bottomPad;

    public PaddedCellRenderer(int padding) {
        this.leftPad = padding;
        this.rightPad = padding;
        this.topPad = padding;
        this.bottomPad = padding;
    }

    public PaddedCellRenderer(int topPad, int leftPad, int bottomPad, int rightPad) {
        super();
        this.leftPad = leftPad;
        this.rightPad = rightPad;
        this.topPad = topPad;
        this.bottomPad = bottomPad;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (c instanceof JLabel) {
            ((JLabel) c).setBorder(BorderFactory.createEmptyBorder(topPad, leftPad, bottomPad, rightPad)); // Top, Left, Bottom, Right
        }

        return c;
    }
}
