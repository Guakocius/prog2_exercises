package aufgabe11.teil2;

import java.util.Map;
import java.util.function.BiFunction;

public class G extends CompoundExpression {
    public Expression a, b;
    BiFunction<Expression, Expression, Double> g;

    public G(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        g = (a, b) -> a.eval(varBel) % b.eval(varBel);
        return g.apply(this.a, this.b);
    }

    @Override
    public String toString() {
        return "(" + a.toString() + " mod " + b.toString() + ")";
    }
}
