# !/bin/python



import sys


def prime_factors(n):
    factor = 2
    factors = []
    while n > 1:
        while n % factor == 0:
            n /= factor
            factors.append(factor)
        factor += 1
        if factor * factor > n:
            if n > 1: factors.append(n)
            break

    return factors


# print(10 ** 14)
# print(prime_factors(10 ** 14))

t = int(raw_input().strip())
for a0 in xrange(t):
    n = long(raw_input().strip())
    print(max(prime_factors(n)))
