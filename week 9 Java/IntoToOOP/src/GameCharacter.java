public class GameCharacter {
	private String name;
	private String description;
	private boolean isMale;
	private int currentHealth;
	private int maxHealth;
	private int height;
	private int strength;
	private int jumpHeight;
	
	// constructors
	public GameCharacter(String name) {
		this.name = name;
	}
	public GameCharacter(String name, int currentHealth, int maxHealth) {
		this.name = name;
		this.currentHealth = currentHealth;
		this.maxHealth = maxHealth;
	}
	
	// getters and setters
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}


	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getJumpHeight() {
		return jumpHeight;
	}
	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	}


	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}


	public String getName() {
		return name;
	}
	
	
	public int getMaxHealth() {
		return maxHealth;
	}
}
