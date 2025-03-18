package intro;

/**
 * Klasse zum Arbeiten mit Kreisen in der Ebene.
 *
 * @author Oliver Bittel; 05.10.2018
 * @author Oliver Haase; 30.09.2024
 */
public class CircleWSq implements Circle {

    /**
     * Konstante pi.
     */
    private final double pi = 3.14;
    /**
     * x-Koord. des LUP.
     */
    private double lupX = 0;
    /**
     * y-Koord. des LUP.
     */
    private double lupY = 0;
    /**
     * Radius.
     */
    private double len = 1;

    /**
     * Default Konstruktor.
     */
    public CircleWSq() { }

    /**
     * Kreiskonstruktor mit Parameter.
     * @param x x-Komponente des lup.
     * @param y y-Komponente des lup.
     * @param a Seteinlaenge des umfassenden Rechtecks.
     */
    public CircleWSq(final double x,
            final double y, final double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Seitenlaenge "
                + "darf nicht negativ sein");
        }
        lupX = x;
        lupY = y;
        len = a;
    }


    public final void resize(final double f) {
        // Das Werfen von RunTimeExceptions muss NICHT deklariert werden;
        // das Java-Tutorial empfiehlt das Werfen von RuntimeExceptions 
        // wenn z.B. eine Methode mit falschen Parametern aufgerufen wird.
        // download.oracle.com/javase/tutorial/essential/exceptions/runtime.html
        if (f < 0) {
            throw new IllegalArgumentException("Skalierungsfaktor darf "
                + "nicht negativ sein");
        }
        len *= f;
    }

    
    public final void move(final double x, final double y) {
        lupX += x;
        lupY += y;
    }

    
    public final double getArea() {
        return pi * len * len  / 4;
    }
}

