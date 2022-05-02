
public class GridCell {
	private String cellType;
	private boolean discovered = false;
	
	// Constructor
	public GridCell(String cellType) {
		this.cellType = cellType;
	}
	
	// Get the cellType as String
	public String getCellType() {
		return this.cellType;
	}
	
	// Set the cellType to given String
	public void setCellType(String cellType) {
		this.cellType = cellType;
	}
	
	public boolean isDiscovered() { return this.discovered; }
	
	// Reveal gridCell
	public void discover() { this.discovered = true; }
	public void hide() { this.discovered = false; }
	
	// Copy this gridCell
	public GridCell copy() {
		GridCell copy = new GridCell(this.cellType);
		copy.discovered = this.discovered;
		return copy;
	}
}
