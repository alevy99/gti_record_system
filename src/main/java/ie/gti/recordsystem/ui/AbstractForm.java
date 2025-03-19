package ie.gti.recordsystem.ui;

import javax.swing.*;

public abstract class AbstractForm extends JFrame {

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
        System.out.println(this.getClass().getSimpleName() + " WINDOW IS HIDDEN");
        //mainFrame.setVisible(true);
    }


    protected void onFormShown() {
        System.out.println(this.getClass().getSimpleName() + " WINDOW IS VISIBLE");
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