"""
<!-- Input -->


<html><head>
<title>Sample Application</title>
</head>
<body>
<div id="container"></div>
<div id="content"><h1>Hello, World!</h1></div>
</body>
</html>

<!-- We have to support the following methods operations on the given input

--- Phase 1 ---
format(rawString: string)

--- Phase 2 ---
getElementById(id: string)
getElementsByTagName(tagName: string)


the output of getElementById or items returned by getByTagName should support same methods again if we want to filter further, e.g.: getElementsByTagName("body")[0].getElementById("content");
getElementById("container").getElementById("content").getElementsByTagName("div");

-->

<!-- Output of format -->
<html>
    <head>
        <title>Sample Application</title>
    </head>
    <body>
        <div id="container"></div>
        <div id="content">
            <h1>Hello, World!</h1>
        </div>
    </body>
</html>

"""
import logging
from typing import List, Dict

log = logging.getLogger(__name__)
logging.basicConfig(level=logging.DEBUG)


class Element:
    tagName: str
    attributes: Dict[str, str]
    children: List
    text: str

    def __init__(self, tag_name):
        self.tag_name = tag_name
        self.children = []


class Parser:

    def format(self):
        pass

    def parse(self, inp: str):
        inp = inp.replace('\n', '').strip()
        stack = []

        children = []
        active = None

        while inp or stack:
            log.debug(inp)
            if inp.startswith('</'):
                tag = inp[2:inp.index('>')]
                if stack[-1].tag_name != tag:
                    raise ValueError('Invalid XML')
                else:
                    element = stack.pop()

                inp = inp[len(tag) + 3:]
            elif inp.startswith('<'):
                start = inp[1:inp.index('>')]
                tokens = start.split(' ')
                tag = tokens[0]
                e = Element(tag)
                if stack:
                    stack[-1].children.append(e)
                stack.append(Element(tag))

                inp = inp[len(start) + 2:]
            else:
                content = inp[:inp.index('<')]
                inp = inp[len(content):]
                print(content)


if __name__ == '__main__':
    p = Parser()
    p.parse("""
<html><head>
<title>Sample Application</title>
</head>
<body>
<div id="container">
<div>Hello</div>
</div>
<div id="content"><h1>Hello, World!</h1></div>
</body>
</html>""")
