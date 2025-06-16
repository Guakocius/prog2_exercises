package aufgabe10;

import javax.swing.*;

public class Calculator extends JFrame {

    public final int WIDTH = 400;
    public final int HEIGHT = 600;

    public Calculator() {

        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);


        Operand operands = new Operand();
        Settings settings = new Settings();

        this.add(operands);
        this.add(settings);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        JFrame calculator = new Calculator();
    }

}
