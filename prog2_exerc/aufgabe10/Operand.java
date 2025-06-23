
package aufgabe10;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Operand extends JPanel {


    public final JTextField xText;
    public final JTextField yText;
    public final JTextField resText;

    public Operand() {

        final int WIDTH = 15;

        final int rows = 3, cols = 2, hgap = 10, vgap = 10;

        JPanel operands = new JPanel(new GridLayout(rows, cols, hgap, vgap));

        this.setLayout(new FlowLayout(FlowLayout.CENTER, hgap, vgap));

        JLabel xLabel = new JLabel("Operand x");
        xText = new JTextField(WIDTH);
        //JPanel xPanel = new JPanel();
        xText.setBackground(Color.BLACK);
        xText.setForeground(Color.YELLOW);

        JLabel yLabel = new JLabel("Operand y");
        yText = new JTextField(WIDTH);
        //JPanel yPanel = new JPanel();
        yText.setBackground(Color.BLACK);
        yText.setForeground(Color.YELLOW);

        JLabel resLabel = new JLabel("Resultat");
        resText = new JTextField(WIDTH);
        //JPanel resPanel = new JPanel();
        resText.setBackground(Color.BLACK);
        resText.setForeground(Color.YELLOW);

        /*xPanel.add(xLabel);
        xPanel.add(xText);

        yPanel.add(yLabel);
        yPanel.add(yText);

        resPanel.add(resLabel);
        resPanel.add(resText);

        this.add(xPanel);
        this.add(yPanel);
        this.add(resPanel);*/

        operands.add(xLabel);
        operands.add(xText);
        operands.add(yLabel);
        operands.add(yText);
        operands.add(resLabel);
        operands.add(resText);

        operands.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.add(operands);
        this.setVisible(true);
    }

    void setLightMode() {
        this.xText.setBackground(Color.WHITE);
        this.yText.setBackground(Color.WHITE);
        this.resText.setBackground(Color.WHITE);

        this.xText.setForeground(Color.BLACK);
        this.yText.setForeground(Color.BLACK);
        this.resText.setForeground(Color.BLACK);
    }

    void setDarkMode() {
        this.xText.setBackground(Color.BLACK);
        this.yText.setBackground(Color.BLACK);
        this.resText.setBackground(Color.BLACK);

        this.xText.setForeground(Color.YELLOW);
        this.yText.setForeground(Color.YELLOW);
        this.resText.setForeground(Color.YELLOW);
    }
}
