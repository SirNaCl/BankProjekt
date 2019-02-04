import java.util.ArrayList;

public class Bank {
	/** Skapar en ny bank utan konton. */
	public static int customers = 1000, accounts = 1000;
	private ArrayList<Customer> customerList;
	private ArrayList<BankAccount> accountList;

	public Bank() {
		customerList = new ArrayList<Customer>();
		accountList = new ArrayList<BankAccount>();
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	public int addAccount(String holderName, long idNr) {
		BankAccount account;

		// Om kunden redan finns så skapas ett konto i dess namn.
		if (doesCustomerExist(idNr)) {
			account = new BankAccount(findHolder(idNr));
		}

		// Om det är en ny kund så skapas ett nytt kundobjekt med hjälp av denna
		// konstruktorn i BankAccount klassen.
		else {
			account = new BankAccount(holderName, idNr);

			// Den nya kunden läggs till i listan av kunder.
			customerList.add(account.getHolder());

		}

		// Returnerar nummret för det nya kontot.
		accountList.add(account);

		return account.getAccountNumber();
	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */
	public Customer findHolder(long idNr) {
		for (Customer customer : customerList) {
			if (customer.getIdNr() == idNr) {
				return customer;
			}
		}
		return null;
	}

	/**
	 * Tar bort konto med nummer ’number’ från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	public boolean removeAccount(int number) {
		BankAccount account = findByNumber(number);

		if (account != null) {
			accountList.remove(account);
			return true;
		}
		return false;
	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	public ArrayList<BankAccount> getAllAccounts() {
		if (accountList.size() == 0) {
			return null;
		}

		return sortAccountList(accountList);
	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	 * Returnerar null om inget sådant konto finns.
	 */
	public BankAccount findByNumber(int accountNumber) {
		for (BankAccount account : accountList) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> foundAccounts = new ArrayList<BankAccount>();

		for (BankAccount account : accountList) {
			if (account.getHolder().getIdNr() == idNr) {
				foundAccounts.add(account);
			}
		}

		if (foundAccounts.size() == 0) {
			return null;
		}

		return foundAccounts;
	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
	 * vars namn innehåller strängen ’namePart’ inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i
	 * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
	 * på stora och små bokstäver.
	 */
	public ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> result = new ArrayList<Customer>();

		if (namePart == null) {
			return null;
		}

		for (Customer customer : customerList) {
			if (customer.getName().toLowerCase().contains(namePart.toLowerCase())) {
				result.add(customer);
			}
		}

		return result;
	}

	// Kontrollerar om en kund redan finns i banken
	private boolean doesCustomerExist(long idNr) {
		for (Customer customer : customerList) {
			if (customer.getIdNr() == idNr) {
				return true;
			}
		}
		return false;
	}

	// sorterar en ArrayList<BankAccount> med hjälp av quicksort
	private ArrayList<BankAccount> sortAccountList(ArrayList<BankAccount> list) {
		ArrayList<BankAccount> higher = new ArrayList<BankAccount>();
		ArrayList<BankAccount> lower = new ArrayList<BankAccount>();
		ArrayList<BankAccount> unsorted = new ArrayList<BankAccount>();
		ArrayList<BankAccount> sorted = new ArrayList<BankAccount>();
		
		unsorted.addAll(list);
		
		BankAccount reference = unsorted.get(unsorted.size() / 2);
		unsorted.remove(unsorted.size() / 2);

		for (BankAccount account : unsorted) {

			// Jämför accountholderns namn med referensens namn och lägger därefter till
			// kontot i rätt lista
			if (reference.getHolder().getName().compareTo(account.getHolder().getName()) > 0) {
				lower.add(account);
			} else {
				higher.add(account);
			}
		}

		// Nedanför monteras en sorterad lista ihop genom att sortera sub-listorna
		if (lower.size() > 1) {
			sorted.addAll(sortAccountList(lower));
		} else {
			sorted.addAll(lower);
		}

		// Sätter tillbaka referensen mellan sub-listorna
		sorted.add(reference);

		if (higher.size() > 1) {
			sorted.addAll(sortAccountList(higher));
		} else {
			sorted.addAll(higher);
		}

		return sorted;
	}

}
