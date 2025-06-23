package aufgabe10;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Operations extends JPanel {

    private Operand o = new Operand();

    private boolean isNumber(String text) {
        try {
            Double value;
            if (text.equals("")) {
                value = 0.0;
            }

            value = Double.parseDouble(text);
            return true;

        } catch (NumberFormatException e) {
            System.err.printf("%s ist keine Zahl!\n", text);
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

            if (!isNumber(xText) | !isNumber(yText)) {
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

            if (!isNumber(xText) || !isNumber(yText)) {
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

            if (!isNumber(xText) | !isNumber(yText)) {
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

            if (!isNumber(xText) | !isNumber(yText)) {
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

            if (!isNumber(xText) | !isNumber(yText)) {
                this.o.resText.setText("");
                return;
            }
            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }
            this.o.yText.setText(yText);
            this.o.resText.setText(Double.toString(Math.sin(valueX)));
            System.out.println("Sin isDeg: " + settings.isDeg);
            if (settings.isDeg) {
                settings.toDeg(o);
            } else {
                settings.toRad(o);
            }
        });

        cos.addActionListener(e -> {
            double valueX = 0;
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();
            yText = "0";

            if (!isNumber(xText) | !isNumber(yText)) {
                this.o.resText.setText("");
                return;
            }
            if (!this.o.xText.getText().equals("")) {
                valueX = Double.parseDouble(this.o.xText.getText());
            }
            this.o.yText.setText(yText);
            this.o.resText.setText(Double.toString(Math.cos(valueX)));
            System.out.println("Cos isDeg: " + settings.isDeg);
            if (settings.isDeg) {
                settings.toDeg(this.o);
            } else {
                settings.toRad(this.o);
            }
        });

        exp.addActionListener(e -> {
            double valueX = 0, valueY = 0;
            String xText = this.o.xText.getText(), yText = this.o.yText.getText();

            if (!isNumber(xText) | !isNumber(yText)) {
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

            if (!isNumber(xText) | !isNumber(yText)) {
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
            jb.setPreferredSize(new Dimension(70, 40));
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
