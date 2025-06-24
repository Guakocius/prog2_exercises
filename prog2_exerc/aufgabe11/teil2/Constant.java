package aufgabe11.teil2;

import java.util.Map;

public final class Constant implements Expression {
    public final double val;
    public Constant(double val) {
        this.val = val;
    }
    @Override
    public double eval(Map<String, Double> varBel) {
        return this.val;
    }
    @Override
    public String toString() {
        return Double.toString(this.val);
    }

}
