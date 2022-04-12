/* 1) Create an array called fruits with the elements... */
let fruits = [
  "Apple",
  "Orange",
  "Banana",
  "Pear",
  "Peach",
  "Strawberry",
  "Cherry",
  "Acai"
];

let totalVowels = 0;
let totalConsonants = 0;

/* 2) Iterate through that array using a for-inloop using
let fruit in fruits. */
for(let fruit in fruits) {
  
  /* 3) Within that loop, create 2 variables called vowels
  and consonants, and set their values to 0. */
  let vowels = 0;
  let consonants = 0;
  let startingVowel = false;

  /* 4) Within the loop, create another loop, but this time
  use a for loop using i as the iterator. */
  for(let i = 0; i < fruits[fruit].length; i++) {
    /* 5) This for loop will want to look through every letter
    of the fruit and determine how many vowels and how many
    consonants are within that word.*/

    /* Define the current character for ease of typing and reading.
    Also convert the character to a lowercase character to reduce
    the number of checks needed */
    const currentChar = fruits[fruit][i].toLowerCase();
    if(currentChar == "a" || currentChar == "e" || currentChar == "i" || currentChar == "o" || currentChar == "u") {
        vowels++;
        if(i == 0) { startingVowel = true; }
      }
    else { consonants++; }
  }

  /* 6) For each element within the array, print out to console... */

  // If the fruit name starts with a vowel, change A to An
  let determiner = "A";
  if(startingVowel) { determiner += "n"; }

  /* create a string that includes the number of vowels or consonants
  and pluralises if necessary */
  const vowelString = `${vowels} vowel${vowels > 1 ? "s" : ""}`;
  const consonantString = `${consonants} consonant${consonants > 1 ? "s" : ""}`;

  totalVowels += vowels;
  totalConsonants += consonants;

  console.log(`${determiner} ${fruits[fruit]} has ${vowelString} and ${consonantString}.`);
}

/* create a string that includes the number of vowels or consonants
and pluralises if necessary */
const vowelString = `${totalVowels} vowel${totalVowels > 1 ? "s" : ""}`;
const consonantString = `${totalConsonants} consonant${totalConsonants > 1 ? "s" : ""}`;

console.log(`A total of ${vowelString} and ${consonantString} are required.`);