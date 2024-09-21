package actions;

import java.util.HashMap;
import player.Player;

public class Action {
	public static HashMap<String, Runnable> getActionMethod = new HashMap<String, Runnable>();
	
	public static Player player;
	
	public static String[] allActionNames = {
		"collect sticks",
		"collect loose rocks",
		"forage for food",
	};
	
	public static Runnable[] allActionMethods = {
		Action::collectSticks,
		Action::collectLooseRocks,
		Action::foodForage,
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
	
	
	
	
	
	public static void collectSticks() {
		System.out.println("collect states");
	}
	
	public static void collectLooseRocks() {
		System.out.println("rock and stone");
	}
	
	public static void foodForage() {
		System.out.println("fooooooooof");
	}
}
