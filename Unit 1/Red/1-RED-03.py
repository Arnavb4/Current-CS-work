def shrink (x):
    l = len (x)
    if l == 1:
        print (x)
    else:
        print (x)
        shrink (x [0:l-1])

def grow (x):
    l = len (x)
    if l <= 1:
        print (x)
    else:
        grow (x [0:l-1])
        print (x)

def shrink_right (x):
    n = len (x)
    def shrink_right_help (y):
        m = len (y)
        if m==n:
            print (y)
            shrink_right_help (y [1:m])
        elif m == 1:
            print ((" " * (n - 1)) + y)
        else:
            print ((" " * (n - m)) + y [0 : m])
            shrink_right_help (y [1 : m])
    shrink_right_help (x)


def shrink_right_cascade (x):
    n = len (x)
    def cascade_helper (y):
        m = len (y)
        if m==n:
            print (" " + y [1 : len (y)])
            cascade_helper (y [2:m])
        elif m == 1:
            print ((" " * (n - 1)) + y)
        else:
            print ((" " * (n - m)) + y [0 : m])
            cascade_helper (y [1 : m])
    cascade_helper (x)

def word_cascade (x):
    grow(x)
    shrink_right_cascade (x)

def grow_cascade (x):
    l = len (x)
    if l <= 1:
        print (x)
    else:
        print (x)
        grow_cascade (x [0:l-1])
        
def cascade_backwards(x):
    return cascade_backwards_helper (x, len(x), 1)

def cascade_backwards_helper (x, total, char):
    if total == char:
        return shrink (x)
    else:
        print (" " * (total - char) + x [total - char: total])
        (cascade_backwards_helper (x, total, char + 1))

def snake (x):
    return snake_right (x, 0, 1)

def snake_right (x, char, let_count):
    if let_count - 1 == len (x):
        print ("")
    elif char == 3:
        return snake_left (x, 1, let_count)
    else:
        print (" " * (char) + x [let_count - 1:let_count])
        let_count += 1
        snake_right (x, char + 1, let_count)

def snake_left (x, char, let_count):
    if let_count - 1 == len (x):
        print ("")
    elif char == -1:
        return snake_right (x, 1, let_count)
    else:
        print (" " * (char) + x [let_count - 1:let_count])
        let_count += 1
        snake_left (x, char - 1, let_count)


def custom_snake (x, num):
    return custom_snake_right (x, 0, 1, num)

def custom_snake_right (x, char, let_count, num):
    if let_count - 1 == len (x):
        print ("")
    elif char >= num:
        return custom_snake_left (x, num - 2, let_count, num)
    else:
        print (" " * (char) + x [let_count - 1:let_count])
        let_count += 1
        custom_snake_right (x, char + 1, let_count, num)

def custom_snake_left (x, char, let_count, num):
    if let_count - 1 == len (x):
        print ("")
    elif char == -1:
        return custom_snake_right (x, 1, let_count, num)
    else:
        print (" " * (char) + x [let_count - 1:let_count])
        let_count += 1
        custom_snake_left (x, char - 1, let_count, num)


import sys
s = sys.argv[1]
print("Shrink:")
print()
shrink(s)
print()
print("Grow:")
print()
grow(s)
print()
print("Shrink right:")
print()
shrink_right(s)
print()
print("Word cascade:")
print()
word_cascade(s)
print()
print("Cascade backwards:")
print()
cascade_backwards(s)
print()
print("Snake:")
print()
snake(s)
print()
print("Custom snake:")
print()
custom_snake(s, int(sys.argv[2]))