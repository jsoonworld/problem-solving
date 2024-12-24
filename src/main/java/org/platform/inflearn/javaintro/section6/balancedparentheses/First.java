package org.platform.inflearn.javaintro.section6.balancedparentheses;

import java.util.Scanner;
import java.util.Stack;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String result = "YES";

        char leftDelimiter = '(';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);

            if (target == leftDelimiter) {
                stack.push(target);
            }

            if (target != leftDelimiter) {
                /**
                 * 스택이 비었는데 ')'가 나오면 올바르지 않음.
                 */
                if (stack.isEmpty()) {
                    result = "NO";
                }

                stack.pop();
            }


        }

        if (!stack.isEmpty()) {
            result = "NO";
        }
        System.out.println(result);
    }
}
