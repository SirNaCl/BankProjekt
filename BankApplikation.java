import java.util.ArrayList;
import java.util.Scanner;

public class BankApplikation {
	private Scanner scan = new Scanner(System.in);
	private Bank bank;
	private boolean badChoice = false;

	public static void main(String[] args) {
		BankApplikation app = new BankApplikation();
		app.runApplication();

	}

	public void runApplication() {
		bank = new Bank();
		String choice = "";

		addAccount("Emil", "9801194631");
		bank.findByNumber(1001).deposit(1000);
		addAccount("Emil", "9801194631");
		addAccount("Emiasd", "9891194631");
		addAccount("ASDjoi", "946511");
		addAccount("Ezxvael", "9845618");
		addAccount("Emiasdasdasd", "485168");

		// Programloopen som körs tills det att användaren väljer att stänga av
		// programmet.
		do {
			printMenu();

			// Om ett ogiltigt val gjordes förra iterrationen så meddelas användaren om
			// detta.
			if (badChoice) {
				System.out.println("\"" + choice + "\" Är ett ogiltigt val, vänligen försök igen.");
				badChoice = false;
			}

			choice = listenForChoice();
			actOnChoice(choice);

		} while (!choice.equals("9")); // Kör programmet så länge valet inte är 9
	}

	// \Skriver ut menyn i konsolen
	private void printMenu() {
		System.out.println("----------------------------------------------");
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");

	}

	// Ger menyn funktionalitet och anropar de metoder som är anknytna till valen
	private void actOnChoice(String choice) {
		switch (choice) {
		case "1":
			findAccountsByID();
			break;
		case "2":
			searchByName();
			break;
		case "3":
			depositToAccount();
			break;
		case "4":
			withdrawFromAccount();
			break;
		case "5":
			transferBetweenAccounts();
			break;
		case "6":
			addAccount();
			break;
		case "7":
			removeAccount();
			break;
		case "8":
			printAccounts();
			break;
		case "9":
			System.out.println("Tack för att du använde applikationen. Välkommen åter!");
			break;
		default:
			badChoice = true;
			break;
		}
	}

	private String listenForChoice() {
		System.out.println("\nMata in ett val från menyn ovan: ");
		return scan.nextLine();
	}

	private void addAccount() {
		String name;
		String idNrAsString;
		long idNr;

		System.out.println("Du har valt att lägga till ett nytt konto. \nNamn: ");
		name = scan.nextLine();
		System.out.println("Personnummer: ");
		idNrAsString = scan.nextLine();

		// Hanterar exception som sker ifall perssonnumret innehåller felaktiga tecken
		try {
			idNr = Long.valueOf(idNrAsString);
			bank.addAccount(name, idNr);
		} catch (java.lang.NumberFormatException e) {
			System.out.println("Felaktig inmatning av personnummer.");
			waitForEnter();
		}
	}

	// skapar konton som används för att testa
	@SuppressWarnings("unused")
	private void addAccount(String name, String idNrAsString) {
		long idNr = Long.valueOf(idNrAsString);
		bank.addAccount(name, idNr);
	}

	// Skriver ut alla existerande konton
	private void printAccounts() {
		ArrayList<BankAccount> list = bank.getAllAccounts();
		
		if (list == null) {
			System.out.println("Det finns inga konton.");
		}
		
		else {
			for (BankAccount account : list) {
				System.out.println(account);
			}
		}
		waitForEnter();
	}

	private void findAccountsByID() {
		long idNr = askForID();
		ArrayList<BankAccount> accountList;
		if (idNr == -1) {

		}

		else {
			accountList = bank.findAccountsForHolder(idNr);
			for (BankAccount account : accountList) {
				System.out.println(account);
			}
			System.out.println("Tryck på enter för att återgå till menyn.");
			scan.nextLine();
		}
	}

	private long askForID() {
		String input;
		System.out.println("Vänligen skriv in det önskade personnummret: ");
		input = scan.nextLine();

		try {
			return Long.valueOf(input);

		} catch (java.lang.NumberFormatException e) {
			System.out.println("Felaktig inmatning av personnummer, tryck på enter för att återgå till menyn.");
			scan.nextLine();
			return -1;
		}
	}

	private void searchByName() {
		String name;
		ArrayList<Customer> result = new ArrayList<Customer>();

		System.out.println("Ange det namn du vill söka på: ");
		name = scan.nextLine();
		result = bank.findByPartofName(name);

		if (result == null) {
			System.out.println("Inga kunder matchar din sökning, tryck på enter för att återgå till menyn.");
			scan.nextLine();
		}

		else {
			for (Customer customer : result) {
				System.out.println(customer);
			}
			System.out.println("Tryck på enter för att gå tillbaka till menyn.");
			scan.nextLine();
		}

	}

	private void depositToAccount() {
		String inputNbr, inputAmount;
		int accountNumber, amount;
		BankAccount account;

		System.out.println("Vänligen skriv in nummer på det konto som du vill sätta in pengar på");
		inputNbr = scan.nextLine();
		System.out.println("Ange hur mycket du vill sätta in: ");
		inputAmount = scan.nextLine();

		try {
			accountNumber = Integer.parseInt(inputNbr);
			amount = Integer.parseInt(inputAmount);

			account = bank.findByNumber(accountNumber);

			if (account != null && amount > 0) {
				account.deposit(amount);
				System.out.println(account);
				waitForEnter();
			}

			else if (account != null && amount <= 0) {
				System.out.println("Felaktigt belopp");
				waitForEnter();
			}
			
			else {
				System.out.println("Kontot kunde inte hittas");
				waitForEnter();
			}

		} catch (java.lang.NumberFormatException e) {
			System.out.println("Felaktigt inmatning, tryck på enter för att återgå till menyn.");
			scan.nextLine();
		}

	}
      
	private void withdrawFromAccount() {
		String inputNbr, inputAmount;
		int accountNumber, amount;
		BankAccount account;

		System.out.println("Vänligen skriv in nummer på det konto som du vill ta ut pengar ifrån");
		inputNbr = scan.nextLine();
		System.out.println("Ange hur mycket du vill ta ut: ");
		inputAmount = scan.nextLine();

		try {
			accountNumber = Integer.parseInt(inputNbr);
			amount = Integer.parseInt(inputAmount);

			account = bank.findByNumber(accountNumber);

			if (account != null && amount < account.getAmount() && amount > 0) {
				account.withdraw(amount);
				System.out.println(account);
				waitForEnter();
			}
			
			else if (account != null && amount <= 0) {
				System.out.println("Felaktigt belopp");
				waitForEnter();
			}

			else if (account != null && amount >= account.getAmount()) {
				System.out.println("Otillräckligt saldo");
				waitForEnter();
			}
			
			
			else {
				System.out.println("Kontot kunde inte hittas");
				waitForEnter();
			}

		} catch (java.lang.NumberFormatException e) {
			System.out.println("Felaktigt inmatning, tryck på enter för att återgå till menyn.");
			scan.nextLine();
		}

	}

	private void transferBetweenAccounts() {
		String inputSenderNbr, inputRecieverNbr, inputAmount;
		int accountNumberSender, accountNumberReciever, amount;
		BankAccount sender, reciever;

		System.out.println("Vänligen skriv in nummer på det konto som du vill skicka pengar från");
		inputSenderNbr = scan.nextLine();
		System.out.println("Vänligen skriv in nummer på det konto som du vill skicka pengar till");
		inputRecieverNbr = scan.nextLine();
		System.out.println("Ange hur mycket du vill skicka: ");
		inputAmount = scan.nextLine();

		try {
			accountNumberSender = Integer.parseInt(inputSenderNbr);
			accountNumberReciever = Integer.parseInt(inputRecieverNbr);
			amount = Integer.parseInt(inputAmount);

			sender = bank.findByNumber(accountNumberSender);
			reciever = bank.findByNumber(accountNumberReciever);

			if (sender != null && reciever != null && amount < sender.getAmount()) {
				sender.withdraw(amount);
				reciever.deposit(amount);
				System.out.println(sender);
				System.out.println(reciever);
				waitForEnter();
			}
			
			//Om det inte finns tillräckligt pengar på kontot
			else if (sender != null && reciever != null && amount >= sender.getAmount()) {
				System.out.println("Otillräckligt saldo");
				waitForEnter();
			}
			
			else {
				System.out.println("Konto kunde inte hittas");
				waitForEnter();
			}

		} catch (java.lang.NumberFormatException e) {
			System.out.println("Felaktigt inmatning, tryck på enter för att återgå till menyn.");
			scan.nextLine();
		}

	}
	
	private void removeAccount() {
		String input;
		int accountNumber;

		System.out.println("Vänligen skriv in nummer på det konto som du vill ta bort");
		input = scan.nextLine();

		try {
			accountNumber = Integer.parseInt(input);
			
			if (bank.removeAccount(accountNumber)) {
				System.out.println("Konto borttaget.");
				waitForEnter();
			}
			
			else {
				System.out.println("Konto kunde inte hittas eller tas bort");
				waitForEnter();
			}

		} catch (java.lang.NumberFormatException e) {
			System.out.println("Felaktigt inmatning.");
			waitForEnter();
		}
	}
	
	// Pausar programmet tills det att användaren trycker på enterknappen
	private void waitForEnter() {
		System.out.println("Tryck på enter för att återgå till menyn");
		scan.nextLine();
	}

}
