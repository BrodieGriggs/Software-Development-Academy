
public class Main {
	
	// task method
	static boolean checkPangram(String sentence) {
		
		boolean result = false;
		
		// 2) Create 26 Boolean variables named a to z
		boolean a = false;
		boolean b = false;
		boolean c = false;
		boolean d = false;
		boolean e = false;
		boolean f = false;
		boolean g = false;
		boolean h = false;
		boolean i = false;
		boolean j = false;
		boolean k = false;
		boolean l = false;
		boolean m = false;
		boolean n = false;
		boolean o = false;
		boolean p = false;
		boolean q = false;
		boolean r = false;
		boolean s = false;
		boolean t = false;
		boolean u = false;
		boolean v = false;
		boolean w = false;
		boolean x = false;
		boolean y = false;
		boolean z = false;
		
		// 3) Create a loop that will iterate over each letter of the sentence
		for(int charIterator = 0; charIterator < sentence.length(); charIterator++) {
			switch(Character.toLowerCase(sentence.charAt(charIterator))) {
			case 'a':
				a = true;
				break;
			case 'b':
				b = true;
				break;
			case 'c':
				c = true;
				break;
			case 'd':
				d = true;
				break;
			case 'e':
				e = true;
				break;
			case 'f':
				f = true;
				break;
			case 'g':
				g = true;
				break;
			case 'h':
				h = true;
				break;
			case 'i':
				i = true;
				break;
			case 'j':
				j = true;
				break;
			case 'k':
				k = true;
				break;
			case 'l':
				l = true;
				break;
			case 'm':
				m = true;
				break;
			case 'n':
				n = true;
				break;
			case 'o':
				o = true;
				break;
			case 'p':
				p = true;
				break;
			case 'q':
				q = true;
				break;
			case 'r':
				r = true;
				break;
			case 's':
				s = true;
				break;
			case 't':
				t = true;
				break;
			case 'u':
				u = true;
				break;
			case 'v':
				v = true;
				break;
			case 'w':
				w = true;
				break;
			case 'x':
				x = true;
				break;
			case 'y':
				y = true;
				break;
			case 'z':
				z = true;
				break;
			}
		}
		
		if(a && b && c && d && e && f && g && h && i && j && k && l && m && n && o && p && q && r && s && t && u && v && w && x && y && z)
		{
			result = true;
		}
			
		
		return result;
	}
	
	
	// alternate method
	static void checkPangramAlt(String sentence) {
		/* create an array of booleans to store the
		 * status of each letter */
		boolean[] letters = new boolean[26];
		
		/* create an array of alphabet letters to use
		 * for checks */
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		/* iterate through the letters and check the
		 * presence of each alphabet letter */
		for(int i = 0; i < alphabet.length; i++) {
			if(sentence.toLowerCase().indexOf(alphabet[i]) != -1) {
				letters[i] = true;
			}
		}
		
		// check boolean values and record missing letters
		String missingLetters = "";
		boolean allTrue = true;
		for(int i = 0; i < letters.length; i++) {
			if(letters[i] == false) {
				if(missingLetters == "") {
					allTrue = false;
					missingLetters += alphabet[i];
				} else {
					missingLetters += ", " + alphabet[i];
				}
			}
		}
		
		// construct and return result
		String result;
		if(allTrue) { result = "The sentence, '" + sentence + "' is a pangram!"; }
		else { 
			result = "The sentence, '" + sentence + "' is not a pangram!";
			result += "\nThe following letters are missing: " + missingLetters;
		}
		
		System.out.println(result);
	}
	
	static void addLine() {
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		/* 1)
		 * Create a String ‘sentence’ with the value
		 * “Sixty zippers were quickly picked from the
		 * woven jute bag.” */
		String sentence = "Sixty zippers were quickly picked from the woven jute bag.";
		
		/* 5) Once the sentence has been fully processed,
		 * evaluate the value of each Boolean:
		 * 
		 * a. Should all of them be true, print the message
		 * ‘the sentence “<sentence>” is a pangram!’
		 * 
		 * b. Should any of them be false, print the message
		 * ‘the sentence “<sentence>” is not a pangram!’ */
		if(checkPangram(sentence)) {
			System.out.println("The sentence, '" + sentence + "' is a pangram!");
		} else {
			System.out.println("The sentence, '" + sentence + "' is not a pangram!");
		}
		
		addLine();
		/* 6) What are the results when you run the code again
		 * but with the following sentences: ... */
		checkPangramAlt("A wizard’s job is to vex chumps quickly in fog.");
		addLine();
		checkPangramAlt("Brown jars prevented the mixture from freezing too quickly.");
		addLine();
		checkPangramAlt("I once went to a quiet place in the Bahamas to see a very dodgy taxman.");
		addLine();
		checkPangramAlt("We promptly judged antique ivory buckles for the next prize.");
	}

}
