package a61;

import java.util.List;
import java.util.ArrayList;


/**
 * ZusammengesetzteTaetigkeit
 */
public abstract class ZusammengesetzteTaetigkeit implements Taetigkeit {
    protected List<Taetigkeit> meineTaetigkeiten = new ArrayList<>();

    @Override
    public void add(Taetigkeit tk) {
        meineTaetigkeiten.add(tk);
    }

    @Override
    public void remove(Taetigkeit tk) {
        meineTaetigkeiten.remove(tk);
    }

    @Override
    public int getAnzahl() {
        int anz = 0;
        for (Taetigkeit taetigkeit : meineTaetigkeiten) {
            anz += taetigkeit.getAnzahl();
        }
        return anz;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Taetigkeit taetigkeit : meineTaetigkeiten) {
            sb.append(taetigkeit.toString());
            sb.append(", ");
        }
        sb.append("} size = ").append(meineTaetigkeiten.size());
        sb.append("\n");
        return sb.toString();
    }
}
