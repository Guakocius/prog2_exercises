package aufgabe6;


/**
 * Taetigkeit
 */
public interface Taetigkeit {

    double getTime();

    void add(Taetigkeit tk);

    void remove(Taetigkeit tk);

    int getAnzahl();

}
