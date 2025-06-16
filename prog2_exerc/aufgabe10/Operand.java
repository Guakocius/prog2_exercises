package aufgabe10;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Operand extends JPanel {

    public final int WIDTH = 15;

    private final JTextField xText;
    private final JTextField yText;
    private final JTextField resText;

    private Operand o;

    public Operand() {

        JLabel xLabel = new JLabel("Operand x");
        xText = new JTextField(WIDTH);
        JPanel xPanel = new JPanel();
        xText.setBackground(Color.BLACK);
        xText.setForeground(Color.YELLOW);

        JLabel yLabel = new JLabel("Operand y");
        yText = new JTextField(WIDTH);
        JPanel yPanel = new JPanel();
        yText.setBackground(Color.BLACK);
        yText.setForeground(Color.YELLOW);

        JLabel resLabel = new JLabel("Resultat");
        resText = new JTextField(WIDTH);
        JPanel resPanel = new JPanel();
        resText.setBackground(Color.BLACK);
        resText.setForeground(Color.YELLOW);

        xPanel.add(xLabel);
        xPanel.add(xText);

        yPanel.add(yLabel);
        yPanel.add(yText);

        resPanel.add(resLabel);
        resPanel.add(resText);

        this.add(xPanel);
        this.add(yPanel);
        this.add(resPanel);

        this.setVisible(true);
    }

    void setLightMode() {
        this.o.xText.setBackground(Color.WHITE);
        this.o.yText.setBackground(Color.WHITE);
        this.o.resText.setBackground(Color.WHITE);

        this.o.xText.setForeground(Color.BLACK);
        this.o.yText.setForeground(Color.BLACK);
        this.o.resText.setForeground(Color.BLACK);
    }
}
