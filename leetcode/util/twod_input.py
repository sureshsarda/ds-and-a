def read_2d_input(s, sep=''):
    twod = []
    s = s.split('\n')
    for i in range(1, len(s) - 1):  # Skip first and last
        row = s[i]
        r = row.strip()
        if sep:
            r = r.split(sep)
        twod.append(r)

    return twod


if __name__ == '__main__':
    print(read_2d_input(
        """
        .........
        ...123...
        ......123
        """
    ))

    print(read_2d_input(
        """
        ab,cd,ef
        gh,ig,kl
        """
    , sep=','))
