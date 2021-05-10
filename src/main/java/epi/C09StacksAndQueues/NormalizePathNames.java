package epi.C09StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class NormalizePathNames {
    // path names may contain '/', meaning the root
    // path names may contain . or ..

    public static String normalize(String path) {
        String[] tokens = path.split("/");

        List<String> stack = new ArrayList<>();

        for (String t : tokens) {
            if (".".equals(t)) {
                continue;
            } else if ("..".equals(t)) {
                if (stack.isEmpty()) {
                    if (path.startsWith("/")) {
                        throw new IllegalArgumentException("Invalid path");
                    } else {
                        stack.add(t);
                    }
                } else {
                    if ("..".equals(stack.get(stack.size() - 1))) {
                        stack.add(t);
                    } else {
                        stack.remove(stack.size() - 1);
                    }
                }
            } else {
                if (!"".equals(t)) {
                    stack.add(t);
                }
            }
        }

        return (path.startsWith("/") ? "/" : "")
                + String.join("/", stack)
                + (stack.size() > 0 ? "/" : ".");
    }

    public static void main(String[] args) {
        System.out.println(normalize("/foo/bar/../baz"));
        System.out.println(normalize("/foo/bar/../baz/."));
        System.out.println(normalize("/foo///../baz/."));
        System.out.println(normalize("foo///../baz/."));
        System.out.println(normalize("foo///../baz/../../"));
        System.out.println(normalize("../../../"));
        System.out.println(normalize("foo///../baz/../../../../../"));
        System.out.println(normalize("foo/bar/baz/../baz/../../"));
        System.out.println(normalize("foo/.."));
        System.out.println(normalize(""));
        System.out.println(normalize("/foo/.."));

        // invalid
        System.out.println(normalize("/foo/bar/../../../baz"));
    }

}
