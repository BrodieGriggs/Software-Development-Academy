// is the runner an early registrant?
let earlyRegistrant = false;

// runner age
let runnerAge = 0;

// assign random raceNumber
let raceNumber= Math.floor(Math.random() * 1000);

// is the runner an adult and early registrant?
if(earlyRegistrant && runnerAge >= 18) { raceNumber += 1000; }

// assign racetimes based on runner age and registration 
let raceTime;
if(runnerAge < 18) { raceTime = "12:30pm"; } // Youth Registrants
else if(earlyRegistrant) { raceTime = "9:30am"; } // Adult Early Registrants
else { raceTime = "11:00am"; } // Adult Late Registrant

// console.log racenumber and racetime
console.log(`Your assigned Race Number is ${raceNumber}.\nYour race will commence at ${raceTime}.`)

/* Instruction 9:
"Don’t forget about runners exactly 18 years old!
Add anelsestatement that logs a statement to the console telling
the runner to see the registration desk."

In the brief, adults are listed as 18+ and youths as under 18s.
So I am not sure why a separate message would be needed.
When determining if the runner is an adult or not I have used
"age < 18 = youth", and "age >=18 = adult" */