package aufgabe11.teil2;

import java.util.Map;

public class Difference extends CompoundExpression {
    public Expression a, b;
    public Difference(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double eval(Map<String, Double> varBel) {
        return this.a.eval(varBel) - this.b.eval(varBel);
    }
    @Override
    public String toString() {
        return "(" + a.toString() + " - " + b.toString() + ")";
    }

}
