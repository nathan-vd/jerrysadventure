package jerrysadventure;
import java.time.Year;
import java.util.Scanner;

public class Game {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		// ----- Write your code below
		
		// Outputting title to the terminal
		System.out.println("       __                    _         ___       __                 __");
		System.out.println("      / /__  ____________  _( )_____  /   | ____/ /   _____  ____  / /___   _________");
		System.out.println(" __  / / _ \\/ ___/ ___/ / / /// ___/ / /| |/ __  / | / / _ \\/ __ \\/ __/ / / / ___/ _ \\");
		System.out.println("/ /_/ /  __/ /  / /  / /_/ / (__  ) / ___ / /_/ /| |/ /  __/ / / / /_/ /_/ / /  /  __/");
		System.out.println("\\____/\\___/_/  /_/   \\__, / /____/ /_/  |_\\__,_/ |___/\\___/_/ /_/\\__/\\__,_/_/   \\___/");
		System.out.println("                    /____/");
		System.out.println("\nby: Nathan\n\n");

		// Ask for users name
		System.out.print("What is your name?: ");
		String name = scanner.nextLine();
		System.out.println("Hi! " + name);

		// Ask user when they were born
		System.out.print("What year were you born?: ");
		int birthYear = scanner.nextInt();
		int age = calculateAge(birthYear);
		System.out.println("You are " + age + " years old!");

		// Printing the opening dialogue
		System.out.println("\nYou are standing in an abandoned university office.\nThere are neither students "
		+ "nor teachers around you.\nThere's a table in front of you with various papers, "
		+ "pens, a small puzzle toy, and a calculator.\n"
		+ "A large window shows an empty office building; there are no Zombies in the empty "
		+ "building (as far as you can tell).\nBehind you is a dark and mysterious door that "
		+ "leads to a well-lit corridor with a fireproof ceiling and floor.\nYou feel a "
		+ "sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be "
		+ "heard in the distance.\nYou are not thirsty, but you rather have a craving for "
		+ "justice.\n");
		
		getInput();
		// ----- Write your code above
	}

	public static int calculateAge(int year){
		return Year.now().getValue() - year;
	}

	public static void getInput(){
		scanner = new Scanner(System.in);
		System.out.print("What would you like to do?: ");
		String input = scanner.nextLine();

		switch(input.toLowerCase()){
			case "open the door":
				System.out.println("You open the door");
				break;
			case "go north":
				System.out.println("You go north");
				break;
			case "go east":
				System.out.println("You go east");
				break;
			case "go south":
				System.out.println("You go south");
				break;
			case "go west":
				System.out.println("You go west");
				break;
			case "take item":
				System.out.println("You take the item");
				break;
			case "drop item":
				System.out.println("You drop the item");
				break;
			case "use item":
				System.out.println("You use the item");
				break;
			default:
				System.out.println("Invalid Input");
				getInput();
				break;
		}
	}
}
