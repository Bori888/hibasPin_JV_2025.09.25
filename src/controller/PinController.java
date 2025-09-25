
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modell.PinModell;
import view.PinView;

public class PinController {
    private PinModell model;
    private PinView view;

    public PinController(PinModell model, PinView view) {
        this.model = model;
        this.view = view;

        view.addButtonListener(new ButtonListener());
        view.addCheckboxListener(new CheckboxListener());
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.length() == 1 && Character.isDigit(cmd.charAt(0))) {
                if (model.addDigit(cmd.charAt(0))) {
                    if (model.isComplete()) {
                        view.setCheckboxEnabled(true);
                        view.showMessage("PIN mentve!");
                        try {
                            model.saveToFile();
                        } catch (IOException ex) {
                            view.showMessage("Hiba a PIN mentésekor: " + ex.getMessage());
                        }
                    }
                }
            }
        }
    }

    private class CheckboxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean selected = view.isCheckboxSelected();
            view.highlightButtons(model.getPin(), selected);
        }
    }
}

