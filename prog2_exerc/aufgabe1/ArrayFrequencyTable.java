package aufgabe1;

/**
 *
 * @author Alexander Engelhardt
 *
 * @author Timothy Drexler
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
        fqTable = new Word[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        
        // throw muss auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Word word = new Word(w, f);
        if (size == 0) {
            fqTable[0] = word;
            size++;
        } else {
            int c = 0;
            for (Word wo: fqTable) {
                if (w.equals(wo.getWord())) {
                    wo.addFrequency(f);
                } else if (c == size - 1) {
                    fqTable[size] = word;
                    size++;
                    bubbleSort(fqTable, size);
                }
                c++;
            }
        }
    }

    @Override
    public Word get(int pos) {
        // throw muss auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (size < pos + 1) {
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                if (i == pos) {
                    return fqTable[pos];
                }
            }
        }
        return null;
    }

    @Override
    public int get(String w) {
        // throw muss auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Word word: fqTable) {
            if (word.getWord().equals(w)) {
                return word.getFrequency();
            }
        }
        return 0;
    }
    public void bubbleSort(Word[] words, int size) {
        Word temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (words[j].getFrequency() < words[j + 1].getFrequency()) {
                    temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }
}
