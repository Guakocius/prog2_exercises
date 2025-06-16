package aufgabe10;

import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Settings
        extends JPanel {

    private Operand o;

    public Settings() {

        JPanel degPanel = new JPanel();
        JPanel radPanel = new JPanel();
        JPanel lightPanel = new JPanel();

        JRadioButton degButton = new JRadioButton();
        JRadioButton radButton = new JRadioButton();
        JCheckBox lightButton = new JCheckBox();
        lightButton.addActionListener((ActionEvent e) -> {
            o.setLightMode();
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
}
