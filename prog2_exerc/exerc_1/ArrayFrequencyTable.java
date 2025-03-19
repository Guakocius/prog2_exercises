package aufgabe1;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
    private int size = 0;
    private Word[] fqTable;
    private final int DEFAULT_SIZE = 100;

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        // throw muss auskommentiert werden!
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        // ...
    }

    @Override
    public void add(String w, int f) {
        // throw muss auskommentiert werden!
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        // ...
    }

    @Override
    public Word get(int pos) {
        // throw muss auskommentiert werden!
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        // ...
    }

    @Override
    public int get(String w) {
        // throw muss auskommentiert werden!
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        // ...
    }
}
