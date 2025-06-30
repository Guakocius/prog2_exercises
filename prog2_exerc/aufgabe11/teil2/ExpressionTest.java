package aufgabe11.teil2;

import java.util.Map;
import java.util.TreeMap;

/**
 * Testprogramm für Aufgabe 9 (Bäume für arithmetische Ausdrücke).
 *
 * @author oliverbittel
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 * @since 11.12.2019
 *
 * @author Oliver Haase
 */
public class ExpressionTest {

        public static void main(String[] args) {
                Var n = new Var("n"); // Variable n
                Var a = new Var("a"); // Variable a
                Var b = new Var("b"); // Variable b
                Var c = new Var("c"); // Variable c
                Constant one = new Constant(1.0); // Konstante 1.0
                Constant two = new Constant(2.0); // Konstante 2.0
                Constant three = new Constant(3.0); // Konstante 2.0

                // Ausdruck e1 = a*a + b*b
                Expression e1 = new Sum(
                                new Product(a, a),
                                new Product(b, b));

                // Ausdruck e2 = n*(n+1)/2
                Expression e2 = new Quotient(
                                new Product(n, new Sum(n, one)),
                                two);

                // Ausdruck e3 = (a+b+c)/3
                Expression e3 = new Quotient(
                                new Sum(
                                                new Sum(a, b),
                                                c),
                                three);

                // Audruck e4 = a + (b + c)
                Expression e4 = new Sum(
                                a,
                                new Sum(b, c)); // Vorsicht: Sie müssen e4 noch definieren.
                Expression e5 = new F(
                                two,
                                n);
                Expression e6 = new G(
                                new Sum(
                                                n,
                                                three),
                                two);

                // Belegung alle Variablen als Map:
                Map<String, Double> varBel = new TreeMap<>();
                varBel.put("a", 3.0);
                varBel.put("b", 4.0);
                varBel.put("c", 8.0);
                varBel.put("n", 10.0);

                // evaluieren
                System.out.println(e1.eval(varBel)); // 25.0
                System.out.println(e2.eval(varBel)); // 55.0
                System.out.println(e3.eval(varBel)); // 5.0
                System.out.println(e4.eval(varBel)); // 15.0
                System.out.println(e5.eval(varBel));
                System.out.println(e6.eval(varBel));

                // Variablenbelegung ändern
                varBel.put("b", 1.0);
                System.out.println();

                // mit geänderter Variablenbelegung erneut evaluieren
                System.out.println(e1.eval(varBel)); // 10.0
                System.out.println(e2.eval(varBel)); // 55.0
                System.out.println(e3.eval(varBel)); // 4.0
                System.out.println(e4.eval(varBel)); // 12.0
                System.out.println(e5.eval(varBel));
                System.out.println(e6.eval(varBel));
                System.out.println();
                // Alle Variablen in e1:
                // System.out.println(e1.getVars()); // [a, b]
                // System.out.println(e2.getVars()); // [n]
                // System.out.println(e3.getVars()); // [a, b, c]
                // System.out.println(e4.getVars()); // [a, b, c]

                // Pruefe, ob alle Variablen in e1 belegt sind:
                // System.out.println(varBel.keySet().containsAll(e1.getVars())); // true

                // e1 und e2 ausgeben (ueberschriebene toString-Methode):
                System.out.println(e1); // ((a * a) + (b * b))
                System.out.println(e2); // ((n * (n + 1.0)) / 2.0)
                System.out.println(e3); // (((a + b) + c) / 3.0)
                System.out.println(e4); // (a + (b + c))
                System.out.println(e5);
                System.out.println(e6);
        }
}
