import java.util.Scanner;

public class Main {
	
	// method for Part 1
	static String reverseSentence(String sentence) {
		// Check for "?" or "!", record and remove it
		boolean questionMark = false;
		boolean exclamationMark = false;
		if(sentence.indexOf("?") != -1) {
			questionMark = true;
			sentence = sentence.replace("?", "");
		}
		if(sentence.indexOf("!") != -1) {
			exclamationMark = true;
			sentence = sentence.replace("!", "");
		}
		
		/* 2) Create another string called ‘reverseSentence’
		with not value assigned to it*/
		String reverseSentence = null;
		
		/* 3) Using string methods, split the string into
		individual words using space ‘ ‘ as the “splitter”.
		You will need to assign the result of the split
		string to a string array. */
		String[] stringArr = sentence.split(" ");
		
		/* 4) Create a for loop that will iterate through
		the array of words backwards. */
		for(int i = stringArr.length - 1; i >= 0; i--) {
			
			/* 5) Within the loop update the value of
			‘reverseSentence’ to add in the words */
			
			// get the current word
			String currentWord = stringArr[i];
			
			/* if the word is the first to be added,
			it should be capitalised. Otherwise, just
			add the lower case word. */
			
			if(reverseSentence == null) {
				reverseSentence = currentWord.substring(0, 1).toUpperCase() + currentWord.substring(1).toLowerCase();
			}
			
			// check for "I" to capitalise
			else if(currentWord.equals("i") || currentWord.equals("I")) {
				reverseSentence += " " + currentWord.toUpperCase();
			} else {
				reverseSentence += " " + currentWord.toLowerCase();
			}
		}
		
		/* If the original string used a "!" or a "?",
		add the relevant punctuation to the end of the
		string */
		if(questionMark) { reverseSentence += "?"; }
		if(exclamationMark) { reverseSentence += "!"; }
		
		// return the new string
		return reverseSentence;
	}
	
	
	// method for Part 2
	static void reverseWords(String[] wordList) {
		/* 2) Create a string called ‘reversedWord’ and
		do not assign it a value.
		
		3) Similar to the above challenge, however,
		instead of reversing a sentence, reverse the
		order of the letters within each string. */
		String reversedWord = "";
		
		// iterate through wordList
		for(int i = 0; i < wordList.length; i++) {
			
			/* iterate through each char of the word
			in reverse, adding each char to reversedWord */
			for(int j = wordList[i].length() - 1; j >= 0; j--) {
				
				// first letter is capitalised
				if(j == wordList[i].length() - 1) { reversedWord += Character.toUpperCase(wordList[i].charAt(j)); }
				
				// all others are not
				else { reversedWord += Character.toLowerCase(wordList[i].charAt(j)); }
			}
			
			// Print the reversed word on screen
			System.out.println(reversedWord);
			
			// reset reversedWord
			reversedWord = "";
		}
	}
	
	public static void main(String[] args) {
		/*
		Part 1:
		1) Create a string called ‘sentence’ and assign
		the value “Are you as excited as I am?” 
		
		6) Print the result to the screen.
		*/
		System.out.println(reverseSentence("Are you as excited as I am?"));
		
		/*
		Part 2:
		1) Create an array of words called ‘wordList’ and
		assign the values ‘Stressed’, ‘Parts’, ‘Straw’,
		‘Keep’, ‘Wolf’.
		 */
		String[] wordList = {"Stressed", "Parts", "Straw", "Keep", "Wolf"};
		reverseWords(wordList);
	}
}
