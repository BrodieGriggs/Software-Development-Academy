let calculating = true; // bool used for the loop

function calculate() {
  /* 1) Ask the user for a number with a prompt()
  and store the value in a variable called firstValue */
  let firstValue;
  while(!firstValue) {
    firstValue = parseFloat(prompt("Please enter the first number:"));
  }

  /* 3) Ask the user for a third input with prompt()
  storing the value in a variable called operation.
  Expected operations are... */
  /* rearranged steps 2 and 3 to make the input order
  make more sense */
  const validOperations = ["+", "-", "/", "*", "^", "sin", "cos", "tan"];
  const validOperationsString = validOperations.join(" ");

  let operation;
  while(!operation) {
    operation = prompt(`Please enter the operation you would like to perform:\n\nAccepted operations:\n${validOperationsString}`);

    if(!validOperations.some(currentValue => currentValue == operation)) {
      operation = null;
    }
  }

  /* 2) Ask the user for a second number with a prompt()
  and store that value in a variable called secondValue */

  /* if the user chooses to perform a sin, cos or tan
  operation, the second value is not required. */
  let secondValue;
  if(operation != "sin" && operation != "cos" && operation != "tan") {
    while(!secondValue) {
      secondValue = parseFloat(prompt("Please enter the second number:"));
    }
  }

  /* 5) Create a case-switch for evaluating the operation
  the user supplied, and depending on the value, execute
  the relevant function. */
  let calculationAnswer;
  switch(operation) {
    case '+':
      calculationAnswer = add(firstValue, secondValue);
      break;
    case '-':
      calculationAnswer = subtract(firstValue, secondValue);
      break;
    case '/':
      calculationAnswer = divide(firstValue, secondValue);
      break;
    case '*':
      calculationAnswer = multiply(firstValue, secondValue);
      break;
    case '^':
      calculationAnswer = toThePowerOf(firstValue, secondValue);
      break;
    case 'sin':
      calculationAnswer = sine(firstValue);
      break;
    case 'cos':
      calculationAnswer = cosine(firstValue);
      break;
    case 'tan':
      calculationAnswer = tangent(firstValue);
      break;
  }

  /* Check if the answer is a decimal, and if it is,
  round it to a reasonable amount of decimal places */
  if(calculationAnswer % 1 != 0) {
    calculationAnswer = parseFloat(calculationAnswer).toFixed(4);
  }

  /* 6) Print out to console firstValue, operator,
  secondValue, an equal sign, and the answer */

  /* If secondValue is undefined, a sin, cos or
  tan operation was performed */
  let answerString;
  if(secondValue) {
    answerString = `${firstValue} ${operation} ${secondValue} = ${calculationAnswer}`;
  } else {
    answerString = `${operation}(${firstValue}) = ${calculationAnswer}`;
  }
  console.log(answerString);

  /* display the answer for the user */
  alert(answerString);

  /* Ask the user if they would like to perform another
  calculation. If no, exit the loop. */
  if(!confirm('Would you like to perform another calculation?\n\nPlease press "OK" for yes, or "Cancel" for no.')) {
    calculating = false;
  }
  return;
}

/* 4) Write a method for the 5 operations listed above
(one for each operation) that takes in both valuesand
returns the result of the operation. */
function add(num1, num2) { return num1 + num2; }
function subtract(num1, num2) { return num1 - num2; }
function divide(num1, num2) { return num1 / num2; }
function multiply(num1, num2) { return num1 * num2; }
function toThePowerOf(num, exponent) {

  /* I wrote the code for integer exponents,
  but while looking into ways to process fractional
  exponents (decimals) the complexety seems to increase
  .. exponentially!
  
  Since I don't think the object of
  this HLT is to implement complicated math algorithms,
  I have instead decided to utilize JavaScript's
  built-in function for powers, but will leave the code
  I wrote for integer exponents below:

  if(Math.abs(exponent % 1) == 0) {
    if(exponent == 0) { ans = 1; } 
    else if(exponent > 0) {
      ans = num;
      for(let i = 0; i < exponent - 1; i++) {
        ans *= num;
      }
    }
    else {
      ans = num;
      for(let i = 0; i < Math.abs(exponent); i++) {
        ans /= num;
      }
    }
  } */

  return Math.pow(num, exponent);
}
function sine(num1) { return Math.sin(num1); }
function cosine(num1) { return Math.cos(num1); }
function tangent(num1) { return Math.tan(num1); }

/* Main loop.
While the boolean 'calculating' is true,
the calculator will keep calculating.

The loop is exited when the user selects
that they would no longer like to continue
using the calculator after a result is
displayed. 'calculating' will be set to false,
and the while loop will exit. */
while(calculating) {
  calculate();
}