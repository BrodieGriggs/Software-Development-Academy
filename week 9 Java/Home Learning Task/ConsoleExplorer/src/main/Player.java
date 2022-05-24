package main;

public class Player {
	private int xPos;
	private int yPos;
	private Character lastMove = null;
	private int viewDistance = 1;
	
	// Constructor
	public Player(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	// Get player position as int[x,y]
	public int[] getPosition() {
		return new int[] {this.xPos, this.yPos};
	}
	
	/* Update player position, prevent moving
	 * outside the game area */
	public void updatePosition(String direction, int gridWidth, int gridHeight) {
		switch(direction.toLowerCase()) {
		case "w": 
			if(yPos > 1) {
				this.yPos -= 1;
				this.lastMove = '↑';
			}
			break;
		case "d":
			if(xPos < gridWidth-2) {
				this.xPos += 1;
				this.lastMove = '→';
			}
			break;
		case "s":
			if(yPos < gridHeight-2) {
				this.yPos += 1;
				this.lastMove = '↓';
			}
			break;
		case "a":
			if(xPos > 1) {
				this.xPos -= 1;
				this.lastMove = '←';
			}
			break;
		}
	}
	
	// Get the player's last move
	public Character getLastMove() {
		return this.lastMove;
	}
	
	// Check if the player's coordinates match given coords[x,y]
	public boolean checkCollision(int[] coords) {
		if(this.xPos == coords[0] && this.yPos == coords[1]) {
			return true;
		}
		return false;
	}
	
	// Get the player's viewDistance
	public int getViewDistance() { return this.viewDistance; }
	
	// Increase the player's viewDistance by a given amount
	public void increaseViewDistance(int amount) {
		this.viewDistance += amount;
	}
}
