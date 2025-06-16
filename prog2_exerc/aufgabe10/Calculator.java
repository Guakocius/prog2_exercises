package aufgabe10;

import javax.swing.*;

public class Calculator extends JFrame {

    public final int WIDTH = 400;
    public final int HEIGHT = 600;

    public Calculator() {

        GroupLayout layout = new GroupLayout(this);

        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);

        Operand operands = new Operand();
        Settings settings = new Settings();

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup(
                                        GroupLayout.Alignment.BASELINE)
                                        .add(operands)
                                        .add(settings)
                        )
        );

        this.add(operands);
        this.add(settings);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        JFrame calculator = new Calculator();
    }

}
