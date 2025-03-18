package intro;

/**
 * Testprogramm fuer Kreisklassen.
 *
 * @author Oliver Bittel; 05.10.2018
 * @author Oliver Haase; 30.09.2024
 */

public final class CircleApplication {

    /**
     * Privater Konstruktor, da rein statische Klasse.
     */
    private CircleApplication() { }

    /**
     * @param args wird nicht benutzt.
     */
    public static void main(final String[] args) {
        Circle k1 = new CircleWRad();
        k1.resize(2);
        k1.move(-3, -3);
        Circle k2 = new CircleWSq(2, 3, 3);
        System.out.println(k1.getArea());
        k2.move(1, 1);
        System.out.println(k2.getArea());
    }

}
