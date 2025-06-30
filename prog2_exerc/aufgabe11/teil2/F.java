package aufgabe11.teil2;

import java.util.Map;
import java.util.function.Function;

public class F extends CompoundExpression {
    public Expression a, b;
    Function<Expression, Double> f;

    public F(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        f = a -> a.eval(varBel);
        return f.apply(this.a);
    }

    @Override
    public String toString() {
        return "(" + a.toString() + ")";
    }
}
