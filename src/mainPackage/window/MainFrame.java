package mainPackage.window;

import mainPackage.Main;
import mainPackage.window.adapters.*;
import mainPackage.window.dialogWindow.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame(String title) {
        super(title);
        setSize(getToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DrawingComponent drawingComponent = new DrawingComponent(this);
        //drawingComponent.setLayout(new GridLayout(1, 5, 0, 0));
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        drawingComponent.setLayout(flowLayout);

        Button reset = new Button("Reset");
        reset.addActionListener(e -> {
            Main.getFigure().reset();
            drawingComponent.repaint();
        });

        JButton buttonMove = new JButton("Move");
        buttonMove.addActionListener(createMoveActionListener());
        JButton buttonSize = new JButton("Size");
        buttonSize.addActionListener(e -> {
            ChangeFigureSizeDialog changeFigureSizeDialog = new ChangeFigureSizeDialog(this);
            changeFigureSizeDialog.setVisible(true);
        });
        JButton buttonRotate = new JButton("Rotate");
        buttonRotate.addActionListener(e -> {
            RotationDialog rotationDialog = new RotationDialog(this);
            rotationDialog.setVisible(true);
        });
        JButton buttonInvisibleLines = new JButton("Invisible lines");
        buttonInvisibleLines.addActionListener(new InvisibleLinesMenuActionAdapter(this));
        JButton buttonLight = new JButton("Light");
        buttonLight.addActionListener(new LightMenuActionAdapter(this));
        JButton buttonChangeLight = new JButton("Change light");
        buttonChangeLight.addActionListener(e -> {
            ChangeLightPointDialog changeLightPointDialog = new ChangeLightPointDialog(this);
            changeLightPointDialog.setVisible(true);
        });

        JButton buttonXY = new JButton("OXY");
        buttonXY.addActionListener(new ProjectionsActionAdapter(this, (byte) 0));
        JButton buttonXZ = new JButton("OXZ");
        buttonXZ.addActionListener(new ProjectionsActionAdapter(this, (byte) 1));
        JButton buttonYZ = new JButton("OYZ");
        buttonYZ.addActionListener(new ProjectionsActionAdapter(this, (byte) 2));
        JButton buttonAxonometric = new JButton("Axonometric");
        buttonAxonometric.addActionListener(new ProjectionsActionAdapter(this, (byte) 3));
        JButton buttonOblique = new JButton("Oblique");
        buttonOblique.addActionListener(new ProjectionsActionAdapter(this, (byte) 4));
        JButton buttonPerspective = new JButton("Perspective");
        buttonPerspective.addActionListener(new ProjectionsActionAdapter(this, (byte) 5));
        drawingComponent.add(reset);
        drawingComponent.add(buttonMove);
        drawingComponent.add(buttonRotate);
        drawingComponent.add(buttonSize);
        drawingComponent.add(buttonXY);
        drawingComponent.add(buttonXZ);
        drawingComponent.add(buttonYZ);
        drawingComponent.add(buttonAxonometric);
        drawingComponent.add(buttonOblique);
        drawingComponent.add(buttonPerspective);
        drawingComponent.add(buttonInvisibleLines);
        drawingComponent.add(buttonLight);
        drawingComponent.add(buttonChangeLight);


//        JPanel panel1 = new JPanel();
//        drawingComponent.add(panel1);
        add(drawingComponent);

        //setJMenuBar(new MainMenu(this));

        MFrameMouseAdapter mouseAdapter = new MFrameMouseAdapter(drawingComponent);
        addMouseMotionListener(mouseAdapter);
        addMouseListener(mouseAdapter);
        addMouseWheelListener(mouseAdapter);

        addKeyListener(new MFrameKeyAdapter(drawingComponent));

        setVisible(true);
    }

    private ActionListener createMoveActionListener() {
        return e -> {
            MoveFigureDialog moveFigureDialog = new MoveFigureDialog(this);
            moveFigureDialog.setVisible(true);
        };
    }
}
