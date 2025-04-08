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

import java.util.Scanner;

import static aufgabe3.Tokenizer.*;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
 */

/**
 * Klasse zum Auswerten von arithmetischen Ausdrücken.
 */
public class Evaluator {

    private static final String ANSI_BLUE = "\u001B[34m";
    private final Object[] stack;		    // Stack
    private int size;	    				// Index des obersten Kellerelements
    private Object token;					// Aktuelles Token
    private Tokenizer tokenizer;			// Zerlegt String-Eingabe in Tokens

    public Evaluator() {
        stack = new Object[20];
        size = 0;
    }


    /**
     * Wertet expr als arithmetischen Ausdruck aus.
     *
     * @param expr Arthmetischer Ausdruck als String
     * @return Wert des Ausdrucks oder null, falls der Ausdruck fehlerhaft ist.
     */
    public Double eval(String expr) {
        // Dollar in leeren Stack ablegen:
        size = 0;
        stack[size++] = DOLLAR;

        // expr in Tokens zerlegen und erstes Token abholen:
        tokenizer = new Tokenizer(expr);
        token = tokenizer.nextToken();

        while (token != null) {
            //System.out.println("token = " + token);
            if (shift()) { // Shift durchführen, falls möglich
                continue;
            } else if (reduce()) { // Reduce durchführen, falls möglich
                continue;
            } else if (accept()) { // prüfen ob Ausdruck erfolgreich evaluiert wurde
                return (Double) stack[size -1];
            } else {
                return null; // Fehler beim Auswerten
            }
        }
        return null; // Fehler beim Auswerten
    }

    private boolean shift() {
        if (stack[size -1] == DOLLAR && (token == KL_AUF || isVal(token))) {		// Regel 1 der Parser-Tabelle
            doShift();
            return true;
        } // Ihr Code:
        // ...
        else {
            return false;
        }
    }

    private static void doShift() {
        // Ihr Code:
        // ...
    }

    private boolean isOp(Object o) {
        return (o == PLUS || o == MULT || o == POWER);
    }

    private boolean isVal(Object o) {
        return o instanceof Double;
    }

    private boolean reduce() {
        if (size < 4) {
            return false;
        }

        if (stack[size - 3] == KL_AUF && isVal(stack[size - 2]) && stack[size -1] == KL_ZU
                && (token == KL_ZU || isOp(token) || token == DOLLAR)) {         // Regel 4 der Parser-Tabelle			
            doReduceKlValKl();
            return true;
        } // Ihr Code:
        // ...

        else {
            return false;
        }
    }

    private static void doReduceKlValKl() {
        // Ihr Code:
        // ...
    }

    private static void doReduceValOpVal() {
        // Ihr Code:
        // ...
    }

    private static boolean accept() {
        // Ihr Code:
        // ...
        return false;
    }

    /**
     * Liest von der Konsole eine Folge von Zeilen, wertet jede Zeile als
     * Ausdruck aus und gibt seinen Wert aus. (repl = read-evaluate-print-loop).
     */
    public void repl() {
        Scanner in = new Scanner(System.in);
        System.out.print(ANSI_BLUE + ">> ");

        while (in.hasNextLine()) {
            String line = in.nextLine();
            // Ihr Code:
            // ...
            System.out.print(ANSI_BLUE + ">> ");
        }
    }

    /**
     * Testprogramm.
     *
     * @param args wird nicht benutzt.
     */
    public static void main(String[] args) {
        // Zum Testen, später auskommentieren:
		String s1 = "1+2";
		String s2 = "2^10+5";
		String s3 = "5+2^10";
        String s4 = "(2+3*4+4)^2";
        String s5 = "(2+3*4+4))*2";
        String s6 = "2+3**4";
        String s7 = "2^2^3";
        String s8 = "2^2*5";
        String s9 = "1+(2+(3+(4+(5+6))))";
        String s10 = "1+2+3+4+5+6";

        Evaluator evaluator = new Evaluator();

		System.out.println(evaluator.eval(s1));	// 3.0
		System.out.println(evaluator.eval(s2));	// 1029.0
        System.out.println(evaluator.eval(s3));	// 1029.0
        System.out.println(evaluator.eval(s4));	// 324.0
        System.out.println(evaluator.eval(s5));	// null; Syntaxfehler
        System.out.println(evaluator.eval(s6));	// null; Syntaxfehler
        System.out.println(evaluator.eval(s7));	// 64.0
        System.out.println(evaluator.eval(s8));	// 20.0
        System.out.println(evaluator.eval(s9));	// 21.0
        System.out.println(evaluator.eval(s10));	// 21.0

        //repl();
    }
}
