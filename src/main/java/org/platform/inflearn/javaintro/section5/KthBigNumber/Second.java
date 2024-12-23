package org.platform.inflearn.javaintro.section5.KthBigNumber;

import java.util.*;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers.add(sc.nextInt());
        }

        // 3장의 조합 합 계산
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
                    sums.add(sum);
                }
            }
        }

        // 내림차순 정렬
        List<Integer> result = new ArrayList<>(sums);
        result.sort(Collections.reverseOrder());

        // K번째 값 출력
        if (K <= result.size()) {
            System.out.println(result.get(K - 1));
        } else {
            System.out.println(-1);
        }
    }
}
