
public class BankAccount {
	/**
	 * Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och id
	 * ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	 * inledningsvis 0 kr.
	 */

	private double balance = 0;
	private Customer customer;
	private int accountNbr;

	BankAccount(String holderName, long holderId) {
		customer = new Customer(holderName, holderId);
		generateAccountNbr();
	}

	/**
	 * Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas ett unikt
	 * kontonummer och innehåller inledningsvis 0 kr.
	 */
	BankAccount(Customer holder) {
		customer = holder;
		generateAccountNbr();
	}

	/** Tar reda på kontots innehavare. */
	Customer getHolder() {
		return customer;
	}

	/** Tar reda på det kontonummer som identifierar detta konto. */
	int getAccountNumber() {
		return accountNbr;
	}

	/** Tar reda på hur mycket pengar som finns på kontot. */
	double getAmount() {
		return balance;
	}

	/** Sätter in beloppet ’amount’ på kontot. */
	void deposit(double amount) {
		balance += amount;
	}

	/**
	 * Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning blir saldot
	 * negativt.
	 */
	void withdraw(double amount) {
		balance -= amount;
	}

	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return "Konto: " + accountNbr + " (" + customer + "), Saldo: " + balance;
	}

	// Ökar bankens kontoräknare och tilldelar detta kontot ett unikt nummer.
	private void generateAccountNbr() {
		Bank.accounts++;
		accountNbr = Bank.accounts;
	}
}
