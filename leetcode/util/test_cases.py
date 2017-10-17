class TestCase:
    def __init__(self, arguments, answer):
        self.arguments = arguments if isinstance(arguments, list) else [arguments]
        self.answer = answer


def check(func, test_cases):
    for tc in test_cases:
        result = func(*tc.arguments)
        if result != tc.answer:
            print 'Incorrect. Expected: {0}, Got: {1}'.format(tc.answer, result)
        else:
            print 'Correct'
