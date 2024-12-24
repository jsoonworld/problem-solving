package org.platform.inflearn.javaintro.section6.cranegame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N x N 크기의 게임판 크기

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt(); // 게임판의 상태 입력받기
            }
        }

        int M = sc.nextInt(); // moves 배열의 크기
        // 문제점 1: List<Integer> 초기화 논리 오류
        List<Integer> moves = List.of(Integer.parseInt(Arrays.toString(sc.next().split(" "))));
        // 문제: Arrays.toString()은 문자열로 변환된 배열을 반환하므로, Integer.parseInt()로 변환 시 예외 발생
        // 해결: moves 배열을 정수 배열로 직접 입력받아 처리해야 함

        int count = 1; // 문제점 2: 잘못된 초기값
        // 문제: count는 제거된 인형의 개수를 세기 위한 변수이므로 0으로 초기화해야 적절함
        // 해결: int count = 0;으로 수정

        Stack<Integer> bucket = new Stack<>();
        for (int i = 0; i < moves.size(); i++) {
            for (int j = 0; j < N; j++) {
                int target = board[i][moves.get(i)]; // 문제점 3: 잘못된 배열 접근
                // 문제: moves.get(i)는 1-based 인덱스이므로 0-based로 변환 필요
                // 문제: board[i][...]에서 `i`는 행(row)을 가리켜야 하지만 열(column)로 잘못 사용됨
                // 해결: board[j][moves.get(i) - 1]로 수정
                if (target == 0) {
                    continue; // 빈칸인 경우 다음 행으로 이동
                }
                bucket.push(target); // 인형을 바구니(bucket)에 추가
                board[i][moves.get(i)] = 0; // 문제점 4: 잘못된 board 갱신
                // 문제: board[i][...]에서 `i`는 행(row)을 가리켜야 하지만 열(column)로 잘못 사용됨
                // 해결: board[j][moves.get(i) - 1]로 수정
            }
        }

        for (int i = 0; i < bucket.size(); i++) {
            int top = bucket.pop(); // 문제점 5: 잘못된 스택 순회 방식
            // 문제: 스택을 순회하며 동시에 pop()을 호출하면 스택 크기가 줄어들어 논리적 오류 발생
            // 해결: for 대신 while (!bucket.isEmpty()) 사용
            if (top == bucket.peek()) { // 문제점 6: 빈 스택 접근 가능성
                // 문제: bucket이 비어 있을 경우 peek() 호출 시 예외 발생
                // 해결: if (!bucket.isEmpty() && top == bucket.peek())로 조건 추가
                count++;
                top = bucket.pop(); // 문제점 7: 불필요한 중복 처리
                // 문제: 이미 pop한 요소를 다시 pop할 필요 없음
            }
        }

        // 문제점 8: 출력이 없음
        // 문제: 결과 값인 count를 출력하는 로직이 없음
        // 해결: System.out.println(count); 추가
    }
}
