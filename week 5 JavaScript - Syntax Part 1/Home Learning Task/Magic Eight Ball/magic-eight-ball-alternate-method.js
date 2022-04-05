// set username to user input (or "" if null or no value is entered)
let userName = prompt(`Please enter your name, or hit "OK"`);

/* Log 'Hello!' or 'Hello, userName!' to console depending on
whether a userName was entered */
const greeting = userName == "" || userName == null ? 'Hello!' : `Hello, ${userName}!`;
console.log(greeting);

/* Take a user input question to ask of the magic eight ball.
Reused the value of greeting in this user-facing prompt.
Using a while loop that checks if userQuestion is falsy
("", null, undefined, etc..) and keeps asking for a value
until userQuestion is assigned */
let userQuestion;
while(!userQuestion) {
  userQuestion = prompt(`${greeting} Ask a question of the Magic Eight Ball:`);
}

// if null or no username was entered, use a default name
if(userName == "" || userName == null) { userName = "User"; }
console.log(`${userName} asked The Magic Eight Ball; "${userQuestion}".`);

/* list of possible eightBall responses
(list can be any length) */
const eightBallResponses = [
  "It is certain",
  "It is decidedly so",
  "Reply hazy try again",
  "Cannot predict now",
  "Do not count on it",
  "My sources say no",
  "Outlook not so good",
  "Signs point to yes"
]

/* assign random eightBall response from the array "eightBallResponses"
This expression assigns a value to eightball by randomly choosing a
string from the array. It generates a random integer between 0 and the
length of the array - 1. That value is then used to get a value from the
array as following: "eightBall = array[randomNumber];" 
The random number generation takes into account the length of the array,
this means the list of responses can be any length and it will still work 
(well, except 0) */
const eightBall = eightBallResponses[Math.floor(Math.random()*eightBallResponses.length)];

// console log the response from the eight ball
console.log(`The Magic Eight Ball answers: "${eightBall}".`);

// display the response in an alert box
alert(`${userName} asked The Magic Eight Ball; "${userQuestion}".\nThe Magic Eight Ball answers: "${eightBall}".`);