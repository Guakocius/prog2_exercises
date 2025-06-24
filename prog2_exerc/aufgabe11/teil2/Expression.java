package aufgabe11.teil2;

import java.util.Map;

public interface Expression {
    double eval(Map<String, Double> varBel);
//    Set<String> getVars();
    @Override
    String toString();
}
