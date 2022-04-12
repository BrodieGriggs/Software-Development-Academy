// activity 1
function temperatureOpinion(temp) {
  let temperature = temp;

  if(temperature >= 20) { console.log("It is hot today!"); }
  else { console.log("It is not very hot today!"); }

  return;
}

// activity 2
function opinionOfDay(givenDay) {
  let day = givenDay;

  day = day.toLowerCase();

  if(day == "monday") { console.log("I hate Mondays."); }
  else if(day == "tuesday") { console.log("I hate Tuesdays."); }
  else if(day == "wednesday") { console.log("Wednesdays are ok."); }
  else if(day == "thursday") { console.log("I hate Thursdays."); }
  else if(day == "friday") { console.log("I hate Fridays."); }
  else if(day == "saturday") { console.log("I hate Saturdays."); }
  else { console.log("I hate Sundays."); }

  return;
}

//activity 3
function priceOfFruit(givenFruit) {
  let fruit = givenFruit;
  let price;
  switch(fruit) {
    case "apple":
      price = "50p";
      break;
    case "pear":
    case "orange":
      price = "60p";
      break;
    case "banana":
      price = "40p";
      break;
    case "clementine":
      price = "30p";
      break;
    default:
      price = "0p";
  }

  console.log(price);
}