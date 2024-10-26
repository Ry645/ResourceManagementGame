package player;

import inventory.Inventory;

/**
 * a player of this game.
 *
 * @author Ryan Sexton
 * @version 1.0
 */
public class Player {
	private String name = "player";
	private int inventorySize = 32;
	private Inventory inventory;
	
	private HealthSystem healthSystem;
	private HungerSystem hungerSystem;
	
    /**
     * constructs a player.
     */
	public Player(String name, int health, int minHealth, int maxHealth,
		int hunger, int minHunger, int maxHunger
	) {
		if (name.equals("")) {
			this.name = "player";
		} else {
            this.name = name;
        }
		
		inventory = new Inventory();
		healthSystem = new HealthSystem(health, minHealth, maxHealth);
		hungerSystem = new HungerSystem(hunger, minHunger, maxHunger);
	}
    
    
    
    
    
    public String getName() {
        return name;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public HealthSystem getHealthSystem() {
        return healthSystem;
    }

    public HungerSystem getHungerSystem() {
        return hungerSystem;
    }
	
    
}
