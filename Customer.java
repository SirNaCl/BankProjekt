
public class Customer implements Comparable<Customer> {
	private long idNr;
	private int custumerNr;
	private String name;

	/**
	 * Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
	 * Kunden tilldelas också ett unikt kundnummer.
	 */
	Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		generateCustomerNr();
	}

	/** Tar reda på kundens namn. */
	public String getName() {
		return name;
	}

	/** Tar reda på kundens personnummer. */
	public long getIdNr() {
		return idNr;
	}

	/** Tar reda på kundens kundnummer. */
	public int getCustomerNr() {
		return custumerNr;
	}

	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		return "Namn: " + name + " Personnummer: " + idNr + " Kundnummer: " + custumerNr;
	}

	// Ökar bankens kundräknare och ger kunden ett unikt id
	private void generateCustomerNr() {
		Bank.customers++;
		custumerNr = Bank.customers;
	}

	// Använder samma interface och metod som i lab 7 för att kunna sortera kunder
	// efter namn
	@Override
	public int compareTo(Customer o) {
		// Om exakt samma objekt
		if (o == this) {
			return 0;
		}
		return name.compareTo(o.name);
	}

}
