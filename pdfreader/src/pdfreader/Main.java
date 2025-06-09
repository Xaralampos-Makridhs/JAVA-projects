package pdfreader;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PDFGUI().setVisible(true));
    }
}

