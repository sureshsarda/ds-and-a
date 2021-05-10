package leetcode.h00;

import java.util.*;

public class N0071SimplifyPaths {

    public String simplifyPath(String path) {
        String[] tokens = path.split("/");

        List<String> directories = new ArrayList<>();

        for (String t : tokens) {
            if (t == null || t.length() == 0) {
                continue;
            }

            if (".".equals(t)) {
                continue;
            }

            if ("..".equals(t)) {
                if (!directories.isEmpty()) {
                    directories.remove(directories.size() - 1);
                }
            }

            directories.add(t);


        }



        return "/" + String.join("/", directories);
    }
}
