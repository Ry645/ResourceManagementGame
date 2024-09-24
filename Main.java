//Tags: TEMP, TEST

import java.util.Scanner;

import actions.*;
import player.Player;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hit enter to start game!");
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
			
			int actionIndex = sc.nextInt();
			
			//TEMP make different action eventually?
			if (actionIndex == -1) {
				System.out.println("Exiting program...");
				break;
			}
			
			if (actionIndex < 0 || actionIndex >= actions.length) {
				System.out.println("invalid option, please try again");
				continue;
			}
			
			//TODO migrate to actual action methods instead of inlining in the main method
			System.out.printf("You %s.\n", actions[actionIndex].name);
			
			actions[actionIndex].doAction();
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
