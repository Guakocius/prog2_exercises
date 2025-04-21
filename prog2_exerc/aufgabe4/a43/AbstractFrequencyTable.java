package a43;

import java.util.Iterator;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */

public abstract class AbstractFrequencyTable<T> implements FrequencyTable<Word>  {

    FrequencyTable<Word> fq;
    
    Iterator<Word> abstractIterator = this.iterator();

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
    public void add(String w) {
		add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable<Word> fq) {
        Iterator<Word> iterator = fq.iterator(); 
        if (!fq.isEmpty()) {
            while (iterator.hasNext()) {
                Word word = iterator.next();
                this.add(word.getWord(), word.getFrequency());
                
            }
        }
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable<? super Word> fq) {
        fq.clear();
        if (this.size() < n) {
            fq.addAll((FrequencyTable<Word>) this);
        } else {
            for (int i = 0; i < n; i++) {
                Word word = abstractIterator.next();
                fq.add(word.getWord(), word.getFrequency());
            }
        }
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		
        while (abstractIterator.hasNext()) {
            Word word = abstractIterator.next();
            String w = word.getWord();
            s.append(w);
            s.append(", ");
        }
        s.append("} size = ").append(this.size());
		return s.toString();
    }

    @Override
    public Iterator<Word> iterator() {
        return new Iterator<Word>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size();
            }
            
            @Override
            public Word next() {
                return get(current++);
            }
        };
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

