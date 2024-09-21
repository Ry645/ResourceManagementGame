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
		
		System.out.println("You're in a forest. What do you do?");
		for (int i = 0; i < actions.length; i++) {
			System.out.println(actions[i].name + " " + i);
		}
		
		int actionIndex = sc.nextInt();
		
		System.out.printf("You %s.\n", actions[actionIndex].name);
		actions[actionIndex].doAction();
		
		sc.close();
	}
	
	public static Action[] generateActions(Player player) {
		String[] allActionNames = Action.allActionNames;
		Action[] actionObjects = new Action[allActionNames.length];
		for (int i = 0; i < allActionNames.length; i++) {
			actionObjects[i] = new Action(allActionNames[i], player);
		}
		return actionObjects;
	}
}
