package a62;

public class Bibliothek {

	public static void main(String[] args) {
		Buch b1 = new Buch("Tod auf dem Nil");
		Buch b2 = new Buch("Alibi");
		Buch b3 = new Buch("Mord im Orientexpress");
		Person p1 = new Person("Peter");
		Person p2 = new Person("Maria");

		System.out.println(p1.leihtAus(b1));			// true
		System.out.println(b2.wirdAusgeliehen(p1));		// true

		p1.print(); // Peter hat ausgeliehen: Tod auf dem Nil, Alibi

		System.out.println(p2.leihtAus(b1));			// false
		System.out.println(p1.gibtZurueck(b1));			// true
		System.out.println(p2.leihtAus(b1));			// true
		System.out.println(b3.wirdAusgeliehen(p2));		// true

		p1.print(); // Peter hat ausgeliehen: Alibi
		p2.print(); // Maria hat ausgeliehen: Tod auf dem Nil, Mord im Orientexpress
		b1.print(); // Tod auf dem Nil: ausgeliehen von Maria
		b2.print(); // Alibi: ausgeliehen von Peter
		b3.print(); // Mord im Orientexpress: ausgeliehen von Maria

		System.out.println(p1.gibtZurueck(b1));			// false
		System.out.println(b2.wirdZurueckGegeben());	// true
		System.out.println(p2.gibtZurueck(b1));			// true
		System.out.println(b3.wirdZurueckGegeben());	// true

		p1.print(); // Peter hat ausgeliehen:
		p2.print(); // Maria hat ausgeliehen:
		b1.print(); // Tod auf dem Nil: nicht ausgeliehen
		b2.print(); // Alibi: nicht ausgeliehen
		b3.print(); // Mord im Orientexpress: nicht ausgeliehen
	}
}
