// set username to user input (or "" if null or no value is entered)
let userName = prompt(`Please enter your name, or hit "OK"`);

/* Log 'Hello!' or 'Hello, userName!' to console depending on
whether a userName was entered */
const greeting = userName == "" || userName == null ? 'Hello!' : `Hello, ${userName}!`;
console.log(greeting);

/* - Take a user input question to ask of the magic eight ball.
- Reused the value of greeting in this user-facing prompt.
- Using a while loop that checks if userQuestion is falsy
("", null, undefined, etc..) and keeps asking for a value
until userQuestion is assigned */
let userQuestion;
while(!userQuestion) {
  userQuestion = prompt(`${greeting} Ask a question of the Magic Eight Ball:`);
}

// if null or no username was entered, use a default name
if(userName == "" || userName == null) { userName = "User"; }
console.log(`${userName} asked The Magic Eight Ball; "${userQuestion}".`);

// generate a random integer between 0 and 7
const randomNumber = Math.floor(Math.random()*8);

/* Create one more variable namedeightBall, and set it equal
to an empty string. We will save a value to this variable in
the next steps, depending on the value ofrandomNumber. */
let eightBall = "";

// assign a response based on the randomNumber generated
switch(randomNumber) {
  case 0:
    eightBall = "It is certain";
    break;
  case 1:
    eightBall = "It is decidedly so";
    break;
  case 2:
    eightBall = "Reply hazy try again";
    break;
  case 3:
    eightBall = "Cannot predict now";
    break;
  case 4:
    eightBall = "Do not count on it";
    break;
  case 5:
    eightBall = "My sources say no";
    break;
  case 6:
    eightBall = "Outlook not so good";
    break;
  case 7:
    eightBall = "Signs point to yes";
    break;
}

// console log the response from the eight ball
console.log(`The Magic Eight Ball answers: "${eightBall}".`);

// display the response in an alert box
alert(`${userName} asked The Magic Eight Ball; "${userQuestion}".\nThe Magic Eight Ball answers: "${eightBall}".`);