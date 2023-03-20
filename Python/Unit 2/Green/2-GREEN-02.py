alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def caesar_encode(text, shift):
    output = ""
    for char in text:
        index_of_text_letter = alpha.index(char)
        shifted_index = index_of_text_letter + shift
        wrapped_shifted_index = shifted_index % 26
        final_letter = alpha [wrapped_shifted_index]
        output = output + final_letter
    return output


def caesar_decode(text, shift):
    output = ""
    for char in text:
        index_of_text_letter = alpha.index(char)
        shifted_index = index_of_text_letter - shift
        if shifted_index < 0:
            shifted_index = shifted_index + 26
        wrapped_shifted_index = shifted_index % 26
        final_letter = alpha [wrapped_shifted_index]
        output = output + final_letter
    return output

def caesar_crack(text):
    for r in range(26):
        print (caesar_decode(text, r) )

def substitution_encode(text, code_alpha):
    final_output = ""
    for char in text:
        index = alpha.index (char)
        new_letter = code_alpha [index]
        final_output = final_output + new_letter
    return final_output

def substitution_decode(text, code_alpha):
    final_output = ""
    for char in text:
        index = code_alpha.index (char)
        new_letter = alpha [index]
        final_output = final_output + new_letter
    return final_output

import sys
pt = sys.argv[1]
a2 = sys.argv[2]
ct = sys.argv[3]
ct2 = sys.argv[4]
shift = int(sys.argv[5])
print(caesar_encode(pt, shift))
print(caesar_decode(ct, shift))
print(substitution_encode(pt, a2))
print(substitution_decode(ct2, a2))
print(caesar_crack(ct))