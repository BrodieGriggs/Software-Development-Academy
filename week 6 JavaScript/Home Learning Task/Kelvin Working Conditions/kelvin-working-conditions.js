function evaluateWorkingConditions(){
  /* 1) Create 3 variables,
  one named temperature,
  another named condition,
  and the last one named goToWork
  -alldeclared without a value. */
  let temperature;
  let condition;
  let goToWork;



  /* 2) Ask the user for the value of temperature and
  store that value within the variable of the same name. */

  /* this code will keep asking the user to enter the
  temperature until a valid value is entered. */
  while(!temperature) {
    /* parsing the value entered to a float value
    will check the type of data the user has entered
    is a valid float (decimal)
    
    if it cannot parse the data to a float, it will
    return NaN, which is a falsy value */
    temperature = parseFloat(prompt("Please enter the temperature below:"));
  }



  /* 3) Next, do the same but for the condition variable.
  Anticipated values for condition are:
  a.Sunny
  b.Cloudy
  c.Raining
  d.Snowing
  e.Thunder */

  /* An array of valid conditions has been created,
  so that the user's input can be checked */
  const validConditions = ["sunny", "cloudy", "raining", "snowing", "thunder"];
  // get a string of all the accepted values for the user prompt
  const validConditionsString = validConditions.join(" ");

  /* ask the user for the condition and check the input's
  validity against the array of valid inputs */
  while(!condition) {
    condition = prompt(`Please enter the current weather condition:\n\nAccepted values:\n${validConditionsString}`);

    // change condition string to lowercase for comparing
    condition = condition.toLowerCase();

    /* check if the input is valid, if it isn't change
    the value of condition so that the while loop continues */
    if(!validConditions.some(currentValue => currentValue == condition)) {
      condition = null;
    }
  }


  /* 4) assign a value to goToWork based on the temperature
  and weather condition. */

  switch(condition) {
    case 'sunny':
    case 'cloudy':
      if(temperature >= 10 && temperature <= 30) { goToWork = true; }
      else { goToWork = false; }
      break;
    case 'raining':
      if(temperature > 20 && temperature <= 30) { goToWork = true; }
      else { goToWork = false; }
    case 'snowing':
    case 'thunder':
      goToWork = false;
      break;
  }



  /* 5) Depending on the outcome of goToWork, display a
  message on the screen that tells Kelvin whether the weather
  is fit for purpose, and he can continue construction on his
  new lab. */

  /* create a string based on the value of goToWork for use
  in a user-facing alert on the working conditions */
  const decision = goToWork ? "safe to work" : "not safe to work";

  /* return an interpolated string with the decision */
  return `KWC has determined that today it is ${decision}.`
}

/* call function and alert user with the result */
alert(evaluateWorkingConditions());