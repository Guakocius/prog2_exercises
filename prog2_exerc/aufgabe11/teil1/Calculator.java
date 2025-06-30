package aufgabe11.teil1;

import java.util.function.BiFunction;
import java.util.function.Function;

import javax.swing.*;

public class Calculator extends JFrame {

    public final int WIDTH = 400;
    public final int HEIGHT = 600;

    Operand o;
    Functions fn;
    Function<Double, Double> f;
    BiFunction<Double, Double, Double> g;

    public Calculator(Function<Double, Double> f, BiFunction<Double, Double, Double> g) {

        this.f = f;
        this.g = g;

        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);

        o = new Operand();
        Operations op = new Operations(o);
        Settings settings = new Settings(o);
        fn = new Functions(o, f, g);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        contentPanel.add(o);
        contentPanel.add(settings);
        contentPanel.add(op);
        contentPanel.add(fn);

        this.add(contentPanel);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        Function<Double, Double> f = x -> {
            Double l = Math.random();
            return l + x;
        };
        BiFunction<Double, Double, Double> g = (x, y) -> x * y;

        new Calculator(f, g);
    }

}
