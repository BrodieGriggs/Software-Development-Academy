let fruits = ["Apple", "Orange", "Banana", "Pear", "Peach", "Strawberry", "Cherry", "Acai"];
let totalVowels = 0;
let totalConsonants = 0;

fruits.forEach(fruit => {
  let vowels = fruit.match(/[aeiou]/ig).length; // regex matches aeiou, ignoring case
  let consonants = fruit.match(/(?![aeiou])[a-z]/ig).length; // regex matches any a-z except aeiou, ignoring case

  let determiner = "A";
  if(/^[aeiou]/i.test(fruit)) { determiner = "An"; } // statement evaluates to true if fruit begins with aeiou, ignoring case

  const vowelString = `${vowels} vowel${vowels > 1 ? "s" : ""}`;
  const consonantString = `${consonants} consonant${consonants > 1 ? "s" : ""}`;

  totalVowels += vowels;
  totalConsonants += consonants;

  console.log(`${determiner} ${fruit} has ${vowelString} and ${consonantString}.`);
});

const vowelString = `${totalVowels} vowel${totalVowels > 1 ? "s" : ""}`;
const consonantString = `${totalConsonants} consonant${totalConsonants > 1 ? "s" : ""}`;

console.log(`A total of ${vowelString} and ${consonantString} are required.`);