package mainPackage.window;

import mainPackage.Main;
import mainPackage.window.adapters.MFrameKeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class DrawingComponent extends JPanel {
    private final JFrame frame;

    public DrawingComponent(JFrame frame) {
        super();
        this.frame = frame;
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        Rectangle rectangle = frame.getBounds();
        g.drawLine(rectangle.width / 2, 0, rectangle.width / 2, rectangle.height);
        g.drawLine(0, rectangle.height / 2, rectangle.width, rectangle.height / 2);

        Main.getFigure().drawFigure((Graphics2D) g, frame.getWidth(), frame.getHeight());
    }
}
