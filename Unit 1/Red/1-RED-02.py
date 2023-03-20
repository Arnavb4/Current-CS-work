def gcd_check(x, y, r):
    if x % r == 0 and y % r == 0:
        return r
    else:
        return gcd_check(x, y, r - 1)

def gcd(x, y):
    if x==y:
        return x
    elif x%y==0:
        return y
    elif x==1 or y==1:
        return 1
    elif y%x == 0:
        return x
    else:
        if x<y:
            return gcd_check (x, y, int (x/2))
        else:
            return gcd_check (x, y, int (x/2))

def gcd_euclid (x, y):
    gcd_euclidCheck(x, y)
    if y < x:
        return gcd_euclid (x, x % y)
    else:
        return gcd_euclid (y, y % x)
    

def gcd_euclidCheck(x, y):
    if x == y:
        return y
    elif x == 1 or y == 1:
        return 1
    elif y % x == 0:
        return x
    elif x % y == 0:
        return y

def lcm (x, y):
    return (x * y)/gcd_euclid(x, y)

def lcm_n(n):  
    if n == 1:
        return 0
    elif n == 2:
        return 2
    else:
        return lcm (n, n-1)  

import sys
x = int(sys.argv[1])
y = int(sys.argv[2])
n = int(sys.argv[3])
print(gcd(x, y))
print(gcd_euclid(x, y))
print(lcm(x, y))
print(lcm_n(n))  