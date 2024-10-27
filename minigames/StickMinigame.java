//battleship : stick
//hot and cold
//multiply column and row

package minigames;

import java.util.Scanner;

import item.ItemStruct;
import player.Player;
import utils.*;

//technically does nothing
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

//does nothing
enum SegmentType {
    LEAF,
    HIDDEN_STICK,
    EMPTY,
    REVEALED_STICK,
}

public class StickMinigame {
	/**
     * the symbol of a leaf in this minigame.
     */
    public static final String LEAF_SYMBOL = "·";
    
    /**
     * the symbol of a stick in this minigame.
     */
	public static final String STICK_SYMBOL = "#";
    
    /**
     * the symbol of a empty patch in this minigame.
     */
	public static final String EMPTY_SYMBOL = " ";
    
    
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
		System.out.println(stickMinigame.minigameBoard(false));
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
    
    /**
     * plays this stick minigame.
     * the player reveals leaves to find a stick.
     * once the player sees the entire stick, they get a stick.
     *
     * @param player the player attempting the minigame
     */
    public void playMinigame(Player player) {
        Scanner sc = player.getPlayerInput();
        boolean wonMinigame = false;
        while (true) {
            //print out minigameBoard
            System.out.println(minigameBoard(false));
            
            //prompt user to type in row and column
            System.out.print("Enter a column and row (starts at 0): ");
            
            int[] rowAndColumn = new int[2];
            int[] maxRowAndColumn = {totalRows, totalColumns};
            int index = rowAndColumn.length - 1;
            while (index >= 0) {
                int input = 0;
                if (sc.hasNextInt()) {
                    input = sc.nextInt();
                } else {
                    sc.nextLine();
                    System.out.print("Input invalid; try again: ");
                    continue;
                }
                
                if (input < 0 || input >= maxRowAndColumn[index]) {
                    sc.nextLine();
                    System.out.print("Input out of bounds; try again: ");
                    continue;
                }
                
                rowAndColumn[index] = input;
                index--;
            }
            //flush input
            sc.nextLine();
            
            //reveal segment
            int segmentVal = gameTile[rowAndColumn[0]][rowAndColumn[1]];
            if (segmentVal == 1) {
                gameTile[rowAndColumn[0]][rowAndColumn[1]] = 3;
            } else if (segmentVal == 0) {
                gameTile[rowAndColumn[0]][rowAndColumn[1]] = 2;
            } // otherwise do nothing
            
            //check if stick is fully revealed
            int count = 0;
            for (int i = 0; i < gameTile.length; i++) {
                for (int j = 0; j < gameTile[i].length; j++) {
                    if (gameTile[i][j] == 3) {
                        count++;
                    }
                }
            }
            if (count >= length) {
                wonMinigame = true;
                break;
            }
        }
        
        //broken out of loop
        if (wonMinigame) {
            //TODO
            System.out.println(minigameBoard(true));
            
            player.getInventory().collect(new ItemStruct("stick", 1));
            System.out.print("You got a stick! Hit enter to continue: ");
            sc.nextLine();
            return;
        }
    }
    
    /**
     * shows the leaves, empty patches, and found stick segments.
     * can be configured to show just the stick.
     * 
     * @param isClear makes the board show only the stick if true
     */
    public String minigameBoard(boolean isClear) {
        String toReturn = "  ";
        for (int i = 0; i < gameTile.length; i++) {
            toReturn += i + " ";
        }
        toReturn += "\n";
        
		for (int i = 0; i < gameTile.length; i++) {
            toReturn += i + " ";
			for (int j = 0; j < gameTile[i].length; j++) {
                String toAdd;
                // distinction
                String leafSymbol = isClear ? EMPTY_SYMBOL : LEAF_SYMBOL;
                switch (gameTile[i][j]) {
                    case 0: //LEAF
                        toAdd = leafSymbol;
                        break;
                    case 1: //HIDDEN_STICK
                        toAdd = leafSymbol;
                        break;
                    case 2: //EMPTY
                        toAdd = EMPTY_SYMBOL;
                        break;
                    case 3: //REVEALED_STICK
                        toAdd = STICK_SYMBOL;
                        break;
                    default: //handle error
                        toAdd = EMPTY_SYMBOL;
                        break;
                }
				toReturn += toAdd + " ";
			}
			toReturn += "\n";
		}
		
		return toReturn;
    }
}
