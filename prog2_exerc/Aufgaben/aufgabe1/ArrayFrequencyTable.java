package aufgabe1;

import java.util.Objects;

/**
 *
 * @author Alexander Engelhardt
 *
 * @author Timothy Drexler
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
    private int size = 0;
    private Word[]  fqTable;
    private static final int DEFAULT_SIZE = 100;

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
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        fqTable = new Word[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Word word = new Word(w, f);
        if (size == 0) {
            fqTable[0] = word;
            size++;
        } else if (size > 0) {
            int c = 0;
            
            for (Word wo : fqTable) {
                if (c == size && (size + 1) <= DEFAULT_SIZE) {
                    fqTable[size] = word;
                    sort(size);
                    size++;
                    break;
                } else if (wo == null) {
                    break;
<<<<<<< HEAD:prog2_exerc/aufgabe1/ArrayFrequencyTable.java
                } else if (Objects.requireNonNull(wo.getWord().equals(w))) {
=======
                } else if (wo.getWord().equals(w)) {
>>>>>>> 196ed65 (added my changes):prog2_exerc/Aufgaben/aufgabe1/ArrayFrequencyTable.java
                    fqTable[c].addFrequency(f);
                    if (c > 0) {
                        sort(c);
                    }
                    break;
                }
                c++;
            }
        }
        
    }

    @Override
    public Word get(int pos) {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
<<<<<<< HEAD:prog2_exerc/aufgabe1/ArrayFrequencyTable.java
        
=======
>>>>>>> 196ed65 (added my changes):prog2_exerc/Aufgaben/aufgabe1/ArrayFrequencyTable.java
        return fqTable[pos];
    }

    @Override
    public int get(String w) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Word word : fqTable) {
            if (word == null) {
                continue;
            } else if (word.getWord().equals(w)) {
                return word.getFrequency();
            }
        }
        return 0;
    }
<<<<<<< HEAD:prog2_exerc/aufgabe1/ArrayFrequencyTable.java
    public void sort(int size) {
        Word temp;
        try {
            while (size != 0 && fqTable[size].getFrequency() > fqTable[size - 1].getFrequency()) {
                temp = fqTable[size];
                fqTable[size] = fqTable[size - 1];
                fqTable[size - 1] = temp;
                size--;
            }
        } catch (Exception e) {
            throw new NullPointerException();
=======

    public void sort(int pos) {
        while (pos != 0 && fqTable[pos].getFrequency() > fqTable[pos - 1].getFrequency()) {
            Word temp = fqTable[pos];
            fqTable[pos] = fqTable[pos - 1];
            fqTable[pos - 1] = temp;
            pos --;
>>>>>>> 196ed65 (added my changes):prog2_exerc/Aufgaben/aufgabe1/ArrayFrequencyTable.java
        }
        
          
    }
}
