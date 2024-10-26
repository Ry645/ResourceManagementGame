package utils;

/**
 * utility methods that other classes can use.
 *
 * @author Ryan Sexton
 * @version 1.0
 */
public class Utils {
	//TODO TEST
    //TODO RAND
    /**
     * gets a random index from an array of weighted values.
     * example: can be used in a random item drop pool where some items are rarer than others.
     *
     * @param weights the array of weighted values
     */
	public static int getRandomIndexFromWeights(int[] weights) {
		int totalWeight = 0;
		for (int weight : weights) {
			totalWeight += weight;
		}
		
		int randomIndex = -1;
		int randomRawVal = (int) (Math.random() * totalWeight);
		for (int i = 0; i < weights.length; i++) {
			randomRawVal -= weights[i];
			if (randomRawVal <= 0.0) {
				randomIndex = i;
				break;
			}
		}
		return randomIndex;
	}
}
