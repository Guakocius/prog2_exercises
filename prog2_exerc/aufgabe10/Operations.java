package aufgabe10;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Operations extends JPanel {

    private Operand o = new Operand();
    public boolean isSinCos = false;

    public Operations(Operand o) {

        this.o = o;

        JButton plus = new JButton("+");
        JButton times = new JButton("*");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JPanel firstRow = new JPanel();

        JButton sin = new JButton("sin");
        JButton cos = new JButton("cos");
        JButton exp = new JButton("x^y");
        JButton log = new JButton("log2");
        JPanel secondRow = new JPanel();

        JButton clear = new JButton("Clear");
        JPanel clearRow = new JPanel();

        plus.addActionListener(e -> {
            double valueX = 0, valueY = 0;
            isSinCos = false;

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }

            if (!this.o.yText.getText().equals("")) {
                valueY = Double.parseDouble(this.o.yText.getText());
            }

            this.o.resText.setText(Double.toString((valueX + valueY)));
        });

        times.addActionListener(e -> {
            double valueX = 0, valueY = 0;
            isSinCos = false;

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }

            if (!this.o.yText.getText().equals("")) {
                valueY = Double.parseDouble(this.o.yText.getText());
            }
            this.o.resText.setText(Double.toString((valueX * valueY)));
        });

        minus.addActionListener(e -> {
            double valueX = 0, valueY = 0;
            isSinCos = false;

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }

            if (!this.o.yText.getText().equals("")) {
                valueY = Double.parseDouble(this.o.yText.getText());
            }
            this.o.resText.setText(Double.toString((valueX - valueY)));
        });

        divide.addActionListener(e -> {
            double valueX = 0, valueY = 0;
            isSinCos = false;

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }

            if (!this.o.yText.getText().equals("")) {
                valueY = Double.parseDouble(this.o.yText.getText());
            }
            this.o.resText.setText(Double.toString((valueX / valueY)));
        });

        sin.addActionListener(e -> {
            double valueX = 0;
            isSinCos = true;

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }
            this.o.yText.setText("");
            this.o.resText.setText(Double.toString(Math.sin(valueX)));
        });

        cos.addActionListener(e -> {
            double valueX = 0;
            isSinCos = true;

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }
            this.o.yText.setText("");
            this.o.resText.setText(Double.toString(Math.cos(valueX)));
        });

        exp.addActionListener(e -> {
            double valueX = 0, valueY = 0;
            isSinCos = false;

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }

            if (!this.o.yText.getText().equals("")) {
                valueY = Double.parseDouble(this.o.yText.getText());
            }
            this.o.resText.setText(Double.toString(Math.pow(valueX, valueY)));
        });

        log.addActionListener(e -> {
            double valueX = 0;
            isSinCos = false;

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }
            this.o.yText.setText("");
            this.o.resText.setText(Double.toString(Math.log10(valueX) / Math.log10(2)));
        });

        clear.addActionListener(e -> {
            this.o.xText.setText("");
            this.o.yText.setText("");
            this.o.resText.setText("");

        });

        firstRow.add(plus);
        firstRow.add(times);
        firstRow.add(minus);
        firstRow.add(divide);

        secondRow.add(sin);
        secondRow.add(cos);
        secondRow.add(exp);
        secondRow.add(log);

        clearRow.add(clear);

        firstRow.setAlignmentX(CENTER_ALIGNMENT);
        secondRow.setAlignmentX(CENTER_ALIGNMENT);
        clearRow.setAlignmentX(CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(firstRow, BorderLayout.NORTH);
        this.add(secondRow, BorderLayout.CENTER);
        this.add(clearRow, BorderLayout.SOUTH);

    }
}
