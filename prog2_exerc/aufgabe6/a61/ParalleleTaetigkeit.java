package a61; 

/**
 * ParalleleTaetigkeit
 */
public class ParalleleTaetigkeit extends ZusammengesetzteTaetigkeit {

    public ParalleleTaetigkeit() {
        super();
    }

    @Override
    public double getTime() {
        double maxTime = 0.0;
        for (Taetigkeit tk : meineTaetigkeiten) {
            if (tk.getTime() >= maxTime) {
                maxTime = tk.getTime();
            }
        }
        return maxTime;
    }
}
