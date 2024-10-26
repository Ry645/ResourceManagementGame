//battleship : stick
//hot and cold
//multiply column and row

package minigames;

import utils.*;

/**
 * the direction a stick can face.
 */
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
	/**
     * the symbol of a leaf in this minigame.
     */
    public static final String leafSymbol = "·";
    
    /**
     * the symbol of a stick in this minigame.
     */
	public static final String stickSymbol = "#";
	
	private static final int totalRows = 8;
	private static final int totalColumns = 8;
	
	private static int[] possibleLengths = 	{4,  5,  6,  7};
	private static int[] weightsToLengths = {10, 40, 30, 20};
	
    //associates direction enum to what x and y direction the stick origin moves
	private static int[] directionToColumnTraversal = 	{1,  1,  0, -1, -1, -1, 0, 1};
	private static int[] directionToRowTraversal = 		{0, -1, -1, -1,  0,  1, 1, 1};
	
	//stores where the stick is
	private int[][] gameTile = new int[totalRows][totalColumns];
	
	private int startingRow;
	private int startingColumn;
	private int direction;
	private int length;
	
	public static void main(String[] args) {
		StickMinigame stickMinigame = new StickMinigame(0, 0, 1, 6);
		System.out.println(stickMinigame);
		return;
	}
	
	//TODO RAND
	// value = 13
	// row = 13 / 8 = 1
	// column = 13 % 8 = 5
    /**
     * constructs a stick minigame with a random stick location and orientation.
     */
	public StickMinigame() {
		int startingIndex = (int) (Math.random() * (totalRows * totalColumns));
		startingRow = startingIndex / totalColumns;
		startingColumn = startingIndex % totalRows;
		
		direction = (int) (Math.random() * 8);
		
		length = possibleLengths[Utils.getRandomIndexFromWeights(weightsToLengths)];
		
		generateStickInGameTile();
	}
	
	//for testing
    /**
     * constructs a stick minigame.
     */
	public StickMinigame(int startingRow, int startingColumn, int direction, int length) {
		this.startingRow = startingRow;
		this.startingColumn = startingColumn;
		
		this.direction = direction;
		
		this.length = length;
		
		generateStickInGameTile();
	}
	
	//INFO this works well
	//returns the number of points hanging off the tile
    /**
     * returns the number of points on a line hanging off a maximum value.
     *
     * @param start starting point
     * @param length length of line
     * @param traversalDirection the direction of movement of the line
     * @param maximum the maximum length the line can go without hanging off
     */
	public static int calculateHangingPointsCount(int start, int length, int traversalDirection, int maximum) {
		int endpoint = (start + length * traversalDirection);
		int toSubtract = endpoint < 0 ? 0 : maximum - 1;
		int hangingPointsCount = endpoint / maximum != 0 || endpoint < 0 ? (endpoint - toSubtract) : 0;
		return Math.abs(hangingPointsCount);
	}
	
	// generates a stick in the gameTile array
	// shifts the stick based on whether or not it would hang off the tile if not shifted
    /**
     * generates the stick in the game tile.
     */
	public void generateStickInGameTile() {
		//INFO : THAT'S FUKIN CLEANNNNNNNNN
		//-1, 0, or 1
		int rowTraversal = directionToRowTraversal[direction];
		int columnTraversal = directionToColumnTraversal[direction];
		
		//INFO : this took forever
		int hangingRows = calculateHangingPointsCount(startingRow, length, rowTraversal, totalRows);
		//shifts the stick based on the number of hanging
		startingRow -= (hangingRows - (hangingRows == 0 ? 0 : 1)) * rowTraversal;
		
		int hangingColumns = calculateHangingPointsCount(startingColumn, length, columnTraversal, totalColumns);
		startingColumn -= (hangingColumns - (hangingColumns == 0 ? 0 : 1)) * columnTraversal;
		
		for (int i = 0; i < length; i++) {
				gameTile[startingRow + (i * rowTraversal)][startingColumn + (i * columnTraversal)] = 1;
		}
	}
	
    @Override
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
