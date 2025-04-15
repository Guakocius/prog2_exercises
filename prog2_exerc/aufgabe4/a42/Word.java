package a42;

/**
 * Klasse für Wörter mit ihren Häufigkeiten.
 * 
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */
public class Word<T> {
	private final T word;
	private int frequency;

	/**
	 * Konstruktor.
	 * @param word Wort
	 * @param f H&auml;ufigkeit
	 */
	public Word(T word, int f) {
        this.word = word;
		this.frequency = f;
	}

    	/**
	 * Liefert Wort zur&uuml;ck.
	 * @return Wort
	 */
	public T getWord() {
		return word;
	}

	/**
	 * Liefert H&auml;ufgkeit zur&uuml;ck.
	 * @return H&auml;ufgkeit
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * Addiert zur H&auml;ufgkeit f dazu.
	 * @param f H&auml;ufgkeits&auml;nderung.
	 */
	public void addFrequency(int f) {
		frequency += f;
	}

	@Override
	public String toString() {
		return word.toString() + ":" + frequency;
	}
}
