//Tags: TEMP, TEST

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
		
		Player player = new Player(name, 10, 0, 10, 10, 0, 10);
		Action.init(player);
		
		System.out.printf("New Character: %s\nHealth: %d\nHunger: %d\n\n", player.name,
			player.healthSystem.health, player.hungerSystem.hunger
		);
		
		Action[] actions = generateActions(player);
		
		while (true) {
			System.out.println("You're in a forest. What do you do?");
			//TEST make sure prints out same
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
			
			//TEMP make different action eventually?
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
	
	//TODO will eventually slowly introduce actions to the player as progression increases
	public static Action[] generateActions(Player player) {
		String[] allActionNames = Action.allActionNames;
		Action[] actionObjects = new Action[allActionNames.length];
		for (int i = 0; i < allActionNames.length; i++) {
			actionObjects[i] = new Action(allActionNames[i], player);
		}
		return actionObjects;
	}
	
	public static void printActions(Action[] actions) {
		for (int i = 0; i < actions.length; i++) {
			System.out.println(actions[i].name + " " + i);
		}
	}
}
