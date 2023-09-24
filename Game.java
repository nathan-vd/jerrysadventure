package jerrysadventure;
import java.time.Year;
import java.util.Scanner;

public class Game{
	private static Scanner scanner;
	public static int stateId = 0;

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
		System.out.println("Hi " + name);

		// Ask user when they were born
		System.out.print("What year were you born?: ");
		int birthYear = scanner.nextInt();
		int age = calculateAge(birthYear);
		System.out.println("You are " + age + " years old");

		// Printing the opening dialogue
		printState(stateId);

		while (stateId != 666){
			String input = getInput();
			takeAction(input, stateId);
			printState(stateId);
		}
		// ----- Write your code above
	}

	public static int calculateAge(int year){
		return Year.now().getValue() - year;
	}

	public static String getInput(){
		scanner = new Scanner(System.in);
		System.out.print("What would you like to do?: ");
		String input = scanner.nextLine().toLowerCase();

		// Check whether action inputted was a valid action and returns the action to later change stateId
		switch(input){
			case "open the door":
				System.out.println("You open the door");
				return input;
			case "go north":
				System.out.println("You go north");
				return input;
			case "go east":
				System.out.println("You go east");
				return input;
			case "go south":
				System.out.println("You go south");
				return input;
			case "go west":
				System.out.println("You go west");
				return input;
			case "take item":
				System.out.println("You take the item");
				return input;
			case "drop item":
				System.out.println("You drop the item");
				return input;
			case "use item":
				System.out.println("You use the item");
				return input;
			case "exit":
			case "quit": 
				System.out.println("You quit");
				return input;
			default:
				System.out.println("Invalid Input");
				return getInput();
		}
	}

	public static void takeAction(String action, int currentState){
		switch(action){
			case "open the door": 
				if (currentState == 0){
					stateId = 1;
				}
				break;
			case "take item":
				if (currentState == 0){
					stateId = 2;
				}
				break;
			case "go east":
				if (currentState == 1){
					stateId = 3;
				}
				break;
			case "exit":
			case "quit": stateId = 666; break;
		}
	}

	public static void printState(int stateId){
		String story = "";

		switch(stateId){
			case 0: 
				story = "You are standing in an abandoned university office.\nThere are neither students "
				+ "nor teachers around you.\nThere's a table in front of you with various papers, "
				+ "pens, a small puzzle toy, and a calculator.\n"
				+ "A large window shows an empty office building; there are no Zombies in the empty "
				+ "building (as far as you can tell).\nBehind you is a dark and mysterious door that "
				+ "leads to a well-lit corridor with a fireproof ceiling and floor.\nYou feel a "
				+ "sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be "
				+ "heard in the distance.\nYou are not thirsty, but you rather have a craving for "
				+ "justice.";
				break;
			case 1: 
				story = "You are in a long hallway.\nThere\'s a man wearing glasses at the end of it, he "
				+ "looks harmless.\nWest is a wall, east is the man, to the north is nothing but "
				+ "empty offices, a desperate sight.\nThe carpeting in the hallway feels soft, you "
				+ "hear the clicking of a mouse in the distance.\nYour office is south (behind "
				+ "you).";
				break;
			case 2: 
				story = "You take the calculator from your desk.\nIt's a Casio FX-85gt Plus.\nThe "
				+ "display shows the number 0.1134.\nYou turn it upside down; now the Casio "
				+ "greets you with a friendly “hello”, nice.\nYou hold the calculator in your hand.";
				break;
			case 3:
				story = "The man greets you and starts endlessly talking to you about his children "
				+ "and his holiday to Benidorm.\nYou die of boredom.";
				break;
		}
		System.out.println("\n" + story + "\n");
	}
}
