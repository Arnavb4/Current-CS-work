alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

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

import sys
pt = sys.argv[1]
ct = sys.argv[2]
ky = sys.argv[3]
print(vigenere_encode(pt, ky))
print(vigenere_decode(ct, ky))