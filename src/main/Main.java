
package main;

import controller.PinController;
import modell.PinModell;
import view.PinView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            PinModell model = new PinModell();
            PinView view = new PinView();
            new PinController(model, view);
            view.setVisible(true);
        });
    }
}
