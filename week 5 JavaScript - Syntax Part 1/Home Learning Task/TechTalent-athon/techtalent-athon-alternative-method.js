/* One thing I wanted to address with this challenge is that
although it is unlikely, it is possible to roll the same
racenumber twice and have two runners with the same number.
I plan to create an array of runners so that after generating
a race number, the array can be checked to make sure that
no two runners are assigned the same number. 

I have also added the ability to change the number of runners
in each group, which is taken into account when generating
race numbers */

// participants in adult early race
const participantsAE = 1000;

// participants in adult late race
const participantsAL = 1000;

// participants in youth race
const participantsY = 1000;

// array of runners
let runners = [];

// used to end the loop if needed
let collectingData = true;

// main loop
while(collectingData) {

  /* Get runner age.
  Keeps asking for runner age until a value is assigned
  that is a number. */
  let runnerAge;
  while(isNaN(runnerAge)) {
    runnerAge = parseInt(prompt("Please enter runner age:\n\nTo stop collecting date and view list of runners, enter 256."));
  }

  // display list of runner data
  if(runnerAge == 256) {

    // add all data to a string and format it so it's readable
    let message = "";
    for(let i = 0; i < runners.length; i++) {
      message += `Runner Number: ${runners[i]['runnerNumber']}\nRunner Age: ${runners[i]['age']}\n\n`;
    }

    // display data in an alert box and in the console
    if(message) {
      confirm(message);
      console.log(message);

      // break the main loop and stop collecting data
      collectingData = false;
      break;
    } else {
      confirm("no data to display");
      continue;
    }
  }

  /* Early registrant?
  If runner is a youth, assign false.
  Keeps asking until a value is assigned. */
  let earlyRegistrant;
  if(runnerAge < 18) { earlyRegistrant = false; }
  while(earlyRegistrant == null) {
    earlyRegistrant = confirm(`Is runner an early registrant?\n\nPlease press "OK" for yes, and "Cancel" for no.`);
  }
  
  /* assign race number */
  let runnerNumber;
  while(!runnerNumber) {
    // generate number based on age and registration
    if(runnerAge < 18) { runnerNumber = getRandomBetween(1, participantsY); }
    else if(earlyRegistrant) { runnerNumber = 1000 + getRandomBetween(1, participantsAE); }
    else { runnerNumber = getRandomBetween(0, participantsAL); }

    /* check list of runners to see if the number has
    already been used. if it has, set runnerNumber to null
    so that the while loop continues, and break the for loop
    to stop searching through the list of runners */
    for(let i = 0; i < runners.length; i++) {
      if(runners[i]['runnerNumber'] == runnerNumber) {
        runnerNumber = null;
        break;
      }
    }
  }

  // add runner to "runners"
  runners.push({'age': runnerAge, 'runnerNumber': runnerNumber});
}

// function for getting a random integer between two values
function getRandomBetween(min, max) {
  return Math.floor( Math.random() * (max - min + 1) + min);
}