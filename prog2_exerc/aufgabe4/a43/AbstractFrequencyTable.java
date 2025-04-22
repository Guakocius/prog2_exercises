package a43;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */

public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
    public void add(T w) {
		add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable<? extends T> fq) {
        if (!fq.isEmpty()) {
            // for (int i = 0; i < fq.size(); i++) {
            //     this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
            // }
            for (var wo : fq) {
                this.add(wo.getWord(), wo.getFrequency());
            }
        }
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable<? super T> fq) {
        fq.clear();
        if (this.size() < n) {
            fq.addAll(this);
        } else {
            // for (int i = 0; i < n; i++) {
            //     fq.add(this.get(i).getWord(), this.get(i).getFrequency());
            // }
            for (int i = 0; i < n; i++){
                Word<? extends T> wo = this.get(i);
                fq.add(wo.getWord(), wo.getFrequency());
            } 
        }
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		// Ihr Code:

        for (int i = 0; i < this.size(); i++) {
            String w = this.get(i).toString();
            s.append(w);
            s.append(", ");
        }
        s.append("} size = ").append(this.size());
		return s.toString();
    }
}
