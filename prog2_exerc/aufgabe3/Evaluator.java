/*
 * class Evaluator
 * repl-Schleife: lese von der Konsole eine Ziele und
 * werte sie als arithmetischen Ausdruck aus.
 *
 * O. Bittel; 22.03.2018
 * Verbeserung am 11.04.2018: +,-, *, / müssen linksassozoativ sein.
 * Geändert am 13.4.2018: da KEYWORS String-Konstante sind,
 * reicht Gleichheitsprüfung mit ==.
 *
 */
package aufgabe3;

import static aufgabe3.Tokenizer.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */
/**
 * Klasse zum Auswerten von arithmetischen Ausdrücken.
 */
public class Evaluator {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static Object[] stack;		    // Stack
    private static int size;	    				// Index des obersten Kellerelements
    private static Object token;					// Aktuelles Token
    private static Tokenizer tokenizer;			// Zerlegt String-Eingabe in Tokens

    public Evaluator() {
        stack = new Object[20];
        size = 0;
    }
    static final Evaluator e = new Evaluator();
    //static final Tokenizer t = new Tokenizer(e.token.toString());
    /**
     * Wertet expr als arithmetischen Ausdruck aus.
     *
     * @param expr Arthmetischer Ausdruck als String
     * @return Wert des Ausdrucks oder null, falls der Ausdruck fehlerhaft ist.
     */
    public static Double eval(String expr) {
        // Dollar in leeren Stack ablegen:
        size = 0;
        stack[size++] = DOLLAR;

        // expr in Tokens zerlegen und erstes Token abholen:
        tokenizer = new Tokenizer(expr);
        token = tokenizer.nextToken();

        while (token != null) {
            // System.out.println("token = " + token);
            if (shift()) { // Shift durchführen, falls möglich
                continue;
            } else if (reduce()) { // Reduce durchführen, falls möglich
                continue;
            } else if (accept()) { // prüfen ob Ausdruck erfolgreich evaluiert wurde
                return (Double) stack[size - 1];
            } else {
                return null; // Fehler beim Auswerten
            }
        }
        return null; // Fehler beim Auswerten
    }

    private static boolean shift() {
        boolean tokenCheck = (token == KL_AUF || isVal(token));
        if ((stack[size - 1] == DOLLAR && tokenCheck) || (isOp(stack[size - 1]) && tokenCheck)
            || (stack[size - 1] == KL_AUF && tokenCheck)) {		// Regel 1, 2 + 3 der Parser-Tabelle
            doShift();
            return true;
        }
        else if (stack[size - 2] == DOLLAR && isVal(stack[size - 1]) && isOp(token)) { // Regel 6 der Parser-Tabelle
            doShift();
            return true;
        }
        else if (stack[size - 2] == KL_AUF && isVal(stack[size - 1]) &&
            (isOp(token) || token == KL_ZU)) { // Regel 7 der Parser-Tabelle
            doShift();
            return true;
        }
        else {
            return false;
        }
    }

    private static void doShift() {
        if (size >= stack.length) {
            stack = Arrays.copyOf(stack, size * 2);
        }
        stack[size++] = token;
        token = tokenizer.nextToken();
    }

    private static boolean isOp(Object o) {
        return (o == PLUS || o == MULT || o == POWER);
    }

    private static boolean isVal(Object o) {
        return o instanceof Double;
    }

    private static boolean reduce() {
        if (size < 4) {
            return false;
        }

        if (stack[size - 3] == KL_AUF && isVal(stack[size - 2]) && stack[size - 1] == KL_ZU
                && (token == KL_ZU || isOp(token) || token == DOLLAR)) {        // Regel 4 der Parser-Tabelle
            doReduceKlValKl();
            return true;
        } else if (isVal(stack[size - 3]) && isOp(stack[size - 2]) && isVal(stack[size - 1])
                && (token == KL_ZU || token == DOLLAR)) {            // Regel 8 der Parser-Tabelle
            doReduceValOpVal();
            return true;
        } else if (isVal(stack[size - 3]) && isOp(stack[size - 2])
                && isVal(stack[size - 1]) && isOp(token)) {                  // Regel 9 der Parser-Tabelle
            if (token != PLUS && stack[size - 2] == PLUS) {
                doShift();
                return true;
            }
            else if (token == POWER && stack[size - 2] == POWER) {
                doShift();
                return true;
            }
            else {
                doReduceValOpVal();
                return true;
            }
        } else {
            return false;
        }
    }

    private static void doReduceKlValKl() {
        Object d = stack[size - 2];
        stack[size-3] = d;
        stack[size-2] = null;
        stack[size-1] = null;
        size -= 2;
    }

    private static void doReduceValOpVal() {
        if (stack[size - 2]==PLUS) {
            Object add = (Double)stack[size - 3] + (Double)stack[size - 1];
            stack[size - 3] = add;
        } else if (stack[size - 2]==MULT) {
            Object mult = (Double)stack[size - 3] * (Double)stack[size - 1];
            stack[size - 3] = mult;
        } else if (stack[size - 2]==POWER){
            Object p = (Double)stack[size - 3];
            Object power = p;
            int l = ((Double) stack[size - 1]).intValue();
            for (int i = 0; i < l - 1; i++) {
                power = (Double)power * (Double)p;
            }
            stack[size - 3] = power;
        }
        stack[size - 2] = token;
        stack[size - 1] = null;
        size -= 2;
    }

    private static boolean accept() {
        if (size == 2) {
            if (stack[size - 2] == DOLLAR && isVal(stack[size - 1]) && token == DOLLAR) {
                return true;
            }
        }
        return false;
    }

    /**
     * Liest von der Konsole eine Folge von Zeilen, wertet jede Zeile als
     * Ausdruck aus und gibt seinen Wert aus. (repl = read-evaluate-print-loop).
     */
    public static void repl() {
        Scanner in = new Scanner(System.in);
        System.out.print(ANSI_BLUE + ">> ");

        while (in.hasNextLine()) {
            String line = in.nextLine();
            // Ihr Code:
            // ...
            if (line.equals("end")) {
                System.out.println("bye!");
                return;
            }
            else if (eval(line)==null) System.out.println("!!! error");
            else {
                System.out.println(eval(line));
            }
            System.out.print(ANSI_BLUE + ">> ");
        }
        in.close();
    }

    /**
     * Testprogramm.
     *
     * @param args wird nicht benutzt.
     */
    public static void main(String[] args) {
        // Zum Testen, später auskommentieren:
        // String s1 = "1+2";
        // String s2 = "2^10+5";
        // String s3 = "5+2^10";
        // String s4 = "(2+3*4+4)^2";
        // String s5 = "(2+3*4+4))*2";
        // String s6 = "2+3**4";
        // String s7 = "2^2^3";
        // String s8 = "2^2*5";
        // String s9 = "1+(2+(3+(4+(5+6))))";
        // String s10 = "1+2+3+4+5+6";

        Evaluator evaluator = new Evaluator();

        // System.out.println(evaluator.eval(s1));	// 3.0
        // System.out.println(evaluator.eval(s2));	// 1029.0
        // System.out.println(evaluator.eval(s3));	// 1029.0
        // System.out.println(evaluator.eval(s4));	// 324.0
        // System.out.println(evaluator.eval(s5));	// null; Syntaxfehler
        // System.out.println(evaluator.eval(s6));	// null; Syntaxfehler
        // System.out.println(evaluator.eval(s7));	// 256.0
        // System.out.println(evaluator.eval(s8));	// 20.0
        // System.out.println(evaluator.eval(s9));	// 21.0
        // System.out.println(evaluator.eval(s10));	// 21.0

        evaluator.repl();
    }
}
