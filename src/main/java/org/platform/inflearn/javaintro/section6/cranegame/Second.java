package org.platform.inflearn.javaintro.section6.cranegame;

import java.util.Scanner;
import java.util.Stack;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int M = sc.nextInt();

        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(playCraneGame(board, moves));
    }

    private static int playCraneGame(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int count = 0;

        for (int move : moves) {
            int column = move - 1;

            for (int row = 0; row < board.length; row++) {
                if (board[row][column] != 0) {
                    int doll = board[row][column];
                    board[row][column] = 0;

                    if (!bucket.isEmpty() && bucket.peek() == doll) {
                        bucket.pop();
                        count += 2;
                    } else {
                        bucket.push(doll);
                    }
                    break;
                }
            }
        }
        return count;
    }
}
