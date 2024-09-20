public class HealthSystem {
	public int health = 10;
	public int minHealth = 0;
	public int maxHealth = 10;
	
	public HealthSystem(int health, int minHealth, int maxHealth) {
		this.health = health;
		this.minHealth = minHealth;
		this.maxHealth = maxHealth;
	}
	
	public void takeDamage(int damage) {
		health -= damage;
	}
}

