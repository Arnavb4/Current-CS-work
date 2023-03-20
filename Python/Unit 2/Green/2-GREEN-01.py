def function_for_12(x):
    temp = []
    for char in x:
        temp.append(char)
    return (temp)

def function_for_15(x):
    count = 0
    for char in x:
        if char == "e":
            count +=1
    return (count)

def function_for_16(x):
    count = 0
    for char in x:
        if char == "e":
            count +=1
        elif char == "E":
            count +=1
    return (count)

def function_for_17(x):
    count = 0
    for char in x:
        if char == "a":
            count +=1
        elif char == "A":
            count +=1
        elif char == "e":
            count +=1
        elif char == "E":
            count +=1
        elif char == "i":
            count +=1
        elif char == "I":
            count +=1
        elif char == "o":
            count +=1
        elif char == "O":
            count +=1
        elif char == "u":
            count +=1
        elif char == "U":
            count +=1
    return (count)

def function_for_18(x):
    temp = []
    for char in x:
        if char == "a":
            temp.append(char)
        elif char == "A":
            temp.append(char)
        elif char == "e":
            temp.append(char)
        elif char == "E":
            temp.append(char)
        elif char == "i":
            temp.append(char)
        elif char == "I":
            temp.append(char)
        elif char == "o":
            temp.append(char)
        elif char == "O":
            temp.append(char)
        elif char == "u":
            temp.append(char)
        elif char == "U":
            temp.append(char)
    return (temp)

def function_for_19(x):
    temp = []
    for i, x in enumerate(x):
        if i % 2 == 0:
            temp.append(x)
    join = "".join(temp) 
    return join

def function_for_20(x):
    temp = []
    for i, x in enumerate(x):
        if i % 2 == 1:
            temp.append(x)
    join = "".join(temp) 
    return join

def function_for_21(x, y):
    temp = []
    if y == len(x) - 2:
        temp.append(x[y: y + 2])
        return temp
    else:
        temp.append (x[y: y + 2])
        return temp + function_for_21 (x, y + 1)

def function_for_22(x):
    temp = []
    for i, x in enumerate(x):
        if i % 3 == 0:
            temp.append("!")
        else:
            temp.append(x)
    join = "".join(temp) 
    return join

def function_for_23(x):
    temp = []
    for i, x in enumerate(x):
        if i % 3 == 2:
            temp.append("!")
        else:
            temp.append(x)
    join = "".join(temp) 
    return join

s = input("Please type a string: ")
print ()
print ("#1:", s[2])
print ("#2:", s[4])
print ("#3:", len(s))
print ("#4:", s[0])
print ("#5:", s[len(s) - 1: len(s)])
print ("#6:", s[len(s) - 2: len(s) - 1])
print ("#7:", s[3:8])
print ("#8:", s[len(s) - 5:len(s)])
print ("#9:", s[3:len(s)])
print ("#10:", s.lower())
print ("#11:", s.upper())
print ("#12:", function_for_12(s))
print ("#13:", s [0:len(s) - 1])
print ("#14:", s [1:len(s)])
print ("#15:", function_for_15(s))
print ("#16:", function_for_16(s))
print ("#17:", function_for_17(s))
print ("#18:", function_for_18(s))
print ("#19:", function_for_19(s))
print ("#20:", function_for_20(s))
print ("#21:", function_for_21(s, 0))
print ("#22:", function_for_22(s))
print ("#23:", function_for_23(s))




