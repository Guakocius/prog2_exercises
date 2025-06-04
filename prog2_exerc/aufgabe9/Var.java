package aufgabe9;

import java.util.Map;

public class Var implements Expression {
    public final String name;
    public Var(String name) {
        this.name = name;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return 1.0;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
