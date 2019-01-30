import java.util.Scanner;

public class BankApplikation {
	private Scanner scan = new Scanner(System.in);
	private Bank bank = new Bank();

	public static void main(String[] args) {
		BankApplikation app = new BankApplikation();
		app.runApplication();
	}

	public void runApplication() {
		String choice;
		do {
			printMenu();
			choice = listenForChoice();
			actOnChoice(choice);
			

		} while (choice != "9");
	}

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
	
	//Ger menyn funtionalitet och anropar de metoder som är anknytna till valen
	private void actOnChoice(String choice) {
		switch (choice) {
		case "1":
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		case "5":
			break;
		case "6":
			break;
		case "7":
			break;
		case "8":
			break;
		case "9":
			System.out.println("Tack för att du använde applikationen. Välkommen åter!");
			break;
		default:
			printMenu();
			System.out.println("\"" + choice + "\" Är ett ogiltigt val, vänligen välj ett tal mellan 1 och 9.");
		}
	}
	
	private String listenForChoice() {
		return scan.nextLine();
	}

}
