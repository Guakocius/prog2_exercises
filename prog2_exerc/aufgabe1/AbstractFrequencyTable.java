package aufgabe1;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */

 // TODO: Implement void collectNMostFrequent(int n, FrequencyTable fq);
 
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
				String w = fq.get(i).getWord();
				int f = fq.get(w);
				this.add(w, f);
			}
		}
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable fq) {
		if (!fq.isEmpty()) {
			fq.clear();
			if (this.size() < n) {
				fq.addAll(this);
			} else {
				for (int i = 0; i < n; i++) {
					String w = this.get(i).getWord();
					int f = this.get(w);
					fq.add(w, f);
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		
		for (int i = 0; i < this.size(); i++) {
			s.append(get(i).getWord());
			s.append(":");
			s.append(get(i).getFrequency());
			s.append(", ");
		}
		s.append("} size = ");
		s.append(this.size());
		//s.append()
		return s.toString();
	}
}
