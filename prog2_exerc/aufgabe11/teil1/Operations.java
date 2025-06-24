package aufgabe11.teil1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Operations extends JPanel {

    private Operand o = new Operand();
    private Settings s = new Settings(o);

    private boolean isNumber(JTextField textField) {
        String text = textField.getText();
        try {
            Double value;
            if (text.equals("")) {
                value = 0.0;
            }

            value = Double.parseDouble(text);
            return true;

        } catch (NumberFormatException e) {
            textField.setText(text + " ist keine Zahl!");
            textField.setForeground(Color.RED);
            return false;
        }
    }

    public Operations(Operand o) {
        this.o = o;

        JButton plus = new JButton("+");
        JButton times = new JButton("*");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JButton sin = new JButton("sin");
        JButton cos = new JButton("cos");
        JButton exp = new JButton("x^y");
        JButton log = new JButton("log2");
        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JButton clear = new JButton("Clear");
        JPanel clearRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        Settings settings = new Settings(o);

        plus.addActionListener(e -> {
            double valueX = 0, valueY = 0;
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();

            if (!isNumber(this.o.xText) | !isNumber(this.o.yText)) {
                this.o.resText.setText("");
                return;
            }

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
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();

            if (!isNumber(this.o.xText) || !isNumber(this.o.yText)) {
                this.o.resText.setText("");
                return;
            }
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
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();

            if (!isNumber(this.o.xText) || !isNumber(this.o.yText)) {
                this.o.resText.setText("");
                return;
            }
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
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();

            if (!isNumber(this.o.xText) || !isNumber(this.o.yText)) {
                this.o.resText.setText("");
                return;
            }
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
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();
            yText = "0";
            this.o.yText.setText("0");

            if (!isNumber(this.o.xText) || !isNumber(this.o.yText)) {
                this.o.resText.setText("");
                return;
            }

            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
                double sD = Math.sin(valueX);
                double resR = Math.toRadians(valueX);
                double sR = Math.sin(resR);
                this.o.yText.setText(yText);
                if (this.o.isDeg) {
                    this.o.resText.setText(Double.toString(sD));
                } else {
                    this.o.resText.setText(Double.toString(sR));
                }
            }
        });

        cos.addActionListener(e -> {
            double valueX = 0;
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();
            yText = "0";
            this.o.yText.setText("0");
            this.o.yText.setText(yText);

            if (!isNumber(this.o.xText) || !isNumber(this.o.yText)) {
                this.o.resText.setText("");
                return;
            }
            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
                double cD = Math.cos(valueX);
                double resR = Math.toRadians(valueX);
                double cR = Math.cos(resR);
                if (this.o.isDeg) {
                    this.o.resText.setText(Double.toString(cD));
                } else {
                    this.o.resText.setText(Double.toString(cR));
                }

            }
        });

        exp.addActionListener(e -> {
            double valueX = 0, valueY = 0;
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();

            if (!isNumber(this.o.xText) || !isNumber(this.o.yText)) {
                this.o.resText.setText("");
                return;
            }
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
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();
            yText = "0";
            this.o.yText.setText("0");

            if (!isNumber(this.o.xText) || !isNumber(this.o.yText)) {
                this.o.resText.setText("");
                return;
            }
            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }
            this.o.yText.setText(yText);
            this.o.resText.setText(Double.toString(Math.log10(valueX) / Math.log10(2)));
        });

        clear.addActionListener(e -> {
            this.o.xText.setText("0");
            this.o.yText.setText("0");
            this.o.resText.setText("0");

        });

        JButton[] OperationButtons = {plus, times, minus, divide,
            sin, cos, exp, log, clear};

        for (JButton jb : OperationButtons) {
            jb.setPreferredSize(new Dimension(100, 50));
        }

        firstRow.add(plus);
        firstRow.add(times);
        firstRow.add(minus);
        firstRow.add(divide);

        secondRow.add(sin);
        secondRow.add(cos);
        secondRow.add(exp);
        secondRow.add(log);

        clearRow.add(clear);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(firstRow);
        this.add(secondRow);
        this.add(clearRow);
    }
}
