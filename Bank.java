import java.util.ArrayList;

public class Bank {
	/** Skapar en ny bank utan konton. */
	public static int customers = 1000, accounts = 1000;
	private ArrayList<Customer> customerList;
	private ArrayList<BankAccount> accountList;
	
	
	Bank(){
		customerList = new ArrayList<Customer>();
		accountList = new ArrayList<BankAccount>();
	}
	/**
	* Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
	* med de givna uppgifterna ska inte en ny Customer skapas, utan istället
	* den befintliga användas. Det nya kontonumret returneras.
	*/
	public int addAccount(String holderName, long idNr) {
		BankAccount account;
		
		//Om kunden redan finns så skapas ett konto i dess namn.
		if(doesCustomerExist(idNr)) {
			account = new BankAccount(findHolder(idNr));
		}
		
		//Om det är en ny kund så skapas ett nytt kundobjekt med hjälp av denna konstruktorn i BankAccount klassen.
		else {
			account = new BankAccount(holderName, idNr);
		}
		
		//Returnerar nummret för det nya kontot.
		return account.getAccountNumber();
	}
	
	/**
	* Returnerar den kontoinnehavaren som har det givna id-numret,
	* eller null om ingen sådan finns.
	*/
	Customer findHolder(long idNr) {
		for(Customer customer: customerList) {
			if(customer.getIdNr() == idNr) {
				return customer;
			}
		}
		return new Customer("Not Found", -1);
	}
	
	/**
	* Tar bort konto med nummer ’number’ från banken. Returnerar true om
	* kontot fanns (och kunde tas bort), annars false.
	*/
	boolean removeAccount(int number) {
		return false;
	}
	
	/**
	* Returnerar en lista innehållande samtliga bankkonton i banken.
	* Listan är sorterad på kontoinnehavarnas namn.
	*/
	ArrayList<BankAccount> getAllAccounts(){
		return accountList;
	}
	
	/**
	* Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	* Returnerar null om inget sådant konto finns.
	*/
	BankAccount findByNumber(int accountNumber) {
		return null;
	}
	
	/**
	* Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’.
	* Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	*/
	ArrayList<BankAccount> findAccountsForHolder(long idNr){
		return null;
	}
	/**
	* Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
	* personer vars namn innehåller strängen ’namePart’ inkluderas i
	* resultatet, som returneras som en lista. Samma person kan förekomma
	* flera gånger i resultatet. Sökningen är "case insensitive", det vill
	* säga gör ingen skillnad på stora och små bokstäver.
	*/
	ArrayList<Customer> findByPartofName(String namePart){
		return null;
	}
	
	private boolean doesCustomerExist(long idNr) {
		for (Customer customer: customerList) {
			if(customer.getIdNr() == idNr) {
				return true;
			}
		}
		return false;
	}
	
}
