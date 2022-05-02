import java.util.*;

public class Main {
	
	// Display player position and controls in console
	public static void showInfo(int[] position) { System.out.println("("+position[0]+","+position[1]+")" + "    A: ← ,  W: ↑ ,  D: → ,  S: ↓"); }
	
	// Get a random integer in a range
	public static int getRandomIntInRange(int min, int max) {
		return ( min + (int)(Math.random() * ((max - min) + 1)) );
	}
	
	/* Clear the console.
	 * I tried multiple methods for actually clearing
	 * the console, but I couldn't get any of them to
	 * work so instead I advance the console by 50 lines */
	public static void clearConsole() { 
		String newLines = "";
		for(int i = 0; i < 50; i++) {
			newLines += "\n";
		}
		System.out.println(newLines);
	}
	
	// Pause the game for a given number of seconds
	public static void pauseGame(int duration) {
		try {
			Thread.sleep(duration*1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner consoleScanner = new Scanner(System.in);
		
		// Create map, can't be smaller than 4x4
		Map gameGrid = new Map(10, 10);
		
		// Show intro and pause for 3s
		gameGrid.showIntro();
		pauseGame(3);
		
		// Create  player
		Player player = new Player(1, 1);
		
		// Populate gameGrid with cells
		gameGrid.populateGrid(player.getPosition());
		
		// Game loop variable
		boolean gameRunning = true;
		
		// 'Render' the game
		clearConsole();
		gameGrid.show(player);
		showInfo(player.getPosition());
		
		// Main game loop
		while(gameRunning) {
			// Wait for userInput
			System.out.print("Please enter a move: ");
			String userInput = consoleScanner.nextLine();
			
			// Update playerPostion based on userInput
			player.updatePosition(userInput, gameGrid.getDimensions()[0], gameGrid.getDimensions()[1]);
			
			/* If player is on the treasure (finish), show the
			 * next level screen, increase the dimensions of
			 * the gameGrid and set up the next level */
			if(player.checkCollision(gameGrid.getTreasureLocation())) {
				gameGrid.showNextLevelText();
				pauseGame(2);
				if(gameGrid.getDimensions()[0] < 25) { // max grid size of 25
					gameGrid.increaseDimensions(5, 5);
				}
				clearConsole();
				gameGrid.populateGrid(player.getPosition());
				gameGrid.show(player);
				showInfo(player.getPosition());
				continue;
			}
			
			/* If player is on the powerUp, show the powerUp
			 * screen, apply the powerUp and remove the powerUp
			 * cell from the gameGrid */
			if(player.checkCollision(gameGrid.getPowerUpLocation())) {
				gameGrid.showPowerUp();
				pauseGame(1);
				player.increaseViewDistance(1);
				gameGrid.removePowerUp();
				
			}
			
			// 'Render' the game
			clearConsole();
			gameGrid.show(player);
			showInfo(player.getPosition());
			
			// Display last move made			
			if(player.getLastMove() != null) {
				System.out.println("Your last move: " + player.getLastMove());
			}
			
		}
		// close scanner
		consoleScanner.close();
	}

}
