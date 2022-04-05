/* Today's forecast is 293 kelvin.
The value saved to kelvin will stay constant. */
const kelvin = 293;

/* Get Celsius from Kelvin value.
Celsius is 273 degrees less than kelvin */
const celsius = kelvin - 273;

/* Get Fahrenheit form Celsius value.
"Fahrenheit = Celsius * (9/5) + 32"
Variable declared with 'let' to allow changes such as rounding */
let fahrenheit = celsius * (9/5) + 32;

/* When you convert from Celsius to Fahrenheit,you often get a
decimal number. Temperature in Fahrenheit is rounded down to
the nearest integer */
fahrenheit = Math.floor(fahrenheit);


console.log(`The temperature is ${fahrenheit} degrees Fahrenheit.`);