package player;

import inventory.Inventory;

public class Player {
	public String name = "player";
	public int inventorySize = 32;
	public Inventory inventory;
	
	public HealthSystem healthSystem;
	public HungerSystem hungerSystem;
	
	public Player(String name1, int health, int minHealth, int maxHealth,
		int hunger, int minHunger, int maxHunger
	) {
		if (!name1.equals("")) {
			name = name1;
		}
		
		inventory = new Inventory();
		healthSystem = new HealthSystem(health, minHealth, maxHealth);
		hungerSystem = new HungerSystem(hunger, minHunger, maxHunger);
	}
	
}
