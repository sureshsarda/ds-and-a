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


if __name__ == '__main__':
    print gcd(24, 30)
    print gcd(30, 24)

    print gcd_iterative(24, 30)
    print gcd_iterative(30, 24)

    print gcd_iterative(21, 30)
    print gcd(21, 30)
