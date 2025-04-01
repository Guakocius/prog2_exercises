package aufgabe2;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */

public abstract class AbstractFrequencyTable implements FrequencyTable {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
    public void add(String w) {
		add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable fq) {
        if (!fq.isEmpty()) {
            for (int i = 0; i < fq.size(); i++) {
                String word = fq.get(i).getWord();
                int freq = fq.get(word);
                this.add(word, freq);
            }
        }
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable fq) {
        fq.clear();
        if (this.size() < n) {
            fq.addAll(this);
        } else {
            for (int i = 0; i < n; i++) {
                String word = this.get(i).getWord();
                int freq = this.get(word);
                fq.add(word, freq);
            }
        }
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		// Ihr Code:

        for (int i = 0; i < this.size(); i++) {
            s.append(this.get(i).toString());
            s.append(", ");
        }
        s.append("} size = " + this.size());
		return s.toString();
	}
}
