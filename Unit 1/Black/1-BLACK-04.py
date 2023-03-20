def pyramid(x):
    return pyramid_helper(x, int(len(x)/2), int(len(x)/2) + 1)

def pyramid_helper(x, y, z):
    if y == -1:
        print ("")
    else:
        print (" " * y + x[y:z])
        return pyramid_helper (x, y - 1, z + 1)

def spike(x):
    return spike_helper(x, 0, len(x))

def spike_helper(x, y, z):
    if y == (len(x) + 1)/2:
        print ("")
    else:
        print (" " * y + x[y:z])
        return spike_helper (x, y + 1, z - 1)

def pyramid_mod(x):
    return pyramid_mod_helper(x, int(len(x)/2), int(len(x)/2) + 1)

def pyramid_mod_helper(x, y, z):
    if y == 0:
        spike(x)
    else:
        print (" " * y + x[y:z])
        return pyramid_mod_helper (x, y - 1, z + 1, 3)

def diamond(x):
    pyramid_mod(x, 1, 1)

# def magic_square(x, y, z):
#     print (x[0:int((len(x) + 1)/2)] + " " * 3 + x [int ((len(x) - 1)/2) : len(x)])
#     print (x[0:int((len(x) - 1)/2)] + " " * 5 + x [int ((len(x) + 1)/2) : len(x)])
#     print (x[0:int((len(x) - 3)/2)] + " " * 7 + x [int ((len(x) + 3)/2) : len(x)])
#     print (x[0:int((len(x) - 5)/2)] + " " * 9 + x [int ((len(x) + 5)/2) : len(x)])

def magic_square(x):
    return magic_square_helper(x, 1, 1, 3)

def magic_square_helper(x, left_char, right_char, space):
    if len(x) - right_char == 0:
        print (" " * 4 + x [1:len(x)-1])
        print (" " * 3 + x)
    else:
        print (x[0:int((len(x) + left_char)/2)] + " " * space + x [int ((len(x) + right_char)/2) : len(x)])
        return magic_square_helper (x, left_char - 2, right_char + 2, space)

magic_square ("1234567")