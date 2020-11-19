def gcd_iterative(a, b):
    """
    Find GCD of two numbers, iteratively

    :param a: `int` first number
    :type a: int
    :param b: `int` second number
    :type b: int

    :return: `int` GCD of a and b
    :rtype: int
    """
    while b:
        temp = b
        b = a % b
        a = temp

    return a


def gcd(a, b):
    """
    Find GCD of two numbers, recursively

    :param a: `int` first number
    :type a: int
    :param b: `int` second number
    :type b: int

    :return: `int` GCD of a and b
    :rtype: int
    """
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def extended_euclid(a, b):
    """
    Extended Euclid Algorithm. Given a and b, return d, x, y s.t. they satisfy the equation: d = gcd(a, b) = ax + by

    :param a: first number
    :type a: int
    :param b: second number
    :type b: int
    :return: tuple(d, x, y) values in the equation d = gcd(a, b) = ax + by
    :rtype: tuple
    """
    if b == 0:
        return a, 1, 0
    else:
        d, x, y = extended_euclid(b, a % b)
        return d, y, x - int(a / b) * y


if __name__ == '__main__':
    print(gcd(24, 30))
    print(gcd(30, 24))

    print(gcd_iterative(24, 30))
    print(gcd_iterative(30, 24))
    print(extended_euclid(24, 30))
    print(extended_euclid(30, 24))

    print(gcd_iterative(21, 30))
    print(gcd(21, 30))

    print(extended_euclid(99, 78))
