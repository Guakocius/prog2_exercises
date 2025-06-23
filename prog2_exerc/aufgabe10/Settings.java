package aufgabe10;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Settings
        extends JPanel {

    JRadioButton degButton;
    JRadioButton radButton;

    private Operand o = new Operand();

    public boolean isDeg;
    Color defaultXColor;
    Color defaultYColor;

    public Settings(Operand o) {

        this.o = o;

        JPanel degPanel = new JPanel();
        JPanel radPanel = new JPanel();
        JPanel lightPanel = new JPanel();

        degButton = new JRadioButton("Deg", true);
        radButton = new JRadioButton("Rad", false);
        JCheckBox lightButton = new JCheckBox("Helles Display", true);

        o.setLightMode();
        defaultXColor = this.o.xText.getForeground();
        defaultYColor = this.o.yText.getForeground();

        lightButton.addActionListener(e -> {
            if (lightButton.isSelected()) {
                o.setLightMode();
                defaultXColor = this.o.xText.getForeground();
                defaultYColor = this.o.yText.getForeground();

            } else {
                o.setDarkMode();
                defaultXColor = this.o.xText.getForeground();
                defaultYColor = this.o.yText.getForeground();
            }
        });

        ButtonGroup degRadGroup = new ButtonGroup();
        degRadGroup.add(degButton);
        degRadGroup.add(radButton);

        degButton.addActionListener(e -> {
            isDeg = true;
        });

        radButton.addActionListener(e -> {
            isDeg = false;
        });
        this.o.xText.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                o.xText.setForeground(defaultXColor);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });

        this.o.yText.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                o.yText.setForeground(defaultYColor);
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });

        degPanel.add(degButton);

        radPanel.add(radButton);

        lightPanel.add(lightButton);

        this.add(degPanel);
        this.add(radPanel);
        this.add(lightPanel);
    }

    void toDeg(double val) {
        try {
            val = Math.toDegrees(val);
            o.resText.setText(Double.toString(val));
        } catch (NumberFormatException e) {
            o.resText.setText("Ungültige Zahl!");

        }
    }

    void toRad(double val) {
        try {
            val = Math.toRadians(val);
            o.resText.setText(Double.toString(val));
        } catch (NumberFormatException e) {
            o.resText.setText("Ungültige Zahl!");
        }
    }
}
