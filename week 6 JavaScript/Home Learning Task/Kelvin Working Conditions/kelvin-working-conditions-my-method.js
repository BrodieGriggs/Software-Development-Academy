function evaluateWorkingConditions(){
  let temperature;
  let condition;
  let goToWork;

  while(!temperature) {
    temperature = parseFloat(prompt("Please enter the temperature below:"));
  }

  const validConditions = ["sunny", "cloudy", "raining", "snowing", "thunder"];
  const validConditionsString = validConditions.join(" ");
  while(!condition) {
    condition = prompt(`Please enter the current weather condition:\n\nAccepted values:\n${validConditionsString}`).toLowerCase();

    if(!validConditions.some(currentValue => currentValue == condition)) {
      condition = null;
    }
  }
  
  // goToWork can be determined in just 3 lines:
  /* temperatures > 30 or <10 always mean goToWork is false,
  regardless of the weather conditions, and snowing and thunder
  weather always mean goToWork is false, regardless of temperature. */
  if(temperature > 30 || temperature < 10 || condition == "snowing" || condition == "thunder"){ goToWork = false; }
  
  /* for temperatures >=10 and <30, sunny and cloudy weather
  conditions mean go to work is true. */
  else if(condition == "sunny" || condition == "cloudy") { goToWork = true; }

  /* This leaves the weather condition raining, which is
  dependant on the temperature being above or below 20 */
  else goToWork = temperature > 20 ? true : false;

  const decision = goToWork ? "safe to work" : "not safe to work";

  return `KWC has determined that today it is ${decision}.`
}
alert(evaluateWorkingConditions());