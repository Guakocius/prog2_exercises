package intro;

/**
 * Klasse zum Arbeiten mit Kreisen in der Ebene.
 *
 * @author Oliver Bittel; 05.10.2018
 * @author Oliver Haase; 30.09.2024
 * 
 */
public class CircleWRad implements Circle {

    /**
     * Konstante pi.
     */
    private final static double pi = 3.14;
    /**
     * x-Koord. des Mittelpunkts.
     */
    private double mx = 0;
    /**
     * y-Koord. des Mittelpunkts.
     */
    private double my = 0;
    /**
     * Radius.
     */
    private double radius = 1;

    /**
     * DEfault Konstruktor.
     */
    public CircleWRad() { }

    /**
     * Kreiskonstruktor mit Parameter.
     * @param x x-Komponente des Mittelpunkts.
     * @param y y-Komponente des Mittelpunkts.
     * @param r Radius.
     */
    public CircleWRad(final double x,
            final double y, final double r) {
        if (r < 0) {
            throw new IllegalArgumentException("Radius darf "
                    + "nicht negativ sein");
        }
        mx = x;
        my = y;
        radius = r;
    }

    public final void resize(final double f)  {
        if (f < 0) {
            throw new IllegalArgumentException("Skalierungsfaktor "
                    + "darf nicht negativ sein");
        }
        radius *= f;
    }

    public final void move(final double x, final double y) {
        mx += x;
        my += y;
    }

    public final double getArea() {
        return pi * radius * radius;
    }
}
