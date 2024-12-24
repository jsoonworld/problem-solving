package org.platform.inflearn.javaintro.section6.removeparentheses;

import java.util.Scanner;
import java.util.Stack;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(removeParentheses(input));
    }

    private static String removeParentheses(String input) {
        Stack<Character> stack = new Stack<>();

        for (char target : input.toCharArray()) {
            if (target == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(target);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
