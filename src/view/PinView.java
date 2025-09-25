
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PinView extends JFrame {
    private JPanel pnlSzamokHelye;
    private JCheckBox chbMutat;
    private JButton[] buttons;

    public PinView() {
        setTitle("PIN Bekérő");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        pnlSzamokHelye = new JPanel(new GridLayout(4, 3));
        chbMutat = new JCheckBox("Mutat");
        chbMutat.setEnabled(false);

        buttons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setBackground(null);
            pnlSzamokHelye.add(buttons[i]);
        }

        JPanel mainPanel = new JPanel();
        mainPanel.add(pnlSzamokHelye);
        mainPanel.add(chbMutat);

        getContentPane().add(mainPanel);
    }

    public void addButtonListener(ActionListener listener) {
        for (JButton btn : buttons) {
            btn.addActionListener(listener);
        }
    }

    public void addCheckboxListener(ActionListener listener) {
        chbMutat.addActionListener(listener);
    }

    public void setCheckboxEnabled(boolean enabled) {
        chbMutat.setEnabled(enabled);
    }

    public boolean isCheckboxSelected() {
        return chbMutat.isSelected();
    }

    public void highlightButtons(String pin, boolean highlight) {
        for (int i = 0; i < pin.length(); i++) {
            int digit = Character.getNumericValue(pin.charAt(i));
            buttons[digit].setBackground(highlight ? Color.RED : null);
        }
    }
    public void printToConsole(String message) {
    System.out.println(message);
}


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
