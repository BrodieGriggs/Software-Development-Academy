import random


def guess_the_number():
    random_num = random.randint(1, 10)
    user_int = -1
    user_name = str(input("Please enter your name: "))

    while user_int != random_num:
        user_int = int(input("Please enter an integer: "))
        if user_int == random_num:
            break
        else:
            print(user_name + ", unfortunately you didn't guess correctly, try again!")

    print("Congratulations " + user_name + ", you guessed the correct number!")


def depreciation():
    current_value = float(input("Please enter the current value: £"))
    year = 0
    while current_value > 1000:
        print("Year " + str(year) + ", the current value is: £" + ("%.2f" % current_value))
        current_value *= 0.9
        year += 1

    print("In year " + str(year) + ", the value is now less that 1000 at: £" + str(current_value))


def calculate():
    a = int(input("Please enter your first number: "))
    b = int(input("Please enter another number: "))
    print("Please enter your choice of operator")
    print("'+' = add, '-' = subtract, '*' = multiply, '/' = divide")
    operation = input(" : ")
    if operation == "+":
        result = a + b
        print(str(a), "+", str(b), "=", str(result))
    elif operation == "-":
        result = a - b
        print(str(a), "-", str(b), "=", str(result))
    elif operation == "*":
        result = a * b
        print(str(a), "*", str(b), "=", str(result))
    elif operation == "/":
        result = a / b
        print(str(a), "/", str(b), "=", str(result))
    else:
        print("Invalid operator received")
