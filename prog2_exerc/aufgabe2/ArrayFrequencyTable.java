package aufgabe2;

import java.util.Arrays;

/**
 *
 * @author Alexander Engelhardt
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
        fqTable = new Word[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        if (size >= fqTable.length) {
            fqTable = Arrays.copyOf(fqTable, size * 2);}

       Word word = new Word(w, f);
        if (size == 0) {
            fqTable[0] = word;
            size++;
        } else if (size > 0) {
            int c = 0;
            for (Word wo : fqTable) {
                if (c == size) {
                    fqTable[size] = word;
                    sort(size);
                    size++;
                    break;
                } else if (wo == null) {
                    break;
                } else if (wo.getWord().equals(w)) {
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
        return fqTable[pos];
    }

    @Override
    public int get(String w) {
        for (Word word : fqTable) {
            if (word == null) {
                continue;
            } else if (word.getWord().equals(w)) {
                return word.getFrequency();
            }
        }
        return 0;
    }


    public void sort(int pos) {
        while (pos != 0 && fqTable[pos].getFrequency() > fqTable[pos - 1].getFrequency()) {
            Word temp = fqTable[pos];
            fqTable[pos] = fqTable[pos - 1];
            fqTable[pos - 1] = temp;
            pos--;
        }
    }
}
