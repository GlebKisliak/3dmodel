
package mainPackage.window.dialogWindow;

import mainPackage.Main;
import mainPackage.geometry.Figure;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class RotationDialog extends JDialog {
    private JTextField xTextField;
    private JTextField yTextField;
    private JTextField zTextField;

    private JFrame frame;

    public RotationDialog(JFrame frame) {
        super(frame, "Rotate", true);
        this.frame = frame;

        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 1, 0, 0));

        container.add(createTextFields());
        container.add(createOkButton());

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JPanel createOkButton() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(createOkActionListener());
        panel.add(okButton);
        return panel;
    }

    private ActionListener createOkActionListener() {
        return e -> {
            double x = 0, y = 0, z = 0;
            boolean isCorrect = false;
            try {
                x = Double.parseDouble(xTextField.getText());
                y = Double.parseDouble(yTextField.getText());
                z = Double.parseDouble(zTextField.getText());
                isCorrect = true;
            } catch (Exception ignored) {
            }
            if (isCorrect) {
                Figure figure = Main.getFigure();
                figure.rotate(Math.toRadians(x), Math.toRadians(y), Math.toRadians(z));
                frame.getContentPane().repaint();
            }
            this.dispose();
        };
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("Angle x:"));
        xTextField = new JTextField("000");
        panel.add(xTextField);
        panel.add(new JLabel("Angle y:"));
        yTextField = new JTextField("000");
        panel.add(yTextField);
        panel.add(new JLabel("Angle z:"));
        zTextField = new JTextField("000");
        panel.add(zTextField);
        return panel;
    }
}
