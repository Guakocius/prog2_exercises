package aufgabe10;

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
        Settings settings = new Settings(o);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        contentPanel.add(o);
        contentPanel.add(settings);
        contentPanel.add(op);

        this.add(contentPanel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame calculator = new Calculator();
    }

}
