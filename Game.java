package jerrysadventure;
import java.time.Year;
import java.util.Scanner;

public class Game{
	private static Scanner scanner;
	public static int stateId = 0;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

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

		// Initializing story array with possibilities
		String[] storyArray = {"You are standing in an abandoned university office.\nThere are neither students "
				+ "nor teachers around you.\nThere's a table in front of you with various papers, "
				+ "pens, a small puzzle toy, and a calculator.\n"
				+ "A large window shows an empty office building; there are no Zombies in the empty "
				+ "building (as far as you can tell).\nBehind you is a dark and mysterious door that "
				+ "leads to a well-lit corridor with a fireproof ceiling and floor.\nYou feel a "
				+ "sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be "
				+ "heard in the distance.\nYou are not thirsty, but you rather have a craving for "
				+ "justice.",
				"You are in a long hallway.\nThere\'s a man wearing glasses at the end of it, he "
				+ "looks harmless.\nWest is a wall, east is the man, to the north is nothing but "
				+ "empty offices, a desperate sight.\nThe carpeting in the hallway feels soft, you "
				+ "hear the clicking of a mouse in the distance.\nYour office is south (behind "
				+ "you).",
				"You take the calculator from your desk.\nIt's a Casio FX-85gt Plus.\nThe "
				+ "display shows the number 0.1134.\nYou turn it upside down; now the Casio "
				+ "greets you with a friendly “hello”, nice.\nYou hold the calculator in your hand.",
				"The man greets you and starts endlessly talking to you about his children "
				+ "and his holiday to Benidorm.\nYou die of boredom.",
				"You enter the hallway with the Casio FX-85gt stand-by.\nHaving this small device "
				+ "greet you puts you in a good mood, somehow the building feels less lonely than "
				+ "before.\nWest is a wall, looking east you stare into the darkness, the corridor is too "
				+ "long to see the end.\nTo the north you see an office with what looks like a small "
				+ "creature in a corner.\nThe carpeting in the hallway feels soft, you hear someone "
				+ "explaining algorithms to your north.",
				"You enter the office.\nTo your surprise a small dog is sitting in the corner.\nSurely this "
				+ "breaks any number of university regulations!\nIn a high-pitched voice the dog tells "
				+ "you how to write even more cool words on your Casio FX-85gt, good boi!\nTo the "
				+ "north you see an open window, a ladder hangs down from it, it looks so dangerous!\n"
				+ "An LCD display shows a youtube video about developing algorithms."
				};
			
		// Game loop
		while (stateId != 666){
			System.out.println("\n" + getStory(stateId, storyArray) + "\n");
			String input = getInput();
			takeAction(input, stateId); 
		}
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
			case "go north":
			case "go east":
			case "go south":
			case "go west":
			case "take item":
			case "drop item":
			case "use item":
			case "exit":
			case "quit": 
				return input;
			default:
				System.out.println("Invalid Input");
				return getInput();
		} 
	}

	public static void takeAction(String action, int currentState){
		
		String[][] transitionMatrix = new String[6][6];
		for (int i = 0; i < transitionMatrix.length; i++){
			for (int c = 0; c < transitionMatrix.length; c++){
				transitionMatrix[i][c] = "";
			}
		}

		transitionMatrix[0][1] = "open the door";
		transitionMatrix[0][2] = "take item";
		transitionMatrix[1][0] = "go south";
		transitionMatrix[1][3] = "go east";
		transitionMatrix[2][4] = "open the door";
		transitionMatrix[4][1] = "drop item";
		transitionMatrix[4][5] = "go north";
		transitionMatrix[5][1] = "go south";

		for (int i = 0; i < transitionMatrix.length; i++){
			if (transitionMatrix[currentState][i].equals(action)){
				stateId = i;
			}
			else if (action.equalsIgnoreCase("quit") || action.equalsIgnoreCase("exit")){
				stateId = 666;
			}
		}
	}

	public static String getStory(int stateId, String[] storyArray){
		return storyArray[stateId];
	}
}
