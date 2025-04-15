package a42;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size = 0;
    private List<Word<T>> fqTable;
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
        fqTable = new ArrayList<>(DEFAULT_SIZE);
        size = 0;
    }

    @Override
    public void add(Word<T> w, int f) {
        if (size >= fqTable.size()) {
            fqTable = new ArrayList<>(fqTable.size() * 2);
            fqTable.addAll(fqTable);
        }

       Word<T> word = new Word<T>((T) w, f);
        if (size == 0) {
            fqTable.get(0).add(word);
            size++;
        } else if (size > 0) {
            int c = 0;
            for (Word<? extends T> wo : fqTable) {
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
    public Word<T> get(int pos) {
        return fqTable[pos];
    }

    @Override
    public int get(T w) {
        for (Word<? extends T> word : fqTable) {
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
            Word<T> temp = fqTable[pos];
            fqTable[pos] = fqTable[pos - 1];
            fqTable[pos - 1] = temp;
            pos--;
        }
    }
}
