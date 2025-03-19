package ie.gti.recordsystem.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public abstract class AbstractForm extends JFrame {

    private final Logger logger = LoggerFactory.getLogger(AbstractForm.class);

    private boolean isShownOnce = false;

    protected abstract int getDefaultCloseOperationValue();


    public AbstractForm() {
        super();
//        setLocationRelativeTo(this);
    }

    protected void shownFirstTime() {

    }

    protected void initForm() {
        setDefaultCloseOperation(getDefaultCloseOperationValue()); // Hide instead of closing
    }

    @Override
    public void setVisible(boolean b) {
        if (! isShownOnce) {
            isShownOnce = true;
            setLocationRelativeTo(this);
            shownFirstTime();
        }
        super.setVisible(b);
        if (!b) {
            onFormHidden();
        } else {
            onFormShown();
        }
    }

    protected void onFormHidden() {
        logger.debug("{} WINDOW IS HIDDEN", this.getClass().getSimpleName());
        //mainFrame.setVisible(true);
    }


    protected void onFormShown() {
        logger.debug("{} WINDOW IS VISIBLE", this.getClass().getSimpleName());
//        initTableData();
    }

    public void showForm() {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            toFront();
        });
    }

//    protected boolean isShownOnce() {
//        return isShownOnce;
//    }
//
//    protected void setShownOnce(boolean shownOnce) {
//        isShownOnce = shownOnce;
//    }
}