package aufgabe9;

import java.util.Map;
import java.util.Set;

public interface Expression {
    double eval(Map<String, Double> varBel);
//    Set<String> getVars();
}
