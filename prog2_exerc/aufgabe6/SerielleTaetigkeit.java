package aufgabe6;

/**
 * SerielleTaetigkeit
 */
public class SerielleTaetigkeit extends ZusammengesetzteTaetigkeit {

    public SerielleTaetigkeit() {
        super();
    }

    @Override
    public double getTime() {
        double sumTime = 0.0;
        for (Taetigkeit tk : meineTaetigkeiten) {
            sumTime += tk.getTime();
        }
        return sumTime;
    }
}
