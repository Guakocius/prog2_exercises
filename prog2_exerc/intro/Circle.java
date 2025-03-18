package intro;


/**
 * Interface Circle.
 *
 * @author Oliver Bittel; 05.10.2018
 * @author Oliver Haase; 30.09.2024
 */
public interface Circle {
    /**
     * Veraendert Kreisgroesse um Faktor f.
     * @param f Vergroesserungs-Faktor
     */
    void resize(final double f);

    /**
     * Verschiebt Kreis.
     * @param x Verschiebungsanteil in x-Richtung.
     * @param y Verschiebungsanteil in y-Richtung.
     */
    void move(final double x, final double y);

    /**
     * Kreisflaeche berechnen.
     * @return Kreisflaeche.
     */
    double getArea();
}
