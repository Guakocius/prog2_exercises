package aufgabe11.teil1;

import java.awt.FlowLayout;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Functions extends JPanel {

    Operand o = new Operand();

    public Functions(Operand o) {
        this.o = o;

        Function<Double, Double> f = l -> l + Double.parseDouble(
            o.xText.getText());
        BiFunction<Double, Double, Double> g = (x, y) -> x * y;

        JButton fButton = new JButton("f(x)");
        JButton gButton = new JButton("g(x, y)");

        fButton.addActionListener(e -> {
            o.resText.setText(Double.toString(f.apply(Math.random())));
        });

        gButton.addActionListener(e -> {
            o.resText.setText(Double.toString(g.apply(Double.parseDouble(
            o.xText.getText()), Double.parseDouble(
            o.yText.getText()))));
        });

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 0, 0));

        buttonPanel.add(fButton);
        buttonPanel.add(gButton);

        this.add(buttonPanel);

    }

}
