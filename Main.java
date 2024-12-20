//todo tags: TEMP, TEST, WARNING, FINISH, RAND
//info tags: INFO

import java.util.Scanner;

import actions.*;
import player.Player;

//TODO make the print output a little more readable somehow
//use scanner to slow down text output
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Hit enter to start game! ");
		sc.nextLine();
		
		System.out.print("Enter the name of your character: ");
		String name = sc.nextLine();
		
		Player player = new Player(name, 10, 0, 10, 10, 0, 10, sc);
		
		System.out.printf("New Character: %s\nHealth: %d\nHunger: %d\n\n", player.getName(),
			player.getHealthSystem().getHealth(), player.getHungerSystem().getHunger()
		);
		
		Action[] actions = Action.generateActions(player);
		
		while (true) {
			System.out.println("You're in a forest. What do you do?");
			printActions(actions);
			
			int actionIndex;
			
			while (true) {
				actionIndex = sc.nextInt();
				
				if ((actionIndex < 0 || actionIndex >= actions.length) && actionIndex != -1) {
					System.out.println("invalid option, please try again");
					continue;
				}
				break;
			}
			
			//TODO TEMP make different action eventually?
			if (actionIndex == -1) {
				System.out.println("Exiting program...");
				System.out.println();
				break;
			}
			
			//TODO migrate to actual action methods
			//System.out.printf("You %s.\n", actions[actionIndex].name);
			
			actions[actionIndex].doAction();
			System.out.println();
		}
		
		
		sc.close();
	}
    	
	public static void printActions(Action[] actions) {
		for (int i = 0; i < actions.length; i++) {
			System.out.println(actions[i].getName() + " " + i);
		}
	}
}
