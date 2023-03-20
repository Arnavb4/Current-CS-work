alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
eng_freq = [.0817, .0149, .0278, .0425, .1270, .0223, .0202, .0609, .0697, .0015, .0077, .0403, .0241, .0675, .0751,
            .0193, .0010, .0599, .0633, .0906, .0276, .0098, .0236, .0015, .0197, .0007]
eng_freq_squared = []
for freq in eng_freq:
    eng_freq_squared.append(freq * freq)
engIoC = sum(eng_freq_squared)


def vigenere_encode(message, key):
    string = ""
    for key_letter in range(len(message)):
        message_index = message [key_letter % len(message)]
        key_index = key [key_letter % len(key)]
        string = string + alpha [(alpha.index (message_index) + alpha.index (key_index)) % 26]
    return string

def vigenere_decode(message, key):
    string = ""
    for key_letter in range(len(message)):
        message_index = message [key_letter % len(message)]
        key_index = key [key_letter % len(key)]
        string = string + alpha [(alpha.index (message_index) + (26 - alpha.index (key_index))) % 26]
    return string


def i_of_c(text):
    num_of_times = []
    for char in alpha:
        num_of_times.append (text.count(char))

    index_of_choice = []
    for char in num_of_times:
        index_of_choice.append((float(char * float (char - 1))) / (float (len(text)) * float (len(text) - 1)))
    return sum (index_of_choice)

def friedman_test (text):
    return (float (len(text) * (engIoC - 1/26))) / (float(float ((i_of_c (text)) * (float(len(text) - 1)))) + engIoC - (float(len(text) * 1/26)))


def gcd (x, y):
    if y == 0:
        return x
    else:
        return gcd (y, x % y)

def gcd_list_helper (list, index):
    if index == len(list) - 1:
        return list [index]
    else:
        return gcd(list[index], gcd_list_helper(list, index + 1))

def gcd_of_list(list):
    return gcd_list_helper(list, 0)

def find_plausible_gcd (distances, minimum):
    greater_list = []
    for num in distances:
        if distances.count (num) > minimum:
            greater_list.append(num)    
    if greater_list == distances:
        return gcd_of_list (greater_list)
    elif gcd_of_list (greater_list) > 1:
        return gcd_of_list (greater_list)
    else:
        return find_plausible_gcd (distances, minimum + 1)

def kasiski_test (text):
    trigraphs = []
    distances = []
    for i in range(len(text)):
        if text [i: i + 2] in trigraphs:
            distances.append (float ((i - text.index(text [i: i + 2]))))
        else: 
            trigraphs.append (text [i: i + 2])
    return int(find_plausible_gcd(distances, 1))

def make_cosets (text, n):
    coset = []
    for i in range(n):
        coset.append(text [i: len(text): n])
    return coset


def find_total_differences(l1, l2):
    new_list = []
    for i in range (len(l1)):
        new_list.append (abs(l1[i] - l2[i]))
    return sum(new_list)

def find_likely_letter(coset):
    coset_frequency_list = []
    difference_frequency = []
    for i in alpha:
        coset_frequency_list.append((coset.count(i) / len (coset)))
    for rando in range(len(coset_frequency_list)):
        coset_frequency_list.append(coset_frequency_list [0])
        del (coset_frequency_list [0])
        difference_frequency.append (find_total_differences(coset_frequency_list, eng_freq))
        min_index = difference_frequency.index (min (difference_frequency))
    if min_index == 25:
        return alpha [0]
    else:
        return alpha [min_index + 1]
    

def crack(ciphertext):
    print ("Your cipher text is:")
    print (ciphertext)
    print ("Friedman test gives:", friedman_test (ciphertext), "and Kasiski gives this as the most likely", kasiski_test (ciphertext))
    print ()
    key_word_len = input ("Choose the key length you'd like to try: ")
    for each_coset in make_cosets (ciphertext, int(key_word_len)):
        print("The letter for this coset is likely: ", find_likely_letter (each_coset))
    inputted_key = input ("Type the key you would like to use for decoding: ")
    print (vigenere_decode(ciphertext, inputted_key))

crack ("")

#import sys
#crack(sys.argv[1])