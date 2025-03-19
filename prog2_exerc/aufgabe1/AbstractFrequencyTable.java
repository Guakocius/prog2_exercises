package aufgabe1;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
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
		// Ihr Code:
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable fq) {
		// Ihr Code:
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		// Ihr Code:

		return s.toString();
	}
}
