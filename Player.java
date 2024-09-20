public class Player {
	public String name = "player";
	public Object[] inventory = new Object[32];
	
	public HealthSystem healthSystem;
	public HungerSystem hungerSystem;
	
	public Player(String name1, int health, int minHealth, int maxHealth,
		int hunger, int minHunger, int maxHunger
	) {
		if (!name1.equals("")) {
			name = name1;
		}
		healthSystem = new HealthSystem(health, minHealth, maxHealth);
		hungerSystem = new HungerSystem(hunger, minHunger, maxHunger);
	}
	
	
}
