
public class BankAccount {
	/**
	* Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och
	* id ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	* inledningsvis 0 kr.
	*/
	BankAccount(String holderName, long holderId){
		
	}
	/**
	* Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas
	* ett unikt kontonummer och innehåller inledningsvis 0 kr.
	*/
	BankAccount(Customer holder){
		
	}
	/** Tar reda på kontots innehavare. */
	Customer getHolder() {
		return null;
	}
	/** Tar reda på det kontonummer som identifierar detta konto. */
	int getAccountNumber() {
		return 0;
	}
	/** Tar reda på hur mycket pengar som finns på kontot. */
	double getAmount() {
		return 0;
	}
	/** Sätter in beloppet ’amount’ på kontot. */
	void deposit(double amount) {
		
	}
	/**
	* Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning
	* blir saldot negativt.
	*/
	void withdraw(double amount) {
		
	}
	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return null;
	}
}