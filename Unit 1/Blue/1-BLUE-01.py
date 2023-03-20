def sum_n(n):
    if n==0:
        return 0
    else:
        return n + sum_n(n - 1)

def sum_squares(n):
    if n == 0:
        return 0
    else:
        return n**2 + sum_squares(n-1)

def sum_even(n):
    if n==0:
        return 0
    elif n==1:
        return 0
    elif n % 2 == 0:
        return n + (sum_even(n-2))
    elif n % 2 == 1:
        return n-1 + (sum_even(n-3))

def count_threes(n):
    if n < 3:
        return 0
    elif n == 3:
        return 1
    elif n >3:
        return 1 + count_threes (n-3)

def sum_m_to_n(m,n):
    if m == n:
        return 0
    elif n > m:
        return n + (sum_m_to_n(m, n-1))
    else:
        return m + (sum_m_to_n(m-1, n))

import sys
print(sum_n(int(sys.argv[1])))
print(sum_squares(int(sys.argv[2])))
print(sum_even(int(sys.argv[3])))
print(count_threes(int(sys.argv[4])))
print(sum_m_to_n(int(sys.argv[5]), int(sys.argv[6])))