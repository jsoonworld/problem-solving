package org.platform.inflearn.javaintro.section5.KthBigNumber;

import java.util.*;
import java.util.stream.Collectors;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();

        // 입력값 처리
        for (int i = 0; i < N; i++) {
            numbers.add(sc.nextInt());
        }

        // 3장의 조합 합 계산 및 내림차순 정렬
        List<Integer> sortedSums = numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> numbers.indexOf(j) > numbers.indexOf(i))
                        .flatMap(j -> numbers.stream()
                                .filter(k -> numbers.indexOf(k) > numbers.indexOf(j))
                                .map(k -> i + j + k)))
                .distinct() // 중복 제거
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .collect(Collectors.toList());

        // K번째 값 출력
        System.out.println(K <= sortedSums.size() ? sortedSums.get(K - 1) : -1);
    }
}
