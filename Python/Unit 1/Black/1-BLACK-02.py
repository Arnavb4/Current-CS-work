def mirror (x):
    print(mirror_end(x) + x)

def mirror_end(x):
    if len (x) == 1:
        return x
    else:
        return (x [len(x) - 1:len(x)] + mirror_end (x [0:len(x) - 1])) 

def big_arch(x):
    print (x [0:1] + x + x [0:1])
    print (big_arch_helper(x, 2))

def big_arch_helper(x, y):
    count = len(x)
    if count == y - 2:
        return " "
    else:
        print ((x[y - 1: y]) + " " * len(x) + x[y - 1: y])
        return big_arch_helper (x, y + 1)

def star (x):
    print (star_top(mirror_end(x), 0))
    print (star_end(x, 0))

def star_top (x, y):
    if y == len (x):
        return star_middle (x, 0)
    else:
        print ((" " * (y * 2)) + x[y : y + 1] + (" " * (2 * (len(x) - y))) + x [y : y + 1] + (" " * (2 * (len(x) - y))) +  x [y : y + 1])
        return star_top (x, y + 1)

def star_middle (x, y):
    if y == len(x):
        return star_middle_helper (x) 
    else:
        return ((x [y : y + 1]) + " " + star_middle (x, y + 1))

def star_middle_helper (x):
    return " " + "*" + "  " + star_middle_helper2 (mirror_end(x), 0)

def star_middle_helper2 (x, y):
    if y == len(x):
        return star_middle_helper3 (x)
    else:
        return ((x [y : y + 1]) + " " + star_middle_helper2 (x, y + 1))

def star_middle_helper3(x):
    return ""

def star_end (x, y):
    if y == len (x):
        return ""
    elif y == len(x) - 1:
        return x [len(x) - 1 : len(x)] + " " * ((2 * y) + 2) + x [len(x) - 1 : len(x)] + " " * ((2 * y) + 2) + x [len(x) - 1 : len(x)]
    else:
        print ((" " * (((len (x) - y) * 2)- 3)) + " " + x[y : y + 1] + "  " + (" " * (2 * (y))) + x [y : y + 1] + "  " + (" " * (2 * (y))) +  x [y : y + 1])
        return star_end (x, y + 1)

def word_art_11 (x):
    return word_art_11_helper (x, 0)

def word_art_11_helper (x, y):
    if y == len(x):
        return ""
    else:
        print (" " * y + (x[y:y + 1]))
        return word_art_11_helper (x, y + 1)

def star_middle_modified (x, y):
    if y == len(x):
        return "" 
    else:
        return ((x [y : y + 1]) + " " + star_middle_modified (x, y + 1))


def word_art_12(x):
    print (star_middle_modified(x, 0) + x[0:1])
    return boxed_helper (x, len(x), 1)

def boxed_helper (x, y, z):
    if z == len(x):
        print (x [0:1] + mirror_end (star_middle_modified (x, 0)))
    else:
        print (x [y - 1:y] + " " * ((len (x) * 2)- 1) + (x[z: z + 1]))
        return boxed_helper (x, y - 1, z + 1)

star("star")

import sys
s = sys.argv[1]
print("Mirror:")
print()
mirror(s)
print()
print("Big Arch:")
print()
big_arch(s)
print()
print("Star:")
print()
star(s)
print()
print("Descending:")
print()
word_art_11(s) 
print()
print("Boxed:")
print()
word_art_12(s)