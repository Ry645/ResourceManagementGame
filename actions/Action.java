package actions;

import java.util.HashMap;
import player.Player;
import item.ItemStruct;

public class Action {
	public static HashMap<String, Runnable> getActionMethod = new HashMap<String, Runnable>();
	
	public static Player player;
	
	public static String[] allActionNames = {
		"collect sticks",
		"collect loose rocks",
		"forage for food",
		"show inventory",
	};
	
	public static Runnable[] allActionMethods = {
		Action::collectSticks,
		Action::collectLooseRocks,
		Action::foodForage,
		Action::printInventory,
	};
	
	public String name;
	
	public Action(String name, Player player) {
		this.name = name;
	}
	
	//always do this at the very start of the program
	public static void init(Player playerRef) {
		player = playerRef;
		for (int i = 0; i < allActionNames.length; i++) {
			getActionMethod.put(allActionNames[i], allActionMethods[i]);
		}
	}
		
	public void doAction() {
		getActionMethod.get(name).run();
	}
	
	
	
	//#region Action Methods
	
	public static void collectSticks() {
		player.inventory.collect(new ItemStruct("stick", 3));
	}
	
	public static void collectLooseRocks() {
		player.inventory.collect(new ItemStruct("rock", 4));
	}
	
	public static void foodForage() {
		player.inventory.collect(new ItemStruct("berry", 24));
	}
	
	public static void printInventory() {
		System.out.println(player.inventory);
	}
	
	//#endregion
}
