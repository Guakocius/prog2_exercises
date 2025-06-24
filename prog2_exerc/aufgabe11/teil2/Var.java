package aufgabe11.teil2;

import java.util.Map;

public class Var implements Expression {
    public final String name;
    public Var(String name) {
        this.name = name;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        if (varBel.containsKey(this.name)) {
            Double val = varBel.get(name);
            return (val != null)? val : 0.0;
        }
        return 0.0;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
