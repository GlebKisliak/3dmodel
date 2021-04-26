package mainPackage.window.dialogWindow;

import mainPackage.Main;
import mainPackage.geometry.Figure;
import mainPackage.geometry.Vertex;

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

public class ChangeLightPointDialog extends JDialog {
    private JTextField xTextField;
    private JTextField yTextField;
    private JTextField zTextField;
    private JTextField kd;
    private JTextField ka;

    private JFrame frame;

    public ChangeLightPointDialog(JFrame frame) {
        super(frame, "Change Light Point", true);
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
            double x = 0, y = 0, z = 0, kd = 1, ka = 1;
            boolean isCorrect = false;
            try {
                x = Double.parseDouble(xTextField.getText());
                y = Double.parseDouble(yTextField.getText());
                z = Double.parseDouble(zTextField.getText());
                kd = Double.parseDouble(this.kd.getText());
                ka = Double.parseDouble(this.ka.getText());

                isCorrect = true;
            } catch (Exception ignored) {
            }
            if (isCorrect) {
                Figure figure = Main.getFigure();
                figure.setLight(new Vertex(x, y, z));
                figure.setAmbientLight(ka);
                figure.setDiffisedLight(kd);
                frame.getContentPane().repaint();
            }
            this.dispose();
        };
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("x:"));
        xTextField = new JTextField("300");
        panel.add(xTextField);
        panel.add(new JLabel("y:"));
        yTextField = new JTextField("300");
        panel.add(yTextField);
        panel.add(new JLabel("z:"));
        zTextField = new JTextField("-200");
        panel.add(zTextField);
        panel.add(new JLabel("Kd:"));
        kd = new JTextField("1");
        panel.add(kd);
        panel.add(new JLabel("Ka:"));
        ka = new JTextField("1");
        panel.add(ka);
        return panel;
    }
}
