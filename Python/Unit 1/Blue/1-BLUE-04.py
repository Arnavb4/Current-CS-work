def guess_my_number(x, y, number_of_guesses = 0):
    guess_1 = (x + y) / 2
    guess_1 = int (guess_1)
    print ("I think this is your number: ", guess_1)
    user_input = input ("correct / low / high? ")
    number_of_guesses +=1
    if user_input == "high":
        guess_my_number(x, guess_1 - 1, number_of_guesses)
    elif user_input == "low":
        guess_my_number(guess_1 + 1, y, number_of_guesses)
    elif user_input == "correct":
        print ("I guessed your number! It took this many tries: ", int(number_of_guesses))
    else:
        print ("Sorry, I don't understand your input")

guess_my_number (0, 100)