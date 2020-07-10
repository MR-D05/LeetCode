package problems;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        StringBuilder finalPath = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";

        for (int i = path.length() - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                if (path.charAt(i) == '/' && path.charAt(i - 1) == '/') {
                    stack.push("//");
                    i -= 1;
                    continue;
                }
                if (path.charAt(i) == '.' && path.charAt(i - 1) == '.') {
                    stack.push("..");
                    i -= 1;
                    continue;
                }
            }
            stack.push(String.valueOf(path.charAt(i)));
        }

        while (stack.iterator().hasNext()) {
            String current = stack.pop();
            if (current.equals("/") || current.equals("//")) {
                if (finalPath.length() == 0) {
                    finalPath.append("/");
                    continue;
                }
                if (alphabet.contains(String.valueOf(finalPath.charAt(finalPath.length()-1)))) {
                    finalPath.append("/");
                    continue;
                }
            }
            if (alphabet.contains(current)) {
                finalPath.append(current);
                continue;
            }
            if (current.equals(".")) {
                if (!stack.empty()) {
                    if (stack.peek().equals(".") || stack.peek().equals("..") || alphabet.contains(stack.peek())) {
                        String next = stack.pop();
                        finalPath.append(current);
                        finalPath.append(next);
                        continue;
                    }
                }
            }
            if (current.equals("..")) {
                if (!stack.empty()) {
                    if (stack.peek().equals(".") || stack.peek().equals("..") || alphabet.contains(stack.peek())) {
                        String next = stack.pop();
                        finalPath.append(current);
                        finalPath.append(next);
                        continue;
                    }
                }
                if (finalPath.length() >= 3) {
                    finalPath.deleteCharAt(finalPath.length() - 1);
                    while (finalPath.charAt(finalPath.length() - 1) != '/') {
                        finalPath.deleteCharAt(finalPath.length() - 1);
                    }
                    if (finalPath.length() != 1) {
                        finalPath.deleteCharAt(finalPath.length() - 1);
                    }
                    continue;
                }
            }
            if (current.equals("..")) {
                finalPath = new StringBuilder("/");
            }
        }

        if (finalPath.length() > 1 && Character.toString(finalPath.charAt(finalPath.length() - 1)).equals("/")) {
            finalPath.deleteCharAt(finalPath.length() - 1);
        }

        return finalPath.toString();
    }

    public static void main(String[] args) {

        /*
        Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

        In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves
        the directory up a level.

        Note that the returned canonical path must always begin with a slash /, and there must be only a single slash /
        between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the
        canonical path must be the shortest string representing the absolute path.

        Example 1:

        Input: "/home/"
        Output: "/home"

        Explanation: Note that there is no trailing slash after the last directory name.

        Example 2:

        Input: "/../"
        Output: "/"

        Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level
        you can go.

        Example 3:

        Input: "/home//foo/"
        Output: "/home/foo"

        Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

        Example 4:

        Input: "/a/./b/../../c/"
        Output: "/c"

        Example 5:

        Input: "/a/../../b/../c//.//"
        Output: "/c"

        Example 6:

        Input: "/a//b////c/d//././/.."
        Output: "/a/b/c"
         */

        /*
        Plan:

        1. We need to filter on //, so // does nothing.
        2. When we encounter .. we have to go back one.
        3. Maybe we implement a Stack, and we say, if char is . and next is .., then push .. onto the stack move the loop
           ahead past i+1.
        4. Same for //.
        5. We do this starting from the back.
        "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"
         */

        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
    }
}

/*
Answer:

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        StringBuilder finalPath = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";

        for (int i = path.length() - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                if (path.charAt(i) == '/' && path.charAt(i - 1) == '/') {
                    stack.push("//");
                    i -= 1;
                    continue;
                }
                if (path.charAt(i) == '.' && path.charAt(i - 1) == '.') {
                    stack.push("..");
                    i -= 1;
                    continue;
                }
            }
            stack.push(String.valueOf(path.charAt(i)));
        }

        while (stack.iterator().hasNext()) {
            String current = stack.pop();
            if (current.equals("/") || current.equals("//")) {
                if (finalPath.length() == 0) {
                    finalPath.append("/");
                    continue;
                }
                if (alphabet.contains(String.valueOf(finalPath.charAt(finalPath.length()-1)))) {
                    finalPath.append("/");
                    continue;
                }
            }
            if (alphabet.contains(current)) {
                finalPath.append(current);
                continue;
            }
            if (current.equals(".")) {
                if (!stack.empty()) {
                    if (stack.peek().equals(".") || stack.peek().equals("..") || alphabet.contains(stack.peek())) {
                        String next = stack.pop();
                        finalPath.append(current);
                        finalPath.append(next);
                        continue;
                    }
                }
            }
            if (current.equals("..")) {
                if (!stack.empty()) {
                    if (stack.peek().equals(".") || stack.peek().equals("..") || alphabet.contains(stack.peek())) {
                        String next = stack.pop();
                        finalPath.append(current);
                        finalPath.append(next);
                        continue;
                    }
                }
                if (finalPath.length() >= 3) {
                    finalPath.deleteCharAt(finalPath.length() - 1);
                    while (finalPath.charAt(finalPath.length() - 1) != '/') {
                        finalPath.deleteCharAt(finalPath.length() - 1);
                    }
                    if (finalPath.length() != 1) {
                        finalPath.deleteCharAt(finalPath.length() - 1);
                    }
                    continue;
                }
            }
            if (current.equals("..")) {
                finalPath = new StringBuilder("/");
            }
        }

        if (finalPath.length() > 1 && Character.toString(finalPath.charAt(finalPath.length() - 1)).equals("/")) {
            finalPath.deleteCharAt(finalPath.length() - 1);
        }

        return finalPath.toString();
    }
 */
