class TestCase:
    def __init__(self, arguments, answer):
        self.arguments = arguments if isinstance(arguments, list) else [arguments]
        self.answer = answer


class SolvedTestCase:
    def __init__(self, actual_result, exptected_result):
        self.actual = actual_result
        self.expected = exptected_result


def check(func, test_cases):
    for tc in test_cases:
        result = func(*tc.arguments)
        if result != tc.answer:
            print('Incorrect. Expected: {0}, Got: {1}'.format(tc.answer, result))
        else:
            print('Correct')


def compare(test_cases):
    # type: (List[util.test_cases.SolvedTestCase]) -> object
    """

    :param test_cases:
    :return: bool
    """

    result = []
    for i, case in enumerate(test_cases):
        if case.actual != case.expected:
            msg = "### {0} Incorrect: Actual: {1}, Expected: {2}".format(i, case.actual, case.expected)
            print(msg)
            result.append(False)
        else:
            print("{0} Correct: Actual: {1}, Expected: {2}".format(i, case.actual, case.expected))
            result.append(True)
