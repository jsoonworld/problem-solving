package org.platform.inflearn.javaintro.section6.removeparentheses;

import java.util.Scanner;
import java.util.Stack;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next(); // 입력 문자열 받기
        char leftDelimiter = '(';
        char rightDelimiter = ')';
        Stack<Character> stack = new Stack<>(); // 괄호와 문자를 관리하기 위한 스택 생성

        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);

            // 1. 여는 괄호 '('를 만나면 스택에 추가
            if (target == leftDelimiter) {
                stack.push(target);
            }

            // 2. 괄호가 아닌 경우 스택에 추가
            if (target != leftDelimiter && target != rightDelimiter) {
                stack.push(target); // 문제점: 이미 스택에 추가되었는지 확인하지 않음.
                // 예: 'A(BC)'에서 'A'는 이미 스택에 있을 수 있지만, 잘못 추가될 수 있음.
            }

            // 3. 닫는 괄호 ')'를 처리
            if (target == rightDelimiter) {
                boolean flag = true; // 문제점: 플래그 사용이 불필요하고 복잡성을 증가시킴.
                while (flag) {
                    if (stack.pop() == leftDelimiter) { // 문제점: 스택에서 두 번 pop이 잘못 호출됨.
                        stack.pop(); // 여는 괄호를 다시 pop하는 잘못된 동작.
                        flag = false; // 수정: 닫는 괄호를 만난 경우 여는 괄호까지의 문자를 한 번에 제거.
                    }
                    stack.pop(); // 이 위치에서 불필요한 추가 pop 호출.
                }
            }
        }

        // 4. 스택의 내용을 읽어 결과 문자열 생성
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) { // 문제점: stack.size()와 pop()을 함께 사용하면 논리적 오류 발생.
            // 스택은 LIFO(Last In, First Out)이므로, pop()을 호출하면 스택 크기가 줄어듭니다.
            sb.append(stack.pop());
        }
        System.out.println(sb.toString()); // 결과 문자열 출력 (거꾸로 출력됨)
        // ✅ 수정: 스택에 남은 문자들을 순서대로 처리하려면 `for` 대신 `while (!stack.isEmpty())`를 사용.
    }
}
