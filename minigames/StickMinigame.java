//battleship : stick
//hot and cold
//multiply column and row

package minigames;

import utils.*;

enum Direction {
	EAST,
	NORTHEAST,
	NORTH,
	NORTHWEST,
	WEST,
	SOUTHWEST,
	SOUTH,
	SOUTHEAST,
}

public class StickMinigame {
	public static final String leafSymbol = "O";
	public static final String stickSymbol = "#";
	
	public static final int totalRows = 8;
	public static final int totalColumns = 8;
	
	public static int[] possibleLengths = 	{4,  5,  6,  7};
	public static int[] weightsToLengths = 	{10, 40, 30, 20};
	
	//TEMP rowTraversal: might use sin/cos instead
	public static int[] directionToColumnTraversal = 	{1,  1,  0, -1, -1, -1, 0, 1};
	public static int[] directionToRowTraversal = 		{0, -1, -1, -1,  0,  1, 1, 1};
	
	//stores where the stick is
	public int[][] gameTile = new int[totalRows][totalColumns];
	
	public int startingRow;
	public int startingColumn;
	public int direction;
	public int length;
	
	public static void main(String[] args) {
		StickMinigame stickMinigame = new StickMinigame(7,7,7,8);
		System.out.println(stickMinigame);
		return;
	}
	
	//RAND
	// value = 13
	// row = 13 / 8 = 1
	// column = 13 % 8 = 5
	public StickMinigame() {
		int startingIndex = (int) (Math.random() * (totalRows * totalColumns));
		startingRow = startingIndex / totalColumns;
		startingColumn = startingIndex % totalRows;
		
		direction = (int) (Math.random() * 8);
		
		length = possibleLengths[Utils.getRandomIndexFromWeights(weightsToLengths)];
		
		generateStickInGameTile();
	}
	
	//for testing
	public StickMinigame(int startingRow, int startingColumn, int direction, int length) {
		this.startingRow = startingRow;
		this.startingColumn = startingColumn;
		
		this.direction = direction;
		
		this.length = length;
		
		generateStickInGameTile();
	}
	
	//INFO this works well
	public static int calculateHangingPointsCount(int start, int length, int traversalDirection, int total) {
		int endpoint = (start + length * traversalDirection);
		int toSubtract = endpoint < 0 ? 0 : total - 1;
		int hangingPointsCount = endpoint / total != 0 || endpoint < 0 ? (endpoint - toSubtract) : 0;
		return hangingPointsCount;
	}
	
	public void generateStickInGameTile() {
		//INFO : THAT'S FUKIN CLEANNNNNNNNN
		//-1, 0, or 1
		int rowTraversal = directionToRowTraversal[direction];
		int columnTraversal = directionToColumnTraversal[direction];
		
		//INFO : this took forever
		int hangingRows = calculateHangingPointsCount(startingRow, length, rowTraversal, totalRows);
		//shifts the stick based on the number of hanging
		startingRow -= hangingRows - 1;
		
		int hangingColumns = calculateHangingPointsCount(startingColumn, length, columnTraversal, totalColumns);
		startingColumn -= hangingColumns - 1;
		
		for (int i = 0; i < length; i++) {
				gameTile[startingRow + (i * rowTraversal)][startingColumn + (i * columnTraversal)] = 1;
		}
	}
	
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < gameTile.length; i++) {
			for (int j = 0; j < gameTile[i].length; j++) {
				toReturn += (gameTile[i][j] == 1 ? stickSymbol : leafSymbol) + " ";
			}
			toReturn += "\n";
		}
		
		return toReturn;
		
		/*
		return 		"O O O O O O O O \n"
				+	"O O O O O O O O \n"
				+	"O O O O O O O O \n"
				+	"O O O O O O O O \n"
				+	"O O O O O O O O \n"
				+	"O O O O O O O O \n"
				+	"O O O O O O O O \n"
				+	"O O O O O O O O \n";
		*/
	}
}
