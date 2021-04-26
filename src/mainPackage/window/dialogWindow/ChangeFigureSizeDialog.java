package mainPackage.window.dialogWindow;

import mainPackage.Main;
import mainPackage.geometry.MyFigure;

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

public class ChangeFigureSizeDialog extends JDialog {
    private JTextField aTextField;
    private JTextField dTextField;
    private JTextField hTextField;
    private JTextField cTextField;

    private JFrame frame;

    public ChangeFigureSizeDialog(JFrame frame) {
        super(frame, "Change Figure Size", true);
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
            double a = 0, d = 0, h = 0, c = 0;
            boolean isCorrect = false;
            try {
                a = Double.parseDouble(aTextField.getText());
                d = Double.parseDouble(dTextField.getText());
                h = Double.parseDouble(hTextField.getText());
                c = Double.parseDouble(cTextField.getText());
                if (a <= 0 || d <= 0 || h <= 0 || c <= 0 ) throw new Exception();
                isCorrect = true;
            } catch (Exception ignored) {
            }
            if (isCorrect) {
                MyFigure figure = (MyFigure) Main.getFigure();
                figure.changeFigureSize(a, d, h, c);
                frame.getContentPane().repaint();
            }
            this.dispose();
        };
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("a:"));
        aTextField = new JTextField("50");
        panel.add(aTextField);
        panel.add(new JLabel("d:"));
        dTextField = new JTextField("200");
        panel.add(dTextField);
        panel.add(new JLabel("h:"));
        hTextField = new JTextField("100");
        panel.add(hTextField);
        panel.add(new JLabel("c:"));
        cTextField = new JTextField("200");
        panel.add(cTextField);
        return panel;
    }
}
