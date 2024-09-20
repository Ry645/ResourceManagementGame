public class HungerSystem {
	public int hunger = 10;
	public int minHunger = 0;
	public int maxHunger = 10;
	
	public HungerSystem(int hunger, int minHunger, int maxHunger) {
		this.hunger = hunger;
		this.minHunger = minHunger;
		this.maxHunger = maxHunger;
	}
	
	public void useHunger(int val) {
		hunger -= val;
	}
}
