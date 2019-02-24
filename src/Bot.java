
public class Bot {

	static void pick() {

		/*
		 * Check if the sum of the probabilities is 1, then adjust the values of the 2
		 * lower to fit.
		 */
		if (Main.rock + Main.paper + Main.scissors != 1) {
			double sobra = (Main.rock + Main.paper + Main.scissors) - 1;

			if (Main.rock > Main.scissors && Main.rock > Main.paper) {
				// The higher is rock
				Main.scissors -= sobra / 2.0;
				Main.paper -= sobra / 2.0;
			} else if (Main.paper > Main.rock && Main.paper > Main.scissors) {
				// The higher is paper
				Main.scissors -= sobra / 2.0;
				Main.rock -= sobra / 2.0;
			} else if (Main.scissors > Main.rock && Main.scissors > Main.paper) {
				// The higher is scissors
				Main.paper -= sobra / 2.0;
				Main.rock -= sobra / 2.0;
			}
		}

		/*
		 * Pick a random number and check with that number what we are going to throw in
		 * this round
		 */
		double random = Math.random();

		if (random < Main.rock) {
			// Tira rock
			Main.defense = 0;
		} else if (random > Main.rock && random < (Main.rock + Main.paper)) {
			// Tira paper\
			Main.defense = 1;
		} else if (random > (Main.rock + Main.paper)) {
			// Tira scissors
			Main.defense = 2;
		}

	}

	static void prob() {

		/*
		 * If the opponent loses, we assume that his attack will change, we calculate
		 * what more possibilities would have to win or draw and we raise the
		 * probability by a 10%
		 */
		if (Main.result == true) {
			if (Main.lastTwo[Main.i - 1] == 0) {

				// If he changes to scissors, we draw, but if he changes to paper, we won
				Main.scissors += 0.10;
			} else if (Main.lastTwo[Main.i - 1] == 1) {

				// If he changes to rock, we draw, but if he changes to scissors, we won
				Main.rock += 0.10;
			} else if (Main.lastTwo[Main.i - 1] == 2) {

				// If he changes to paper, we draw, but if he changes to rock, we won
				Main.paper += 0.10;
			}
		} else {
			/*
			 * If he won we assume that he will continue with the same thing so we increase
			 * the percentage to what is best
			 */

			if (Main.lastTwo[Main.i - 1] == 0) {
				Main.paper += 0.10;
			} else if (Main.lastTwo[Main.i - 1] == 1) {
				Main.scissors += 0.10;
			} else if (Main.lastTwo[Main.i - 1] == 2) {
				Main.rock += 0.10;
			}
		}

		/*
		 * If in the last two rounds the opponent's shots were the same, we assume that
		 * it will change and we increase the probability to what would have the maximum
		 * chance of a draw or victory. And as it is more normal instead of increasing
		 * 10% we increase 15%
		 */
		if (Main.lastTwo[0] == Main.lastTwo[1]) {
			if (Main.lastTwo[0] == 0) {
				/*
				 * If the last two rounds he was going with rock, what is more likely to win or
				 * tie is scissors
				 */
				Main.scissors += 0.15;
			} else if (Main.lastTwo[0] == 1) {
				/*
				 * If the last two rounds he was going with paper, what is more
				 * likely to win or tie is rock
				 */
				Main.rock += 0.15;
			} else if (Main.lastTwo[0] == 2) {
				/*
				 * If the last two rounds he was going with scissors, what is more likely to win or
				 * tie is paper
				 */
				Main.paper += 0.15;
			}
		}
	}
}
