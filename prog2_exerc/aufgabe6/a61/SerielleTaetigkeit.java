package a61;

/**
 * SerielleTaetigkeit
 */
public class SerielleTaetigkeit extends ZusammengesetzteTaetigkeit {

    @Override
    public double getTime() {
        double sumTime = 0.0;
        for (Taetigkeit tk : meineTaetigkeiten) {
            sumTime += tk.getTime();
        }
        return sumTime;
    }
}
