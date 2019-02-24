/*
 * INPUT:
 * 			0 = rock
 * 			1 = paper
 * 			2 = scissors
 * 
 * I hope you enjoy this little program!!!
 */





import java.util.Scanner;

public class Main {

	public static double rock = 0.354;
	public static double paper = 0.35;
	public static double scissors = 0.296;

	public static int[] lastTwo = new int[2];

	public static short i = 0;
	public static short defense;

	public static boolean result; // true = Bot wins, false = Bot loses
	static boolean first = true;

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		while (true) {
			rock = 0.354;
			paper = 0.35;
			scissors = 0.296;

			System.out.println("Rock, paper, scissors!!!");
			int ataque = sc.nextInt(); // Attack is the move of the opponent

			// We need to differentiate between the first round and the other, because of
			// how
			// we maked the algorithm
			if (first == true) {
				// First Round
				Bot.pick();
				first = false;
			} else {
				Bot.prob();
				Bot.pick();
			}

			if (ataque == defense) {
				// Tie
				System.out.println("Tie!");
			} else {
				switch (ataque) {
				case 0:
					if (defense == 1) {
						// Bot wins
						System.out.println("I win!");
					} else {
						// Opponent wins
						System.out.println("You won! :)");
					}
					break;
				case 1:
					if (defense == 2) {
						// Bot wins
						System.out.println("I win!");
					} else {
						// Opponent wins
						System.out.println("You won! :)");
					}
					break;
				case 2:
					if (defense == 0) {
						// Bot wins
						System.out.println("I win!");
					} else {
						// Opponent wins
						System.out.println("You won! :)");
					}
					break;
				}
			}

			// Luego metes el ataque en el array
			if (i == 2) {
				i = 0;
			}

			lastTwo[i] = ataque;
			i++;

			/*
			 * If you want to see the probabilities and the defense please uncomment this
			 * lines!
			 * 
			 * System.out.println(rock); 
			 * System.out.println(paper);
			 * System.out.println(scissors); 
			 * System.out.println(defense);
			 */

		}
	}
}
