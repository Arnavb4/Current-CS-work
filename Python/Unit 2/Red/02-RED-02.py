import math

alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def mod_inverse_helper(a, b):
    q, r = a//b, a%b
    if r == 1:
        return (1, -1 * q)
    u, v = mod_inverse_helper(b, r)
    return (v, -1 * q * v + u)

def mod_inverse(a, m):
    assert math.gcd(a, m) == 1, "You're trying to invert " + str(a) + " in mod " + str(m) + " and that doesn't work!"
    return mod_inverse_helper(m, a)[1] % m


def affine_encode(message, a, b):
    temp = []
    for char in message:
        i = alpha.index (char)
        c = ((a * i) + b) % 26
        c = c % 26
        temp.append (alpha[c])
    join = "".join (temp)
    return join

def affine_decode(message, a, b):
    temp = []
    for char in message:
        i = alpha.index (char)
        c = mod_inverse(a, 26) * (i - b)
        c = c % 26
        temp.append (alpha [c])
    join = "".join (temp)
    return join

def convert_to_num (ngraph):
    temp = []
    for i in range (len(ngraph)):
        temp.append ((alpha.index (ngraph [i])) * (26 ** i))
    return sum (temp)

def convert_to_text (num, n):
    if n == 0:
        return ""
    else:
        current_letter = alpha [(num % 26)]
        return current_letter + convert_to_text (num // 26, n - 1)

def affine_n_encode(text, n, a, b):
    if not len(text) % n == 0:
        text = text + "X"
        return affine_n_encode (text, n, a, b)
    else:
        return affine_n_encode_helper (text, n, 0, a, b)

affine_encode_helper1_ngraphs = []
affine_encode_helper2_converted_num = []
affine_encode_helper3_converted_num_shifted = []
affide_encode_n_final_list = []

def affine_n_encode_helper (text, n, z, a, b):
    if z == len(text) - n:
        affine_encode_helper1_ngraphs.append(text[z: z + n])
        return affine_n_encode_helper2(text, n, a, b)
    else:
        affine_encode_helper1_ngraphs.append (text[z: z + n])
        return affine_n_encode_helper (text, n, z + n, a, b)

def affine_n_encode_helper2 (text, n, a, b):
    for i in affine_encode_helper1_ngraphs:
        affine_encode_helper2_converted_num.append (convert_to_num(i))
    return affine_n_encode_ab_mods (affine_encode_helper2_converted_num, n, a, b)

def affine_n_encode_ab_mods(text, n, a, b):
    for i in affine_encode_helper2_converted_num:
        affine_encode_helper3_converted_num_shifted.append (i * a + b)
    return affine_encode_helper4_shifted_num_converter (affine_encode_helper3_converted_num_shifted, n)

def affine_encode_helper4_shifted_num_converter(shifted_list, n):
    for i in affine_encode_helper3_converted_num_shifted:
        affide_encode_n_final_list.append(convert_to_text(i, n))
    join = "".join (affide_encode_n_final_list)
    return join


affine_decode_helper1_ngraphs = []
affine_decode_helper2_converted_num = []
affine_decode_helper3_converted_num_shifted = []
affide_decode_n_final_list = []

def affine_n_decode(text, n, a, b):
    return affine_n_decode_helper(text, n, 0, a, b)

def affine_n_decode_helper (text, n, z, a, b):
    if z == len(text) - n:
        affine_decode_helper1_ngraphs.append(text[z: z + n])
        return affine_n_decode_helper2(text, n, a, b)
    else:
        affine_decode_helper1_ngraphs.append (text[z: z + n])
        return affine_n_decode_helper (text, n, z + n, a, b)

def affine_n_decode_helper2 (text, n, a, b):
    for i in affine_decode_helper1_ngraphs:
        affine_decode_helper2_converted_num.append (convert_to_num(i))
    return affine_n_decode_ab_mods (affine_decode_helper2_converted_num, n, a, b)

def affine_n_decode_ab_mods(text, n, a, b):
    for i in affine_decode_helper2_converted_num:
        affine_decode_helper3_converted_num_shifted.append ((mod_inverse(a, 26 ** n) * (i - b)))
    return affine_decode_helper4_shifted_num_converter (affine_decode_helper3_converted_num_shifted, n)

def affine_decode_helper4_shifted_num_converter(shifted_list, n):
    for i in affine_decode_helper3_converted_num_shifted:
        affide_decode_n_final_list.append(convert_to_text(i, n))
    join = "".join (affide_decode_n_final_list)
    return join


import sys
text, dec1, dec2 = sys.argv[1:4]
a, b, n, n_a, n_b = [int(x) for x in sys.argv[4:]]
print(affine_encode(text, a, b))
print(affine_decode(dec1, a, b))
print(affine_n_encode(text, n, n_a, n_b))
print(affine_n_decode(dec2, n, n_a, n_b))