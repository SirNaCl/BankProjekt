import java.util.Scanner;
import se.lth.cs.pt.window.SimpleWindow;

public class BankApplikation {
	private Scanner scan = new Scanner(System.in);
	private Bank bank = new Bank();
	private boolean badChoice = false;

	public static void main(String[] args) {
		BankApplikation app = new BankApplikation();
		app.runApplication();
	}

	public void runApplication() {
		Bank bank = new Bank();
		String choice = "";

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

		} while (!choice.equals("9"));
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
			addAccount();
			break;
		case "7":
			break;
		case "8":
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

		try {
			idNr = Long.valueOf(idNrAsString);
			bank.addAccount(name, idNr);
		} catch (java.lang.NumberFormatException e) {
			System.out.println("Felaktig inmatning av personnummer.");
			SimpleWindow.delay(250);
		}
	}

}
