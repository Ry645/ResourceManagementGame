package player;

/**
 * a system that manages the hunger of an entity.
 *
 * @author Ryan Sexton
 * @version 1.0
 */
public class HungerSystem {
	private int hunger = 10;
	private int minHunger = 0;
	private int maxHunger = 10;
	
    /**
     * constructs a hunger system.
     */
	public HungerSystem(int hunger, int minHunger, int maxHunger) {
		this.hunger = hunger;
		this.minHunger = minHunger;
		this.maxHunger = maxHunger;
	}
	
    /**
     * uses up hunger by an amount.
     *
     * @param val the amount of hunger to use
     */
	public void useHunger(int val) {
		hunger -= val;
	}
    
    
    

    public int getHunger() {
        return hunger;
    }

    public int getMinHunger() {
        return minHunger;
    }

    public int getMaxHunger() {
        return maxHunger;
    }
    
    
}
