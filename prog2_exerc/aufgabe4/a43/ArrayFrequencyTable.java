package a43;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size = 0;
    private Word[] fqTable;
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
            fqTable = Arrays.copyOf(fqTable, size * 2);
        }

       Word word = new Word(w, f);

        if (size == 0) {
            fqTable[0] = word;
            size++;
            return;

        } else if (size > 0) {
        Iterator<?> iterator = Arrays.asList(fqTable).subList(0, size).iterator();
        int c = 0;
        while (iterator.hasNext()) {
            Word wo = (Word) iterator.next();
            if (wo.getWord().equals(w)) {
                fqTable[c].addFrequency(f);
                if (c > 0) {
                    sort(c);
                }
                return;
            }
            c++;
        }
    }
}

@Override
    public void add(T w, int f) {
        if (size >= fqTable.length) {
            fqTable = Arrays.copyOf(fqTable, size * 2);
        }

        
        Word w2 = (Word) w;
        Word word = new Word(w2.getWord(), f);
        
        if (size == 0) {
            fqTable[0] = word;
            size++;
            return;

        } else if (size > 0) {
        Iterator<?> iterator = Arrays.asList(fqTable).subList(0, size).iterator();
        int c = 0;
        while (iterator.hasNext()) {
            Word wo = (Word) iterator.next();
            if (wo.getWord().equals(w)) {
                fqTable[c].addFrequency(f);
                if (c > 0) {
                    sort(c);
                }
                return;
            }
            c++;
        }
    }
}


    @Override
    public Word get(int pos) {
        Iterator<Word> iterator = Arrays.asList(fqTable).subList(0, size).iterator();
        Word word = iterator.next();
        while (iterator.hasNext()) {
            if (word == null) {
                continue;
            } else if (word.getWord().equals(fqTable[pos].getWord())) {
                return word;
            }
        }
        return null;
    }

    /*@Override
    public int get(Word w) {
        Iterator<Word> iterator = Arrays.asList(fqTable).subList(0, size).iterator();
        Word word = iterator.next();
        while (iterator.hasNext()) {
            if (word == null) {
                continue;
            } else if (word.getWord().equals(w.getWord())) {
                return word.getFrequency();
            }
        }
        return 0;
    }*/

    @Override
    public int get(String w) {
        Iterator<T> iterator = (Iterator<T>) Arrays.asList(fqTable).subList(0, size).iterator();
        Word word = (Word) iterator.next();
        while (iterator.hasNext()) {
            if (word == null) {
                continue;
            } else if (word.getWord().equals(w)) {
                return word.getFrequency();
            }
        }
        return 0;
    }

    public int get(T w) {
        Iterator<T> iterator = (Iterator<T>) Arrays.asList(fqTable).subList(0, size).iterator();
        Word word = (Word) iterator.next();
        while (iterator.hasNext()) {
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

    /*@Override
    public void add(T w, int f) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(String w) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/

    
}
