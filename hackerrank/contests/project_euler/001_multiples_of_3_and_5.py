#!/bin/python

import sys


# Solution inspired from: https://math.stackexchange.com/questions/9259/find-the-sum-of-all-the-multiples-of-3-or-5-below-1000

def sum_of_divisors(n, base):
    numbers = (n - 1) / base
    s = (numbers * (numbers + 1)) / 2
    return s * base


t = int(raw_input().strip())
for a0 in xrange(t):
    n = int(raw_input().strip())
    print sum_of_divisors(n, 3) + sum_of_divisors(n, 5) - sum_of_divisors(n, 15)
