package utils;

public class Utils {
	//TEST
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
