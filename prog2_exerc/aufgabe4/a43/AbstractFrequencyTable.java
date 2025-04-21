package a43;

import java.util.Iterator;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */

public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T>  {

    FrequencyTable<T> fq;


	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
    public void add(T w) {
	    add((String) w, 1);
    }

    @Override
    public void add(String w) {
        add(w, 1);
    }


	@Override
	public void addAll(FrequencyTable<? extends T> fq) {
        Iterator<? extends T> iterator = fq.iterator();
        if (!fq.isEmpty()) {
            while (iterator.hasNext() ) {
                if (iterator.next() instanceof Word) {
                    Word word = (Word) iterator.next();

                    this.add((String) word.getWord(), word.getFrequency());
                }
                else {
                    T w = iterator.next();
                    this.add(w);
                }
                
            }
        }
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable<? super T> fq) {
        Iterator<T> abstractIterator = this.iterator();
        fq.clear();
        if (this.size() < n) {
            fq.addAll(this);
        } else {
            for (int i = 0; i < n; i++) {
                Word word = (Word) abstractIterator.next();
                fq.add(word.getWord(), word.getFrequency());
            }
        }
	}

	@Override
	public String toString() {
        Iterator<T> abstractIterator = this.iterator();
		StringBuilder s = new StringBuilder("{");
		
        while (abstractIterator.hasNext() && abstractIterator.next() != null) {
            Word word = (Word) abstractIterator.next();
            String w = word.getWord();
            s.append(w);
            s.append(", ");
        }
        s.append("} size = ").append(this.size());
		return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size();
            }
            
            @Override
            public T next() {
                return (T) get(current++);
            }
        };
    }

    @Override
    public Word convertToWord(T w) {
        return (Word) w;
    }

    /*public class FqTableIterator implements Iterator<Word> {
        private int index = 0;
    
        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public Word next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(index++);
        }
    }*/
}

