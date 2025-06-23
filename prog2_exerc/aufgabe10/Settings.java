package aufgabe10;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Settings
        extends JPanel {

    private Operand o = new Operand();

    public boolean isDeg = true;

    public Settings(Operand o) {

        this.o = o;

        JPanel degPanel = new JPanel();
        JPanel radPanel = new JPanel();
        JPanel lightPanel = new JPanel();

        JRadioButton degButton = new JRadioButton("Deg", true);
        JRadioButton radButton = new JRadioButton("Rad", false);
        JCheckBox lightButton = new JCheckBox("Helles Display", true);

        o.setLightMode();
        lightButton.addActionListener(e -> {
            if (lightButton.isSelected()) {
                o.setLightMode();
            } else {
                o.setDarkMode();
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

        degPanel.add(degButton);

        radPanel.add(radButton);

        lightPanel.add(lightButton);

        this.add(degPanel);
        this.add(radPanel);
        this.add(lightPanel);
    }

    void toDeg(Operand o) {
        try {
            double val = Double.parseDouble(o.resText.getText());
            o.resText.setText(Double.toString(Math.toDegrees(val)));
        } catch (NumberFormatException e) {
            o.resText.setText("Ungültige Zahl!");
            o.resText.setForeground(Color.RED);
        }
    }

    void toRad(Operand o) {
        try {
            double val = Double.parseDouble(o.resText.getText());
            o.resText.setText(Double.toString(Math.toRadians(val)));
        } catch (NumberFormatException e) {
            o.resText.setText("Ungültige Zahl!");
            o.resText.setForeground(Color.RED);
        }
    }

}
