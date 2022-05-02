public class Main {

	public static void main(String[] args) {
		// goodGuy
		GameCharacter goodGuy = new GameCharacter("Mario", 5, 10);
		goodGuy.setDescription("He's pretty good");
		goodGuy.setMale(true);
		goodGuy.setHeight(140);
		
		//badGuy
		GameCharacter badGuy = new GameCharacter("Bowser", 75, 100);
		badGuy.setDescription("He's just the worst");
		badGuy.setMale(true);
		badGuy.setHeight(510);
		
		//princess
		GameCharacter princess = new GameCharacter("Peach", 1, 1);
		princess.setDescription("Seems to love being captured");
		princess.setMale(false);
		princess.setHeight(160);
	}
}