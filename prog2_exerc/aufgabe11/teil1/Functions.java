package aufgabe11.teil1;

import java.lang.Math;
import java.awt.FlowLayout;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Functions extends JPanel {

    Function<Double, Double> f;
    BiFunction<Double, Double, Double> g;
    Operand o = new Operand();

    public Functions(Operand o, Function<Double, Double> f, BiFunction<Double, Double, Double> g) {

        JButton fButton = new JButton("f(x)");
        JButton gButton = new JButton("g(x, y)");

        final Operand op = o;
        final Function<Double, Double> ff = f;
        final BiFunction<Double, Double, Double> gg = g;

        fButton.addActionListener(e -> {
            Double x = Double.parseDouble(op.xText.getText());
            op.resText.setText(Double.toString(ff.apply(x)));
        });

        gButton.addActionListener(e -> {
            Double x = Double.parseDouble(op.xText.getText());
            Double y = Double.parseDouble(op.yText.getText());
            op.resText.setText(Double.toString(gg.apply(x, y)));
        });

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 0, 0));

        buttonPanel.add(fButton);
        buttonPanel.add(gButton);

        this.add(buttonPanel);

    }

}
