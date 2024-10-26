package player;

/**
 * a system that manages the health of an entity.
 *
 * @author Ryan Sexton
 * @version 1.0
 */
public class HealthSystem {
	private int health = 10;
	private int minHealth = 0;
	private int maxHealth = 10;
	
    /**
     * constructs a health system.
     */
	public HealthSystem(int health, int minHealth, int maxHealth) {
		this.health = health;
		this.minHealth = minHealth;
		this.maxHealth = maxHealth;
	}
	
    /**
     * subtracts the health by an amount.
     *
     * @param damage the damage to subtract to the health
     */
	public void takeDamage(int damage) {
		health -= damage;
	}
    
    
    

    public int getHealth() {
        return health;
    }

    public int getMinHealth() {
        return minHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}

