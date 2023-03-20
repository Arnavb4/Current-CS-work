def sort_string (x):
    return sort_string_helper (x, 0, 0)

def sort_string_helper (x, y, z):
    if y == len(x):
        return x [z:z + 1] + sort_string_helper (x[0:z] + x[z + 1: len(x)], 0, 0)
    elif len(x) == 1:
        return x
    else:
        if x [z: z + 1] < x [y : y + 1]:
            return sort_string_helper (x, y + 1, z)
        elif x [z: z + 1] == x [y : y + 1]:
            return sort_string_helper (x, y + 1, z)
        else:
            return sort_string_helper (x, y + 1, y)


def reverse_sort_string(x):
    return reverse_sort_string_helper(x, 0, 0)

def reverse_sort_string_helper(x, y, z):
    if y == len(x):
        return x [z:z + 1] + reverse_sort_string_helper (x[0:z] + x[z + 1: len(x)], 0, 0)
    elif len(x) == 1:
        return x
    else:
        if x [z: z + 1] > x [y : y + 1]:
            return reverse_sort_string_helper (x, y + 1, z)
        elif x [z: z + 1] == x [y : y + 1]:
            return reverse_sort_string_helper (x, y + 1, z)
        else:
            return reverse_sort_string_helper (x, y + 1, y)



count = 0

def vowels_first_helper (x, y, z):
    global count
    if y == len(x):
        return x [z:z + 1] + vowels_first_helper (x[0:z] + x[z + 1: len(x)], 0, 0)
    elif x[y: y + 1]  < "b":
        count += 1
        return x[y: y + 1] + vowels_first_helper (x [0:y] + x[y + 1: len(x)], 0, 0)
    elif x[y: y + 1] > "d" and x[y: y + 1] < "f":
        count += 1
        return x[y: y + 1] + vowels_first_helper (x [0:y] + x[y + 1: len(x)], 0, 0)
    elif x[y: y + 1] > "h" and x[y: y + 1] < "j":
        count += 1
        return x[y: y + 1] + vowels_first_helper (x [0:y] + x[y + 1: len(x)], 0, 0)
    elif x[y: y + 1] > "n" and x[y: y + 1] < "p":
        count += 1
        return x[y: y + 1] + vowels_first_helper (x [0:y] + x[y + 1: len(x)], 0, 0)
    elif x[y: y + 1] > "t" and x[y: y + 1] < "v":
        count += 1
        return x[y: y + 1] + vowels_first_helper (x [0:y] + x[y + 1: len(x)], 0, 0)
    elif len(x) == 1:
        return x
    else:
        if x [z: z + 1] < x [y : y + 1]:
            return vowels_first_helper (x, y + 1, z)
        elif x [z: z + 1] == x [y : y + 1]:
            return vowels_first_helper (x, y + 1, z)
        else:
            return vowels_first_helper (x, y + 1, y)
 
def vowels_first(x):
    return vowels_sorting(vowels_first_helper(x, 0, 0), count)

def vowels_sorting(x, y):
    return sort_string(x[0:y]) + x[y:len(x)]


import sys
print(sort_string(sys.argv[1]))
print(reverse_sort_string(sys.argv[1]))
print(vowels_first(sys.argv[1]))