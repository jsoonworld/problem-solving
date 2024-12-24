package org.platform.inflearn.javaintro.section6.balancedparentheses;

import java.util.Scanner;
import java.util.Stack;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(isBalanced(input) ? "YES" : "NO");
    }

    private static boolean isBalanced(String input) {
        char leftDelimiter = '(';
        char rightDelimiter = ')';
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);

            if (target == leftDelimiter) {
                stack.push(target);
            } else if (target == rightDelimiter) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
