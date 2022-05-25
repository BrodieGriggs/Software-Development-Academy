package main;
import java.util.HashMap;

public class Map {
	
	/* 2d array to hold gridCells, each cell
	 * object can be accessed as: gridCell = grid[x][y] */
	private GridCell[][] grid;
	
	private int gridWidth;
	private int gridHeight;
	
	private int[] treasureLocation;
	private boolean powerUpPresent = false;
	private int[] powerUpLocation;
	
	// HashMap to hold different types of cell and their appearance
	private HashMap<String, String> cellTypes = new HashMap<String, String>();
	
	public HashMap<String, String> getCellTypes() {
		return cellTypes;
	}

	// Constructor
	public Map(int gridWidth, int gridHeight) {
		// assign size variables
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		
		// put cell types to HashMap
		this.cellTypes.put("hidden", "███");
		this.cellTypes.put("border", "[X]");
		this.cellTypes.put("nothing", "   ");
		this.cellTypes.put("player", "(P)");
		this.cellTypes.put("treasure", "(T)");
		this.cellTypes.put("powerup", "(+)");
	}
	
	public void populateGrid(int[] playerPosition) {
		// set grid array size
		this.grid = new GridCell[gridWidth][gridHeight];
		
		// iterate through columns
		for(int i = 0; i < this.gridWidth; i++) {
			//iterate through rows
			for(int j = 0; j < this.gridHeight; j++) {
				//create edges
				if(i == 0 || i == this.gridWidth-1 || j == 0 || j == this.gridHeight-1) {
					this.grid[i][j] = new GridCell(this.cellTypes.get("border"));
					this.grid[i][j].discover();
				} else {
					// place empty cells
					this.grid[i][j] = new GridCell(this.cellTypes.get("nothing"));
				}
			}
		}
		// place treasure
		int[] treasureLocation = getRandomEmptyCell(playerPosition);
		this.grid[treasureLocation[0]][treasureLocation[1]].setCellType(this.cellTypes.get("treasure"));
		this.treasureLocation = new int[] {treasureLocation[0],treasureLocation[1]};
		
		// place power-up
		int[] powerUpLocation = getRandomEmptyCell(playerPosition);
		this.grid[powerUpLocation[0]][powerUpLocation[1]].setCellType(this.cellTypes.get("powerup"));
		this.powerUpLocation = new int[] {powerUpLocation[0],powerUpLocation[1]};
		this.powerUpPresent = true;
	}
	
	// Get location of treasure as int[x,y]
	public int[] getTreasureLocation() { return this.treasureLocation; }
	
	public boolean isPowerUpPresent() { return this.powerUpPresent; }
	// Get location of powerUp as int[x,y]
	public int[] getPowerUpLocation() { return this.powerUpLocation; }
	
	// Remove powerUp
	public void removePowerUp() {
		this.powerUpPresent = false;
		this.grid[this.powerUpLocation[0]][this.powerUpLocation[1]].setCellType(this.cellTypes.get("nothing"));;
		this.powerUpLocation = new int[] {-1, -1};
	}
	
	// Choose a random empty cell from grid
	public int[] getRandomEmptyCell(int[]playerPosition) {
		boolean locationChosen = true;
		int randomX = -1;
		int randomY = -1;
		do {
			locationChosen = true;
			
			// generate random x and y
			randomX = Main.getRandomIntInRange(0, this.gridWidth-1);
			randomY = Main.getRandomIntInRange(0, this.gridHeight-1);
			
			// check the gridCell at [x,y] is cellType "nothing"
			if(this.grid[randomX][randomY].getCellType() != this.cellTypes.get("nothing")) {
				locationChosen = false;
			}
			
			/* Player's data isn't combined with the grid until
			 * it is placed in tempGrid during 'rendering'. So
			 * perform a separate check to prevent choosing player's location */
			if(playerPosition[0] == randomX && playerPosition[1] == randomY) {
				locationChosen = false;
			}
		} while(!locationChosen);
		
		return new int[] {randomX, randomY };
	}
	
	// Get the dimensions of the grid as int[x,y]
	public int[] getDimensions() { return new int[] {this.gridWidth, this.gridHeight}; }
	
	// Increase the grid dimensions by int[x,y]
	public void increaseDimensions(int x, int y) {
		this.gridWidth += x;
		this.gridHeight += y;
	}
	
	// 'Render' the grid to the console
	public void show(Player player) {
		int[] playerPos = player.getPosition();
		String output = "";
		
		// Make a copy of the grid to make temporary changes to
		GridCell[][] tempGrid = new GridCell[this.gridWidth][this.gridHeight];
		for(int i = 0; i < this.gridWidth; i++) {
			for(int j = 0; j < this.gridHeight; j++) {
				tempGrid[i][j] = grid[i][j].copy();
			}
		}
		
		// Add the player to the grid by changing a cellType
		tempGrid[playerPos[0]][playerPos[1]].setCellType(this.cellTypes.get("player"));
		tempGrid[playerPos[0]][playerPos[1]].discover();
		
		// Revealing cells near the player
		/* setting up useful variables for determining
		 * cells to reveal.
		 * Check for values outside of array index */
		int viewDist = player.getViewDistance();
		int xStart = playerPos[0] - viewDist;
		if(xStart < 0) { xStart = 0; }
		int xEnd = playerPos[0] + viewDist;
		if(xEnd > this.gridWidth-1) { xEnd = this.gridWidth-1; }
		int yStart = playerPos[1] - viewDist;
		if(yStart < 0) { yStart = 0; }
		int yEnd = playerPos[1] + viewDist;
		if(yEnd > this.gridHeight-1) { yEnd = this.gridHeight-1; }
		// reveal cells
		for(int i = xStart; i <= xEnd ; i++) {
			for(int j = yStart; j <= yEnd; j++) {
				tempGrid[i][j].discover();
				//grid[i][j].discover();
			}
		}
			
		/* console prints rows not columns,
		 * so need to access data in groups
		 * of y values:
		 * [x,y]
		 * [0][0],[1][0],[2][0]...
		 * [0][1],[1][1],[2][1]...
		 * 
		 * First line will be all of y=0
		 * next all of y=1, etc...*/
		for(int i = 0; i < this.gridHeight; i++) {
			for(int j = 0; j < this.gridWidth; j++) {
				//check if cell is discovered
				if(tempGrid[j][i].isDiscovered()) { output += tempGrid[j][i].getCellType(); }
				else { output += this.cellTypes.get("hidden"); }				
			}
			//new line at end of row
			output += "\n";
		}
		
		// Display output in the console
		System.out.print(output);
	}
	
	// Show the game intro screen
	public void showIntro() {
		Main.clearConsole();
		System.out.println(
			"[X][X][X][X][X][X][X][X][X][X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]    CONSOLE EXPLORER    [X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X][X][X][X][X][X][X][X][X][X]"
		);
	}
	
	// Show the powerUp screen
	public void showPowerUp() {
		Main.clearConsole();
		System.out.println(
			"[X][X][X][X][X][X][X][X][X][X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]    View Distance +1    [X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X][X][X][X][X][X][X][X][X][X]"
		);
	}
	
	// show the next level screen
	public void showNextLevelText() {
		Main.clearConsole();
		System.out.println(
			"[X][X][X][X][X][X][X][X][X][X]\n" +
			"[X]                        [X]\n" +
			"[X]                        [X]\n" +
			"[X]     You found the      [X]\n" +
			"[X]       treasure!        [X]\n" +
			"[X]                        [X]\n" +
			"[X]    Advancing to the    [X]\n" +
			"[X]       next cave!       [X]\n" +
			"[X]                        [X]\n" +
			"[X][X][X][X][X][X][X][X][X][X]"
		);
	}
}
