import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Database {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	private String queryString;
	
	public Database(String driver, String database, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		this.conn = DriverManager.getConnection(database, username, password);
	}
	
	public void query(String query) throws SQLException {
		try {
			this.stmt = this.conn.createStatement();
			this.rs = stmt.executeQuery(query);
			this.rsmd = this.rs.getMetaData();
			
			printResults();
		}
		catch(Exception e) {
			Main.clearConsole();
			displayTitle();
			System.out.println("Invalid Query");
			Main.scn.nextLine();
		}
	}
	
	public void printResults() throws SQLException {
		Main.clearConsole();
		int totalFields = this.rsmd.getColumnCount();
		while(rs.next()) {
			for(int i = 1; i <= totalFields; i++) {
				if(i > 1) System.out.print(", ");
				String fieldValue = rs.getString(i);
				System.out.print(fieldValue);
			}
			System.out.println();
		}
		Main.waitForKeyPress();
	}
	
	public void displayTitle() {
		String title = "\n";
		title += "██\\       ██\\ ██\\ \n";
		title += "██ |      \\__|██ |\n";
		title += "██ |      ██\\ ███████\\   ██████\\  ██████\\   ██████\\  ██\\   ██\\ \n";
		title += "██ |      ██ |██  __██\\ ██  __██\\ \\____██\\ ██  __██\\ ██ |  ██ |\n";
		title += "██ |      ██ |██ |  ██ |██ |  \\__|███████ |██ |  \\__|██ |  ██ |\n";
		title += "██ |      ██ |██ |  ██ |██ |     ██  __██ |██ |      ██ |  ██ |\n";
		title += "████████\\ ██ |████████ |██ |     \\███████ |██ |      \\███████ |\n";
		title += "\\________|\\__|\\_______/ \\__|      \\_______|\\__|       \\____██ |\n";
		title += "                                                     ██\\   ██ |\n";
		title += "███████████████████████████████████████████████████\\ \\██████  |\r\n";
		title += "\\___________________________________________________| \\______/\n";
		System.out.println(title);
	}
	
	public void displayMenu() {
		String options = "PLEASE SELECT FROM THE FOLLOWING OPTIONS:\n\n";
		options += "1: Show all users.            2: Show all books.\n\n";
		options += "3: Show all users that have books loaned.\n\n";
		options += "4: Show all books that are loaned by users.\n\n";
		options += "5: Show all loaned books and the users who loaned them.\n\n";
		options += "6: Show all overdue books and the users who loaned them.\n\n";
		options += "7: Custom query.              8: Exit this program.\n\n";
		options += " -------> ";
		System.out.print(options);
	}
	
	public int getUserInput() {
		
		// Get user input
		int userInput = -1;
		while(userInput == -1) {
			
			Main.clearConsole();
			displayTitle();
			displayMenu();
			
			String input = Main.scn.nextLine();
			
			try // check if input is an integer
			{ 
				Integer.parseInt(input);
				userInput = Integer.parseInt(input);
			}  
			catch (NumberFormatException e)  
			{ 
				continue;
			}
			
			// check if input is between 1 and 8
			if(userInput < 1 || userInput > 8) { 
				userInput = -1;
				continue;
			}
		}
		return userInput;
	}
	
	public void handleUserInput(int input) throws SQLException {
		if(input < 7) {
			getQueryFromUserInput(input);
			query(this.queryString);
		}
		else if(input == 7) {
			Main.clearConsole();
			displayTitle();
			System.out.println("Please enter a custom query:");
			this.queryString = Main.scn.nextLine();
			query(this.queryString);
		} else {
			Main.clearConsole();
			displayTitle();
			System.out.println("                    - > >  Offline  < < -");
			Main.loopRunning = false;
		}
	}
	
	private void getQueryFromUserInput(int input) {
		switch(input) {
		case 1:
			this.queryString = "SELECT * FROM Users";
			break;
		case 2:
			this.queryString = "SELECT * FROM Books";
			break;
		case 3:
			this.queryString = "SELECT Users.user_id, Users.First_name, Users.Last_name FROM Users\n"
				  + "INNER JOIN Loaned ON Users.user_id = Loaned.user_id;";
			break;
		case 4:
			this.queryString = "SELECT Books.ISBN, Books.title, Books.author FROM Books\r\n"
				  + "INNER JOIN Loaned ON Books.ISBN = Loaned.ISBN;";
			break;
		case 5:
			this.queryString = "SELECT\n"
				  + "	 Users.user_id,\n"
				  + "    Users.First_name,\n"
				  + "    Users.Last_name,\n"
				  + "    Books.title, Books.author,\n"
				  + "    Books.ISBN,\n"
				  + "    Loaned.date_lent,\n"
				  + "    Loaned.due_date\n"
				  + "FROM Users\n"
				  + "INNER JOIN Loaned ON Users.user_id = Loaned.user_id\n"
				  + "INNER JOIN Books ON Loaned.ISBN = Books.ISBN;";
			break;
		case 6:
			this.queryString = "SELECT\r\n"
				  + " 	 Users.user_id,\r\n"
				  + "    Users.First_name,\r\n"
				  + "    Users.Last_name,\r\n"
				  + "    Books.title, Books.author,\r\n"
			   	  + "    Books.ISBN,\r\n"
			 	  + "    Loaned.date_lent,\r\n"
			 	  + "    Loaned.due_date\r\n"
			 	  + "FROM Users\r\n"
			 	  + "INNER JOIN Loaned ON Users.user_id = Loaned.user_id\r\n"
			 	  + "INNER JOIN Books ON Loaned.ISBN = Books.ISBN\r\n"
			 	  + "WHERE Loaned.due_date < CURDATE();";
			break;
		}
	}
}
