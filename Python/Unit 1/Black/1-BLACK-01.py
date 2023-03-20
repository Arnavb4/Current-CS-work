import sys
sys.setrecursionlimit(500000)

def is_fib(x):
    if ((((5 * (x * x)) + 4) ** 0.5) % 1 == 0) or ((((5 * (x * x)) - 4) ** 0.5) % 1 == 0):
        return True
    else:
        return False

def fib(x):
    if x == 0:
        return 1
    elif x == 1:
        return 1
    else:
        return fib (x-1) + fib (x-2)


def sum_even_fib(x):
    if x == 1:
        return 0
    elif x == 0:
        return 0
    elif is_fib (x) and x % 2 == 0:
        return x + sum_even_fib (x-1)
    else:
        return sum_even_fib (x-1)

print (sum_even_fib (10))

import sys
print(is_fib(int(sys.argv[1])))
print(sum_even_fib(int(sys.argv[2])))