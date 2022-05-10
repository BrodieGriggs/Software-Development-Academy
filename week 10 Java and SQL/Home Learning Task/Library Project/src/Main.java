import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static Scanner scn = new Scanner(System.in);
	public static boolean loopRunning = true;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Database library = new Database("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/library", "root", "root");
		
		while(loopRunning) {
			int userInput = library.getUserInput();
			library.handleUserInput(userInput);
		}
		
		if(!loopRunning) {
			scn.close();
		}
	}
	
	
	
	public static void clearConsole() {
		String str = "";
		for(int i = 0; i < 50; i++) {
			str += "\n";
		}
		System.out.println(str);
	}
	
	public static void waitForKeyPress() {
		System.out.println("\nPLEASE PRESS ENTER TO CONTINUE");
		scn.nextLine();
	}
}