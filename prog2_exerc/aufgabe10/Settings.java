package aufgabe10;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Settings
        extends JPanel {

    private Operand o = new Operand();
    private Operations op = new Operations(o);

    public Settings(Operand o, Operations op) {

        this.o = o;
        this.op = op;

        JPanel degPanel = new JPanel();
        JPanel radPanel = new JPanel();
        JPanel lightPanel = new JPanel();

        JRadioButton degButton = new JRadioButton();
        JRadioButton radButton = new JRadioButton();
        JCheckBox lightButton = new JCheckBox();
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

        /*while (degButton.isSelected()) {
                System.out.println(this.op.isSinCos);
                //degButton.addActionListener(e -> this.toDeg(o, this.op.isSinCos));
                this.toDeg(o, this.op.isSinCos);
        }
        while (radButton.isSelected()) {
                System.out.println(this.op.isSinCos);

        }*/
        degButton.addActionListener(e -> {
                System.out.println(this.op.isSinCos);
                this.toDeg(o, this.op.isSinCos);
        });

        radButton.addActionListener(e -> {
                System.out.println(this.op.isSinCos);
                this.toRad(o, this.op.isSinCos);
        });
        JTextField degText
                = new JTextField("Deg");
        JTextField radText
                = new JTextField("Rad");
        JTextField lightText
                = new JTextField("Helles Display");

        degPanel.add(degButton);
        degPanel.add(degText);

        radPanel.add(radButton);
        radPanel.add(radText);

        lightPanel.add(lightButton);
        lightPanel.add(lightText);

        this.add(degPanel);
        this.add(radPanel);
        this.add(lightPanel);
    }

    void toDeg(Operand o, boolean isSinCos) {
        if (isSinCos) {
            Math.toDegrees(Double.parseDouble(o.resText.getText()));
        }

    }

    void toRad(Operand o, boolean isSinCos) {
        if (isSinCos) {
            Math.toRadians(Double.parseDouble(o.resText.getText()));
        }

    }

}
