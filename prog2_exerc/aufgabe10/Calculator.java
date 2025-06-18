package aufgabe10;

import java.awt.BorderLayout;
import javax.swing.*;

public class Calculator extends JFrame {

    public final int WIDTH = 400;
    public final int HEIGHT = 600;

    public Calculator() {

        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);

        Operand o = new Operand();
        Operations op = new Operations(o);
        Settings settings = new Settings(o, op);

        JPanel contentPanel = new JPanel();

        o.setAlignmentX(TOP_ALIGNMENT);
        settings.setAlignmentX(TOP_ALIGNMENT);
        op.setAlignmentX(TOP_ALIGNMENT);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        contentPanel.add(o, BorderLayout.NORTH);
        contentPanel.add(settings, BorderLayout.CENTER);
        contentPanel.add(op, BorderLayout.SOUTH);
        this.add(contentPanel);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        JFrame calculator = new Calculator();
    }

}
